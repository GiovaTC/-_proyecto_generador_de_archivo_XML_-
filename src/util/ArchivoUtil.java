package util;

import java.io.File;

public class ArchivoUtil {

    public static String obtenerRutaArchivo() {

        File carpeta = new File("salida");

        if (!carpeta.exists()) {
            carpeta.mkdir();
        }

        return "salida/personas.xml";
    }
}