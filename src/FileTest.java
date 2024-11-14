import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jorge Aguirre
 */


public class FileTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyFile myFile = new MyFile();
        int opcion = 0;

        while (opcion != 10) {
            System.out.println("\n===== MENU =====");
            System.out.println("1- Set Archivo/Folder");
            System.out.println("2- Ver informacion");
            System.out.println("3- Crear Archivo");
            System.out.println("4- Crear Folder");
            System.out.println("5- Borrar Archivo/Folder");
            System.out.println("6- Escribir en archivo/sobreescribir (FileWriter)");
            System.out.println("7- Añadir al archivo    (BuffererdWriter)" );
            System.out.println("8- Leer archivo (FileReader)");
            System.out.println("9- Leer archivo (BufferedReader)");
            System.out.println("10- Salir");
            System.out.print("Seleccione una opcion: ");

            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la dirección del archivo o carpeta: ");
                        String direccion = scanner.nextLine();
                        myFile.setFile(direccion);
                        
                        System.out.println("Archivo/Folder establecido correctamente.");
                        break;

                    case 2:
                        myFile.info();
                        break;

                    case 3:
                        try {
                            if (myFile.crearFile()) {
                                System.out.println("Archivo creado exitosamente.");
                                
                            } else {
                                System.out.println("El archivo ya existe o no se pudo crear.");
                                
                            }
                        } catch (IOException e) {
                            
                            System.out.println("Error al crear el archivo: " + e.getMessage());
                        }
                        break;

                    case 4:
                        if (myFile.crearFolder()) {
                            System.out.println("Folder creado exitosamente");
                        } else {
                            System.out.println("El folder ya existe o no se pudo crear");
                        }
                        break;

                    case 5:
                        myFile.borrar();
                        break;

                        
                    case 6:
                        myFile.escribirArchivo();
                        
                        break;

                        
                        
                    case 7:
                        //pendiente v2 de write
                        
                        break;

                        
                        
                    case 8:
                        myFile.leerArchivoConFileReader();
                        break;

                        
                    case 9:
                        //caso 9, version 9 del reader
                        
                        break;
                        

                    case 10:
                        System.out.println("Saliste del programa.");
                        break;
                        

                    default:
                        System.out.println("opcion invalida, un numero entre el 1 a 10");
                        break;
                        
                        
                }
            } else {
                System.out.println("Ingresa un numero valido.");
                scanner.nextLine();
            }
        }

    }
}