/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
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
import org.eclipse.papyrus.infra.services.edit.commands.AbstractConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.utils.GMFCommandUtils;
import org.eclipse.papyrus.sysml.diagram.common.dialogs.CreateOrSelectActorPartTypeDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * This command factory provides a command that enable ActorPart type to be selected or created during creation.
 */
public class CreateActorPartWithTypeConfigureCommandFactory extends AbstractConfigureCommandFactory {

	/**
	 * {@inheritDoc}
	 */
	public ICommand create(ConfigureRequest request) {

		ICommand configureCommand = null;

		Shell shell = Display.getDefault().getActiveShell();
		// Start dialog to identify the new part type
		Property part = (Property)request.getElementToConfigure();
		Package partPkg = part.getNearestPackage();

		CreateOrSelectActorPartTypeDialog dialog = new CreateOrSelectActorPartTypeDialog(shell, partPkg);
		dialog.open();
		if(dialog.getReturnCode() == CreateOrSelectActorPartTypeDialog.OK) {

			final ICommand typeCreationCommand = dialog.getNewTypeCreateCommand();
			final Type actorPartType = (Type)dialog.getExistingType();

			// Abort if type creation command exists but is not executable
			if((typeCreationCommand != null) && (!typeCreationCommand.canExecute())) {
				return cancelCommand(request);
			} else {
				configureCommand = CompositeCommand.compose(configureCommand, typeCreationCommand);
			}

			// Create the configure command that will set the ActorPart type
			ICommand setTypeCommand = new ConfigureElementCommand(request) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

					Property actorPart = (Property)getElementToEdit();
					if(actorPartType != null) {
						actorPart.setType(actorPartType);
					} else {
						Type newType = (Type)GMFCommandUtils.getCommandEObjectResult(typeCreationCommand);
						actorPart.setType(newType);
					}
					
					return CommandResult.newOKCommandResult(actorPart);
				}

			};

			configureCommand = CompositeCommand.compose(configureCommand, setTypeCommand);
			return configureCommand;
		}

		return cancelCommand(request);
	}
}
