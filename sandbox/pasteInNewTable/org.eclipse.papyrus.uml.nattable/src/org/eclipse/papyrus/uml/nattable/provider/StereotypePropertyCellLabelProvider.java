/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.provider;

import java.util.List;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderCellContextElementWrapper;
import org.eclipse.uml2.uml.Property;


public class StereotypePropertyCellLabelProvider extends AbstractUMLNattableCellLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.GenericCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderCellContextElementWrapper) {
			final ILabelProviderCellContextElementWrapper cellWrapperContextElement = (ILabelProviderCellContextElementWrapper)element;

			final IConfigRegistry registry = cellWrapperContextElement.getConfigRegistry();

			//now it is possible that we accepts the element
			final Object rowObject = getRowObject(cellWrapperContextElement, registry);
			final Object columnObject = getColumnObject(cellWrapperContextElement, registry);

			final List<Object> objects = getUMLObjects(rowObject, columnObject);
			if(objects.size() == 2) {
				final Object feature = objects.get(1);
				return feature instanceof Property;
			}
		}
		return false;
	}
}
