/*******************************************************************************
 * Copyright (c) 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software)
 *******************************************************************************/
package org.eclipse.emf.facet.common.ui.internal.widgets;

import org.eclipse.emf.facet.common.core.internal.utils.StringMatcher;
import org.eclipse.ui.dialogs.FilteredList.FilterMatcher;

/** This is a matcher that matches anywhere, not just at the beginning. */
public class AnywhereFilterMatcher implements FilterMatcher {
	private StringMatcher fMatcher;

	public void setFilter(final String pattern, final boolean ignoreCase,
			final boolean ignoreWildCards) {
		this.fMatcher = new StringMatcher('*' + pattern + '*', ignoreCase, ignoreWildCards);
	}

	public boolean match(final Object element) {
		return this.fMatcher.match(element.toString());
	}
}
