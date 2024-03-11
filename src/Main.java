import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int eleccion=1;
        int eleccionadmin;
        int eleccciondep;
        String contraseñadepartamento;
        String contraseñadmin;
        Departamento opertativo;
        boolean opcioninvalida = false;
        Scanner in = new Scanner(System.in);
        Administrador admin = new Administrador("1111");
        //Menu


        do {
            try {


                opcioninvalida = false;
                System.out.println("----MENU----"); //Creamos un menu  como indica es Admin y Departamento
                System.out.println("1) Login como Administrador");
                System.out.println("2) Login como Departamento");
                System.out.println("3) Salir");
                eleccion = Integer.parseInt(in.nextLine());


                if (eleccion < 1 || eleccion > 3) {
                    System.out.println("Debes introducir una opción valida");
                    opcioninvalida = true;
                }

                //Menu Administrador
                if (eleccion == 1) {
                    boolean cerrarsesion = false;
                    System.out.println("Introduce la contraseña de administrador"); //Tendremos que meter bien la contraseña
                    contraseñadmin = in.nextLine();
                    while (!contraseñadmin.equals(admin.contraseña) && !contraseñadmin.equals("3")) {
                        System.out.println("La contraseña no es valida"); //Mensaje de contraseña erronea
                        System.out.println("vuelve a intentarlo o pulse 3 para salir");
                        contraseñadmin = in.nextLine();

                    }
                    while (contraseñadmin.equals(admin.contraseña) && !cerrarsesion) {
                        System.out.println();
                        System.out.println();
                        System.out.println("---MENU ADMIN---"); //multiples opciones
                        System.out.println("1) Listar Departamento");
                        System.out.println("2) Añadir Departamento");
                        System.out.println("3) Eliminar Departamentos");
                        System.out.println("4) Listar Salas");
                        System.out.println("5) Añadir Sala");
                        System.out.println("6) Eliminar Sala");
                        System.out.println("7) Listar todas las Reservas");
                        System.out.println("8) Cerrar Sesión");
                        System.out.println("Elige la opcion que desees");
                        eleccionadmin = Integer.parseInt(in.nextLine());

                        if (eleccionadmin == 1) {
                            admin.listarDepartamentos(); //te listará departamentos
                        } else if (eleccionadmin == 2) {//añades departamento con nombre y contraseña
                            String nombredep;
                            String contraseñadep;
                            System.out.println();
                            System.out.println("Introduce el nombre del departamento");
                            nombredep = in.nextLine();
                            System.out.println("Introduce la clave del departamento");
                            contraseñadep = in.nextLine();
                            if (admin.añadirDepartamento(contraseñadep, nombredep)) {
                                System.out.println("El departamento  ha sido añadido con exito");
                            } else {
                                System.out.println("El departamento ya existía");
                            }
                        } else if (eleccionadmin == 3) { //eliminas departamento si no exixste te manda mensaje
                            String contraseña;
                            System.out.println("Introduce la clave del departamento");
                            contraseña = in.nextLine();
                            if (admin.eliminarDepartamento(contraseña)) {
                                System.out.println("Se elimino el departamento");
                            } else {
                                System.out.println("La clave no corresponde a ningun departamento");
                            }

                        } else if ((eleccionadmin == 4)) { //Listar Salas
                            admin.listarSalas();
                        } else if (eleccionadmin == 5) { //Crear sala
                            String nombredesal;
                            String contraseñasal;
                            System.out.println();
                            System.out.println("Introduce el nombre de la sala");
                            nombredesal = in.nextLine();
                            System.out.println("Introduce la clave de la sala");
                            contraseñasal = in.nextLine();
                            if (admin.añadirSala(contraseñasal, nombredesal)) {
                                System.out.println("La sala  ha sido creada con exito");
                            } else {
                                System.out.println("La sala ya existía");
                            }
                        } else if (eleccionadmin == 6) {//eliminar sala
                            String contraseña;
                            System.out.println("Introduce la clave de la sala");
                            contraseña = in.nextLine();
                            if (admin.eliminarSala(contraseña)) {
                                System.out.println("Se elimino la sala");
                            } else {
                                System.out.println("La clave no corresponde a ninguna sala");
                            }

                        } else if (eleccionadmin == 7) { //listas reservas
                            admin.listarTodasReservas();

                        } else if (eleccionadmin == 8) {  //sales de este menu cerrando sesion
                            cerrarsesion = true;
                        }

                    }


                }
                if (eleccion == 2) {
                    boolean cerrarsesion = false;
                    System.out.println();
                    System.out.println("Introduce la clave del departamento");
                    contraseñadepartamento = in.nextLine();
                    while (admin.encontrarContraseñaDep(contraseñadepartamento) == null && !contraseñadepartamento.equals("4")) {
                        System.out.println("La contraseña no es valida"); //Mensaje de contraseña erronea
                        System.out.println("vuelve a intentarlo o pulse 3 para salir");
                        contraseñadepartamento = in.nextLine();

                    }
                    while (admin.encontrarContraseñaDep(contraseñadepartamento) != null && !cerrarsesion) {
                        opertativo = admin.encontrarContraseñaDep(contraseñadepartamento);
                        System.out.println("---MENU del departamento de " + opertativo.nombre + "---");
                        System.out.println("1) Añadir Reserva");
                        System.out.println("2) Eliminar Reservas");
                        System.out.println("3) Listar reservas");
                        System.out.println("3) Cerrar sesion");
                        System.out.println();
                        System.out.println("Elige la opcion que desees");
                        eleccciondep = Integer.parseInt(in.nextLine());
                        while (eleccciondep > 3 || eleccciondep < 1) {
                            System.out.println("Introduce un valor valido");
                            eleccciondep = Integer.parseInt(in.nextLine());
                        }
                        if (eleccciondep == 1) { //reserva , te pide en duracion cuantas horas quieres
                            int año, mes, dia, hora, duracion;
                            LocalDateTime aux;
                            String clavesala;
                            Duration d;
                            System.out.println("Introduce el año");
                            año = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce el mes");
                            mes = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce el dia");
                            dia = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce la hora");
                            hora = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce la duracion");
                            duracion = Integer.parseInt(in.nextLine());
                            d = Duration.ofHours(duracion);
                            aux = LocalDateTime.of(año, mes, dia, hora, 0);
                            System.out.println("Por ultimo la clave de la sala");
                            clavesala = in.nextLine();
                            if (admin.encontrarContraseñaSal(clavesala) != null) {
                                if (opertativo.AñadirReserva(clavesala, aux, d)) {
                                    System.out.println("Se ha hecho la reserva");
                                } else {
                                    System.out.println("La reserva no se ha realizado porque la sala no esta diponible a esa fecha");
                                }
                            } else {
                                System.out.println(" No existe ninguna sala con esa clave");
                            }
                        }
                        if (eleccciondep == 2) {//eliminas la reserva
                            int año, mes, dia, hora, duracion;
                            LocalDateTime aux;
                            String clavesala;
                            Duration d;
                            System.out.println("Introduce el año");
                            año = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce el mes");
                            mes = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce el dia");
                            dia = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce la hora");
                            hora = Integer.parseInt(in.nextLine());
                            System.out.println("Introduce la duracion");
                            duracion = Integer.parseInt(in.nextLine());
                            d = Duration.ofHours(duracion);
                            aux = LocalDateTime.of(año, mes, dia, hora, 0);
                            System.out.println("Por ultimo la clave de la sala");
                            clavesala = in.nextLine();
                            if (admin.encontrarContraseñaSal(clavesala) != null) {
                                if (opertativo.eliminarReserva(clavesala, aux, d)) {
                                    System.out.println("Se ha eliminado la reserva ");
                                } else {
                                    System.out.println("La reserva no se ha eliminado porque no se ha encontrado");
                                }
                            } else {
                                System.out.println(" No existe ninguna sala con esa clave");
                            }
                        }
                        if (eleccciondep==3){
                            admin.listarTodasReservas();
                        }

                        if ((eleccciondep == 4)) { //cierras sesion
                            cerrarsesion = true;
                        }
                    }
                }
            }catch (NumberFormatException nfe ){
                System.out.println("Has introducido un caracter invalido");
            }catch (DateTimeException det){
                System.out.println("Fecha no valida");
            }

            }while (eleccion == 1 || eleccion == 2 || opcioninvalida);
                System.out.println("Hasta la próxima");
            }


    }
