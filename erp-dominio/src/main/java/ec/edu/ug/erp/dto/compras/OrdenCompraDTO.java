package ec.edu.ug.erp.dto.compras;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;

@Entity
@Table(name=ITableNames.ORDEN_COMPRA,schema=ISchemaNames.COMPRAS)
public class OrdenCompraDTO extends GenericComprasDTO<OrdenCompraDTO> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.ORDEN_COMPRA, sequenceName = ISequenceTables.ORDEN_COMPRA, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.ORDEN_COMPRA)
	private Long id;
	
	@Column(name=CODIGO,length=10,unique=true)
	private String codigo;


	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id=id;
	}

	@Override
	public String getCodigo() {
		return codigo;
	}

	@Override
	public void setCodigo(String codigo) {
		this.codigo=codigo;		
	}

}
