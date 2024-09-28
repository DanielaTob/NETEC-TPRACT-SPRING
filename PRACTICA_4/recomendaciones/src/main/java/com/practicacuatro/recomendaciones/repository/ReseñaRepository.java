package com.practicacuatro.recomendaciones.repository;

import com.practicacuatro.recomendaciones.model.Reseña;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseñaRepository extends JpaRepository<Reseña, Long> {

    List<Reseña> findByUsuarioId(Long usuarioId);
    List<Reseña> findByProductoId(Long productoId);
}
