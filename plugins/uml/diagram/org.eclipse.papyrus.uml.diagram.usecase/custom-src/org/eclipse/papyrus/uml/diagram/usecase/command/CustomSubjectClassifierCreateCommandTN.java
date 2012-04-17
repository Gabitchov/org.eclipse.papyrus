/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.usecase.command;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.usecase.ui.SubjectSelectionDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Classifier;

/**
 * specific command to create a subject
 * 
 */
public class CustomSubjectClassifierCreateCommandTN extends EditElementCommand {

	ArrayList<IHintedType> possibleSubject = new ArrayList<IHintedType>();

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
	public CustomSubjectClassifierCreateCommandTN(CreateElementRequest req, EObject eObject, ArrayList<IHintedType> possibleSubject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
		this.possibleSubject = possibleSubject;
	}

	/**
	 * @generated
	 */
	public static CustomSubjectClassifierCreateCommandTN create(CreateElementRequest req, EObject eObject, ArrayList<IHintedType> possibleSubject) {
		return new CustomSubjectClassifierCreateCommandTN(req, eObject, possibleSubject);
	}

	/**
	 * @generated
	 */
	public CustomSubjectClassifierCreateCommandTN(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		return true;
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		SubjectSelectionDialog dialog = new SubjectSelectionDialog(new Shell(), possibleSubject, SWT.NATIVE);
		dialog.open();
		Classifier newElement = null;
		IHintedType htype = dialog.getSelectedMetaclass();
		EObject element = ((CreateElementRequest)getRequest()).getContainer();
		CreateElementRequest createElementRequest = new CreateElementRequest(element, htype);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
		if(provider != null) {
			// Retrieve delete command from the Element Edit service
			ICommand createCommand = provider.getEditCommand(createElementRequest);
			createCommand.execute(new NullProgressMonitor(), null);
			createCommand.getCommandResult().getReturnValue();
			newElement = (Classifier)createCommand.getCommandResult().getReturnValue();
		}
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Classifier newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}
}
