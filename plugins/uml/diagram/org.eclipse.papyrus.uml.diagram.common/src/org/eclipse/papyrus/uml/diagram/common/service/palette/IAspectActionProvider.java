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
package org.eclipse.papyrus.uml.diagram.common.service.palette;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Node;

/**
 * Interface for aspect action factories
 */
public interface IAspectActionProvider extends IProvider {

	/**
	 * Creates an action, given the specified parameters
	 * 
	 * @param configurationNode
	 *        the configuration node that specifies parameter to the action
	 */
	public IAspectAction createAction(Node configurationNode);

	/**
	 * Returns the id of this factory
	 * 
	 * @return the id of this factory
	 */
	public String getFactoryId();

	/**
	 * Returns the name of the factory
	 * 
	 * @return the name of the factory
	 */
	public String getName();

	/**
	 * Returns the image representing the factory
	 * 
	 * @return the image representing the factory
	 */
	public Image getImage();

	/**
	 * returns <code>true</code> if this factory is enabled
	 * 
	 * @param entryProxy
	 *        the entry proxy for which aspect action will be added or
	 *        removed
	 * 
	 * @return <code>true</code> if this factory is enabled
	 */
	public boolean isEnable(IPaletteEntryProxy entryProxy);

	/**
	 * Sets the configuration for this provider, given the configuration element
	 */
	public void setConfiguration(IConfigurationElement element);

}
