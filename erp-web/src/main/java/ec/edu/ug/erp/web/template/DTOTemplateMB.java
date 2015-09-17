package ec.edu.ug.erp.web.template;

import java.util.List;

import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

public abstract class DTOTemplateMB<DTO extends GenericDTO<?>> extends TemplateMB {

	private static final long serialVersionUID = 9127180840504035585L;
	 
	protected DTO searchDTO;
	protected DTO currentDTO;
	
	private List<DTO> searchResult; 
	
	/**
	 * Instanciar serachDTO & currentDTO
	 * <br/>
	 * Ejemplo:
	 * <br/> 
	 * <code>
	 *  searchDTO=new DTO();</br>
	 * </code>
	 * 
	 * Entiendase por DTO al tipo de dato con el que construyen su MB <br/>	  
	 * Ejemplo:
	 * <br/>
	 * <code>
	 * public class OpcionMB extends SeguridadMB&lt;ModuloDTO>{...<br/>
	 * public abstract class SeguridadMB&lt;DTO extends GenericSeguridadDTO&lt;DTO>> extends DTOTemplateMB&lt;DTO> {...<br/>
	 * </code>
	 * la implementacion seria <br/>
	 * <code>
	 * public void instanceSearchDTO() {
	 *	searchDTO  = new ModuloDTO();		
	 * }
	 * </code>
	 * 
	 * 
	 * @author <a href="mailto:joyalt77@gmail.com">Joel Alvarado</a>
	 * @since 2015-09-15  v 1.0
	 */
	public abstract void instanceSearchDTO();
	
	/**
	 * TODO agregar comentario
	 * 
	 * @author Joel Alvarado
	 * @return
	 */
	public abstract List<DTO> loadMainResult(DTO filter);
	
	
	
	
	
	
	
	
	public DTO getSearchDTO() {
		return searchDTO;
	}
	
	public void setSearchDTO(DTO searchDTO) {
		this.searchDTO = searchDTO;
	}
	
	public DTO getCurrentDTO() {
		return currentDTO;
	}
	
	public void setCurrentDTO(DTO currentDTO) {
		this.currentDTO = currentDTO;
	}

	public List<DTO> getSearchResult() {
		return searchResult!=null?searchResult:loadMainResult(getSearchDTO());
	}
		
}
