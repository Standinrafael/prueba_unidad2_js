package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.ICitaMedicaService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2JsApplication implements CommandLineRunner  {

	private static final Logger LOG = LoggerFactory.getLogger(PruebaUnidad2JsApplication.class);
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private ICitaMedicaService citaMedicaService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2JsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//Cita medita
		
		CitaMedica c1= new CitaMedica();
		c1.setNumero("1");
		c1.setFechaCita(LocalDateTime.now());
		c1.setValorCita(new BigDecimal(20.00));
		c1.setLugarCita("Conocoto");
		
		
		//Ingreso de dos Pacientes
		
		Paciente p1= new Paciente();
		p1.setCedula("1105166290");
		p1.setApellido("Perez");
		p1.setCodigoIess("adsasdsa");
		p1.setEstatura(new BigDecimal(1.70));
		p1.setNombre("Andres");
		p1.setEdad(13);
		p1.setFechaNacimiento(LocalDateTime.of(1989, Month.AUGUST,8,12,45));
		p1.setCitaMedicaPaciente(c1);
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
		p2.setCitaMedicaPaciente(c1);
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
		d1.setCitaMedica(c1);
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
		d1.setCitaMedica(c1);
		//cita medica
		this.doctorService.insertarDoctor(d2);
		
		//enviar paciente y docotr
		List<Paciente> listp=new ArrayList<>();
		listp.add(p2);
		listp.add(p1);
		
		List<Doctor> listd=new ArrayList<>();
		listd.add(d2);
		listd.add(d1);
		
		c1.setPaciente(listp);
		c1.setDoctor(listd);
		
		this.citaMedicaService.insertarCitaMedica("1", LocalDateTime.now(), new BigDecimal (50.00), "Conocoto", p1.getCedula(), d1.getCedula());
		
		List<String> receta = new ArrayList<>();
		receta.add("Paracetamol");
		receta.add("penicilina");
		
		this.citaMedicaService.actualizarCitaMedica("Gripe", receta, LocalDateTime.now(), 1);
	}

}
