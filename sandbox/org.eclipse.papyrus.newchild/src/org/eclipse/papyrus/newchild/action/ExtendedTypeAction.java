/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.newchild.action;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.core.utils.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extendedtypes.ExtendedElementTypeConfiguration;
import org.eclipse.papyrus.extendedtypes.gmf.ExtendedEditHelperAdvice;
import org.eclipse.papyrus.extendedtypes.gmf.ExtendedSemanticTypeDescriptor;
import org.eclipse.papyrus.extendedtypes.gmf.types.ExtendedHintedTypeFactory;


public class ExtendedTypeAction extends Action {

	private IElementType elementType;

	private EObject parent;

	private EditingDomain domain;

	private ExtendedSemanticTypeDescriptor descriptor;

	public static ExtendedEditHelperAdvice advice = new ExtendedEditHelperAdvice();

	public ExtendedTypeAction(EObject parent, ExtendedElementTypeConfiguration elementTypeConfiguration, EditingDomain domain) {
		this.descriptor = new ExtendedSemanticTypeDescriptor(elementTypeConfiguration);
		this.elementType = ExtendedHintedTypeFactory.getInstance().createSpecializationType(descriptor);
		this.parent = parent;
		this.domain = domain;

		configureAction();
	}

	protected void configureAction() {
		setText(descriptor.getName());
		setImageDescriptor(ImageDescriptor.createFromURL(descriptor.getIconURL()));
	}

	@Override
	public void run() {
		CreateElementRequest request = new CreateElementRequest((TransactionalEditingDomain)domain, parent, elementType);
		//			ICommand beforeCommand = advice.getBeforeEditCommand(request);
		ICommand command = new CreateElementCommand(request);
		//			baseCommand.getCommandResult().getReturnValue();
		//			ConfigureRequest configure = new ConfigureRequest(parent, elementType);
		//			ICommand afterCommand = advice.getAfterEditCommand(configure);
		//			CompositeCommand command = new CompositeCommand(getText());
		//
		//			if(beforeCommand != null) {
		//				command.add(beforeCommand);
		//			}
		//			if (baseCommand != null){
		//				command.add(baseCommand);
		//			}
		//			if(afterCommand != null) {
		//				command.add(afterCommand);
		//			}

		Command emfCommand = new GMFtoEMFCommandWrapper(command);

		System.out.println(emfCommand.canExecute());
		domain.getCommandStack().execute(emfCommand);
	}
}
