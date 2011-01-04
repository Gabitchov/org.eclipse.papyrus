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

import org.eclipse.papyrus.diagram.common.providers.AbstractActionStateSourceProvider;
import org.eclipse.papyrus.diagram.menu.actions.handlers.AbstractViewHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.CopyAppearancePropertiesHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.RecalculatePageBreaksHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ShowHideCompartmentHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.ShowHideContentsHandler;
import org.eclipse.papyrus.diagram.menu.actions.handlers.SnapToGridHandler;
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
	 * The name of the variable to check.
	 */
	public static final String SHOW_HIDE_CONTENTS = "showHideContents"; //$NON-NLS-1$

	public static final String SHOW_HIDE_COMPARTMENTS = "showHideCompartments"; //$NON-NLS-1$

	public static final String COPY_APPEARANCE_PROPERTIES = "copyAppearanceProperties";//$NON-NLS-1$

	public static final String GRID = "grid";//$NON-NLS-1$

	public static final String RULERS = "rulers";//$NON-NLS-1$

	public static final String PAGE_BREAKS = "pageBreaks";//$NON-NLS-1$

	public static final String RECALCULATE_PAGE_BREAKS = "recalculatePageBreaks";//$NON-NLS-1$

	public static final String SNAP_TO_GRID = "snapToGrid";//$NON-NLS-1$



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
		refreshShowHideContentsHandler();
		refreshShowHideCompartmentsHandler();
		refreshCopyAppearancePropertiesHandler();
		refreshGridHandler();
		refreshRulersHandler();
		refreshPageBreaksHandler();
		refreshRecalculatePageBreakHandler();
		refreshSnapToGridHandler();
	}

	/**
	 * Refresh the state of the Show Hide Contents Handler
	 */
	protected void refreshShowHideContentsHandler() {
		String oldState = currentState.get(SHOW_HIDE_CONTENTS);
		String newState = (testShowHideContents() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(SHOW_HIDE_CONTENTS, newState);
			fireSourceChanged(ISources.WORKBENCH, SHOW_HIDE_CONTENTS, newState);
		}
	}


	/**
	 * Refresh the state of the Show/Hide Compartments Handler
	 */
	protected void refreshShowHideCompartmentsHandler() {
		String oldState = currentState.get(SHOW_HIDE_COMPARTMENTS);
		String newState = (testShowHideCompartments() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(SHOW_HIDE_COMPARTMENTS, newState);
			fireSourceChanged(ISources.WORKBENCH, SHOW_HIDE_COMPARTMENTS, newState);
		}
	}


	/**
	 * Refresh the state of the Copy Appearance Properties Handler
	 */
	protected void refreshCopyAppearancePropertiesHandler() {
		String oldState = currentState.get(COPY_APPEARANCE_PROPERTIES);
		String newState = (testCopyAppearanceProperties() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(COPY_APPEARANCE_PROPERTIES, newState);
			fireSourceChanged(ISources.WORKBENCH, COPY_APPEARANCE_PROPERTIES, newState);
		}

	}

	/**
	 * Refresh the state of the Grid Handler
	 */
	protected void refreshGridHandler() {
		String oldState = currentState.get(GRID);
		String newState = (testGrid() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(GRID, newState);
			fireSourceChanged(ISources.WORKBENCH, GRID, newState);
		}

	}

	/**
	 * Refresh the state of the Rulers Handler
	 */
	protected void refreshRulersHandler() {
		String oldState = currentState.get(RULERS);
		String newState = (testRulers() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(RULERS, newState);
			fireSourceChanged(ISources.WORKBENCH, RULERS, newState);
		}

	}

	/**
	 * Refresh the state of the Page Break Handler
	 */
	protected void refreshPageBreaksHandler() {
		String oldState = currentState.get(PAGE_BREAKS);
		String newState = (testPageBreaks() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(PAGE_BREAKS, newState);
			fireSourceChanged(ISources.WORKBENCH, PAGE_BREAKS, newState);
		}
	}

	/**
	 * Refresh the state of the RecalculatePageBreak Handler
	 */
	protected void refreshRecalculatePageBreakHandler() {
		String oldState = currentState.get(RECALCULATE_PAGE_BREAKS);
		String newState = (testRecalculatePageBreaks() ? ENABLED : DISABLED);
		if(oldState != newState) {
			currentState.put(RECALCULATE_PAGE_BREAKS, newState);
			fireSourceChanged(ISources.WORKBENCH, RECALCULATE_PAGE_BREAKS, newState);
		}
	}

	/**
	 * Refresh the state of the Snap to Grid Handler
	 */
	protected void refreshSnapToGridHandler() {
		String oldState = currentState.get(SNAP_TO_GRID);
		String newState = (testSnapToGrid() ? ENABLED : DISABLED);

		if(oldState != newState) {
			currentState.put(SNAP_TO_GRID, newState);
			fireSourceChanged(ISources.WORKBENCH, SNAP_TO_GRID, newState);
		}
	}


	/**
	 * Tests if the Handler ShowHideContentsHandler can be executed
	 * 
	 * @return
	 *         <code>true</code> if the Handler ShowHideContentsHandler can be executed <code>false</code> if not
	 */
	protected boolean testShowHideContents() {
		ShowHideContentsHandler handler = new ShowHideContentsHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}


	/**
	 * Tests if the Handler ShowHideCompartmentsHandler can be executed
	 * 
	 * @return
	 *         <code>true</code> if the Handler ShowHideCompartmentsHandler can be executed <code>false</code> if not
	 */
	protected boolean testShowHideCompartments() {
		ShowHideCompartmentHandler handler = new ShowHideCompartmentHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}


	/**
	 * Tests if the Copy Appearance Properties Handler can be executed
	 * 
	 * @return
	 *         <code>true</code> if the Handler Copy Appearance Properties can be executed <code>false</code> if not
	 */
	protected boolean testCopyAppearanceProperties() {
		CopyAppearancePropertiesHandler handler = new CopyAppearancePropertiesHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}

	/**
	 * Calculates the new state for the Grid Handler
	 * 
	 * @return
	 *         the new state for the Grid Handler
	 */
	protected boolean testGrid() {
		AbstractViewHandler handler = new ViewGridHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}

	/**
	 * Calculates the new state for the Rulers Handler
	 * 
	 * @return
	 *         the new state for the Rulers Handler
	 */
	protected boolean testRulers() {
		AbstractViewHandler handler = new ViewRulersHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}

	/**
	 * Calculates the new state for the Page Break Handler
	 * 
	 * @return
	 *         the new state for the Page Break Handler
	 */
	protected boolean testPageBreaks() {
		AbstractViewHandler handler = new ViewPageBreaksHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}

	/**
	 * Calculates the new state for the Recalculate Page Breaks Handler
	 * 
	 * @return
	 *         the new state for the Recalculate Page Breaks Handler
	 */
	protected boolean testRecalculatePageBreaks() {
		AbstractViewHandler handler = new RecalculatePageBreaksHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}

	/**
	 * Calculates the new state for the Snap To Grid Handler
	 * 
	 * @return
	 *         the new state for the Snap To Grid Handler
	 */
	protected boolean testSnapToGrid() {
		AbstractViewHandler handler = new SnapToGridHandler();
		return isSelectionInDiagram() && handler.isEnabled();
	}
}
