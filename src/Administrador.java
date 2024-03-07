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

    //Listar todas las reservas existencia
    public void listarTodasReservas(){

    }

    public boolean encontrarContraseñaSal(String contraseña){
        Iterator i1=salas.iterator();
        boolean encontrado=false;
        while (i1.hasNext() && !encontrado){
            Sala aux=(Sala)i1.next();
            if(contraseña.equals(aux.contraseña)){
                encontrado=true;
            }
        }
        return encontrado;
    }
    public boolean añadirSala(String contraseña,String nombre){
        if (this.encontrarContraseñaSal(contraseña)){
            return false;
        }
        else {
            Sala aux=new Sala(nombre,contraseña);
            salas.add(aux);
            return true;
        }
    }


    public boolean encontrarContraseñaDep(String contraseña){
        Iterator i1=departamentos.iterator();
        boolean encontrado=false;
        while (i1.hasNext() && !encontrado){
            Departamento aux=(Departamento)i1.next();
            if(contraseña.equals(aux.contraseña)){
                encontrado=true;
            }
        }
        return encontrado;
    }


}
