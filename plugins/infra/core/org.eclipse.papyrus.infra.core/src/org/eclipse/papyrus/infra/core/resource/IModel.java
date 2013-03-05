/*****************************************************************************
 * Copyright (c) 2010, 2013 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - manage models by URI, not IFile (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.resource;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

/**
 * A Model is a set of elements defined by a metamodel (preferably an EMF
 * metamodel). A root of a model is an element which have no parent (i.e. is not
 * contained by another element of the model). A model has usually only one
 * root. Elements of a model can be contained in one or several resources. A
 * model is identified by an id, usually the id from the metamodel package
 * (ModelPackage.eCONTENT_TYPE).
 * 
 * @author cedric dumoulin
 * 
 */
public interface IModel {

	/**
	 * Initialize the model and set its associated model manager.
	 * 
	 * @param modelManager
	 *        The associated model manager.
	 */
	public void init(ModelSet modelManager);

	/**
	 * Get the identifier identifying this model (aka: uml, notation, ...)
	 * 
	 * @return
	 */
	public String getIdentifier();

	/**
	 * Create the model repository.
	 * 
	 * @param fullPath
	 *        The full path, without extension where the model should be
	 *        saved.
	 * @deprecated Use the {@link #createModel(URI)} API, instead.
	 */
	@Deprecated
	public void createModel(IPath fullPath);

	/**
	 * Create the model resource(s).
	 * 
	 * @param uri the URI, without file extension, where the model should be saved.
	 */
	public void createModel(URI uri);

	/**
	 * Load the model from the specified path..
	 * 
	 * @param path
	 *        The full path, without extension where the model should be
	 *        saved. Should be used as a bases to guess the model IPath.
	 * @deprecated Use the {@link #createModel(URI)} API, instead.
	 */
	@Deprecated
	public void loadModel(IPath path);

	/**
	 * Load the model from the specified path..
	 * 
	 * @param uri the URI, without file extension, where the model should be saved.
	 *        Should be used as a basis to guess the model URI.
	 */
	public void loadModel(URI uri);

	/**
	 * Import the model from the specified path.
	 * 
	 * @param path
	 *        The full path, without extension.
	 * @deprecated Use the {@link #importModel(URI)} API, instead.
	 */
	@Deprecated
	public void importModel(IPath path);

	/**
	 * Import the model from the specified URI.
	 * 
	 * @param uri the URI, without file extension, where the model is.
	 */
	public void importModel(URI uri);

	/**
	 * Save the model in its repository.
	 * 
	 * @throws IOException
	 * 
	 */
	public void saveModel() throws IOException;

	/**
	 * Change the path under which the model should be save. Do not save it now
	 * !
	 * 
	 * @deprecated Use the {@link #setModelURI(URI)} API, instead.
	 */
	@Deprecated
	public void changeModelPath(IPath fullPath);

	/**
	 * Sets the path under which the model should be saved. Does not save it.
	 * 
	 * @param uri the new base model URI, without file extension
	 */
	public void setModelURI(URI uri);

	/**
	 * Dispose the model.
	 */
	public void unload();

	/**
	 * Add a snippet to this model. The snippet is called just after model is
	 * initialized, and before it is disposed or unloaded. Snippet can be shared
	 * among models.
	 * 
	 * @param snippet
	 *        The snippet to add.
	 */
	public void addModelSnippet(IModelSnippet snippet);

}
