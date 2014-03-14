/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.core.resource.sasheditor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.core.resource.ModelSet;


/**
 * A partial implementation of the {@link ISashModelProvider} protocol.
 */
public abstract class AbstractSashModelProvider implements ISashModelProvider {

	private ModelSet modelSet;

	public AbstractSashModelProvider() {
		super();
	}

	@Override
	public void initialize(ModelSet modelSet) {
		this.modelSet = modelSet;
	}

	@Override
	public void dispose() {
		modelSet = null;
	}

	protected ModelSet getModelSet() {
		return modelSet;
	}

	@Override
	public Resource loadSashModel(URI sashModelURI) {
		return modelSet.getResource(sashModelURI, true);
	}

}
