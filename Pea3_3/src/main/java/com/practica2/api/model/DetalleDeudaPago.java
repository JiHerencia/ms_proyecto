package com.practica2.api.model;
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
@Table(name = "detalledeudapago")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DetalleDeudaPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddetalle;
	@Positive(message = "La cantidad debe ser mayor que cero")
	private Double preciomora;
	private String diasretraso;
	private String status;
	
	@NotNull(message = "El empleado no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpago")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Pago pago;
	
	@NotNull(message = "La compra no puede ser vacia")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "iddeuda")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Deuda deuda;
}