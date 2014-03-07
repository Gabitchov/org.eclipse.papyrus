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
 *  Christian W. Damus (CEA) - bug 429826
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import static org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis.permissionAxes;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.IReadOnlyHandler2;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;

import com.google.common.base.Optional;

public abstract class AbstractReadOnlyHandler implements IReadOnlyHandler2 {

	private EditingDomain editingDomain;

	public AbstractReadOnlyHandler(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	@Deprecated
	public Optional<Boolean> anyReadOnly(URI[] uris) {
		return anyReadOnly(permissionAxes(), uris);
	}
	
	@Deprecated
	public Optional<Boolean> isReadOnly(EObject eObject) {
		return isReadOnly(permissionAxes(), eObject);
	}

	public Optional<Boolean> isReadOnly(Set<ReadOnlyAxis> axes, EObject eObject) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return anyReadOnly(axes, new URI[] {res.getURI()});
		}
		return Optional.absent();
	}

	@Deprecated
	public Optional<Boolean> makeWritable(URI[] uris) {
		return makeWritable(permissionAxes(), uris);
	}
	
	@Deprecated
	public Optional<Boolean> makeWritable(EObject eObject) {
		return makeWritable(permissionAxes(), eObject);
	}

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, EObject eObject) {
		Resource res = eObject.eResource();
		if (res != null && res.getURI() != null) {
			return makeWritable(axes, new URI[] {res.getURI()});
		}
		return Optional.absent();
	}

	/**
	 * By default, we do not handle writability of these resources.
	 */
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		return Optional.absent();
	}
	
	public Optional<Boolean> canMakeWritable(Set<ReadOnlyAxis> axes, EObject object) {
		Resource res = object.eResource();
		if((res != null) && (res.getURI() != null)) {
			return canMakeWritable(axes, new URI[]{ res.getURI() });
		}
		return Optional.absent();
	}
}
