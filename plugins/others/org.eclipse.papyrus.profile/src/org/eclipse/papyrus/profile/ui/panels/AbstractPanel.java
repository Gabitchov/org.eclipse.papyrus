/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.panels;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

// TODO: Auto-generated Javadoc
/**
 * Abstract panel for the Accord/UML view.<br>
 * 
 * @author Remi SCHNEKENBURGER
 */
public abstract class AbstractPanel extends Composite {

	/**
	 * The Constant WARNING_IMAGE.
	 */
	protected static final String WARNING_IMAGE = "resources/icons/warning.gif";

	/**
	 * Default constructor.
	 * 
	 * @param style the style of this composite
	 * @param parent the parent of this composite
	 */
	public AbstractPanel(Composite parent, int style) {
		super(parent, style);

	}

	/**
	 * Creates the content for this panel, and returns its Control.
	 * 
	 * @return the Control for this panel
	 */
	public abstract Control createContent();

	/**
	 * Action executed just after the panel is created for the specific element.
	 */
	public void entryAction() {
		// do nothing
	}

	/**
	 * Action executed just before moving to the new element.
	 */
	public void exitAction() {
		// do nothing
	}
	
	/**
	 * Refresh panel.
	 */
	public void refresh() {
		
	}
}