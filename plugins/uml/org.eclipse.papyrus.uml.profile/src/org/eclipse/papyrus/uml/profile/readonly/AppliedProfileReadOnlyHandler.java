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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.uml.UmlModel;
import org.eclipse.papyrus.infra.emf.readonly.IReadOnlyHandler;
import org.eclipse.uml2.uml.Profile;


public class AppliedProfileReadOnlyHandler implements IReadOnlyHandler {

	public boolean isReadOnly(URI[] uris, EditingDomain editingDomain) {
		if(editingDomain != null) {
			Resource mainUmlResource = null;
			if(editingDomain.getResourceSet() instanceof ModelSet) {
				UmlModel umlModel = (UmlModel)((ModelSet)editingDomain.getResourceSet()).getModel(UmlModel.MODEL_ID);
				if(umlModel == null) {
					return false;
				}
				mainUmlResource = umlModel.getResource();
			}

			for(URI uri : uris) {
				Resource resource = editingDomain.getResourceSet().getResource(uri, false);
				if(isProfileResource(resource) && mainUmlResource != resource) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isProfileResource(Resource resource) {
		if(resource == null) {
			return false;
		}

		for(EObject rootElement : resource.getContents()) {
			if(rootElement instanceof Profile) {
				return true;
			}
		}

		return false;
	}

	public boolean enableWrite(URI[] uris, EditingDomain editingDomain) {
		return false; //Applied profiles should remain read-only
	}

}
