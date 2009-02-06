/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.tree;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.profile.tree.objects.PropertyTreeObject;
import org.eclipse.papyrus.profile.tree.objects.StereotypeTreeObject;


// TODO: Auto-generated Javadoc
/**
 * The Class ProfileElementTreeViewerFilter.
 */
public class ProfileElementTreeViewerFilter extends ViewerFilter {

	/**
	 * Select.
	 * 
	 * @param viewer the viewer
	 * @param element the element
	 * @param parentElement the parent element
	 * 
	 * @return true, if select
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub
		if ((element instanceof StereotypeTreeObject)
				|| (element instanceof PropertyTreeObject)) {
			return true;
		}
		return false;
	}

}
