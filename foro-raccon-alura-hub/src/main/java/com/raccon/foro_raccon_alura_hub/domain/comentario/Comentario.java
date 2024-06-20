package com.raccon.foro_raccon_alura_hub.domain.comentario;

import com.raccon.foro_raccon_alura_hub.usuarios.UsuarioUno;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "contenido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioUno_id", nullable = false)
    private UsuarioUno usuarioUno;

    private String nombreCurso;

    public Comentario(DatosRegistroComentario datosRegistroComentario) {
        this.titulo = datosRegistroComentario.getTitulo();
        this.contenido = datosRegistroComentario.getContenido();
        // Convertir String a LocalDateTime
        // Convertir String a LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd "); // Define el formato adecuado
        this.fecha = LocalDateTime.parse((CharSequence) datosRegistroComentario.getFecha(), formatter); // Aquí se realiza la conversión
        this.estado = datosRegistroComentario.getEstado();
    }

    public void actualizarDatos(DatosRegistroComentario datosRegistroComentario) {
        if (datosRegistroComentario.getTitulo() != null && !datosRegistroComentario.getTitulo().isEmpty()) {
            this.titulo = datosRegistroComentario.getTitulo();
        }
        if (datosRegistroComentario.getContenido() != null && !datosRegistroComentario.getContenido().isEmpty()) {
            this.contenido = datosRegistroComentario.getContenido();
        }
        if (datosRegistroComentario.getNombreCurso() != null && !datosRegistroComentario.getNombreCurso().isEmpty()) {
            this.nombreCurso = datosRegistroComentario.getNombreCurso();
        }
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setUsuarioUno(UsuarioUno usuarioUno) {
        this.usuarioUno = usuarioUno;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setFecha(ChronoLocalDateTime<LocalDate> fecha) {

    }
}
