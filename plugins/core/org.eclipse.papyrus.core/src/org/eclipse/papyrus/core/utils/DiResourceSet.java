/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.listenerservice.ModelListenerManager;

/**
 * ResourceSet Manager for UML and DI files, and also other loaded models.
 * 
 * @author Cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 */
public class DiResourceSet extends ResourceSetImpl {

	/**
	 * File extension used for DI.
	 */
	public static final String DI_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/**
	 * File extension used for Model.
	 */
	public static final String MODEL_FILE_EXTENSION = "uml"; //$NON-NLS-1$

	/**
	 * File extension used for Model.
	 */
	public static final String NOTATION_FILE_EXTENSION = "notation"; //$NON-NLS-1$

	/**
	 * The UML model resource.
	 */
	private Resource modelResource;

	/**
	 * The DI resource.
	 */
	private Resource diResource;

	/**
	 * The DI resource.
	 */
	private Resource notationResource;

	private TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * Just loads the model into the current resource set.
	 * 
	 * @returns The loaded model.
	 */
	public Resource loadModelResource(URI uri) {
		// FIXME maybe check that model is null ?!
		modelResource = getResource(uri, true);
		return getModelResource();
	}

	/**
	 * Load both files (DI and UML) from an handle on one of the two files.
	 * 
	 * @param file
	 */
	public void loadResources(IFile file) {
		// Extract file name, without extension
		IPath fullPath = file.getFullPath().removeFileExtension();

		// Load UML file
		URI uri = getPlatformURI(fullPath.addFileExtension(MODEL_FILE_EXTENSION));
		loadModelResource(uri);

		// TODO move next line away from DiResourceSet ? Define a place
		// where Resource initialization can take place.
		modelResource.eAdapters().add(new ModelListenerManager());

		// load DI2
		URI diUri = getPlatformURI(fullPath.addFileExtension(DI_FILE_EXTENSION));
		diResource = getResource(diUri, true);

		// load notation
		URI notationURI = getPlatformURI(fullPath.addFileExtension(NOTATION_FILE_EXTENSION));
		notationResource = getResource(notationURI, true);

	}

	/**
	 * Create both files (DI and UML) from a filename.
	 * 
	 * @param newFile
	 *            the file from which path is extracted to create the new files
	 */
	public void createModelResources(IFile newFile, String eContentType) {

		// create the di resource URI
		URI diUri = getPlatformURI(newFile.getFullPath());
		// Create the di Resource for the sashcontainer
		// The model will be automatically initialized by the SashContainer if
		// needed (if it is empty).
		// Normally the resource should contains models set by previous use from
		// the SashContainer
		diResource = createResource(diUri);

		IPath filenameWithoutExtension = newFile.getFullPath().removeFileExtension();
		// if the uml model is not loaded, create resource
		if (modelResource == null) {
			// create the model URI
			URI modelUri = getPlatformURI(filenameWithoutExtension.addFileExtension("uml"));
			// create the model resource
			modelResource = createResource(modelUri, eContentType);
		}
		// create the notation URI
		URI notationURI = getPlatformURI(filenameWithoutExtension.addFileExtension(NOTATION_FILE_EXTENSION));
		// create the notation resource
		notationResource = createResource(notationURI);

	}

	/**
	 * Get a platform resource URI of the given path
	 * 
	 * @param path
	 *            the path
	 * @return the uri
	 */
	private URI getPlatformURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	/**
	 * Save the resources.
	 * 
	 * @param monitor
	 *            The monitor.
	 * @throws IOException
	 *             IO Error.
	 */
	public void save(IProgressMonitor monitor) throws IOException {
		monitor.beginTask("Saving resources", 3);
		try {
			// save associated resources
			modelResource.save(null);
			monitor.worked(1);
			diResource.save(null);
			monitor.worked(1);
			notationResource.save(null);
			monitor.worked(1);
		} finally {
			monitor.done();
		}
	}

	/**
	 * The resources are already loaded, but we want to save them under another name.
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void saveAs(IPath path) throws IOException {
		IPath nameWithoutExt = path.removeFileExtension();
		IPath modelPath = nameWithoutExt.addFileExtension(MODEL_FILE_EXTENSION);
		IPath notationPath = nameWithoutExt.addFileExtension(NOTATION_FILE_EXTENSION);
		IPath diPath = nameWithoutExt.addFileExtension(DI_FILE_EXTENSION);

		// Set model URI
		URI modelUri = getPlatformURI(modelPath);
		modelResource.setURI(modelUri);

		// Set notation URI
		URI notationURI = getPlatformURI(notationPath);
		notationResource.setURI(notationURI);

		// set di uri
		URI diUri = getPlatformURI(diPath);
		diResource.setURI(diUri);

		save(new NullProgressMonitor());
	}

	/**
	 * Returns the notation resource.
	 * 
	 * @return the notationResource
	 */
	public Resource getNotationResource() {
		return notationResource;
	}

	/**
	 * 
	 * 
	 * @return the diResource
	 */
	public Resource getDiResource() {
		return diResource;
	}

	/**
	 * Returns the model resource.
	 * 
	 * @return the modelResource
	 */
	public Resource getModelResource() {
		return modelResource;
	}

	/**
	 * Returns the additional resources.
	 * 
	 * @return The additional resources.
	 */
	public List<Resource> getAdditionalResources() {
		List<Resource> additionnalResources = new ArrayList<Resource>();
		for (Resource resource : getResources()) {
			// ignore di, notation and domain resources
			if (resource != diResource && resource != notationResource && resource != modelResource) {
				additionnalResources.add(resource);
			}
		}

		return additionnalResources;
	}

	/**
	 * Create the transactional editing domain
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain() {
		transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(this);
		if (transactionalEditingDomain == null) {
			transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(this);
			// What for?
			transactionalEditingDomain.setID("SharedEditingDomain"); //$NON-NLS-1$
		}
		return transactionalEditingDomain;
	}

}
