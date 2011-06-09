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

import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.modelelement.EMFModelElementFactory;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.uml.util.UMLUtil;
import org.eclipse.uml2.uml.Element;

/**
 * A Factory for building ModelElements manipulating UML Objects.
 * 
 * @author Camille Letavernier
 */
public class UMLModelElementFactory extends EMFModelElementFactory {

	@Override
	public ModelElement createFromSource(Object source, DataContextElement context) {
		Element umlSource = UMLUtil.resolveUMLElement(source);
		if(umlSource == null) {
			Activator.log.warn("Unable to resolve the selected element to a UML Element"); //$NON-NLS-1$
			return null;
		}

		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(umlSource);
		return new UMLModelElement(umlSource, domain);
	}
}
