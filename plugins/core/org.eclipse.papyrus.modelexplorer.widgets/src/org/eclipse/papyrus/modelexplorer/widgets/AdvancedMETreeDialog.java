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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Added a lighter constructor
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.widgets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * this dialog box has the possibility to select by the user interface the kind of wanted meta-class.
 * 
 */
public class AdvancedMETreeDialog extends ModelExplorerBasedTreeSelectorDialog {

	protected Label metaclassLabel = null;

	protected Combo combo;

	protected EPackage metaModel;

	protected ArrayList<Object> metaclasses = new ArrayList<Object>();

	/**
	 * 
	 * Constructor to display this dialog
	 * 
	 * @param parentShell
	 *        a shell
	 * @param root
	 *        the Eobject that will be the root of the Tree, it can be null
	 * @param wantedEClass
	 *        , in order to filter the tree by taking in account only this kind of object
	 * @param metaClassNotWanted
	 *        the list of not wanted object (to be pertinent, it has to be a subclass of wantedEclass
	 * @param metaModel
	 *        an Epackage that represent the domain model
	 */
	public AdvancedMETreeDialog(Shell parentShell, EObject root, Object wantedEClass, List<Object> metaClassNotWanted, EPackage metaModel) {
		super(parentShell, root, wantedEClass, metaClassNotWanted);
		this.metaModel = metaModel;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parentShell
	 *        a shell
	 * @param metaModel
	 *        an Epackage that represent the domain model
	 */
	public AdvancedMETreeDialog(Shell parentShell, EPackage metaModel) {
		super(parentShell);
		this.metaModel = metaModel;
	}

	@Override
	public void create() {
		super.create();
		//install labels
		metaclassLabel = new Label(getDialogArea(), SWT.WRAP);
		metaclassLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		metaclassLabel.setText("Metaclass:");
		setDescription("Look for " + metaclassLabelProvider.getText(contentProvider.getMetaClassWanted()));

		//install combo
		combo = new Combo(getDialogArea(), SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		combo.addSelectionListener(new SelectionListener() {

			//creation of inner class for the selection
			public void widgetSelected(SelectionEvent e) {
				//look for the new wantedEClass
				int index = combo.getSelectionIndex();
				contentProvider.setMetaClassWanted(metaclasses.get(index));
				setDescription("Look for " + metaclassLabelProvider.getText(contentProvider.getMetaClassWanted()));
				contentProvider.setMetaClassNotWanted(new ArrayList<Object>());
				if(getViewer() != null) {
					getViewer().refresh();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		fillmetaclassList(metaModel);
		fillMetaclassCombo(metaclasses, new EclassComparator());
		getShell().pack();


	}

	/**
	 * Put into the list metaclasses all element from the Epackage
	 * border effect the list metaclasses is filled
	 * 
	 * @param ePackage
	 *        that represent the domain model
	 */
	protected void fillmetaclassList(EPackage ePackage) {
		metaclasses.clear();
		for(Iterator<EObject> iterator = ePackage.eContents().iterator(); iterator.hasNext();) {
			EObject type = iterator.next();
			if(type instanceof EClass) {
				metaclasses.add(type);
			}
		}
	}

	/**
	 * take in account all metaclasses and fill the combo by taking account order done by the comparator.
	 * Border effect: the variable combo is filled by all element contained in the parameter metaclasses
	 * 
	 * @param metaclasses
	 *        the list of metaclasses
	 * @param comparator
	 *        a comparator
	 */
	protected void fillMetaclassCombo(ArrayList<Object> metaclasses, Comparator<Object> comparator) {
		this.metaclasses = metaclasses;
		//fill the list of meta-classes
		combo.removeAll();
		Collections.sort(metaclasses, comparator);
		//fill the combo
		for(Iterator<Object> iterator = metaclasses.iterator(); iterator.hasNext();) {
			combo.add(metaclassLabelProvider.getText(iterator.next()));
		}

	}
}
