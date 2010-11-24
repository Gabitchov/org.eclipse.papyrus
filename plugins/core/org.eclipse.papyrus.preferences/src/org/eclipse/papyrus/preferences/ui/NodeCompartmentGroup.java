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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.SWT;
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
	private final List<String> myCompartments;

	private final IPreferenceStore myPreferenceStore;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param title
	 * @param dialogPage
	 * @param compartmentsName
	 */
	public NodeCompartmentGroup(Composite parent, String title, DialogPage dialogPage, List<String> compartmentsName, IPreferenceStore store) {
		super(parent, title, dialogPage);
		this.myCompartments = compartmentsName;
		myPreferenceStore = store;
		createContent(parent);
	}

	/**
	 * create the content.
	 * 
	 * @param parent
	 *        : the parent composite
	 */
	protected void createContent(Composite parent) {
		for(String compartment : myCompartments) {
			addCompartmentVisibilityGroup(parent, compartment);
		}
	}

	private void addCompartmentVisibilityGroup(Composite parent, String compartment) {
		// show Compartment Visibility and CompartmentName Visibility items in the same row   
		Group group = new Group(parent, SWT.NONE);
		group.setLayout(new GridLayout(2, true));
		group.setText(compartment);

		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 2;
		group.setLayoutData(gridData);

		Button showCompartment = addShowCompartmentField(group, compartment);
		Button showName = addShowNameOfCompartmentField(group, compartment);
		createDependency(showCompartment, new Control[]{ showName });
	}

	protected Button addShowCompartmentField(Composite parent, String name) {
		String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
		String label = "Show compartment";
		return addCheckboxField(parent, compartmentVisibilityPreference, label);
	}

	protected Button addShowNameOfCompartmentField(Composite parent, String compartmentName) {
		String compartmentNameVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
		String label = "Show name";
		Button checkbox = addCheckboxField(parent, compartmentNameVisibilityPreference, label);

		String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), compartmentName, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
		boolean showCompartmentIsNotChecked = !myPreferenceStore.getBoolean(compartmentVisibilityPreference);
		if(showCompartmentIsNotChecked) {
			checkbox.setEnabled(false);
		}

		return checkbox;
	}

	private Button addCheckboxField(Composite parent, String preferenceKey, String label) {
		// show Compartment Visibility and CompartmentName Visibility items in the same row   
		// as CheckBoxFieldEditor resets layout data to fit the grid we create this stub plate 
		// @see #doFillIntoGrid 
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayoutData(new GridData());

		CheckBoxFieldEditor compartmentVisibilityBooleanFieldEditor = new CheckBoxFieldEditor(preferenceKey, label, plate);
		Button checkbox = compartmentVisibilityBooleanFieldEditor.getCheckbox();
		compartmentVisibilityBooleanFieldEditor.setPage(getDialogPage());
		addFieldEditor(compartmentVisibilityBooleanFieldEditor);
		return checkbox;
	}

	private void createDependency(final Button master, final Control[] slaves) {
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


}
