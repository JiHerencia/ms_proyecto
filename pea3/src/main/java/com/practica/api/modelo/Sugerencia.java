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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sugerencia")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sugerencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsugerencia;
	
	@NotEmpty(message = "El Caso de la sugerencia no debe estar vacio")
	private String caso;
	@NotEmpty(message = "La descripción no debe estar vacio")
	private String descripcion;
	private String status;

	@Column(name="fechasugerencia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@NotNull(message = "El empleado no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idempleado")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Empleado empleado;
	
	@NotNull(message = "El cliente no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcliente")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Cliente cliente;
	
	/*@NotNull(message = "El proveedor no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idproveedor")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Proveedor proveedor;*/
}
