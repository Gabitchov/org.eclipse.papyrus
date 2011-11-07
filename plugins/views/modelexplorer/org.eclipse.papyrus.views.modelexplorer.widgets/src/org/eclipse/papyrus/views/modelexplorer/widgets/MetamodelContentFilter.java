/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.widgets;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * A class to filter the empty elements, based on the given content provider
 * 
 * @author Camille Letavernier
 */
public class MetamodelContentFilter extends ViewerFilter {

	private IStructuredContentProvider metaclassProvider;

	public MetamodelContentFilter(IStructuredContentProvider metaclassProvider) {
		this.metaclassProvider = metaclassProvider;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return metaclassProvider.getElements(element).length > 0;
	}

}
