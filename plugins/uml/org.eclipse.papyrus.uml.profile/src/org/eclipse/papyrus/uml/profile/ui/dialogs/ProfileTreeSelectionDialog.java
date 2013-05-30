/*****************************************************************************
 * Copyright (c) 2008, 2013 CEA LIST.
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
 *  Christian W. Damus (CEA) - Refactoring package/profile import/apply UI for CDO
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Profile;

/**
 * this is dialog that display all profiles and package in a tree view
 */
public class ProfileTreeSelectionDialog extends ElementImportTreeSelectionDialog<Profile> {

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
		this(parent, Collections.singletonList(model));
	}

	/**
	 * constructor
	 * 
	 * @param model
	 *        of the profile
	 * @param parent
	 *        the shell
	 */
	public ProfileTreeSelectionDialog(Shell parent, Collection<Package> model) {
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
	public ProfileTreeSelectionDialog(Shell parent, Collection<Package> model, List<String> subprofiles) {
		super(parent, ImportAction.APPLY, Profile.class, model);
		subSelection = true;
		subProfilesList = subprofiles;
	}


	/**
	 * Returns the elements to import.
	 * 
	 * @return a list of profile even if the user selects a package
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Collection<ImportSpec<Profile>> getResult() {
		List<ImportSpec<Profile>> result = new ArrayList<ImportSpec<Profile>>();
		Iterator<? extends ImportSpec<? extends Package>> iter = elementsToImport.iterator();
		while(iter.hasNext()) {
			ImportSpec<? extends Package> currentElement = iter.next();
			if(currentElement.getElement() instanceof Profile) {
				result.add((ImportSpec<Profile>)currentElement);
			}
		}
		return result;
	}

	@Override
	protected Collection<? extends Element> getChildren(Package package_) {
		Collection<Package> result = new java.util.ArrayList<Package>();

		Iterator<PackageableElement> elemIter = package_.getPackagedElements().iterator();
		while(elemIter.hasNext()) {
			Element elem = elemIter.next();
			if(elem instanceof Package) {
				result.add((Package)elem);
			}
		}

		return result;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Choose profile(s) to apply");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite result = (Composite)super.createDialogArea(parent);

		Composite buttons = new Composite(result, SWT.NONE);
		buttons.setLayout(new RowLayout());

		Button selectAll = new Button(buttons, SWT.PUSH);
		selectAll.setText("Select All");
		selectAll.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				selectAll(ImportAction.APPLY);
			}
		});

		Button deselectAll = new Button(buttons, SWT.PUSH);
		deselectAll.setText("Deselect All");
		deselectAll.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				selectAll(ImportAction.NONE);
			}
		});

		// set initial sub-profile selections
		for(Iterator<?> iter = EcoreUtil.getAllContents(packages); iter.hasNext();) {
			Object next = iter.next();
			if(next instanceof Profile) {
				Profile profile = (Profile)next;
				String name = profile.getQualifiedName();
				if((name != null) && subProfilesList.contains(name)) {
					setInitialSelection(profile);
				}
			}
		}

		return result;
	}
}
