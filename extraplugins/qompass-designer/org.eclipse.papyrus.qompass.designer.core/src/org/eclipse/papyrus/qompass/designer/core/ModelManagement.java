package org.eclipse.papyrus.qompass.designer.core;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;


public class ModelManagement {

	/**
	 * Create a resource for the model passed as parameter
	 * 
	 * @param newModel
	 */
	public ModelManagement() {
		getResourceSet();
		model = UMLFactory.eINSTANCE.createModel();
		resource = resourceSet.createResource(URI.createURI("temp.uml"));
		resource.getContents().add(model);
	}

	/**
	 * Save a model within the given project
	 * 
	 * @param model
	 *        a model that should be saved
	 * @param project
	 *        an existing project
	 */
	public void saveModel(IProject project) {
		saveModel(getPath(project, null, null));
	}

	public void dispose() {
		if(model != null) {
			model.destroy();
			model = null;
		}
		resourceSet.getResources().remove(resource);
	}

	public Model getModel() {
		return model;
	}

	/**
	 * Save a model within a passed project and a specified folder
	 * (TODO: use path instead a single folder?)
	 * 
	 */
	public void saveModel(String path) {

		try {
			URI uri = URI.createURI(path);

			ResourceSetImpl resourceSet = new ResourceSetImpl();
			resourceSet.getPackageRegistry().put(UMLPackage.eNS_URI, UMLPackage.eINSTANCE);

			/*
			 * Resource resource = resourceSet.createResource(uri);
			 * EList<EObject> contents = resource.getContents();
			 * contents.add(model);
			 */
			resource.setURI(uri);
			EList<EObject> contents = resource.getContents();

			for(Iterator<EObject> allContents = UMLUtil.getAllContents(model, true, false); allContents.hasNext();) {
				EObject eObject = allContents.next();

				if(eObject instanceof Element) {
					contents.addAll(((Element)eObject).getStereotypeApplications());
				}
			}
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param project
	 *        an existing project
	 * @param subFolder
	 *        a subfolder within the project (will be created, if it does not exist)
	 * @param filename
	 *        the name of the file or null (in his case, the name of the
	 *        model with the postfix .uml is used)
	 * 
	 * @return The access path to a file
	 */
	public String getPath(IProject project, String subFolder, String filename) {
		IFile file;
		if(filename == null) {
			filename = model.getName() + ".uml";
		}
		if(subFolder != null) {
			IFolder ifolder = project.getFolder(subFolder);
			if(!ifolder.exists()) {
				try {
					ifolder.create(false, true, null);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			file = ifolder.getFile(filename);
		} else {
			file = project.getFile(filename);
		}
		return file.getFullPath().toString();
	}

	/**
	 * return the used resource set (a singleton)
	 */
	public static ResourceSet getResourceSet() {
		if(resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	private static ResourceSet resourceSet = null;

	private Model model;

	private Resource resource;
}
