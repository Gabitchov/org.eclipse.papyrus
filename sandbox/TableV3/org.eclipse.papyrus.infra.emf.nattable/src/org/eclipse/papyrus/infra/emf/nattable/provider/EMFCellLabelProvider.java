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
package org.eclipse.papyrus.infra.emf.nattable.provider;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider;
import org.eclipse.papyrus.infra.nattable.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * The Label provider used for EMF element
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EMFCellLabelProvider extends AbstractNattableCellLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> if the element is an instance of {@link ILabelProviderContextElement} and if the cell represents an
	 *         {@link EStructuralFeature} of an {@link EObject}
	 */
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final ILayerCell cell = ((ILabelProviderContextElement)element).getCell();
			final IConfigRegistry registry = ((ILabelProviderContextElement)element).getConfigRegistry();
			final Object rowElement = getRowObject(cell, registry);
			final Object columnElement = getColumnObject(cell, registry);
			if(rowElement instanceof EObject && columnElement instanceof EStructuralFeature) {
				return true;
			} else if(rowElement instanceof EStructuralFeature && columnElement instanceof EObject)
				return true;
		}
		return false;
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
		final ILayerCell cell = ((ILabelProviderContextElement)element).getCell();
		final IConfigRegistry registry = ((ILabelProviderContextElement)element).getConfigRegistry();
		Object value = cell.getDataValue();
		String label = ""; //$NON-NLS-1$
		final LabelProviderService service = getLabelProviderService(registry);
		if(value instanceof Collection<?>) {
			Iterator<?> iter = ((Collection<?>)value).iterator();
			label += Constants.BEGIN_OF_COLLECTION;
			while(iter.hasNext()) {
				label = service.getLabelProvider(value).getText(value);
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
