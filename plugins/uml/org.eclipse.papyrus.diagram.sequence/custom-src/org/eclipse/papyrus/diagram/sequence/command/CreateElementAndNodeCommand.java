/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.sequence.command;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;

/**
 * Command to create an element and its associated view.
 * 
 * @author Mathieu Velten
 * 
 */
public class CreateElementAndNodeCommand extends Command {

	protected ShapeNodeEditPart nodeEditPart;

	protected Point location;

	protected EObject parent, element;

	protected TransactionalEditingDomain editingDomain;

	protected Command elementCreationCommand;

	protected Command nodeCreationCommand;

	protected Map<String, Object> createElementRequestParameters = new HashMap<String, Object>();

	protected IHintedType elementType;

	/**
	 * 
	 * @param editingDomain
	 *        editingDomain the editing domain.
	 * @param nodeEditPart
	 *        the editpart of the graphical parent of the node to create.
	 * @param parent
	 *        the parent of the element to create.
	 * @param elementType
	 *        the GMF type of the element which will be created.
	 * @param location
	 *        the location where to create the element figure.
	 */
	public CreateElementAndNodeCommand(TransactionalEditingDomain editingDomain, ShapeNodeEditPart nodeEditPart, EObject parent, IHintedType elementType, Point location) {
		this.nodeEditPart = nodeEditPart;
		this.location = location;
		this.parent = parent;
		this.editingDomain = editingDomain;
		this.elementType = elementType;
	}

	/**
	 * put a parameter which will be add to the parameters of the element creation request.
	 * 
	 * @param key
	 * @param value
	 */
	public void putCreateElementRequestParameter(String key, Object value) {
		createElementRequestParameters.put(key, value);
	}

	/**
	 * retrieve the edit part associated with the created execution specification
	 * 
	 * @return the edit part or null if not created/founded
	 */
	public ShapeNodeEditPart getElementEditPart() {
		if(nodeEditPart != null) {
			for(Object obj : nodeEditPart.getChildren()) {
				if(obj instanceof ShapeNodeEditPart) {
					ShapeNodeEditPart editPart = (ShapeNodeEditPart)obj;
					if(element != null && element.equals(editPart.resolveSemanticElement())) {
						return editPart;
					}
				}
			}
		}
		return null;
	}

	public void execute() {
		super.execute();
		element = createModelElement();
		// create the view for the execution specification
		if(element != null) {
			createElementView();
		}
	}

	public void undo() {
		if(nodeCreationCommand != null) {
			nodeCreationCommand.undo();
		}
		if(elementCreationCommand != null) {
			elementCreationCommand.undo();
		}
	}

	/**
	 * Create the element in the model.
	 * 
	 * @return the element.
	 */
	protected EObject createModelElement() {

		CreateElementRequest req = new CreateElementRequest(editingDomain, parent, elementType);
		req.addParameters(createElementRequestParameters);

		elementCreationCommand = nodeEditPart.getCommand(new EditCommandRequestWrapper(req));

		if(elementCreationCommand != null) {
			elementCreationCommand.execute();
			EObject result = req.getNewElement();
			if(result instanceof EObject) {
				return (EObject)result;
			}
		}
		return null;
	}

	/**
	 * Create and execute the command to create the associated view.
	 * The element needs to be created first using createModelElement.
	 */
	protected void createElementView() {
		if(nodeEditPart != null) {
			// check if execution specification is already drawn
			if(getElementEditPart() == null) {
				ViewDescriptor descriptor = new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject)element), Node.class, elementType.getSemanticHint(), nodeEditPart.getDiagramPreferencesHint());
				CreateViewRequest request = new CreateViewRequest(descriptor);
				request.setLocation(location);
				nodeCreationCommand = nodeEditPart.getCommand(request);
				if(nodeCreationCommand != null) {
					nodeCreationCommand.execute();
				}
			}
		}
	}
}
