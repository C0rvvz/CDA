package udem.edu.co.cda.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="materia")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToMany(mappedBy = "materias")
    private List<Estudiante> estudiantes;

    public Materia() {
    }

    public Materia(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}