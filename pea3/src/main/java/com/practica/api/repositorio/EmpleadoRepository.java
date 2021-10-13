package com.practica.api.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practica.api.modelo.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	/*public List<Empleado> findByVenta(Venta venta);
	/*public List<Producto> findByVenta(Venta venta);
	public List<Producto> findByCompra(Compra compra);*/
	
}
