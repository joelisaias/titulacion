package ec.edu.ug.erp.web.template;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO.Estado;

@Named("tabOptionsMB")
@SessionScoped
public class TabOptionsMB extends TemplateMB {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10820309169280424L;
	
	private List<ModuloDTO> options;
	
	@PostConstruct
	protected void init(){
		
		ModuloDTO modulo;
		
		modulo=new ModuloDTO();
		modulo.setId(1L);
		modulo.setCodigo("DASH");
		modulo.setDescripcion("Dashboard");
		modulo.setIcono("fa fa-dashboard");
		modulo.setEstado(Estado.ACTIVO);
		modulo.setFechaCreacion(Calendar.getInstance().getTime());
		modulo.setNivel(1);
		modulo.setOrden(0);
		modulo.setAccionListar("/pages/general/dashboard.xhtml");		
		modulo.setTipo(Tipo.WELCOMEPAGE);
		addOption(modulo);
		
		
		System.out.println("SE BUSCARA WELCOMEPAGE");
//		try {
//			ModuloDTO modulo=seguridad.obtenerModuloBienvenidaPorUsuario(getUsuarioSesion().getUsuarioSucursal());
//			
//			System.out.println(modulo);
//			addOption(modulo);
//		} catch (Exception e) {
//			addMessageError(e.getMessage());
//		}		
		

	}

    public void addOption(ModuloDTO option){
    	options=options!=null?options:new ArrayList<ModuloDTO>();
    	options.add(option);
    }
    
    public void addTab(final Long id){
    	try {
    		ModuloDTO modulo=seguridad.obtenerModuloPorId(id);
    		if(modulo!=null&& modulo.getAccionListar()!=null)
    			addOption(modulo);
		} catch (Exception e) {			
			addMessageError(e.getMessage());
		}
    }
    
    public void removeTab(final Long id){
    	System.out.println("removing..." +id);
    	addMessageInfo("removing..." +id);
    	
    	int index=0;
    	for(ModuloDTO opcion:getOptions()){
    		if(opcion.getId().equals(id))    		
    			getOptions().remove(index);
    		index++;
    	}
    	
    }
    
    public void onTabChange(TabChangeEvent event) {
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab() );
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
       
        
    }
         
    public void onTabClose(TabCloseEvent event) {
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
	
	public List<ModuloDTO> getOptions() {
		options=options!=null?options:new ArrayList<ModuloDTO>();
		System.out.println(options);
		return options;
	}

	public void setOptions(List<ModuloDTO> options) {
		this.options = options;
	}
	
	

}
