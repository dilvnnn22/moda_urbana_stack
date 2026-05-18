# Proyecto Moda Urbana - Arquitectura de Microservicios

## Descripción del Proyecto

Este proyecto consiste en el desarrollo de una arquitectura basada en microservicios para una tienda de moda urbana. El sistema permite gestionar productos, clientes, pedidos, pagos, inventario, carrito de compras, categorías y marcas mediante servicios independientes desarrollados con Spring Boot.

La solución implementa una arquitectura distribuida utilizando Spring Cloud, Eureka Server, API Gateway, OpenFeign, Flyway y MySQL, permitiendo una comunicación eficiente entre microservicios y una administración centralizada.

---

# Problemática

Las tiendas de moda urbana necesitan administrar grandes volúmenes de información relacionados con productos, clientes, pedidos y pagos. 

En una arquitectura monolítica, todos los módulos se encuentran acoplados, lo que genera problemas como:

- dificultad para escalar el sistema
- baja mantenibilidad
- problemas de rendimiento
- dificultad para desplegar cambios
- fallos globales ante errores de un módulo

Debido a esto, se decidió implementar una arquitectura de microservicios que permita separar responsabilidades y mejorar la escalabilidad y mantenimiento del sistema.

---

# Solución Propuesta

Se desarrolló una arquitectura basada en microservicios donde cada módulo funciona de manera independiente.

La solución incorpora:

- descubrimiento de servicios mediante Eureka Server
- centralización de peticiones usando API Gateway
- configuración centralizada con Config Server
- comunicación entre microservicios mediante OpenFeign
- persistencia de datos usando MySQL
- migraciones automáticas con Flyway
- separación por capas utilizando buenas prácticas

---

# Tecnologías Utilizadas

- Java 21
- Spring Boot
- Spring Cloud
- Eureka Server
- API Gateway
- OpenFeign
- Spring Data JPA
- Validation
- Lombok
- Flyway
- MySQL
- Maven
- Git
- GitHub
- IntelliJ IDEA
- XAMPP

---

# Arquitectura del Proyecto

El sistema está compuesto por los siguientes microservicios:

| Microservicio | Descripción |
|---|---|
| eureka-service | Registro y descubrimiento de servicios |
| config-server | Configuración centralizada |
| api-gateway | Punto de entrada principal |
| productos-service | Gestión de productos |
| clientes-service | Gestión de clientes |
| pedidos-service | Gestión de pedidos |
| pagos-service | Gestión de pagos |
| carrito-service | Gestión del carrito de compras |
| inventario-service | Gestión de inventario |
| marcas-service | Gestión de marcas |
| categorias-service | Gestión de categorías |

---

# Puertos Utilizados

| Servicio | Puerto |
|---|---|
| Eureka Server | 8761 |
| Config Server | 8888 |
| API Gateway | 8090 |
| productos-service | 8081 |
| clientes-service | 8082 |
| categorias-service | 8083 |
| marcas-service | 8084 |
| pedidos-service | 8085 |
| inventario-service | 8086 |
| carrito-service | 8087 |
| pagos-service | 8088 |

---

# Funcionalidades Implementadas

## CRUD Completo

Todos los microservicios principales implementan:

- crear
- listar
- buscar
- actualizar
- eliminar

---

# DTOs

Se implementaron DTOs para entregar información resumida y personalizada.

Ejemplo:

```json
{
  "nombreProducto": "Polera Oversize",
  "precio": 19990
}
