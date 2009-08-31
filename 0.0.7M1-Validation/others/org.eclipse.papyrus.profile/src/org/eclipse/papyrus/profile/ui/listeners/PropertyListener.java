/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.listeners;

import java.util.List;

import org.eclipse.papyrus.profile.ui.panels.AbstractPanel;
import org.eclipse.papyrus.profile.utils.Util;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;


// TODO: Auto-generated Javadoc
/**
 * The Class PropertyListener.
 */
public class PropertyListener implements Listener {

	/**
	 * The property.
	 */
	protected final Property property;
	
	/**
	 * The stereotype.
	 */
	protected final Stereotype stereotype;
	
	/**
	 * The element.
	 */
	protected final Element element;
	
	/**
	 * The parent.
	 */
	protected final AbstractPanel parent;
	
	/**
	 * The table.
	 */
	protected final Table table;
	
	/**
	 * The is multivalued.
	 */
	protected final boolean isMultivalued;
	
	/**
	 * The values.
	 */
	protected List values;
	
	/**
	 * The value.
	 */
	protected Object value;
	
	/**
	 * Constructor.
	 * 
	 * @param element the element
	 * @param table the table
	 * @param stereotype the stereotype
	 * @param property the property
	 * @param parent the parent
	 * 
	 * @throws Exception 	 */
	public PropertyListener(AbstractPanel parent, Table table, Property property, Stereotype stereotype, Element element) {
		super();
		
		// Set properties
		this.property = property;
		this.stereotype = stereotype;
		this.element = element;
		this.parent = parent;
		this.table = table;
		
		// Retrieve iisMultivalued property
		this.isMultivalued = property.isMultivalued();
	}
	
	/**
	 * Init.
	 * 
	 * @throws NoValueException the no value exception
	 */
	protected void init() throws NoValueException {
		// Retrieve current value
		Object tmp = Util.getValueOrDefault(element, stereotype, property);
		if (isMultivalued) {
			this.values = (List) tmp;
		} else {
			this.value = tmp;
		}
		
		// No value exception
		if (isMultivalued) {
			if ((values == null) || (values.size() == 0)) {
				//exception
				throw new NoValueException();
			}
		} else {
			if (value == null) {
				//exception
				throw new NoValueException();
			}
		}
	}
	
	/**
	 * Handle event.
	 * 
	 * @param event the event
	 */
	public void handleEvent(Event event) {
		// TODO Auto-generated method stub
	}
}
