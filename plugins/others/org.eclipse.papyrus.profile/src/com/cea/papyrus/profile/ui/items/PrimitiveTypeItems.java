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
package com.cea.papyrus.profile.ui.items;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.uml2.uml.Property;

// TODO: Auto-generated Javadoc
/**
 * The Class PrimitiveTypeItems.
 */
public class PrimitiveTypeItems {

	/**
	 * Creates new PrimitiveType items in the property table.
	 * 
	 * @param table the table
	 * @param value current value of the property
	 * @param property currently selected property
	 */
	public PrimitiveTypeItems(Table table, Property property, Object value) {
		if(property.isMultivalued()) { 
			// property is multivalued
			final List propValues = (List) value;

			for (int i=0 ; i < propValues.size() ; i++) {
				// Create item in property table
				TableItem propValueItem = new TableItem(table, SWT.NONE);
				propValueItem.setText(propValues.get(i).toString());
				propValueItem.setData(propValues.get(i));
			}

		} else { // property is not multivalued

			// if the property has a value
			if (value != null) {
				TableItem propValueItem = new TableItem(table, SWT.NONE);
				propValueItem.setText(value.toString());
			}
		}
	}
}
