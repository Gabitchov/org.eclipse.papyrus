package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Port;

/**
 * A label provider for either UML or FCM ports
 * 
 * @author ansgar
 * 
 */
public class PortLabelProvider extends LabelProvider implements ITableLabelProvider {

	/**
	 * small helper function: simply retrieval of port (element might be either a port or an FCM port)
	 * 
	 * @param element
	 * @return
	 */
	private Port getUMLport(Object element) {
		if(element instanceof org.eclipse.papyrus.FCM.Port) {
			org.eclipse.papyrus.FCM.Port port = (org.eclipse.papyrus.FCM.Port)element;
			if(port != null) {
				return port.getBase_Port();
			}
		} else if(element instanceof Port) {
			return (Port)element;
		}
		return null;
	}

	public String getText(Object element) {
		Port umlPort = getUMLport(element);
		if(umlPort != null) {
			return umlPort.getName();
		}
		return "";
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
			Port umlPort = getUMLport(element);
			if(umlPort != null) {
				return umlPort.getType().getName();
			}
		}
		return "";
	}

	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
};
