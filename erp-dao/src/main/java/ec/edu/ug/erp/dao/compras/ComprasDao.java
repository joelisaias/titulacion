package ec.edu.ug.erp.dao.compras;

import java.util.List;

import ec.edu.ug.erp.dto.compras.GenericComprasDTO;
import ec.edu.ug.erp.dto.compras.OrdenCompraDTO;
import ec.edu.ug.erp.util.dao.GenericDAO;
import ec.edu.ug.erp.util.dao.PaginationTemplate;



public interface ComprasDao extends GenericDAO<GenericComprasDTO<?>>{

	public List<OrdenCompraDTO> obtenerOrdenesCompraPorCriterio(PaginationTemplate pagination,OrdenCompraDTO filter) throws Exception;
}
