package com.github.gorkiiuss.program3.io.csv.pacientes;

import java.util.Locale;

public enum Sintoma {
    MUCHA_SED, VISION_BORROSA, PERDIDA_DE_PESO,
    PIEL_AMARILLA, FIEBRE, NAUSEAS,
    TOS_MUCOSA, DOLOR_EN_EL_PECHO;

    public static Sintoma parseSintoma(String s) {
        System.out.println(s);
        return valueOf(s.toUpperCase(Locale.ROOT));
    }
}
