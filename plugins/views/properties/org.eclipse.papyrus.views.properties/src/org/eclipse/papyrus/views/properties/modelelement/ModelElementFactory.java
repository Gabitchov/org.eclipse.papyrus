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
package org.eclipse.papyrus.views.properties.modelelement;

import org.eclipse.papyrus.views.properties.contexts.DataContextElement;

/**
 * An interface representing ModelElementFactories.
 * ModelElementFactories are meant to be instantiated reflectively, thus should
 * always provide a 0-arg constructor.
 * 
 * @author Camille Letavernier
 */
public interface ModelElementFactory {

	/**
	 * Creates a new ModelElement for given Object and DataContextElement
	 * 
	 * @param sourceElement
	 *        The Object for which we need to build a ModelElement. Note that this element
	 *        comes directly from the Eclipse selection, and may need to be adapted to get
	 *        the actual semantic object (e.g. sourceElement may be a GMF EditPart, and needs
	 *        to be adapted to retrieve the EObject). The factory is responsible for resolving
	 *        the semantic object in such a case.
	 * @param context
	 *        The DataContextElement containing the properties that the Property View framework
	 *        is susceptible to ask for.
	 * @return
	 *         The ModelElement corresponding to the sourceElement
	 */
	public ModelElement createFromSource(Object sourceElement, DataContextElement context);

}
