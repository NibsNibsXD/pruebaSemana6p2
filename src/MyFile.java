import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jorge Aguirre
 */


public class MyFile {
    private File myFile = null;
    
    void setFile(String direccion){
        myFile = new File(direccion);
    }
    
    void info(){
        if(myFile.exists()){
            System.out.println("\nNombre: " + myFile.getName());
            System.out.println("Path: " + myFile.getPath());
            System.out.println("Absoluta: " + myFile.getAbsolutePath());
            System.out.println("Bytes: " + myFile.length());
            System.out.println("Ultima Modificacion: " + new Date(myFile.lastModified()));
            System.out.println("Padre: " + myFile.getAbsoluteFile().getParentFile().getName());
            if(myFile.isFile()){
                System.out.println("ES FILE");
            }else if(myFile.isDirectory()){
                System.out.println("ES UN FOLDER");
            }
            System.out.println("-+-+-+-+-+-+-+-+-+-");
        }else{
            System.out.println("NO EXISTE");
        }
    }
    
    boolean crearFile() throws IOException{
        return myFile.createNewFile();
    }
    
    boolean crearFolder(){
        return myFile.mkdirs();
    }
    
    void borrar() {
        if (antidoto(myFile))
            System.out.println("Borrado!");
        else
            System.out.println("No se pudo borrar");
    }

    private boolean antidoto(File mf) {
        if (mf.isDirectory()) {
            for (File child : mf.listFiles())
                antidoto(child);
        }   
        return mf.delete();
    }

    void dir() {
        if (myFile.isDirectory()) {
            System.out.println("Directorio de: " + myFile.getAbsolutePath());
            System.out.println("");

            // Contadores
            int cfiles = 0, cdirs = 0;
            long tbytes = 0;

            // Recorrido
            for (File child : myFile.listFiles()) {
                if (!child.isHidden()) {
                    // Última Modificación
                    Date ultimo = new Date(child.lastModified());
                    System.out.print(ultimo + "\t");

                    // Si es File or Folder
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        // File
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("\t" + child.length() + "\t");
                    }

                    // Mostrar los objetos
                    System.out.println(child.getName());
                }
            }

            System.out.println(cfiles + " archivos\t" + tbytes + " bytes");
            System.out.println(cdirs + " dirs\t");
            
        }
    }

    
    // Aqui version 1 para sobreescribir el arcnivo,aqui uso FileWriter
    void escribirArchivo() {
        if (myFile.exists() && myFile.isFile()) {
            
            try (FileWriter fw = new FileWriter(myFile)) {
                
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese el texto nuevo, el texto anterior se perdera ");
                
                String texto = sc.nextLine();
                fw.write(texto);
                System.out.println("Texto fue escrito sin problemas");
                
            } catch (IOException e) {
                System.out.println("Error al escribir: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo no existe ");
        }
    }

    
        // Aqui la version 2, pero aqui uso BufferedWriter
    void anadirArchivo() {
        if (myFile.exists() && myFile.isFile()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(myFile, true))) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese el texto a añadir al archivo:");
                String texto = sc.nextLine();
                
                bw.write(texto);
                bw.newLine(); 
                
                System.out.println("Texto agregado sin sibrescbribir exitosamente.");
                
                
            } catch (IOException e) {
                
                System.out.println("Error al añadir al archivo: " + e.getMessage());
                
            }
        } else {
            System.out.println("El archivo no existe o no es un archivo regular.");
        }
    }


    
    
    // Aqui la version 1, uso FileReader
    void leerArchivoConFileReader() {
        if (myFile.exists() && myFile.isFile()) {
            
            try (FileReader fr = new FileReader(myFile)) {
                int i;
                
                
                while ((i = fr.read()) != -1) {
                    System.out.print((char) i);
                }
                System.out.println(""); 
                
            } catch (IOException e) {
                System.out.println("Error al intentar leer: " + e.getMessage());
            }
            
        } else {
            
            System.out.println("El archvo no existe");
        }
    }

    
    
    
        // Aqui la version 2, uso BufferedReadear
    void leerArchivoConBufferedReader() {
        if (myFile.exists() && myFile.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(myFile))) {
                
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            
            System.out.println("El archivo no existe o no es un archivo regular.");
            
        }
    }
    
    
    
}