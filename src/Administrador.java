import java.util.ArrayList;
import java.util.Iterator;

public class Administrador {
   protected ArrayList salas=new ArrayList<>();
    protected ArrayList departamentos=new ArrayList<>();
    protected String contraseña;

    //constructor
    Administrador(String contraseña){
        this.contraseña=contraseña;
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

    //Añadir departamento
    public boolean añadirDepartamento(String contraseña,String nombre){
        if (this.encontrarContraseñaDep(contraseña)){
            return false;
        }
        else {
            Departamento aux=new Departamento(nombre,contraseña);
            departamentos.add(aux);
            return true;
        }
    }

    //Listar Salas
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

    //Listar todas las reservas
    public void listarTodasReservas(){

    }

}
