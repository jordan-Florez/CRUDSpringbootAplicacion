package com.company.spring_boot_crud_app;

//import com.tuapp.notas.model.Usuario;
import com.company.spring_boot_crud_app.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);
}