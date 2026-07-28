# -_proyecto_generador_de_archivo_XML_- :.
# Generador de Archivo XML con Java 21 + MySQL + JDBC + XML DOM

Proyecto básico para practicar **Java 21**, **IntelliJ IDEA**, **Consola**, **MySQL 8**, **JDBC** y la generación de archivos **XML** utilizando la API **DOM (Document Object Model)**.

---

# Objetivo

Desarrollar una aplicación de consola que sea capaz de:

- Conectarse a una base de datos MySQL.
- Consultar los registros almacenados en una tabla.
- Generar un archivo XML a partir de los datos obtenidos.
- Guardar el archivo XML dentro de una carpeta del proyecto.
- Mostrar en consola el estado de cada proceso.

---

# Tecnologías

- Java 21
- IntelliJ IDEA
- MySQL 8
- JDBC
- DOM XML (`javax.xml.parsers`)
- Transformer XML (`javax.xml.transform`)

---

# Estructura del Proyecto

```text
GeneradorXMLJava/
│
├── src/
│
├── config/
│   └── ConexionBD.java
│
├── model/
│   └── Persona.java
│
├── dao/
│   └── PersonaDAO.java
│
├── xml/
│   └── GeneradorXML.java
│
├── util/
│   └── ArchivoUtil.java
│
└── Main.java
```

---

# Base de Datos

## Crear Base de Datos

```sql
CREATE DATABASE xml_db;
```

```sql
USE xml_db;
```

## Crear Tabla

```sql
CREATE TABLE personas (

    id INT AUTO_INCREMENT PRIMARY KEY,

    nombre VARCHAR(100),

    apellido VARCHAR(100),

    edad INT,

    ciudad VARCHAR(80)

);
```

---

# Datos de Prueba

```sql
INSERT INTO personas(nombre, apellido, edad, ciudad)
VALUES
('Juan','Perez',25,'Bogotá'),
('Ana','Martinez',30,'Medellín'),
('Carlos','Gomez',22,'Cali'),
('Laura','Ruiz',28,'Barranquilla'),
('Pedro','Torres',35,'Cartagena');
```

---

# XML Esperado

```xml
<?xml version="1.0" encoding="UTF-8"?>

<personas>

    <persona>

        <id>1</id>

        <nombre>Juan</nombre>

        <apellido>Perez</apellido>

        <edad>25</edad>

        <ciudad>Bogotá</ciudad>

    </persona>

    <persona>

        <id>2</id>

        <nombre>Ana</nombre>

        <apellido>Martinez</apellido>

        <edad>30</edad>

        <ciudad>Medellín</ciudad>

    </persona>

</personas>
```

---

# Clases del Proyecto

## ConexionBD.java

### Responsabilidades

- Abrir la conexión con MySQL.
- Cerrar la conexión.
- Gestionar los recursos JDBC.

---

## Persona.java

### Modelo de Datos

Representa una persona almacenada en la base de datos.

### Atributos

- id
- nombre
- apellido
- edad
- ciudad

### Incluye

- Constructor vacío.
- Constructor con parámetros.
- Getters.
- Setters.
- Método `toString()`.

---

## PersonaDAO.java

### Responsabilidades

Consultar la información de la tabla.

### Consulta SQL

```sql
SELECT * FROM personas;
```

### Retorna

```text
ArrayList<Persona>
```

---

## GeneradorXML.java

### Responsabilidades

Crear el archivo:

```text
personas.xml
```

### Utiliza

- DocumentBuilderFactory
- DocumentBuilder
- Document
- Element
- TransformerFactory
- Transformer
- DOMSource
- StreamResult

### Funciones

- Crear el documento XML.
- Construir el árbol XML.
- Agregar cada persona al documento.
- Guardar el XML en disco.

---

## ArchivoUtil.java

### Responsabilidades

- Verificar si existe la carpeta:

```text
salida/
```

- Crear la carpeta si no existe.
- Devolver la ruta donde se almacenará el archivo XML.

---

## Main.java

### Flujo del Programa

```text
Inicio
   │
   ▼
Conectar a MySQL
   │
   ▼
Consultar Personas
   │
   ▼
Generar Documento XML
   │
   ▼
Guardar Archivo
   │
   ▼
Mostrar Ruta del Archivo
   │
   ▼
Fin
```

---

# Funcionamiento General

1. El usuario ejecuta el programa.
2. Se establece conexión con MySQL.
3. Se consultan todos los registros de la tabla **personas**.
4. Los registros son almacenados en un `ArrayList<Persona>`.
5. Se crea un documento XML utilizando la API DOM.
6. Cada objeto Persona se convierte en un nodo XML.
7. El documento se guarda en la carpeta **salida**.
8. El programa informa la ubicación del archivo generado.

---

# Resultado Esperado en Consola

```text
==================================
      GENERADOR DE XML
==================================

Conectando a MySQL...

Conexión exitosa.

Consultando registros...

5 registros encontrados.

Generando archivo XML...

Archivo generado correctamente.

Ruta:

C:\GeneradorXMLJava\salida\personas.xml

Proceso terminado.
```

---

# Archivo Generado

```text
GeneradorXMLJava/
│
├── salida/
│   └── personas.xml
│
└── src/
```

---

# Resultado del XML

```text
personas.xml
```

Contendrá toda la información consultada desde la base de datos organizada mediante etiquetas XML.

---

# Conceptos de Java que se Practican

- Programación Orientada a Objetos (POO).
- Encapsulamiento.
- Clases y Objetos.
- Constructores.
- Getters y Setters.
- Sobrescritura de `toString()`.
- JDBC.
- MySQL.
- Patrón DAO (Data Access Object).
- Modelo de Datos.
- Manejo de Colecciones (`ArrayList`).
- Manejo de Archivos.
- XML DOM.
- `DocumentBuilderFactory`.
- `DocumentBuilder`.
- `Document`.
- `Element`.
- `TransformerFactory`.
- `Transformer`.
- Manejo de Excepciones (`try/catch`).
- Organización de proyectos mediante paquetes.

---

# Requisitos

- Java JDK 21
- IntelliJ IDEA
- MySQL Server 8
- MySQL Connector/J (JDBC Driver)

---

# Salida Final Esperada

```text
✔ Conexión a MySQL establecida.

✔ Registros consultados correctamente.

✔ Documento XML construido.

✔ Archivo personas.xml generado.

✔ Archivo almacenado en:

GeneradorXMLJava/salida/personas.xml

✔ Proceso finalizado correctamente.
```

---

# Autor

**Proyecto educativo para practicar:**

- Java 21
- IntelliJ IDEA
- JDBC
- MySQL 8
- XML DOM
- Organización por capas (DAO)
- Manejo de archivos
- Programación Orientada a Objetos.
:. . / .
