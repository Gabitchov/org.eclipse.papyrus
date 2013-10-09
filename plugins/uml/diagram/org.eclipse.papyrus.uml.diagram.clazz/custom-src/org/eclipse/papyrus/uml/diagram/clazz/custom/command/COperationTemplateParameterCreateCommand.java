/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.clazz.custom.ui.TemplateParameterConfigurationDialog;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.OperationTemplateParameterCreateCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.OperationTemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class COperationTemplateParameterCreateCommand extends OperationTemplateParameterCreateCommand {

	public COperationTemplateParameterCreateCommand(CreateElementRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		OperationTemplateParameter newElement = UMLFactory.eINSTANCE.createOperationTemplateParameter();
		TemplateSignature owner = (TemplateSignature)getElementToEdit();
		owner.getOwnedParameters().add(newElement);
		TemplateSignature childHolder = (TemplateSignature)getElementToEdit();
		childHolder.getParameters().add(newElement);
		TemplateParameterConfigurationDialog configurationDialog = new TemplateParameterConfigurationDialog(new Shell(), SWT.APPLICATION_MODAL, UMLPackage.eINSTANCE.getOperation());
		configurationDialog.setOwner(childHolder);
		configurationDialog.open();
		newElement.setParameteredElement(configurationDialog.getParameterableElement());
		newElement.setDefault(configurationDialog.getDefaultparameterableElement());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
