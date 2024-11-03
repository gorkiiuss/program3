package com.github.gorkiiuss.program3.io.csv.pacientes;

import java.util.Arrays;

public class Medico {
    public void diagnosticarPaciente(Paciente paciente) {
        Sintoma[] sintomas = paciente.getSintomas();

        Diagnostico diagnostico = Diagnostico.NO_ENFERMO;
        if (Arrays.stream(sintomas)
                .filter(sintoma -> sintoma == Sintoma.MUCHA_SED ||
                        sintoma == Sintoma.VISION_BORROSA ||
                        sintoma == Sintoma.PERDIDA_DE_PESO)
                .count() == 3)
            diagnostico = Diagnostico.DIABETES;
        else if (Arrays.stream(sintomas)
                .filter(sintoma -> sintoma == Sintoma.PIEL_AMARILLA ||
                        sintoma == Sintoma.FIEBRE ||
                        sintoma == Sintoma.NAUSEAS)
                .count() == 3)
            diagnostico = Diagnostico.HEPATITIS;
        else if (Arrays.stream(sintomas)
                .filter(sintoma -> sintoma == Sintoma.TOS_MUCOSA ||
                        sintoma == Sintoma.FIEBRE ||
                        sintoma == Sintoma.DOLOR_EN_EL_PECHO)
                .count() == 3)
            diagnostico = Diagnostico.NEUMONIA;

        paciente.setDiagnostico(diagnostico);
    }
}
