package atividade_teste;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionarioTest {
    private Funcionario f;

    @Before
    public void setUp() throws Exception {
        f = new Funcionario("Ze",432567,20);
    }

    @Test
    public void testSalarioLiquido1() {
        double sl = f.salarioLiquido(1000);
        assertTrue(900 == sl);
    }

    @Test
    public void testSalarioLiquido2() {
        double sl = f.salarioLiquido(2000);
        assertTrue(1500 == sl);
    }
    @Test
    public void testSalarioLiquido3() {
        double sl = f.salarioLiquido(3000);
        assertEquals(2250.0, sl, 0.1);
    }
    @Test
    public void testSalarioLiquido4() {
        double sl = f.salarioLiquido(5000);
        assertEquals(3125.0, sl, 0.1);
    }
    @Test
    public void testSalarioLiquido5() {
        double sl = f.salarioLiquido(6000);
        assertEquals(3750.0, sl, 0.1);
    }

    @Test
    public void testSalarioLiquido6() {
        double sl = f.salarioLiquido(-6000);
        assertEquals(3750.0, sl, 0.1);
    }

    @Test
    public void testSalarioBruto() {
        double sb = f.salarioBruto(100);
        assertTrue(2000.0 == sb);
    }
    @Test
    public void testSalarioBruto2() {
        double sb = f.salarioBruto(50);
        assertFalse(3750.0 == sb);
    }

    @Test
    public void testSalarioBruto3() {
        double sb = f.salarioBruto(-50);
        assertFalse(3750.0 == sb);
    }

    @Test
    public void testSalarioBruto4() {
        double sb = f.salarioBruto(50);
        assertEquals(1000.0, sb, 0.0);
    }
/*
    @AfterEach
    void tearDown() {
    }*/
}