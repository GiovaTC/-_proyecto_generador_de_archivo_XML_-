import dao.PersonaDAO;
import model.Persona;
import xml.GeneradorXML;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("     GENERADOR DE ARCHIVO XML");
        System.out.println("=================================");

        // Obtener los registros de MySQL
        PersonaDAO dao = new PersonaDAO();
        ArrayList<Persona> personas = dao.obtenerPersonas();

        System.out.println("Registros encontrados: " + personas.size());

        // Generar el archivo XML
        GeneradorXML generador = new GeneradorXML();
        generador.generar(personas);

        System.out.println("Proceso terminado.");
    }   
}