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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.uml2.uml.Property;

/**
 * 
 * @author Vincent Lorenzo
 *         This label provider is called to display the properties of stereotype application in the headers of the table
 */
public class StereotypePropertyHeaderLabelProvider extends EMFFeatureHeaderLabelProvider {

	/** The string displayed in the header when the required profile is not avalaible */
	public static final String REQUIRED_PROFILE_NOT_AVALAIBLE = "Required Profile Not Found";

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> when element represents a property of a stereotype
	 */
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final Object value = ((ILabelProviderContextElement)element).getCell().getDataValue();
			String id = AxisUtils.getPropertyId(value);
			return (id != null && id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX));
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		final Object value = ((ILabelProviderContextElement)element).getCell().getDataValue();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		final INattableModelManager modelManager = (INattableModelManager)getAxisContentProvider(configRegistry);
		final EObject tableContext = modelManager.getTable().getContext();
		String id = AxisUtils.getPropertyId(value);
		final Property prop = UMLTableUtils.getRealStereotypeProperty(tableContext, id);
		if(prop != null) {
			return getText(configRegistry, prop.getName(), prop.getType(), prop.isDerived(), prop.getLower(), prop.getUpper());
		} else {
			return REQUIRED_PROFILE_NOT_AVALAIBLE;
		}
	}
}
