/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *  Olivier Mélois (Atos) olivier.melois@atos.net - BUG 373710
 *
 *****************************************************************************/
package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.modelexplorer.handler.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.profile.Activator;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * this is dialog that display all profiles and package in a tree view
 */
public class ProfileTreeSelectionDialog extends ElementImportTreeSelectionDialog {

	/** Array that keeps the list of qualified names of subprofiles to be pre-selected */
	List<String> subProfilesList;

	/**
	 * constructor
	 * 
	 * @param model
	 *        of the profile
	 * @param parent
	 *        the shell
	 */
	public ProfileTreeSelectionDialog(Shell parent, Package model) {
		super(parent, model);
		subSelection = true;
		subProfilesList = new ArrayList<String>();
	}

	/**
	 * constructor
	 * 
	 * @param model
	 *        of the profile
	 * @param parent
	 *        the shell
	 */
	public ProfileTreeSelectionDialog(Shell parent, List<Package> model) {
		this(parent, model, new ArrayList<String>());
		subSelection = true;
	}

	/**
	 * constructor
	 * 
	 * @param model
	 *        of the profile
	 * @param parent
	 *        the shell
	 * @param
	 */
	public ProfileTreeSelectionDialog(Shell parent, List<Package> model, List<String> subprofiles) {
		super(parent, model);
		subSelection = true;
		subProfilesList = subprofiles;
	}


	/**
	 * Returns the elements to import.
	 * 
	 * @return a list of profile even, hte user selects a package
	 */
	public ArrayList getResult() {
		ArrayList<Profile> profileList = new ArrayList<Profile>();
		Iterator<Element> iter = elementsToImport.iterator();
		while(iter.hasNext()) {
			Element currentElement = (Element)iter.next();
			if(currentElement instanceof Profile) {
				final Profile profile = (Profile) currentElement;
				profileList.add(profile);
			}
		}
		return profileList;
	}
	
	/**
	 * Gets the selected profiles that are valid.
	 * @return the list of profiles that the user selected and that were validated. 
	 */
	public ArrayList<Profile> getValidResult(){
		final ArrayList<Profile> invalidProfiles = new ArrayList<Profile>();
		final ArrayList<Profile> validProfiles = new ArrayList<Profile>();

		if (! elementsToImport.isEmpty()){
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(elementsToImport.get(0));
			
			//Command used for the validation of the profile.
			AbstractTransactionalCommand validationCommand = new AbstractTransactionalCommand( (TransactionalEditingDomain)editingDomain, "Profile validation", null) {
				
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					
					Iterator<Element> iterator = elementsToImport.iterator();
					while(iterator.hasNext()) {
						Element element = (Element) iterator.next();
						if (element instanceof Profile){
							Profile profile = (Profile) element;
							EPackage ePackage = profile.getDefinition();
							//Validating the ePackage of the profile.
							Diagnostician diagnostician = new Diagnostician();
							Diagnostic diagnostic = diagnostician.validate(ePackage);
							
							//Applying the profile only if it has been validated.
							if (diagnostic.getSeverity() != diagnostic.ERROR){
								validProfiles.add(profile);
							} else {
								invalidProfiles.add(profile);
								Activator.logError(diagnostic.toString());
							}
						};
					}
					return CommandResult.newOKCommandResult();
				}
			};
			editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(validationCommand));
			
			if (!invalidProfiles.isEmpty()){
				//Notifying the user about the invalid profiles.
				StringBuilder message = new StringBuilder("<form><p>The following profiles are invalid : </p>"); //$NON-NLS-1$
				
				Iterator<Profile> iterator = invalidProfiles.iterator();
				while (iterator.hasNext()){
					message.append("<p> - "); //$NON-NLS-1$
					Profile profile = (Profile) iterator.next();
					String profileLabel = profile.getLabel();
					message.append(profileLabel);
					message.append("</p>"); //$NON-NLS-1$

				}
				message.append("<p>These profiles were removed from the list of selected profiles, " +
						"and should be corrected and validated before they are applied. </p></form>"); //$NON-NLS-1$
				String text = message.toString();
				new NotificationBuilder().setAsynchronous(false).setTemporary(false).setHTML(true).setMessage(text).setType(Type.WARNING).run();
			}
		}
		return validProfiles;
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.dialogs.ElementImportTreeSelectionDialog#buildImportTreeList(org.eclipse.swt.widgets.TreeItem,
	 * org.eclipse.uml2.uml.Package)
	 */
	/**
	 * 
	 * 
	 * @param _package
	 * @param elemTree
	 */
	protected void buildImportTreeList(TreeItem elemTree, Package _package) {
		Iterator elemIter = _package.getPackagedElements().iterator();
		while(elemIter.hasNext()) {
			Element elem = (Element)elemIter.next();
			if(elem instanceof Profile) {
				TreeItem item = new TreeItem(elemTree, SWT.NONE);
				item.setText(((Package)elem).getName());
				item.setData(elem);
				item.setImage(IMG_PROFILE);
				// test if the element is in the list of pre selected profiles. If yes, it checks the item
				String name = ((Profile)elem).getQualifiedName();
				if(name != null) {
					if(subProfilesList.contains(name)) {
						item.setChecked(true);
						elementsToImport.add(elem);
					}
				}
				buildImportTreeList(item, (Package)elem);
			} else if(elem instanceof Package) {
				TreeItem item = new TreeItem(elemTree, SWT.NONE);
				item.setText(((Package)elem).getName());
				item.setData(elem);
				item.setImage(IMG_PACKAGE);
				buildImportTreeList(item, (Package)elem);
			}
		}
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Choose profile(s) to apply");
	}

}
