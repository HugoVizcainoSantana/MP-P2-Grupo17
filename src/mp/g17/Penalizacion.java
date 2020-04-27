package mp.g17;


import mp.g17.users.Administrador;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Penalizacion {
    public final static int DIAS_PENA = 2;
    private Calendar fechaInicio;
    private Calendar fechaFinal;
    private Administrador penalizedBy;
    private String reason;

    public Penalizacion(Calendar fechaInicio, Administrador penalizedBy, String reason) { //Constructor of a new penalty
        this.fechaInicio = fechaInicio;
        GregorianCalendar calendarioAux = (GregorianCalendar) fechaInicio;
        calendarioAux.add(Calendar.DAY_OF_MONTH, 2);
        this.fechaFinal = calendarioAux;
        this.penalizedBy = penalizedBy;
        this.reason = reason;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    public Administrador getPenalizedBy() {
        return penalizedBy;
    }

    public String getReason() {
        return reason;
    }
}
