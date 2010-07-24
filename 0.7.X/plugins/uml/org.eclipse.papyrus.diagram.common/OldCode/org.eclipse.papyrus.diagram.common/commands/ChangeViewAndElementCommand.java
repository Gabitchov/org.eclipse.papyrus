/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Marc Gil Sendra (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Complex <Command> that takes an existing <EObject and View> and turns it into another <EObject
 * and View>.
 * 
 * @author <a href="mailto:mgil@prodevelop.es">Marc Gil Sendra</a>
 */
public abstract class ChangeViewAndElementCommand extends AbstractTransactionalCommand {

	/** The new e object. */
	private EObject newEObject = null;

	/** The old edit part. */
	private GraphicalEditPart oldEditPart = null;

	/** The old e object. */
	private EObject oldEObject = null;

	/** The new i element type. */
	private IElementType newIElementType = null;

	/** The new visual id. */
	private int newVisualID = -1;

	/** The new e object view. */
	private View newEObjectView = null;

	/** Copy the diagram? */
	private boolean copyDiagram = false;

	/** The cached create element request. */
	protected CreateElementRequest cachedCreateElementRequest = null;

	/**
	 * Instantiates a new change view and element command.
	 * 
	 * @param oldEditPart
	 *            the old edit part
	 * @param newIElementType
	 *            the new i element type
	 * @param newVisualID
	 *            the new visual id
	 */
	public ChangeViewAndElementCommand(GraphicalEditPart oldEditPart, IElementType newIElementType, int newVisualID,
			boolean copyDiagram) {
		super(oldEditPart.getEditingDomain(), "Mutate an old EObject and View to a new EObject and View", null);
		this.newIElementType = newIElementType;
		this.newVisualID = newVisualID;
		this.oldEditPart = oldEditPart;
		this.oldEObject = oldEditPart.resolveSemanticElement();
		this.copyDiagram = copyDiagram;
	}

	/**
	 * Gets the old edit part.
	 * 
	 * @return the old edit part
	 */
	protected GraphicalEditPart getOldEditPart() {
		return oldEditPart;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.emf.commands.core.command. AbstractTransactionalCommand
	 * #doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// create new EObject
		AbstractTransactionalCommand createNewEObjectCommand = createCreateNewEObjectCommand();
		if (createNewEObjectCommand == null) {
			return CommandResult.newErrorCommandResult("Error when creating new EObject");
		}
		createNewEObjectCommand.execute(monitor, info);

		// extract the newly created EObject
		getNewlyCreatedEObject();

		// change the diagram element if it has one
		if (copyDiagram) {
			AbstractCommand changeDiagramElement = createChangeDiagramElement();
			if (changeDiagramElement != null) {
				changeDiagramElement.execute(monitor, info);
			}
		}

		// create the new EObject View
		Command createViewCommand = getCreateViewCommand(oldEditPart, newEObject);
		if (createViewCommand == null) {
			return CommandResult.newErrorCommandResult("Error when creating new EObject View");
		}
		createViewCommand.execute();

		// add the EObject to the Diagram's "to show" references
		AbstractTransactionalCommand addReferenceToDiagramCommand = createAddNewEObjectToDiagramReferencesCommand();
		if (addReferenceToDiagramCommand == null) {
			return CommandResult.newErrorCommandResult("Error when adding new EObject reference");
		}
		addReferenceToDiagramCommand.execute(monitor, info);

		// "clone" NewEObject
		AbstractCommand cloneNewEObjectCommand = createCloneNewEObjectCommand(getNewEObject());
		if (cloneNewEObjectCommand == null) {
			return CommandResult.newErrorCommandResult("Error when cloning new EObject");
		}
		cloneNewEObjectCommand.execute(monitor, info);

		// delete the old EObject
		AbstractTransactionalCommand deleteOldEObjectCommand = createDeleteOldEObjectCommand();
		if (deleteOldEObjectCommand == null) {
			return CommandResult.newErrorCommandResult("Error when deleting old EObject");
		}
		deleteOldEObjectCommand.execute(monitor, info);

		// delete the Old EObject View
		AbstractTransactionalCommand deleteViewCommand = getDeleteViewCommand(oldEditPart);
		if (deleteViewCommand == null) {
			return CommandResult.newErrorCommandResult("Error when deleting old EObject View");
		}
		deleteViewCommand.execute(monitor, info);

		return CommandResult.newOKCommandResult(getNewEObjectView());
	}

	// // Create requests methods

	/**
	 * Creates the create new e object request.
	 * 
	 * @return the creates the element request
	 */
	protected CreateElementRequest createCreateNewEObjectRequest() {
		EObject container = getContainer();
		IElementType type = newIElementType;
		EReference feature = getContainingFeature();
		if (container == null || type == null || feature == null) {
			return null;
		}
		return new CreateElementRequest(container, type, feature);
	}

	/**
	 * Creates the destroy old EObject request.
	 * 
	 * @return the destroy element request
	 */
	protected DestroyElementRequest createDestroyOldEObjectRequest() {
		EObject oldEObject = getOldEObject();
		return oldEObject != null ? new DestroyElementRequest(oldEObject, false) : null;
	}

	/**
	 * Gets the creates the view request.
	 * 
	 * @param oldEditPart
	 *            the old edit part
	 * @param newEObject
	 *            the new e object
	 * 
	 * @return the creates the view request
	 */
	private CreateViewRequest getCreateViewRequest(GraphicalEditPart oldEditPart, EObject newEObject) {

		String semanticHint = String.valueOf(newVisualID);
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(newEObject), Node.class, semanticHint,
				PreferencesHint.USE_DEFAULTS);

		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptor);
		createViewRequest.setLocation(getLocation(oldEditPart));
		return createViewRequest;
	}

	// // Create commands methods

	/**
	 * Creates the clone new e object command.
	 * 
	 * @param newEObject
	 *            the new e object
	 * 
	 * @return the abstract command
	 */
	protected abstract AbstractCommand createCloneNewEObjectCommand(EObject newEObject);

	/**
	 * Creates the set value command from feature.
	 * 
	 * @param elementToEdit
	 *            the element to edit
	 * @param feature
	 *            the feature
	 * @param elementToCopy
	 *            the element to copy
	 * 
	 * @return the sets the value command
	 */
	public static SetValueCommand createSetValueCommandFromFeature(EObject elementToEdit, EStructuralFeature feature,
			EObject elementToCopy) {
		Object value = elementToCopy != null && feature != null ? elementToCopy.eGet(feature, true) : null;
		if (elementToEdit == null || feature == null || elementToCopy == null) {
			return null;
		}
		SetRequest request = new SetRequest(elementToEdit, feature, value);
		return new SetValueCommand(request);
	}

	/**
	 * Creates the destroy element command.
	 * 
	 * @param eObject
	 *            the e object
	 * 
	 * @return the destroy element command
	 */
	public static DestroyElementCommand createDestroyElementCommand(EObject eObject) {
		DestroyElementRequest destroyRequest = new DestroyElementRequest(eObject, false);
		return new DestroyElementCommand(destroyRequest);
	}

	/**
	 * Creates the create new e object command.
	 * 
	 * @return the abstract transactional command
	 */
	protected AbstractTransactionalCommand createCreateNewEObjectCommand() {
		CreateElementRequest createRequest = createCreateNewEObjectRequest();
		cachedCreateElementRequest = createRequest;
		return createRequest != null ? new CreateElementCommand(createRequest) : null;
	}

	/**
	 * Creates the change diagram element.
	 * 
	 * @return the abstract command
	 */
	protected AbstractCommand createChangeDiagramElement() {
		CompositeCommand cc = new CompositeCommand("Change Diagram Element");

		Diagram d = findElementDiagram();

		if (d == null)
			return null;

		SetRequest request = new SetRequest(d, NotationPackage.eINSTANCE.getView_Element(), getNewEObject());

		cc.add(new SetValueCommand(request));

		return cc.canExecute() ? cc : null;
	}

	/**
	 * Creates the delete old e object command.
	 * 
	 * @return the abstract transactional command
	 */
	protected AbstractTransactionalCommand createDeleteOldEObjectCommand() {
		DestroyElementRequest destroyRequest = createDestroyOldEObjectRequest();
		return destroyRequest != null ? new DestroyElementCommand(destroyRequest) : null;
	}

	/**
	 * Creates the add new e object to diagram references command.
	 * 
	 * @return the abstract transactional command
	 */
	protected AbstractTransactionalCommand createAddNewEObjectToDiagramReferencesCommand() {
		TransactionalEditingDomain domain = getEditingDomain();
		Diagram diagram = getDiagram() instanceof Diagram ? (Diagram) getDiagram() : null;
		EObject newEObject = getNewEObject();
		if (domain == null || newEObject == null) {
			return null;
		}
		List<EObject> list = new ArrayList<EObject>();
		list.add(newEObject);
		return new AddEObjectReferencesToDiagram(domain, diagram, list);
	}

	/**
	 * Gets the delete view command.
	 * 
	 * @param oldEditPart
	 *            the old edit part
	 * 
	 * @return the delete view command
	 */
	private AbstractTransactionalCommand getDeleteViewCommand(GraphicalEditPart oldEditPart) {
		View view = (View) oldEditPart.getModel();
		return new DeleteCommand(view);
	}

	/**
	 * Gets the creates the view command.
	 * 
	 * @param oldEditPart
	 *            the old edit part
	 * @param newEObject
	 *            the new e object
	 * 
	 * @return the creates the view command
	 */
	private Command getCreateViewCommand(GraphicalEditPart oldEditPart, EObject newEObject) {
		CreateViewRequest createViewRequest = getCreateViewRequest(oldEditPart, newEObject);
		if (createViewRequest == null) {
			return null;
		}
		return oldEditPart.getParent().getCommand(createViewRequest);
	}

	// // Getter methods

	/**
	 * Gets the new e object.
	 * 
	 * @return the new e object
	 */
	protected EObject getNewEObject() {
		return newEObject;
	}

	/**
	 * Gets the container.
	 * 
	 * @return the container
	 */
	protected EObject getContainer() {
		EObject element = getOldEditPart() != null ? getOldEditPart().resolveSemanticElement() : null;
		return element.eContainer();
	}

	/**
	 * Gets the containing feature.
	 * 
	 * @return the containing feature
	 */
	protected abstract EReference getContainingFeature();

	/**
	 * Gets the transactional editing domain.
	 * 
	 * @return the transactional editing domain
	 */
	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		return getOldEditPart() != null ? getOldEditPart().getEditingDomain() : null;
	}

	/**
	 * Gets the diagram.
	 * 
	 * @return the diagram
	 */
	protected View getDiagram() {
		return getOldEditPart() != null ? getOldEditPart().getNotationView().getDiagram() : null;
	}

	/**
	 * Gets the old e object.
	 * 
	 * @return the old e object
	 */
	protected EObject getOldEObject() {
		return oldEObject;
	}

	/**
	 * Gets the new e object view.
	 * 
	 * @return the new e object view
	 */
	protected View getNewEObjectView() {
		return newEObjectView;
	}

	// // extract results

	/**
	 * Gets the newly created e object.
	 * 
	 * @return the newly created e object
	 */
	protected void getNewlyCreatedEObject() {
		EObject eObject = cachedCreateElementRequest != null ? cachedCreateElementRequest.getNewElement() : null;
		newEObject = eObject;
	}

	/**
	 * Gets the location.
	 * 
	 * @param editPart
	 *            the edit part
	 * 
	 * @return the location
	 */
	private Point getLocation(GraphicalEditPart editPart) {
		return new Point(editPart.getFigure().getBounds().getLocation());
	}

	/**
	 * Find element diagram.
	 * 
	 * @return the diagram
	 */
	private Diagram findElementDiagram() {
		for (Resource r : getEditingDomain().getResourceSet().getResources()) {
			if (r instanceof GMFResource) {
				for (EObject eo : ((GMFResource) r).getContents()) {
					if (eo instanceof Diagram) {
						Diagram d = (Diagram) eo;
						if (d.getElement() != null && d.getElement().equals(getOldEObject())) {
							return d;
						}
					}
				}
			}
		}

		return null;
	}

}
