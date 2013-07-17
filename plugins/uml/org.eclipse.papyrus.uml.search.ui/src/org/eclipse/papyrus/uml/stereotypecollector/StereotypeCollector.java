/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.stereotypecollector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.views.search.utils.ModelUtils;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeCollector implements IStereotypeCollector {

	private static StereotypeCollector instance = null;

	private StereotypeCollector() {
		super();
	}

	public final static StereotypeCollector getInstance() {

		if(StereotypeCollector.instance == null) {
			synchronized(StereotypeCollector.class) {
				if(StereotypeCollector.instance == null) {
					StereotypeCollector.instance = new StereotypeCollector();
				}
			}
		}
		return StereotypeCollector.instance;
	}


	public Collection<Stereotype> computeAvailableStereotypes(ISearchPageContainer container) {
		Set<Stereotype> preResult = new HashSet<Stereotype>();

		Set<Profile> profiles = new HashSet<Profile>();

		Set<IResource> umlResources = new HashSet<IResource>();

		if(container == null) {
			//Worksapce scope
			umlResources.addAll(createWorkspaceScope());

		} else {
			switch(container.getSelectedScope()) {
			case ISearchPageContainer.WORKSPACE_SCOPE:
			{
				umlResources.addAll(createWorkspaceScope());
				break;
			}
			case ISearchPageContainer.SELECTION_SCOPE:
			{
				ISelection selection = container.getSelection();

				if(!selection.isEmpty()) {
					if(selection instanceof IStructuredSelection) {
						umlResources.addAll(createSelectionScope((IStructuredSelection)selection));
					} else {
						//Do a workspace search instead
						umlResources.addAll(createWorkspaceScope());
					}
				} else {
					//Do a workspace search instead
					umlResources.addAll(createWorkspaceScope());
				}
				break;
			}
			case ISearchPageContainer.SELECTED_PROJECTS_SCOPE:
			{
				String[] projects = container.getSelectedProjectNames();
				umlResources.addAll(createProjectsScope(projects));
				break;
			}
			case ISearchPageContainer.WORKING_SET_SCOPE:
			{
				IWorkingSet[] workingSets = container.getSelectedWorkingSets();
				umlResources.addAll(createWorkingSetsScope(workingSets));
				break;
			}
			default:
			{
				break;
			}
			}
		}

		for(IResource umlRes : umlResources) {
			URI uri = URI.createPlatformResourceURI(umlRes.getFullPath().toString(), true);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);

			TreeIterator<EObject> UMLResourceContentIterator = resource.getAllContents();
			while(UMLResourceContentIterator.hasNext()) {
				EObject umlElement = (EObject)UMLResourceContentIterator.next();

				if(umlElement instanceof ProfileApplication) {
					profiles.add(((ProfileApplication)umlElement).getAppliedProfile());
				}

			}
		}

		for(Profile profile : profiles) {
			TreeIterator<EObject> profileContentIterator = profile.eAllContents();

			while(profileContentIterator.hasNext()) {
				EObject profileContent = (EObject)profileContentIterator.next();
				if(profileContent instanceof Stereotype) {
					preResult.add((Stereotype)profileContent);
				}
			}

		}

		Set<Stereotype> result = new HashSet<Stereotype>();
		for(Stereotype stereo : preResult) {
			result.add(stereo);
			for(Classifier parent : stereo.getGenerals()) {
				if(parent instanceof Stereotype) {
					result.add((Stereotype)parent);
				}
			}

		}

		return result;

	}

	/**
	 * Create a scope when the container is ISearchPageContainer.SELECTION_SCOPE
	 * 
	 * @param selection
	 *        the selection of the container
	 * @return
	 *         the scope
	 */
	protected List<IResource> createSelectionScope(IStructuredSelection selection) {
		List<IResource> results = new ArrayList<IResource>();

		Iterator it = selection.iterator();
		while(it.hasNext()) {
			Object object = (Object)it.next();

			if(object instanceof IPapyrusFile) {
				IResource[] associatedResources = ((IPapyrusFile)object).getAssociatedResources();
				for(IResource iResource : associatedResources) {
					results.addAll(findUMLModels(iResource));
				}

			} else if(object instanceof IResource) {
				results.addAll(findUMLModels((IResource)object));
			} else {

				Object element = BusinessModelResolver.getInstance().getBusinessModel(object);
				if(element instanceof EObject) {
					Resource eResource = ((EObject)element).eResource();
					IFile resource = ModelUtils.getIFile(eResource);
					if(resource != null) {
						results.add(resource);

					} else {
						//Do a workspace search instead
						results.addAll(createWorkspaceScope());
					}

				} else {
					//Do a workspace search instead
					results.addAll(createWorkspaceScope());
				}

			}
		}
		return results;
	}

	/**
	 * Create a scope when the container is ISearchPageContainer.SELECTED_PROJECTS_SCOPE
	 * 
	 * @param projects
	 *        the selected scope
	 * @return
	 *         the scope
	 */
	protected List<IResource> createProjectsScope(String[] projects) {
		List<IResource> results = new ArrayList<IResource>();

		for(String projectName : projects) {
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			if(project.isOpen()) {
				results.addAll(findUMLModels(project));
			}
		}
		return results;
	}

	/**
	 * Create a scope when the container is ISearchPageContainer.WORKING_SET_SCOPE
	 * 
	 * @param workingSets
	 *        the selected workingSets
	 * @return
	 *         the scope
	 */
	protected List<IResource> createWorkingSetsScope(IWorkingSet[] workingSets) {
		List<IResource> results = new ArrayList<IResource>();

		if(workingSets != null && workingSets.length > 0) {
			for(IWorkingSet iWorkingSet : workingSets) {
				for(IAdaptable element : iWorkingSet.getElements()) {
					Object resource = element.getAdapter(IResource.class);
					if(resource instanceof IResource) {
						results.addAll(findUMLModels((IResource)resource));
					}
				}
			}
		}

		return results;
	}

	/**
	 * Find all Papyrus models from a specific root
	 * 
	 * @param res
	 *        the root
	 * @return
	 *         the found Papyrus models
	 */
	protected Collection<IResource> findUMLModels(IResource res) {
		UMLResourceVisitor visitor = new UMLResourceVisitor();
		try {
			res.accept(visitor, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			org.eclipse.papyrus.uml.search.ui.Activator.log.warn(Messages.StereotypeCollector_0 + res);
		}

		return visitor.getParticipants();
	}

	/**
	 * Create a scope when the container is ISearchPageContainer.WORKSPACE_SCOPE
	 * 
	 * @return
	 *         the scope
	 */
	protected Collection<IResource> createWorkspaceScope() {

		//Go through the workspace root
		IResource root = ResourcesPlugin.getWorkspace().getRoot();

		return findUMLModels(root);
	}

}
