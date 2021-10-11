package com.practica2.api.model;


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
@Table(name = "deuda")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Deuda {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long iddeuda;
		
		@NotEmpty(message = "El estado no debe estar vacio")
		private String estado;
		private String fechavencimiento;
		private String status;
		
		/*@NotNull(message = "El empleado no puede ser vacia")
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "idventa")
		@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
		private Venta venta;*/
	}


