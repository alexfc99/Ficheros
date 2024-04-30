package Gestion;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws IOException {
        int opcion;
        int contador;
        Scanner scanner = new Scanner(System.in);
        File f = File.listRoots()[0];
        do {
            contador = 0;
            System.out.println("Lista de ficheros y directorios del directorio: / \n--------------------------------------------------");
            System.out.println(contador + ".- " + "Direcortio Padre ");
            for(File x : f.listFiles()){
                contador++;
                if (x.isFile()){
                    System.out.println(contador + ".- " + f.getName() + " - " + f.length());
                }
                if(x.isDirectory()){
                    System.out.println(contador + ".- " + x.getName() + " <Directorio>");
                }
            }
            System.out.println("Introduce una opción (-1 para salir): ");
            opcion = scanner.nextInt();
            try {
                scanner.nextLine();
            }catch (InputMismatchException ime){
                System.out.println("Introduce números. ");
            }
            if (opcion == 0){
                if (f.getParentFile() != null && f.getParentFile().canRead()){
                    f = f.getParentFile();
                }
            }else if (opcion != - 1){
                if (opcion <= f.listFiles().length){
                    if (f.listFiles()[opcion - 1].isDirectory() && f.listFiles()[opcion - 1].canRead()){
                        f = f.listFiles()[opcion - 1];
                    }
                }
            }
        }while (opcion != -1);
    }
}