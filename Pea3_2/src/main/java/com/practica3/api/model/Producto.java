package com.practica3.api.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Positive;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idproducto;
	
	@NotEmpty(message = "El nombre no debe ser vacÃ­o")
	private String nombreproducto;
	private String marcaproducto;
	
	@Positive(message = "El stock debe ser mayor que cero")
	private Double stock;
	@Positive(message = "El precio debe ser mayor que cero")
	private Double precio;
	private String status;
	
	private String vence;
		
}