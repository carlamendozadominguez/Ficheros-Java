import java.io.File;
import java.io.IOException;

public class Ficheros1Informacion {
    public static void main(String[] args) {
        // Creamos el fichero del cual obtendremos información
        File fichero = new File("fichero.txt");

        // controlamos las excepciones
        try {
            CrearFichero(fichero);
            MostrarInformación(fichero);
        }
        catch (IOException e) {
            System.err.println("Error en el fichero" + e);
        }
    }

    private static void CrearFichero(File fichero) throws IOException {
        // createNewFile nos devuelve una excepción de tipo IOException
        // que debemos controlar
        if (fichero.createNewFile()) {
            System.out.println("Fichero creado");
        }
        else {
            System.out.println("Fichero ya existe");
        }
    }

    private static void MostrarInformación(File fichero) {
        System.out.println("Nombre del archivo:" + fichero.getName());
        System.out.println("Ruta:" + fichero.getPath());
        System.out.println("Ruta absoluta:" + fichero.getAbsolutePath());
        System.out.println("Se puede escribir:" + fichero.canRead());
        System.out.println("Se puede leer:" + fichero.canWrite());
        System.out.println("Tamaño:" + fichero.length());
    }


}