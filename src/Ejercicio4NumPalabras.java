import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4NumPalabras {

    public static void main(String[] args) {
        File archivo = new File("miTrabajo.txt");
        int numPalabras = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                numPalabras += palabras.length;
            }
        } catch (IOException e) {
            System.err.println("Error con el fichero");
        }

        System.out.println("El archivo contiene " + numPalabras + " palabras.");
    }

}