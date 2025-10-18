package mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CalculadoraTest {
    
    @Mock
    private ServicoMatematico servicoMatematico;
    
    private Calculadora calculadora;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        calculadora = new Calculadora(servicoMatematico);
    }
    
    @Test
    public void testSomar() {
        when(servicoMatematico.somar(2, 3)).thenReturn(5);
        
        int resultado = calculadora.somar(2, 3);
        
        assertEquals(5, resultado);
        
        verify(servicoMatematico).somar(2, 3);
    }
}