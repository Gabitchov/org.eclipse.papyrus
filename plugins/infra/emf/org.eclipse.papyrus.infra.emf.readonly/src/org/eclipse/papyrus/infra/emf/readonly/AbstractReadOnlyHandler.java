/*****************************************************************************
 * Copyright (c) 2013 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler;

import com.google.common.base.Optional;

public abstract class AbstractReadOnlyHandler implements IReadOnlyHandler {

	private EditingDomain editingDomain;

	public AbstractReadOnlyHandler(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	public Optional<Boolean> isReadOnly(EObject eObject) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return anyReadOnly(new URI[] {res.getURI()});
		}
		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(EObject eObject) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return makeWritable(new URI[] {res.getURI()});
		}
		return Optional.absent();
	}

}
