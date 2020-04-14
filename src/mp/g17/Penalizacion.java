package mp.g17;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Penalizacion {
    private Calendar fechaInicio;
    private Calendar fechaFinal;
    private final static  int DIAS_PENA=2;

    public Penalizacion(Calendar fechaInicio){
        this.fechaInicio=fechaInicio;
         GregorianCalendar calendarioAux= (GregorianCalendar) fechaInicio;
        calendarioAux.add(Calendar.DAY_OF_MONTH,2);
        this.fechaFinal=calendarioAux;



    }
}
