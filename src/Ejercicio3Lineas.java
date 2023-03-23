import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3Lineas {
    public static void main(String[] args) {

        // Nombre del archivo a leer
        String nombreArchivo = "miTrabajo.txt";

        // Variables para contar el número de líneas y la longitud de la línea más larga
        int numLineas = 0;
        int longitudMaxima = 0;
        String lineaMasLarga = "";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            // Leer cada línea del archivo
            String lineaActual;
            while ((lineaActual = br.readLine()) != null) {
                // Incrementar el contador de líneas
                numLineas++;

                // Calcular la longitud de la línea actual
                int longitudActual = lineaActual.length();

                // Si la longitud actual es mayor que la longitud máxima registrada hasta ahora,
                // actualizar la longitud máxima y la línea más larga
                if (longitudActual > longitudMaxima) {
                    longitudMaxima = longitudActual;
                    lineaMasLarga = lineaActual;
                }
            }

        } catch (IOException e) {
            // Imprimir un mensaje de error si ocurre una excepción
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // Imprimir los resultados
        System.out.println("Número de líneas en el archivo: " + numLineas);
        System.out.println("Longitud de la línea más larga: " + longitudMaxima);
        System.out.println("Línea más larga: " + lineaMasLarga);
    }
}