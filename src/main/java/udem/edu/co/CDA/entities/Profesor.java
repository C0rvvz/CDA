package udem.edu.co.cda.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name="profesor")
public class Profesor {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    public Profesor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Profesor() {
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

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}