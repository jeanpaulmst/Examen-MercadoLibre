package com.example.parcial.entidades;

import com.example.parcial.DTOs.DTOPersona;
import com.example.parcial.controllers.PersonaController;
import com.example.parcial.services.PersonaServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControllerTest {

    @Autowired
    private PersonaController personaController;
    @MockBean
    private PersonaServiceImpl personaService;

    @Test
    public void testAnalyzePerson_Mutant() throws Exception {
        DTOPersona dtoPersona = new DTOPersona();
        dtoPersona.setDna(Arrays.asList("AAAA", "AAAA", "AAAA", "AAAA")); // ADN mutante

        when(personaService.isMutant(dtoPersona.getDna())).thenReturn(true); // Mock del servicio

        ResponseEntity<?> response = personaController.analizePerson(dtoPersona);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(((DTOPersona) response.getBody()).isMutant());
    }

    @Test
    public void testStatistics() throws Exception {
        // Preparar el mock del servicio
        HashMap<String, Serializable> mockStats = new HashMap<>();
        mockStats.put("cantMutantes", 4);
        mockStats.put("cantHumanos", 3);

        when(personaService.getStatistics()).thenReturn(mockStats); // Simular el método del servicio

        // Llamar al método del controlador
        ResponseEntity<?> response = personaController.statistics();

        // Verificar el código de estado
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar el cuerpo de la respuesta
        HashMap<String, Integer> responseBody = (HashMap<String, Integer>) response.getBody();
        assertNotNull(responseBody);
        assertEquals(4, responseBody.get("cantMutantes"));
        assertEquals(3, responseBody.get("cantHumanos"));
    }

    @Test
    public void testStatistics_Error() throws Exception {
        // Configurar el mock para lanzar una excepción
        when(personaService.getStatistics()).thenThrow(new RuntimeException("Error al obtener estadísticas"));

        // Llamar al método del controlador
        ResponseEntity<?> response = personaController.statistics();

        // Verificar el código de estado
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

        // Verificar el cuerpo de la respuesta
        String responseBody = (String) response.getBody();
        assertNotNull(responseBody);
        assertTrue(responseBody.contains("Error al obtener estadísticas"));
    }


}
