package com.raccon

        .foro_raccon_alura_hub.apiresponse.errores;

import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class ApiError {
    @ExceptionHandler(EntityActionVetoException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){

        var errores=e.getAllErrors();
        return ResponseEntity.badRequest().body(errores);
    }
}
