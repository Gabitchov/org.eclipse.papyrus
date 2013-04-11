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

import java.util.List;

/**
 * Interface implemented by all proxies for entries that contain pre/post
 * actions
 */
public interface IPaletteAspectToolEntryProxy extends IPaletteEntryProxy {

	/**
	 * Returns the list of post actions to execute on creation
	 * 
	 * @return the list of post actions to execute on creation
	 */
	public List<IPostAction> getPostActions();

	/**
	 * Returns the list of pre actions to execute on creation
	 * 
	 * @return the list of pre actions to execute on creation
	 */
	public List<IPreAction> getPreActions();

}
