package com.company.spring_boot_crud_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones CRUD sobre productos.
 * Las rutas de este controlador están prefijadas con "/api/productos".
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final NotaRepository notaRepository;

    /**
     * Constructor de ProductoController.
     * @param productoRepository Repositorio para interactuar con la base de datos de productos.
     */
    public ProductoController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    /**
     * Obtiene una lista de todos los productos.
     * Responde a las peticiones GET en "/api/productos".
     * @return Lista de todos los productos.
     */
    @GetMapping
    public List<Nota> obtenerTodos() {
        return (List<Nota>) notaRepository.findAll();
    }

    /**
     * Crea un nuevo producto y lo guarda en la base de datos.
     * Responde a las peticiones POST en "/api/productos".
     * @param producto Producto enviado en el cuerpo de la petición.
     * @return El producto creado con el estado HTTP 201 (CREATED).
     */
    @PostMapping
    public ResponseEntity<Nota> crearNota(@RequestBody Nota nota) {
        Nota nuevaNota = notaRepository.save(nota);
        return new ResponseEntity<>(nuevaNota, HttpStatus.CREATED);
    }

    /**
     * Actualiza un producto existente por su ID.
     * Responde a las peticiones PUT en "/api/productos/{id}".
     * @param id ID del producto a actualizar.
     * @param producto Producto actualizado enviado en el cuerpo de la petición.
     * @return El producto actualizado o un 404 si no se encuentra.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Nota> actualizarProducto(@PathVariable Long id, @RequestBody Nota nota) {
        if (!notaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        nota.setId(id);
        Nota actualizada = notaRepository.save(nota);
        return ResponseEntity.ok(actualizada);
    }

    /**
     * Elimina un producto existente por su ID.
     * Responde a las peticiones DELETE en "/api/productos/{id}".
     * @param id ID del producto a eliminar.
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
