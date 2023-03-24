import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio2Cifrado {

    public static void main(String[] args) {
        // Array con el abecedario
        char[] abecedario = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        // Leer el archivo con FileReader
        try {
            File archivo = new File("mensaje.txt");
            FileReader lector = new FileReader(archivo);

            int desplazamiento = 3;

            // Leer el mensaje encriptado de las siguientes líneas
            int caracter;
            while ((caracter = lector.read()) != -1) {
                char letra = (char) caracter;

                // Obtener el índice de la letra en el abecedario
                int indice = 0;
                Boolean encontrado = false;
                while (!encontrado && indice < abecedario.length) {
                    if (abecedario[indice] == letra) {
                        encontrado = true;
                    } else {
                        indice++;
                    }
                }

                // imprimir tal cual el espacio
                if (letra == ' ') {
                    System.out.print(" ");
                } else {
                    // Calcular el nuevo índice con el desplazamiento
                    int nuevoIndice = indice - desplazamiento;
                    if (nuevoIndice < 0) {
                        nuevoIndice = nuevoIndice + abecedario.length;
                    }
                    // Imprimir la letra cifrada
                    System.out.print(abecedario[nuevoIndice]);
                }
            }

            lector.close();

        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
        }
    }
}
