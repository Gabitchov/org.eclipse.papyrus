/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
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

package org.eclipse.papyrus.preferences.ui;

import java.util.List;

import org.eclipse.gmf.runtime.common.ui.preferences.CheckBoxFieldEditor;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * The Class NodeCompartmentGroup contains field editor to manage the display of the compartment
 */
public class NodeCompartmentGroup extends AbstractGroup {

	/** the list owning the compartment names for the UML element */
	private List<String> compartmentsName = null;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param title
	 * @param dialogPage
	 * @param compartmentsName
	 */
	public NodeCompartmentGroup(Composite parent, String title, DialogPage dialogPage, List<String> compartmentsName) {
		super(parent, title, dialogPage);
		this.compartmentsName = compartmentsName;
		createContent(parent);
	}

	/**
	 * create the content.
	 * 
	 * @param parent
	 *        : the parent composite
	 */
	protected void createContent(Composite parent) {
		addCompartmentVisibilityGroup(parent);
	}

	private void addCompartmentVisibilityGroup(Composite parent) {
		if(compartmentsName.isEmpty()) {
			return;
		}
		Group compartmentGroup = new Group(parent, 2);
		compartmentGroup.setLayout(new GridLayout());
		compartmentGroup.setText(Messages.NodeCompartmentGroup_Compartiments);
		for(String compartmentName : compartmentsName) {
			addShowCompartmentField(compartmentGroup, compartmentName);
			addShowNameOfCompartmentField(compartmentGroup, compartmentName);
		}
	}

	protected void addShowCompartmentField(Group compartmentGroup, String name) {
		String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
		BooleanFieldEditor compartmentVisibilityBooleanFieldEditor = new BooleanFieldEditor(compartmentVisibilityPreference, name, compartmentGroup);
		compartmentVisibilityBooleanFieldEditor.setPage(this.dialogPage);
		addFieldEditor(compartmentVisibilityBooleanFieldEditor);
	}

	protected void addShowNameOfCompartmentField(Group compartmentGroup, String compartmentName) {
		String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
		String label = "Show name";
		CheckBoxFieldEditor compartmentVisibilityBooleanFieldEditor = new CheckBoxFieldEditor(compartmentVisibilityPreference, label, compartmentGroup);
		indent(compartmentVisibilityBooleanFieldEditor.getCheckbox());
		compartmentVisibilityBooleanFieldEditor.setPage(this.dialogPage);
		addFieldEditor(compartmentVisibilityBooleanFieldEditor);
	}

	//	private void createDependency(final Button master, Preference preference, final Control[] slaves) {
	//		indent(slaves[0]);
	//
	//		boolean masterState= fOverlayStore.getBoolean(preference.getKey());
	//		for (int i= 0; i < slaves.length; i++) {
	//			slaves[i].setEnabled(masterState);
	//		}
	//
	//		SelectionListener listener= new SelectionListener() {
	//			public void widgetSelected(SelectionEvent e) {
	//				boolean state= master.getSelection();
	//				for (int i= 0; i < slaves.length; i++) {
	//					slaves[i].setEnabled(state);
	//				}
	//			}
	//
	//			public void widgetDefaultSelected(SelectionEvent e) {}
	//		};
	//		master.addSelectionListener(listener);
	//		fMasterSlaveListeners.add(listener);
	//	}

	private static void indent(Control control) {
		GridData gridData = new GridData();
		gridData.horizontalIndent = 20;
		control.setLayoutData(gridData);
	}

}
