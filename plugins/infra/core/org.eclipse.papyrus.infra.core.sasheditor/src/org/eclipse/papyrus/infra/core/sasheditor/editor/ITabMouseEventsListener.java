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



/**
 * Class implementing this interface can listen on events coming from a tab of a {@link TabFolderPart}.
 * Here a tab means the rectangle showing the name of an item.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public interface ITabMouseEventsListener {


	/**
	 * A mouse double click is detected.
	 * 
	 * @param event
	 */
	public void mouseDoubleClick(ITabMouseEvent event);
	
	/**
	 * A mouse up click is detected.
	 * 
	 * @param event
	 */
	public void mouseUp(ITabMouseEvent tabEvent);
	/**
	 * A mouse down is detected.
	 * 
	 * @param event
	 */
	public void mouseDown(ITabMouseEvent tabEvent);
	

}
