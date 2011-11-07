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


package org.eclipse.papyrus.uml.diagram.profile.custom.commands;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.papyrus.uml.diagram.profile.custom.messages.Messages;
import org.eclipse.papyrus.uml.diagram.profile.custom.requests.CustomCreateElementRequestAdapter;
import org.eclipse.papyrus.uml.diagram.profile.custom.ui.dialog.ChooseSetMetaclassDialog;
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
public class CustomSemanticCreateCommand extends AbstractTransactionalCommand {

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
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param requestAdapter
	 * @param realSemanticCommand
	 * @param profile
	 */
	public CustomSemanticCreateCommand(TransactionalEditingDomain domain, CustomCreateElementRequestAdapter requestAdapter, Profile profile) {
		super(domain, "Create Custom Semantic Command for Metaclass", null); //$NON-NLS-1$
		this.profile = profile;
		this.customRequestAdapter = requestAdapter;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		CommandResult result = CommandResult.newCancelledCommandResult();
		ChooseSetMetaclassDialog cmcd = new ChooseSetMetaclassDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), this.profile);

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
				ICommand createElementImportCommand = getImportElementCommand();
				if(createElementImportCommand != null) {
					createElementImportCommand.execute(progressMonitor, info);
				}
				return CommandResult.newOKCommandResult();
			}
			//else we return a canceled command result (avoid an Undo for nothing for the user!)
		}
		return result;

	}

	/**
	 * 
	 * @return
	 *         the command to create the new ElementImport for each new import metaclass
	 */
	private ICommand getImportElementCommand() {
		CompositeCommand addindCommand = new CompositeCommand("Add ImportElement Command"); //$NON-NLS-1$
		//----Obtain the actual imported metaclasses
		EList<?> metaclassSet = this.profile.getReferencedMetaclasses();

		//we add the new metaclasses
		for(int i = 0; i < this.addedMetaclasses.size(); i++) {
			//we need to import the metaclass
			if(!metaclassSet.contains(this.addedMetaclasses.get(i))) {
				//we create an ElementImport for the new metaclass
				ElementImport ei = UMLFactory.eINSTANCE.createElementImport();
				//we create the class		


				ei.setImportedElement((PackageableElement)this.addedMetaclasses.get(i));
				ei.setAlias(((NamedElement)this.addedMetaclasses.get(i)).getName());
				//					addedMetaclasses.add(addedMetaclasses.get(i));
				ElementImport added = ei;

				//we need make the import only if it doesn't exist yet!
				EList<ElementImport> list = this.profile.getElementImports();

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
				SetRequest setRequest = new SetRequest(this.profile, UMLPackage.eINSTANCE.getProfile_MetaclassReference(), added);
				org.eclipse.papyrus.service.edit.service.IElementEditService provider = org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils.getCommandProvider(this.profile);

				if(provider != null) {
					ICommand editCommand = null;
					editCommand = provider.getEditCommand(setRequest);
					if(editCommand != null) {
						addindCommand.add(editCommand);
					}
				}
			} else {
				//the metaclass is already imported, nothing to do here!
			}
			this.customRequestAdapter.setNewElement((EObject)this.addedMetaclasses.get(i));
		}
		if(!addindCommand.isEmpty()) {
			return addindCommand;
		}
		return null;
	}


}
