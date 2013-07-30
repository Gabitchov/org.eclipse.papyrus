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

import org.eclipse.gef.palette.PaletteEntry;

/**
 * Interface implemented by all proxies for the palette customization dialog
 */
public interface IPaletteEntryProxy {

	/**
	 * Returns the entry managed by this proxy
	 * 
	 * @return the entry managed by this proxy
	 */
	public PaletteEntry getEntry();

}
