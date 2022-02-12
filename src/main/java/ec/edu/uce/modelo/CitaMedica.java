package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cita_medica")
public class CitaMedica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cita_medica")
	@SequenceGenerator(name="seq_cita_medica",sequenceName="seq_cita_medica",allocationSize=1)
	@Column(name="cime_id")
	private Integer id;
	
	@Column(name="cime_numero")
	private String numero;
	
	@Column(name="cime_fecha_cita", columnDefinition="TIMESTAMP")
	private LocalDateTime fechaCita;
	
	@Column(name="cime_valor_cita")
	private BigDecimal valorCita;
	
	@Column(name="cime_lugar_cita")
	private String lugarCita;
	
	@Column(name="cime_diagnostico")
	private String diagnostico;
	
	@ElementCollection
	private List<String> receta;//lista
	
	@Column(name="cime_fecha_control", columnDefinition="TIMESTAMP")
	private LocalDateTime fechaControl;
	
	@OneToMany(mappedBy="citaMedica", cascade=CascadeType.ALL)
	private List<Doctor>doctor;
	
	@OneToMany(mappedBy="citaMedicaPaciente", cascade=CascadeType.ALL)
	private List<Paciente> paciente;

	//Metodos Get Y Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public List<String> getReceta() {
		return receta;
	}

	public void setReceta(List<String> receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numero=" + numero + ", fechaCita=" + fechaCita + ", valorCita=" + valorCita
				+ ", lugarCita=" + lugarCita + ", diagnostico=" + diagnostico + ", receta=" + receta + ", fechaControl="
				+ fechaControl + ", doctor=" + doctor + ", paciente=" + paciente + "]";
	}

	
}
