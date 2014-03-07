/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
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
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.DiModel;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;

import com.google.common.base.Optional;

/**
 * A ReadOnlyHandler for the Sash Model (*.sash or *.di).
 *
 * If the model is located in the user preferences space, it may be considered
 * read-only by other read-only handlers, whereas it shouldn't.
 * 
 * Its priority should be greater than EMFReadOnlyHandler, FSReadOnlyHandler and
 *
 * @author Camille Letavernier
 *
 */
public class SashModelReadOnlyHandler extends AbstractReadOnlyHandler {

	private ModelSet modelSet;

	public SashModelReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);

		if(getEditingDomain().getResourceSet() instanceof ModelSet) {
			modelSet = (ModelSet)getEditingDomain().getResourceSet();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Optional<Boolean> anyReadOnly(URI[] uris) {
		if(modelSet == null) {
			return Optional.absent();
		}

		for(URI uri : uris) {
			if(SashModel.SASH_MODEL_FILE_EXTENSION.equals(uri.fileExtension())) {
				return Optional.of(false);
			}

			if(DiModel.DI_FILE_EXTENSION.equals(uri.fileExtension())) {
				return Optional.of(false);
			}
		}

		return Optional.absent();
	}

	/**
	 * {@inheritDoc}
	 */
	public Optional<Boolean> makeWritable(URI[] uris) {
		return Optional.absent(); //If the file is read-only, it can probably made writable by other read-only handlers (e.g. FSReadOnlyHandler).
	}



}
