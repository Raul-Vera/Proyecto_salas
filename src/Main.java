import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int eleccion;
        boolean opcioninvalida = false;
        Scanner in = new Scanner(System.in);
        Administrador admin=new Administrador("1111");
        //Menu
        do {
            opcioninvalida=false;
            System.out.println("----MENU----");
            System.out.println("1) Login como Administrador");
            System.out.println("2) Login como Departamento");
            System.out.println("3) Salir");
            eleccion=Integer.parseInt(in.nextLine());

            //Menu Administrador
            if(eleccion==1){

            }
            if (eleccion<1 ||eleccion>3){
                System.out.println("Debes introducir una opción valida");
                opcioninvalida=true;
            }

        }
        while (eleccion==1 || eleccion==2||opcioninvalida);
        System.out.println("Hasta la próxima");
    }
}

