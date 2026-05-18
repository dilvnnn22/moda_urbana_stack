package cl.duoc.pedidos_service.service;

import cl.duoc.pedidos_service.client.ClienteClient;
import cl.duoc.pedidos_service.client.ProductoClient;
import cl.duoc.pedidos_service.model.Pedido;
import cl.duoc.pedidos_service.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class PedidoService {

    private final PedidoRepository repository;

    private final ClienteClient clienteClient;

    private final ProductoClient productoClient;

    public PedidoService(PedidoRepository repository,
                         ClienteClient clienteClient,
                         ProductoClient productoClient) {

        this.repository = repository;
        this.clienteClient = clienteClient;
        this.productoClient = productoClient;
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }

    public Pedido guardar(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Map<String, Object> obtenerDetalle(Long id) {

        Pedido pedido = repository.findById(id).orElse(null);

        Map<String, Object> cliente =
                clienteClient.obtenerCliente(pedido.getClienteId());

        Map<String, Object> producto =
                productoClient.obtenerProducto(pedido.getProductoId());

        Map<String, Object> respuesta = new HashMap<>();

        respuesta.put("pedido", pedido);

        respuesta.put("cliente", cliente);

        respuesta.put("producto", producto);

        return respuesta;
    }
}