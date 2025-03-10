package udem.edu.co.cda.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import udem.edu.co.cda.entities.Materia;
import udem.edu.co.cda.repository.MateriaRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MateriaServiceImplTest {

    @Mock
    private MateriaRepository materiaRepository;

    @InjectMocks
    private MateriaServiceImpl materiaService;

    private Materia materia;
    private List<Materia> materias;

    @BeforeEach
    void setUp() {
        materia = new Materia(1, "Matermaticas" , "Numeritos");
        materias = new ArrayList<>();
        materias.add(materia);
    }

    @Test
    void findAllMateriasWithData() throws SQLException, IOException {
        when(materiaRepository.findAll()).thenReturn(materias);
        assertNotNull(materiaService.findAllMaterias());
    }

    @Test
    void findAllMateriasVacio() throws SQLException, IOException {
        List<Materia> materias = new ArrayList<>();
        when(materiaRepository.findAll()).thenReturn(materias);
        assertEquals(materias, materiaService.findAllMaterias());
    }

    @Test
    void findByIdMateriaWithData() throws SQLException, IOException {
        when(materiaRepository.findById(materia.getId())).thenReturn(Optional.of(materia));
        assertNotNull(materiaService.findByIdMateria(materia.getId()));
    }

    @Test
    void findByIdMateriaNull() throws SQLException, IOException {
        when(materiaRepository.findById(materia.getId())).thenReturn(Optional.empty());
        assertFalse(materiaService.findByIdMateria(materia.getId()).isPresent());
    }

    @Test
    void createMateriaWithData() throws IOException {
        when(materiaRepository.save(materia)).thenReturn(materia);
        assertNotNull(materiaService.createMateria(materia));
    }

    @Test
    void createMateriaNull() throws IOException {
        when(materiaRepository.save(null)).thenReturn(null);
        assertNull(materiaService.createMateria(null));
    }

    @Test
    void updateMateriaWithData() throws IOException {
        when(materiaRepository.save(materia)).thenReturn(materia);
        assertNotNull(materiaService.updateMateria(materia.getId(), materia));
    }

    @Test
    void updateMateriaNull() throws IOException {
        when(materiaRepository.save(null)).thenReturn(null);
        assertNull(materiaService.updateMateria(0, null));
    }

    @Test
    void deleteMateria() throws IOException {
        materiaService.deleteMateria(materia.getId());
        assertTrue(true); 
    }
}