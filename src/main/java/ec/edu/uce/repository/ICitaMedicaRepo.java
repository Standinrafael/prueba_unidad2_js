package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface ICitaMedicaRepo {

	void insertarCitaMedica( String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaPaciente, String cedulaDoctor);
	void actualizarCitaMedica (String diagnostico,List<String> receta, LocalDateTime fechaControl,Integer numero);
}
