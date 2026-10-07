package edu.upn.edad;

import java.time.LocalDate;

public class CalculadoraEdad {

    private static final String MENSAJE_FECHA_FUTURA =
            "La fecha de nacimiento no puede ser posterior a la fecha actual";

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        validarFechaNacimiento(fechaNacimiento, fechaActual);

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

    private static void validarFechaNacimiento(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException(MENSAJE_FECHA_FUTURA);
        }
    }
}