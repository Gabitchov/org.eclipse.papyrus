/*****************************************************************************
 * Copyright (c) 2013, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;

import com.google.common.base.Optional;

public abstract class AbstractReadOnlyHandler implements IReadOnlyHandler2 {

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

	/**
	 * By default, we do not handle writability of these resources.
	 */
	public Optional<Boolean> canMakeWritable(URI[] uris) {
		return Optional.absent();
	}
	
	public Optional<Boolean> canMakeWritable(EObject object) {
		Resource res = object.eResource();
		if((res != null) && (res.getURI() != null)) {
			return canMakeWritable(new URI[]{ res.getURI() });
		}
		return Optional.absent();
	}
}
