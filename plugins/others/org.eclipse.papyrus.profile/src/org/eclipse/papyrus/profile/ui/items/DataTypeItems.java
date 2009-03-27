package org.eclipse.papyrus.profile.ui.items;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.uml2.uml.Property;

public class DataTypeItems {
	/**
	 * Creates new DataType items in the property table.
	 * 
	 * @param table the table
	 * @param value current value of the property
	 * @param property currently selected property
	 */
	public DataTypeItems(Table table, Property property, Object value) {
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
