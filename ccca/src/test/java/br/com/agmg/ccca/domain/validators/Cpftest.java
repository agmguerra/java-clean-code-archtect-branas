package br.com.agmg.ccca.domain.validators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Cpftest {

    @DisplayName("Cpf não pode ser nulo")
    @Test
    public void testCpfNulo() {
        assertFalse(Cpf.isValido(null));
    }

    @DisplayName("Cpf não pode ter menos de 11 caracteres")
    @Test
    public void testCpfTamanhoMenorOnze() {
        assertFalse(Cpf.isValido(""));
    }

    @DisplayName("Cpf não pode ter mais de 14 caracteres")
    @Test
    public void testCpfTamanhoMaiorQuatorze() {
        assertFalse(Cpf.isValido("111.111.111-111"));
    }

    @DisplayName("Cpf não pode ter todos os digitos iguais")
    @Test
    public void testCpfComTodosDigitosIguais() {
        assertFalse(Cpf.isValido("111.111.111-11"));
    }

    @DisplayName("Cpf correto")
    @Test
    public void testCpfCorreto() {
        assertTrue(Cpf.isValido("226.434.070-32"));
    }

    @DisplayName("Cpf errado")
    @Test
    public void testCpfErrado() {
        assertFalse(Cpf.isValido("226.134.070-32"));
    }

}
