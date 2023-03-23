import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5ListaCompra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la lista de la compra (escribe 'fin' para finalizar):");
        String producto = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter("listaCompra.txt", true)){
            while (!producto.equalsIgnoreCase("fin")) {
                fileWriter.write(producto + "\n");
                producto = scanner.nextLine();
            }
            System.out.println("La lista de la compra se ha guardado en el archivo listaCompra.txt");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la lista de la compra en el archivo");
        }
    }
}