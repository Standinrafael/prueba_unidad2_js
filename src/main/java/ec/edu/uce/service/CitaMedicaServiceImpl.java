package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepo citaMedicaRepo;
	@Override
	public void insertarCitaMedica(String numero, LocalDateTime fecha, BigDecimal valor, String lugar,
			String cedulaPaciente, String cedulaDoctor) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.insertarCitaMedica(numero, fecha, valor, lugar, cedulaPaciente, cedulaDoctor);
	}
	@Override
	public void actualizarCitaMedica(String diagnostico, List<String> receta, LocalDateTime fechaControl,
			Integer numero) {
		// TODO Auto-generated method stub
		this.citaMedicaRepo.actualizarCitaMedica(diagnostico, receta, fechaControl, numero);
	}

}
