# Actividad Parcial

## Objetivo

El Objetivo de esta asignación es que el estudiante se enfrente a los conceptos vistos durante el parcial y puedo aplicarlos a un proyecto simple que le de práctica y seguridad para aplicarlos en proyectos propios bajos sus propias arquitecturas y metodologías.

## Instrucciones

A partir del proyecto del Pokedex que se ha venido realizando a través del parcial, y cuyo código al día estará en este mismo repositorio se pide lo siguiente.

Realizar la vista de detalle para cada uno de los pokemon utilizando la referencia del API para un pokemon en específico. Ej. [https://pokeapi.co/api/v2/pokemon/1/](https://pokeapi.co/api/v2/pokemon/1/)

El resumen del resultado de dicha llamada devolverá lo siguiente:
```json
{
  "abilities": [],
  "base_experience": 64,
  "forms": [],
  "game_indices": [],
  "height": 7,
  "held_items": [],
  "id": 1,
  "is_default": true,
  "location_area_encounters": "https://pokeapi.co/api/v2/pokemon/1/encounters",
  "moves": [],
  "name": "bulbasaur",
  "order": 1,
  "species": {
    "name": "bulbasaur",
    "url": "https://pokeapi.co/api/v2/pokemon-species/1/"
  },
  "sprites": {
    "back_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png",
    "back_female": null,
    "back_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/1.png",
    "back_shiny_female": null,
    "front_default": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
    "front_female": null,
    "front_shiny": "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png",
    "front_shiny_female": null
  },
  "stats": [],
  "types": [],
  "weight": 69
}
```
## Evaluación

El formato de desarrollo de la vista de detalle será abierto debiendo contener al menos los siguientes requerimientos:

* 1 Sola vista adicional al proyecto
* Diseño basado en Material Design para Android (colores, distribuciones, tipografías, etc.)
* Se deberán incorporar al menos los siguientes elementos del API: 
	* Número del Pokemon
	* Nombre del Pokemon
	* Al menos 1 sprite del pokemon
	* Lista de tipos del Pokemon
	* Estadísticas base del Pokemon
	* Listado de movimientos que puede aprender el Pokemon
* La vista debe abrirse desde la lista general de Pokemon y se hará a través de un INTENT que pase la url del detalle del Pokemon a buscar
* Optimización del detalle para funcionar en modo landscape y portrait, no se permite bloquear la vista para funcionar solo de 1 forma

### Cada detalle es individual, no se aceptarán detalles iguales que vengan de la copia de otros de internet o copia de otros compañeros. El diseño es tuyo date el tiempo de trabajarlo y planearlo. Casos de este tipo pueden derivar en FIA.

## Formato de entrega

Se deberá entregar a través del repositorio entregado en github classroom.

El repositorio deberá contener lo siguiente:

* Código fuente del proyecto
* Archivo .APK firmado para instalación dentro del repositorio, puede ser en la raíz o la carpeta por default que genera Android Studio
* Documento en formato TXT que incluya nombre, matrícula y la respuesta a las siguientes preguntas: ¿Qué fue lo que más se te facilitó de la implementación de la vista? ¿Qué fue lo que más se te dificultó de la implementación de la vista?

## Comandos GitHub Entregable

Si tienes algún problema para subir tu actividad al repositorio, favor de notificar al profesor con tiempo antes para revisar el caso.

Si tienes problemas con los comandos no olvides que son los siguientes

| Comando | Descripión |
| ------- | ----------- |
| `git status` | Checa el estatus de cambios de tu repositorio |
| `git pull` | Baja los últimos cambios del repositorio |
| `git add [file-name.txt]` | Agrega un archivo para subir |
| `git add -A` | Agrega todos los archivos con cambios detectados |
| `git commit -m "[commit message]"` | Crea un commit con un mensaje |
| `git push origin"` | Sube los cambios identificados con commit correspondiente de tu computadora al repositorio |

Un ciclo de actualización de cambios es el siguiente pull,status,add,commit,push

## Rúbrica

La siguiente rúbrica será utilizada para la evaluación de la actividad parcial
| Concepto                                                                  | Porcentaje    |
| :------------------------------------------------------------------------:|:-------------:|
| 1 Sola vista de detalle                                                   |  5%           |
| Diseño basado en MD                                                       | 30%           |
| Incorporación de los 6 campos solicitados del API                         | 25%           |
| La apertura del detalle es a través del INTENT con el formato solicitado  |  5%           |
| Optimización para vista en modo landscape y portrait                      | 25%           |
| Se entrega código fuente y archivo .apk firmado                           |  5%           |
| Documento de reflexión actividad                                          |  5%           |

### En caso de que al instalar el proyecto no corra el archivo .APK o al ejecutar el código fuente falle la aplicación se dara una calificación automática de 0, verifica desde antes que tus entregables funcionen correctamente para evitar detalles como en el mío si corre no se por que en el suyo no.

## Fecha de Entrega

### 19/03/2020 11:59 a través de GitHub Classroom