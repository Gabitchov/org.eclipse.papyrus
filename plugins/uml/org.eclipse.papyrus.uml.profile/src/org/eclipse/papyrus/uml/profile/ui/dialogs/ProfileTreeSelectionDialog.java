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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
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
		if( !isAValidProfile(model)){
			this.model=null;
		}
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
	 * @param testValidity true to test if profile to apply are valids       
	 */
	public ProfileTreeSelectionDialog(Shell parent, List<Package> model, boolean testValidity) {
		this(parent, model, new ArrayList<String>());
		if(testValidity){
			List<Package> modelToRemoveList= new ArrayList<Package>();
			for(Iterator<Package> iterator = model.iterator(); iterator.hasNext();) {
				Package currentPackage = (Package)iterator.next();
				if( !isAValidProfile(currentPackage)){
					modelToRemoveList.add(currentPackage);
				}

			}
			for(Iterator<Package> iterator = modelToRemoveList.iterator(); iterator.hasNext();) {
				Package currentPackage = (Package)iterator.next();
				this.models.remove(currentPackage);
			}
			if( this.models.size()==0){
				MessageDialog.openError(new Shell(), "Profiles not Valid", "Selected profiles cannot be applied because their definition are not valid");
				getShell().dispose();
			}
		}
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
				profileList.add((Profile)currentElement);
			}
		}
		return profileList;
	}

	private boolean isAValidProfile(Package profile){

		EditingDomain domain=TransactionUtil.getEditingDomain(profile);;
		AdapterFactory adapterFactory = domain instanceof AdapterFactoryEditingDomain ? ((AdapterFactoryEditingDomain)domain).getAdapterFactory() : null;
		Diagnostician diagnostician = createDiagnostician(adapterFactory, new NullProgressMonitor());
		BasicDiagnostic diagnostic = diagnostician.createDefaultDiagnostic(profile);
		Map<Object, Object> context = diagnostician.createDefaultContext();
		boolean isValid = diagnostician.validate(profile, diagnostic, context);
		int severity=diagnostic.getSeverity();
		if(severity==Diagnostic.ERROR) {return false;}
		return true;
	}

	/**
	 * create a diagnostician to evaluate a profil
	 * @param adapterFactory
	 * @param progressMonitor
	 * @return
	 */
	protected Diagnostician createDiagnostician(final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor) {
		return new Diagnostician() {

			@Override
			public String getObjectLabel(EObject eObject) {
				if(adapterFactory != null && !eObject.eIsProxy()) {
					IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
					if(itemLabelProvider != null) {
						return itemLabelProvider.getText(eObject);
					}
				}
				return super.getObjectLabel(eObject);
			}

			@Override
			public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
				progressMonitor.worked(1);
				return super.validate(eClass, eObject, diagnostics, context);
			}
		};
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
