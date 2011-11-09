/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.matcher;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;

/**
 * Filter hiding di files and associated. the filter enables the content
 * provider
 * 
 * @author tfaure
 * 
 */
public class OnlyDiFilter extends ViewerFilter {

	public static final String FILTER_ID = "org.eclipse.papyrus.infra.onefile.onlyDiFilter";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers
	 * .Viewer, java.lang.Object, java.lang.Object)
	 * 
	 * @Override
	 */
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return OneFileUtils.isVisible(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ViewerFilter#isFilterProperty(java.lang.Object,
	 * java.lang.String)
	 * 
	 * @Override
	 */
	public boolean isFilterProperty(Object element, String property) {
		return true;
	}

}
