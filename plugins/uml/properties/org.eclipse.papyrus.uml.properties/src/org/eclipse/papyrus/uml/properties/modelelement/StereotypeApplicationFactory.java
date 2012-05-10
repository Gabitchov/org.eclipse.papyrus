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
package org.eclipse.papyrus.uml.properties.modelelement;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.uml2.uml.Element;

/**
 * A ModelElementFactory for manipulating Stereotype and Profile
 * applications
 * 
 * @author Camille Letavernier
 * 
 */
public class StereotypeApplicationFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);
		if(umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
		if(sourceElement instanceof EditPart) {
			return new StereotypeApplicationModelElement((EditPart)sourceElement, domain);
		} else {
			return new StereotypeApplicationModelElement(umlSource, domain);
		}
	}

}
