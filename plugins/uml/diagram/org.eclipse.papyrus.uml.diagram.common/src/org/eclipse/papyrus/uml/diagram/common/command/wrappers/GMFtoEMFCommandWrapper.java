/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Mario Cervera Ubeda (Prodevelop)
 *
 ******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.command.wrappers;

import org.eclipse.gmf.runtime.common.core.command.ICommand;

// TODO: Auto-generated Javadoc
/**
 * A EMF Command that wraps a GMF command. Each method is redirected to the GMF
 * one.
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
