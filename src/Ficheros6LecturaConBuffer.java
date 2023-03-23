import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros6LecturaConBuffer {
    public static void main(String[] args) {
        String fileName = "listaCompra.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            LeerFichero(bufferedReader);
        }
        catch (FileNotFoundException e){
            System.err.println("El fichero no existe");
        }
        catch (IOException e) {
            System.err.println("Error con el fichero");
        }
    }

    private static void LeerFichero(BufferedReader buffer) throws IOException {
        String line = buffer.readLine();
        while(line != null){
            System.out.println(line);
            line = buffer.readLine();
        }
    }
}