package ec.edu.ug.erp.web.modulo.seguridad;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.util.dao.PaginationTemplate;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;


/**
 * Backing bean para administrar el comportamiento de la pantalla de opciones
 * 
 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado</a>
 * @version 1.0
 * @since 2015-09-15
 * 
 */
@Named("opcionMB")
@ViewScoped
public class OpcionMB extends GenericSeguridadMB<ModuloDTO> {

	private static final long serialVersionUID = 1670252147038791394L;
	

	
	@PostConstruct
	protected void init(){
		System.out.println("INICIANDO opcion MB");
	}

	@Override
	public ModuloDTO instanceSearchDTO() {
		ModuloDTO filtro=new ModuloDTO();
		return filtro;		
	}
	

	@Override
	public List<ModuloDTO> loadMainResult(ModuloDTO filter,PaginationTemplate pagination) {
		List<ModuloDTO> result=null;
		try {
			result= seguridadService.obtenerListModulos(filter,pagination);
		} catch (Exception e) {
			addMessageError(e.getMessage());
		}
		return result;
	}

	@Override
	public ModuloDTO actionEdit(Long id) {
		try {
			return seguridadService.obtenerModuloPorId(id);
		} catch (Exception e) {
			addMessageError(e.getMessage());
		}
		return null;
	}

	@Override
	public ModuloDTO actionNew() {
		ModuloDTO dto=new ModuloDTO();
		dto.setFechaCreacion(Calendar.getInstance().getTime());
		dto.setEstado(Estado.ACTIVO);
		return dto;
	}

	@Override
	public void actionDelete(ModuloDTO dto) {
		addMessageInfo("DELETING...");
	}

	
	@Override
	public TipoTemplate initSearchTemplate() {
		return TipoTemplate.CENTRO_ESTE;
	}

	@Override
	public TipoTemplate initEditTemplate() {
		return TipoTemplate.CENTRO_NORTE;
	}

	
	
	


}
