/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEventsListener;
import org.eclipse.swt.events.MouseEvent;


/**
 * This class is used to maintain a list of listeners {@link TabMouseEventsListener}.
 * Instance of this class can be use to fire the events to the listeners.
 * The various fireXxx() methods are used to fire events.
 * 
 * @author cedric dumoulin
 *
 */
public class TabMouseEventsProvider {

	/** List of listeners */
	private List<ITabMouseEventsListener> listeners = new ArrayList<ITabMouseEventsListener>();

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void addListener(ITabMouseEventsListener listener) {
		// no duplicate
		if(listeners.contains(listener))
			return;
		listeners.add(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	public void removeListener(ITabMouseEventsListener listener) {
		listeners.remove(listener);
	}


	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void fireMouseDoubleClickEvent(PagePart page, TabFolderPart folder, MouseEvent event) {
		// Fire events to internal listeners
		for(ITabMouseEventsListener listener : listeners) {
			listener.mouseDoubleClick(new TabMouseEvent(page, folder, event));
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void fireMouseDownEvent(PagePart page, TabFolderPart folder, MouseEvent event) {
		// Fire events to internal listeners
		for(ITabMouseEventsListener listener : listeners) {
			listener.mouseDown(new TabMouseEvent(page, folder, event));
		}
	}

	/**
	 * Notify all listener with event.
	 * @param newEditor
	 */
	public void fireMouseUpEvent(PagePart page, TabFolderPart folder, MouseEvent event) {
		// Fire events to internal listeners
		for(ITabMouseEventsListener listener : listeners) {
			listener.mouseUp(new TabMouseEvent(page, folder, event));
		}
	}

}
