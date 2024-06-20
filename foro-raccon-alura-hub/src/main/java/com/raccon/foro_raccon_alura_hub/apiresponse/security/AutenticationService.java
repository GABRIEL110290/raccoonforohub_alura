package com.raccon.foro_raccon_alura_hub.apiresponse.security;

import com.raccon.foro_raccon_alura_hub.repository.UsuarioUnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UsuarioUnoRepository usuarioUnoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioUnoRepository.findByLogin(username);
    }
}