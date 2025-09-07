package com.faleite.imc.util;

public class ImcCalculator {

    public static double calcularAlturaCm(double alturaM){
        return alturaM * 100;
    }

    public static double calcularPesoIdeal(double alturaCm, double pesoKg){
        return (alturaCm - 100) - ((alturaCm - pesoKg) / 4) * (5.0 / 100);
    }

    public static double calcularIMC(double alturaM, double pesoKg){
        return pesoKg / Math.pow(alturaM, 2);
    }

    public static String interpretarIMC(double imc){
        if (imc < 20) return "Baixo Peso";
        if (imc < 25) return "Normal";
        if (imc <= 30) return "Acima do Peso";
        return "Obeso";
    }
}
