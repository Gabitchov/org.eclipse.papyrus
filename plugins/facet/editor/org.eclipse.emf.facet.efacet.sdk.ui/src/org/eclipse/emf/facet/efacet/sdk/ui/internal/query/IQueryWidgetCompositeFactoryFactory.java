/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.query;

import java.util.List;

import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.IQueryDialogFactoryStrategy;

/**
 * This interface provide to get all the plug-ins extending the extension point
 * and the lazy loading of this plug-ins.
 * 
 * @see QueryWidgetCompositeFactoryImpl
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IQueryWidgetCompositeFactoryFactory {

	/**
	 * Returns an instance of {@link QueryWidgetCompositeFactoryImpl}.
	 */
	IQueryWidgetCompositeFactoryFactory INSTANCE = new QueryWidgetCompositeFactoryImpl();

	/**
	 * Return a registered {@link AbstractQueryDialogFactory} corresponding to
	 * the given type name.
	 * 
	 * @param managedTypeName
	 *            the <i>managedQueryTypeName</i> extension attribute.
	 * @return an instance of the class which implements
	 *         {@link AbstractQueryDialogFactory}.
	 */
	IQueryDialogFactoryStrategy getQueryDialogFactoryStrategy(
			String managedTypeName);

	/**
	 * Returns every registered {@link AbstractQueryDialogFactory} name.
	 * 
	 * @return a list containing the <i>managedQueryTypeName</i>.
	 */
	List<String> getRegisteredQueryWidgetsComposite();

}
