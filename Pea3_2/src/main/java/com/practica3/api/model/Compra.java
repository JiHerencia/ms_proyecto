package com.practica3.api.model;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "compra")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcompra;
	
	@Column(name="fechacompra")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	private Double totalcompra;
	
	@NotEmpty(message = "El estado no debe estar vacio")
	private String estadocompra;
	private String status;
	
	/*@NotNull(message = "El empleado no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idempleado")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Empleado empleado;*/
	
	@NotNull(message = "El Proveedor no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idproveedor")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Proveedor proveedor;
}

