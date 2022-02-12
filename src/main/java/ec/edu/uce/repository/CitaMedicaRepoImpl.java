package ec.edu.uce.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarCitaMedica(String numero, LocalDateTime fecha, BigDecimal valor, String lugar,
			String cedulaPaciente, String cedulaDoctor) {
		// TODO Auto-generated method stub
		
		Query miQuery=this.entityManager.createNativeQuery("insert into cita_medica (cime_numero, cime_fecha_cita,cime_valor_cita,cime_lugar_cita,cime_doct_cedula, cime_paci_cedula) values"
				+ "(:numero,:fecha,:valor,:lugar,:cedulaPaciente,:cedulaDoctor)");
		miQuery.setParameter("numero", numero);
		miQuery.setParameter("fecha", fecha);
		miQuery.setParameter("valor", valor);
		miQuery.setParameter("lugar", lugar);
		miQuery.setParameter("cedulaPaciente", cedulaPaciente);
		miQuery.setParameter("cedulaDoctor", cedulaDoctor);
		miQuery.executeUpdate();
		
				    
	
	}

	@Override
	public void actualizarCitaMedica(String diagnostico,List<String> receta, LocalDateTime fechaControl,Integer numero) {
		// TODO Auto-generated method stub
		Query myQuery=this.entityManager.createQuery("update CitaMedica c set c.diagnostico=: diagnostico, c.receta=:receta, c.fechaControl: fechaContro where c.id=:numero");
		myQuery.setParameter("diagnostico", diagnostico);
		myQuery.setParameter("receta", receta);
		myQuery.setParameter("fechaControl", fechaControl);
		myQuery.setParameter(" numero",  numero);
		myQuery.executeUpdate();
	}

}
