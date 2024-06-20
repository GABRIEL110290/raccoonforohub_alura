package com.raccon.foro_raccon_alura_hub.usuarios;

import com.raccon.foro_raccon_alura_hub.dto.DatosActualizarUsuarioUno;
import com.raccon.foro_raccon_alura_hub.dto.DatosRegistroUsuarioUno;
import com.raccon.foro_raccon_alura_hub.domain.comentario.Comentario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioUno implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "usuario_activo", nullable = false)
    private boolean usuarioActivo;

    public static String getlogin() {
        return null;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return usuarioActivo;
    }

    @OneToMany(mappedBy = "usuarioUno", cascade = CascadeType.ALL)
    private List<Comentario> comentarios = new ArrayList<>();

    public UsuarioUno(DatosRegistroUsuarioUno datosRegistroUsuarioUno) {
        this.usuarioActivo = true;
        this.login = datosRegistroUsuarioUno.getLogin();
        this.nombre = datosRegistroUsuarioUno.getNombre();
        this.email = datosRegistroUsuarioUno.getEmail();
        this.contrasena = datosRegistroUsuarioUno.getClave();
    }

    public void actualizarDatos(DatosActualizarUsuarioUno datosActualizarUsuarioUno) {
        if (datosActualizarUsuarioUno.getNombre() != null) {
            this.nombre = datosActualizarUsuarioUno.getNombre();
        }
        if (datosActualizarUsuarioUno.getClave() != null) {
            this.contrasena = datosActualizarUsuarioUno.getClave();
        }
    }

    // Método para agregar un comentario y establecer la relación bidireccional
    public void agregarComentario(Comentario comentario) {
        comentarios.add(comentario);
        comentario.setUsuarioUno(this);
    }

    // Método para desactivar lógicamente un usuario
    public void desactivaUsuario() {
        this.usuarioActivo = false;
    }

    public void setLogin(String login) {

    }

    public void setNombre(String nombre) {
    }

    public void setEmail(String email) {
    }

    public void setContrasena(String clave) {
    }

    public void setUsuarioActivo(boolean b) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
