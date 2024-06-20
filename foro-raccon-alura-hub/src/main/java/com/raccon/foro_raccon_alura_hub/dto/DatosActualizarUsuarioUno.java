package com.raccon.foro_raccon_alura_hub.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosActualizarUsuarioUno (
        @NotNull
        Long id,

        @Size(min = 2, max = 70, message = "El nombre debe tener entre 1 y 100 caracteres")
        String nombre,

        @Size(min = 6, max = 50, message = "La clave debe tener entre 6 y 100 caracteres")
        String clave,
        String usuarioUnoClave) {
    public String getNombre() {
        return null;
    }

    public String getClave() {
        return null;
    }

    public Long getId() {
        return this.id();
    }
}
