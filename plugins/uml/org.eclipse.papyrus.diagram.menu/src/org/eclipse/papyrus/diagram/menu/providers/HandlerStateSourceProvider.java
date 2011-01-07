/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.diagram.menu.providers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.papyrus.diagram.common.providers.AbstractActionStateSourceProvider;
import org.eclipse.papyrus.diagram.menu.actions.handlers.CopyAppearancePropertiesHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.RecalculatePageBreaksHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ShowHideCompartmentHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ShowHideContentsHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.SnapToGridHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.SortFilterCompartmentItemsHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ViewGridHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ViewPageBreaksHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ViewRulersHandler;
import org.eclipse.ui.ISources;

/**
 * This class provides the state of the Handlers. It's used to refresh
 * the status of these Handlers in the menu. (in toolbar and popup, it's not needed)
 * 
 * To get the status, we listen the selection service AND the part service!
 * The part service is used to know if the selection is in the Model Explorer or not!
 * When the selection is not in the model explorer, the handlers listening the variable need to be disabled
 */
public class HandlerStateSourceProvider extends AbstractActionStateSourceProvider {

	/**
	 * The names of the variable to check.
	 */
	public static final String SHOW_HIDE_CONTENTS = "showHideContents"; //$NON-NLS-1$

	public static final String SHOW_HIDE_COMPARTMENTS = "showHideCompartments"; //$NON-NLS-1$

	public static final String COPY_APPEARANCE_PROPERTIES = "copyAppearanceProperties";//$NON-NLS-1$

	public static final String GRID = "grid";//$NON-NLS-1$

	public static final String RULERS = "rulers";//$NON-NLS-1$

	public static final String PAGE_BREAKS = "pageBreaks";//$NON-NLS-1$

	public static final String RECALCULATE_PAGE_BREAKS = "recalculatePageBreaks";//$NON-NLS-1$

	public static final String SNAP_TO_GRID = "snapToGrid";//$NON-NLS-1$

	public static final String SORT_FILTER_COMPARTMENT_ITEMS = "sortFilterCompartmentItems";


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public HandlerStateSourceProvider() {
		super();
		currentState.put(SHOW_HIDE_CONTENTS, DISABLED);
		currentState.put(SHOW_HIDE_COMPARTMENTS, DISABLED);
		currentState.put(COPY_APPEARANCE_PROPERTIES, DISABLED);
		currentState.put(GRID, DISABLED);
		currentState.put(RULERS, DISABLED);
		currentState.put(PAGE_BREAKS, DISABLED);
		currentState.put(RECALCULATE_PAGE_BREAKS, DISABLED);
		currentState.put(SNAP_TO_GRID, DISABLED);
		currentState.put(SORT_FILTER_COMPARTMENT_ITEMS, DISABLED);
	}


	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getProvidedSourceNames()
	 * 
	 * @return
	 */
	@Override
	public String[] getProvidedSourceNames() {
		return new String[]{ SHOW_HIDE_CONTENTS, SHOW_HIDE_COMPARTMENTS, COPY_APPEARANCE_PROPERTIES, GRID, RULERS, PAGE_BREAKS, RECALCULATE_PAGE_BREAKS, SNAP_TO_GRID };
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.providers.AbstractActionStateSourceProvider#refreshActions()
	 * 
	 */
	@Override
	protected void refreshActions() {
		refresh(SHOW_HIDE_CONTENTS, new ShowHideContentsHandler());
		refresh(SHOW_HIDE_COMPARTMENTS, new ShowHideCompartmentHandler());
		refresh(COPY_APPEARANCE_PROPERTIES, new CopyAppearancePropertiesHandler());
		refresh(GRID, new ViewGridHandler());
		refresh(RULERS, new ViewRulersHandler());
		refresh(PAGE_BREAKS, new ViewPageBreaksHandler());
		refresh(RECALCULATE_PAGE_BREAKS, new RecalculatePageBreaksHandler());
		refresh(SNAP_TO_GRID, new SnapToGridHandler());
		refresh(SORT_FILTER_COMPARTMENT_ITEMS, new SortFilterCompartmentItemsHandler());
	}

	/**
	 * Refresh the state of the handlers
	 * 
	 * @param key
	 *        the key used to refresh the handler status
	 * @param handler
	 *        the handler to refresh
	 */
	protected void refresh(String key, AbstractHandler handler) {
		String oldState = currentState.get(key);
		String newState = (test(handler) ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(key, newState);
			fireSourceChanged(ISources.WORKBENCH, key, newState);
		}
	}

	/**
	 * 
	 * @param handler
	 *        the handler to refresh
	 * @return
	 *         <code>true</code> if the status of the handler is enabled
	 */
	protected boolean test(AbstractHandler handler) {
		return isSelectionInDiagram() && handler.isEnabled();
	}
}
