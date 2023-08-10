package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Random generadorAleatorio = new Random();

        final String contraseña = "admin123*";
        Double tarifaKWH=1.0;


        Integer opcionPerfil=-1;
        String respuestaPerfil;
        Integer contadorIntentos=0;


        Integer opcionMenu=-1;
        Integer KWTotales;
        Integer contadorPicos;

        String colorVerde="\033[0;32m";
        String colorReset="\033[0m";
        String colorAzul="\033[0;34m";
        String colorMorado="\033[1;35m";
        String colorRojo="\033[1;31m";



        do{
            System.out.println(colorVerde+"------- BIENVENIDO -------");
            System.out.println(colorReset+"1. Administrador");
            System.out.println("2. Empresa");
            System.out.println("3. TERMINAR");
            System.out.print(colorAzul+"Digite el número de la opción de su perfil: "+colorReset);


            opcionPerfil = teclado.nextInt();

            if (opcionPerfil == 1) {
                //--------------------------------------------------------------Login
                System.out.print(colorAzul+"Digite su contraseña: "+colorReset);
                teclado.nextLine();
                respuestaPerfil = teclado.nextLine();

                if(respuestaPerfil.equals(contraseña)){
                    //---------------------------------------------------------Modificar tarifa KWH
                    System.out.println(colorVerde+"---------------- Bienvenido admin ---------------");
                    System.out.print(colorAzul+"Digite la nueva tarifa del KWH: $");
                    tarifaKWH = teclado.nextDouble();
                    System.out.println(colorMorado+"Nueva tarifa fijada en $"+tarifaKWH+colorReset);
                }else{
                    //---------------------------------------------------------Contraseña equivocada
                    contadorIntentos++;
                    if(contadorIntentos>=3){
                        System.out.println(colorRojo+"Número de intentos excedidos."+colorReset);
                        opcionPerfil=3;
                    }else{
                        System.out.println(colorRojo+"Contraseña equivocada, inténtelo de nuevo");
                        System.out.println(colorMorado+"Te quedan "+(3-contadorIntentos)+" intentos."+colorReset);
                    }
                }

            }
            else if (opcionPerfil == 2) {
                //---------------------------------------------------------------Empresa
                KWTotales=0;
                contadorPicos=0;

                //Hacemos cuentas
                Integer contadorDias=1;
                while (contadorDias<=30){
                    Integer KWDia = generadorAleatorio.nextInt(401);
//                    System.out.println("Día "+contadorDias+": "+ KWDia);
                    KWTotales = KWTotales+KWDia;
                    if (KWDia>300){
//                        System.out.println("Sumamos un pico");
                        contadorPicos++;}
                    contadorDias++;
                }

                do {
                    //---------------------------------------------------------------Menú
                    System.out.println(colorVerde+"------- EPM empresas - GRANDES CLIENTES -------");
                    System.out.println(colorReset+"1. Ver tarifa.");
                    System.out.println("2. Mostrar consumo promedio.");
                    System.out.println("3. Mostrar picos consumo.");
                    System.out.println("4. Mostrar factura.");
                    System.out.println("5. SALIR.");
                    System.out.print(colorAzul+"Digite el número de la opción que desea consultar:"+colorReset);
                    opcionMenu = teclado.nextInt();

                    switch (opcionMenu) {
                        case 1:
                            System.out.println(colorMorado+"La tarifa actual del KWH es: $"+tarifaKWH+colorReset);
                            break;
                        case 2:
                            System.out.println(colorMorado+"El consumo promedio de KW es de: "+KWTotales/30+colorReset);
                            break;
                        case 3:
                            System.out.println(colorMorado+"El total de picos de este mes fue de: "+contadorPicos+colorReset);
                            break;
                        case 4:
                            System.out.println(colorMorado+"El total de kw consumidos en los últimos 30 días fue de "+KWTotales);
                            System.out.println("El total a pagar es de: $"+KWTotales*tarifaKWH+colorReset);
                            break;
                        default:
                            System.out.println(colorRojo+"Opción inválida"+colorReset);
                            break;
                    }

                    System.out.println(colorAzul+"Presione enter para continuar"+colorReset);
                    teclado.nextLine();
                    teclado.nextLine();
                }while(opcionMenu!=5);



            }
            else {
                System.out.println(colorMorado+"Opción inválida. Intente de nuevo"+colorReset);
            }

        }while(opcionPerfil != 3 && contadorIntentos<3);


        System.out.println("...............");
        System.out.println("...............");
        System.out.println(".....FINAL.....");
        System.out.println("...............");
        System.out.println("...............");


    }
}