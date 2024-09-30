package com.company.spring_boot_crud_app;

import com.company.spring_boot_crud_app.Carpeta;
import com.company.spring_boot_crud_app.CarpetaRepository;
import com.company.spring_boot_crud_app.UsuarioRepository;
import com.company.spring_boot_crud_app.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carpetas")
public class CarpetaController {

    private final CarpetaRepository carpetaRepository;
    private final UsuarioRepository usuarioRepository;

    public CarpetaController(CarpetaRepository carpetaRepository, UsuarioRepository usuarioRepository) {
        this.carpetaRepository = carpetaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Carpeta> listarCarpetas() {
        return carpetaRepository.findAll();
    }

    @PostMapping
    public Carpeta crearCarpeta(@RequestBody Carpeta carpeta) {
        Usuario usuario = usuarioRepository.findById(carpeta.getUsuario().getId()).orElse(null);
        carpeta.setUsuario(usuario);
        return carpetaRepository.save(carpeta);
    }

    @GetMapping("/{id}")
    public Carpeta obtenerCarpeta(@PathVariable Long id) {
        return carpetaRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Carpeta actualizarCarpeta(@PathVariable Long id, @RequestBody Carpeta carpetaActualizada) {
        Usuario usuario = usuarioRepository.findById(carpetaActualizada.getUsuario().getId()).orElse(null);
        return carpetaRepository.findById(id).map(carpeta -> {
            carpeta.setNombre(carpetaActualizada.getNombre());
            carpeta.setUsuario(usuario);
            return carpetaRepository.save(carpeta);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarpeta(@PathVariable Long id) {
        carpetaRepository.deleteById(id);
    }
}
