/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Abstract Implementation of the {@link IModel} interface.
 */
public abstract class AbstractModel implements IModel {

	/** Default encoding */
	public static final String ENCODING = "UTF-8"; //$NON-NLS-1$

	/** The associated ModelManager */
	protected ModelSet modelSet;

	/** List of attached snippets */
	protected ModelSnippetList snippets = new ModelSnippetList();

	/** list of Models (referenced by identifiers) that should be loaded before this one can be loaded */
	protected List<String> afterLoadModelIdentifiers;

	/** list of Models (referenced by identifiers) that should not be loaded before this one is unloaded */
	protected List<String> unloadBeforeModelIdentifiers;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(ModelSet modelSet) {
		this.modelSet = modelSet;
	}

	/**
	 * Returns the ModelSet given during initialization
	 * 
	 * @return the ModelSet given during initialization
	 */
	protected ModelSet getModelManager() {
		return modelSet;
	}

	/**
	 * Returns the associated ResourceSet containing the resources of this model.
	 * 
	 * @return the associated ResourceSet containing the resources of this model.
	 */
	protected ResourceSet getResourceSet() {
		return modelSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String getIdentifier();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addModelSnippet(IModelSnippet snippet) {
		snippets.add(snippet);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAfterLoadModelDependencies(List<String> afterLoadModelIdentifiers) {
		this.afterLoadModelIdentifiers = afterLoadModelIdentifiers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getAfterLoadModelIdentifiers() {
		return afterLoadModelIdentifiers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setBeforeUnloadDependencies(List<String> unloadBeforeModelIdentifiers) {
		this.unloadBeforeModelIdentifiers = unloadBeforeModelIdentifiers;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getUnloadBeforeModelIdentifiers() {
		return unloadBeforeModelIdentifiers;
	}

	@Override
	public void unload() {
		this.modelSet = null;
		snippets.clear();
	}

	@Override
	public boolean isModelFor(Object element) {
		return false;
	}
}
