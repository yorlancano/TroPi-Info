package com.RegistroTropiInfo.Validaciones.Controlador;

import com.RegistroTropiInfo.Validaciones.DatosUsuario.Usuarios;
import com.RegistroTropiInfo.Validaciones.Exepciones.ResourceNotFoundException;
import com.RegistroTropiInfo.Validaciones.Repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("usuarios/registro")
public class Controlador {
    @Autowired
   private Repositorio repositorio;
   @GetMapping("/mostrar")
        public List<Usuarios>mostrarUsuarios(){
            return repositorio.findAll();
    }
    @CrossOrigin
    @PostMapping("/guardar")
    public Usuarios guardarUsuarios(@RequestBody Usuarios usuarios) {
       return  repositorio.save(usuarios);
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<Usuarios> modificarUsuarios(@RequestBody Usuarios usuarios, @PathVariable Long id){
        Usuarios modificarUsuario = repositorio.findById(id).
                orElseThrow(()->new ResourceNotFoundException("El usuario no fue encontrado"));

        modificarUsuario.setNombre(usuarios.getNombre());
        modificarUsuario.setApelllidos(usuarios.getApelllidos());
        modificarUsuario.setContraseña(usuarios.getContraseña());
        modificarUsuario.setCorreo(usuarios.getCorreo());
        modificarUsuario.setTelefono(usuarios.getTelefono());
        modificarUsuario.setGenero(usuarios.getGenero());
        modificarUsuario.setNacimiento(usuarios.getNacimiento());

        Usuarios usuarios1 = repositorio.save(modificarUsuario);

        return ResponseEntity.ok(usuarios1);
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarRegistro(@PathVariable Long id){
        Usuarios eliminarRegistro= repositorio.findById(id).
                orElseThrow(()->new ResourceNotFoundException("El usuario no fue encontrado"));

        repositorio.delete(eliminarRegistro);

        Map<String,Boolean> respuesta=new HashMap<>();
        respuesta.put("Dato eliminado",Boolean.TRUE);

        return ResponseEntity.ok(respuesta);
    }

}
