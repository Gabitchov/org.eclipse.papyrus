/*****************************************************************************
 * Copyright (c) 2010, 2013 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico emilien.perico@atosorigin.com - manage loading strategies
 *  Christian W. Damus (CEA) - manage models by URI, not IFile (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource.additional;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.papyrus.infra.core.resource.AbstractModel;
import org.eclipse.papyrus.infra.core.resource.IModel;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelUtils;

public class AdditionalResourcesModel extends AbstractModel implements IModel {

	/** Model identifier */
	public static String MODEL_ID = "org.eclipse.papyrus.infra.core.resource.additional";

	/**
	 * {@inheritDoc}
	 */
	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * useless for additional resources
	 */
	@Deprecated
	public void createModel(IPath fullPath) {
		// do nothing
	}

	public void createModel(URI uri) {
		// do nothing
	}

	@Deprecated
	public void loadModel(IPath path) {
		// call registered snippets
		snippets.performStart(this);
	}

	public void loadModel(URI uri) {
		// call registered snippets
		snippets.performStart(this);
	}

	@Deprecated
	public void importModel(IPath fullPathWithoutExtension) {
		loadModel(fullPathWithoutExtension);
	}

	public void importModel(URI uriWithoutExtension) {
		loadModel(uriWithoutExtension);
	}

	public void saveModel() throws IOException {
		for(Resource r : modelSet.getResources()) {
			if(isAdditionalResource(getModelManager(), r.getURI())) {
				// only save referenced models not
				// read-only and either platform or file
				if(!modelSet.getTransactionalEditingDomain().isReadOnly(r) && (r.getURI().isPlatformResource() || r.getURI().isFile()) && !ModelUtils.resourceFailedOnLoad(r)) {
					if(r instanceof XMIResource){
						r.save(Collections.singletonMap(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware()));
					}else {
						r.save(Collections.EMPTY_MAP);
					}

				}
			}
		}
	}

	/**
	 * useless for additional resources
	 */
	@Deprecated
	public void changeModelPath(IPath fullPath) {
		// do nothing
	}

	public void setModelURI(URI uri) {
		// do nothing
	}

	public void unload() {
		// call registered snippets
		snippets.performDispose(this);

		// Unload remaining resources
		for(int i = 0; i < modelSet.getResources().size(); i++) {
			Resource next = modelSet.getResources().get(i);
			if(isAdditionalResource(getModelManager(), next.getURI())) {
				next.unload();
			}
		}
	}

	/**
	 * Check is a resource is additional in the resource set
	 * 
	 * @param uri
	 *        the specified URI of the resource
	 * @return true if it is an additional resource
	 */
	public static boolean isAdditionalResource(ModelSet modelSet, URI uri) {
		if(uri != null) {
			URI uriWithoutExt = uri.trimFileExtension();
			return !modelSet.getURIWithoutExtension().equals(uriWithoutExt);
		}
		return false;
	}

	public Set<URI> getModifiedURIs() {
		Set<URI> res = new HashSet<URI>();
		for(Resource r : modelSet.getResources()) {
			if(isAdditionalResource(getModelManager(), r.getURI())) {
				if (!r.isTrackingModification() || r.isModified()) {
					res.add(r.getURI());
				}
			}
		}
		return res;
	}

}
