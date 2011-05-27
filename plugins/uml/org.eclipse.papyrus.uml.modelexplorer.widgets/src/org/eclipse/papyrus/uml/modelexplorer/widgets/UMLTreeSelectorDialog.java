/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Added a lighter constructor
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelexplorer.widgets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.widgets.AdvancedMETreeDialog;
import org.eclipse.papyrus.modelexplorer.widgets.EclassComparator;
import org.eclipse.papyrus.modelexplorer.widgets.HierarchicViewerFilter;
import org.eclipse.papyrus.modelexplorer.widgets.MetaclassLabelProvider;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.ModelUtils;
import org.eclipse.papyrus.resource.uml.UmlModel;
import org.eclipse.papyrus.resource.uml.UmlUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this dialog box display a Tree dialog by using the model explorer and propose to filter by taking in account metaclasses of UML, or
 * stereotypes of applied profiles
 * 
 */
public class UMLTreeSelectorDialog extends AdvancedMETreeDialog {

	//display of UML domain model
	protected static final String UML = "UML";

	//the list of applied profiles
	protected HashSet<Profile> appliedProfiles = null;

	//the combo that show metamodels and profiles
	protected Combo comboMetamodel;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        a shell
	 * @param root
	 *        the root element that can be display at the top of the tree, can be null
	 * @param wantedEClass
	 *        the object use to filter in the tree all object that are instance of wantedEclasse
	 *        it can be stereotype of Eclass (can be null)
	 * 
	 * @param metaClassNotWanted
	 *        list of not wanted metaclass or stereotypes (can be null)
	 */
	public UMLTreeSelectorDialog(Shell parentShell, EObject editedEObject, EStructuralFeature feature, EObject root, EClass wantedEClass, List<Object> metaClassNotWanted) {
		super(parentShell, root, wantedEClass, metaClassNotWanted, UMLPackage.eINSTANCE);
		init(editedEObject, feature, root, wantedEClass, metaClassNotWanted);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        a shell
	 */
	public UMLTreeSelectorDialog(Shell parentShell) {
		super(parentShell, UMLPackage.eINSTANCE);
	}

	/**
	 * Sets the preferences for initializing this Dialog's ContentProvider.
	 * 
	 * @param root
	 *        the root element that can be display at the top of the tree, can be null
	 * @param wantedEClass
	 *        the object use to filter in the tree all object that are instance of wantedEclasse
	 *        it can be stereotype of Eclass (can be null)
	 * @param metaClassNotWanted
	 *        list of not wanted metaclass or stereotypes (can be null)
	 */
	public void init(EObject editedEObject, EStructuralFeature feature, EObject root, EClass wantedEClass, List<Object> metaClassNotWanted) {
		super.init(root, wantedEClass, metaClassNotWanted);
		contentProvider = new ServiceEditFilteredUMLContentProvider(editedEObject, feature, root);
		//		contentProvider = new UMLElementMEBContentProvider(root);
		contentProvider.setMetaClassWanted(wantedEClass);
		contentProvider.setMetaClassNotWanted(metaClassNotWanted);
		appliedProfiles = getAppliedProfile();
	}

	@Override
	public void create() {
		super.create();
		//create the label
		Label metamodelLabel = new Label(getDialogArea(), SWT.WRAP);
		metamodelLabel.setText("Metamodel:");
		//create the combo
		comboMetamodel = new Combo(getDialogArea(), SWT.NONE);
		comboMetamodel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		//fill the combo for domain model
		final ArrayList<Profile> profiles = new ArrayList<Profile>();
		profiles.addAll(appliedProfiles);
		Collections.sort(profiles, new NamedElementComparator());
		for(Iterator<Profile> iterator = profiles.iterator(); iterator.hasNext();) {
			Profile profile = iterator.next();
			comboMetamodel.add(profile.getQualifiedName());
		}
		comboMetamodel.add(UML);

		comboMetamodel.addSelectionListener(new SelectionListener() {

			//creation of inner class for the selection
			public void widgetSelected(SelectionEvent e) {
				//  a metamodel has been choosen, we have to update the list of metaclass or stereotypes
				int index = comboMetamodel.getSelectionIndex();
				//in the case of UML this is management by using EClass
				if(comboMetamodel.getItem(index).equals(UML)) {
					fillmetaclassList(UMLPackage.eINSTANCE);
					setMetaclassLabelProvider(new MetaclassLabelProvider());
					fillMetaclassCombo(metaclasses, new EclassComparator());
				} else {
					//in the case of profile, this a uml specific management due to stereotypes
					Profile selectedProfile = profiles.get(index);
					ArrayList<Object> stereotypesList = new ArrayList<Object>(selectedProfile.getOwnedStereotypes());
					setMetaclassLabelProvider(new StereotypeMetaclassLabelProvider());
					fillMetaclassCombo(stereotypesList, new NamedElementComparator());

				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		ViewerFilter[] filters = { new UMLHierarchicViewerFilter(contentProvider) };
		getViewer().setFilters(filters);
		getShell().pack();


	}

	/**
	 * 
	 * @return all profile without doublon. it is never null
	 * 
	 * @throws ServiceException
	 */
	protected HashSet<Profile> getAppliedProfile() {
		HashSet<Profile> profileList = new HashSet<Profile>();
		//a root has been given.
		if(root != null && root instanceof Package) {
			profileList.addAll(((Package)root).getAllAppliedProfiles());
			return profileList;

		}
		//look for from contentprovider
		ServicesRegistry servicesRegistry = EditorUtils.getMultiDiagramEditor().getServicesRegistry();
		if(servicesRegistry != null) {
			UmlModel umlModel = null;
			try {
				ModelSet modelSet = ModelUtils.getModelSetChecked(servicesRegistry);
				umlModel = (UmlUtils.getUmlModel(modelSet));

			} catch (Exception e) {
				Activator.log.error("Cannot succeed to access to modelSet by using service Registry", e);
			}
			if(umlModel == null) {
				return profileList;
			}
			EList<EObject> contents = umlModel.getResource().getContents();
			Iterator<EObject> iterator = contents.iterator();
			while(iterator.hasNext()) {
				EObject eObject = iterator.next();
				if(eObject instanceof Package) {
					profileList.addAll(((Package)eObject).getAllAppliedProfiles());
				}
			}
		}
		return profileList;
	}

}
