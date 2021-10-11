package com.practica.api.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Empleado{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idempleado;
	
	@NotEmpty(message = "Ingresar el Nombre del empleado por favor")
	private String nombreempleado;
	@NotEmpty(message = "Ingresar el DNI del empleado por favor")
	private Integer dni;
	private String status;
	
	
}