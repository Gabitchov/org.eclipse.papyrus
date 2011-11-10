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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vinent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Add undo
 *****************************************************************************/
package org.eclipse.papyrus.uml.pastemanager.command;

import org.eclipse.gef.commands.Command;

/**
 * A EMF Command that wraps a GEF command. Each method is redirected to the GEF one.
 * 
 * @deprecated use {@link org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper} instead
 */
public class GEFtoEMFCommandWrapper extends org.eclipse.papyrus.commands.wrappers.GEFtoEMFCommandWrapper {

	/**
	 * Constructor.
	 * 
	 * @param gefCommand
	 *        the gef command
	 */
	public GEFtoEMFCommandWrapper(Command gefCommand) {
		super(gefCommand);
	}
}
