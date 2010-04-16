/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.tabbed.core.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.properties.tabbed.core.view.content.AbstractContainerDescriptor;


/**
 * Configuration of the section. It describes the content of the section, its layout, its controllers, etc.
 */
public class SectionConfiguration {

	/** list of root containers for this section */
	protected List<AbstractContainerDescriptor> containers = new ArrayList<AbstractContainerDescriptor>();


	/**
	 * Creates a new SectionConfiguration.
	 */
	public SectionConfiguration() {

	}

	/**
	 * returns the list of root containers for this section
	 * 
	 * @return the list of root containers for this section
	 */
	public List<AbstractContainerDescriptor> getContainers() {
		return containers;
	}





}
