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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.widget.IAbstractWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * This class will be used for the creation of a java query.
 * 
 * @see JavaQueryWidget
 */
public interface IQueryDialogFactoryStrategy {

	IAbstractWidget createWidget(Composite parent,
			IQueryContext queryContext);

	Query createQuery(boolean canBeCached, boolean sideEffects,
			IQueryContext queryContext);

	String getDialogMessage();

	String getDialogTitle();

	String getConclusionText();

}
