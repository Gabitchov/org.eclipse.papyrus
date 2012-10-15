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
package org.eclipse.papyrus.infra.core.utils;

import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.ModelsReader;

/**
 * ResourceSet Manager for UML and DI files, and also other loaded models.
 * 
 * @author Cedric dumoulin
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 * 
 * @deprecated Use ModelSet instead.
 */
@Deprecated
public class DiResourceSet extends ModelSet {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DiResourceSet() {
		super();
		// Register declared models
		ModelsReader reader = new ModelsReader();
		reader.readModel(this);
	}

	/**
	 * Just loads the model into the current resource set.
	 * 
	 * @returns The loaded model or null if the model is not loaded.
	 * @deprecated load requested model and get its resource. See implementation
	 *             for example.
	 */
	//	@Deprecated
	//	public Resource loadModelResource(IFile file) {
	//
	//		UmlModel model = null;
	//		try {
	//			model = (UmlModel)loadModel(UmlModel.MODEL_ID, file);
	//		} catch (ModelException e) {
	//			return null;
	//		}
	//		return model.getResource();
	//	}

	/**
	 * Returns the extension of the model. Seem to be unused.
	 * 
	 * @deprecated Use {@link UmlModel#UML_FILE_EXTENSION}
	 */
	//	@Deprecated
	//	public String getModelFileExtension() {
	//		throw new UnsupportedOperationException("deprecated method.");
	//		// if(modelFileExtension == null) {
	//		// modelFileExtension = modelResource.getURI().fileExtension();
	//		// }
	//		// return modelFileExtension;
	//	}

	/**
	 * Load both files (DI and UML) from an handle on one of the two files.
	 * 
	 * @param file
	 *        The file to load (no matter the extension)Model
	 * @deprecated use {@link ModelSet#loadModels(IFile)} instead.
	 */
	//	@Deprecated
	//	public void loadResources(IFile file) {
	//		try {
	//			loadModels(file);
	//		} catch (ModelMultiException e) {
	//			e.printStackTrace();
	//		}
	//
	//		// // Extract file name, without extension
	//		// IPath fullPath = file.getFullPath().removeFileExtension();
	//		//
	//		// // load DI2
	//		// URI diUri =
	//		// getPlatformURI(fullPath.addFileExtension(DI_FILE_EXTENSION));
	//		// diResource = getResource(diUri, true);
	//		//
	//		// // load notation
	//		// URI notationURI =
	//		// getPlatformURI(fullPath.addFileExtension(NOTATION_FILE_EXTENSION));
	//		// notationResource = getResource(notationURI, true);
	//		//
	//		// if(notationResource != null) {
	//		// // look for a model associated with a diagram in notation
	//		// for(EObject eObject : notationResource.getContents()) {
	//		// if(eObject instanceof Diagram) {
	//		// Diagram diagram = (Diagram)eObject;
	//		// if(diagram.getElement() != null) {
	//		// modelResource = diagram.getElement().eResource();
	//		// break;
	//		// }
	//		// }
	//		// }
	//		// }
	//		//
	//		//
	//		// // if modelResource is still null, we look for a file with the same
	//		// name and a supported extension
	//		// if(modelResource == null) {
	//		// IContainer folder = file.getParent();
	//		// try {
	//		// IResource[] files = folder.members();
	//		// for(IResource r : files) {
	//		// String extension = r.getFullPath().getFileExtension();
	//		// if(r.getFullPath().removeFileExtension().lastSegment().equals(fullPath.lastSegment())
	//		// && !DI_FILE_EXTENSION.equalsIgnoreCase(extension) &&
	//		// !NOTATION_FILE_EXTENSION.equalsIgnoreCase(extension)) {
	//		// if(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().get(extension)
	//		// != null) {
	//		// modelResource = getResource(getPlatformURI(r.getFullPath()), true);
	//		// break;
	//		// }
	//		// }
	//		// }
	//		// } catch (CoreException e) {
	//		// // never happens.
	//		// }
	//		// }
	//		//
	//		// modelFileExtension = modelResource.getURI().fileExtension();
	//		//
	//		// // TODO move next line away from DiResourceSet ? Define a place
	//		// // where Resource initialization can take place.
	//		// // move this line to centralize all the adapters
	//		// modelResource.eAdapters().add(new ModelListenerManager());
	//	}

	/**
	 * Create both files (DI and UML) from a filename.
	 * 
	 * @param newFile
	 *        The file from which path is extracted to create the new files
	 * 
	 * @deprecated Use {@link ModelSet#createsModels(IFile)} instead.
	 */
	//	@Deprecated
	//	public void createModelResources(IFile newFile, String eContentType, String modelExtension) {
	//
	//		// Check if parameters are those expected.
	//		// If not, throws an exception to inform the programmer.
	//		if(!("org.eclipse.uml2.uml".equals(eContentType) && "uml".equals(modelExtension))) {
	//			throw new UnsupportedOperationException("");
	//		}
	//		// Create models
	//		createsModels(newFile);
	//
	//		// // create the di resource URI
	//		// URI diUri = getPlatformURI(newFile.getFullPath());
	//		// // Create the di Resource for the sashcontainer
	//		// // The model will be automatically initialized by the SashContainer
	//		// if needed (if it is empty).
	//		// // Normally the resource should contains models set by previous use
	//		// from the SashContainer
	//		// diResource = createResource(diUri);
	//		//
	//		// IPath filenameWithoutExtension =
	//		// newFile.getFullPath().removeFileExtension();
	//		// // if the model is not loaded, create resource
	//		// if(modelResource == null) {
	//		// // create the model URI
	//		// URI modelUri =
	//		// getPlatformURI(filenameWithoutExtension.addFileExtension(modelExtension));
	//		// // create the model resource
	//		// modelResource = createResource(modelUri, eContentType);
	//		// this.modelFileExtension = modelExtension;
	//		// }
	//		// // create the notation URI
	//		// URI notationURI =
	//		// getPlatformURI(filenameWithoutExtension.addFileExtension(NOTATION_FILE_EXTENSION));
	//		// // create the notation resource
	//		// notationResource = createResource(notationURI);
	//
	//	}

	/**
	 * Get a platform resource URI of the given path
	 * 
	 * @param path
	 *        the path
	 * @return the uri
	 */
	//	private URI getPlatformURI(IPath path) {
	//		return URI.createPlatformResourceURI(path.toString(), true);
	//	}

	/**
	 * Returns the notation resource.
	 * 
	 * @return the notationResource
	 * @deprecated Use NotationUtils.getNotationModel(this).getResource();
	 *             instead.
	 */
	//	public Resource getNotationResource() {
	//		return NotationUtils.getNotationModel(this).getResource();
	//	}

	/**
	 * 
	 * 
	 * @return the diResource
	 * @deprecated Use NotationUtils.getSashModel(this).getResource(); instead.
	 */
	//	@Deprecated
	//	public Resource getDiResource() {
	//		return SashModelUtils.getSashModel(this).getResource();
	//	}

	/**
	 * Retrieve the di resource associated with a given model element.
	 * 
	 * @param modelElement
	 * @return the di resource or null
	 * @deprecated a model should be modified/created to correctly handle
	 *             controlled resources
	 */
	//	@Deprecated
	//	public Resource getAssociatedDiResource(EObject modelElement) {
	//		// return the "base" di since we want the opened tabs in a unique di
	//		return getDiResource();
	//	}

	/**
	 * Retrieve the notation resource associated with a given model element.
	 * 
	 * @param modelElement
	 * @return the notation resource or null
	 * @deprecated a model should be modified/created to correctly handle
	 *             controlled resources
	 */
	//	@Deprecated
	//	public Resource getAssociatedNotationResource(EObject modelElement) {
	//		if(modelElement != null) {
	//			Resource modelResource = modelElement.eResource();
	//			if(modelResource != null && !modelResource.equals(getModelResource())) {
	//				// handle controlled resource
	//				return getAssociatedResource(modelResource, NotationModel.NOTATION_FILE_EXTENSION);
	//			}
	//		}
	//		return getNotationResource();
	//	}

	/**
	 * Retrieve the model resource associated with a given model element. Please
	 * refers to {@link ResourceSet#getResource(URI, boolean)} for the meaning
	 * of loadOnDemand.
	 * 
	 * @param modelElement
	 * @return the model resource or null
	 * @deprecated a model should be modified/created to correctly handle
	 *             controlled resources
	 */
	//	@Deprecated
	//	public Resource getAssociatedModelResource(EObject modelElement) {
	//		if(modelElement != null && modelElement.eResource() != null) {
	//			return modelElement.eResource();
	//		}
	//		return getModelResource();
	//	}

	/**
	 * Returns the model resource.
	 * 
	 * @return the modelResource
	 * @deprecated Use NotationUtils.getUmlModel(this).getResource(); instead.
	 */
	//	@Deprecated
	//	public Resource getModelResource() {
	//		return UmlUtils.getUmlModel(this).getResource();
	//	}

	/**
	 * Returns the additional resources.
	 * 
	 * @return The additional resources.
	 */
	//	public List<Resource> getAdditionalResources() {
	//		List<Resource> additionnalResources = new ArrayList<Resource>();
	//		for(Resource resource : getResources()) {
	//			// ignore di, notation and domain resources
	//
	//			if(resource != getDiResource() && resource != getNotationResource() && resource != getModelResource()) {
	//				additionnalResources.add(resource);
	//			}
	//		}
	//
	//		return additionnalResources;
	//	}

	/**
	 * Returns the related di file.
	 * 
	 * @param file
	 *        A file (di, model or notation).
	 * @return The associated DI file.
	 * @deprecated use {@link DiModelUtils#getRelatedDiFile(IFile)}
	 */
	//	@Deprecated
	//	public static IFile getRelatedDiFile(IFile file) {
	//		return DiModelUtils.getRelatedDiFile(file);
	//	}

}
