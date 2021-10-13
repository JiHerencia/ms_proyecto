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

import com.practica.api.modelo.Empleado;
import com.practica.api.servicio.EmpleadoService;


@RestController
@RequestMapping(value = "/empleado")
public class EmpleadoController {
	
	@Autowired
	EmpleadoService empleadoServicio;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Empleado>> getEmpleado(){
		List<Empleado>empleado=empleadoServicio.ListAllEmpleado();
		return ResponseEntity.ok(empleado);
	}
	
	//@GetMapping("/")
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Empleado>> ListarPago(@RequestParam(name = "empleadoId",
	required = false) Long empleadoId) {
		
		List<Empleado> pagos = new ArrayList<>();
		
		if(empleadoId == null) {
			pagos = empleadoServicio.ListAllEmpleado();
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}else {
			pagos = empleadoServicio.findByEmpleado(Empleado.builder()
					.idempleado(empleadoId).build());
			if(pagos.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		return ResponseEntity.ok(pagos);
	}*/
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Empleado> getEmpleado(@PathVariable("id") Long id){
		
		Empleado empleado = empleadoServicio.getEmpleado(id);
		if(empleado == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empleado);
	}
	
	@PostMapping
	public ResponseEntity<Empleado> CrearEmpleado(@Valid @RequestBody Empleado empleado,BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}

		Empleado empleadoCreado = empleadoServicio.createEmpleado(empleado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCreado);
	}

	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable("id") Long id,
			@RequestBody Empleado pago){
		
		pago.setIdempleado(id);
		Empleado empleadoEncontrado = empleadoServicio.updateEmpleado(pago);
		
		if(empleadoEncontrado == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empleadoEncontrado);
	}
	
	@DeleteMapping(value = "/eliminaremp/{id}")
	public ResponseEntity<Empleado> deleteEmpleado(@PathVariable("id") Long id){
		Empleado empleadoDelete = empleadoServicio.deleteEmpleado(id);
		
		if(empleadoDelete == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empleadoDelete);
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