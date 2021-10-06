package com.bid.demo.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bid.demo.dao.PedidoDAO;
import com.bid.demo.models.Detalle;
import com.bid.demo.models.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PedidoDAO pedidoDAO;

	@Override
	public List<Pedido> obtenerPedidos() {
		try {
			List<Pedido> listaPedido = pedidoDAO.findAll();			
			return listaPedido;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public Pedido guardarPedido(Pedido pedido) {
		try {
			Long iddetalleSig = pedidoDAO.obtenerIdMaximoDetalle();
			pedido.setId(pedidoDAO.obtenerIdMaximoPedido());
			
			/*
			pedido.getLista().forEach(x -> {
				x.setPedido(pedido);
				x.setIddetalle(iddetalleSig);
				iddetalleSig++;
			});*/
			for(Detalle det : pedido.getLista()) {
				det.setPedido(pedido);
				det.setIddetalle(iddetalleSig);
				iddetalleSig = iddetalleSig +1;
			}
			Pedido pedidoSave = pedidoDAO.save(pedido);			
			return pedidoSave;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
	}
	
	@Override
	public Pedido acualizarPedido(Pedido pedido) {
		try {
			pedido.getLista().forEach(x -> {
				x.setPedido(pedido);
			});
			Pedido pedidoSave = pedidoDAO.save(pedido);	
			return pedidoSave;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public Pedido obtenerPedidoXId(Long id) {
		try {
			Pedido pedido = pedidoDAO.findById(id).orElse(new Pedido());			
			return pedido;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public Long obtenerIdMaximo() {
		try {
			Long id = pedidoDAO.obtenerIdMaximoPedido();			
			return id;
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			return 0L;
		}
	}


	
	
	
}
