package com.raccon.foro_raccon_alura_hub.domain.comentario;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;

import com.raccon.foro_raccon_alura_hub.usuarios.UsuarioUno;
import jakarta.validation.constraints.NotNull;

public class DatosRegistroComentario {

        @NotNull
        private String titulo;

        @NotNull
        private String contenido;

        @NotNull
        private LocalDate fecha; // Cambiado a LocalDate

        @NotNull
        private Estado estado;

        @NotNull
        private UsuarioUno usuarioUno;

        @NotNull
        private String nombreCurso;

        // Getters y setters

        public @NotNull String getTitulo() {
                return titulo;
        }

        public void setTitulo(@NotNull String titulo) {
                this.titulo = titulo;
        }

        public @NotNull String getContenido() {
                return contenido;
        }

        public void setContenido(@NotNull String contenido) {
                this.contenido = contenido;
        }

        public ChronoLocalDateTime<LocalDate> getFecha() {
                // Convertir LocalDate a LocalDateTime
                return fecha.atStartOfDay();
        }

        public void setFecha(@NotNull LocalDate fecha) {
                this.fecha = fecha;
        }

        public @NotNull Estado getEstado() {
                return estado;
        }

        public void setEstado(@NotNull Estado estado) {
                this.estado = estado;
        }

        public @NotNull UsuarioUno getUsuarioUno() {
                return usuarioUno;
        }

        public void setUsuarioUno(@NotNull UsuarioUno usuarioUno) {
                this.usuarioUno = usuarioUno;
        }

        public @NotNull String getNombreCurso() {
                return nombreCurso;
        }

        public void setNombreCurso(@NotNull String nombreCurso) {
                this.nombreCurso = nombreCurso;
        }

        public Long getUsuarioUnoId() {
                return this.usuarioUno.getId();
        }
}
