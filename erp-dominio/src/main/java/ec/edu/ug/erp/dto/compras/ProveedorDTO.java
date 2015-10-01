package ec.edu.ug.erp.dto.compras;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ec.edu.ug.erp.dto.rrhh.EmpresaPersonaDTO;
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableNames;

@Entity
@Table(name=ITableNames.PROVEEDOR,schema=ISchemaNames.COMPRAS)
public class ProveedorDTO extends GenericComprasDTO<ProveedorDTO> {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.PROVEEDOR, sequenceName = ISequenceTables.PROVEEDOR, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.PROVEEDOR)
	private Long id;
	
	@Column(name=CODIGO,length=10,unique=true)
	private String codigo;
	
	@JoinColumn(name=EMPRESAPERSONA_ID,nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private EmpresaPersonaDTO empresaPersona;
	
	@OneToMany(mappedBy=FIELD_PROVEEDOR,fetch=FetchType.LAZY)
	private List<OrdenCompraDTO> ordenCompraDTOs;
	
	
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

	public EmpresaPersonaDTO getEmpresaPersona() {
		return empresaPersona;
	}

	public void setEmpresaPersona(EmpresaPersonaDTO empresaPersona) {
		this.empresaPersona = empresaPersona;
	}
	
	

}
