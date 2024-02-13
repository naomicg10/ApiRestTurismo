# ApiRestTurismo

#Recursos Utilizados<br>
He utilizado una base de datos en la que represento una tabla de Museos con su insert de 20 museos de Málaga y otra tabla de Eventos con su insert de 20 eventos de Málaga, aparte tengo otra tabla de Usuarios con su insert de 5 usuarios con tokens de seguridad.<br>
<br>
#EndsPoints<br>
MuseoController:<br>
    @GetMapping("/get/")<br>
    @GetMapping("/getId/{id}")<br>
    @GetMapping("/getNombre/{nombre}")<br>
    @GetMapping("/getDireccion/{direccion}")<br>
    @GetMapping("/getUrl/{url}")<br>
    @GetMapping("/getEmail/{email}")<br>
    @GetMapping("/getTitularidad/{titularidad}")<br>
    @PostMapping("/post/{email}")<br>
    @PutMapping("/put/{id}/{email}")<br>
    @DeleteMapping("/delete/{id}/{email}")<br>
<br>    
EventoController:<br>
    @GetMapping("/get/")<br>
    @GetMapping("/getId/{id}")<br>
    @GetMapping("/getNombre/{nombre}")<br>
    @GetMapping("/getDescripcion/{descripcion}")<br>
    @GetMapping("/getFecha/{fecha}")<br>
    @GetMapping("/getLugar/{lugar}")<br>
    @GetMapping("/getDireccion/{direccion}")<br>
    @GetMapping("/getUrl/{url}")<br>
    @GetMapping("/getEmail/{email}")<br>
    @GetMapping("/getCategoria/{categoria}")<br>
    @GetMapping("/getPrecio/{precio}")<br>
    @PostMapping("/post/{email}")<br>
    @PutMapping("/put/{id}/{email}")<br>
    @DeleteMapping("/delete/{id}/{email}")<br>
<br>    
#Ejemplos de respuesta:<br>
MuseoController:<br>
GET http://localhost:8080/museos/get/<br>
<br>
{<br>
    "id": 15,<br>
    "nombre": "Museo Picasso Málaga",<br>
    "direccion": "CALLE SAN AGUSTÍN, 8",<br>
    "url": "http://www.museopicassomalaga.org",<br>
    "email": "info@museopicassomalaga.org",<br>
    "titularidad": "PRIVADA"<br>
  }<br>
<br>  
POST http://localhost:8080/museos/post/tony@gmail.com?token=KAEVINLACIWK<br>
Content-Type: application/json<br>
<br>
{<br>
  "nombre": "Nuevo Nombre del Museo",<br>
  "direccion": "Nueva Dirección del Museo",<br>
  "url": "Nueva URL del Museo",<br>
  "email": "nuevomuseo@exemple.com",<br>
  "titularidad": "Nueva Titularidad del Museo"<br>
}<br>
Museo creado con éxito<br>
<br>
PUT http://localhost:8080/museos/put/21/tony@gmail.com?token=KAEVINLACIWK<br>
Content-Type: application/json<br>
<br>
{<br>
  "id": 21,<br>
  "nombre": "Nuevo Museo",<br>
  "direccion": "Nueva Dirección",<br>
  "url": "Nueva URL",<br>
  "email": "nuevomuseo@exemple.com",<br>
  "titularidad": "Nueva Titularidad"<br>
}<br>
{<br>
  "id": 21,<br>
  "nombre": "Nuevo Museo",<br>
  "direccion": "Nueva Dirección",<br>
  "url": "Nueva URL",<br>
  "email": "nuevomuseo@exemple.com",<br>
  "titularidad": "Nueva Titularidad"<br>
}<br>
Response file saved.<br>
<br>
DELETE http://localhost:8080/museos/delete/21/tony@gmail.com?token=KAEVINLACIWK<br>
Museo eliminado correctamente<br>
<br>
EventoController:<br>
GET http://localhost:8080/eventos/get/<br>
<br>
{<br>
    "id": 10,<br>
    "nombre": "Feria de Málaga 2024",<br>
    "descripcion": "La feria más grande de la ciudad con música, baile, y diversión para toda la familia.",<br>
    "fecha": "2024-08-15 12:00:00",<br>
    "lugar": "Centro Histórico",<br>
    "direccion": "Centro Histórico",<br>
    "url": "http://www.feriamalaga.es",<br>
    "email": "info@feriamalaga.es",<br>
    "categoria": "Festivales",<br>
    "precio": 0.0<br>
  }<br>
<br>
POST http://localhost:8080/eventos/post/tony@gmail.com?token=KAEVINLACIWK<br>
Content-Type: application/json<br>
<br>
{<br>
    "nombre": "Nuevo Nombre del Evento",<br>
    "descripcion": "Nueva Descripcion del Evento",<br>
    "fecha": "Nueva Fecha del Evento",<br>
    "lugar": "Nuevo Lugar del Evento",<br>
    "direccion": "Nueva Dirección del Evento",<br>
    "url": "Nueva URL del Evento",<br>
    "email": "nuevoevento@exemple.com",<br>
    "categoria": "Nueva Categoria del Evento",<br>
    "precio": 0.0<br>
 }<br>
Evento creado con éxito<br>
<br>
PUT http://localhost:8080/eventos/put/21/tony@gmail.com?token=KAEVINLACIWK<br>
Content-Type: application/json<br>
<br>
{<br>
  "id": 21,<br>
  "nombre": "Nuevo Nombre",<br>
  "descripcion": "Nueva Descripcion",<br>
  "fecha": "Nueva Fecha",<br>
  "lugar": "Nuevo Lugar",<br>
  "direccion": "Nueva Dirección",<br>
  "url": "Nueva URL",<br>
  "email": "nuevoevento@exemple.com",<br>
  "categoria": "Nueva Categoria",<br>
  "precio": 0.0<br>
}<br>
{<br>
  "id": 21,<br>
  "nombre": "Nuevo Nombre",<br>
  "descripcion": "Nueva Descripcion",<br>
  "fecha": "Nueva Fecha",<br>
  "lugar": "Nuevo Lugar",<br>
  "direccion": "Nueva Dirección",<br>
  "url": "Nueva URL",<br>
  "email": "nuevoevento@exemple.com",<br>
  "categoria": "Nueva Categoria",<br>
  "precio": 0.0<br>
}<br>
Response file saved.<br>
<br>
DELETE http://localhost:8080/eventos/delete/21/tony@gmail.com?token=KAEVINLACIWK<br>
Evento eliminado correctamente<br>
