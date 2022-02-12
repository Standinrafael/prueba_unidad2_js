package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2JsApplication implements CommandLineRunner  {

	private static final Logger LOG = LoggerFactory.getLogger(PruebaUnidad2JsApplication.class);
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IDoctorService doctorService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2JsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Ingreso de dos Pacientes
		
		Paciente p1= new Paciente();
		p1.setCedula("1105166290");
		p1.setApellido("Perez");
		p1.setCodigoIess("adsasdsa");
		p1.setEstatura(new BigDecimal(1.70));
		p1.setNombre("Andres");
		p1.setEdad(13);
		p1.setFechaNacimiento(LocalDateTime.of(1989, Month.AUGUST,8,12,45));
		//ingresar cita medica
		this.pacienteService.insertarPaciente(p1);
		
		Paciente p2= new Paciente();
		p2.setCedula("1105166290");
		p2.setApellido("Perez");
		p2.setCodigoIess("adsasdddda");
		p2.setEstatura(new BigDecimal(1.90));
		p2.setNombre("Andres");
		p2.setEdad(17);
		p2.setFechaNacimiento(LocalDateTime.of(1997, Month.AUGUST,8,12,45));
		//ingresar cita medica
		this.pacienteService.insertarPaciente(p2);
		
		//Ingreso de dos Doctores;
		
		Doctor d1= new Doctor();
		d1.setApellido("Alvez");
		d1.setCedula("11555");
		d1.setCodigoSenescyt("adad");
		d1.setFechaNacimiento(LocalDateTime.of(1987, Month.AUGUST,8,12,45));
		d1.setNombre("Juan");
		d1.setNumeroConsultorio(3);
		d1.setSueldo(new BigDecimal(400.00));
		//cita medica
		this.doctorService.insertarDoctor(d1);
		
		Doctor d2= new Doctor();
		d1.setApellido("Alvez");
		d1.setCedula("11555");
		d1.setCodigoSenescyt("jjjj11");
		d1.setFechaNacimiento(LocalDateTime.of(1987, Month.AUGUST,8,12,45));
		d1.setNombre("Tomas");
		d1.setNumeroConsultorio(8);
		d1.setSueldo(new BigDecimal(450.00));
		//cita medica
		this.doctorService.insertarDoctor(d2);
	}

}
