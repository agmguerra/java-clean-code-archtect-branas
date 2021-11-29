package br.com.agmg.ccca.domain.validators;

public class Cpf {


    private static boolean isNull(String cpf) { return (cpf == null); } 

    private static boolean isTamanhoValido(String cpf) {
        return (cpf.length() >= 11 && cpf.length() <= 14);
    }

    private static String retirarFormatacao(String cpf) {
        return cpf.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll(" ", "");
    }

    private static boolean isTodosDigitosIguais(String cpf) {
       return cpf.chars().allMatch(digito -> digito == cpf.charAt(0));
    }

    private static int calcularDigitoVerificador(String cpfParte) {
        int acumulador = 0;
        String[] cpfParteArray = cpfParte.split("");
        int multiplicador = cpfParte.length() + 1;
        for (String digito : cpfParteArray) {
            acumulador += (Integer.valueOf(digito) * multiplicador);
            multiplicador--;
        }
        int resto = acumulador % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }

    public static boolean isValido(String cpf) {
        if (Cpf.isNull(cpf) || !Cpf.isTamanhoValido(cpf)) return false;
        String cpfSemFormato = Cpf.retirarFormatacao(cpf);        
        if (Cpf.isTodosDigitosIguais(cpfSemFormato)) return false;

        String noveDigitosDoCpf = cpfSemFormato.substring(0, 9);
        int primeroDV = calcularDigitoVerificador(noveDigitosDoCpf);
        int  segundoDV = calcularDigitoVerificador(noveDigitosDoCpf + primeroDV);
        String cpfCorreto = noveDigitosDoCpf + primeroDV + segundoDV;

        return (!Cpf.retirarFormatacao(cpf).equals(cpfCorreto)) ? false : true;
    }
    
}
