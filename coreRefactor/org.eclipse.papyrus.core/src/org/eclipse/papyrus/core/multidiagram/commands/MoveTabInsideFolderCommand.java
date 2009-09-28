/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.core.multidiagram.commands;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Move a tab inside the same folder.
 * 
 */
public class MoveTabInsideFolderCommand extends RecordingCommand {

	Diagram srcfolder;

	int srcTabIndex;

	int targetTabIndex;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param srcfolder
	 *            folder into which a tab is moved
	 * @param srcTabIndex
	 *            index of the tab to move
	 * @param targetTabIndex
	 *            new index of the tab after the move.
	 */
	public MoveTabInsideFolderCommand(TransactionalEditingDomain domain, Diagram srcfolder, int srcTabIndex, int targetTabIndex) {
		super(domain);
		this.srcfolder = srcfolder;
		this.srcTabIndex = srcTabIndex;
		this.targetTabIndex = targetTabIndex;
	}

	/**
	 * Execute the command.
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	protected void doExecute() {
		if (srcTabIndex == targetTabIndex)
			return;

		EList<View> list = srcfolder.getChildren();
		if(list.size() == 0)
			return;
		
		if (targetTabIndex >= list.size())
		{
			targetTabIndex = list.size()-1;
		}

		list.move(srcTabIndex, targetTabIndex);
	}

}
