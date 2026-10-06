package edu.upn.edad;

import java.time.LocalDate;

public class CalculadoraEdad {

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();

        boolean aunNoCumple =
                fechaActual.getMonthValue() < fechaNacimiento.getMonthValue()
                || (fechaActual.getMonthValue() == fechaNacimiento.getMonthValue()
                    && fechaActual.getDayOfMonth() < fechaNacimiento.getDayOfMonth());

        if (aunNoCumple) {
            edad--;
        }

        return edad;
    }
}