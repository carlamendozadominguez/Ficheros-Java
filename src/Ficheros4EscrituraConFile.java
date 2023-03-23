import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ficheros4EscrituraConFile {
    public static void main(String[] args) {
        File fichero = new File("listaCompra.txt");
        FileWriter fileWriter = null;

        try {
            CrearFichero(fichero);
            fileWriter = new FileWriter(fichero);

            fileWriter.write("2kg naranjas\n");
            fileWriter.write("0,5kg platanos \n");
            fileWriter.write("1kg pollo\n");
        }
        catch (IOException e) {
            System.err.println(e);
        }
        finally {
            CerrarFichero(fileWriter);
        }
    }
    private static void CrearFichero(File fichero) throws IOException {
        if (fichero.createNewFile()) {
            System.out.println("Fichero creado");
        }
        else {
            System.out.println("Fichero ya existe");
        }
    }
    private static void CerrarFichero(FileWriter fileWriter) {
        if(fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Error cerrando fichero");
            }
        }
    }
}