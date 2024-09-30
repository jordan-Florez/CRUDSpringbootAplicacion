package com.company.spring_boot_crud_app;

//import com.tuapp.notas.model.Carpeta;
import com.company.spring_boot_crud_app.Carpeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarpetaRepository extends JpaRepository<Carpeta, Long> {
}
