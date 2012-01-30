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
package org.eclipse.papyrus.customization.properties.generation.layout;

import java.util.List;

import org.eclipse.papyrus.customization.properties.generation.generators.IGenerator;
import org.eclipse.papyrus.views.properties.contexts.Section;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.ui.PropertyEditor;

/**
 * An interface for defining Layout generators.
 * Layout generators are responsible for building a List of sections from a list
 * of Property editors.
 * 
 * @author Camille Letavernier
 */
public interface ILayoutGenerator {

	/**
	 * Return a list of Sections from a list of property editors.
	 * Each section should be placed in the parent's resourceSet
	 * 
	 * @param editors
	 *        The list of editors to layout
	 * @param parent
	 *        The view owning the resulting list of sections
	 * @return
	 *         The list of sections owning the input editors
	 */
	public List<Section> layoutElements(List<PropertyEditor> editors, View parent);

	/**
	 * @return the name of the Layout generator
	 */
	public String getName();

	/**
	 * Sets the generator used to generate the Property view configuration
	 * 
	 * @param generator
	 */
	//TODO : This method has been added for a specific case (Profile layout).
	//It should be removed when we have a better way to retrieve the source
	//profile
	public void setGenerator(IGenerator generator);
}
