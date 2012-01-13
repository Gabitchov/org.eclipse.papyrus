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
package org.eclipse.papyrus.uml.tools.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.emf.providers.EMFGraphicalContentProvider;
import org.eclipse.papyrus.infra.emf.providers.strategy.StrategyBasedContentProvider;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.widgets.strategy.IStrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.ProviderBasedBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;
import org.eclipse.papyrus.uml.tools.providers.UMLContainmentBrowseStrategy;


public class UMLProviderHelper {

	/**
	 * Encapsulates the given content provider in a higher-level content provider
	 * The returned provider uses two different strategies to display and search
	 * elements, and adds a pattern filter and an History
	 * 
	 * @param provider
	 *        The ContentProvider to encapsulate
	 * @return
	 */
	public static EMFGraphicalContentProvider encapsulateProvider(IStructuredContentProvider provider, EObject editedEObject, EStructuralFeature feature) {
		String historyId = HistoryUtil.getHistoryID(editedEObject, feature);

		IStructuredContentProvider contentProvider;

		if(provider instanceof ITreeContentProvider) {
			contentProvider = getStrategyProvider((ITreeContentProvider)provider);
		} else {
			contentProvider = provider;
		}

		EMFGraphicalContentProvider graphicalProvider = new EMFGraphicalContentProvider(contentProvider, editedEObject.eResource().getResourceSet(), historyId);

		return graphicalProvider;
	}

	public static IStrategyBasedContentProvider getStrategyProvider(ITreeContentProvider provider) {
		TreeBrowseStrategy browseStrategy = new ProviderBasedBrowseStrategy(provider);
		TreeBrowseStrategy revealStrategy = new UMLContainmentBrowseStrategy(provider);

		return new StrategyBasedContentProvider(browseStrategy, revealStrategy);
	}
}
