/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;

/**
 * A EMF Command that wraps a GMF command. Each method is redirected to the GMF
 * one.
 * 
 * @deprecated use {@link org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper} instead
 */
public class GMFToEMFCommand extends GMFtoEMFCommandWrapper {

	public GMFToEMFCommand(ICommand gmfCommand) {
		super(gmfCommand);
	}

}
