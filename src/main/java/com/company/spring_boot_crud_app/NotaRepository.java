package com.company.spring_boot_crud_app;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
// Anotación que indica que esta interfaz es un repositorio
@Repository
public interface NotaRepository extends CrudRepository<Nota, Long> {
    // Encuentra productos por su nombre
    List<Nota> findByTitulo(String titulo);

    // Encuentra productos cuyo precio sea mayor que un valor dado
    List<Nota> findByContenido(String contenido);
    
}
