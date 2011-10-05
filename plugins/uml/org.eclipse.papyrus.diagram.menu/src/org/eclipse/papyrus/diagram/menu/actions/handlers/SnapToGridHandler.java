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
package org.eclipse.papyrus.diagram.menu.actions.handlers;

import org.eclipse.gmf.runtime.diagram.ui.internal.properties.WorkspaceViewerProperties;

/**
 * 
 * Handler for the Snap To Grid Action
 * 
 * 
 */
@SuppressWarnings("restriction")
public class SnapToGridHandler extends AbstractViewHandler {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public SnapToGridHandler() {
		super(WorkspaceViewerProperties.SNAPTOGRID);
	}
}
