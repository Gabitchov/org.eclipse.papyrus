/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * CEA LIST- Initial API and implementation
 * Nizar GUEDIDI (CEA LIST)- modification
 *
 ****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.eclipse.papyrus.infra.gmfdiag.preferences.pages.AbstractPapyrusLinkPreferencePage;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.OrderedLabelGroup;
import org.eclipse.papyrus.sysml.diagram.requirement.Activator;
import org.eclipse.swt.widgets.Composite;

public class RequirementDiagramLinkPreferencePage extends AbstractPapyrusLinkPreferencePage {

	/** The list of label names for this link */
	protected List<String> labelsList;

	/** Constructor */
	public RequirementDiagramLinkPreferencePage() {
		labelsList = new ArrayList<String>();
		initializeLabelsList();
		Collections.unmodifiableList(labelsList);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected final TreeMap<String, String> getLabelRole() {
		return new TreeMap<String, String>();
	}
}
