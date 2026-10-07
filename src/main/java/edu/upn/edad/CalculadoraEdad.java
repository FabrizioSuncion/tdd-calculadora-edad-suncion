package edu.upn.edad;

import java.time.LocalDate;

public class CalculadoraEdad {

    private static final String MENSAJE_FECHA_FUTURA =
            "La fecha de nacimiento no puede ser posterior a la fecha actual";

    public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
        validarFechaNacimiento(fechaNacimiento, fechaActual);

        int edad = fechaActual.getYear() - fechaNacimiento.getYear();

        if (!yaCumplioAnios(fechaNacimiento, fechaActual)) {
            edad--;
        }

        return edad;
    }

    private static void validarFechaNacimiento(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if (fechaNacimiento.isAfter(fechaActual)) {
            throw new IllegalArgumentException(MENSAJE_FECHA_FUTURA);
        }
    }

    private static boolean yaCumplioAnios(LocalDate fechaNacimiento, LocalDate fechaActual) {
        if (fechaActual.getMonthValue() != fechaNacimiento.getMonthValue()) {
            return fechaActual.getMonthValue() > fechaNacimiento.getMonthValue();
        }
        return fechaActual.getDayOfMonth() >= fechaNacimiento.getDayOfMonth();
    }
}