package ec.edu.ug.erp.servicio.compras;

import java.util.List;

import ec.edu.ug.erp.dto.compras.OrdenCompraDTO;
import ec.edu.ug.erp.util.dao.PaginationTemplate;


public interface ComprasService {
	

	public List<OrdenCompraDTO> obtenerOrdenesCompraPorCriterio(PaginationTemplate pagination,OrdenCompraDTO filter) throws Exception;
	
}
