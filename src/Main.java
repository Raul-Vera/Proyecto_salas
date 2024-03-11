import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int eleccion;
        int eleccionadmin;
        String contraseñadepartamento;
       String contraseñadmin;
       Departamento opertativo;
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



            if (eleccion<1 ||eleccion>3){
                System.out.println("Debes introducir una opción valida");
                opcioninvalida=true;
            }

            //Menu Administrador
            if(eleccion==1){
                boolean cerrarsesion=false;
                System.out.println("Introduce la contraseña de administrador");
                contraseñadmin=in.nextLine();
                while (!contraseñadmin.equals(admin.contraseña) && !contraseñadmin.equals("3")){
                    System.out.println("La contraseña no es valida");
                    System.out.println("vuelve a intentarlo o pulse 3 para salir");
                    contraseñadmin=in.nextLine();
                }
                while (contraseñadmin.equals(admin.contraseña) && !cerrarsesion){
                    System.out.println();
                    System.out.println();
                    System.out.println("---MENU ADMIN---");
                    System.out.println("1) Listar Departamento");
                    System.out.println("2) Añadir Departamento");
                    System.out.println("3) Eliminar Departamentos");//queda por hacer
                    System.out.println("4) Listar Salas");
                    System.out.println("5) Añadir Sala");
                    System.out.println("6) Eliminar Sala");//quea dpor hacerlo
                    System.out.println("7) Listar todas las Reservas");
                    System.out.println("8) Cerrar Sesión");
                    System.out.println("Elige la opcion que desees");
                    eleccionadmin=Integer.parseInt(in.nextLine());

                    if (eleccionadmin==1){
                        admin.listarDepartamentos();
                    } else if (eleccionadmin==2) {
                        String nombredep;
                        String contraseñadep;
                        System.out.println();
                        System.out.println("Introduce el nombre del departamento");
                        nombredep=in.nextLine();
                        System.out.println("Introduce la contraseña del departamento");
                        contraseñadep=in.nextLine();
                        if (admin.añadirDepartamento(contraseñadep,nombredep)){
                            System.out.println("El departamento  ha sido añadido con exito");
                    }else {
                            System.out.println("El departamento ya existía");
                        }
                }else if(eleccionadmin==3){
                        String contraseña;
                        System.out.println("Introduce la clave del departamento");
                        contraseña=in.nextLine();
                        if (admin.eliminarDepartamento(contraseña)){
                            System.out.println("Se elimino el departamento");
                        }
                        else {
                            System.out.println("La clave no corresponde a ningun departamento");
                        }

                    }
                    else  if ((eleccionadmin==4)){
                        admin.listarSalas();
                    }else if(eleccionadmin==5) {
                        String nombredesal;
                        String contraseñasal;
                        System.out.println();
                        System.out.println("Introduce el nombre de la sala");
                        nombredesal = in.nextLine();
                        System.out.println("Introduce la contraseña de la sala");
                        contraseñasal = in.nextLine();
                        if (admin.añadirSala(contraseñasal, nombredesal)) {
                            System.out.println("La sala  ha sido creada con exito");
                        } else {
                            System.out.println("La sala ya existía");
                        }
                    }
                    else if (eleccionadmin==6){
                        String contraseña;
                        System.out.println("Introduce la clave de la sala");
                        contraseña=in.nextLine();
                        if (admin.eliminarSala(contraseña)){
                            System.out.println("Se elimino la sala");
                        }
                        else {
                            System.out.println("La clave no corresponde a ninguna sala");
                        }

                        } else if (eleccionadmin==7) {
                        admin.listarTodasReservas();

                    }
                    else if (eleccionadmin==8) {
                        cerrarsesion=true;
                    }

                    }


                }
            if (eleccion==2){

                System.out.println();
                System.out.println("Introduce la contraseña del departamento");
                contraseñadepartamento=in.nextLine();
                while (admin.encontrarContraseñaDep(contraseñadepartamento) != null) {
                    opertativo=admin.encontrarContraseñaDep(contraseñadepartamento);
                    System.out.println("---MENU"+opertativo.nombre+"---");
                }
            }


    }while (eleccion==1 || eleccion==2||opcioninvalida);
        System.out.println("Hasta la próxima");
}

}
