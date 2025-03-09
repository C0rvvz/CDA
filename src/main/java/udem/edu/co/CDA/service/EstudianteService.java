package udem.edu.co.cda.service;

import org.springframework.stereotype.Service;
import udem.edu.co.cda.entities.Estudiante;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public interface EstudianteService {
    public List<Estudiante> findAllEstudiantes() throws IOException, SQLException;
    public Optional<Estudiante> findByIdEstudiante(int id) throws IOException, SQLException;
    public Estudiante createEstudiante(Estudiante estudiante) throws IOException;
    public Estudiante updateEstudiante(int id, Estudiante estudiante) throws IOException;
    public void deleteEstudiante(int id) throws IOException;
}


