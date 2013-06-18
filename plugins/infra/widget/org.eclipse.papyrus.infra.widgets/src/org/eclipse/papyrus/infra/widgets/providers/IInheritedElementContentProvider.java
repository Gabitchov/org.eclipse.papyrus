/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * This interface
 * 
 * @author vl222926
 * 
 */
public interface IInheritedElementContentProvider extends IStructuredContentProvider {

	/**
	 * 
	 * @param ignoreInheritedElements
	 *        if <code>true</code> the inherited elements won't be returned
	 */
	public void setIgnoreInheritedElements(final boolean ignoreInheritedElements);

	/**
	 * 
	 * @return
	 *         <code>true</code> if the content provider is ignoring the inherited elements
	 */
	public boolean isIgnoringInheritedElements();
}
