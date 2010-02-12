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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/


package org.eclipse.papyrus.diagram.profile.custom.commands;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.papyrus.diagram.profile.custom.messages.Messages;
import org.eclipse.papyrus.diagram.profile.custom.requests.CustomCreateElementRequestAdapter;
import org.eclipse.papyrus.diagram.profile.custom.ui.dialog.ChooseSetMetaclassDialog;
import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Profile;

/**
 * this command allows to import metaclasses in a profile
 * 
 * @author VL222926
 * 
 */
public class CustomSemanticCreateCommand extends org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand {

	/**
	 * the requestAdapter
	 */
	private CustomCreateElementRequestAdapter customRequestAdapter;

	/**
	 * the added metaclasses
	 */
	private ArrayList<Object> addedMetaclasses;

	/**
	 * the profile
	 */
	private Profile profile;



	/**
	 * the request is here to allow the creation of the requestAdapterList
	 * 
	 * @param requestAdapterNEW
	 * 
	 * @param requestAdapterList2
	 */
	public CustomSemanticCreateCommand(CustomCreateElementRequestAdapter requestAdapter, Command realSemanticCommand, Profile profile) {
		// /!\ warning 
		// the first arg is here to be conform with the metaclass's constructor. It isn't used!
		super(new CreateElementRequestAdapter(requestAdapter.getRequest(0)), realSemanticCommand);
		this.profile = profile;
		this.customRequestAdapter = requestAdapter;
	}



	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult result = null;
		ChooseSetMetaclassDialog cmcd = new ChooseSetMetaclassDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), profile);

		// opening of a message box indicating profile application
		final Shell message = new Shell(new Shell(), SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
		message.setText(Messages.CustomSemanticCreateCommand_MetaclassImport0);
		message.setImage(ImageManager.IMG_METACLASS);

		message.setSize(250, 100);

		final Label label = new Label(message, SWT.NONE);
		label.setText(Messages.CustomSemanticCreateCommand_FetchingMetaclasses);
		label.setBounds(20, 15, 150, 20);

		message.open();
		cmcd.open();
		message.close();


		if(cmcd.getReturnCode() != IStatus.OK) {

			result = CommandResult.newCancelledCommandResult();


		} else {


			addedMetaclasses = cmcd.getAddedMetaclasses();

			if(addedMetaclasses.size() == 0) {
				//Nothing to to after this command
				result = CommandResult.newCancelledCommandResult();
			} else {

				for(int i = 0; i < cmcd.getAddedMetaclasses().size(); i++) {
					this.customRequestAdapter.setNewElement((EObject)cmcd.getAddedMetaclasses().get(i));
				}
				result = CommandResult.newOKCommandResult(this.customRequestAdapter);
			}

		}

		return result;

	}

	/**
	 * 
	 * @return the list of the added Metaclasses
	 */
	public ArrayList<Object> getAddedMetaclasses() {
		return addedMetaclasses;
	}


}
