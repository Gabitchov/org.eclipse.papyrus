/*****************************************************************************
 * Copyright (c) 2012 Atos .
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Arthur daussy - arthur.daussy@atos.net - 374607: [model explorer] moving a model element in another model does not move associated diagrams
 *
 **/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.adaptor.gmf.MoveOpenableCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.diagram.common.commands.MoveStereotypeApplicationsCommand;
import org.eclipse.papyrus.resource.notation.NotationUtils;
import org.eclipse.papyrus.uml.service.types.Activator;
import org.eclipse.uml2.uml.Element;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
/**
 * The edit helper advice for all uml element
 * @author adaussy
 *
 */
public class ElementEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * This case will handle moving an element from a resource to another (use case : control mode).
	 * This will move into the new resource :
	 *  -> The stereotypes linked to this element and its descendant
	 *  -> The diagrams linked to this element and its descendant
	 */
	@Override
	protected ICommand getAfterMoveCommand(MoveRequest request) {
		Map<?, ?> elementsToMove = request.getElementsToMove();
		EObject container = request.getTargetContainer();
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(getEditingDomain(container), "Move related elements to new resource");////$NON-NLS-1$

		for(Object o : elementsToMove.keySet()) {
			EObject sourceEObject = null;
			if(o instanceof EObject) {
				sourceEObject = (EObject)o;
			} else if(o instanceof IAdaptable) {
				sourceEObject = (EObject)((IAdaptable)o).getAdapter(EObject.class);
			}

			if(sourceEObject != null && container != null && sourceEObject.eResource() != null && container.eResource() != null) {
				final Resource eResource = sourceEObject.eResource();
				Resource containerEResource = container.eResource();
				/*
				 * Test if the moving element is going to be in a new resource
				 */
				if(!eResource.equals(containerEResource) && !AdapterFactoryEditingDomain.isControlled(sourceEObject)) {
					/*
					 * Move related diagrams
					 */
					ICommand moveDiagramsCommand = getMoveDiagramsCommand(container, sourceEObject);
					if(moveDiagramsCommand != null && moveDiagramsCommand.canExecute()) {
						cc.compose(moveDiagramsCommand);
					}
					/*
					 * Move related stereotypes
					 */
					addAllMoveStereotypeCommand(cc, sourceEObject, container);
				}
			}
		}

		if (!cc.isEmpty()) {
			return cc;
		}

		return null;
	}

	protected void addAllMoveStereotypeCommand(CompositeTransactionalCommand cc, final EObject sourceEObject, EObject container) {
		/*
		 * Iterator of all descendant contained in the same resource as the source
		 */
		UnmodifiableIterator<EObject> descendantElementIterator = Iterators.filter(sourceEObject.eAllContents(), new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return input.eResource() != null && input.eResource().equals(sourceEObject.eResource());
			}
		});
		/*
		 * Iterator of the source element
		 */
		UnmodifiableIterator<EObject> elementIterator = Iterators.singletonIterator(sourceEObject);
		/*
		 * unifiedIterator = (elementIterator) U (descendantElementIterator)
		 */
		Iterator<EObject> unifiedIterator = Iterators.concat(elementIterator, descendantElementIterator);
		while (unifiedIterator.hasNext()){
			/*
			 * Move related diagrams
			 */
			EObject next = unifiedIterator.next();
			ICommand modeStereotypeCommand = getMoveStereotypeCommand(container, next);
			if(modeStereotypeCommand != null && modeStereotypeCommand.canExecute()) {
				cc.compose(modeStereotypeCommand);
			}						
		}
	}

	/**
	 * Move all the stereotype of an element into a new resource
	 * @param container
	 * @param sourceEObject
	 * @return
	 */
	protected ICommand getMoveStereotypeCommand(EObject container, EObject obj) {
		if(obj instanceof Element) {
			Element element = (Element)obj;
			EList<EObject> stereotypeApplications = element.getStereotypeApplications();
			if(stereotypeApplications != null && !stereotypeApplications.isEmpty()) {
				Resource eResource = container.eResource();
				if(eResource != null) {
					if(eResource.isLoaded()){
						return new MoveStereotypeApplicationsCommand(getEditingDomain(container), element, eResource);
					} else {
						return new UnexecutableCommand(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The new containing resource is not loaded"));////$NON-NLS-1$
					}
				}
			}
		}
		return null;
	}

	protected ICommand getMoveDiagramsCommand(EObject container, EObject sourceEObject) {
		/*
		 * Get all diagram from source EObject (its diagram and its descendant)
		 */
		List<Diagram> initialDiagrams = NotationUtils.getAllDescendantDiagramsInResource(sourceEObject, getDiagramContainer(sourceEObject));

		/*
		 * Get the notation model of the container
		 * 1. If not loaded unexecutable command
		 */
		Resource diagramContainer = getDiagramContainer(container);
		if(diagramContainer == null) {
			return new UnexecutableCommand(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Unable to find a notation model to store diagram elements"));////$NON-NLS-1$
		}
		TransactionalEditingDomain editingDomain = getEditingDomain(container);
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, "Move related diagrams in new resource");////$NON-NLS-1$
		for(Diagram d : initialDiagrams) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Move ");
			stringBuilder.append(d.getName());
			stringBuilder.append("into a new resource");
			cc.compose(new MoveOpenableCommand(editingDomain, stringBuilder.toString(), d, diagramContainer));
		}
		return cc;
	}

	/**
	 * Get the editing domain from an {@link EObject}
	 * @param eObject
	 * @return
	 */
	protected TransactionalEditingDomain getEditingDomain(EObject eObject) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(editingDomain instanceof TransactionalEditingDomain) {
			return (TransactionalEditingDomain)editingDomain;
		}
		throw new RuntimeException("Unable to retrieve the transactionnal editin domain");////$NON-NLS-1$
	}

	/**
	 * Get the EObject which contains diagram in the new ressource
	 * 
	 * @param containerRessourceContentes
	 * @return
	 */
	protected Resource getDiagramContainer(EObject newEobjectContainer) {
		ResourceSet rs = newEobjectContainer.eResource().getResourceSet();
		Resource diagramContainer = null;
		if(rs instanceof DiResourceSet) {
			DiResourceSet diResourceSet = (DiResourceSet)rs;
			diagramContainer = diResourceSet.getAssociatedNotationResource(newEobjectContainer);
		}
		return diagramContainer;
	}
}
