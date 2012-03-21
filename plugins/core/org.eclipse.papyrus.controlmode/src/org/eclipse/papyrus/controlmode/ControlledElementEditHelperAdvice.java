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
package org.eclipse.papyrus.controlmode;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.papyrus.core.adaptor.gmf.MoveDiagramCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.resource.notation.NotationUtils;

/**
 * Edit Helper advice which will handle changing resource of element.
 * Examples :
 * Moving an EObject to a controlled package should also move the related diagram to the new resource
 * 
 * @author arthur daussy
 * 
 */
public class ControlledElementEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * This case will handle moving an element from a resource to another (use case : controlled mode. This will move into the new ressource :
	 * -> The diagrams linked to this element
	 * 
	 */
	@Override
	protected ICommand getAfterMoveCommand(MoveRequest request) {
		Map elementsToMove = request.getElementsToMove();
		EObject container = request.getTargetContainer();
		for(Object o : elementsToMove.keySet()) {
			EObject sourceEObject = null;
			if(o instanceof EObject) {
				sourceEObject = (EObject)o;
			} else if(o instanceof IAdaptable) {
				sourceEObject = (EObject)((IAdaptable)o).getAdapter(EObject.class);
			}
			Resource eResource = sourceEObject.eResource();
			Resource containerEResource = container.eResource();
			if(sourceEObject != null && eResource != null && container != null && containerEResource != null) {
				/*
				 * Test if the moving element is going to be in a new resource
				 */
				if(!eResource.equals(containerEResource)) {
					CompositeTransactionalCommand cc = new CompositeTransactionalCommand(getEditingDomain(container), "Move related element to new resource");////$NON-NLS-1$
					/*
					 * Move related diagrams
					 */
					ICommand moveDiagramsCommand = getMoveDiagramsCommand(container, sourceEObject);
					if(moveDiagramsCommand != null) {
						cc.compose(moveDiagramsCommand);
					}
					return cc;
				}
			}
		}
		return super.getAfterMoveCommand(request);
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
			new UnexecutableCommand(new Status(IStatus.ERROR, ControlModePlugin.PLUGIN_ID, "Unable to find a notation model to store diagrams elements"));////$NON-NLS-1$
		}
		TransactionalEditingDomain editingDomain = getEditingDomain(container);
		CompositeTransactionalCommand cc = new CompositeTransactionalCommand(editingDomain, "Move related diagrams in new ressource");////$NON-NLS-1$
		for(Diagram d : initialDiagrams) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Move ");
			stringBuilder.append(d.getName());
			stringBuilder.append("into a new resource");
			MoveDiagramCommand mvDiagCmd = new MoveDiagramCommand(editingDomain, stringBuilder.toString(), d, diagramContainer);////$NON-NLS-1$
			if(mvDiagCmd != null && mvDiagCmd.canExecute()) {
				cc.compose(mvDiagCmd);
			}
		}
		return cc;
	}

	protected TransactionalEditingDomain getEditingDomain(EObject eObject) {
		EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		if(editingDomain instanceof TransactionalEditingDomain) {
			TransactionalEditingDomain trEditingDomain = (TransactionalEditingDomain)editingDomain;
			return trEditingDomain;
		}
		throw new RuntimeException("Unable to retreive the transactionnal editin domain");////$NON-NLS-1$
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
