package com.practica3.api.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "detallecompra")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetalleCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetallecompra;
	@Positive(message = "La cantidad debe ser mayor que cero")
	private Integer cantidad;
	@Positive(message = "el IGV debe ser mayor que cero")
	private Double igv;
	@Positive(message = "El Subtotal debe ser mayor que cero")
	private Double subtotal;
	private String status;
	
	@NotNull(message = "El empleado no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcompra")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Compra compra;
	
	@NotNull(message = "La compra no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idproducto")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Producto producto;
}