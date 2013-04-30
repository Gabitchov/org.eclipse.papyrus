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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.util;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * A wrapper to convert a IRevealSemanticElement to an INavigationTarget
 * 
 * @author Camille Letavernier
 * 
 */
public class RevealSemanticElementWrapper implements NavigationTarget {

	private final IRevealSemanticElement revealSemanticElement;

	public RevealSemanticElementWrapper(IRevealSemanticElement revealSemanticElement) {
		this.revealSemanticElement = revealSemanticElement;
	}

	public boolean revealElement(Object element) {
		return revealElement(Collections.singletonList(element));
	}

	public boolean revealElement(Collection<?> elements) {
		revealSemanticElement.revealSemanticElement(new LinkedList<Object>(elements));
		return false;
	}

}
