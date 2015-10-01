package ec.edu.ug.erp.util.constantes;

public interface ISequenceGenerators {

	public static final String EMPRESA="ADMIGEMPRESA";
	public static final String SUCURSAL="ADMIGSUCURSAL";
	public static final String DIVISION_NEGOCIO="ADMIGDIVISION_NEGOCIO";
	
	/*
	 * GENERAL 
	 */
	public static final String DIVISION_GEOGRAFICA="GENEGDIVISION_GEOGRAFICA";
	public static final String IMPUESTO="GENEGIMPUESTO";
	public static final String MONEDA="GENEGMONEDA";
	public static final String REGION="GENEGREGION";
	
	/*
	 *RECURSOS HUMANOS 
	 */
	public static final String PERSONA="RRHHGPERSONA";
	public static final String EMPRESA_PERSONA="RRHHGEMPRESA_PERSONA";
	
	/*
	 *SEGURIDAD 
	 */
	public static final String MODULO="SEGUGMODULO";
	public static final String ROL="SEGUGROL";
	public static final String TAREA="SEGUGTAREA";	
	public static final String TAREA_ROL="SEGUGTAREA_ROL";
	public static final String USUARIO="SEGUGUSUARIO";
	public static final String USUARIO_ROL="SEGUGUSUARIO_ROL";
	public static final String USUARIO_SUCURSAL="SEGUGUSUARIO_SUCURSAL";
	
	/*
	 * COMPRAS
	 */
	public static final String ORDEN_COMPRA="COMPGORDEN_COMPRA";
	public static final String ORDEN_COMPRA_DETALLE="COMPGORDEN_COMPRA_DETALLE";
	public static final String RECEPCION_COMPRA="COMPGRECEPCION_COMPRA";
	public static final String RECEPCION_COMPRA_DETALLE="COMPGRECEPCION_COMPRA_DETALLE";
	public static final String FACTURA_COMPRA="COMPGFACTURA_COMPRA";
	public static final String FACTURA_COMPRA_DETALLE="COMPGFACTURA_COMPRA_DETALLE";
	
}
