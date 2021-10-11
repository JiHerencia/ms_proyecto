package com.practica3.api.model;


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
@Table(name = "proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproveedor;
	
	@NotEmpty(message = "Ingresar el Nombre del cliente por favor")
	private String nombreproveedor;
	@NotEmpty(message = "Ingresar el DNI del cliente por favor")
	private Integer ruc;
	private String correo;
	private String status;
	
	
}
