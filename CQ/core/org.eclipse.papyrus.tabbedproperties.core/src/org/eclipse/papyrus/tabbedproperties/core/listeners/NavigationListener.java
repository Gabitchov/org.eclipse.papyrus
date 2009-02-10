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

import org.eclipse.papyrus.tabbedproperties.core.sections.AbstractEnhancedPropertySection;
import org.eclipse.uml2.uml.Element;

/**
 * Implementation of the {@link INavigationListener}
 * 
 * @author Patrick Tessier
 * 
 */
public class NavigationListener implements INavigationListener {

	/** the element that we want to see **/
	private Element theElement;

	/** the current property section **/
	private AbstractEnhancedPropertySection propertySection;

	/**
	 * the constructor of NavigationListener
	 * 
	 * @param propertySection
	 *            the current section
	 */
	public NavigationListener(AbstractEnhancedPropertySection propertySection) {
		this.propertySection = propertySection;
	}

	/**
	 * {@inheritDoc}
	 */
	public void navigateTo(Element umlElement) {
		this.propertySection.navigateTo(umlElement);
	}

	/**
	 * used to execute the naviagation
	 */
	public void fireNavigation() {
		if (theElement != null) {
			navigateTo(theElement);
		}
	}

	/**
	 * get the element that we want to see
	 * 
	 * @return the element
	 */
	public Element getTheElement() {
		return theElement;
	}

	/**
	 * set the element that we want to see
	 * 
	 * @param theElement
	 */
	public void setTheElement(Element theElement) {
		this.theElement = theElement;
	}

}
