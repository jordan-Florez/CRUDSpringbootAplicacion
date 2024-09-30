package com.company.spring_boot_crud_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones CRUD sobre notas.
 * Las rutas de este controlador están prefijadas con "/api/notas".
 */
@RestController
@RequestMapping("/api/notas")
public class NotasController {

    private final NotaRepository notaRepository;

    /**
     * Constructor de NotasController.
     * @param notaRepository Repositorio para interactuar con la base de datos de notas.
     */
    public NotasController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    /**
     * Obtiene una lista de todas las notas.
     * Responde a las peticiones GET en "/api/notas".
     * @return Lista de todas las notas.
     */
    @GetMapping
    public List<Nota> obtenerTodasLasNotas() {
        System.out.println("Datos recibidos en el GET");
        return (List<Nota>) notaRepository.findAll();
    }

    /**
     * Crea una nueva nota y la guarda en la base de datos.
     * Responde a las peticiones POST en "/api/notas".
     * @param nota Nota enviada en el cuerpo de la petición.
     * @return La nota creada con el estado HTTP 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestParam String titulo, 
                                       @RequestParam String contenido, 
                                       @RequestParam Long carpeta_id) {
    Nota nuevaNota = new Nota(titulo, contenido);
    nuevaNota.setCarpeta_id(carpeta_id); // Asigna el carpeta_id
    Nota notaGuardada = notaRepository.save(nuevaNota);
    return new ResponseEntity<>(notaGuardada, HttpStatus.CREATED);
    }

    // public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
    //     System.out.println("Datos recibidos en el POST: " + nota);
    //     Nota nuevaNota = notaRepository.save(nota);
    //     System.out.println("Nota creada con éxito: " + nuevaNota);
    //     return new ResponseEntity<>(nuevaNota, HttpStatus.CREATED);
    // }
    
    /**
     * Actualiza una nota existente por su ID.
     * Responde a las peticiones PUT en "/api/notas/{id}".
     * @param id ID de la nota a actualizar.
     * @param nota Nota actualizada enviada en el cuerpo de la petición.
     * @return La nota actualizada o un 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarNota(@PathVariable Long id, @RequestBody Nota nota) {
        if (!notaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        nota.setId(id);
        Nota notaActualizada = notaRepository.save(nota);
        return ResponseEntity.ok(notaActualizada);
    }

    /**
     * Elimina una nota existente por su ID.
     * Responde a las peticiones DELETE en "/api/notas/{id}".
     * @param id ID de la nota a eliminar.
     * @return 204 (NO CONTENT) si se elimina con éxito, o 404 si no se encuentra.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        if (!notaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        notaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
