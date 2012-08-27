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
package org.eclipse.papyrus.views.properties.runtime.view.content;

import org.eclipse.papyrus.views.properties.runtime.view.IConfigurableDescriptor;
import org.eclipse.swt.widgets.Layout;


/**
 * Descriptor for layouts for containers
 */
public abstract class LayoutDescriptor implements IConfigurableDescriptor {

	/**
	 * {@inheritDoc}
	 */
	public abstract LayoutDescriptorState createState(boolean readOnly);

	/**
	 * Creates the layout relative to this descriptor
	 * 
	 * @return the layout relative to this descriptor
	 */
	public abstract Layout createLayout();
}
