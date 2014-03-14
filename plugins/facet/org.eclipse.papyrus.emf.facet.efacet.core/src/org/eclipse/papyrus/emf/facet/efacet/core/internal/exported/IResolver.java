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
package org.eclipse.papyrus.emf.facet.efacet.core.internal.exported;

import java.util.List;

/**
 * The interface has to be implemented to contribute to the extension point
 * 'org.eclipse.papyrus.emf.facet.efacet.core.internal.resolver'.
 */
public interface IResolver {

	/**
	 * Return true is the parameter object can be handle by the implementation
	 * of this interface.
	 * 
	 * @param object
	 * @return
	 */
	boolean canHandle(Object object);

	/**
	 * If the parameter 'object' is a proxy, this method returns the
	 * corresponding a resolved object.
	 * 
	 * @param object
	 *            a proxy
	 * @param aClass
	 *            the expected resolved object
	 */
	<T> T resolve(Object object, Class<T> aClass);

	/**
	 * This method returns the objects that have to be automatically selected
	 * when the parameter 'selectedObject' is selected.
	 * 
	 * @param selectedObject
	 * @param aClass
	 *            the expected list elements type.
	 */
	<T> List<T> selectionPropagation(Object selectedObject, Class<T> aClass);

	/**
	 * This method returns the root of the objects that have to be automatically
	 * selected when the parameter 'selectedObject' is selected.
	 * 
	 * @param selectedObject
	 * @param aClass
	 *            the expected list elements type.
	 */
	<T> T selectionRoot(Object selectedObject, Class<T> aClass);
}
