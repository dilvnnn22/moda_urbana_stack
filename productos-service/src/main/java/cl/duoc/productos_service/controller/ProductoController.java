package cl.duoc.productos_service.controller;

import cl.duoc.productos_service.dto.ProductoDTO;
import cl.duoc.productos_service.model.Producto;
import cl.duoc.productos_service.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto) {
        return service.guardar(producto);
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/listado")

    public List<ProductoDTO> listadoDTO() {

        return service.listadoDTO();
    }

    @GetMapping("/precio/{precio}")

    public List<Producto> precio(@PathVariable Double precio) {

        return service.buscarPorPrecio(precio);
    }

    @GetMapping("/stock/{stock}")

    public List<Producto> stock(@PathVariable Integer stock) {

        return service.stockBajo(stock);
    }

    @GetMapping("/marca/{marcaId}")

    public List<Producto> marca(@PathVariable Long marcaId) {

        return service.buscarPorMarca(marcaId);
    }

    @GetMapping("/categoria/{categoriaId}")

    public List<Producto> categoria(@PathVariable Long categoriaId) {

        return service.buscarPorCategoria(categoriaId);
    }
}