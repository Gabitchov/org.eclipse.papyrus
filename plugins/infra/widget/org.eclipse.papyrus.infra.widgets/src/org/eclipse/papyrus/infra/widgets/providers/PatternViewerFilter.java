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
package org.eclipse.papyrus.infra.widgets.providers;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.internal.misc.StringMatcher;

/**
 * A ViewerFilter which can be used to match a pattern.
 * 
 * The pattern accepts wildcards (* and ?), and ; as a pattern-separator
 * 
 * For example:
 * foo;bar will match either "foo" or "bar"
 * foo* will match "foobar"
 * 
 * @author Camille Letavernier
 * 
 */
public class PatternViewerFilter extends AbstractTreeFilter {

	private StringMatcher[] validPatterns = new StringMatcher[]{ new StringMatcher("*", true, false) };

	private String currentPattern;

	private boolean strict = false;

	/**
	 * If the pattern is not strict, wildcards (*) will be added at the beginning and the end of the pattern
	 * The pattern foo becomes equivalent to *foo*
	 * 
	 * @param strict
	 */
	public void setStrict(boolean strict) {
		this.strict = strict;
	}

	public void setPattern(String value) {
		if(value.equals(currentPattern)) {
			return;
		}

		currentPattern = value;

		String[] patterns = value.split(";");
		this.validPatterns = new StringMatcher[patterns.length];
		int i = 0;
		for(String pattern : patterns) {
			if(!strict) {
				pattern = "*" + pattern.trim() + "*";
			}
			validPatterns[i++] = new StringMatcher(pattern, true, false);
		}

		clearCache();
	}

	@Override
	public boolean isVisible(Viewer viewer, Object parentElement, Object element) {
		IBaseLabelProvider labelProvider = ((StructuredViewer)viewer).getLabelProvider();
		if(labelProvider instanceof ILabelProvider) {
			for(StringMatcher pattern : validPatterns) {
				if(pattern.match(((ILabelProvider)labelProvider).getText(element))) {
					return true;
				}
			}
		}
		return false;
	}

}
