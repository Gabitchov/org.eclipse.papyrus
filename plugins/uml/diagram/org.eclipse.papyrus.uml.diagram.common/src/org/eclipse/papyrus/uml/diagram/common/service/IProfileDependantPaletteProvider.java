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
package org.eclipse.papyrus.uml.diagram.common.service;

import java.util.Collection;

import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;

/**
 * Interface implemented by all palette providers that requires some profiles
 * applied to be shown
 */
public interface IProfileDependantPaletteProvider extends IPaletteProvider {

	/**
	 * Returns the list of required profiles for the palette to be shown
	 * 
	 * @return the list of required profiles for the palette to be shown
	 */
	public Collection<String> getRequiredProfiles();

}
