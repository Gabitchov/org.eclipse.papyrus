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
package org.eclipse.papyrus.infra.nattable.provider.tmp;

import org.eclipse.jface.viewers.IStructuredContentProvider;

/**
 * This interface adds 2 methods to allow to the content provider to ignore or not the properties base_ExtendedMetaclass
 * in the stereotype properties
 * 
 * @author vl222926
 * 
 */
//FIXME must be deleted after the official extraplugins build and before Papyrus 0.10SR1
public interface IIgnoreStereotypeBasePropertyContentProvider extends IStructuredContentProvider {

	/**
	 * 
	 * @param ignoreBaseProperty
	 *        the new value to use for the content provider. if <code>true</code> the base properties won't be returned
	 */
	public void setIgnoreBaseProperty(final boolean ignoreBaseProperty);

	/**
	 * 
	 * @return
	 *         <code>true</code> if the content provider doesn't return the base properties
	 */
	public boolean isIgnoringBaseProperty();
}
