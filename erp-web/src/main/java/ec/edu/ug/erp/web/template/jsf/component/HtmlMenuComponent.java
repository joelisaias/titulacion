package ec.edu.ug.erp.web.template.jsf.component;

import java.io.IOException;
import java.util.List;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;


/**
 * Componente personalizado para generar menu Html5 utilizando el modelo de los menus de Primefaces conbinandolos con estilos de bootstrap 
 * 
 * @author Joel Alvarado
 * @since 2015-08-24
 * @category Componente
 * @version 1.0
 * @see  <a href="http://www.adictosaltrabajo.com/tutoriales/custom-jsf-component/">http://www.adictosaltrabajo.com/tutoriales/custom-jsf-component/</a>
 * @see	 <a href="http://www.adictosaltrabajo.com/tutoriales/jsf-component/">http://www.adictosaltrabajo.com/tutoriales/jsf-component/</a>
 * @see  <a href="https://github.com/primefaces/primefaces/tree/master/src/main/java/org/primefaces/component/menu">https://github.com/primefaces/primefaces/tree/master/src/main/java/org/primefaces/component/menu</a>
 * @see  <a href="https://github.com/primefaces/primefaces/tree/master/src/main/java/org/primefaces/model/menu">https://github.com/primefaces/primefaces/tree/master/src/main/java/org/primefaces/model/menu</a>
 */
@FacesComponent(value="HtmlMenuComponent")
public class HtmlMenuComponent extends UIComponentBase {

	
	public static final String MODEL_ATTRIBUTE="model";
	
	public static final String HTML_A="a";	
	public static final String HTML_I="i";	
	public static final String HTML_UL="ul";
	public static final String HTML_LI="li";
	public static final String HTML_DIV="div";
	public static final String HTML_SPAN="span";
	public static final String HTML_INPUT="input";
	public static final String HTML_BUTTON="button";
	public static final String HTML_ATTR_ID="id";
	public static final String HTML_ATTR_TYPE="type";
	public static final String HTML_ATTR_CLASS="class";
	public static final String HTML_ATTR_STYLE="style";
	public static final String HTML_ATTR_HREF="href";
	
	public static final String COL_MENU_CLASS="col-xs-2 col-sm-2";
	public static final String MAIN_MENU_CLASS="nav main-menu";
	public static final String SEARCH_MENU_CLASS="sidebar-search";
	public static final String SEARCH_INPUT_CLASS="input-group custom-search-form";
	public static final String FORMCONTROL_CLASS="form-control";
	public static final String INPUTGROUPBTN_CLASS="input-group-btn";
	public static final String BTNDEFAULT_CLASS="btn btn-default";
	public static final String FA_SEARCH_CLASS="fa fa-search";
	public static final String SUBMENU_CLASS="dropdown";
	public static final String SUBMENU_ICON_CLASS="fa arrow";
	public static final String SUBMENU_TOGGLE_CLASS="dropdown-toggle";
	public static final String SUBMENU_LABEL_CLASS="hidden-xs";
	public static final String SUBMENU_CHILD_CLASS="dropdown-menu";
	public static final String LINK_CLASS="option-link";
	public static final String HREF_NONE="#";
	public static final String STRING_EMPTY="";
	public static final String ID_VALUE="sidebar-left";
	public static final String DEFAULT_SUBMENU_ICON="fa fa-list";
	public static final String DEFAULT_MENUITEM_ICON="fa fa-angle-double-right";
	public static final String STYLE_HIDDEN="display:none";

	
	
	
	
	
	@Override
	public String getFamily() {
		return null;
	}
	
	@Override
	public void encodeAll(FacesContext context) throws IOException {
		final ResponseWriter writer;	
		final MenuModel model =(MenuModel) this.getAttributes().get(MODEL_ATTRIBUTE);
		writer=context.getResponseWriter();
		
		//creacion de contenedor de menus
		writer.startElement(HTML_DIV, this);
		writer.writeAttribute(HTML_ATTR_ID, ID_VALUE, null);
		writer.writeAttribute(HTML_ATTR_CLASS, COL_MENU_CLASS, null);
		writer.startElement(HTML_UL, this);
		writer.writeAttribute(HTML_ATTR_CLASS, MAIN_MENU_CLASS, null);
		
		writer.startElement(HTML_LI, this);
		writer.writeAttribute(HTML_ATTR_CLASS, SEARCH_MENU_CLASS, null);
		writer.startElement(HTML_DIV, this);
		writer.writeAttribute(HTML_ATTR_CLASS, SEARCH_INPUT_CLASS, null);
		writer.startElement(HTML_INPUT, this);
		writer.writeAttribute(HTML_ATTR_CLASS, FORMCONTROL_CLASS, null);
		writer.endElement(HTML_INPUT);
		writer.startElement(HTML_SPAN, this);
		writer.writeAttribute(HTML_ATTR_CLASS, INPUTGROUPBTN_CLASS, null);
		writer.startElement(HTML_BUTTON, this);
		writer.writeAttribute(HTML_ATTR_CLASS, BTNDEFAULT_CLASS, null);
		writer.writeAttribute(HTML_ATTR_TYPE, HTML_BUTTON, null);
		writer.startElement(HTML_I, this);
		writer.writeAttribute(HTML_ATTR_CLASS, FA_SEARCH_CLASS, null);
		writer.endElement(HTML_I);
		writer.endElement(HTML_BUTTON);
		writer.endElement(HTML_SPAN);
		writer.endElement(HTML_DIV);		
		writer.endElement(HTML_LI);		
		
		
		//creacion de submenus
		encodeModel(writer,model);

		//se cierra el contenedor de menus
		writer.endElement(HTML_UL);		
		writer.endElement(HTML_DIV);
		
		//se cierra escritura y se completa la respuesta del requerimiento
		writer.close();
		context.responseComplete();


	}
	
	private void encodeModel(ResponseWriter writer, MenuModel model) throws IOException{
		if(model!=null)
			encodeElements(writer,model.getElements());		
	}
	
	@SuppressWarnings("unchecked")
	private void encodeElements(ResponseWriter writer, List<MenuElement> elements) throws IOException{
		for (MenuElement element : elements) {
			if(element instanceof Submenu){
				//se construyen los submenus
				Submenu submenu=(Submenu) element;
				writer.startElement(HTML_LI, this);		
				writer.writeAttribute(HTML_ATTR_CLASS, SUBMENU_CLASS, null);
				writer.startElement(HTML_A, this);
				writer.writeAttribute(HTML_ATTR_CLASS, SUBMENU_TOGGLE_CLASS, null);
				writer.writeAttribute(HTML_ATTR_HREF, HREF_NONE, null);
				writer.startElement(HTML_I, this);
				writer.writeAttribute(HTML_ATTR_CLASS, submenu.getIcon()!=null?submenu.getIcon():DEFAULT_SUBMENU_ICON, null);
				writer.endElement(HTML_I);		
				writer.startElement(HTML_SPAN, this);
				writer.writeAttribute(HTML_ATTR_CLASS, SUBMENU_LABEL_CLASS, null);
				writer.writeText(submenu.getLabel()!=null?submenu.getLabel():STRING_EMPTY, null);
				writer.endElement(HTML_SPAN);		
				writer.startElement(HTML_SPAN, this);
				writer.writeAttribute(HTML_ATTR_CLASS, SUBMENU_ICON_CLASS, null);
				writer.endElement(HTML_SPAN);		
				writer.endElement(HTML_A);
				writer.startElement		(HTML_UL		, this);
				writer.writeAttribute	(HTML_ATTR_CLASS, SUBMENU_CHILD_CLASS, null);
				//creacion de usbmenus de nivel N o menu items
				if(submenu.getElements()!=null)					
					encodeElements(writer,(List<MenuElement>)submenu.getElements());
				writer.endElement(HTML_UL);
				writer.endElement(HTML_LI);		
				
				/*************************************************************************************
				 * CODIGO QUE GENERA
				 * ***********************************************************************************
				 *<li class="dropdown">
				 *<a href="#" class="dropdown-toggle">
				 *	<i class="icon"></i>
				 *	<span class="hidden-xs">Label</span>
				 *</a>
				 *<ul class="dropdown-menu">
				 *	<li>...
				 *</ul>
				 *</li> 
				 */
				
								
				
				
			}else if(element instanceof MenuItem){
				//se construyen los menu items
				MenuItem item=(MenuItem)element;
				writer.startElement(HTML_LI, this);		
				writer.startElement(HTML_A, this);
				writer.writeAttribute(HTML_ATTR_CLASS, LINK_CLASS, null);
				writer.writeAttribute(HTML_ATTR_HREF, HREF_NONE, null);
				writer.startElement(HTML_I, this);
				writer.writeAttribute(HTML_ATTR_CLASS, item.getIcon()!=null?item.getIcon():DEFAULT_MENUITEM_ICON, null);
				writer.endElement(HTML_I);		
				writer.startElement(HTML_SPAN, this);
				if(item.getIcon()!=null)
					writer.writeAttribute(HTML_ATTR_CLASS,SUBMENU_LABEL_CLASS, null);
				writer.writeText(item.getValue()!=null?item.getValue():STRING_EMPTY, null);
				writer.endElement(HTML_SPAN);
				writer.startElement(HTML_SPAN, this);
				writer.writeAttribute(HTML_ATTR_STYLE,STYLE_HIDDEN, null);
				writer.writeText(item.getCommand(),null);
				writer.endElement(HTML_SPAN);
				writer.endElement(HTML_A);		
				writer.endElement(HTML_LI);
				
				/*************************************************************************************
				 * CODIGO QUE GENERA
				 * ***********************************************************************************
				 *	<li><a class="ajax-link" href="#">child1</a></li>
				 *	<li><a class="ajax-link" href="#">child2</a></li>
				 *	<li><a class="ajax-link" href="#">child3</a></li>
				 *	<li><a class="ajax-link" href="#">child4</a></li>
				 *	<li><a class="ajax-link" href="#">child5</a></li>
				 *	<li>...
				 *	<li><a class="ajax-link" href="#">childN</a></li>
				 */

			}
		}
	};
	

}
