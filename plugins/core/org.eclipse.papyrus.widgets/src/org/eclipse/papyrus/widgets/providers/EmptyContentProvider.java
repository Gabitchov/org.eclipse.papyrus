/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.widgets.providers;

import org.eclipse.jface.viewers.Viewer;

/**
 * A ContentProvider returning empty collections
 * 
 * @author Camille Letavernier
 * 
 */
public class EmptyContentProvider implements IStaticContentProvider {

	public void dispose() {
		//Nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//Nothing
	}

	public Object[] getElements() {
		return new Object[0];
	}

}
