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
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * An interface for implementing a ContentProvider which requires
 * graphical elements for features such as filters.
 * 
 * @author Camille Letavernier
 *
 */
public interface IGraphicalContentProvider extends IContentProvider {
	
	/**
	 * Create graphical elements, which will appear before the widget
	 * used to display the provided elements
	 * @param parent
	 */
	public abstract void createBefore(Composite parent);
	
	/**
	 * Create graphical elements, which will appear after the widget
	 * used to display the provided elements
	 * @param parent
	 */
	public abstract void createAfter(Composite parent);
}
