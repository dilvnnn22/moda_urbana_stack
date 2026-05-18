package cl.duoc.marcas_service.controller;

import cl.duoc.marcas_service.dto.MarcaDTO;
import cl.duoc.marcas_service.model.Marca;
import cl.duoc.marcas_service.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")

public class MarcaController {

    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Marca> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Marca buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping
    public Marca guardar(@RequestBody Marca marca) {
        return service.guardar(marca);
    }

    @PutMapping("/{id}")
    public Marca actualizar(@PathVariable Long id,
                            @RequestBody Marca marca) {
        marca.setId(id);
        return service.guardar(marca);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/listado")
    public List<MarcaDTO> listado() {
        return service.listadoDTO();
    }
}
