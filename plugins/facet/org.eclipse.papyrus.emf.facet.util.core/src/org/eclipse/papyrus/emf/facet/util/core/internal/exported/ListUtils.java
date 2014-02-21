/*******************************************************************************
 * Copyright (c) 2012 CEA-LIST
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *******************************************************************************/
package org.eclipse.emf.facet.util.core.internal.exported;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @since 0.2
 */
public final class ListUtils {

	private ListUtils() {
		// Must not be used.
	}

	public static <T> List<T> cleanList(final Collection<T> collection) {
		final List<T> cleanList = new ArrayList<T>(collection);
		while (cleanList.contains(null)) {
			cleanList.remove(null);
		}
		return cleanList;
	}
}
