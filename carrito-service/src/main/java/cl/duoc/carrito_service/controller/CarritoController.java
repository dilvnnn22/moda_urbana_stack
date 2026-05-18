package cl.duoc.carrito_service.controller;

import cl.duoc.carrito_service.model.Carrito;
import cl.duoc.carrito_service.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")

public class CarritoController {

    private final CarritoService service;

    public CarritoController(CarritoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carrito> listar() {
        return service.listar();
    }

    @PostMapping
    public Carrito guardar(@RequestBody Carrito carrito) {
        return service.guardar(carrito);
    }

    @GetMapping("/{id}")
    public Carrito buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
