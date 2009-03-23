/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package com.cea.papyrus.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * this is dialog that display all profiles and package  in a tree view
 */
public class ProfileTreeSelectionDialog extends ElementImportTreeSelectionDialog {
	
	/** Array that keeps the list of qualified names of subprofiles to be pre-selected */
	List<String> subProfilesList;
	
	/**
	 * constructor
	 * @param model of the profile 
	 * @param parent the shell
	 */
	public ProfileTreeSelectionDialog(Shell parent, Package model){
		super(parent, model);
		subProfilesList = new ArrayList<String>();
	}

	/**
	 * constructor
	 * @param model of the profile 
	 * @param parent the shell
	 */
	public ProfileTreeSelectionDialog(Shell parent, List<Package> model) {
		this(parent, model, new ArrayList<String>());
	}
	
	/**
	 * constructor
	 * @param model of the profile 
	 * @param parent the shell
	 * @param 
	 */
	public ProfileTreeSelectionDialog(Shell parent, List<Package> model, List<String> subprofiles) {
		super(parent, model);
		subProfilesList = subprofiles;
	}
	
	
	/**
	 * Returns the elements to import.
	 * @return a list of profile even, hte user selects a package
	 */
	public ArrayList getResult(){
		ArrayList<Profile> profileList= new ArrayList<Profile>();
		Iterator<Element> iter= elementsToImport.iterator();
		while(iter.hasNext()){
			Element currentElement= (Element) iter.next();
			if (currentElement instanceof Profile){
				profileList.add((Profile)currentElement);
			}
		}
		return profileList;
	}
	/*
	 * (non-Javadoc)
	 * @see com.cea.papyrus.ui.dialogs.ElementImportTreeSelectionDialog#buildImportTreeList(org.eclipse.swt.widgets.TreeItem, org.eclipse.uml2.uml.Package)
	 */
	/**
	 * 
	 * 
	 * @param _package 
	 * @param elemTree 
	 */
	protected void buildImportTreeList(TreeItem elemTree, Package _package){
		Iterator elemIter = _package.getPackagedElements().iterator();
		while(elemIter.hasNext()) {
			Element elem = (Element) elemIter.next();
			if(elem instanceof Profile){
				TreeItem item = new TreeItem(elemTree, SWT.NONE);
				item.setText(((Package)elem).getName());
				item.setData(elem);
				item.setImage(IMG_PROFILE);
				// test if the element is in the list of pre selected profiles. If yes, it checks the item
				String name = ((Profile)elem).getQualifiedName();
				if(name!=null) {
					if(subProfilesList.contains(name)) {
						item.setChecked(true);
						elementsToImport.add(elem);
					}
				}
				buildImportTreeList(item, (Package)elem);
			}
			else if(elem instanceof Package){
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
