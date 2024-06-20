package com.raccon.foro_raccon_alura_hub.repository;

import com.raccon.foro_raccon_alura_hub.domain.comentario.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {

    Boolean existsByTituloAndContenido(String titulo, String contenido);

    @Query("SELECT t FROM Comentario t WHERE FUNCTION('YEAR', t.fecha) = :year")
    Page<Comentario> findByFechaYear(@Param("year") int year, Pageable pageable);
}
