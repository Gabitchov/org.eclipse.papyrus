/*******************************************************************************
 * Copyright (c) 2010, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software)
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.ui;

import java.util.List;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;

/**
 * Implemented by a view or editor that wants to be used to display the results
 * of a model query.
 */
//Copied from org.eclipse.emf.facet.infra.query.ui.views.queryExecution.QueryResultDisplayer
public interface IETypedElementResultDisplayer {
	void displayETypedElementResults(final List<ETypedElementResult> result, EditingDomain editingDomain);

	String getName();
}
