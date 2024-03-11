import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Departamento {
    //Propiedades
    protected String nombre;
    protected String contraseña;
    protected ArrayList reservas = new ArrayList<>();

    //Constructor
    public Departamento(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public boolean AñadirReserva(String clavesal, LocalDateTime horainicio, Duration duracion) {
        if (this.Comprobarreserva(clavesal,horainicio,duracion)){
            return false;
        }
        else {
            LocalDateTime horafin=horainicio.plus(duracion);
            Reserva aux=new Reserva(horainicio,horafin,clavesal);
            reservas.add(aux);
            return true;
        }

    }

    /* añadir y quitar reserva al final se hace*/

    //Listar Reservas
    public void listarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("No existe ninguna reserva");
        } else {
            for (Object reserva : reservas) {
                Reserva aux = (Reserva) reserva;
                System.out.println(aux);
            }
        }
    }

    //To string
    @Override
    public String toString() {
        String departamento = "|Nombre: " + this.nombre + " |Contraseña: " + this.contraseña;
        return departamento;
    }

    public boolean Comprobarreserva(String clavesal, LocalDateTime horainicio, Duration duracion) {
        Boolean coincide=false;
        Iterator i1=reservas.iterator();
        final Duration MAX = Duration.ofHours(5);
        LocalTime resinicio = LocalTime.of(horainicio.getHour(), horainicio.getMinute(), horainicio.getSecond());
        LocalTime resfinal = resinicio.plus(duracion);
        LocalDateTime horafin=horainicio.plus(duracion);
        LocalTime limiteinicio = LocalTime.of(9, 0, 0);
        LocalTime finlimite = LocalTime.of(14, 0, 0);
        Duration durres = Duration.between(resinicio, resfinal);
        if (duracion.compareTo(MAX) == 0 || duracion.compareTo(MAX) == -1) {
            if ((resinicio.compareTo(limiteinicio) == 0 || resinicio.isAfter(limiteinicio)) && (resfinal.compareTo(finlimite) == 0 || resfinal.isBefore(finlimite))) {
                while (i1.hasNext() && !coincide){
                    Reserva aux;
                    aux=(Reserva) i1.next();
                    if(aux.sala.equals(clavesal)){
                        if(aux.horainicio.getYear()==horainicio.getYear() &&aux.horainicio.getDayOfYear()==horainicio.getDayOfYear()){
                            if (aux.horainicio.isAfter(horafin) && horainicio.isAfter(aux.horafin)){

                            }
                            else {
                                coincide=true;
                            }
                        }
                    }
                }

            }
        }
        return coincide;
    }
}

// if (aux.horainicio.isBefore(r)){