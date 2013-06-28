/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.domain.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusNodePreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.OrderedCompartmentGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.OrderedLabelGroup;
import org.eclipse.papyrus.uml.diagram.domain.Activator;
import org.eclipse.swt.widgets.Composite;

public class DomainDiagramNodePreferencePage extends AbstractPapyrusNodePreferencePage {

	/** The list owning the names of compartments */
	protected List<String> compartmentNamesList;

	/** The list owning the names of compartment that have a title */
	protected List<String> compartmentTitlesList;

	/** The list of label names for this node */
	protected List<String> labelsList;

	/** Constructor */
	public DomainDiagramNodePreferencePage() {
		this.labelsList = new ArrayList<String>();
		this.compartmentNamesList = new ArrayList<String>();
		this.compartmentTitlesList = new ArrayList<String>();

		initializeLabelsList();
		initializeCompartmentNamesList();
		initializeCompartmentTitlesList();

		Collections.unmodifiableList(labelsList);
		Collections.unmodifiableList(compartmentNamesList);
		Collections.unmodifiableList(compartmentTitlesList);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

		// Add compartments visibility group
		if(!compartmentNamesList.isEmpty()) {
			OrderedCompartmentGroup compartmentGroup = new OrderedCompartmentGroup(parent, getPreferenceKey(), this, compartmentNamesList, compartmentTitlesList, getPreferenceStore());
			addAbstractGroup(compartmentGroup);
		}

		// Add label visibility group
		if(!labelsList.isEmpty()) {
			OrderedLabelGroup compartmentGroup = new OrderedLabelGroup(parent, getPreferenceKey(), this, labelsList);
			addAbstractGroup(compartmentGroup);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getBundleId() {
		return Activator.PLUGIN_ID;
	}

	/** Initialize the list containing names of labels. */
	protected void initializeLabelsList() {
		//  Implemented by subclasses.
	}

	/** Initialize the list containing the names of compartments. */
	protected void initializeCompartmentNamesList() {
		//  Implemented by subclasses.
	}

	/** Initialize the list containing the names of compartment that have titles. */
	protected void initializeCompartmentTitlesList() {
		//  Implemented by subclasses.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final TreeMap<String, String> getLabelRole() {
		return new TreeMap<String, String>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final TreeMap<String, Boolean> getCompartmentTitleVisibilityPreferences() {
		return new TreeMap<String, Boolean>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final void initializeCompartmentsList() {
		compartmentsList = Collections.emptyList();
	}
}
