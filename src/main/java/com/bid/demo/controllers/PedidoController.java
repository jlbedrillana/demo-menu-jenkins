package com.bid.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bid.demo.models.Pedido;
import com.bid.demo.services.PedidoService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/demo/pedidos")
public class PedidoController {

	@Autowired
    private PedidoService pedidoService;
	
	@GetMapping
	public List<Pedido> getTodosPedidos(){
		return pedidoService.obtenerPedidos();
	}
	
	@GetMapping("/{id}")
	public Pedido obtenerPedido(@PathVariable("id") Long id) {
		return pedidoService.obtenerPedidoXId(id);
	}
	
	@GetMapping("/maximo")
	public Long obtenerIdMaximo() {
		return pedidoService.obtenerIdMaximo();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Pedido saveProduct(@RequestBody Pedido pedido){
        return pedidoService.guardarPedido(pedido);
    }
	
	@ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Pedido updateProduct(@RequestBody Pedido pedido){
        return pedidoService.acualizarPedido(pedido);
    }
	
}
