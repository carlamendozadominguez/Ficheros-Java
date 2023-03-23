import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio1Letras {
    public static void main(String[] args) {
        File fichero = new File("miTrabajo.txt");
        FileReader fileReader = null;

        try {
            CrearFichero(fichero);
            fileReader = new FileReader(fichero);
            int numeroLetras = ContarLetras(fileReader);
            System.out.println("Numero de letras del fichero -> \n" + numeroLetras);

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
    private static int ContarLetras(FileReader fileReader) throws IOException {
        int c = fileReader.read();
        int numeroLetras = 0;
        char contenido;

        while(c != -1){
            contenido = (char)c;
            if(contenido != '\n' && contenido != '\r'  )
                numeroLetras++;
                c = fileReader.read();
        }
        return numeroLetras;
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