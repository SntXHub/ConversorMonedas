
# **Conversor de Monedas - Proyecto Java**

## **Descripción**

El **Conversor de Monedas** es una aplicación de consola desarrollada en **Java 17** que permite realizar conversiones de monedas de manera sencilla y eficiente. Utiliza la API de ExchangeRate-API para obtener tasas de conversión en tiempo real, y ofrece una interfaz de línea de comandos para interactuar con el usuario.

### Nota de versión

**Versión: v1.0.0**
- Primera versión funcional del Conversor de Monedas.
- Funcionalidades incluidas:
    - Conversión entre 8 monedas distintas.
    - Actualización de tasas de conversión en tiempo real mediante la API ExchangeRate-API.
    - Interfaz de usuario basada en consola con un menú principal.
- Estructura del proyecto diseñada siguiendo buenas prácticas de programación en Java.

### Tecnologías Utilizadas

El proyecto se desarrolló utilizando las siguientes tecnologías y herramientas:

- **Java 17**: Lenguaje principal de programación utilizado.
- **IntelliJ IDEA Community Edition**: Entorno de desarrollo integrado (IDE) para la creación y edición del proyecto.
- **Librería GSON**: Utilizada para manejar la serialización y deserialización de objetos JSON.
- **ExchangeRate-API**: API externa para obtener las tasas de conversión de monedas en tiempo real.
- **Git y GitHub**: Para el control de versiones y la colaboración en el proyecto.

### **Monedas disponibles:**
- Peso Argentino (ARS)
- Real Brasileño (BRL)
- Peso Mexicano (MXN)
- Sol Peruano (PEN)
- Bolívar Soberano (VES)
- Dólar Estadounidense (USD)
- Euro (EUR)
- Yuan Chino (CNY)

## **Características del Proyecto**
- Conversión de monedas entre las monedas disponibles.
- Actualización en tiempo real de las tasas de conversión utilizando la API **ExchangeRate-API**.
- Interfaz de usuario interactiva en consola.
- Funcionalidad de visualización de las monedas disponibles.
- Opción para actualizar las tasas de conversión a tiempo real.

## **Instrucciones de Uso**

1. **Clonar el repositorio:**

   Para comenzar, clona el repositorio en tu máquina local con el siguiente comando:
   ```bash
   git clone https://github.com/usuario/ConversorMonedas.git
   ```

2. **Configuración de la clave de la API:**
   - Debes reemplazar `"tuclaveAPI"` en el archivo `ServicioConversion.java` con la clave que obtuviste de 
     [ExchangeRate-API](https://www.exchangerate-api.com/).

3. **Ejecutar el programa:**
   - Abre la terminal o consola en la carpeta del proyecto.
   - Compila el código fuente:
     ```bash
     javac *.java
     ```
   - Ejecuta el programa:
     ```bash
     java MenuPrincipal
     ```
   - Se mostrará un menú interactivo en la consola, donde podrás seleccionar entre las opciones disponibles:
     - Convertir monedas
     - Mostrar monedas disponibles
     - Actualizar tasas de conversión
     - Salir

4. **Interacción con el menú:**
   - El usuario podrá elegir la opción de conversión de monedas, seleccionar la moneda de origen y destino, y realizar la conversión con una cantidad especificada.
   - La opción "Actualizar tasas de conversión" actualiza las tasas en tiempo real.

## **Estructura del Proyecto**

```
ConversorMonedas/
├── MenuPrincipal.java
├── ConversorMonedas.java
├── Moneda.java
├── ServicioConversion.java
├── README.md
```

## **Desarrollador**
- **Santiago Gabriel Cabrera**
  - Desarrollador principal del proyecto.

## **Colaboradores**
Agradecimientos a todos los colaboradores que han ayudado a hacer realidad este proyecto.

## **Notas adicionales**

- **API de ExchangeRate-API:** Este proyecto utiliza la API de ExchangeRate-API para obtener tasas de conversión en tiempo real. Asegúrate de tener una clave válida para utilizar el servicio.
- **Compatibilidad:** El proyecto es compatible con cualquier sistema operativo que soporte **Java 17**.

### **Instalación de dependencias adicionales**

Si decides agregar más dependencias en el futuro, puedes incluir instrucciones detalladas aquí. Por ejemplo, si agregas una biblioteca para la interfaz gráfica o herramientas adicionales, solo indica cómo se instalan y configuran.


### **Licencia**

Este proyecto está licenciado bajo la Licencia MIT.


### **Contactos y Soporte**

Si tienes alguna duda o necesitas soporte adicional, no dudes en ponerte en contacto :)
