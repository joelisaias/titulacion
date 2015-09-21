package ec.edu.ug.erp.web.template;

import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.model.LazyDataModel;

import ec.edu.ug.erp.util.dao.PaginationTemplate;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;
import ec.edu.ug.erp.web.model.DataTableModel;

public abstract class DTOTemplateMB<DTO extends GenericDTO<?>> extends TemplateMB {

	private static final long serialVersionUID = 9127180840504035585L;
	 
	protected DTO searchDTO;
	protected DTO currentDTO;
	protected PaginationTemplate pagination;
	protected LazyDataModel<DTO> dataModel;
	
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
	public abstract DTO instanceSearchDTO();
	
	/**
	 * TODO agregar comentario
	 * 
	 * @author Joel Alvarado
	 * @return
	 */
	public abstract List<DTO> loadMainResult(DTO filter,PaginationTemplate pagination);
	public abstract DTO 	  actionEdit(Long id);
	public abstract DTO 	  actionNew();
	public abstract void 	  actionDelete(DTO dto);
	
	public abstract TipoTemplate initSearchTemplate();
	public abstract TipoTemplate initEditTemplate();
	
	public void actionSearch(ActionEvent evt){
		addMessageInfo("search");
	}	
	public void actionNew(ActionEvent evt){
		setCurrentDTO(actionNew());		
	}
	

	public void actionDelete(ActionEvent evt){
				
	}
	
	public DTO getSearchDTO() {
		return searchDTO!=null?searchDTO:instanceSearchDTO();
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
		return searchResult!=null?searchResult:loadMainResult(getSearchDTO(),getPagination());
	}
		
	public TipoTemplate getSearchTemplate() {
		return super.getSearchTemplate()!=null?super.getSearchTemplate():initSearchTemplate();
	}	
	
	public TipoTemplate getEditTemplate() {
		return super.getEditTemplate()!=null?super.getEditTemplate():initEditTemplate();
	}
	
	public PaginationTemplate getPagination() {
		return pagination;
	}
	
	public void setPagination(PaginationTemplate pagination) {
		this.pagination = pagination;
	}

	public LazyDataModel<DTO> getDataModel() {
		return dataModel!=null?dataModel:new DataTableModel<DTO>() {

			private static final long serialVersionUID = -6937043607542982666L;

			@Override
			public List<DTO> loadData(DTO dto, PaginationTemplate pagination) {
				return loadMainResult(dto, pagination);
			}

			@Override
			public DTO actionEdit(Long id) {			
				return actionEdit(id);
			}
			
		};
	}

	public void setDataModel(LazyDataModel<DTO> model) {
		this.dataModel = model;
	}
	
	
	
}
