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
        if (this.encontrarContraseñaDep(contraseña)!=null){
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
        Departamento aux;
        if (departamentos.isEmpty()){
            System.out.println("No existe ningun departamento por lo que no existe ninguna reserva");
        }
        else {
            for (Object departamento : departamentos) {
                aux = (Departamento) departamento;
                System.out.println("Departamento: " + aux.nombre);
                aux.listarReservas();
            }
        }
    }

    //encuentra las contraseñas de salas
    public Sala encontrarContraseñaSal(String contraseña){
        Iterator i1=salas.iterator();
        boolean encontrado=false;
       Sala res=null;
        while (i1.hasNext() && !encontrado){
            Sala aux=(Sala)i1.next();
            if(contraseña.equals(aux.contraseña)){
                encontrado=true;
                res=aux;
            }
        }
        return res;
    }
    //añade salas al Array list
    public boolean añadirSala(String contraseña,String nombre){
        if (this.encontrarContraseñaSal(contraseña)!=null){
            return false;
        }
        else {
            Sala aux=new Sala(nombre,contraseña);
            salas.add(aux);
            return true;
        }
    }

// Encontrar la contraseña de los departamentos en el array
    public Departamento encontrarContraseñaDep(String contraseña){
        Iterator i1=departamentos.iterator();
        boolean encontrado=false;
        Departamento resp= null;
        while (i1.hasNext() && !encontrado){
            Departamento aux=(Departamento)i1.next();
            if(contraseña.equals(aux.contraseña)){
                encontrado=true;
                resp=aux;
            }
        }
        return resp;
    }
    public boolean eliminarDepartamento(String contraseña){
        Departamento res;
        if(this.encontrarContraseñaDep(contraseña)==null){
            return false;
        }
        else {
            res=this.encontrarContraseñaDep(contraseña);
            departamentos.remove(res);
            return true;
        }
    }
    public boolean eliminarSala(String contraseña){
        Sala res;
        if(this.encontrarContraseñaSal(contraseña)==null){
            return false;
        }
        else {
            res=this.encontrarContraseñaSal(contraseña);
            salas.remove(res);
            return true;
        }
    }

}
