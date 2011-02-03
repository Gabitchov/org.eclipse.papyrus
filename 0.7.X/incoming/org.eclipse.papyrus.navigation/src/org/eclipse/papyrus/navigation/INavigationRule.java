/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * This interface defines a navigation rule.
 * @author mvelten
 *
 */
public interface INavigationRule {

	/**
	 * Tests if an element is supported by this rule.
	 * @param element
	 * @return
	 */
	public boolean handle(EObject element);

	/**
	 * Retrieve a list of the next possible navigation possibilities.
	 * @param currentNavElement
	 * @return a list of navigable elements
	 */
	public List<NavigableElement> getNextPossibleElements(NavigableElement currentNavElement);
}
