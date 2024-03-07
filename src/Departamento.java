import java.time.LocalDateTime;
import java.util.ArrayList;

public class Departamento {
    //Propiedades
    protected String nombre;
    protected String contraseña;
    protected ArrayList reservas=new ArrayList<>();

    //Constructor
    public Departamento (String nombre , String contraseña){
        this.nombre=nombre;
        this.contraseña=contraseña;
    }

    public void AñadirReserva (String nombre , LocalDateTime horainicio,LocalDateTime horafin){
        this.nombre=nombre;
        this.contraseña=contraseña;

    }

    /* añadir y quitar reserva al final se hace*/

    //Listar Reservas
    public void listarReservas(){
        if(reservas.isEmpty()){
            System.out.println("No existe ninguna reserva");
        }
        else {
            for (Object reserva:reservas){
                Reserva aux=(Reserva) reserva;
                System.out.println(aux);
            }
        }
    }

    //To string
    @Override
    public String toString() {
        String departamento="|Nombre: "+this.nombre+" |Contraseña: "+this.contraseña;
        return departamento;
    }
}
