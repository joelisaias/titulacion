package ec.edu.ug.erp.servicio.seguridad.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.seguridad.SeguridadDao;
import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO;
import ec.edu.ug.erp.dto.seguridad.ModuloDTO.Tipo;
import ec.edu.ug.erp.dto.seguridad.RolDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioSucursalDTO;
import ec.edu.ug.erp.servicio.seguridad.SeguridadService;
import ec.edu.ug.erp.util.dao.PaginationTemplate;
/**
 * Implementacion de Capa de servicio para modulo de seguridad
 * 
 * @author Joel Alvarado
 * @since 2015-08-30
 * @version 1.0
 *
 */
@Service("seguridadService")
public class SeguridadServiceImpl implements SeguridadService {

	@Autowired
	private SeguridadDao seguridadDao;

	public UsuarioDTO obtenerUsuarioSesion(UsuarioDTO usuario,EmpresaDTO empresa)
			throws Exception {
		return seguridadDao.obtenerUsuarioSesion(usuario, empresa);
	}
	
	public List<UsuarioSucursalDTO> obtenerUsuariosSucursal(UsuarioDTO usuario) throws Exception{		
		return seguridadDao.obtenerUsuariosSucursal(usuario);
		
	}
	
	public UsuarioSucursalDTO obtenerUsuarioSucursal(UsuarioDTO usuario) throws Exception{
		return seguridadDao.obtenerUsuarioSucursal(usuario);
		
	}
	
	public ModuloDTO saveModulo(ModuloDTO modulo) throws Exception {
		seguridadDao.saveOrUpdate(modulo);
		return modulo;
	}

	public List<ModuloDTO> loadMenu(Object... filters) throws Exception {		
		List<ModuloDTO> modulos=seguridadDao.loadMenu(Tipo.LIST_PARENTS,filters);		
		return modulos;
	}
	
	public List<ModuloDTO> obtenerOpcionesPermitidas(UsuarioSucursalDTO usuarioAutenticado) throws Exception {
		return seguridadDao.obtenerOpcionesPermitidas(usuarioAutenticado);
	}

	public Collection<RolDTO> findRolesByUrl(String url) throws Exception{		
		return seguridadDao.findRolesByUrl(url);
	}
	
	public ModuloDTO obtenerModuloPorId(Long id) throws Exception{
		return seguridadDao.findById(id, ModuloDTO.class);
	}
	
	public ModuloDTO obtenerModuloBienvenidaPorUsuario(UsuarioSucursalDTO usuarioAutenticado) throws Exception{
		return seguridadDao.obtenerModuloBienvenidaPorUsuario(usuarioAutenticado);
	}
	
	public List<ModuloDTO> obtenerListModulos(ModuloDTO filter,PaginationTemplate pagination)throws Exception{
		return seguridadDao.obtenerListModulos(filter,pagination);
	}

}
