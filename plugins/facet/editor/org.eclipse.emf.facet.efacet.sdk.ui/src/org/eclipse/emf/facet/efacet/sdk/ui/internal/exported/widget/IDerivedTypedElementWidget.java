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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query.ICreateQueryWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;

/**
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IDerivedTypedElementWidget extends
		IETypedElementWidget<Facet, IGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget>> {

	Query getQuery();

	void setQuery(Query value);

	/**
	 * Select the query with the name in parameter.
	 * 
	 * @param queryName
	 *            the name of the query to select.
	 */
	IDialog<ICreateQueryWidget> selectQueryType(String queryName);

	/**
	 * @return true if the query is enable.
	 */
	boolean isQueryEnable();

	/**
	 * @return the text displayed with the query.
	 */
	String getQueryText();
}
