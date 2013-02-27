/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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

import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.nebula.widgets.nattable.config.AbstractRegistryConfiguration;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.ui.action.IMouseAction;
import org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry;
import org.eclipse.nebula.widgets.nattable.ui.matcher.MouseEventMatcher;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.swt.events.MouseEvent;

/**
 * 
 * This configuration allows to invert axis clicking on the top left corner of the table
 * 
 */
public class InvertAxisOnCornerConfiguration extends AbstractRegistryConfiguration {

	/**
	 * the manager of the table
	 */
	private INattableModelManager manager;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param manager
	 *        the manager of the table
	 */
	public InvertAxisOnCornerConfiguration(final INattableModelManager manager) {
		this.manager = manager;
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.config.AbstractRegistryConfiguration#configureUiBindings(org.eclipse.nebula.widgets.nattable.ui.binding.UiBindingRegistry)
	 * 
	 * @param uiBindingRegistry
	 */
	@Override
	public void configureUiBindings(UiBindingRegistry uiBindingRegistry) {
		super.configureUiBindings(uiBindingRegistry);
		uiBindingRegistry.registerSingleClickBinding(new MouseEventMatcher(GridRegion.CORNER), new IMouseAction() {

			@Override
			public void run(final NatTable natTable, final MouseEvent event) {
				manager.invertAxis();
			}
		});
	}

	/**
	 * 
	 * @see org.eclipse.nebula.widgets.nattable.config.IConfiguration#configureRegistry(org.eclipse.nebula.widgets.nattable.config.IConfigRegistry)
	 * 
	 * @param configRegistry
	 */
	@Override
	public void configureRegistry(IConfigRegistry configRegistry) {
		//nothing to do
	}


}
