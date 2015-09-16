package ec.edu.ug.erp.web.template;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

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
	
	 
	
	

	public UsuarioSesionMB getUsuarioSesion() {
		usuarioSesion.validaSesion();
		return usuarioSesion;
	}

	public void setUsuarioSesion(UsuarioSesionMB usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
	}
		
}
