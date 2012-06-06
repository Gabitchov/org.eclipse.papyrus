/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import org.eclipse.gef.commands.Command;

/**
 * A Handler called when the user chooses a default action on
 * SelectAndExecuteCommand
 * 
 * @author Camille Letavernier
 */
public interface DefaultActionHandler {

	public void defaultActionSelected(Command defaultCommand);

	public String getLabel();
}
