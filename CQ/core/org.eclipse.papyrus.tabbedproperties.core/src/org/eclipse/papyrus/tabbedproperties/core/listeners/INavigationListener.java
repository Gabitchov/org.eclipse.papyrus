/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core.listeners;

import org.eclipse.uml2.uml.Element;

/**
 * used to precise contract in order to write a class that will execute the navigation
 * 
 * @author Patrick Tessier
 * 
 */
public interface INavigationListener {

	/**
	 * this method has in charge to load the property view with the given element
	 * 
	 * @param umlElement
	 *            the element that we want to see
	 */
	public void navigateTo(Element umlElement);

}
