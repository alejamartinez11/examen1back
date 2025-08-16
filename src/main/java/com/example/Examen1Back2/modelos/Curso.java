package com.example.Examen1Back2.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre",length = 50,nullable = false,unique = false)
    private String nombre;

    //RELACIONANDOME CON USUARIO
    @OneToOne
    @JoinColumn(name = "fk_docente",referencedColumnName = "id_docente")
    @JsonManagedReference(value = "docente-curso")
    private Docente docente;



    public Curso() {
    }

    public Curso(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


}
