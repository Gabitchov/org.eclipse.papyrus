/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

// TODO: Auto-generated Javadoc
/**
 * The Class ImportedLibrary.
 */
public class ImportedLibrary {

	/** The library model. */
	private EObject libraryModel;

	/** The new uri. */
	private String newUri;

	/** The old uri. */
	private URI oldURI;



	/** The name. */
	private String name;



	/**
	 * Instantiates a new imported library.
	 * 
	 * @param libraryModel
	 *        the library model
	 * @param newUri
	 *        the new uri
	 * @param oldURI
	 *        the old uri
	 * @param libraryName
	 *        the library name
	 */
	public ImportedLibrary(EObject libraryModel, String newUri, URI oldURI, String libraryName) {
		super();
		this.libraryModel = libraryModel;
		this.newUri = newUri;
		this.name = libraryName;
		this.oldURI = oldURI;

	}


	/**
	 * Gets the library model.
	 * 
	 * @return the library model
	 */
	public EObject getLibraryModel() {
		return libraryModel;
	}

	/**
	 * Sets the library model.
	 * 
	 * @param libraryModel
	 *        the new library model
	 */
	public void setLibraryModel(EObject libraryModel) {
		this.libraryModel = libraryModel;
	}

	/**
	 * Gets the uri.
	 * 
	 * @return the uri
	 */
	public String getUri() {
		return newUri;
	}

	/**
	 * Sets the uri.
	 * 
	 * @param uri
	 *        the new uri
	 */
	public void setUri(String uri) {
		this.newUri = uri;
	}


	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the name.
	 * 
	 * @param name
	 *        the new name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets the old uri.
	 * 
	 * @return the old uri
	 */
	public URI getOldURI() {
		return oldURI;
	}


	/**
	 * Sets the old uri.
	 * 
	 * @param oldURI
	 *        the new old uri
	 */
	public void setOldURI(URI oldURI) {
		this.oldURI = oldURI;
	}





}
