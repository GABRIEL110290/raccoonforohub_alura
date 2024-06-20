package com.raccon.foro_raccon_alura_hub.apiresponse.security;

import com.raccon.foro_raccon_alura_hub.dto.DatosAutenticacion;
import com.raccon.foro_raccon_alura_hub.usuarios.UsuarioUno;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/login")
public class AtenticationController {

    public record DatosTokenJWT(String token) {}

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity realizarLogin(@RequestBody @Valid DatosAutenticacion datos) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((UsuarioUno) authentication);

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }


}
