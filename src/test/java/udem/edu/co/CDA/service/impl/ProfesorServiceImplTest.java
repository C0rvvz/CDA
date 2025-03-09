package udem.edu.co.cda.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import udem.edu.co.cda.entities.Profesor;
import udem.edu.co.cda.repository.ProfesorRepository;
import udem.edu.co.cda.service.ProfesorService;
import udem.edu.co.cda.service.impl.ProfesorServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfesorServiceImplTest {

    @Mock
    private ProfesorRepository profesorRepository;

    @InjectMocks
    private ProfesorServiceImpl profesorService;

    private Profesor profesor;
    private List<Profesor> profesores;

    @BeforeEach
    void setUp() {
        profesor = new Profesor("Juan");
        profesores = new ArrayList<>();
        profesores.add(profesor);
    }

    @Test
    void findAllProfesoresWithData() throws SQLException, IOException {
        when(profesorRepository.findAll()).thenReturn(profesores);
        assertNotNull(profesorService.findAllProfesores());
    }

    @Test
    void findAllProfesoresVacio() throws SQLException, IOException {
        List<Profesor> profesores = new ArrayList<>();
        when(profesorRepository.findAll()).thenReturn(profesores);
        assertEquals(profesores, profesorService.findAllProfesores());
    }

    @Test
    void findByIdProfesorWithData() throws SQLException, IOException {
        when(profesorRepository.findById(profesor.getId())).thenReturn(Optional.of(profesor));
        assertNotNull(profesorService.findByIdProfesor(profesor.getId()));
    }

    @Test
    void findByIdProfesorNull() throws SQLException, IOException {
        when(profesorRepository.findById(profesor.getId())).thenReturn(Optional.empty());
        assertFalse(profesorService.findByIdProfesor(profesor.getId()).isPresent());
    }

    @Test
    void createProfesorWithData() throws IOException {
        when(profesorRepository.save(profesor)).thenReturn(profesor);
        assertNotNull(profesorService.createProfesor(profesor));
    }

    @Test
    void createProfesorNull() throws IOException {
        when(profesorRepository.save(null)).thenReturn(null);
        assertNull(profesorService.createProfesor(null));
    }

    @Test
    void updateProfesorWithData() throws IOException {
        when(profesorRepository.save(profesor)).thenReturn(profesor);
        assertNotNull(profesorService.updateProfesor(profesor.getId(), profesor));
    }

    @Test
    void updateProfesorNull() throws IOException {
        when(profesorRepository.save(null)).thenReturn(null);
        assertNull(profesorService.updateProfesor(0, null));
    }

    @Test
    void deleteProfesor() throws IOException {
        profesorService.deleteProfesor(profesor.getId());
        assertTrue(true); // No exception means success
    }
}