package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;

import org.eclipse.papyrus.qompass.designer.core.Description;

public class ConfigOptionLabelProvider extends LabelProvider implements ITableLabelProvider {

	public String getText(Object element) {
		return ((Class)element).getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		if(columnIndex == 0) {
			return getText(element);
		} else if(columnIndex == 1) {
			return Description.getDescription((Class)element);
		}
		return null;
	}

	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
};
