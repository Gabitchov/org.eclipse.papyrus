/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.navigation.service;

import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;
import org.eclipse.swt.graphics.Image;

/**
 * Represents a single instance of NavigableElement
 * 
 * @author Camille Letavernier
 * 
 */
public interface NavigableElement {

	/**
	 * The label of this navigable element
	 * 
	 * @return
	 */
	public String getLabel();

	/**
	 * The description of this navigable element
	 * 
	 * @return
	 */
	public String getDescription();

	/**
	 * Executes the navigation action
	 * 
	 * @param navigationContext
	 *        The IRevealSemanticElement that can be used to select the navigation target
	 * 
	 */
	public void navigate(IRevealSemanticElement navigationContext);

	/**
	 * The Image of this navigable element
	 * 
	 * @return
	 */
	public Image getImage();

	/**
	 * Indicates whether this element is enabled. The element will be displayed
	 * but won't be navigable
	 * 
	 * @return
	 */
	public boolean isEnabled();
}
