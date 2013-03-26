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
package org.eclipse.papyrus.infra.emf.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Optional;


public class EMFReadOnlyHandler extends AbstractReadOnlyHandler {

	EMFReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	public Optional<Boolean> anyReadOnly(URI[] uris) {
		for(URI uri : uris) {
			if(!uri.isPlatformResource()) {
				return Optional.of(Boolean.TRUE);
			}
		}

		return Optional.absent();
	}

	public Optional<Boolean> makeWritable(URI[] uris) {
		return Optional.absent(); //We cannot change the read-only status
	}

}
