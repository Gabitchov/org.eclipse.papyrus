/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 429826
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.AbstractReadOnlyHandler;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;

import com.google.common.base.Optional;

/**
 * The EMF read-only handler is permission-based.
 */
public class EMFReadOnlyHandler extends AbstractReadOnlyHandler {

	public EMFReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		if(axes.contains(ReadOnlyAxis.PERMISSION)) {
			for(URI uri : uris) {
				if(!uri.isPlatformResource()) {
					return Optional.of(Boolean.TRUE);
				}
			}
		}
		
		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		return Optional.absent(); //We cannot change the read-only status
	}

}
