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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.configuration;

import org.eclipse.nebula.widgets.nattable.config.AbstractUiBindingConfiguration;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.swt.SWT;

/**
 * The configuration for the popup to use in the header of the table
 * 
 * Adapted code from AbstractHeaderMenuConfiguration
 * 
 * @author vl222926
 * 
 */
public class PapyrusHeaderMenuConfiguration extends AbstractUiBindingConfiguration {

	/**
	 * the category used for the column command
	 */
	public static final String COLUMN_COMMANDS_CATEGORY_ID = "org.eclipse.papyrus.infra.nattable.columns.command.category"; //$NON-NLS-1$

	/**
	 * the category used for the row command
	 */
	public static final String ROW_COMMANDS_CATEGORY_ID = "org.eclipse.papyrus.infra.nattable.rows.command.category"; //$NON-NLS-1$


	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.config.IConfiguration#configureUiBindings(org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry)
	 * 
	 * @param uiBindingRegistry
	 */
	@Override
	public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
		uiBindingRegistry.registerMouseDownBinding(new MouseEventMatcher(SWT.NONE, GridRegion.COLUMN_HEADER, MouseEventMatcher.RIGHT_BUTTON), new PapyrusPopupMenuAction(COLUMN_COMMANDS_CATEGORY_ID));
		uiBindingRegistry.registerMouseDownBinding(new MouseEventMatcher(SWT.NONE, GridRegion.ROW_HEADER, MouseEventMatcher.RIGHT_BUTTON), new PapyrusPopupMenuAction(ROW_COMMANDS_CATEGORY_ID));

	}
}
