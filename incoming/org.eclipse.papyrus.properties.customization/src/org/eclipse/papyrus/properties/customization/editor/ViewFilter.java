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
package org.eclipse.papyrus.properties.customization.editor;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.ui.internal.misc.StringMatcher;


public class ViewFilter extends ViewerFilter {

	private StringMatcher matcher;

	public void setPattern(String pattern) {
		matcher = new StringMatcher("*" + pattern + "*", true, false);
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(matcher == null)
			return true;

		if(element instanceof IAdaptable) {
			EObject eObject = (EObject)((IAdaptable)element).getAdapter(EObject.class);
			if(eObject != null && eObject instanceof View) {
				String viewName = (((View)eObject).getName());
				if(viewName == null) {
					return true;
				}
				return matcher.match(viewName);
			}
		}

		return true;
	}
}
