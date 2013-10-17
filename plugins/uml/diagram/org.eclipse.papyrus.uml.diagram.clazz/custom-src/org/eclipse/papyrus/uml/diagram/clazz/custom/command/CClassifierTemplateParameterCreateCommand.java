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
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.ClassifierTemplateParameterCreateCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class CClassifierTemplateParameterCreateCommand extends ClassifierTemplateParameterCreateCommand {

	public CClassifierTemplateParameterCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ClassifierTemplateParameter newElement = UMLFactory.eINSTANCE.createClassifierTemplateParameter();
		TemplateSignature owner = (TemplateSignature)getElementToEdit();
		owner.getOwnedParameters().add(newElement);
		TemplateSignature childHolder = (TemplateSignature)getElementToEdit();
		childHolder.getParameters().add(newElement);
		TemplateParameterConfigurationDialog configurationDialog = new TemplateParameterConfigurationDialog(new Shell(), SWT.APPLICATION_MODAL, UMLPackage.eINSTANCE.getClassifier());
		configurationDialog.setOwner(childHolder);
		configurationDialog.open();
		newElement.setParameteredElement(configurationDialog.getParameterableElement());
		newElement.setDefault(configurationDialog.getDefaultparameterableElement());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
