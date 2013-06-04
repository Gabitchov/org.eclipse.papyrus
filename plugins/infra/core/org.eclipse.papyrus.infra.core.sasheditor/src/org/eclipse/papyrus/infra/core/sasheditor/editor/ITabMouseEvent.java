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

package org.eclipse.papyrus.infra.core.sasheditor.editor;

import org.eclipse.swt.events.MouseEvent;


/**
 * Event sent by the TabEventProvider, through the {@link ITabMouseEventsListener} interface.
 * 
 * @author cedric dumoulin
 *
 */
public interface ITabMouseEvent {

	/**
	 * @return the page
	 */
	public IPage getPage() ;
	
	/**
	 * @return the folder
	 */
	public IFolder getFolder() ;
	
	public MouseEvent getMouseEvent();
}
