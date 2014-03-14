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

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.clazz.custom.ui.TemplateParameterConfigurationDialog;
import org.eclipse.papyrus.uml.diagram.clazz.edit.commands.TemplateParameterCreateCommand;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class CTemplateParameterCreateCommand extends TemplateParameterCreateCommand {

	public CTemplateParameterCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		TemplateParameter newElement = UMLFactory.eINSTANCE.createTemplateParameter();
		TemplateSignature owner = (TemplateSignature)getElementToEdit();
		owner.getOwnedParameters().add(newElement);
		TemplateSignature childHolder = (TemplateSignature)getElementToEdit();
		childHolder.getParameters().add(newElement);
		ArrayList<EClass> eclassnotWanted = new ArrayList<EClass>();
		eclassnotWanted.add(UMLPackage.eINSTANCE.getClassifier());
		eclassnotWanted.add(UMLPackage.eINSTANCE.getOperation());
		eclassnotWanted.add(UMLPackage.eINSTANCE.getConnectableElement());
		TemplateParameterConfigurationDialog configurationDialog = new TemplateParameterConfigurationDialog(new Shell(), SWT.APPLICATION_MODAL, UMLPackage.eINSTANCE.getPackageableElement(), eclassnotWanted);
		configurationDialog.setOwner(childHolder);
		configurationDialog.open();
		newElement.setParameteredElement(configurationDialog.getParameterableElement());
		newElement.setDefault(configurationDialog.getDefaultparameterableElement());
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
