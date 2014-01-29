/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.appearance.style;

import java.util.Map;

/**
 * An interface to retrieve the label masks associated to an element
 * 
 * @author Camille Letavernier
 * 
 */
public interface ILabelMaskProvider {

	/**
	 * Returns the list of masks for this provider
	 * 
	 * @return
	 */
	public Map<Integer, String> getMasks();

	/**
	 * Returns the default mask value for this provider
	 * 
	 * @return
	 */
	public int getDefaultValue();
}
