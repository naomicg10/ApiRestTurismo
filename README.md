# ApiRestTurismo

#Recursos Utilizados<br>
He utilizado una base de datos en la que represento una tabla de Museos con su insert de 20 museos de Málaga y otra tabla de Eventos con su insert de 20 eventos de Málaga, aparte tengo otra tabla de Usuarios con su insert de 5 usuarios con tokens de seguridad.

#EndsPoints
MuseoController:
    @GetMapping("/get/")
    @GetMapping("/getId/{id}")
    @GetMapping("/getNombre/{nombre}")
    @GetMapping("/getDireccion/{direccion}")
    @GetMapping("/getUrl/{url}")
    @GetMapping("/getEmail/{email}")
    @GetMapping("/getTitularidad/{titularidad}")
    @PostMapping("/post/{email}")
    @PutMapping("/put/{id}/{email}")
    @DeleteMapping("/delete/{id}/{email}")
    
EventoController:
    @GetMapping("/get/")
    @GetMapping("/getId/{id}")
    @GetMapping("/getNombre/{nombre}")
    @GetMapping("/getDescripcion/{descripcion}")
    @GetMapping("/getFecha/{fecha}")
    @GetMapping("/getLugar/{lugar}")
    @GetMapping("/getDireccion/{direccion}")
    @GetMapping("/getUrl/{url}")
    @GetMapping("/getEmail/{email}")
    @GetMapping("/getCategoria/{categoria}")
    @GetMapping("/getPrecio/{precio}")
    @PostMapping("/post/{email}")
    @PutMapping("/put/{id}/{email}")
    @DeleteMapping("/delete/{id}/{email}")
    
#Ejemplos de respuesta:
MuseoController:
GET http://localhost:8080/museos/get/

{
    "id": 15,
    "nombre": "Museo Picasso Málaga",
    "direccion": "CALLE SAN AGUSTÍN, 8",
    "url": "http://www.museopicassomalaga.org",
    "email": "info@museopicassomalaga.org",
    "titularidad": "PRIVADA"
  }
  
POST http://localhost:8080/museos/post/tony@gmail.com?token=KAEVINLACIWK
Content-Type: application/json

{
  "nombre": "Nuevo Nombre del Museo",
  "direccion": "Nueva Dirección del Museo",
  "url": "Nueva URL del Museo",
  "email": "nuevomuseo@exemple.com",
  "titularidad": "Nueva Titularidad del Museo"
}
Museo creado con éxito

PUT http://localhost:8080/museos/put/21/tony@gmail.com?token=KAEVINLACIWK
Content-Type: application/json

{
  "id": 21,
  "nombre": "Nuevo Museo",
  "direccion": "Nueva Dirección",
  "url": "Nueva URL",
  "email": "nuevomuseo@exemple.com",
  "titularidad": "Nueva Titularidad"
}
{
  "id": 21,
  "nombre": "Nuevo Museo",
  "direccion": "Nueva Dirección",
  "url": "Nueva URL",
  "email": "nuevomuseo@exemple.com",
  "titularidad": "Nueva Titularidad"
}
Response file saved.

DELETE http://localhost:8080/museos/delete/21/tony@gmail.com?token=KAEVINLACIWK
Museo eliminado correctamente

EventoController:
GET http://localhost:8080/eventos/get/

{
    "id": 10,
    "nombre": "Feria de Málaga 2024",
    "descripcion": "La feria más grande de la ciudad con música, baile, y diversión para toda la familia.",
    "fecha": "2024-08-15 12:00:00",
    "lugar": "Centro Histórico",
    "direccion": "Centro Histórico",
    "url": "http://www.feriamalaga.es",
    "email": "info@feriamalaga.es",
    "categoria": "Festivales",
    "precio": 0.0
  }
  
POST http://localhost:8080/eventos/post/tony@gmail.com?token=KAEVINLACIWK
Content-Type: application/json

{
    "nombre": "Nuevo Nombre del Evento",
    "descripcion": "Nueva Descripcion del Evento",
    "fecha": "Nueva Fecha del Evento",
    "lugar": "Nuevo Lugar del Evento",
    "direccion": "Nueva Dirección del Evento",
    "url": "Nueva URL del Evento",
    "email": "nuevoevento@exemple.com",
    "categoria": "Nueva Categoria del Evento",
    "precio": 0.0
 }
Evento creado con éxito

PUT http://localhost:8080/eventos/put/21/tony@gmail.com?token=KAEVINLACIWK
Content-Type: application/json

{
  "id": 21,
  "nombre": "Nuevo Nombre",
  "descripcion": "Nueva Descripcion",
  "fecha": "Nueva Fecha",
  "lugar": "Nuevo Lugar",
  "direccion": "Nueva Dirección",
  "url": "Nueva URL",
  "email": "nuevoevento@exemple.com",
  "categoria": "Nueva Categoria",
  "precio": 0.0
}
{
  "id": 21,
  "nombre": "Nuevo Nombre",
  "descripcion": "Nueva Descripcion",
  "fecha": "Nueva Fecha",
  "lugar": "Nuevo Lugar",
  "direccion": "Nueva Dirección",
  "url": "Nueva URL",
  "email": "nuevoevento@exemple.com",
  "categoria": "Nueva Categoria",
  "precio": 0.0
}
Response file saved.

DELETE http://localhost:8080/eventos/delete/21/tony@gmail.com?token=KAEVINLACIWK
Evento eliminado correctamente
