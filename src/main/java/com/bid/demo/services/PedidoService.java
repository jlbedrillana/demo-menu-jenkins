package com.bid.demo.services;

import java.util.List;

import com.bid.demo.models.Pedido;

public interface PedidoService {

	List<Pedido> obtenerPedidos();
	
	Pedido guardarPedido(Pedido pedido);
	
	Pedido acualizarPedido(Pedido pedido);
	
	Pedido obtenerPedidoXId(Long id);
	
	Long obtenerIdMaximo();
}
