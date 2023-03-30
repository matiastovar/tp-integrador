import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Resultados {
    public static void main(String[] args) {
        // Define la ruta del archivo CSV
        // Al utilizar la clase Path en lugar de una cadena de caracteres (String) simple para representar una ruta de archivo, obtenemos una serie de beneficios que nos permiten trabajar con rutas de archivo de manera más eficiente, segura y portátil.
        Path rutaArchivo = Paths.get("C:\\Users\\Bruno\\OneDrive\\Programacion\\Argentina Programa\\Java\\Trabajo Practico\\Resultados\\resultados.csv");
        // Una vez que hayas importado la clase Paths, puedes utilizar el método Paths.get() para crear un objeto Path a partir de una cadena de caracteres que representa una ruta de archivo.
        // Para poder utilizar este método en tu código, debes importar la clase java.nio.file.Paths en tu archivo Java

        try {
            // Lee todas las líneas del archivo CSV y las almacena en una lista de cadenas de texto
            List<String> lineas = Files.readAllLines(rutaArchivo);

            // Itera sobre cada línea del archivo CSV
            for (String linea : lineas) {
                // Divide la línea en sus valores individuales utilizando el carácter ","
                String[] valores = linea.split(",");

                // Aca puedo hacer algo con los valores leídos

            }
        } catch (IOException e) {
            // Maneja cualquier excepción que pueda ocurrir al leer el archivo CSV, utilizando la subclase IOException y declarando la variable e
            System.err.println("Error al leer el archivo: " + e.getMessage()); //La expresión 'e.getMessage()' se utiliza para obtener el mensaje de error específico asociado con la excepción capturada. Este mensaje de error puede proporcionar información valiosa sobre el problema que causó la excepción y puede ser útil para el usuario o el desarrollador para diagnosticar el problema.
            System.exit(1); //Nuevamente demostramos que ocurrió un error.
            //  Codigo de salida = 0 = Exitoso
            // Codigo de salida distinto de 0 = ha ocurrido un error
        }
    }
}

