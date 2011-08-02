/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.notation.modelelement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.modelelement.ModelElementFactory;
import org.eclipse.papyrus.properties.util.EMFHelper;

/**
 * A factory for handling the GMF Notation elements
 * 
 * @author Camille Letavernier
 */
public class NotationModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {

		View view = null;

		if(sourceElement instanceof EditPart) {
			EditPart part = (EditPart)sourceElement;
			Object model = part.getModel();

			if(model instanceof View) {
				view = (View)model;
			}
		} else if(sourceElement instanceof GradientData) {
			return new GradientDataModelElement((GradientData)sourceElement);
		} else {
			EObject eObject = EMFHelper.getEObject(sourceElement);
			if(eObject instanceof View) {
				view = (View)eObject;
			}
		}

		if(view != null) {
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(view);
			return new GMFModelElement(view, domain);
		}

		return null;
	}

}
