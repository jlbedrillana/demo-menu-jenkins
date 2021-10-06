package com.bid.demo.models;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {

	@Id
    private Long idmenu;
	
	@Column(length = 100)
    private String menu;
	
	@Column
    private BigInteger costo;

	public Long getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(Long idmenu) {
		this.idmenu = idmenu;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public BigInteger getCosto() {
		return costo;
	}

	public void setCosto(BigInteger costo) {
		this.costo = costo;
	}
	
	
}
