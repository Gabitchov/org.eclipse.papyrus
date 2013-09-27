package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.uml2.uml.UMLPackage;

/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

/**
 * Filter for the comment section
 */
public class CommentFilter implements IFilter {

	/**
	 * {@inheritDoc}
	 */
	public boolean select(Object toTest) {
		EObject eObjectToTest = resolveSemanticObject(toTest);
		return eObjectToTest != null && eObjectToTest.eClass() == UMLPackage.eINSTANCE.getComment();
	}

	/**
	 * Resolve semantic element
	 * 
	 * @param object
	 *            the object to resolve
	 * @return <code>null</code> or the semantic element associated to the specified object
	 */
	private EObject resolveSemanticObject(Object object) {
		if (object instanceof EObject) {
			return (EObject) object;
		} else if (object instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) object;
			if (adaptable.getAdapter(EObject.class) != null) {
				return (EObject) adaptable.getAdapter(EObject.class);
			}
		}
		return null;
	}

}
