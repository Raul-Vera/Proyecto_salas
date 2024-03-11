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
        /* Llama al metodo comprobar reserva si este le devuelve una reserva entonces no se hace la reserva,
    y se devuelve nulo.Si comprobar reserva devuelve nulo , se añade la reserva y se devuelve true*/
        if (this.Comprobarreserva(clavesal,horainicio,duracion)!=null){
            return false;
        }
        else {
            LocalDateTime horafin=horainicio.plus(duracion);
            Reserva aux=new Reserva(horainicio,horafin,clavesal);
            reservas.add(aux);
            return true;
        }

    }



    //Listar Reservas
    public void listarReservas() {
        /*Si las reservas estan vacias lo dice, si no llama al toString de reservas */
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

    public Reserva Comprobarreserva(String clavesal, LocalDateTime horainicio, Duration duracion) {
        /*SE introducen los parametros, primero comprueba las restricciones en cuanto al horario y la duracion
        , despues comprueba si esa reserva se pisa con otra reserva o no si las comprobaciones salen bien devuelve null si falla en alguna de las dos comprobaciones devuelve la reserva con la c*/
        Reserva res =null;
        Iterator i1 = reservas.iterator();
        final Duration MAX = Duration.ofHours(5);
        LocalTime resinicio = LocalTime.of(horainicio.getHour(), horainicio.getMinute(), horainicio.getSecond());
        LocalTime resfinal = resinicio.plus(duracion);
        LocalDateTime horafin = horainicio.plus(duracion);
        LocalTime limiteinicio = LocalTime.of(9, 0, 0);
        LocalTime finlimite = LocalTime.of(14, 0, 0);
        if (duracion.equals(MAX) || duracion.compareTo(MAX) < 0) {
            if ((resinicio.isAfter(limiteinicio) || resinicio.equals(limiteinicio))) {
                if (resfinal.equals(finlimite) || resfinal.isBefore(finlimite)) {
                    while (i1.hasNext()) {
                        Reserva aux;
                        aux = (Reserva) i1.next();
                        if (aux.sala.equals(clavesal)) {
                            if (aux.horainicio.getYear() == horainicio.getYear() && aux.horainicio.getDayOfYear() == horainicio.getDayOfYear()) {
                                if (aux.horainicio.isAfter(horafin) || horainicio.isAfter(aux.horafin)) {

                                }
                                else{
                                    res = aux;
                                }
                            }
                        }
                    }
                }
                else {
                    res=new Reserva();
                }
            }else {
                res=new Reserva();
            }

        }else {
            res=new Reserva();
        }
        return res;
    }


    public  boolean eliminarReserva (String clavesal, LocalDateTime horainicio, Duration duracion){
        /*Si Comprobar devuelve reserva se elimina ,si no no se elimina*/
        if (this.Comprobarreserva(clavesal,horainicio,duracion)!=null){
            reservas.remove(this.Comprobarreserva(clavesal,horainicio,duracion));
            return true;
        }
        else {
            return false;
        }
    }

}

