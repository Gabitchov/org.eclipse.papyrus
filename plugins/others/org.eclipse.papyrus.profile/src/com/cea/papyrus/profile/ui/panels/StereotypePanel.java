/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package com.cea.papyrus.profile.ui.panels;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;

import com.cea.papyrus.profile.tree.objects.PropertyTreeObject;
import com.cea.papyrus.profile.tree.objects.RootElementTreeObject;
import com.cea.papyrus.profile.ui.composites.PropertyComposite;
import com.cea.papyrus.profile.ui.composites.StereotypeComposite;

// TODO: Auto-generated Javadoc
/**
 * The Class StereotypePanel.
 */
public class StereotypePanel extends AbstractPanel {

	// The selected Class in the model explorer or model diagram
	/**
	 * The selected.
	 */
	protected Element selected;

	/**
	 * The stereotype composite.
	 */
	protected StereotypeComposite stereotypeComposite;
	
	/**
	 * The property composite.
	 */
	protected PropertyComposite   propertyComposite;
	
    /**
     * 
     */
    protected Composite parent;
    
    /**
     * 
     */
    public TabbedPropertySheetWidgetFactory factory;


	/**
	 * The default constructor.
	 * 
	 * @param style the style of this panel
	 * @param parent the parent Composite for this panel
	 */
	public StereotypePanel(Composite parent, int style) {
		super(parent, style);
		factory = new TabbedPropertySheetWidgetFactory();
		this.parent = parent;
	}
	
	/**
	 * A constructor parameterized by a factory.
	 * 
	 * @param style 
	 * @param factory 
	 * @param parent 
	 */
	public StereotypePanel(Composite parent, TabbedPropertySheetWidgetFactory factory, int style){
		super(parent, style);
		this.factory=factory;
		this.parent=parent;
	}

	/**
	 * Gets the selected.
	 * 
	 * @return Returns the selected.
	 */
	public Element getSelected() {
		return selected;
	}

	/**
	 * Sets the selected.
	 * 
	 * @param selected The selected to set.
	 * @param elt the elt
	 */
	public void setSelected(Element elt) {
		
		if (stereotypeComposite != null) {
			selected = elt;
			stereotypeComposite.setInput(new RootElementTreeObject(elt));
			refresh();
		}
	}
	
	/**
	 * Sets the selected property.
	 * 
	 * @param selected The selected to set.
	 * @param elt the elt
	 */
	public void setSelectedProperty(PropertyTreeObject elt) {
		propertyComposite.setInput(elt);
	}

	/**
	 * Gets the control.
	 * 
	 * @return the control for this panel
	 */
	public Control getControl() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.odf.platform.uml2.ui.panels.AbstractPanel#createContent()
	 */
	/**
	 * Creates the content.
	 * 
	 * @return the control
	 */
	@Override
	public Control createContent() {

		this.setLayout(new FormLayout());
		
		// Create profile composite
		stereotypeComposite = new StereotypeComposite(this);
		stereotypeComposite.createContent(this, factory);
	
		propertyComposite   = new PropertyComposite(this);
		propertyComposite.createContent(this, factory);

		FormData data;

		// stereotypeComposite placement
		data         = new FormData();
		data.left    = new FormAttachment(0, 0);
		data.right   = new FormAttachment(50);
		data.top     = new FormAttachment(0, 0);
		data.bottom  = new FormAttachment(100, 0);

		stereotypeComposite.setLayoutData(data);

		// propertyComposite placement
		data         = new FormData();
		data.left    = new FormAttachment(stereotypeComposite, 0);
		data.right   = new FormAttachment(100,0);
		data.top     = new FormAttachment(0, 0);
		data.bottom  = new FormAttachment(100, 0);

		propertyComposite.setLayoutData(data);
		return this;
	}


	/**
	 * Refresh the composites.
	 */
	@Override
	public void refresh() {
		// Refresh stereotypes and property values
		stereotypeComposite.refresh();	
		propertyComposite.refresh();	  	
	}
}
