package com.practica.api.controlador;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practica.api.modelo.Cliente;

import com.practica.api.servicio.ClienteService;
@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService pagoServicio;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> getCliente(){
		List<Cliente>empleado=pagoServicio.ListAllCliente();
		return ResponseEntity.ok(empleado);
	}
	
	//@GetMapping("/")
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> ListarPago(@RequestParam(name = "deudaId",
	required = false) Long deudaId) {
		
		List<Cliente> pagos = new ArrayList<>();
		
		if(deudaId == null) {
			pagos = pagoServicio.ListAllCliente();
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			pagos = pagoServicio.findByDeuda(Cliente.builder()
					.idcliente(deudaId).build());
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		return ResponseEntity.ok(pagos);
	}*/
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> getPago(@PathVariable("id") Long id){
		
		Cliente pago = pagoServicio.getCliente(id);
		if(pago == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pago);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> CrearPago(@Valid @RequestBody Cliente pago,BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}

		Cliente pagoCreado = pagoServicio.createCliente(pago);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pagoCreado);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Cliente> actualizarPago(@PathVariable("id") Long id,
			@RequestBody Cliente pago){
		
		pago.setIdcliente(id);
		Cliente pagoEncontrado = pagoServicio.updateCliente(pago);
		
		if(pagoEncontrado == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pagoEncontrado);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<Cliente> deletePago(@PathVariable("id") Long id){
		Cliente pagoDelete = pagoServicio.deleteCliente(id);
		
		if(pagoDelete == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pagoDelete);
	}
	
	/*@RequestMapping(value = "/eliminar/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Pago> eliminarPago(@PathVariable("id") Long id,
			@RequestBody Pago pago){
		
		pago.setIdpago(id);
		Pago pagoeliminar = pagoServicio.deletePago(id);
		
		if(pagoeliminar == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(pagoeliminar);
	}*/
	
	private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
	
}
