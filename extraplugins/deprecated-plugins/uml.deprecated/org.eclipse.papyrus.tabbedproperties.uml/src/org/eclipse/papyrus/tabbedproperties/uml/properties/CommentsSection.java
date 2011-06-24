/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.utils.EcoreTool;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Comments property section used by all uml::Element
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CommentsSection extends ElementCommentsPropertySection {

	@Override
	public boolean select(Object toTest) {
		EObject eObjectToTest = null;
		if(toTest instanceof EObject)
			eObjectToTest = (EObject)toTest;
		else if(toTest instanceof IAdaptable && ((IAdaptable)toTest).getAdapter(EObject.class) != null)
			eObjectToTest = (EObject)((IAdaptable)toTest).getAdapter(EObject.class);
		// is an instance of uml::Element
		return eObjectToTest != null && EcoreTool.isInstanceOfEClass(eObjectToTest, UMLPackage.eINSTANCE.getElement());
	}

}
