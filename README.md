# ProyectoFormas

**Universidad CENFOTEC — Ingeniería de Software**

**Curso:** SOFT-04 — Programación Orientada a Objetos  
**Lenguaje:** Java  
**Entorno de desarrollo:** IntelliJ IDEA  
**Base de datos:** MySQL

## 1. Descripción

ProyectoFormas es una aplicación de consola desarrollada en Java que permite registrar, consultar y realizar cálculos geométricos de figuras planas y cuerpos tridimensionales.

El proyecto aplica principios de Programación Orientada a Objetos, incluyendo encapsulamiento, herencia, abstracción, interfaces, polimorfismo y asociaciones entre objetos.

La aplicación implementa una arquitectura MVC (Modelo-Vista-Controlador), el patrón DAO (Data Access Object) y persistencia de datos mediante MySQL.

## 2. Objetivos

- Aplicar los principios fundamentales de Programación Orientada a Objetos.
- Implementar jerarquías de clases mediante herencia.
- Utilizar interfaces y clases abstractas.
- Calcular perímetros, áreas y volúmenes de formas geométricas.
- Administrar figuras y cuerpos mediante una colección.
- Implementar una interfaz de usuario por consola.
- Separar responsabilidades utilizando MVC y DAO.
- Guardar y recuperar registros geométricos mediante MySQL.
- Documentar las clases y relaciones mediante diagramas UML.

## 3. Figuras y cuerpos geométricos

### Figuras planas

- Círculo.
- Rectángulo.
- Cuadrado.
- Rombo.
- Triángulo equilátero.
- Triángulo isósceles.
- Triángulo escaleno.

Los triángulos se clasifican automáticamente según las longitudes de sus lados utilizando la clase `FabricaTriangulos`.

### Cuerpos geométricos

- Cubo.
- Cilindro.
- Tetraedro regular.
- Esfera.

Los cuerpos permiten calcular áreas superficiales y volúmenes. El sistema también implementa cálculos de perímetro utilizando las convenciones definidas en sus clases.

Los cuerpos cubo, cilindro y tetraedro mantienen asociaciones con figuras planas.

## 4. Funcionalidades principales

El sistema dispone de un menú interactivo con las siguientes opciones:

| Opción | Funcionalidad |
|---|---|
| 1 | Agregar una figura geométrica |
| 2 | Agregar un cuerpo geométrico |
| 3 | Listar figuras registradas |
| 4 | Listar cuerpos registrados |
| 5 | Calcular el área total |
| 6 | Calcular el perímetro total |
| 7 | Calcular el volumen total |
| 0 | Salir del programa |

El sistema valida las medidas ingresadas y utiliza MySQL para conservar las formas registradas entre ejecuciones.

## 5. Arquitectura del proyecto

El proyecto se organiza en los siguientes componentes:

| Paquete o componente | Responsabilidad |
|---|---|
| `modelo` | Clases geométricas, interfaz `Forma` y colección |
| `controlador` | Coordinación de operaciones mediante `ControladorFormas` |
| `vista` | Interacción con el usuario mediante `Menu` |
| `dao` | Acceso y persistencia de datos en MySQL |
| `Main.java` | Punto de entrada de la aplicación |
| `PruebaFormas.java` | Pruebas de cálculos geométricos |

### Clases principales

- `Forma`: interfaz que define los métodos comunes.
- `Figura`: clase abstracta para figuras geométricas.
- `Cuerpo`: clase abstracta para cuerpos geométricos.
- `Triangulo`: clase abstracta de la que heredan los tipos de triángulo.
- `FabricaTriangulos`: identifica el tipo de triángulo según sus lados.
- `Coleccion`: almacena figuras y cuerpos, y calcula los totales.
- `ControladorFormas`: coordina las operaciones del sistema.
- `FormaDAO`: interfaz para las operaciones de persistencia.
- `FormaDAOMySQL`: implementación DAO utilizando MySQL.
- `ConexionMySQL`: establece la conexión JDBC.
- `Menu`: presenta las opciones de la aplicación.

## 6. Estructura del repositorio

- `src/modelo/`: clases de figuras y cuerpos geométricos.
- `src/controlador/`: controlador de la aplicación.
- `src/vista/`: menú interactivo.
- `src/dao/`: interfaz DAO, implementación MySQL y conexión JDBC.
- `src/Main.java`: ejecución principal.
- `src/PruebaFormas.java`: pruebas geométricas.
- `database/proyecto_formas.sql`: estructura y datos de la base de datos.
- `docs/uml/ProyectoFormas_Diagramas_UML.drawio`: diagramas UML editables.
- `docs/uml/ProyectoFormas_Diagramas_UML.drawio.pdf`: diagramas UML en PDF.
- `.gitignore`: configuración de archivos excluidos de Git.

## 7. Tecnologías utilizadas

- Java.
- IntelliJ IDEA.
- MySQL 8.
- MySQL Workbench.
- JDBC y MySQL Connector/J.
- Git y GitHub.
- draw.io (diagrams.net).
- UML.

## 8. Requisitos de ejecución

Para ejecutar el proyecto se necesita:

1. Java JDK instalado y configurado. El proyecto fue desarrollado utilizando Java 26.
2. IntelliJ IDEA.
3. MySQL Server 8.
4. MySQL Connector/J disponible como dependencia JDBC del proyecto.
5. La base de datos `proyecto_formas`.
6. Las variables de entorno necesarias para conectarse a MySQL.

El repositorio no incluye contraseñas de conexión ni archivos de configuración local de IntelliJ.

## 9. Configuración de MySQL

### 9.1. Importar la base de datos

1. Abrir MySQL Workbench.
2. Conectarse al servidor MySQL.
3. Seleccionar **Server → Data Import**.
4. Elegir **Import from Self-Contained File**.
5. Seleccionar el archivo `database/proyecto_formas.sql`.
6. Ejecutar la importación.
7. Comprobar que se haya creado la base de datos `proyecto_formas` y su tabla `forma_registro`.

**Importante:** El archivo SQL incluye instrucciones para eliminar y recrear la tabla `forma_registro`. Se recomienda importarlo en un entorno de prueba o en una base de datos sin información que deba conservarse.

La exportación contiene 11 registros de ejemplo: 7 figuras y 4 cuerpos geométricos.

### 9.2. Configurar la conexión JDBC

La clase `ConexionMySQL` utiliza las siguientes variables de entorno:

| Variable | Descripción |
|---|---|
| `PF_DB_URL` | Dirección JDBC de la base de datos |
| `PF_DB_USER` | Usuario de MySQL |
| `PF_DB_PASSWORD` | Contraseña del usuario |

Ejemplo de URL JDBC:

`jdbc:mysql://localhost:3306/proyecto_formas`

En IntelliJ IDEA, estas variables pueden configurarse en **Run → Edit Configurations → Environment variables** para la configuración de ejecución de `Main`.

Las credenciales deben establecerse localmente. No deben incorporarse al código fuente ni publicarse en GitHub.

## 10. Ejecución de la aplicación

1. Descargar o clonar el repositorio.
2. Abrir la carpeta `ProyectoFormas` desde IntelliJ IDEA.
3. Configurar el JDK.
4. Agregar MySQL Connector/J a las dependencias del módulo, si todavía no está configurado.
5. Importar la base de datos MySQL.
6. Configurar `PF_DB_URL`, `PF_DB_USER` y `PF_DB_PASSWORD`.
7. Ejecutar la clase `Main.java`.
8. Utilizar el menú de consola para administrar figuras y cuerpos geométricos.

Al iniciar, el controlador recupera los registros existentes desde MySQL.

## 11. Pruebas

El proyecto incluye la clase `PruebaFormas.java`, que realiza 13 comprobaciones de cálculos y comportamiento geométrico.

Las pruebas abarcan:

- Área del círculo.
- Área del cuadrado.
- Área del rombo.
- Clasificación de triángulos.
- Volumen del cubo.
- Volumen del cilindro.
- Volumen del tetraedro.
- Volumen de la esfera.
- Área total de una colección.
- Perímetro total de una colección.
- Volumen total de una colección.

Estas pruebas pueden ejecutarse directamente desde `PruebaFormas.java`, sin necesidad de conectarse a MySQL.

Durante la validación del proyecto, las 13 pruebas finalizaron correctamente.

## 12. Diagramas UML

El directorio `docs/uml/` contiene los diagramas del proyecto.

Se documentan:

- La interfaz `Forma`.
- Las jerarquías de figuras y cuerpos geométricos.
- Las relaciones de herencia.
- Las asociaciones entre cuerpos y figuras.
- La arquitectura MVC.
- El patrón DAO y la persistencia MySQL.

Los diagramas pueden consultarse en PDF o editarse mediante draw.io.

## 13. Repositorio

**GitHub:** https://github.com/Gabriel96-G/ProyectoFormas

## 14. Contexto académico

Proyecto desarrollado como práctica del curso **SOFT-04 — Programación Orientada a Objetos**, correspondiente a la carrera de **Ingeniería de Software de la Universidad CENFOTEC**.

Su finalidad es aplicar los conocimientos del curso en el diseño, implementación y validación de un sistema orientado a objetos con persistencia en una base de datos relacional.