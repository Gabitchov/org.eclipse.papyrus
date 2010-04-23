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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.listenerservice.ModelListenerManager;

/**
 * ResourceSet Manager for UML and DI files, and also other loaded models.
 * 
 * @author Cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 */
public class DiResourceSet extends ResourceSetImpl {

	/** File extension used for DI. */
	public static final String DI_FILE_EXTENSION = "di"; //$NON-NLS-1$

	/** File extension used for notation. */
	public static final String NOTATION_FILE_EXTENSION = "notation"; //$NON-NLS-1$

	/** File extension used for Model */
	private String modelFileExtension; //$NON-NLS-1$

	/** The model resource */
	private Resource modelResource;

	/** The DI resource */
	private Resource diResource;

	/** The notation resource */
	private Resource notationResource;

	/** URI of the model resource */
	private URI modelURI;

	/** URI of the notation resource */
	private URI notationURI;

	/** URI of the di resource */
	private URI diURI;

	/** Set that enables to always load the uri with any strategy*/
	private Set<URI> uriLoading = new HashSet<URI>();

	/** The transactional editing domain. */
	private TransactionalEditingDomain transactionalEditingDomain;

	/** The proxy manager that loads the model according to a specific strategy. */
	private ProxyManager proxyManager;

	public DiResourceSet() {
		super();
		GMFResourceFactory gmfFactory = new GMFResourceFactory();
		getResourceFactoryRegistry().getExtensionToFactoryMap().put(NOTATION_FILE_EXTENSION, gmfFactory);
		proxyManager = new ProxyManager();
	}

	/**
	 * Just loads the model into the current resource set.
	 * 
	 * @returns The loaded model.
	 */
	public Resource loadModelResource(URI uri) {
		// FIXME maybe check that model is null ?!
		modelResource = getResource(uri, true);
		modelFileExtension = modelResource.getURI().fileExtension();
		return getModelResource();
	}

	/**
	 * Returns the extension of the model
	 */
	public String getModelFileExtension() {
		if(modelFileExtension == null) {
			modelFileExtension = modelResource.getURI().fileExtension();
		}
		return modelFileExtension;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EObject getEObject(URI uri, boolean loadOnDemand) {
		//return super.getEObject(uri, loadOnDemand);
		URI resourceURI = uri.trimFragment();
		// for performance reasons, we check the three initial resources first
		if(resourceURI.equals(modelURI) || resourceURI.equals(notationURI) || resourceURI.equals(diURI) || uriLoading.contains(resourceURI)) {
			// do not manage eObject of the initial resources
			return super.getEObject(uri, loadOnDemand);
		} else if(loadOnDemand) {
			return getEObjectFromStrategy(uri);
		} else {
			return null;
		}
	}

	// move it in ProxyManager ?
	private EObject getEObjectFromStrategy(URI uri) {
		// ask the strategy if the resource of the uri must be loaded
		boolean loadOnDemand = proxyManager.loadResource(uri);
		if(loadOnDemand) {
			Resource resource = getResource(uri, loadOnDemand);
			if(resource != null) {
				EObject object = resource.getEObject(uri.fragment());
				if(object != null) {
					// object find in the resource
					return object;
				}
				// explore routes in historic
				// RouteManager should be used for that
				else {
					String fileExtension = uri.fileExtension();
					Resource diResource = null;
					if(DI_FILE_EXTENSION.equals(fileExtension)) {
						// proxy is in DI resource
						diResource = getResource(uri, loadOnDemand);
					} else {
						// retrieve the DI resource from the uri to get the historic
						// TODO check if it needs to add the dot
						URI newURI = uri.trimFragment().trimFileExtension().appendFileExtension(DI_FILE_EXTENSION);
						diResource = getResource(newURI, loadOnDemand);
					}

					// get the historic from the Di resource
					if(diResource != null) {
						// TODO resource.getHistoric();	
						// call the RouteManager to get the EObject
						// TODO algo de parcours à définir: largeur ou profondeur
						// c'est le routeurManager qui trouve l'object
						// return RouteManager.getEObject(uri, context);
						return null;

					} else {
						// resource di not found -> Error managed in proxyManager
						// warn the user, ask him to select the resource
						// return Popup.getChoice();
						return null;
					}
				}
			} else {
				// resource not found -> Error managed in proxyManager
				// warn the user, ask him to select a resource to search in
				// or ask to seach in the entire resource set
				// or use a proxy
				// return Popup.getChoice();
				// strategy used for the specified resource only 
				return null;
			}
		} else {
			// we just want to manage a proxy for this object
			return null;
		}
	}

	public void loadResources(URI pDiUri, URI pNotationURI, URI pModelResourceURi, IFile file) {
		diURI = pDiUri;
		notationURI = pNotationURI;
		diResource = getResource(diURI, true);
		notationResource = getResource(notationURI, true);
		if(notationResource != null) {
			// look for a model associated with a diagram in notation
			for(EObject eObject : notationResource.getContents()) {
				if(eObject instanceof Diagram) {
					Diagram diagram = (Diagram)eObject;
					if(diagram.getElement() != null) {
						modelResource = diagram.getElement().eResource();
						break;
					}
				}
			}
		}
		// if modelResource is still null, we look for a file with the same name and a supported extension
		if(pModelResourceURi != null) {
			modelResource = getResource(pModelResourceURi, true);
			modelURI = pModelResourceURi;
		}
		if(modelResource == null && file != null) {
			IContainer folder = file.getParent();
			try {
				IResource[] files = folder.members();
				for(IResource r : files) {
					String extension = r.getFullPath().getFileExtension();
					if(r.getFullPath().removeFileExtension().lastSegment().equals(file.getFullPath().removeFileExtension().lastSegment()) && !DI_FILE_EXTENSION.equalsIgnoreCase(extension) && !NOTATION_FILE_EXTENSION.equalsIgnoreCase(extension)) {
						if(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(extension) != null) {
							modelURI = getPlatformURI(r.getFullPath());
							modelResource = getResource(modelURI, true);
							break;
						}
					}
				}
			} catch (CoreException e) {
				// never happens.
			}
		}
		modelFileExtension = modelResource.getURI().fileExtension();
		// TODO move next line away from DiResourceSet ? Define a place
		// where Resource initialization can take place.
		modelResource.eAdapters().add(new ModelListenerManager());
	}

	/**
	 * Load both files (DI and UML) from an handle on one of the two files.
	 * 
	 * @param file
	 *        The file to load (no matter the extension)
	 */
	public void loadResources(IFile file) {
		// Extract file name, without extension
		IPath fullPath = file.getFullPath().removeFileExtension();

		// load DI2
		URI diUri = getPlatformURI(fullPath.addFileExtension(DI_FILE_EXTENSION));

		// load notation
		URI notation = getPlatformURI(fullPath.addFileExtension(NOTATION_FILE_EXTENSION));
		loadResources(diUri, notation, null, file);

	}

	/**
	 * Unload all the resources.
	 */
	public void unload() {
		for(Iterator<Resource> iter = getResources().iterator(); iter.hasNext();) {
			iter.next().unload();
			iter.remove();
		}
		diResource = null;
		modelResource = null;
		notationResource = null;
	}

	/**
	 * Create both files (DI and UML) from a filename.
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new files
	 */
	public void createModelResources(IFile newFile, String eContentType, String modelExtension) {

		// create the di resource URI
		URI diUri = getPlatformURI(newFile.getFullPath());
		// Create the di Resource for the sashcontainer
		// The model will be automatically initialized by the SashContainer if needed (if it is empty).
		// Normally the resource should contains models set by previous use from the SashContainer
		diResource = createResource(diUri);

		IPath filenameWithoutExtension = newFile.getFullPath().removeFileExtension();
		// if the model is not loaded, create resource
		if(modelResource == null) {
			// create the model URI
			URI modelUri = getPlatformURI(filenameWithoutExtension.addFileExtension(modelExtension));
			// create the model resource
			modelResource = createResource(modelUri, eContentType);
			this.modelFileExtension = modelExtension;
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
	 *        the path
	 * @return the uri
	 */
	private URI getPlatformURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	/**
	 * Save the resources.
	 * 
	 * @param monitor
	 *        The monitor.
	 * @throws IOException
	 *         IO Error.
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
		IPath modelPath = nameWithoutExt.addFileExtension(getModelFileExtension());
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
		for(Resource resource : getResources()) {
			// ignore di, notation and domain resources
			if(resource != diResource && resource != notationResource && resource != modelResource) {
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
		if(transactionalEditingDomain == null) {
			transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(this);
			// What for?
			transactionalEditingDomain.setID("SharedEditingDomain"); //$NON-NLS-1$
		}
		return transactionalEditingDomain;
	}

	/**
	 * Returns the related di file.
	 * 
	 * @param file
	 *        A file (di, model or notation).
	 * @return The associated DI file.
	 */
	public static IFile getRelatedDiFile(IFile file) {
		if(file == null) {
			return null;
		}
		IFile diFile;
		if(DI_FILE_EXTENSION.equalsIgnoreCase(file.getFileExtension())) {
			diFile = file;
		} else {
			// Find the correct file
			IPath diPath = file.getFullPath().removeFileExtension().addFileExtension(DiResourceSet.DI_FILE_EXTENSION);
			diFile = file.getParent().getFile(diPath.makeRelativeTo(file.getParent().getFullPath()));
		}
		return diFile;
	}
	
	/**
	 * Enables to add an URI that will be always loaded.
	 * It is not listening at the current loading strategy and always load the specified URI if needed. 
	 *
	 * @param the uri always loaded
	 */
	public void forceUriLoading(URI alwaysLoadedUri) {
		uriLoading.add(alwaysLoadedUri);
	}

}
