/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.infra.emf.providers.strategy.ContainmentBrowseStrategy;
import org.eclipse.papyrus.infra.emf.providers.strategy.SemanticEMFContentProvider;
import org.eclipse.papyrus.infra.emf.utils.HistoryUtil;
import org.eclipse.papyrus.infra.widgets.providers.EmptyContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.IStrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.ProviderBasedBrowseStrategy;
import org.eclipse.papyrus.infra.widgets.strategy.StrategyBasedContentProvider;
import org.eclipse.papyrus.infra.widgets.strategy.TreeBrowseStrategy;

/**
 * A global Content provider for EMF
 * 
 * @author Camille Letavernier
 */
public class EMFContentProvider extends EncapsulatedContentProvider {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param feature
	 *        The feature representing the reference for which we want to retrieve possible values
	 * @param eObject
	 */
	public EMFContentProvider(EObject editedEObject, EStructuralFeature feature) {
		IStructuredContentProvider provider = getSemanticProvider(editedEObject, feature);

		encapsulated = encapsulateProvider(provider, editedEObject, feature);
	}

	/**
	 * Returns the content provider associated to feature being edited
	 * 
	 * @param editedEObject
	 *        The object being edited
	 * @param feature
	 *        The object's feature being edited
	 * @return
	 *         A content provider returning all the values valid for the given feature
	 */
	protected IStructuredContentProvider getSemanticProvider(EObject editedEObject, EStructuralFeature feature) {
		EClassifier type = feature.getEType();
		if(type instanceof EEnum) {
			return new EMFEnumeratorContentProvider(feature);
		} else if(type instanceof EClass) {
			return new SemanticEMFContentProvider(editedEObject, feature);
		}

		return EmptyContentProvider.instance;
	}

	/**
	 * Encapsulates the given content provider in a higher-level content provider
	 * The returned provider uses two different strategies to display and search
	 * elements, and adds a pattern filter and an History
	 * 
	 * @param provider
	 *        The ContentProvider to encapsulate
	 * @return
	 */
	protected EMFGraphicalContentProvider encapsulateProvider(IStructuredContentProvider provider, EObject editedEObject, EStructuralFeature feature) {
		String historyId = HistoryUtil.getHistoryID(editedEObject, feature);

		IStructuredContentProvider contentProvider;

		if(provider instanceof ITreeContentProvider) {
			contentProvider = getStrategyProvider((ITreeContentProvider)provider);
		} else {
			contentProvider = provider;
		}

		ResourceSet rs = editedEObject == null ? null : editedEObject.eResource() == null ? null : editedEObject.eResource().getResourceSet();
		EMFGraphicalContentProvider graphicalProvider = new EMFGraphicalContentProvider(contentProvider, rs, historyId);

		return graphicalProvider;
	}

	protected IStrategyBasedContentProvider getStrategyProvider(ITreeContentProvider provider) {
		TreeBrowseStrategy browseStrategy = new ProviderBasedBrowseStrategy(provider);
		TreeBrowseStrategy revealStrategy = new ContainmentBrowseStrategy(provider);

		return new StrategyBasedContentProvider(browseStrategy, revealStrategy);
	}

}
