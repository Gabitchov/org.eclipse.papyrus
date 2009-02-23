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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class Property2CreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public Property2CreateCommand(CreateElementRequest req, EObject eObject) {
		super(req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static Property2CreateCommand create(CreateElementRequest req, EObject eObject) {
		return new Property2CreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public Property2CreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject doDefaultElementCreation() {
		Property newElement = UMLFactory.eINSTANCE.createProperty();

		Signal owner = (Signal) getElementToEdit();
		owner.getOwnedAttributes().add(newElement);

		UMLElementTypes.init_Property_3005(newElement);

		// code used in MOSKitt approach in order to manage "delete from diagram"
		// org.eclipse.gmf.runtime.notation.Diagram diagram = es.cv.gvcase.mdt.common.util.MDTUtil.getDiagramFromRequest(getRequest());
		// if (diagram != null) {
		// es.cv.gvcase.mdt.common.util.MultiDiagramUtil.AddEAnnotationReferenceToDiagram(diagram, newElement);
		// }
		// else {
		// es.cv.gvcase.mdt.common.util.MultiDiagramUtil.
		// addEAnnotationReferenceToDiagram(
		// org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditorPlugin.getInstance(), newElement);
		// }
		return newElement;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	// we modify this method to avoid the bug of infinite loop on creation
	// we don't know what the origin of this bug.
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// Do the default element creation
		Element newElement = (Element) doDefaultElementCreation();

		// // Configure the new element
		// ConfigureRequest configureRequest = createConfigureRequest();
		//
		// ICommand configureCommand = elementType.getEditCommand(configureRequest);
		//
		IStatus configureStatus = null;
		//
		// if (configureCommand != null && configureCommand.canExecute()) {
		// configureStatus = configureCommand.execute(monitor, info);
		// }

		// Put the newly created element in the request so that the
		// 'after' commands have access to it.
		getCreateRequest().setNewElement(newElement);

		return (configureStatus == null) ? CommandResult.newOKCommandResult(newElement) : new CommandResult(configureStatus, newElement);
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {

		EObject eObject = getElementToEdit();
		if (eObject != null) {
			return eObject.eClass();
		}
		if (eClass != null) {
			return eClass;
		}
		return UMLPackage.eINSTANCE.getSignal();
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {

		EObject container = ((CreateElementRequest) getRequest()).getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		if (container != null) {
			return container;
		}
		return eObject;
	}

}
