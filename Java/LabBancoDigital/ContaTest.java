package Estudos.Java.LabBancoDigital;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@TestMethodOrder - DisplayName, order

public class ContaTest {

    //@before
    //@after
    //@beforeAll
    //@afterAll
    //@beforeEach
    //@afterEach
    //@EnabledIf
    //@EnabledIfEnvironmentVariable
    //@rule

    @Test
    void testNumeroDaConta() {
        Cliente cliente1 = new Cliente();
        Conta conta1 = new ContaCorrente(cliente1);
        Assertions.assertNotNull(conta1.numero);

        Cliente cliente2 = new Cliente();
        Conta conta2 = new ContaCorrente(cliente2);
        Assertions.assertNotNull(conta2.numero);
    }
}
