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
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.listenerservice.ModelListenerManager;

/**
 * ResourceSet Manager for UML and DI files, and also other loaded models.
 * 
 * @author Cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiResourceSet {

	/**
	 * File extension used for DI.
	 */
	public String diFileExtension;

	/**
	 * File extension used for Model.
	 */
	public String modelFileExtension;

	/**
	 * The UML model resource.
	 */
	protected Resource modelResource;

	/**
	 * The DI resource.
	 */
	protected Resource diResource;

	/**
	 * File extension used for Model. TODO: change following and pass it throw constructor ?
	 */
	public String notationFileExtension = "notation";

	/**
	 * The DI resource.
	 */
	protected Resource notationResource;

	/**
	 * this is the editing domain to load and apply EMF command on the repository
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * this is the editing domain to load and apply EMF command on the repository
	 */
	protected TransactionalEditingDomain transactionalEditingDomain;

	// @unused
	public static String EditingDomainID = "com.cea.papyrus.core.PapyrusEditingDomainID";

	/** This is the one adapter factory used for providing views of the model */
	protected AdapterFactory adapterFactory;

	/**
	 * Creates a new DiResourceSet, using default for file extensions.
	 */
	public DiResourceSet() {
		this("di", "uml", null);
	}

	/**
	 * Creates a new DiResourceSet, using default for file extensions.
	 */
	// @unused
	public DiResourceSet(AdapterFactory adapterFactory) {
		this("di", "uml", adapterFactory);
	}

	/**
	 * Creates a new DiResourceSet, with specified extensions for di2 files and model files
	 * 
	 * @param diFileExtension
	 *            extension for di files
	 * @param modelFileExtension
	 *            extension for model files
	 */
	public DiResourceSet(String diFileExtension, String modelFileExtension, AdapterFactory adapterFactory) {
		this.diFileExtension = diFileExtension;
		this.modelFileExtension = modelFileExtension;

		// init EMF environment
		this.initEMFTool(adapterFactory);
	}

	/**
	 *this method allows initializing EMF environment. To do this we copy code of the Di2 editor.
	 */
	public void initEMFTool(AdapterFactory adapterFactory) {
		// adpater was not initialized (example: wizards)
		if (adapterFactory == null) {
			List<ComposeableAdapterFactory> factories = new ArrayList<ComposeableAdapterFactory>();

			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());

			this.adapterFactory = new ComposedAdapterFactory(factories);
		} else {
			this.adapterFactory = adapterFactory;
		}

		// Create the editing domain
		createEditingDomain();
	}

	protected void createEditingDomain() {
		// Create the editing domain with a special command stack
		// a "default" ResourceSet is created by this Editing domain, no need to
		// create a new one
		// Create the command stack that will notify this editor as commands are
		// executed.
		BasicCommandStack commandStack = new BasicCommandStack();
		editingDomain = new AdapterFactoryEditingDomain(this.adapterFactory, commandStack,
				new HashMap<Resource, Boolean>());

		transactionalEditingDomain = DiagramEditingDomainFactory.getInstance().createEditingDomain(
				editingDomain.getResourceSet());
		transactionalEditingDomain.setID("org.eclipse.uml2.diagram.clazz.EditingDomain"); //$NON-NLS-1$
		TransactionalEditingDomain.Registry.INSTANCE
				.add(transactionalEditingDomain.getID(), transactionalEditingDomain);
	}

	/**
	 * 
	 */
	public void loadModelResource(URI uri) {
		modelResource = getResourceSet().getResource(uri, true);
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
		URI uri = getPlatformURI(fullPath.addFileExtension(modelFileExtension));
		loadModelResource(uri);

		// TODO move next line away from DiResourceSet ? Define a place
		// where Resource initialization can take place.
		modelResource.eAdapters().add(new ModelListenerManager());

		// load DI2
		URI diUri = getPlatformURI(fullPath.addFileExtension(diFileExtension));
		diResource = getResourceSet().getResource(diUri, true);

		// load notation
		URI notationURI = getPlatformURI(fullPath.addFileExtension(notationFileExtension));
		notationResource = getResourceSet().getResource(notationURI, true);

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
		diResource = getResourceSet().createResource(diUri);

		IPath filenameWithoutExtension = newFile.getFullPath().removeFileExtension();
		// if the uml model is not loaded, create resource
		if (modelResource == null) {
			// create the model URI
			URI modelUri = getPlatformURI(filenameWithoutExtension.addFileExtension("uml"));
			// create the model resource
			modelResource = getResourceSet().createResource(modelUri, eContentType);
		}

		// create the notation URI
		URI notationURI = getPlatformURI(filenameWithoutExtension.addFileExtension(notationFileExtension));
		// create the notation resource
		notationResource = getResourceSet().createResource(notationURI);

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
	 * @throws IOException
	 */
	public void saveResources() throws IOException {
		// save associated resources
		modelResource.save(null);
		diResource.save(null);
		notationResource.save(null);
	}

	public void saveResources(IProgressMonitor monitor) throws IOException {
		monitor.beginTask("Saving resources", 3);
		// save associated resources
		modelResource.save(null);
		monitor.worked(1);
		diResource.save(null);
		monitor.worked(1);
		notationResource.save(null);
		monitor.worked(1);

		monitor.done();
	}

	/**
	 * The resources are already loaded, but we want to save them under another name.
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void saveAs(IPath path) throws IOException {
		IPath nameWithoutExt = path.removeFileExtension();
		IPath modelPath = nameWithoutExt.addFileExtension(modelFileExtension);
		IPath notationPath = nameWithoutExt.addFileExtension(notationFileExtension);
		IPath diPath = nameWithoutExt.addFileExtension(diFileExtension);

		// Set model URI
		URI modelUri = getPlatformURI(modelPath);
		modelResource.setURI(modelUri);

		// Set notation URI
		URI notationURI = getPlatformURI(notationPath);
		notationResource.setURI(notationURI);

		// set di uri
		URI diUri = getPlatformURI(diPath);
		diResource.setURI(diUri);

		saveResources();
	}

	/**
	 * Remove the diagram from the model.
	 * 
	 * @param diagram
	 */
	// @unused
	public void removeDiagram(Diagram diagram) {
		// Detach the diagram from its container
		// diagram.setContainer(null);
		// Remove from the resource.
		diResource.getContents().remove(diagram);
		// Something else to do ??
	}

	/**
	 * @return the adapterFactory
	 */
	// @unused
	public AdapterFactory getAdapterFactory() {
		return adapterFactory;
	}

	// @unused
	public AdapterFactoryEditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @return the notationResource
	 */
	public Resource getNotationResource() {
		return notationResource;
	}

	/**
	 * 
	 * 
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return editingDomain.getResourceSet();
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
	 * 
	 * 
	 * @return the modelResource
	 */
	public Resource getModelResource() {
		return modelResource;
	}

	/**
	 * @return the transactionalEditingDomain
	 */
	public TransactionalEditingDomain getTransactionalEditingDomain() {
		return transactionalEditingDomain;
	}

}
