/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.sorters;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * This class sort elements in Model Navigator.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 **/
public class UMLViewerSorter extends ViewerSorter {

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		// Add diagram at first position
		if (e1 instanceof Diagram || e2 instanceof Diagram) {
			if (e1 instanceof Diagram && e2 instanceof Diagram) {
				return super.compare(viewer, e1, e2);
			} else {
				return 1;
			}
		}
		return super.compare(viewer, e1, e2);
	}

}
