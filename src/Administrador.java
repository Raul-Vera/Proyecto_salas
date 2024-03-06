import java.util.ArrayList;
import java.util.ListIterator;

public class Administrador {
   protected ArrayList salas=new ArrayList<>();
    protected ArrayList departamentos=new ArrayList<>();
    protected String contraseña;

    //constructor
    Administrador(String contraseña){
        this.contraseña=contraseña;
    }


    public void añadirDepartamento(Departamento departamento){
        ListIterator l1= new ; //seguiermañana
    }

    //Listar departamentos
    public void listarDepartamentos(){
        if (departamentos.isEmpty()){
            System.out.println("No existe ningún Departamento");
        }
        else {
            for(Object departamento:departamentos){
                Departamento aux;
                aux=(Departamento)departamento;
                System.out.println(aux);
            }
        }
    }
    public void listarSalas(){
        if (salas.isEmpty()){
            System.out.println("No existe ningúna sala");
        }
        else {
            for(Object sala:salas){
                Sala aux;
                aux=(Sala) sala;
                System.out.println(aux);
            }
        }
    }
    public void listarTodasReservas(){

    }

}
