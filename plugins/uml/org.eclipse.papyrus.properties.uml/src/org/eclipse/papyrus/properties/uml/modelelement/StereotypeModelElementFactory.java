/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.modelelement;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.modelelement.ModelElementFactory;
import org.eclipse.papyrus.properties.runtime.DataSource;
import org.eclipse.papyrus.properties.runtime.StereotypeModelElement;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object source, DataContextElement context) {

		if(source instanceof GraphicalEditPart) {
			GraphicalEditPart editPart = (GraphicalEditPart)source;
			Element umlElement = (Element)editPart.getAdapter(EObject.class);

			Stereotype stereotype = umlElement.getAppliedStereotype(getQualifiedName(context));
			EObject stereotypeApplication = umlElement.getStereotypeApplication(stereotype);

			return new StereotypeModelElement(stereotypeApplication, editPart.getEditingDomain());
		}

		return null;
	}

	private String getQualifiedName(DataContextElement context) {
		if(context.getPackage() == null) {
			return context.getName();
		} else {
			return getQualifiedName(context.getPackage()) + "::" + context.getName(); //$NON-NLS-1$
		}
	}

	/**
	 * @TODO
	 */
	public List<ModelElement> createFromDataSource(ModelElement currentElement, DataSource source, String propertyPath, DataContextElement context) {
		// TODO Auto-generated method stub
		//Case 1 : ModelElement is a Stereotype
		//Case 2 : ModelElement is an UML Object
		throw new UnsupportedOperationException();
	}
}
