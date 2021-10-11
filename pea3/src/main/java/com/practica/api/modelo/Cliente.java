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
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcliente;
	
	@NotEmpty(message = "Ingresar el Nombre del cliente por favor")
	private String nombrecliente;
	@NotEmpty(message = "Ingresar el DNI del cliente por favor")
	private Integer dni;
	private String status;
	
	
}
