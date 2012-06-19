/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.ProviderBasedBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.strategy.StrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.strategy.WorkspaceRevealStrategy;


/**
 * A Workspace content provider with search possibilities and filters
 * 
 * @author Camille Letavernier
 */
public class WorkspaceContentProvider extends EncapsulatedContentProvider {

	/**
	 * Constructor
	 */
	public WorkspaceContentProvider() {
		super(encapsulateProvider(getSemanticProvider()));
	}

	protected static IHierarchicContentProvider getSemanticProvider() {
		return new SemanticWorkspaceContentProvider();
	}

	protected static IStructuredContentProvider encapsulateProvider(IHierarchicContentProvider provider) {
		TreeBrowseStrategy browseStrategy = new ProviderBasedBrowseStrategy(provider);
		TreeBrowseStrategy revealStrategy = new WorkspaceRevealStrategy(provider);
		StrategyBasedContentProvider strategyProvider = new StrategyBasedContentProvider(browseStrategy, revealStrategy);


		EncapsulatedContentProvider graphicalProvider = new FilteredContentProvider(strategyProvider);

		return graphicalProvider;
	}

}
