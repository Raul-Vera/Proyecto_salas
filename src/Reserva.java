import java.time.Duration;
import java.time.LocalDateTime;


public class Reserva {
    //propiedades
    protected LocalDateTime horainicio;
    protected LocalDateTime horafin;
    protected  Duration duracion;
    protected Sala sala;

    //metodos

    //constructor
   protected Reserva(LocalDateTime horainicio,LocalDateTime horafin, Sala sala){
       this.horainicio=horainicio;
       this.horafin=horafin;
       this.sala=sala;
       duracion=Duration.between(horainicio,horafin);
   }

   //to string
    @Override
    public String toString() {
       String reserva="Hora de inicio: "+this.horainicio+" Hora de fin: "+this.horafin+"/n"+"Duracion: "+duracion+" Sala: "+this.sala.nombre;
        return reserva;
    }
}