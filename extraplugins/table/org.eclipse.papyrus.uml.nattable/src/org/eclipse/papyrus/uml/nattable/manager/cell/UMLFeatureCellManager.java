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
package org.eclipse.papyrus.uml.nattable.manager.cell;

import java.util.List;
import java.util.Map;

import org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.uml.tools.utils.UMLStringValueConverter;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * @author Vincent Lorenzo
 *         This cell manager allows to manage UML Feature
 */
public class UMLFeatureCellManager extends EMFFeatureValueCellManager {


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean handles(final Object columnElement, final Object rowElement) {
		boolean answer = super.handles(columnElement, rowElement);
		if(answer) {
			final List<Object> objects = organizeAndResolvedObjects(columnElement, rowElement, null);
			answer = objects.get(0) instanceof Element;
		}
		return answer;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getOrCreateStringValueConverterClass(org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager,
	 *      java.util.Map, java.lang.String)
	 * 
	 * @param tableManager
	 * @param existingConverters
	 * @param multiValueSeparator
	 * @return
	 */
	@Override
	public AbstractStringValueConverter getOrCreateStringValueConverterClass(INattableModelManager tableManager, Map<Class<? extends AbstractStringValueConverter>, AbstractStringValueConverter> existingConverters, String multiValueSeparator) {
		AbstractStringValueConverter converter = existingConverters.get(UMLStringValueConverter.class);
		if(converter == null) {
			converter = new UMLStringValueConverter(tableManager.getTable().getContext(), multiValueSeparator);
			existingConverters.put(UMLStringValueConverter.class, converter);
		}
		return converter;
	}
}
