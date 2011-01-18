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
import java.util.Iterator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
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
		//do nothing
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
			if(modelSet.isAdditionalResource(r.getURI())) {
				EditingDomain editingDomain = modelSet.getTransactionalEditingDomain();
				if(!r.getContents().isEmpty() && editingDomain != null && !editingDomain.isReadOnly(r) && (r.getURI().isPlatform() || r.getURI().isFile())) {
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
		for(Iterator<Resource> iter = modelSet.getResources().iterator(); iter.hasNext();) {
			Resource next = iter.next();
			if(modelSet.isAdditionalResource(next.getURI())) {
				next.unload();
			}
			iter.remove();
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

}
