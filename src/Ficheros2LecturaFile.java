import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros2LecturaFile {
    public static void main(String[] args) {
        File fichero = new File("listaCompra.txt");
        FileReader fileReader = null;

        try {
            CrearFichero(fichero);
            fileReader = new FileReader(fichero);
            String contenido = LeerFichero(fileReader);
            System.out.println("Contenido de fichero -> \n" + contenido);

        }
        catch (IOException e) {
            System.err.println("Error con el fichero");
        }
        finally {
            CerrarFichero(fileReader);
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
    private static String LeerFichero(FileReader fileReader) throws IOException {
        // leemos elemento por elemento en codigo ASIIC
        int c = fileReader.read();
        String contenido = "";
        // recorremos mientras no sea -1 (EOF - final del fichero)
        while(c != -1){
            contenido += (char)c;
            c = fileReader.read();
        }
        return contenido;
    }

    private static void CerrarFichero(FileReader fileReader) {
        if(fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.err.println("Error cerrando fichero");
            }
        }
    }
}