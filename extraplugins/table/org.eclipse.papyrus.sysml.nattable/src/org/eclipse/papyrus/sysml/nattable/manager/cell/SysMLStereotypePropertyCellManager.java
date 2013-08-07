/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.nattable.manager.cell;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml.service.types.matcher.FlowPortNAMatcher;
import org.eclipse.papyrus.uml.nattable.manager.cell.StereotypePropertyCellManager;
import org.eclipse.papyrus.uml.nattable.utils.Constants;
import org.eclipse.uml2.uml.Port;

/**
 * 
 * This cell manager manages the cell displaying the direction of the FlowPort.
 * If the flowport is not atomic, the cell is not editable and the direction is N/A.
 * 
 */
public class SysMLStereotypePropertyCellManager extends StereotypePropertyCellManager {

	/**
	 * the FlowPort isAtomicMatcher
	 */
	private static FlowPortNAMatcher matcher = new FlowPortNAMatcher();


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.cell.manager.StereotypePropertyCellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean handles(final Object columnElement, final Object rowElement) {
		if(super.handles(columnElement, rowElement)) {
			final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
			if(objects.size() == 2) {
				final EObject object = (EObject)objects.get(0);
				if(object instanceof Port) {
					String propertyQualifiedName = (String)objects.get(1);
					propertyQualifiedName = propertyQualifiedName.substring(Constants.PROPERTY_OF_STEREOTYPE_PREFIX.length(), propertyQualifiedName.length());
					return propertyQualifiedName.equals(org.eclipse.papyrus.sysml.nattable.utils.Constants.STEREOTYPE_FLOWPORT_DIRECTION);
				}
			}
		}
		return false;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.cell.manager.StereotypePropertyCellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement) {
		boolean value = super.isCellEditable(columnElement, rowElement);
		if(value) {
			final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
			if(objects.size() == 2) {
				final EObject object = (EObject)objects.get(0);
				if(matcher.matches(object)) {
					value = false;
				}
			}
		}
		return value;
	}
}
