package com.RegistroTropiInfo.Validaciones.Repositorio;

import com.RegistroTropiInfo.Validaciones.DatosUsuario.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends JpaRepository<Usuarios,Long> {

}
