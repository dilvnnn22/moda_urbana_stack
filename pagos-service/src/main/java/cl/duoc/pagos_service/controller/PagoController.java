package cl.duoc.pagos_service.controller;

import cl.duoc.pagos_service.model.Pago;
import cl.duoc.pagos_service.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")

public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pago> listar() {
        return service.listar();
    }

    @PostMapping
    public Pago guardar(@RequestBody Pago pago) {
        return service.guardar(pago);
    }

    @GetMapping("/{id}")
    public Pago buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}