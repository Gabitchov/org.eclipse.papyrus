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
package com.cea.papyrus.profile.ui.composites;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * 
 */
public interface ISectionComposite {

	/**
	 * Creates the content of the Section.
	 * 
	 * @param factory the factory used to create the widgets for the section
	 * @param parent the parent of the composite for this section
	 * 
	 * @return the top level Composite of this section
	 */
	public Composite createContent(Composite parent, TabbedPropertySheetWidgetFactory factory);
	
	/**
	 * Refresh the contents of the controls displayed in this section.
	 */
	public void refresh();
	
	
}
