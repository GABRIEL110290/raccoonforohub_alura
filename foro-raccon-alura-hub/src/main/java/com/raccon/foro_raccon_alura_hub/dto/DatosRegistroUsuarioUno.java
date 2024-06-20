package com.raccon.foro_raccon_alura_hub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroUsuarioUno(
        Long id, @NotNull
        String nombre,

        @Email
        @NotNull
        String email,

        @NotNull(message = "clave no debe ser nulo")
        String clave
) {
    public String getNombre() {
        return "nombre";
    }

    public String getEmail() {
        return "email";
    }

    public String getClave() {
        return null;
    }

    public String getLogin() {
        return this.getLogin();
    }
}
