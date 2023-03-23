import java.io.FileWriter;
import java.io.IOException;

public class Ficheros5Escritura {
    public static void main(String[] args) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("listaCompra.txt");
            // Si queremos que que sobreescriba lo que hay enviar parámetro true
            // fileWriter = new FileWriter(fichero, true);
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