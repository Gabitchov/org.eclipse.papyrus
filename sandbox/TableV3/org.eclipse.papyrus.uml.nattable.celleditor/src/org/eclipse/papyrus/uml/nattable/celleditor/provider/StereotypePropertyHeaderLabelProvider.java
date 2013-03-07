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
package org.eclipse.papyrus.uml.nattable.celleditor.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.provider.EMFFeatureHeaderLabelProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.IdAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.uml.nattable.celleditor.utils.UMLTableUtils;
import org.eclipse.swt.graphics.Image;
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
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.provider.EMFFeatureHeaderLabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public Image getImage(Object element) {
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.provider.EMFFeatureHeaderLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	public String getText(Object element) {
		String id = "";
		if(element instanceof IdAxis) {
			id = ((IdAxis)element).getElement();
		} else if(element instanceof String) {
			id = (String)element;
		}
		EObject eobject = null;
		if(element instanceof IdAxis) {
			EObject container = ((IdAxis)element).eContainer();
			if(container != null) {
				container = container.eContainer();
			}
			if(container instanceof Table) {
				eobject = ((Table)container).getContext();
			}
		}

		final Property prop = UMLTableUtils.getRealStereotypeProperty(eobject, id);
		if(prop != null) {
			return getText(prop.getName(), prop.getType(), prop.isDerived(), prop.getLower(), prop.getUpper());
		} else {
			return REQUIRED_PROFILE_NOT_AVALAIBLE;
		}

	}

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.celleditor.provider.EMFFeatureHeaderLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> when element represents a property of a stereotype
	 */
	public boolean accept(Object element) {
		String str = "";
		if(element instanceof IdAxis) {
			str = ((IdAxis)element).getElement();
		} else if(element instanceof String) {
			str = (String)element;
		}
		return (str.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX));
	}

}
