package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

    @Test
    public void testConsultarSaldo() {
        ContaRepository contaRepository = mock(ContaRepository.class);
        
        Conta contaSimulada = new Conta("12345", 1000.0);
        
        when(contaRepository.buscarConta("12345")).thenReturn(contaSimulada);
        
        BancoService bancoService = new BancoService(contaRepository);
        
        double saldo = bancoService.consultarSaldo("12345");
        
        assertEquals(1000.0, saldo);
        
        verify(contaRepository).buscarConta("12345");
    }

    @Test
    public void testDepositar() {
        ContaRepository contaRepository = mock(ContaRepository.class);
        
        Conta contaSimulada = new Conta("12345", 1000.0);
        
        when(contaRepository.buscarConta("12345")).thenReturn(contaSimulada);
        
        BancoService bancoService = new BancoService(contaRepository);
        
        bancoService.depositar("12345", 500.0);
        
        assertEquals(1500.0, contaSimulada.getSaldo());
        
        verify(contaRepository).buscarConta("12345");
        verify(contaRepository).salvar(contaSimulada);
    }
}