package com.raccon.foro_raccon_alura_hub.dto;

import com.raccon.foro_raccon_alura_hub.usuarios.UsuarioUno;

public record DatosListadoUsuarioUno(

        String nombre,
        String email,
        String clave
) {

    // Constructor corregido
    public DatosListadoUsuarioUno(UsuarioUno usuarioUno) {
        this(usuarioUno.getUsername(), usuarioUno.getEmail(), usuarioUno.getContrasena());
    }

    // Métodos override corregidos
    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String clave() {
        return clave;
    }
}
