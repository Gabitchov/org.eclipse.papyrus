/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import java.util.Map;

/**
 * An interface for providing Masks for editing mask-based integer values
 * 
 * @author Camille Letavernier
 * 
 * @see StringMask
 */
public interface MaskProvider {

	/**
	 * @return the list of masks and their String descriptions
	 */
	public Map<String, String> getMasks();
}
