/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *		Vincent Lorenzo (CEA LIST) - Add a list for the compartment names 
 *****************************************************************************/
package org.eclipse.papyrus.preferences.pages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.preferences.ui.BackgroundColor;
import org.eclipse.papyrus.preferences.ui.DecorationGroup;
import org.eclipse.papyrus.preferences.ui.NodeColorGroup;
import org.eclipse.papyrus.preferences.ui.NodeCompartmentGroup;
import org.eclipse.swt.widgets.Composite;

/**
 * An abstract implementation of a basic node preference page.
 * <p>
 * This Preference page adds the preference for {@link org.eclipse.gmf.runtime.notation.FillStyle#getFillColor() <em>FillColor</em>}
 * </p>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusNodePreferencePage extends AbstractPapyrusElementPreferencePage {

	/** the list owning the compartment names for the Node */
	protected List<String> compartmentsList;

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public AbstractPapyrusNodePreferencePage() {
		compartmentsList = new ArrayList<String>();
		initializeCompartmentsList();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.preferences.pages.AbstractPapyrusElementPreferencePage#createPageContents(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		NodeColorGroup colorGroupForNodeComposite = new NodeColorGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(colorGroupForNodeComposite);
		BackgroundColor backgroundColorGroup = new BackgroundColor(parent, getPreferenceKey(), this);
		addAbstractGroup(backgroundColorGroup);
		DecorationGroup decorationGroup = new DecorationGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(decorationGroup);
		if(!compartmentsList.isEmpty()) {
			NodeCompartmentGroup compartmentGroup = new NodeCompartmentGroup(parent, getPreferenceKey(), this, compartmentsList, getPreferenceStore());
			addAbstractGroup(compartmentGroup);
		}
	}

	/**
	 * Initialize {@link #compartmentsList} with the name of the compartment owned by the node
	 */
	protected void initializeCompartmentsList() {
		// TODO Auto-generated method stub	
	}

}
