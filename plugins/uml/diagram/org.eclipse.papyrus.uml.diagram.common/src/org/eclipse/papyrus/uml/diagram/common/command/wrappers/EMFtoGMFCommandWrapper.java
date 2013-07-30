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

import org.eclipse.emf.common.command.Command;

// TODO: Auto-generated Javadoc
/**
 * A GMF Command that wraps an EMF command. Each method is redirected to the EMF
 * one.
 * 
 * @deprecated use {@link org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper} instead
 */
public class EMFtoGMFCommandWrapper extends org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper {

	/**
	 * Constructor.
	 * 
	 * @param emfCommand
	 *        the emf command
	 */
	public EMFtoGMFCommandWrapper(Command emfCommand) {
		super(emfCommand);
	}
}
