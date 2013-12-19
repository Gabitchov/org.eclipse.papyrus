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
package org.eclipse.papyrus.uml.diagram.menu.providers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.papyrus.uml.diagram.common.providers.AbstractActionStateSourceProvider;
import org.eclipse.papyrus.uml.diagram.menu.actions.ArrangeAction;
import org.eclipse.papyrus.uml.diagram.menu.actions.LineStyleAction;
import org.eclipse.papyrus.uml.diagram.menu.actions.SelectAction;
import org.eclipse.papyrus.uml.diagram.menu.actions.ShowHideLabelsAction;
import org.eclipse.papyrus.uml.diagram.menu.actions.ZOrderAction;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.ArrangeHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.CopyAppearancePropertiesHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.FillColorHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.FontHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.LineColorHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.LineStyleHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.SelectHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.ShowHideCompartmentHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.ShowHideContentsHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.ShowHideLabelsHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.SortFilterCompartmentItemsHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.ZOrderHandler;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.ZoomHandler;
import org.eclipse.ui.ISources;

/**
 * This class provides the state of the Handlers. It's used to refresh
 * the status of these Handlers in the menu. (in toolbar and popup, it's not needed)
 * 
 * To get the status, we listen the selection service AND the part service!
 * The part service is used to know if the selection is in the Model Explorer or not!
 * When the selection is not in the model explorer, the handlers listening the variable need to be disabled
 * FIXME we should replace this class by a PropertyTester which avoid to set Listener.
 * 
 */
public class HandlerStateSourceProvider extends AbstractActionStateSourceProvider {

	/**
	 * The names of the variable to check.
	 */
	public static final String SHOW_HIDE_CONTENTS = "showHideContents"; //$NON-NLS-1$

	public static final String SHOW_HIDE_COMPARTMENTS = "showHideCompartments"; //$NON-NLS-1$

	public static final String COPY_APPEARANCE_PROPERTIES = "copyAppearanceProperties";//$NON-NLS-1$

	public static final String SORT_FILTER_COMPARTMENT_ITEMS = "sortFilterCompartmentItems"; //$NON-NLS-1$

	public static final String ZOOM = "zoom"; //$NON-NLS-1$

	public static final String BRING_TO_FRONT = ZOrderAction.BRING_TO_FRONT;

	public static final String SEND_TO_BACK = ZOrderAction.SEND_TO_BACK;

	public static final String BRING_FORWARD = ZOrderAction.BRING_FORWARD;

	public static final String SEND_BACKWARD = ZOrderAction.SEND_BACKWARD;

	public static final String ARRANGE_ALL = ArrangeAction.ARRANGE_ALL;

	public static final String ARRANGE_SELECTION = ArrangeAction.ARRANGE_SELECTION;

	public static final String SELECT_ALL = SelectAction.SELECT_ALL;

	public static final String SELECT_ALL_SHAPES = SelectAction.SELECT_ALL_SHAPES;

	public static final String SELECT_ALL_CONNECTORS = SelectAction.SELECT_ALL_CONNECTORS;

	public static final String FONT = "font"; //$NON-NLS-1$

	public static final String FILL_COLOR = "fillColor"; //$NON-NLS-1$

	public static final String LINE_COLOR = "lineColor"; //$NON-NLS-1$

	public static final String LINE_STYLE = "lineStyle"; //$NON-NLS-1$

	public static final String LINE_STYLE_TREE = "lineStyleTree"; //$NON-NLS-1$

	public static final String SHOW_HIDE_CONNECTION_LABELS = "showHideLabels"; //$NON-NLS-1$ 

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
		currentState.put(SORT_FILTER_COMPARTMENT_ITEMS, DISABLED);
		currentState.put(ZOOM, DISABLED);

		currentState.put(BRING_TO_FRONT, DISABLED);
		currentState.put(SEND_TO_BACK, DISABLED);
		currentState.put(BRING_FORWARD, DISABLED);
		currentState.put(SEND_BACKWARD, DISABLED);

		currentState.put(ARRANGE_ALL, DISABLED);
		currentState.put(ARRANGE_SELECTION, DISABLED);

		currentState.put(SELECT_ALL, DISABLED);
		currentState.put(SELECT_ALL_SHAPES, DISABLED);
		currentState.put(SELECT_ALL_CONNECTORS, DISABLED);

		currentState.put(FONT, DISABLED);

		currentState.put(FILL_COLOR, DISABLED);
		currentState.put(LINE_COLOR, DISABLED);

		currentState.put(LINE_STYLE, DISABLED);
		currentState.put(LINE_STYLE_TREE, DISABLED);
		currentState.put(SHOW_HIDE_CONNECTION_LABELS, DISABLED);

	}


	/**
	 * 
	 * @see org.eclipse.ui.ISourceProvider#getProvidedSourceNames()
	 * 
	 * @return
	 */
	@Override
	public String[] getProvidedSourceNames() {
		return new String[]{ SHOW_HIDE_CONTENTS, SHOW_HIDE_COMPARTMENTS, COPY_APPEARANCE_PROPERTIES, ZOOM


		, BRING_TO_FRONT, SEND_TO_BACK, BRING_FORWARD, SEND_BACKWARD

		, ARRANGE_ALL, ARRANGE_SELECTION

		, SELECT_ALL, SELECT_ALL_CONNECTORS, SELECT_ALL_SHAPES

		, FONT

		, FILL_COLOR, LINE_COLOR, LINE_STYLE, LINE_STYLE_TREE, SHOW_HIDE_CONNECTION_LABELS };

	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.providers.AbstractActionStateSourceProvider#refreshActions()
	 * 
	 */
	@Override
	protected void refreshActions() {
		refresh(SHOW_HIDE_CONTENTS, new ShowHideContentsHandler());
		refresh(SHOW_HIDE_COMPARTMENTS, new ShowHideCompartmentHandler());
		refresh(COPY_APPEARANCE_PROPERTIES, new CopyAppearancePropertiesHandler());

		refresh(SORT_FILTER_COMPARTMENT_ITEMS, new SortFilterCompartmentItemsHandler());
		refresh(ZOOM, new ZoomHandler());

		refresh(BRING_TO_FRONT, new ZOrderHandler(BRING_TO_FRONT));
		refresh(SEND_TO_BACK, new ZOrderHandler(SEND_TO_BACK));
		refresh(BRING_FORWARD, new ZOrderHandler(BRING_FORWARD));
		refresh(SEND_BACKWARD, new ZOrderHandler(SEND_BACKWARD));
		refresh(ARRANGE_ALL, new ArrangeHandler(ARRANGE_ALL));
		refresh(ARRANGE_SELECTION, new ArrangeHandler(ARRANGE_SELECTION));

		refresh(SELECT_ALL, new SelectHandler(SELECT_ALL));
		refresh(SELECT_ALL_CONNECTORS, new SelectHandler(SELECT_ALL_CONNECTORS));
		refresh(SELECT_ALL_SHAPES, new SelectHandler(SELECT_ALL_SHAPES));

		refresh(FONT, new FontHandler());

		refresh(FILL_COLOR, new FillColorHandler());
		refresh(LINE_COLOR, new LineColorHandler());
		refresh(LINE_STYLE, new LineStyleHandler(LineStyleAction.RECTILINEAR));
		refresh(LINE_STYLE_TREE, new LineStyleHandler(LineStyleAction.TREE));
		refresh(SHOW_HIDE_CONNECTION_LABELS, new ShowHideLabelsHandler(ShowHideLabelsAction.SHOW_PARAMETER));
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
