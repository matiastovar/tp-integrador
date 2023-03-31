package Entrega1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class Ronda {
    public static void main(String[] args) {

        Collection<Partido> partidos = new ArrayList<Partido>();

        // Define la ruta del archivo CSV
        // Al utilizar la clase Path en lugar de una cadena de caracteres (String) simple para representar una ruta de archivo, obtenemos una serie de beneficios que nos permiten trabajar con rutas de archivo de manera más eficiente, segura y portátil.
        Path rutaArchivo = Paths.get("C:\\Users\\Bruno\\OneDrive\\Programacion\\Argentina Programa\\Java\\Trabajo Practico\\Entrega 1\\Entrega1\\resulatdos.csv");
        // Una vez que hayas importado la clase Paths, puedes utilizar el método Paths.get() para crear un objeto Path a partir de una cadena de caracteres que representa una ruta de archivo.
        // Para poder utilizar este método en tu código, debes importar la clase java.nio.file.Paths en tu archivo Java

        List<String> lineas = null;

        try {
            // Lee todas las líneas del archivo CSV y las almacena en una lista de cadenas de texto
             lineas = Files.readAllLines(rutaArchivo);


        } catch (IOException e) {
            // Maneja cualquier excepción que pueda ocurrir al leer el archivo CSV, utilizando la subclase IOException y declarando la variable e
            System.err.println("Error al leer el archivo: " + e.getMessage()); //La expresión 'e.getMessage()' se utiliza para obtener el mensaje de error específico asociado con la excepción capturada. Este mensaje de error puede proporcionar información valiosa sobre el problema que causó la excepción y puede ser útil para el usuario o el desarrollador para diagnosticar el problema.
            System.exit(1); //Nuevamente demostramos que ocurrió un error.
            //  Codigo de salida = 0 = Exitoso
            // Codigo de salida distinto de 0 = ha ocurrido un error
        }

        boolean primera = true; //1) Esto lo hacemos para que cuando itere la primera linea no la escriba, y no nos muestra la linea de equipo1, equipo2 y bla

        // Itera sobre cada línea del archivo CSV
        for (String linea : lineas) {

            if (primera) {
                primera = false;// 1)
            } else {
                // Nota: Argentina,1,2,Arabia Saudita
                // Divide la línea en sus valores individuales utilizando el carácter ","
                String[] valores = linea.split(",");

                Equipo equipo1 = new Equipo(valores[0]); //Aca definimos que equipo1 sea el primer index
                Equipo equipo2 = new Equipo(valores[3]); //Aca definimos que equipo2 sea el cuarto index
                Partido partido = new Partido(equipo1, equipo2); // Creamos el objeto partido que represente el enfrentamiento

                // Se establece el numero de goles anotados teniendo en cuenta el index donde se encutra dicha información
                partido.setGolesEq1(Integer.parseInt(valores[1]));
                partido.setGolesEq2(Integer.parseInt(valores[2]));

                // Esto agrega el objeto "partido" a la colección "partidos", lo que permite almacenar y procesar múltiples objetos "Partido".
                partidos.add(partido);
            }

        }
    }
}
