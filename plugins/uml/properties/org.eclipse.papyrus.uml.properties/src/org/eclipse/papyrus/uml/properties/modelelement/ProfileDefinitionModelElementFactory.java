/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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

import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;


public class ProfileDefinitionModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);
		if(umlSource instanceof Profile) {
			//EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
			return new ProfileDefinitionModelElement((Profile)umlSource);
		}

		Activator.log.warn("Unable to resolve the selected element to a UML Profile"); //$NON-NLS-1$
		return null;
	}

}
