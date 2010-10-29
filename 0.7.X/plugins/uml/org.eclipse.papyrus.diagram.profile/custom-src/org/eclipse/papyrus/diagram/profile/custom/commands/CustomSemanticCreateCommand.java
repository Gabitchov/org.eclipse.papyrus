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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.profile.custom.messages.Messages;
import org.eclipse.papyrus.diagram.profile.custom.requests.CustomCreateElementRequestAdapter;
import org.eclipse.papyrus.diagram.profile.custom.ui.dialog.ChooseSetMetaclassDialog;
import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.papyrus.ui.toolbox.LookForElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

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
	private ArrayList<?> addedMetaclasses;

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
		// the first argument is here to be conform with the metaclass's constructor. It isn't used!
		super(new CreateElementRequestAdapter(requestAdapter.getRequest(0)), realSemanticCommand);
		this.profile = profile;
		this.customRequestAdapter = requestAdapter;
	}



	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult result = CommandResult.newCancelledCommandResult();
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


		if(cmcd.getReturnCode() == IStatus.OK) {
			this.addedMetaclasses = cmcd.getSelectedElements();
			if(!this.addedMetaclasses.isEmpty()) {
				result = applyModification();
			}
			//else we return a cancelled command result (avoid an Undo for nothing for the user!)
		}
		return result;

	}

	/**
	 * Apply the modifications to the Profile : import required metaclasses
	 * 
	 * @return
	 *         the command result
	 */
	private CommandResult applyModification() {
		CommandResult result = null;
		CompoundCommand addingCommand = new CompoundCommand();
		//----Obtain the actual imported metaclasses
		EList<?> metaclassSet = profile.getReferencedMetaclasses();

		//we add the new metaclasses
		for(int i = 0; i < addedMetaclasses.size(); i++) {
			//we need to import the metaclass
			if(!metaclassSet.contains(addedMetaclasses.get(i))) {
				//we create an ElementImport for the new metaclass
				ElementImport ei = UMLFactory.eINSTANCE.createElementImport();
				//we create the class		


				ei.setImportedElement((PackageableElement)addedMetaclasses.get(i));
				ei.setAlias(((NamedElement)addedMetaclasses.get(i)).getName());
				//					addedMetaclasses.add(addedMetaclasses.get(i));
				ElementImport added = ei;

				//we need make the import only if it doesn't exist yet!
				EList<ElementImport> list = profile.getElementImports();

				//We search if this metaclass is imported yet
				//ListIterator<ElementImport> iterator = list.listIterator();
				for(int iter = 0; iter < list.size(); iter++) {
					if(list.get(iter) != null) {
						if(list.get(iter).getImportedElement() != null) {
							if(ei.getImportedElement().getQualifiedName().equals(list.get(iter).getImportedElement().getQualifiedName())) {
								added = list.get(iter);//iterator.previous();
								break;
							}
						}
					}
				}

				//we add the metaclass in metaclassReference
				SetRequest setRequest = new SetRequest(profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), added);
				SetValueCommand setValueCommand = new SetValueCommand(setRequest);
				if(setValueCommand != null && setValueCommand.canExecute()) {
					addingCommand.add(new ICommandProxy(setValueCommand));
				}

			} else {
				//the metaclass is already imported, nothing to do here!
			}
			this.customRequestAdapter.setNewElement((EObject)addedMetaclasses.get(i));
		}
		if(addingCommand != null && addingCommand.canExecute()) {
			try {
				LookForElement.getCommandStack().execute(addingCommand);
				result = CommandResult.newOKCommandResult(this.customRequestAdapter);
			} catch (Exception e) {
				Activator.log.error(e);
			}
		}
		return result;
	}

}
