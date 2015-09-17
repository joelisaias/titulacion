package ec.edu.ug.erp.web.modulo.seguridad;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;


/**
 * Backing bean para administrar el comportamiento de la pantalla de opciones
 * 
 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado</a>
 * @version 1.0
 * @since 2015-09-15
 * 
 */
@Named("opcionMB")
@SessionScoped
public class OpcionMB extends SeguridadMB<ModuloDTO> {

	private static final long serialVersionUID = 1670252147038791394L;
	
	@PostConstruct
	protected void init(){
		System.out.println("INICIANDO opcion MB");
	}

	@Override
	public void instanceSearchDTO() {
		searchDTO  = new ModuloDTO();		
	}

	@Override
	public List<ModuloDTO> loadMainResult(ModuloDTO filter) {
		List<ModuloDTO> result=null;
		try {
			result= seguridadService.obtenerListModulos(filter);
		} catch (Exception e) {
			addMessageError(e.getMessage());
		}
		return result;
	}

	
	
	


}
