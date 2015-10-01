package ec.edu.ug.erp.servicio.compras.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.ug.erp.dao.compras.ComprasDao;
import ec.edu.ug.erp.dto.compras.OrdenCompraDTO;
import ec.edu.ug.erp.servicio.compras.ComprasService;
import ec.edu.ug.erp.util.dao.PaginationTemplate;

@Service("comprasService")
public class ComprasServiceImpl implements ComprasService{
	
	@Autowired
	private ComprasDao comprasDao;

	public List<OrdenCompraDTO> obtenerOrdenesCompraPorCriterio(
			PaginationTemplate pagination, OrdenCompraDTO filter)
			throws Exception {

		return comprasDao.obtenerOrdenesCompraPorCriterio(pagination, filter);
	}
	

}
