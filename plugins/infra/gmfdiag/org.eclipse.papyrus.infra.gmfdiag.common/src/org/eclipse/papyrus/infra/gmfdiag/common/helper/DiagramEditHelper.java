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
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.helper;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.viewpoints.policy.ModelAddData;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;

/**
 * Represents an Edit Helper for GMF Diagrams
 * @author Laurent Wouters
 */
public class DiagramEditHelper implements IEditHelper {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper#canEdit(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 */
	public boolean canEdit(IEditCommandRequest req) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper#getEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 */
	public ICommand getEditCommand(final IEditCommandRequest req) {
		if (req instanceof DestroyElementRequest) {
			DestroyElementRequest r = (DestroyElementRequest)req;
			return getDestroyDiagramCommand((Diagram)r.getElementToDestroy());
		} else if (req instanceof SetRequest) {
			SetRequest r = (SetRequest)req;
			return GetSimpleSetCommand(r.getElementToEdit(), r.getFeature(), r.getValue());
		} else if (req instanceof CreateElementRequest) {
			CreateElementRequest r = (CreateElementRequest)req;
			EObject container = r.getContainer();
			if (container instanceof Diagram)
				return getCreateCommand((Diagram)container, r.getContainmentFeature(), r.getElementType());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper#getContainedValues(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EReference)
	 */
	public List getContainedValues(EObject eContainer, EReference feature) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Gets the command for destroying the given diagram
	 * @param diagram The diagram to destroy
	 * @return The appropriate command
	 */
	private ICommand getDestroyDiagramCommand(final Diagram diagram) {
		final Resource resource = diagram.eResource();
		return new AbstractCommand("Destroy diagram") {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				resource.getContents().remove(diagram);
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				resource.getContents().remove(diagram);
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				resource.getContents().add(diagram);
				return CommandResult.newOKCommandResult();
			}
		};
	}
	
	/**
	 * Gets the command for setting a property of a view
	 * @param object The object to modify
	 * @param feature The feature to modify
	 * @param newValue The new value for the feature
	 * @return The appropriate command
	 */
	private ICommand GetSimpleSetCommand(final EObject object, final EStructuralFeature feature, final Object newValue) {
		return new AbstractCommand("Edit property") {
			private Object oldValue;
			
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				oldValue = object.eGet(feature);
				object.eSet(feature, newValue);
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				object.eSet(feature, newValue);
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				object.eSet(feature, oldValue);
				return CommandResult.newOKCommandResult();
			}
		};
	}
	
	
	/**
	 * Gets the command for the creation of an element in a diagram
	 * @param diagram The diagram to change
	 * @param reference The containment feature
	 * @param type The type of the element to be created
	 * @return The appropriate command
	 */
	private ICommand getCreateCommand(final Diagram diagram, final EReference reference, final IElementType type) {
		return new AbstractCommand("Create element") {
			private EObject newElement;
			private ModelAddData data;
			
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				data = PolicyChecker.getCurrent().getChildAddData(diagram, diagram.getElement().eClass(), type.getEClass());
				if (!data.isPermitted())
					return CommandResult.newErrorCommandResult("The current active viewpoint policy prevents the addition of this element to the view");
				newElement = type.getEClass().getEPackage().getEFactoryInstance().create(type.getEClass());
				if (data.isPathDefined()) {
					if (!data.execute(diagram.getElement(), newElement))
						return CommandResult.newErrorCommandResult("Failed to follow the path");
				} else {
					diagram.getElement().eSet(reference, newElement);
				}
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				data.redoExecute();
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				data.undoExecute();
				return CommandResult.newOKCommandResult();
			}
		};
	}
}
