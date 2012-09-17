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
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.properties.Activator;
import org.eclipse.papyrus.uml.tools.utils.UMLUtil;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElementFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Image;

/**
 * A ModelElementFactory for handling UML Images
 * 
 * @author Camille Letavernier
 * 
 */
public class CustomImageModelElementFactory implements ModelElementFactory {

	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(sourceElement);
		if(umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		if(umlSource instanceof Image) {
			EditingDomain domain = EMFHelper.resolveEditingDomain(umlSource);
			return new CustomImageModelElement((Image)umlSource, domain);
		}

		Activator.log.warn("The selected element is not a UML Image"); //$NON-NLS-1$
		return null;
	}

}
