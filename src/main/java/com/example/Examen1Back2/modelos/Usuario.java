package com.example.Examen1Back2.modelos;
import ayudas.Tipousuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "nombre",length = 50,nullable = false,unique = false)
    private String nombre;

    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;
    private String contraseña;
    private String telefono;

    @Column(name = "tipo",nullable = false,unique = false)
    @Enumerated(EnumType.STRING)
    private Tipousuario tipo;

    //Estableciendo la relacion uno a uno con la tabla docente
    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value = "docente-usuario")
    private Docente docente;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String correoElectronico, String contraseña, String telefono, Tipousuario tipo ) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.telefono = telefono;
        this.tipo = tipo;
    }


}