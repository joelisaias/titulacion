package ec.edu.ug.erp.dto.compras;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ec.edu.ug.erp.util.dto.generic.impl.GenericDTO;
import ec.edu.ug.erp.util.type.StringValuedEnum;
import ec.edu.ug.erp.util.type.StringValuedEnumReflect;
import ec.edu.ug.erp.util.type.StringValuedEnumType;


public abstract class GenericComprasDTO<T extends GenericDTO<?>> extends GenericDTO<GenericComprasDTO<?>> {

	private static final long serialVersionUID = 8874999981115162154L;
	
	
	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-10-01
	 *
	 */
	public enum TipoCompra implements StringValuedEnum<TipoCompra> {
		LOCAL("L"),
		IMPORTADA("I"),
		;

		public static class Type extends StringValuedEnumType<TipoCompra> {}
		public static final String TYPE = "ec.edu.ug.erp.dto.compras.GenericComprasDTO$TipoCompra$Type";

		public boolean isLocal() { return this.equals(LOCAL); }
		public boolean isImportada() { return this.equals(IMPORTADA); }

		private String val;
		private String labelKey;
		
		public static Map<String, TipoCompra> LABELED_MAP;
		
		public static final List<TipoCompra> LIST =
			Arrays.asList(TipoCompra.values());

		private TipoCompra(String value) {
			this.val 	  = value;
			this.labelKey = StringValuedEnumReflect.getLabelKeyFromEnum(this);
		}
		

		public String getVal() {
			return val;
		}		
		
		public String getKey() {
			return labelKey;
		}
		public String getValue() {
			return val;
		}
		
		public String getDescription() {
			return getValue();
		}
	}


	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-10-01
	 *
	 */
	public enum TipoTransporte implements StringValuedEnum<TipoTransporte> {
		MARITIMO("M"),
		AEREO("A"),
		TERRESTRE("R"),
		;

		public static class Type extends StringValuedEnumType<TipoTransporte> {}
		public static final String TYPE = "ec.edu.ug.erp.dto.compras.GenericComprasDTO$TipoTransporte$Type";

		public boolean isMaritimo() { return this.equals(MARITIMO); }
		public boolean isAereo() { return this.equals(AEREO); }
		public boolean isTerrsetre() { return this.equals(TERRESTRE); }

		private String val;
		private String labelKey;
		
		public static Map<String, TipoTransporte> LABELED_MAP;
		
		public static final List<TipoTransporte> LIST =
			Arrays.asList(TipoTransporte.values());

		private TipoTransporte(String value) {
			this.val 	  = value;
			this.labelKey = StringValuedEnumReflect.getLabelKeyFromEnum(this);
		}
		

		public String getVal() {
			return val;
		}		
		
		public String getKey() {
			return labelKey;
		}
		public String getValue() {
			return val;
		}
		
		public String getDescription() {
			return getValue();
		}
	}
	
	/**
	 * 
	 * @author Joel Alvarado
	 * @since  2015-10-01
	 *
	 */
	public enum EtapaCompra implements StringValuedEnum<EtapaCompra> {
		REGISTRADA("R"),
		PENDIENTEAUTORIZACION("P"),
		AUTORIZADA("A"),
		ENRECEPCION("E"),
		RECEPCIONPARCIAL("L"),
		RECEPCIONCOMPLETA("C"),
		ENREGISTRODEFACTURA("F"),
		FINALIZADOCOMPLETO("T"),
		FINALIZADOINCOMPLETO("I"),
		CANCELADA("X"),
		;

		public static class Type extends StringValuedEnumType<EtapaCompra> {}
		public static final String TYPE = "ec.edu.ug.erp.dto.compras.GenericComprasDTO$EtapaCompra$Type";

		public boolean isRegistrada() { return this.equals(REGISTRADA); }
		public boolean isPendienteAutorizacion() { return this.equals(PENDIENTEAUTORIZACION); }
		public boolean isAutorizada() { return this.equals(AUTORIZADA); }
		public boolean isEnRecepcion() { return this.equals(ENRECEPCION); }
		public boolean isRecepcionParcial() { return this.equals(RECEPCIONPARCIAL); }
		public boolean isRecepcionCompleta() { return this.equals(RECEPCIONCOMPLETA); }
		public boolean isEnRegistroFactura() { return this.equals(ENREGISTRODEFACTURA); }
		public boolean isFinalizadoCompleto() { return this.equals(FINALIZADOCOMPLETO); }
		public boolean isFinalizadoIncompleto() { return this.equals(FINALIZADOINCOMPLETO); }
		public boolean isCancelada() { return this.equals(CANCELADA); }

		private String val;
		private String labelKey;
		
		public static Map<String, EtapaCompra> LABELED_MAP;
		
		public static final List<EtapaCompra> LIST =
			Arrays.asList(EtapaCompra.values());

		private EtapaCompra(String value) {
			this.val 	  = value;
			this.labelKey = StringValuedEnumReflect.getLabelKeyFromEnum(this);
		}
		

		public String getVal() {
			return val;
		}		
		
		public String getKey() {
			return labelKey;
		}
		public String getValue() {
			return val;
		}
		
		public String getDescription() {
			return getValue();
		}
	}

	
}
