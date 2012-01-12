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

import java.util.List;

import org.eclipse.jface.viewers.Viewer;


public abstract class AbstractTreeBrowseStrategy implements TreeBrowseStrategy {

	public void dispose() {
		//Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//Nothing
	}

	abstract public void revealSemanticElement(List<?> elementsList);

}
