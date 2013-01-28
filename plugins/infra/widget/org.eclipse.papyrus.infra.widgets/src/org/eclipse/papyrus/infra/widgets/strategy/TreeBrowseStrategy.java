/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.strategy;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.papyrus.infra.widgets.util.IRevealSemanticElement;


/**
 * An interface to define a strategy for browsing a Tree
 * 
 * @author Camille Letavernier
 */
public interface TreeBrowseStrategy extends ITreeContentProvider, IRevealSemanticElement {

	/**
	 * Finds a path to the given element
	 * 
	 * @param element
	 *        The semanticElement to find
	 * @parem input
	 *        The root Elements
	 * @return
	 * @deprecated See {@link #revealSemanticElement(java.util.List)} instead
	 */
	@Deprecated
	public TreePath findPath(Object semanticElement, Object[] roots);

}
