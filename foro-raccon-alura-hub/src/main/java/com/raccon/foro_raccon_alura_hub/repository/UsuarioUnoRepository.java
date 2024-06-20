package com.raccon.foro_raccon_alura_hub.repository;

import com.raccon.foro_raccon_alura_hub.usuarios.UsuarioUno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioUnoRepository extends JpaRepository<UsuarioUno,  Long> {
    Page<UsuarioUno> findByUsuarioActivoTrue(Pageable pageable);

    UserDetails findByLogin(String username);
}
