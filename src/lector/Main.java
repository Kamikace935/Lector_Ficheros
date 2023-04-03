package lector;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        File fichero;

        System.out.print("Introduce la ruta que quieres revisar: ");
        fichero = new File(teclado.nextLine());

        lectorFichero(fichero);

        teclado.close();
    }

    private static void lectorFichero(File fichero) {
        try(Scanner lector = new Scanner(fichero)){
            int cont = 1;
            while (lector.hasNextLine()) {
                System.out.println(cont+".-"+lector.nextLine());
                cont++;
            }
        }catch(FileNotFoundException fnfe){
            if(fichero.isDirectory())
                System.out.print("Has pasado un directorio, tienes que introducir un fichero");
            else
                System.out.print("El fichero dado no existe");
        }catch(Exception e) {e.printStackTrace();}
    }
}