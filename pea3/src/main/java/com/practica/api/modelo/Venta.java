package com.practica.api.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "venta")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idventa;
	

	@Positive(message = "El total debe ser mayor que cero")
	private Double totalventa;

	@Column(name="fechaventa")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	private String status;
	
	@NotNull(message = "El empleado no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idempleado")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Empleado empleado;
	
	@NotNull(message = "El empleado no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcliente")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Cliente cliente;
	
}
