/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.part;

import java.util.Map;

import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;

/**
 * Interface that describes a palette.
 */
public interface IPaletteDescription {

	/**
	 * Returns the name of the palette
	 * 
	 * @return the name of this palette
	 */
	public String getName();

	/**
	 * returns the ID of the palette
	 * 
	 * @return the unique identifier of this palette
	 */
	public String getPaletteID();

	/**
	 * Returns the id of the editor for which this palette is defined.
	 * 
	 * @return the id of the editor contributed
	 */
	public String getContributionEditorID();

	/**
	 * Returns the contribution of this palette
	 * 
	 * @return the contribution of this palette
	 */
	public Object getContributions();

	/**
	 * returns the priority for this palette
	 * 
	 * @return the priority for this palette
	 */
	public ProviderPriority getPriority();

	/**
	 * returns the properties map for this palette
	 * 
	 * @return the properties map for this palette
	 */
	public Map<String, String> getProperties();

}
