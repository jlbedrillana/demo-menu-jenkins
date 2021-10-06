package com.bid.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Pedido {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(columnDefinition = "serial")
    private Long id;
	
	@Column
    private Integer nromesa;
	
	@Column(length = 100)
    private String denominacion;
	
	@Column(length = 500)
    private String detalle;
	
	@Column
    private Integer estado;
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval=true)
	@JsonIgnoreProperties("pedido")
	private List<Detalle> lista = new ArrayList<Detalle>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNromesa() {
		return nromesa;
	}

	public void setNromesa(Integer nromesa) {
		this.nromesa = nromesa;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<Detalle> getLista() {
		return lista;
	}

	public void setLista(List<Detalle> lista) {
		this.lista = lista;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
}
