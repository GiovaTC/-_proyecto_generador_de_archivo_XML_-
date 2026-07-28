package xml;

import model.Persona;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorXML {

    public void generar(ArrayList<Persona> lista) {

        try {

            // Crear documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            // Nodo raíz
            Element raiz = documento.createElement("personas");
            documento.appendChild(raiz);

            // Recorrer la lista
            for (Persona p : lista) {

                Element persona = documento.createElement("persona");

                Element id = documento.createElement("id");
                id.appendChild(documento.createTextNode(String.valueOf(p.getId())));
                persona.appendChild(id);

                Element nombre = documento.createElement("nombre");
                nombre.appendChild(documento.createTextNode(p.getNombre()));
                persona.appendChild(nombre);

                Element apellido = documento.createElement("apellido");
                apellido.appendChild(documento.createTextNode(p.getApellido()));
                persona.appendChild(apellido);

                Element edad = documento.createElement("edad");
                edad.appendChild(documento.createTextNode(String.valueOf(p.getEdad())));
                persona.appendChild(edad);

                Element ciudad = documento.createElement("ciudad");
                ciudad.appendChild(documento.createTextNode(p.getCiudad()));
                persona.appendChild(ciudad);

                raiz.appendChild(persona);
            }

            // Crear carpeta salida si no existe
            File carpeta = new File("salida");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            // Guardar XML
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(new File("salida/personas.xml"));

            transformer.transform(source, result);

            System.out.println("Archivo XML generado correctamente.");
            System.out.println("Ruta: salida/personas.xml");

        } catch (Exception e) {

            System.out.println("Error al generar XML: " + e.getMessage());
        }
    }
}
