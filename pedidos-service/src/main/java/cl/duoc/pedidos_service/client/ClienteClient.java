package cl.duoc.pedidos_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "clientes-service")

public interface ClienteClient {

    @GetMapping("/clientes/{id}")

    Map<String, Object> obtenerCliente(@PathVariable Long id);
}
