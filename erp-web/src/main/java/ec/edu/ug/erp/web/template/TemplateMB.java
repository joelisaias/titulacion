package ec.edu.ug.erp.web.template;

import javax.inject.Inject;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.servicio.administracion.AdministracionService;
import ec.edu.ug.erp.servicio.compras.ComprasService;
import ec.edu.ug.erp.servicio.contabilidad.ContabilidadService;
import ec.edu.ug.erp.servicio.facturacion.FacturacionService;
import ec.edu.ug.erp.servicio.general.GeneralService;
import ec.edu.ug.erp.servicio.gerencial.GerencialService;
import ec.edu.ug.erp.servicio.inventario.InventarioService;
import ec.edu.ug.erp.servicio.rrhh.RrhhService;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;
import ec.edu.ug.erp.util.jsf.GenericManagedBean;
import ec.edu.ug.erp.web.sesion.UsuarioSesionMB;

public class TemplateMB extends GenericManagedBean {

	private static final long serialVersionUID = 9127180840504035585L;

	@Autowired protected SeguridadService 		seguridadService;	
	@Autowired protected AdministracionService 	administracionService;	
	@Autowired protected GeneralService 		generalService;	
	@Autowired protected RrhhService 			rrhhService;
	@Autowired protected ComprasService 		comprasService;
	@Autowired protected FacturacionService 	facturacionService;
	@Autowired protected ContabilidadService 	contabilidadService;
	@Autowired protected GerencialService 		gerencialService;
	@Autowired protected InventarioService 		inventarioService;
		
	@Inject private UsuarioSesionMB usuarioSesion;
	@Inject private TabOptionsMB userOptions;
	
	private ModuloDTO opcionActual;
	
	  
	private TipoTemplate searchTemplate;
	private TipoTemplate editTemplate;
	
	
	

	public UsuarioSesionMB getUsuarioSesion() {
		usuarioSesion.validaSesion();
		return usuarioSesion;
	}

	public void setUsuarioSesion(UsuarioSesionMB usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}
	
	public TabOptionsMB getUserOptions() {
		return userOptions;
	}
	
	public ModuloDTO getCurrentOption(){
		return getOpcionActual();
	}
	
	public String getUrlListar(){
		return getCurrentOption().getAccionListar();
	}
	
	public String getUrlEditar(){
		return getCurrentOption().getAccionEditar();
	}
	public String getUrlCrear(){
		return getCurrentOption().getAccionCrear();
	}
	
	public void setTargetURL(String targetURL){
		getCurrentOption().setTargetURL(targetURL);
	}
	
	
	public TipoTemplate getSearchTemplate() {
		return searchTemplate;
	}
	
	public void setSearchTemplate(TipoTemplate searchTemplate) {
		this.searchTemplate = searchTemplate;
	}
	
	public TipoTemplate getEditTemplate() {
		return editTemplate;
	}
	
	public void setEditTemplate(TipoTemplate editTemplate) {
		this.editTemplate = editTemplate;
	}
	
	public ModuloDTO getOpcionActual() {
		return opcionActual;
	}

	public void setOpcionActual(ModuloDTO opcionActual) {
		this.opcionActual = opcionActual;
	}
	
	public RequestContext getPrimeRequestContext(){
		return RequestContext.getCurrentInstance();
	}
	
	public void updatePrimeComponent(String clientId){
		getPrimeRequestContext().update(String.format("#{p:component('%s')}", clientId));
	}
	
	public void excecutePrime(String script){
		getPrimeRequestContext().execute(script);
	}

	
	public enum TipoTemplate{
		 CENTRO_NORTE("CN")
		,CENTRO_ESTE("CE")
		,CENTRO_OESTE("CO")
		,CENTRO_SUR("CS")
		,CENTRO_NORTE_SUR("CNS")
		,CENTRO_NORTE_ESTE("CNE")
		,CENTRO_NORTE_OESTE("CNO")
		 ;
		 
		 private String value;
		 
		 private TipoTemplate(String value) {
			this.value=value;
		}
		
		public String getValue() {
			return value;
		}
		 
		public boolean isHabilitaNorte(){return this.equals(CENTRO_NORTE)||this.equals(CENTRO_NORTE_SUR)||this.equals(CENTRO_NORTE_ESTE)||this.equals(CENTRO_NORTE_OESTE);}
		public boolean isHabilitaEste (){return this.equals(CENTRO_ESTE)||this.equals(CENTRO_NORTE_ESTE);}
		public boolean isHabilitaOeste(){return this.equals(CENTRO_OESTE)||this.equals(CENTRO_NORTE_OESTE);}
		public boolean isHabilitaSur  (){return this.equals(CENTRO_SUR)||this.equals(CENTRO_NORTE_SUR);}
	}
		
}
