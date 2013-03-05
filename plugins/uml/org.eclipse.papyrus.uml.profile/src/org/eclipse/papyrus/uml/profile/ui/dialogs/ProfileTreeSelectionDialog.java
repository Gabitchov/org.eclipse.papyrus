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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
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
		this(parent, Collections.singletonList(model), true);
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
	 * @param testValidity true to test if profile to apply are valids       
	 */
	public ProfileTreeSelectionDialog(Shell parent, Collection<Package> model, boolean testValidity) {
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
				this.packages.remove(currentPackage);
			}
			if( this.packages.size()==0){
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
	@SuppressWarnings("unchecked")
	public Collection<ImportSpec<Profile>> getResult() {
		List<ImportSpec<Profile>> result = new ArrayList<ImportSpec<Profile>>();
		Iterator<? extends ImportSpec<? extends Package>> iter = elementsToImport.iterator();
		while(iter.hasNext()) {
			ImportSpec<? extends Package> currentElement = iter.next();
			if (currentElement.getElement() instanceof Profile) {
				result.add((ImportSpec<Profile>) currentElement);
			}
		}
		return result;
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

	
	@Override
	protected Collection<? extends Element> getChildren(Package package_) {
		Collection<Package> result = new java.util.ArrayList<Package>();
		
		Iterator<PackageableElement> elemIter = package_.getPackagedElements().iterator();
		while(elemIter.hasNext()) {
			Element elem = elemIter.next();
			if (elem instanceof Package) {
				result.add((Package) elem);
			}
		}
		
		return result;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Choose profile(s) to apply");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite result = (Composite) super.createDialogArea(parent);

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
		for (Iterator<?> iter = EcoreUtil.getAllContents(packages); iter.hasNext();) {
			Object next = iter.next();
			if (next instanceof Profile) {
				Profile profile = (Profile) next;
				String name = profile.getQualifiedName();
				if ((name != null) && subProfilesList.contains(name)) {
					setInitialSelection(profile);
				}
			}
		}
		
		return result;
	}
}
