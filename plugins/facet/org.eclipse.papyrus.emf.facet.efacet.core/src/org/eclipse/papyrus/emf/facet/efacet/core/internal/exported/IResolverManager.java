/**
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 375087 - [Table] ITableWidget.addColumn(List<ETypedElement>, List<FacetSet>)
 *    Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 */
package org.eclipse.emf.facet.efacet.core.internal.exported;

import java.util.List;

import org.eclipse.emf.facet.efacet.core.internal.ResolverManager;

public interface IResolverManager {

	IResolverManager DEFAULT = new ResolverManager();

	<T> T resolve(Object object, Class<T> aClass);

	<T> List<T> selectionPropagation(Object selectedObject, Class<T> aClass);
	
	<T> T selectionRoot(Object selectedObject, Class<T> aClass);

}
