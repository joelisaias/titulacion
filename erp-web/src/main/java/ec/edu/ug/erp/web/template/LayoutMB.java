package ec.edu.ug.erp.web.template;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.extensions.model.layout.LayoutOptions;

@Named("layoutMB")
@ViewScoped
public class LayoutMB implements Serializable{
	 private static final long serialVersionUID = 20120925L;  
	  
	    private String stateOne;  
	    private String stateTwo;  
	    private boolean layoutOneShown = true;  
	  
	    private LayoutOptions layoutOptionsOne;  
	    private LayoutOptions layoutOptionsTwo;  
	  
	    @PostConstruct  
	    protected void initialize() {  
	        // 1. set options for first layout  
	        layoutOptionsOne = new LayoutOptions();  
	  
	        // options for all panes (center and west)  
	        LayoutOptions panes = new LayoutOptions();  
	        panes.addOption("slidable", false);  
	        panes.addOption("resizeWhileDragging", true);  
	        layoutOptionsOne.setPanesOptions(panes);  
	  
	        // options for west pane  
	        LayoutOptions west = new LayoutOptions();  
	        west.addOption("size", 150);  
	        west.addOption("minSize", 40);  
	        west.addOption("maxSize", 300);  
	        layoutOptionsOne.setWestOptions(west);  
	  
	        // 2. set options for second layout  
	        layoutOptionsTwo = new LayoutOptions();  
	  
	        // options for all panes  
	        panes = new LayoutOptions();  
	        panes.addOption("slidable", false);  
	        panes.addOption("resizeWhileDragging", true);  
	        layoutOptionsTwo.setPanesOptions(panes);  
	  
	        // options for east pane  
	        LayoutOptions east = new LayoutOptions();  
	        panes.addOption("resizable", false);  
	        panes.addOption("closable", false);  
	        east.addOption("size", "50%");  
	        layoutOptionsTwo.setEastOptions(east);  
	  
	        // options for nested east layout  
	        LayoutOptions childEastOptions = new LayoutOptions();  
	        east.setChildOptions(childEastOptions);  
	  
	        // options for east-south pane  
	        LayoutOptions eastSouth = new LayoutOptions();  
	        eastSouth.addOption("size", "50%");  
	        childEastOptions.setSouthOptions(eastSouth);  
	    }  
	  
	    public String getStateOne() {  
	        return stateOne;  
	    }  
	  
	    public void setStateOne(String stateOne) {  
	        this.stateOne = stateOne;  
	    }  
	  
	    public String getStateTwo() {  
	        return stateTwo;  
	    }  
	  
	    public void setStateTwo(String stateTwo) {  
	        this.stateTwo = stateTwo;  
	    }  
	  
	    public void toogleLayout(ActionEvent event) {  
	        layoutOneShown = !layoutOneShown;  
	    }  
	  
	    public boolean isLayoutOneShown() {  
	        return layoutOneShown;  
	    }  
	  
	    public LayoutOptions getLayoutOptionsOne() {  
	        return layoutOptionsOne;  
	    }  
	  
	    public LayoutOptions getLayoutOptionsTwo() {  
	        return layoutOptionsTwo;  
	    }  
	
	
//	 private static final long serialVersionUID = 20120925L;  
//	  
//	    private LayoutOptions layoutOptions;  
//	  
//	    @PostConstruct  
//	    protected void initialize() {  
//	        layoutOptions = new LayoutOptions();  
//	  
//	        // options for all panes  
//	        LayoutOptions panes = new LayoutOptions();  
//	        panes.addOption("slidable", false);  
//	        panes.addOption("resizeWhileDragging", false);  
//	        layoutOptions.setPanesOptions(panes);  
//	  
//	        // options for center pane  
//	        LayoutOptions center = new LayoutOptions();  
//	        layoutOptions.setCenterOptions(center);  
//	  
//	        // options for nested center layout  
//	        LayoutOptions childCenterOptions = new LayoutOptions();  
//	        center.setChildOptions(childCenterOptions);  
//	  
//	        // options for center-north pane  
//	        LayoutOptions centerNorth = new LayoutOptions();  
//	        centerNorth.addOption("size", "50%");  
//	        childCenterOptions.setNorthOptions(centerNorth);  
//	  
//	        // options for center-center pane  
//	        LayoutOptions centerCenter = new LayoutOptions();  
//	        centerCenter.addOption("minHeight", 60);  
//	        childCenterOptions.setCenterOptions(centerCenter);  
//	  
//	        // options for west pane  
//	        LayoutOptions west = new LayoutOptions();  
//	        west.addOption("size", 200);  
//	        layoutOptions.setWestOptions(west);  
//	  
//	        // options for nested west layout  
//	        LayoutOptions childWestOptions = new LayoutOptions();  
//	        west.setChildOptions(childWestOptions);  
//	  
//	        // options for west-north pane  
//	        LayoutOptions westNorth = new LayoutOptions();  
//	        westNorth.addOption("size", "33%");  
//	        childWestOptions.setNorthOptions(westNorth);  
//	  
//	        // options for west-center pane  
//	        LayoutOptions westCenter = new LayoutOptions();  
//	        westCenter.addOption("minHeight", "60");  
//	        childWestOptions.setCenterOptions(westCenter);  
//	  
//	        // options for west-south pane  
//	        LayoutOptions westSouth = new LayoutOptions();  
//	        westSouth.addOption("size", "33%");  
//	        childWestOptions.setSouthOptions(westSouth);  
//	  
//	        // options for east pane  
//	        LayoutOptions east = new LayoutOptions();  
//	        east.addOption("size", 200);  
//	        layoutOptions.setEastOptions(east);  
//	  
//	        // options for south pane  
//	        LayoutOptions south = new LayoutOptions();  
//	        south.addOption("size", 80);  
//	        layoutOptions.setSouthOptions(south);  
//	    }  
//	  
//	    public LayoutOptions getLayoutOptions() {  
//	        return layoutOptions;  
//	    }  
//	  
//	    public void handleClose(CloseEvent event) {  
//	        FacesMessage msg =  
//	            new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane closed",  
//	                             "Position:" + ((LayoutPane) event.getComponent()).getPosition());  
//	  
//	        FacesContext.getCurrentInstance().addMessage(null, msg);  
//	    }  
//	  
//	    public void handleOpen(OpenEvent event) {  
//	        FacesMessage msg =  
//	            new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane opened",  
//	                             "Position:" + ((LayoutPane) event.getComponent()).getPosition());  
//	  
//	        FacesContext.getCurrentInstance().addMessage(null, msg);  
//	    }  
//	  
//	    public void handleResize(ResizeEvent event) {  
//	        FacesMessage msg =  
//	            new FacesMessage(FacesMessage.SEVERITY_INFO, "Layout Pane resized",  
//	                             "Position:" + ((LayoutPane) event.getComponent()).getPosition() + ", new width = "  
//	                             + event.getWidth() + "px, new height = " + event.getHeight() + "px");  
//	  
//	        FacesContext.getCurrentInstance().addMessage(null, msg);  
//	    }  
}
