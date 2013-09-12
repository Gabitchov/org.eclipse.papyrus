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
package org.eclipse.papyrus.infra.nattable.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;


/**
 * Utils class for paste actions
 * 
 * @author VL222926
 * 
 */
public class PasteConfigurationUtils {


	private PasteConfigurationUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param pasteConfiguration
	 *        a paste configuration
	 * @return
	 *         <code>true</code> if the paste configuration is consistent
	 */
	public static boolean hasConsistentPasteEObjectConfiguration(final PasteEObjectConfiguration pasteConfiguration) {
		boolean result = false;
		if(pasteConfiguration != null) {
			final EStructuralFeature feature = pasteConfiguration.getPasteElementContainementFeature();
			if(feature instanceof EReference) {
				final String elementId = pasteConfiguration.getPastedElementId();
				if(elementId != null && !elementId.equals("")) {
					final IElementType elementType = ElementTypeRegistry.getInstance().getType(elementId);
					final EClass elementTypeMetaclass = elementType.getEClass();
					final EClass containmentFeatureEClass = (EClass)feature.getEType();
					result = elementTypeMetaclass == containmentFeatureEClass || containmentFeatureEClass.isSuperTypeOf(elementTypeMetaclass);
				}
			}
		}
		return result;
	}


}
