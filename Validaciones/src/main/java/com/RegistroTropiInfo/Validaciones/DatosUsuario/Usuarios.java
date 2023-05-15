package com.RegistroTropiInfo.Validaciones.DatosUsuario;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "Nombre",length = 60,unique = false,nullable = false)
    private String nombre;
    @Column(name = "Apellidos",length = 60,unique = false,nullable = false)
    private String apelllidos;
    @Column(name = "Correo Electronico",length = 125,unique = true,nullable = false)
    private String correo;
    @Column(name = "Contraseña",length = 60,nullable = false)
    private String contraseña;
    @Column(name = "Fecha de Nacimiento", length = 60,nullable = false)
    private String nacimiento;
    @Column(name = "Genero",length = 60,nullable = false)
    private String genero;
    @Column(name = "Numero de Celular", length = 60,unique = true,nullable = false)
    private String telefono;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelllidos() {
        return apelllidos;
    }

    public void setApelllidos(String apelllidos) {
        this.apelllidos = apelllidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
