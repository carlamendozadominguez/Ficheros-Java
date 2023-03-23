import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros3Lectura {
    public static void main(String[] args) {
        FileReader fileReader = null;

        try {
            // Si el fichero no existiera da error, debemos controlarlo
            fileReader = new FileReader("listaCompra.txt");
            String contenido = LeerFichero(fileReader);
            System.out.println("Contenido de fichero -> \n" + contenido);

        }
        catch (FileNotFoundException e){
            System.err.println("El fichero no existe");
        }
        catch (IOException e) {
            System.err.println("Error con el fichero");
        }
        finally {
            CerrarFichero(fileReader);
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