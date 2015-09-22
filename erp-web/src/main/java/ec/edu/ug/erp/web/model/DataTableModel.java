package ec.edu.ug.erp.web.model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import ec.edu.ug.erp.util.dao.PaginationTemplate;
import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;

public abstract class DataTableModel<DTO extends GenericDTO<?>> extends
		LazyDataModel<DTO> {

	private static final long serialVersionUID = -5699310846107534276L;

	private PaginationTemplate pagination;

	private DTO filter;
	
	public DataTableModel(){
		pagination=new PaginationTemplate(PaginationTemplate.defaultPageSize);
	}
	
	public DTO getFilter() {
		filter=filter!=null?filter:defineFilter();
		return filter;
	}
	
	public void setFilter(DTO filter) {
		this.filter = filter;
	}
	

	
	public DTO defineFilter(){
		throw new UnsupportedOperationException(
				"Filtro no definido");
	}

	public abstract List<DTO> loadData(DTO dto, PaginationTemplate pagination);

	public abstract DTO rowSelect(Long id);

	public DTO actionNew() {
		throw new UnsupportedOperationException(
				"Metodo actionNew no implementado");
	}

	public DTO actionDelete() {
		throw new UnsupportedOperationException(
				"Metodo actionDelete no implementado");
	}
	
	public PaginationTemplate getPagination() {
		return pagination;
	}

	public void setPagination(PaginationTemplate pagination) {
		this.pagination = pagination;
	}

	@Override
	public List<DTO> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		List<DTO> result;
		pagination.setFirstRow(first);
		pagination.setPageSize(pageSize);
		result = loadData(getFilter(), pagination);
		setRowCount(pagination.getRowCount());
		setPageSize(pagination.getPageSize());		
		return result;
	}

	@Override
	public DTO getRowData(String rowKey) {
		Long id = Long.valueOf(rowKey);
		return rowSelect(id);
	}
	
	@Override
	public Object getRowKey(DTO dto) {
		return dto.getId();
	}

}
