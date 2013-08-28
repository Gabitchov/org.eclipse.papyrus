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
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.stereotypecollector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.search.ui.ISearchPageContainer;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;

public class StereotypeCollector implements IStereotypeCollector {

	private static final StereotypeCollector instance = new StereotypeCollector();

	private StereotypeCollector() {
		super();
	}

	public final static StereotypeCollector getInstance() {
		return StereotypeCollector.instance;
	}


	public Collection<Stereotype> computeAvailableStereotypes(ISearchPageContainer container) {
		Set<Stereotype> preResult = new HashSet<Stereotype>();

		Set<Profile> profiles = new HashSet<Profile>();

		Set<URI> umlResources = new HashSet<URI>();

		if(container == null) {
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

		for(URI uri : umlResources) {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);

			TreeIterator<EObject> UMLResourceContentIterator = resource.getAllContents();
			while(UMLResourceContentIterator.hasNext()) {
				EObject umlElement = (EObject)UMLResourceContentIterator.next();

				if(umlElement instanceof ProfileApplication) {
					boolean found = false;
					Profile profileToProcess = ((ProfileApplication)umlElement).getAppliedProfile();
					for(Profile alreadyAddedProfile : profiles) {

						if(EcoreUtil.equals(alreadyAddedProfile, profileToProcess)) {
							found = true;
						}
					}
					if(!found) {
						profiles.add(profileToProcess);
					}
				}

			}
		}

		for(Profile profile : profiles) {
			TreeIterator<EObject> profileContentIterator = profile.eAllContents();

			while(profileContentIterator.hasNext()) {
				EObject profileContent = (EObject)profileContentIterator.next();
				if(profileContent instanceof Stereotype) {
					boolean found = false;
					Stereotype stereotypeToProcess = (Stereotype)profileContent;
					for(Stereotype alreadyAddedStereotype : preResult) {

						if(EcoreUtil.equals(alreadyAddedStereotype, stereotypeToProcess)) {
							found = true;
						}
					}

					if(!found) {
						preResult.add(stereotypeToProcess);
					}
				}
			}

		}

		Set<Stereotype> result = new HashSet<Stereotype>();
		for(Stereotype stereo : preResult) {
			result.add(stereo);
			for(Classifier parent : stereo.getGenerals()) {
				if(parent instanceof Stereotype) {
					result.add((Stereotype)parent);

					boolean found = false;
					Stereotype stereotypeToProcess = (Stereotype)parent;
					for(Stereotype alreadyAddedStereotype : result) {

						if(EcoreUtil.equals(alreadyAddedStereotype, stereotypeToProcess)) {
							found = true;
						}
					}

					if(!found) {
						result.add(stereotypeToProcess);
					}

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
	protected List<URI> createSelectionScope(IStructuredSelection selection) {
		List<URI> results = new ArrayList<URI>();

		Iterator<?> it = selection.iterator();
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
					// CDO resource *are* EObjects
					Resource eResource = (element instanceof Resource) ? (Resource) element : ((EObject)element).eResource();
					if(eResource != null) {
						results.add(eResource.getURI());

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
	protected List<URI> createProjectsScope(String[] projects) {
		List<URI> results = new ArrayList<URI>();

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
	protected List<URI> createWorkingSetsScope(IWorkingSet[] workingSets) {
		List<URI> results = new ArrayList<URI>();

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
	protected Collection<URI> findUMLModels(IResource res) {
		UMLResourceVisitor visitor = new UMLResourceVisitor();
		try {
			res.accept(visitor, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			org.eclipse.papyrus.uml.search.ui.Activator.log.warn(Messages.StereotypeCollector_0 + res);
		}

		return visitor.getParticipantURIs();
	}

	/**
	 * Create a scope when the container is ISearchPageContainer.WORKSPACE_SCOPE
	 * 
	 * @return
	 *         the scope
	 */
	protected Collection<URI> createWorkspaceScope() {

		//Go through the workspace root
		IResource root = ResourcesPlugin.getWorkspace().getRoot();

		return findUMLModels(root);
	}

}
