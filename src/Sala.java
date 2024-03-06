public class Sala {
    //propiedades
    protected String nombre;
    protected String contraseña;

    //Constuctor
    public Sala(String nombre, String contraseña){
        this.nombre=nombre;
        this.contraseña=contraseña;
    }

    @Override
    public String toString() {
        String sala="|Nombre: "+this.nombre+" |Contraseña: "+this.contraseña;
        return sala;
    }
}
