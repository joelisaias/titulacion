package ec.edu.ug.erp.dao.compras.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import ec.edu.ug.erp.dao.compras.ComprasDao;
import ec.edu.ug.erp.dto.compras.GenericComprasDTO;
import ec.edu.ug.erp.dto.compras.OrdenCompraDTO;
import ec.edu.ug.erp.util.dao.DAOUtils;
import ec.edu.ug.erp.util.dao.PaginationTemplate;
import ec.edu.ug.erp.util.dao.impl.GenericDAOImpl;

@Repository("comprasDAO")
public class ComprasDaoImpl extends GenericDAOImpl <GenericComprasDTO<?>>implements ComprasDao{

	public List<OrdenCompraDTO> obtenerOrdenesCompraPorCriterio(PaginationTemplate pagination,OrdenCompraDTO filter) throws Exception{
		
		DetachedCriteria criteria=DetachedCriteria.forClass(OrdenCompraDTO.class);
		DAOUtils.addInnerJoins(criteria, "proveedor");		
		
		return findByCriteria(criteria,pagination);
	}
	
}
