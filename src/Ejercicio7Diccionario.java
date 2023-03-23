import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio7Diccionario {

    public static void main(String[] args) {
        // Leer el archivo y crear el diccionario
        HashMap<String, String> diccionario = null;
        try {
            diccionario = leerDiccionario("diccionario.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Pedir una palabra al usuario y buscar su traducción
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una palabra en español: ");
        String palabra = sc.nextLine();
        String traduccion = traducirPalabra(palabra, diccionario);
        System.out.println("La traducción al inglés es: " + traduccion);
    }

    public static HashMap<String, String> leerDiccionario(String rutaArchivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        HashMap<String, String> diccionario = new HashMap<String, String>();
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] palabras = linea.split(",");
            diccionario.put(palabras[0], palabras[1]);
        }
        reader.close();
        return diccionario;
    }

    public static String traducirPalabra(String palabra, HashMap<String, String> diccionario) {
        if (diccionario.containsKey(palabra)) {
            return diccionario.get(palabra);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("No tengo la traducción de esa palabra. Introduce la traducción en inglés: ");
            String traduccion = sc.nextLine();
            diccionario.put(palabra, traduccion);
            // Agregar la nueva traducción al archivo
            try (FileWriter writer = new FileWriter("diccionario.txt", true))
            {
                writer.write("\n" + palabra + "," + traduccion);
                System.out.println("Traducción agregada al diccionario.");
            } catch (IOException e) {
                System.err.println("Error al agregar la traducción al archivo.");
            }
            return traduccion;
        }
    }
}
