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
package org.eclipse.papyrus.infra.nattable.provider;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * The generic label provider for the cells
 * 
 * @author Vincent Lorenzo
 * 
 */
public class GenericCellLabelProvider extends AbstractNattableCellLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> if the element is an instance of {@link ILabelProviderContextElementWrapper} and if the cell represents an
	 *         {@link EStructuralFeature} of an {@link EObject}
	 */
	@Override
	public boolean accept(Object element) {
		return element instanceof ILabelProviderCellContextElementWrapper;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		final ILabelProviderCellContextElementWrapper contextElement = (ILabelProviderCellContextElementWrapper)element;
		final IConfigRegistry registry = ((ILabelProviderContextElementWrapper)element).getConfigRegistry();
		Object value = contextElement.getObject();
		String label = ""; //$NON-NLS-1$
		final LabelProviderService service = getLabelProviderService(registry);
		if(value instanceof Collection<?>) {
			Iterator<?> iter = ((Collection<?>)value).iterator();
			label += Constants.BEGIN_OF_COLLECTION;
			while(iter.hasNext()) {
				Object current = iter.next();
				label += service.getLabelProvider(current).getText(current);
				if(iter.hasNext()) {
					label += Constants.SEPARATOR;
				}
			}
			label += Constants.END_OF_COLLECTION;
		} else {
			label = service.getLabelProvider(value).getText(value);
		}
		return label;
	}
}
