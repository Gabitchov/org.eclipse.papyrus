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
package org.eclipse.papyrus.uml.nattable.manager.axis;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.papyrus.infra.emf.nattable.manager.axis.EObjectAxisManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IPasteConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.PasteEObjectConfiguration;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * This axis manager restrict the allowed contents to UML Element
 * 
 */
public class UMLElementAxisManager extends EObjectAxisManager {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.axis.EObjectAxisManager#isAllowedContents(java.lang.Object)
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean isAllowedContents(Object object) {
		boolean value = super.isAllowedContents(object);
		if(value) {
			return object instanceof Element;
		}
		return value;
	}

	@Override
	public boolean canCreateAxisElement(String elementId) {
		return true;//FIXME : must be true only for uml elements
	}
	
	@Override
	public boolean canPaste(final IPasteConfiguration configuration) {
		boolean result = super.canPaste(configuration);
		if(result){
			final EStructuralFeature feature = ((PasteEObjectConfiguration)configuration).getPasteElementContainementFeature();
			//FIXME
			
		}
		return result;
	}
}
