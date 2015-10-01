package ec.edu.ug.erp.util.constantes;

public interface ITableNames {

	/*
	 * ADMINISTRACION
	 */
	public static final String EMPRESA="ADMITEMPRESA";
	public static final String SUCURSAL="ADMITSUCURSAL";
	public static final String DIVISION_NEGOCIO="ADMITDIVISION_NEGOCIO";
	
	/*
	 * GENERAL 
	 */
	public static final String DIVISION_GEOGRAFICA="GENETDIVISION_GEOGRAFICA";
	public static final String IMPUESTO="GENETIMPUESTO";
	public static final String MONEDA="GENETMONEDA";
	public static final String REGION="GENETREGION";
	
	/*
	 *RECURSOS HUMANOS 
	 */
	public static final String PERSONA="RRHHTPERSONA";
	public static final String EMPRESA_PERSONA="RRHHTEMPRESA_PERSONA";
	
	/*
	 *SEGURIDAD 
	 */
	public static final String MODULO="SEGUTMODULO";
	public static final String ROL="SEGUTROL";
	public static final String TAREA="SEGUTTAREA";	
	public static final String TAREA_ROL="SEGUTTAREA_ROL";
	public static final String USUARIO="SEGUTUSUARIO";
	public static final String USUARIO_ROL="SEGUTUSUARIO_ROL";
	public static final String USUARIO_SUCURSAL="SEGUTUSUARIO_SUCURSAL";
	
	/*
	 * COMPRAS
	 */
	public static final String ORDEN_COMPRA="COMPTORDEN_COMPRA";
	public static final String ORDEN_COMPRA_DETALLE="COMPTORDEN_COMPRA_DETALLE";
	public static final String RECEPCION_COMPRA="COMPTRECEPCION_COMPRA";
	public static final String RECEPCION_COMPRA_DETALLE="COMPTRECEPCION_COMPRA_DETALLE";
	public static final String FACTURA_COMPRA="COMPTFACTURA_COMPRA";
	public static final String FACTURA_COMPRA_DETALLE="COMPTFACTURA_COMPRA_DETALLE";
	public static final String PROVEEDOR="COMPTPROVEEDOR";
	
	
}
