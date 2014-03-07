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
package org.eclipse.papyrus.uml.profile.readonly;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ReadOnlyAxis;
import org.eclipse.papyrus.infra.emf.readonly.AbstractReadOnlyHandler;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.eclipse.uml2.uml.Profile;

import com.google.common.base.Optional;

/**
 * Discretion-based read-only handler for applied profiles.
 */
public class AppliedProfileReadOnlyHandler extends AbstractReadOnlyHandler {

	public AppliedProfileReadOnlyHandler(EditingDomain editingDomain) {
		super(editingDomain);
	}

	public Optional<Boolean> anyReadOnly(Set<ReadOnlyAxis> axes, URI[] uris) {
		if((getEditingDomain() != null) && axes.contains(ReadOnlyAxis.DISCRETION)) {
			Resource mainUmlResource = null;
			if(getEditingDomain().getResourceSet() instanceof ModelSet) {
				UmlModel umlModel = (UmlModel)((ModelSet)getEditingDomain().getResourceSet()).getModel(UmlModel.MODEL_ID);
				if(umlModel == null) {
					return Optional.absent();
				}
				mainUmlResource = umlModel.getResource();
			}

			for(URI uri : uris) {
				Resource resource = getEditingDomain().getResourceSet().getResource(uri, false);
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

	public Optional<Boolean> makeWritable(Set<ReadOnlyAxis> axes, URI[] uris) {
		return Optional.absent(); //Applied profiles should remain read-only
	}

}
