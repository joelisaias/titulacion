package ec.edu.ug.erp.dto.rrhh;

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
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import ec.edu.ug.erp.dto.administracion.EmpresaDTO;
import ec.edu.ug.erp.dto.compras.ProveedorDTO;
import ec.edu.ug.erp.dto.seguridad.UsuarioDTO;
import ec.edu.ug.erp.util.constantes.ISchemaNames;
import ec.edu.ug.erp.util.constantes.ISequenceGenerators;
import ec.edu.ug.erp.util.constantes.ISequenceTables;
import ec.edu.ug.erp.util.constantes.ITableFieldNames;
import ec.edu.ug.erp.util.constantes.ITableNames;
import ec.edu.ug.erp.util.type.BooleanToCharType;


@Entity
@Table(name=ITableNames.EMPRESA_PERSONA,schema=ISchemaNames.RRHH,uniqueConstraints={@UniqueConstraint(columnNames={ITableFieldNames.EMPRESA_ID,ITableFieldNames.PERSONA_ID})})
public class EmpresaPersonaDTO extends GenericRrhhDTO<EmpresaPersonaDTO> {

	private static final long serialVersionUID = -1889501347202606778L;
	
	
	@Id
	@SequenceGenerator(name = ISequenceGenerators.EMPRESA_PERSONA, sequenceName = ISequenceTables.EMPRESA_PERSONA, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator=ISequenceGenerators.EMPRESA_PERSONA)
	private Long id;

	@Column(name=CODIGO)
	private String codigo;
	
	@JoinColumn(name=EMPRESA_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private EmpresaDTO empresa;
	
	@JoinColumn(name=PERSONA_ID)
	@ManyToOne(fetch=FetchType.LAZY)
	private PersonaDTO persona;
	
	@Column(name=ESCLIENTE)
	@Type(type=BooleanToCharType.TYPE)
	private boolean cliente;
	
	@Column(name=ESPROVEEDOR)
	@Type(type=BooleanToCharType.TYPE)
	private boolean proveedor;
	
	@Column(name=ESEMPLEADO)
	@Type(type=BooleanToCharType.TYPE)
	private boolean empleado;
	
	@OneToMany(mappedBy=FIELD_EMPRESA_PERSONA,fetch=FetchType.LAZY)
	private List<UsuarioDTO> usuarioDTOs;

	@OneToMany(mappedBy=FIELD_EMPRESA_PERSONA,fetch=FetchType.LAZY)
	private List<ProveedorDTO> proveedorDTOs;
	
	public Long getId() {		
		return id;
	}

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

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	public boolean isProveedor() {
		return proveedor;
	}

	public void setProveedor(boolean proveedor) {
		this.proveedor = proveedor;
	}

	public boolean isEmpleado() {
		return empleado;
	}

	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}

	public List<UsuarioDTO> getUsuarioDTOs() {
		return usuarioDTOs;
	}

	public void setUsuarioDTOs(List<UsuarioDTO> usuarioDTOs) {
		this.usuarioDTOs = usuarioDTOs;
	}

	public List<ProveedorDTO> getProveedorDTOs() {
		return proveedorDTOs;
	}

	public void setProveedorDTOs(List<ProveedorDTO> proveedorDTOs) {
		this.proveedorDTOs = proveedorDTOs;
	}
	
	
	
	

}