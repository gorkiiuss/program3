package com.github.gorkiiuss.program3.io.csv.pacientes;

import java.util.Locale;

public enum Diagnostico {
    DIABETES, HEPATITIS, NEUMONIA, NO_ENFERMO;

    public static Diagnostico parseDiagnostico(String s) {
        if (s == null || s.isEmpty())
            return null;

        return valueOf(s.toUpperCase(Locale.ROOT));
    }
}
