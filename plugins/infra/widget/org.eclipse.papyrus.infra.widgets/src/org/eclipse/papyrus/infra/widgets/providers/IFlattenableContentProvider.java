/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

/**
 * 
 * Interfaces for a content provider which can be flat or not
 * 
 */
public interface IFlattenableContentProvider {

	/**
	 * 
	 * @param isFlat
	 *        <code>true</code> if we display the possible value as a flat view
	 */
	public void setFlat(boolean isFlat);
}
