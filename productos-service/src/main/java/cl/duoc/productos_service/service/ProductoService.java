package cl.duoc.productos_service.service;

import cl.duoc.productos_service.dto.ProductoDTO;
import cl.duoc.productos_service.model.Producto;
import cl.duoc.productos_service.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<ProductoDTO> listadoDTO() {

        return repository.findAll()
                .stream()
                .map(producto -> new ProductoDTO(
                        producto.getNombre(),
                        producto.getPrecio()
                ))
                .collect(Collectors.toList());
    }

    public List<Producto> buscarPorPrecio(Double precio) {

        return repository.findByPrecioLessThan(precio);
    }

    public List<Producto> stockBajo(Integer stock) {

        return repository.findByStockLessThan(stock);
    }

    public List<Producto> buscarPorMarca(Long marcaId) {

        return repository.findByMarcaId(marcaId);
    }

    public List<Producto> buscarPorCategoria(Long categoriaId) {

        return repository.findByCategoriaId(categoriaId);
    }
}