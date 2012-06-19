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
package org.eclipse.papyrus.infra.emf.providers.strategy;

import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;

/**
 * @author Camille Letavernier
 * 
 * @deprecated This class has been moved to infra.widgets
 */
@Deprecated
public class StrategyBasedContentProvider extends org.eclipse.papyrus.infra.widgets.strategy.StrategyBasedContentProvider {

	public StrategyBasedContentProvider(TreeBrowseStrategy browseStrategy, TreeBrowseStrategy revealStrategy) {
		super(browseStrategy, revealStrategy);
	}

}
