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
package org.eclipse.papyrus.widgets.providers;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.internal.misc.StringMatcher;


public class PatternViewerFilter extends AbstractTreeFilter {

	private StringMatcher pattern = new StringMatcher("*", true, false);

	private String currentPattern;

	private boolean strict = false;

	public void setStrict(boolean strict) {
		this.strict = strict;
	}

	public void setPattern(String value) {
		if(!strict) {
			value = "*" + value + "*";
		}

		if(value.equals(currentPattern)) {
			return;
		}

		this.pattern = new StringMatcher(value, true, false);

		clearCache();
	}

	@Override
	public boolean isVisible(Viewer viewer, Object parentElement, Object element) {
		IBaseLabelProvider labelProvider = ((StructuredViewer)viewer).getLabelProvider();
		if(labelProvider instanceof ILabelProvider) {
			return pattern.match(((ILabelProvider)labelProvider).getText(element));
		}
		return false;
	}

}
