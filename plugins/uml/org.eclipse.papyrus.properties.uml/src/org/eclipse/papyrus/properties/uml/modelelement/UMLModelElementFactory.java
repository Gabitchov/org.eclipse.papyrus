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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.properties.contexts.DataContextElement;
import org.eclipse.papyrus.properties.modelelement.EMFModelElementFactory;
import org.eclipse.papyrus.properties.modelelement.ModelElement;
import org.eclipse.papyrus.properties.util.UMLUtil;

public class UMLModelElementFactory extends EMFModelElementFactory {

	@Override
	public ModelElement createFromSource(Object source, DataContextElement context) {		
		EObject umlSource = UMLUtil.resolveUMLElement(source);
		return super.createFromSource(umlSource, context);
	}
}
