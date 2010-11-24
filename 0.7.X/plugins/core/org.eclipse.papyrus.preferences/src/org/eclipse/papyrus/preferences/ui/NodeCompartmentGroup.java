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
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
		for(String compartmentName : compartmentsName) {
			Group compartmentGroup = new Group(parent, 2);
			compartmentGroup.setLayout(new GridLayout(2, true));
			compartmentGroup.setText(compartmentName);

			Button showCompartment = addShowCompartmentField(compartmentGroup, compartmentName);
			Button showName = addShowNameOfCompartmentField(compartmentGroup, compartmentName);
			createDependency(showCompartment, new Control[]{showName});
		}
	}

	protected Button addShowCompartmentField(Group compartmentGroup, String name) {
		String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
		String label = "Show compartment";
		CheckBoxFieldEditor compartmentVisibilityBooleanFieldEditor = new CheckBoxFieldEditor(compartmentVisibilityPreference, label, compartmentGroup);
		Button checkbox = compartmentVisibilityBooleanFieldEditor.getCheckbox();
		indent(checkbox);
		compartmentVisibilityBooleanFieldEditor.setPage(getDialogPage());
		addFieldEditor(compartmentVisibilityBooleanFieldEditor);
		return checkbox;
	}

	protected Button addShowNameOfCompartmentField(Group compartmentGroup, String compartmentName) {
		String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
		String label = "Show name";
		CheckBoxFieldEditor compartmentNameVisibilityFieldEditor = new CheckBoxFieldEditor(compartmentVisibilityPreference, label, compartmentGroup);
		Button checkbox = compartmentNameVisibilityFieldEditor.getCheckbox();
		indent(checkbox);
		compartmentNameVisibilityFieldEditor.setPage(getDialogPage());
		addFieldEditor(compartmentNameVisibilityFieldEditor);
		return checkbox;
	}

	private void createDependency(final Button master, final Control[] slaves) {

//		for(int i = 0; i < slaves.length; i++) {
//			slaves[i].setEnabled(masterState);
//		}

		SelectionListener listener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				boolean state = master.getSelection();
				for(int i = 0; i < slaves.length; i++) {
					slaves[i].setEnabled(state);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		master.addSelectionListener(listener);
	}

	private static void indent(Control control) {
		GridData gridData = new GridData();
		control.setLayoutData(gridData);
	}

}
