/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.commands;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.widgets.Shell;


/**
 * This class opens a dialog to select and execute a command in a given list.
 * 
 * @deprecated Moved to infra.gmfdiag.common
 */
@Deprecated
public class SelectAndExecuteCommand extends org.eclipse.papyrus.infra.gmfdiag.common.commands.SelectAndExecuteCommand {

	public SelectAndExecuteCommand(String label, Shell parentShell, List<Command> content) {
		super(label, parentShell, content);
	}

}
