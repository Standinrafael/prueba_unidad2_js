package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_paciente")
	@SequenceGenerator(name="seq_paciente",sequenceName="seq_paciente",allocationSize=1)
	@Column(name="paci_id")
	private Integer id;
	
	@Column(name="paci_cedula")
	private String cedula;
	
	@Column(name="paci_nombre")
	private String nombre;
	
	@Column(name="paci_apellido")
	private String apellido;
	
	@Column(name="paci_fecha_nacimiento", columnDefinition="TIMESTAMP")
	private LocalDateTime fechaNacimiento;
	
	@Column(name="paci_codigo_iess")
	private String codigoIess;
	
	@Column(name="paci_estatura")
	private BigDecimal estatura;
	
	@Column(name="paci_peso")
	private BigDecimal peso;
	
	@Column(name="paci_edad")
	private Integer edad;
	
	@ManyToOne
	@JoinColumn(name="paci_cime_id")
	private CitaMedica citaMedicaPaciente;
	
	
	
	//Metodos GET y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCodigoIess() {
		return codigoIess;
	}

	public void setCodigoIess(String codigoIess) {
		this.codigoIess = codigoIess;
	}

	public BigDecimal getEstatura() {
		return estatura;
	}

	public void setEstatura(BigDecimal estatura) {
		this.estatura = estatura;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public CitaMedica getCitaMedicaPaciente() {
		return citaMedicaPaciente;
	}

	public void setCitaMedicaPaciente(CitaMedica citaMedicaPaciente) {
		this.citaMedicaPaciente = citaMedicaPaciente;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", codigoIess=" + codigoIess + ", estatura=" + estatura
				+ ", peso=" + peso + ", edad=" + edad + ", citaMedicaPaciente=" + citaMedicaPaciente + "]";
	}
	
	
}
