/*
 * Copyright (c) 2012 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - initial API and implementation
 */
package org.eclipse.papyrus.infra.services.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.papyrus.infra.core.resource.ModelSet;

/**
 * A {@linkplain IClientSelector client-context selector} that matches elements
 * in {@linkplain ModelSet Papyrus resource-sets}.
 */
public class PapyrusClientSelector
		implements IClientSelector {

	/**
	 * Initializes me.
	 */
	public PapyrusClientSelector() {
		super();
	}

	public boolean selects(Object object) {
		boolean result = false;

		if (object instanceof EObject) {
			EObject eObject = (EObject) object;
			Resource resource = eObject.eResource();
			result = (resource != null)
				&& (resource.getResourceSet() instanceof ModelSet);
		}

		return result;
	}

}
