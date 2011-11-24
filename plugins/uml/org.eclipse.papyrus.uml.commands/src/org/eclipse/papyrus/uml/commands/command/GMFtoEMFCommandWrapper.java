/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.commands.command;

import org.eclipse.gmf.runtime.common.core.command.ICommand;

/**
 * A EMF Command that wraps a GMF command. Each method is redirected to the GMF one.
 * 
 * @deprecated use {@link org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper} instead
 */
public class GMFtoEMFCommandWrapper extends org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper {

	/**
	 * Constructor.
	 * 
	 * @param gmfCommand
	 *        the gmf command
	 */
	public GMFtoEMFCommandWrapper(ICommand gmfCommand) {
		super(gmfCommand);
	}
}
