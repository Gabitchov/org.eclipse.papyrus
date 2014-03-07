/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.advice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.commands.IPapyrusDuplicateCommandConstants;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResource;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;


/**
 * Edit Helper advice to add GMF diagram duplication when duplicating
 */
public class GMFDiagramDuplicateEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeDuplicateCommand(DuplicateElementsRequest request) {
		Object additional = request.getParameter(IPapyrusDuplicateCommandConstants.ADDITIONAL_DUPLICATED_ELEMENTS);
		// additional element should be a set of elements that will be duplicated. If this is null, the request will be ignored.
		if(!(additional instanceof Set<?>)) {
			return super.getBeforeDuplicateCommand(request);
		}

		Set<Object> duplicatedObjects = ((Set<Object>)additional);
		EObject object = getDuplicatedEObject(request);
		if(object == null || object.eResource() == null) {
			return super.getBeforeDuplicateCommand(request);
		}

		// retrieve the diagrams linked to the object
		List<Diagram> diagramsToDuplicate = new ArrayList<Diagram>();

		ResourceSet resourceSet = object.eResource().getResourceSet();
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if(adapter == null) {
			adapter = new ECrossReferenceAdapter();
			resourceSet.eAdapters().add(adapter);
		}

		// do not proceed for graphical elements, which will have evident relationships to diagrams (owner, etc.)
		if(object instanceof View) {
			return super.getBeforeDuplicateCommand(request);
		}

		// check for the element itself
		Collection<Setting> settings = adapter.getInverseReferences(object, false);
		for(Setting setting : settings) {
			EObject value = setting.getEObject();
			if(value instanceof Diagram) {
				diagramsToDuplicate.add((Diagram)value);
			}
		}

		// check for sub-elements
		for(Iterator<EObject> it = object.eAllContents(); it.hasNext();) {
			EObject child = it.next();
			settings = adapter.getInverseReferences(child, false);

			for(Setting setting : settings) {
				EObject value = setting.getEObject();
				if(value instanceof Diagram) {
					diagramsToDuplicate.add((Diagram)value);
				}
			}
		}


		if(!diagramsToDuplicate.isEmpty()) {
			CompositeCommand command = null;
			// create the command for all the diagrams that have no command ready
			for(Diagram diagramToDuplicate : diagramsToDuplicate) {
				if(!duplicatedObjects.contains(diagramToDuplicate)) {
					if(command == null) {
						command = new CompositeCommand("", Arrays.asList(new DuplicateDiagramCommand(request.getEditingDomain(), "Duplicate Diagram", diagramToDuplicate, request.getAllDuplicatedElementsMap())));
					} else {
						command.add(new DuplicateDiagramCommand(request.getEditingDomain(), "Duplicate Diagram", diagramToDuplicate, request.getAllDuplicatedElementsMap()));
					}
					duplicatedObjects.add(diagramToDuplicate);
				}
			}

			if(command != null) {
				if(super.getBeforeDuplicateCommand(request) != null) {
					command.add(super.getBeforeDuplicateCommand(request));
					return command.reduce();
				} else {
					return command.reduce();

				}
			}
		}

		return super.getBeforeDuplicateCommand(request);
	}

	/**
	 * Returns the EObject to be duplicated
	 *
	 * @return the EObject to be duplicated
	 */
	protected EObject getDuplicatedEObject(DuplicateElementsRequest request) {
		List<Object> elementsToBeDuplicated = request.getElementsToBeDuplicated();
		if(elementsToBeDuplicated == null || elementsToBeDuplicated.isEmpty()) {
			return null;
		}
		Object elementToBeDuplicated = elementsToBeDuplicated.get(0);
		if(elementToBeDuplicated instanceof EObject) {
			return ((EObject)elementToBeDuplicated);
		}
		return null;
	}

	/**
	 * Command to duplicate diagrams. This adds the diagram to the resource containing the source diagram.
	 */
	public class DuplicateDiagramCommand extends DuplicateEObjectsCommand {

		/** diagram to be duplicated */
		private final Diagram diagramToDuplicate;

		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects.
		 *
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param diagram
		 *        <code>Diagram</code> to be duplicated.
		 */
		public DuplicateDiagramCommand(TransactionalEditingDomain editingDomain, String label, Diagram diagram) {
			super(editingDomain, label, Collections.singletonList(diagram));
			this.diagramToDuplicate = diagram;
		}

		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects.
		 *
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param diagram
		 *        <code>Diagram</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 */
		public DuplicateDiagramCommand(TransactionalEditingDomain editingDomain, String label, Diagram diagram, Map allDuplicatedObjectsMap) {
			super(editingDomain, label, Collections.singletonList(diagram), allDuplicatedObjectsMap);
			this.diagramToDuplicate = diagram;
		}

		/**
		 * Constructs a new duplicate EObjects command with the specified label and
		 * list of EObjects. Also sets the list of affected files to be the files,
		 * where the targetContainer is stored. Target container specifies the
		 * eObject into which the duplicated eObjects will be added.
		 *
		 * @param editingDomain
		 *        the editing domain through which model changes are made
		 * @param label
		 *        The label for the new command.
		 * @param diagram
		 *        <code>Diagram</code> to be duplicated.
		 * @param allDuplicatedObjectsMap
		 *        An empty map to be populated with the duplicated objects.
		 */
		public DuplicateDiagramCommand(TransactionalEditingDomain editingDomain, String label, Diagram diagram, Map allDuplicatedObjectsMap, EObject targetContainer) {
			super(editingDomain, label, Collections.singletonList(diagram), allDuplicatedObjectsMap, targetContainer);
			this.diagramToDuplicate = diagram;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
			// Remove elements whose container is getting copied.
			// ClipboardSupportUtil.getCopyElements(getObjectsToBeDuplicated());

			// Perform the copy and update the references.
			EcoreUtil.Copier copier = new DiagramCopier(getAllDuplicatedObjectsMap());
			copier.copy(diagramToDuplicate);
			copier.copyReferences();

			EObject duplicateDiagram = copier.get(diagramToDuplicate);
			Resource targetResource = getNotationResourceForDiagram(((Diagram)duplicateDiagram).getElement(), getEditingDomain());
			Resource diTargetResource = getDiResourceForDiagram(((Diagram)duplicateDiagram).getElement(), getEditingDomain());

			if(targetResource != null) {
				targetResource.getContents().add(duplicateDiagram);

				if(diTargetResource != null) {
					try {
						IPageManager pageManager = ServiceUtilsForResource.getInstance().getIPageManager(diTargetResource);
						pageManager.addPage(duplicateDiagram);
					} catch (ServiceException e) {
						Activator.log.error(e);
					}
				} else {
					Activator.log.error("It was not possible to find the di resource where to add the diagram page", null);
				}
			} else {
				Activator.log.warn("It was not possible to find the Resource with the target EObject");
				targetResource = diagramToDuplicate.eResource();
				if(targetResource != null) {
					Activator.log.error("It was not possible to find the Resource with the source diagram", null);
					targetResource.getContents().add(duplicateDiagram);
					if(diTargetResource != null) {
						try {
							IPageManager pageManager = ServiceUtilsForResource.getInstance().getIPageManager(diTargetResource);
							pageManager.addPage(duplicateDiagram);
						} catch (ServiceException e) {
							Activator.log.error(e);
						}
					} else {
						Activator.log.error("It was not possible to find the di resource where to add the diagram page", null);
					}
				}
			}
			return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
		}

		@Override
		public boolean canExecute() {
			// should add some tests here? no need to test containement feature like previous, Diagram has no owner...
			return true;
		}
	}

	/**
	 * Returns the notation resource where to add the new diagram
	 *
	 * @param eObject
	 *        the semantic object linked to the diagram or the diagram itself.
	 * @param domain
	 *        the editing domain
	 * @return the resource where the diagram should be added or <code>null</code> if no resource was found
	 *         TODO this method should be handled by the resource plugin.
	 */
	public Resource getNotationResourceForDiagram(EObject eObject, TransactionalEditingDomain domain) {
		Object object = BusinessModelResolver.getInstance().getBusinessModel(eObject);
		EObject semanticObject;
		if(!(object instanceof EObject)) {
			semanticObject = eObject;
		} else {
			semanticObject = (EObject)object;
		}

		Resource containerResource = semanticObject.eResource();
		if(containerResource == null) {
			return null;
		}
		// retrieve the model set from the container resource
		ResourceSet resourceSet = containerResource.getResourceSet();

		if(resourceSet instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)resourceSet;
			Resource destinationResource = modelSet.getAssociatedResource(semanticObject, NotationModel.NOTATION_FILE_EXTENSION, true);
			return destinationResource;
		} else {
			throw new RuntimeException("Resource Set is not a ModelSet or is null");
		}
	}


	/**
	 * Returns the di resource where to add the new diagram
	 *
	 * @param eObject
	 *        the semantic object linked to the diagram or the diagram itself.
	 * @param domain
	 *        the editing domain
	 * @return the resource where the diagram should be added or <code>null</code> if no resource was found
	 */
	public Resource getDiResourceForDiagram(EObject eObject, TransactionalEditingDomain domain) {
		Object object = BusinessModelResolver.getInstance().getBusinessModel(eObject);
		EObject semanticObject;
		if(!(object instanceof EObject)) {
			semanticObject = eObject;
		} else {
			semanticObject = (EObject)object;
		}

		Resource containerResource = semanticObject.eResource();
		if(containerResource == null) {
			return null;
		}
		// retrieve the model set from the container resource
		ResourceSet resourceSet = containerResource.getResourceSet();

		if(resourceSet instanceof ModelSet) {
			ModelSet modelSet = (ModelSet)resourceSet;
			Resource destinationResource = modelSet.getAssociatedResource(semanticObject, SashModel.MODEL_FILE_EXTENSION, true);
			return destinationResource;
		} else {
			throw new RuntimeException("Resource Set is not a ModelSet or is null");
		}
	}

	/**
	 * Copier for diagrams, where only views and internal references are duplicated, not the semantic elements themselves.
	 */
	protected class DiagramCopier extends EcoreUtil.Copier {

		/** Serial UUID */
		private static final long serialVersionUID = 8544123249170461708L;

		/** semantic objects referenced by the views in the diagram */
		private Map<EObject, EObject> semanticObjects;

		/**
		 * Creates a new {@link DiagramCopier}
		 *
		 * @param semanticObjects
		 *        list of semantic objects already copied, to which new views should be related.
		 */
		public DiagramCopier(Map<EObject, EObject> semanticObjects) {
			this.semanticObjects = semanticObjects;
		}

		/**
		 * Overrides the get to look in the map of duplicated semantic objects in case the element was not found in this map
		 *
		 * {@inheritDoc}
		 */
		@Override
		public EObject get(Object arg0) {
			EObject object = super.get(arg0);
			if(object == null) {
				object = semanticObjects.get(arg0);
			}
			return object;
		}
	}
}
