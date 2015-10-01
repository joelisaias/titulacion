package ec.edu.ug.erp.util.constantes;

public interface ISequenceTables {

	/*
	 * ADMINISTRACION
	 */
	public static final String EMPRESA="ADMISEMPRESA";
	public static final String SUCURSAL="ADMISSUCURSAL";
	public static final String DIVISION_NEGOCIO="ADMISDIVISION_NEGOCIO";
	
	/*
	 * GENERAL 
	 */
	public static final String DIVISION_GEOGRAFICA="GENESDIVISION_GEOGRAFICA";
	public static final String IMPUESTO="GENESIMPUESTO";
	public static final String MONEDA="GENESMONEDA";
	public static final String REGION="GENESREGION";
	
	/*
	 *RECURSOS HUMANOS 
	 */
	public static final String PERSONA="RRHHSPERSONA";
	public static final String EMPRESA_PERSONA="RRHHSEMPRESA_PERSONA";
	
	/*
	 *SEGURIDAD 
	 */
	public static final String MODULO="SEGUSMODULO";
	public static final String ROL="SEGUSROL";
	public static final String TAREA="SEGUSTAREA";	
	public static final String TAREA_ROL="SEGUSTAREA_ROL";
	public static final String USUARIO="SEGUSUSUARIO";
	public static final String USUARIO_ROL="SEGUSUSUARIO_ROL";
	public static final String USUARIO_SUCURSAL="SEGUSUSUARIO_SUCURSAL";
	
	/*
	 * COMPRAS
	 */
	public static final String ORDEN_COMPRA="COMPSORDEN_COMPRA";
	public static final String ORDEN_COMPRA_DETALLE="COMPSORDEN_COMPRA_DETALLE";
	public static final String RECEPCION_COMPRA="COMPSRECEPCION_COMPRA";
	public static final String RECEPCION_COMPRA_DETALLE="COMPSRECEPCION_COMPRA_DETALLE";
	public static final String FACTURA_COMPRA="COMPSFACTURA_COMPRA";
	public static final String FACTURA_COMPRA_DETALLE="COMPSFACTURA_COMPRA_DETALLE";
	
	
	
}
