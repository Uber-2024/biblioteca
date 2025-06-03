# Sistema Simplificado de Gestión de Biblioteca

Este proyecto es una API RESTful desarrollada con Spring Boot para la gestión básica de una biblioteca. Permite realizar operaciones CRUD sobre libros y realizar búsquedas, aplicando buenas prácticas de arquitectura por capas, principios SOLID, validación de datos y documentación automática con OpenAPI.

## Características

- **CRUD de libros:** Crear, leer, actualizar y eliminar libros.
- **Búsqueda:** Buscar libros por título.
- **Validación:** Validación de datos de entrada usando Java Validation API.
- **Documentación:** Documentación automática y exploración de la API con Swagger UI.
- **Persistencia en base de datos Postgres:** Los datos se almacenan en una base datos creada en Postgres
- **Arquitectura limpia:** Separación en capas (MVC controlador, servicio, repositorio).
- **Principios SOLID:** Aplicación de buenas prácticas de diseño orientado a objetos.

## Tecnologías utilizadas

- Java 21
- Spring Boot 3
- Spring Web
- Spring Data JPA 
- Lombok
- Hibernate Validator
- Springdoc OpenAPI UI (Swagger)
- Postgres jdbc
- Maven

## Instalación y ejecución

1. **Clona el repositorio:**
   ```sh
   git clone https://github.com/Uber-2024/biblioteca.git
   cd biblioteca
   ```

2. **Compila y ejecuta la aplicación:**
   ```sh
   ./mvnw spring-boot:run
   ```
   O en Windows:
   ```sh
   mvnw.cmd spring-boot:run
   ```

3. **Accede a la documentación interactiva:**
   - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Uso de la API

### Endpoints principales

- `GET /api/books`  
  Obtiene todos los libros.

- `GET /api/books/{id}`  
  Obtiene un libro por su ID.

- `POST /api/books`  
  Crea un nuevo libro.  
  **Ejemplo de cuerpo JSON:**
  ```json
  {
    "title": "El Quijote",
    "author": "Miguel de Cervantes",
    "isbn": "1234567890",
    "genre": "Novela",
    "publishedDate": "1605-01-16",
    "status": "AVAILABLE"
  }
  ```

- `PUT /api/books/{id}`  
  Actualiza un libro existente.

- `DELETE /api/books/{id}`  
  Elimina un libro por su ID.

- `GET /api/books/buscar?title=texto`  
  Busca libros cuyo título contenga el texto indicado.

## Notas importantes

- **Persistencia en una base de datos:** Todos los datos se almacenan en una base de datos creada en Postgres.
- **Validación:** Los campos obligatorios y formatos se validan automáticamente. Si envías datos inválidos, recibirás un error 400 con detalles.
- **Documentación:** Puedes probar todos los endpoints y ver los modelos de datos en Swagger UI.

## Estructura del proyecto

- `controllers/` – Controladores REST.
- `services/` – Lógica de negocio.
- `repositories/` – Simulación de persistencia (puedes implementar aquí una colección en memoria).
- `models/` – Entidades y DTOs.

## Contribución

¡Las contribuciones son bienvenidas! Por favor, abre un issue o pull request para sugerencias o mejoras.

## Licencia

Este proyecto está bajo la licencia Apache 2.0.

---

