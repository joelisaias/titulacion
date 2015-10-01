package ec.edu.ug.erp.dto.compras;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Type;

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
	
	@JoinColumn(name=PROVEEDOR_ID,nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private ProveedorDTO proveedor;
	
	@Column(name=TIPOCOMPRA)
	@Type(type=TipoCompra.TYPE)
	@Check(constraints=TIPOCOMPRA_CHECK)
	private TipoCompra tipoCompra;
	
	@Column(name=NUMEROPEDIDO,length=10)
	private Long numeroPedido;
	
	@Column(name=FECHAPEDIDO)
	@Temporal(TemporalType.DATE)
	private Date fechaPedido;
	
	@Column(name=FECHAESPERADA)
	@Temporal(TemporalType.DATE)
	private Date fechaEsperada;

	@Column(name=FECHALLEGADA)
	@Temporal(TemporalType.DATE)
	private Date fechaLlegada;

	@Column(name=FECHAEMBARQUE)
	@Temporal(TemporalType.DATE)
	private Date fechaEmbarque;

	@Column(name=FECHAVENCIMIENTO)
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
	
	@Column(name=FLETE)
	private BigDecimal flete;
	
	@Column(name=SEGURO)
	private BigDecimal seguro;
	
	@Column(name=BODEGADESTINO_ID)
	private Long bodegaDestino;
	
	@Column(name=PUERTOORIGEN_ID)
	private Long puertoOrigen;
	
	@Column(name=PUERTODESTINO_ID)
	private Long puertoDestino;

	@Column(name=TIPOTRANSPORTE)
	@Type(type=TipoTransporte.TYPE)
	@Check(constraints=TIPOTRANSPORTE_CHECK)
	private TipoTransporte tipoTransporte;
	
	@Column(name=ETAPACOMPRA)
	@Type(type=EtapaCompra.TYPE)
	private EtapaCompra etapaCompra;
	
	@Column(name=SUBTOTAL)
	private BigDecimal subtotal;
	
	@Column(name=DESCUENTO)
	private BigDecimal descuento;
	
	@Column(name=NETO)
	private BigDecimal neto;
	
	@Column(name=IVA)
	private BigDecimal iva;
	
	@Column(name=TOTAL)
	private BigDecimal total;
	
	
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

	public ProveedorDTO getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorDTO proveedor) {
		this.proveedor = proveedor;
	}

	public TipoCompra getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(TipoCompra tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Date getFechaEsperada() {
		return fechaEsperada;
	}

	public void setFechaEsperada(Date fechaEsperada) {
		this.fechaEsperada = fechaEsperada;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Date getFechaEmbarque() {
		return fechaEmbarque;
	}

	public void setFechaEmbarque(Date fechaEmbarque) {
		this.fechaEmbarque = fechaEmbarque;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public BigDecimal getFlete() {
		return flete;
	}

	public void setFlete(BigDecimal flete) {
		this.flete = flete;
	}

	public BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}

	public Long getBodegaDestino() {
		return bodegaDestino;
	}

	public void setBodegaDestino(Long bodegaDestino) {
		this.bodegaDestino = bodegaDestino;
	}

	public Long getPuertoOrigen() {
		return puertoOrigen;
	}

	public void setPuertoOrigen(Long puertoOrigen) {
		this.puertoOrigen = puertoOrigen;
	}

	public Long getPuertoDestino() {
		return puertoDestino;
	}

	public void setPuertoDestino(Long puertoDestino) {
		this.puertoDestino = puertoDestino;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public EtapaCompra getEtapaCompra() {
		return etapaCompra;
	}

	public void setEtapaCompra(EtapaCompra etapaCompra) {
		this.etapaCompra = etapaCompra;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getDescuento() {
		return descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public BigDecimal getNeto() {
		return neto;
	}

	public void setNeto(BigDecimal neto) {
		this.neto = neto;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
	
}
