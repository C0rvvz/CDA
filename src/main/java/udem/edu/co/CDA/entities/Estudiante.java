package udem.edu.co.cda.entities;

import jakarta.persistence.*;

@Entity
@Table(name="estudiante")
public class Estudiante {

    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    public Estudiante(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Estudiante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}