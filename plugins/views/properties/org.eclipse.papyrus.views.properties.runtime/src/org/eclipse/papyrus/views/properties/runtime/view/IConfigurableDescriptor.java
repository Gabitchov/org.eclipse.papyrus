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
package org.eclipse.papyrus.views.properties.runtime.view;

import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.swt.graphics.Image;


/**
 * interface shared by all descriptors that can be configured by the Papyrus customization support
 */
public interface IConfigurableDescriptor {

	/**
	 * Returns the label displayed by the descriptor
	 * 
	 * @return the label displayed by the descriptor
	 */
	public String getText();

	/**
	 * Returns the image displayed by the descriptor
	 * 
	 * @return the image displayed by the descriptor
	 */
	public Image getImage();

	/**
	 * Creates a state on this descriptor, in order to be able to customize it.
	 * 
	 * @param readOnly
	 *        the read only mode of the state
	 * @return the created state
	 */
	public IState createState(boolean readOnly);

}
