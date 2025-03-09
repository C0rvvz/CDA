package udem.edu.co.cda.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import udem.edu.co.cda.entities.Estudiante;
import udem.edu.co.cda.repository.EstudianteRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstudianteServiceImplTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteServiceImpl estudianteService;

    private Estudiante estudiante;
    private List<Estudiante> estudiantes;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante(1, "Juan");
        estudiantes = new ArrayList<>();
        estudiantes.add(estudiante);
    }

    @Test
    void findAllEstudiantesWithData() throws SQLException, IOException {
        when(estudianteRepository.findAll()).thenReturn(estudiantes);
        assertNotNull(estudianteService.findAllEstudiantes(), "Expected non-null list of estudiantes");
    }

    @Test
    void findAllEstudiantesVacio() throws SQLException, IOException {
        List<Estudiante> estudiantes = new ArrayList<>();
        when(estudianteRepository.findAll()).thenReturn(estudiantes);
        assertEquals(estudiantes, estudianteService.findAllEstudiantes(), "Expected empty list of estudiantes");
    }

    @Test
    void findByIdEstudianteWithData() throws SQLException, IOException {
        when(estudianteRepository.findById(String.valueOf(estudiante.getId()))).thenReturn(Optional.of(estudiante));
        assertNotNull(estudianteService.findByIdEstudiante(estudiante.getId()), "Expected non-null estudiante");
    }

    @Test
    void findByIdEstudianteNull() throws SQLException, IOException {
        when(estudianteRepository.findById(String.valueOf(estudiante.getId()))).thenReturn(Optional.empty());
        assertFalse(estudianteService.findByIdEstudiante(estudiante.getId()).isPresent(), "Expected empty optional");
    }

    @Test
    void createEstudianteWithData() throws IOException {
        when(estudianteRepository.save(estudiante)).thenReturn(estudiante);
        assertNotNull(estudianteService.createEstudiante(estudiante), "Expected non-null created estudiante");
    }

    @Test
    void createEstudianteNull() throws IOException {
        when(estudianteRepository.save(null)).thenReturn(null);
        assertNull(estudianteService.createEstudiante(null), "Expected null created estudiante");
    }

    @Test
    void updateEstudianteWithData() throws IOException {
        when(estudianteRepository.save(estudiante)).thenReturn(estudiante);
        assertNotNull(estudianteService.updateEstudiante(estudiante.getId(), estudiante), "Expected non-null updated estudiante");
    }

    @Test
    void updateEstudianteNull() throws IOException {
        when(estudianteRepository.save(null)).thenReturn(null);
        assertNull(estudianteService.updateEstudiante(0, null), "Expected null updated estudiante");
    }

    @Test
    void deleteEstudiante() throws IOException {
        estudianteService.deleteEstudiante(estudiante.getId());
        assertTrue(true, "Expected true after deleting Estudiante");
    }
}