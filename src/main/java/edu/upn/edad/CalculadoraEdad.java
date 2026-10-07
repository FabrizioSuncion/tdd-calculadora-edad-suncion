package edu.upn.edad;

import java.time.LocalDate;

public class CalculadoraEdad {

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException(
                    "La fecha de nacimiento no puede ser posterior a la fecha actual");
        }

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