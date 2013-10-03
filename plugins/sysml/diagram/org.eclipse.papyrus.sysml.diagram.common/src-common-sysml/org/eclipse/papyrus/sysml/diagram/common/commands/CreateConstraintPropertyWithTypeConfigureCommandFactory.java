/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 * Régis Chevrel (chevrel.regis@gmail.com) CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.common.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.services.edit.commands.AbstractConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.services.edit.utils.GMFCommandUtils;
import org.eclipse.papyrus.sysml.diagram.common.dialogs.CreateOrSelectConstraintPropertyTypeDialog;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This command factory provides a command that enable Part type to be selected or created during creation.
 */
public class CreateConstraintPropertyWithTypeConfigureCommandFactory extends AbstractConfigureCommandFactory {

	/**
	 * {@inheritDoc}
	 */
	public ICommand create(ConfigureRequest request) {

		ICommand configureCommand = null;

		Shell shell = Display.getDefault().getActiveShell();
		// Start dialog to identify the new part type
		Property part = (Property)request.getElementToConfigure();
		Package partPkg = part.getNearestPackage();

		CreateOrSelectConstraintPropertyTypeDialog dialog = new CreateOrSelectConstraintPropertyTypeDialog(shell, partPkg);
		dialog.open();
		if(dialog.getReturnCode() == CreateOrSelectConstraintPropertyTypeDialog.OK) {

			final ICommand typeCreationCommand = dialog.getNewTypeCreateCommand();
			final Type partType = (Type)dialog.getExistingType();

			// Abort if type creation command exists but is not executable
			if((typeCreationCommand != null) && (!typeCreationCommand.canExecute())) {
				return cancelCommand(request);
			} else {
				configureCommand = CompositeCommand.compose(configureCommand, typeCreationCommand);
			}

			// Create the configure command that will set the constraint property type
			ICommand setTypeCommand = new ConfigureElementCommand(request) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

					Property part = (Property)getElementToEdit();
					if(partType != null) {
						part.setType(partType);
					} else {
						Type newType = (Type)GMFCommandUtils.getCommandEObjectResult(typeCreationCommand);
						createConstraintBlockConstraint(newType, monitor, info);
						part.setType(newType);
					}
					return CommandResult.newOKCommandResult(part);
				}

				private void createConstraintBlockConstraint(Type newType, IProgressMonitor monitor, IAdaptable info)  throws ExecutionException {
					// Create the constraint attached to the ConstraintBlock
					IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(newType);
					if(commandService != null) {
						CreateElementRequest createTypeRequest = new CreateElementRequest(newType, UMLElementTypes.CONSTRAINT);
						createTypeRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, 
								new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getNamedElement_Name(), newType.getName() + "Specification"));
						ICommand newConstraintCreateCommand = commandService.getEditCommand(createTypeRequest);
						if (newConstraintCreateCommand.canExecute()) {
							newConstraintCreateCommand.execute(monitor, info);
						}
					}
				}
			};

			configureCommand = CompositeCommand.compose(configureCommand, setTypeCommand);
			return configureCommand;
		}

		return cancelCommand(request);
	}
}
