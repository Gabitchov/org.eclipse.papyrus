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

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.papyrus.preferences.Messages;
import org.eclipse.papyrus.preferences.utils.PreferenceConstantHelper;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
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
		addCompartmentNameVisibilityGroup(parent);
	}

	private void addCompartmentVisibilityGroup(Composite parent) {
		if(!compartmentsName.isEmpty()) {
			Group compartmentGroup = new Group(parent, 2);
			compartmentGroup.setLayout(new GridLayout());
			compartmentGroup.setText(Messages.NodeCompartmentGroup_Compartiments);
			for(String name : compartmentsName) {
				String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), name, PreferenceConstantHelper.COMPARTMENT_VISIBILITY);
				BooleanFieldEditor compartmentVisibilityBooleanFieldEditor = new BooleanFieldEditor(compartmentVisibilityPreference, name, compartmentGroup);
				compartmentVisibilityBooleanFieldEditor.setPage(this.dialogPage);
				addFieldEditor(compartmentVisibilityBooleanFieldEditor);

			}
		}
	}
	
	private void addCompartmentNameVisibilityGroup(Composite parent) {
		if(compartmentsName.isEmpty()) {
			return;
		}
		Group compartmentGroup = new Group(parent, 2);
		compartmentGroup.setLayout(new GridLayout());
		compartmentGroup.setText("Show names of the compartments");
		for(String compartmentName : compartmentsName) {
			String compartmentVisibilityPreference = PreferenceConstantHelper.getCompartmentElementConstant(getKey(), compartmentName, PreferenceConstantHelper.COMPARTMENT_NAME_VISIBILITY);
			String label = compartmentName;
			BooleanFieldEditor compartmentVisibilityBooleanFieldEditor = new BooleanFieldEditor(compartmentVisibilityPreference, label, compartmentGroup);
			compartmentVisibilityBooleanFieldEditor.setPage(this.dialogPage);
			addFieldEditor(compartmentVisibilityBooleanFieldEditor);
		}

	}
}
