Objetivo:
Permitir al dueño de la empresa administrar usuarios del sistema (crear, ver, editar y eliminar), para gestionar correctamente el acceso y los horarios laborales.
Documentación funcional actual:
• Crear usuario: recibe nombreCompleto, correoElectronico, rol, horaEntrada, horaSalida y genera un nuevo registro.
• Consultar usuarios:
  – Listar todos.
  – Filtrar por Rol.
  – Obtener un usuario por ID.
• Actualizar usuario: permite modificar cualquier campo excepto el id.
• Eliminar usuario: elimina el registro por id.
• Validación: se verifica que e-mail, longitudes y rangos numéricos sean válidos.

Documentación técnica:

Arquitectura:
• Java 17
• Maven
• Spring Data JPA
• Base de datos H2 (modo memoria, solo pruebas)

Endpoints:

GET	/api/usuario—---------------------LISTAR TODOS LOS USUARIOS

GET	/api/usuario/rol/{rol}-------------OBTENER USUARIO POR ROL

GET	/api/usuario/{id}------------------OBTENER USUARIO POR ID

POST	/api/usuario—--------------------CREAR UN NUEVO USUARIO

PUT	/api/usuario/{id}------------------ACTUALIZAR UN USUARIO

DELETE	/api/usuario/{id}--------ELIMINAR UN USUARIO


Acceder a la Base de Datos:
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
Usuario: sa
Contraseña: (vacía)

Swagger: http://localhost:8080/swagger-ui/index.html

Pasos para ejecutar:
1. Clonar repo: git clone https://github.com/<tu-usuario>/api-usuario.git
2. Entrar al proyecto: cd api-usuario
3. Ejecutar: mvn spring-boot:run o desde el IDE.
4. Probar con Postman/Insomnia o curl.

Enlaces:

https://trello.com/b/y7gSOZTP/utn
https://github.com/xiara15/ProyMetodolog-a


Escalabilidad:	
• Implementar paginación y búsqueda por más criterios (e-mail, rango horario).
• Añadir autenticación y control granular de roles.
• Migrar a una base de datos persistente (PostgreSQL/MySQL).
• Crear un frontend (React/Angular) para administración.
• Contenerizar con Docker y preparar despliegue CI/CD.

