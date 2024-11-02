package com.example.parcial.entidades;
import com.example.parcial.repositories.PersonaRepository;
import com.example.parcial.services.PersonaServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MutantTest {

    @Autowired
    private PersonaServiceImpl personaService;

    //dna para realizar tests unitarios
    List<String> dna_1 = Arrays.asList("AAAA","CCCC","TCAG","GGTC");    //true
    List<String> dna_2 = Arrays.asList("AAAT","AACC","AAAC","CGGG");    //false
    List<String> dna_3 = Arrays.asList("TGAC","AGCC","TGAC","GGTC");    //true
    List<String> dna_4 = Arrays.asList("AAAA","AAAA","AAAA","AAAA");    //false
    List<String> dna_5 = Arrays.asList("TGAC","ATCC","TAAG","GGTC");    //false
    List<String> dna_6 = Arrays.asList(
            "TCGGGTGAT",
            "TGATCCTTT",
            "TACGAGTGA",
            "AAATGTACG",
            "ACGAGTGCT",
            "AGACACATG",
            "GAATTCCAA",
            "ACTACGACC",
            "TGAGTATCC"
    );      //true
    List<String> dna_7 = Arrays.asList(
            "TTTTTTTTT",
            "TTTTTTTTT",
            "TTTTTTTTT",
            "TTTTTTTTT",
            "CCGACCGAT",
            "GGCACTCCA",
            "AGGACACTA",
            "CAAAGGCAT",
            "GCAGTCCCC"
    );      //true
    private static Instant startTime;

    @BeforeAll
    public static void init() {
        startTime = Instant.now();
    }

    @Test
    @Order(1)
    public void test1() {
        System.out.println("dna_1");
        assertTrue(personaService.isMutant(dna_1));
    }
    @Test
    @Order(2)
    public void test2() {
        System.out.println("dna_2");
        assertFalse(personaService.isMutant(dna_2));
    }
    @Test
    @Order(3)
    public void test3() {
        System.out.println("dna_3");
        assertTrue(personaService.isMutant(dna_3));
    }
    @Test
    @Order(4)
    public void test4() {
        System.out.println("dna_4");
        assertFalse(personaService.isMutant(dna_4));
    }
    @Test
    @Order(5)
    public void test5() {
        System.out.println("dna_5");
        assertFalse(personaService.isMutant(dna_5));
    }
    @Test
    @Order(6)
    public void test6() {
        System.out.println("dna_6");
        assertTrue(personaService.isMutant(dna_6));
    }
    @Test
    @Order(7)
    public void test7() {
        System.out.println("dna_7");
        assertTrue(personaService.isMutant(dna_7));
    }
    @Test
    @Order(8)
    public void testStats() {
        System.out.println("TEST_STATISTICS");

        HashMap<String, Serializable> stats = personaService.getStatistics();

        assertEquals(4, stats.get("cantMutantes"), "Deberían haber 4 mutantes");
        assertEquals(3, stats.get("cantHumanos"), "Deberían haber 3 humanos");
    }

    @AfterEach
    public void printLine(){
        System.out.println("-------------------");
    }

    @AfterAll
    public static void printTime() {
        Instant endTime = Instant.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Tiempo total de ejecución: " + duration.toMillis() + " ms");
    }

}
