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
package org.eclipse.papyrus.customization.properties.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.properties.contexts.DataContextElement;
import org.eclipse.papyrus.views.properties.contexts.DataContextPackage;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.ui.internal.misc.StringMatcher;

/**
 * A Filter for the UIEditor. The Filter can match Views and DataContextElements
 * An object is matched if it directly matches the filter, or if one of its parents
 * match it, or if one of his children (at any level) match it.
 *
 * @author Camille Letavernier
 */
public class ViewFilter extends ViewerFilter {

	private StringMatcher matcher;

	/**
	 * Sets the pattern for this filter
	 *
	 * @param pattern
	 */
	public void setPattern(String pattern) {
		matcher = new StringMatcher("*" + pattern + "*", true, false); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if(matcher == null) {
			return true;
		}

		EObject semantic = EMFHelper.getEObject(element);

		if(semantic != null) {
			if(semantic instanceof View) {
				String viewName = ((View)semantic).getName();
				if(viewName == null) {
					return true;
				}
				return matcher.match(viewName);
			} else if(semantic instanceof DataContextPackage) {
				//FIXME : The filter doesn't work correctly for displaying a DataContextElement in a Package
				return select((DataContextPackage)semantic);
			} else if(semantic instanceof DataContextElement) {
				return select((DataContextElement)semantic);
			}
		}

		return true;
	}

	/**
	 * An element is displayed if its name matches the filter, or if one of its
	 * children's or parent's name match it
	 *
	 * @param dataContextPackage
	 * @return
	 */
	private boolean select(DataContextPackage dataContextPackage) {
		if(dataContextPackage.getName() == null) {
			return true;
		}

		if(matcher.match(dataContextPackage.getName())) {
			return true;
		}

		for(DataContextElement subElement : dataContextPackage.getElements()) {
			if(subElement instanceof DataContextPackage) {
				if(select((DataContextPackage)subElement)) {
					return true;
				}
			}

			if(select(subElement)) {
				return true;
			}
		}

		return false;
	}

	private boolean select(DataContextElement dataContextElement) {
		if(dataContextElement.getName() == null) {
			return true;
		}

		if(matcher.match(dataContextElement.getName())) {
			return true;
		}

		DataContextPackage dataContextPackage = dataContextElement.getPackage();
		while(dataContextPackage != null) {
			if(matcher.match(dataContextPackage.getName())) {
				return true;
			}

			dataContextPackage = dataContextPackage.getPackage();
		}

		return false;
	}
}
