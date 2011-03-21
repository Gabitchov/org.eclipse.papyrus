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
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorerbasedwidgets;

import java.util.ArrayList;
import java.util.Collections;
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

	protected Label metaclassLabel=null;
	protected Combo combo;
	protected EPackage metaModel;
	protected ArrayList<EClass> metaclasses=new ArrayList<EClass>();

	public AdvancedMETreeDialog(Shell parentShell, EObject root, EClass wantedEClass, List<EClass> metaClassNotWanted,EPackage metaModel) {
		super(parentShell, root, wantedEClass, metaClassNotWanted);
		this.metaModel=metaModel;
	}

	@Override
	public void create() {
		super.create();
		//install labels
		metaclassLabel = new Label(getDialogArea(), SWT.WRAP);
		metaclassLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		metaclassLabel.setText("Metaclass:");
		setDescription("Look for "+contentProvider.getMetaClassWanted().getName());

		//install combo
		combo = new Combo(getDialogArea(), SWT.NONE);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		combo.addSelectionListener(new SelectionListener() {
			//creation of inner class for the selection
			public void widgetSelected(SelectionEvent e) {
				int index=combo.getSelectionIndex();
				contentProvider.setMetaClassWanted(metaclasses.get(index));
				setDescription("Look for "+contentProvider.getMetaClassWanted().getName());
				contentProvider.setMetaClassNotWanted(new ArrayList<EClass>());
				if(getViewer()!=null){
					getViewer().refresh();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		//fill the list of meta-classes
		for(Iterator<EObject> iterator = metaModel.eContents().iterator(); iterator.hasNext();) {
			EObject type = iterator.next();
			if(type instanceof EClass){
				metaclasses.add(((EClass)type));
			}
		}
		Collections.sort(metaclasses, new EclassComparator());
		//fill the combo
		for(Iterator<EClass> iterator = metaclasses.iterator(); iterator.hasNext();) {
			EClass type = (EClass)iterator.next();
			combo.add((type).getName());
		}
		getShell().pack();


	}

}
