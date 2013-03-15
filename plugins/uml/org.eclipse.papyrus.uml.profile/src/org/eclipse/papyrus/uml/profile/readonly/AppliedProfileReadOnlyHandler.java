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
package org.eclipse.papyrus.uml.profile.readonly;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.emf.readonly.AbstractReadOnlyHandler;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Profile;

import com.google.common.base.Optional;


public class AppliedProfileReadOnlyHandler extends AbstractReadOnlyHandler {

	public Optional<Boolean> anyReadOnly(URI[] uris, EditingDomain editingDomain) {
		if(editingDomain != null) {
			Resource mainUmlResource = null;
			if(editingDomain.getResourceSet() instanceof ModelSet) {
				UmlModel umlModel = (UmlModel)((ModelSet)editingDomain.getResourceSet()).getModel(UmlModel.MODEL_ID);
				if(umlModel == null) {
					return Optional.absent();
				}
				mainUmlResource = umlModel.getResource();
			}

			for(URI uri : uris) {
				Resource resource = editingDomain.getResourceSet().getResource(uri, false);
				if(isProfileResource(resource) && mainUmlResource != resource) {
					return Optional.of(Boolean.TRUE);
				}
			}
		}

		return Optional.absent();
	}

	private boolean isProfileResource(Resource resource) {
		if(resource == null) {
			return false;
		}

		if (!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof Profile) {
			return true;
		}

		return false;
	}

	public Optional<Boolean> makeWritable(URI[] uris, EditingDomain editingDomain) {
		return Optional.absent(); //Applied profiles should remain read-only
	}

}
