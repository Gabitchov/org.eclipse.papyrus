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
package org.eclipse.papyrus.uml.tools.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Label provider for UML Metaclass
 * 
 * @author Vincent Lorenzo
 * 
 */
public class UMLMetaclassLabelProvider extends UMLEClassLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLFilteredLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public boolean accept(Object element) {
		if(element instanceof Class) {
			return ((Class)element).isMetaclass();
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider#getText(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected String getText(final EObject element) {
		return ((Class)element).getName();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider#getImage(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	protected Image getImage(EObject element) {
		EClass umlEClass = null;
		if(element instanceof Class) {
			EClassifier classifier = UMLPackage.eINSTANCE.getEClassifier(((Class)element).getName());
			if(classifier instanceof EClass) {
				umlEClass = (EClass)classifier;
				return super.getImage(umlEClass);
			}
		}
		return null;
	}

}
