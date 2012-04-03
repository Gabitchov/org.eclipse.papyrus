/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico emilien.perico@atosorigin.com - manage loading strategies
 *
 *****************************************************************************/
package org.eclipse.papyrus.resource.additional;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.resource.IModel;
import org.eclipse.papyrus.resource.IModelSnippet;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelSnippetList;

public class AdditionalResourcesModel implements IModel {

	/**
	 * The associated ModelManager.
	 */
	private ModelSet modelSet;

	/**
	 * List of attached snippets.
	 */
	private ModelSnippetList snippets = new ModelSnippetList();

	/**
	 * Model ID.
	 */
	public static String MODEL_ID = "org.eclipse.papyrus.resource.additional";

	public void init(ModelSet modelManager) {
		this.modelSet = modelManager;
	}

	public String getIdentifier() {
		return MODEL_ID;
	}

	/**
	 * useless for additional resources
	 */
	public void createModel(IPath fullPath) {
		// do nothing
	}

	public void loadModel(IPath path) {
		// call registered snippets
		snippets.performStart(this);
	}

	public void importModel(IPath fullPathWithoutExtension) {
		loadModel(fullPathWithoutExtension);
	}

	public void saveModel() throws IOException {
		for(Resource r : modelSet.getResources()) {
			if(isAdditionalResource(getModelManager(), r.getURI())) {
				// only save referenced models not
				// read-only and either platform or file
				if(!modelSet.getTransactionalEditingDomain().isReadOnly(r)
					&& (r.getURI().isPlatformResource() || r.getURI().isFile())) {
					r.save(Collections.EMPTY_MAP);
				}
			}
		}
	}

	/**
	 * useless for additional resources
	 */
	public void changeModelPath(IPath fullPath) {
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

	public void addModelSnippet(IModelSnippet snippet) {
		snippets.add(snippet);
	}

	/**
	 * @return the modelManager
	 */
	protected ModelSet getModelManager() {
		return modelSet;
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
			String platformString = uri.trimFileExtension().toPlatformString(false);
			return ((platformString == null) || !modelSet.getFilenameWithoutExtension().toString().equals(platformString.toString()));
		}
		return false;
	}
}
