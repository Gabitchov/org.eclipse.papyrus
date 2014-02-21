/**
 * Copyright (c) 2011, 2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Gregoire Dupe (Mia-Software) - Bug 364325 - [Restructuring] The user must be able to navigate into a model using the Facet.
 */
package org.eclipse.emf.facet.efacet.ui;

import java.util.List;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.runtime.ETypedElementResult;
import org.eclipse.ui.IWorkbenchPart;


/**
 * This method must be implemented and referenced by the extension point org.eclipse.emf.facet.efacet.ui.displayeropener
 * 
 * This is a new version of the org.eclipse.emf.facet.infra.query.ui.views.queryExecution.QueryResultDisplayer.
 * @author Gregoire Dupe
 *
 */
public interface IETypedElementResultDisplayerOpener {
	IWorkbenchPart open(List<ETypedElementResult> results);
}
