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

import org.eclipse.papyrus.infra.core.sasheditor.editor.ITabMouseEvent;
import org.eclipse.swt.events.MouseEvent;


/**
 * Event sent by the TabEventProvider, through the {@link TabMouseEventsListener} interface.
 * 
 * @author cedric dumoulin
 *
 */
public class TabMouseEvent implements ITabMouseEvent {

	/**
	 * The page on which the event occur.
	 */
	PagePart page;
	/**
	 * The folder containing the page.
	 */
	TabFolderPart folder;
	
	/**
	 * The mouse event sent on the tab.
	 */
	MouseEvent mouseEvent;
	
	/**
	 * Constructor.
	 *
	 * @param page
	 * @param folder
	 */
	public TabMouseEvent(PagePart page, TabFolderPart folder, MouseEvent mouseEvent) {
		this.page = page;
		this.folder = folder;
		this.mouseEvent = mouseEvent;
	}

	/**
	 * @return the page
	 */
	public PagePart getPage() {
		return page;
	}
	
	/**
	 * @return the folder
	 */
	public TabFolderPart getFolder() {
		return folder;
	}

	public MouseEvent getMouseEvent() {
		return mouseEvent;
	}
	
}
