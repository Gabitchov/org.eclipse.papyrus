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
package org.eclipse.papyrus.customization.properties.modelelement;

import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElementFactory;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;

/**
 * A Factory for build {@link CustomizationModelElement}s
 * 
 * @author Camille Letavernier
 */
public class CustomizationModelElementFactory extends EMFModelElementFactory {

	@Override
	public ModelElement createFromSource(Object sourceElement, DataContextElement context) {
		return new CustomizationModelElement((EMFModelElement)super.createFromSource(sourceElement, context));
	}
}
