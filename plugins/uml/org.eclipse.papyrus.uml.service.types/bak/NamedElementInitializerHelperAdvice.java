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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.creation.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * This is an advice helper use to initialize namedElement
 */
public class NamedElementInitializerHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyElementCommand(DestroyElementRequest request) {

		ICommand command = super.getBeforeDestroyElementCommand(request);

		NamedElement elementToDestroy = (NamedElement)request.getElementToDestroy();
		for(Dependency d : elementToDestroy.getClientDependencies()) {
			//			IElementType depET = null;
			//			try {
			//				depET = ElementTypeRegistry.getInstance().getElementType(d, UMLTypeContext.getContext());
			//			} catch (Exception e) {
			//				// TODO Auto-generated catch block
			//				e.printStackTrace();
			//			}
			//
			//			if(depET != null) {
			DestroyReferenceRequest dfr = new DestroyReferenceRequest(request.getEditingDomain(), d, UMLPackage.eINSTANCE.getDependency_Client(), elementToDestroy, false);
			//ICommand destroyRefCommand = depET.getEditCommand(dfr);
			ICommand destroyRefCommand = ElementEditServiceUtils.getCommandProvider(d).getEditCommand(dfr);

			if(destroyRefCommand != null) {
				command = CompositeCommand.compose(command, destroyRefCommand);
			}
			//				DestroyDependentsRequest ddr = new DestroyDependentsRequest(req.getEditingDomain(), req.getElementToDestroy(), false);
			//				ddrCommand = CompositeCommand.compose(ddrCommand, ddr.getDestroyDependentCommand(fragment));
			//			}
		}

		return command;

	}

	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				if(request.getElementToConfigure() instanceof NamedElement) {
					NamedElement element = (NamedElement)request.getElementToConfigure();

					// Initialize the element name based on the created IElementType
					String initializedName = NamedElementHelper.EINSTANCE.getNewUMLElementName(element.getOwner(), element.eClass());
					element.setName(initializedName);
				}

				return CommandResult.newOKCommandResult();
			}
		};
	}



}
