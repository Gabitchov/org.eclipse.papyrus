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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.multidiagram.SashDiagramModelUtil;

/**
 * Move a tab from a folder to another folder.
 * 
 */
public class MoveTabFromFolderToFolderCommand extends RecordingCommand {

	Diagram srcFolder;

	int srcTabIndex;

	Diagram targetFolder;

	int targetTabIndex;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param domain
	 * @param srcFolder
	 *            folder into which a tab is moved
	 * @param srcTabIndex
	 *            index of the tab to move
	 * @param targetTabIndex
	 *            new index of the tab after the move.
	 */
	public MoveTabFromFolderToFolderCommand(TransactionalEditingDomain domain, Diagram srcfolder, int srcTabIndex, Diagram targetfolder, int targetTabIndex) {
		super(domain);
		this.srcFolder = srcfolder;
		this.srcTabIndex = srcTabIndex;
		this.targetFolder = targetfolder;
		this.targetTabIndex = targetTabIndex;
	}

	/**
	 * Execute the command.
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	protected void doExecute() {

		// Check if the command is useful
		if (srcFolder == targetFolder && srcTabIndex == targetTabIndex)
			return;

		EList<View> srcTabList = srcFolder.getChildren();
		EList<View> targetTabList = targetFolder.getChildren();

		// Adjust target index
		if (targetTabIndex < 0 || targetTabIndex > targetTabList.size())
			targetTabIndex = targetTabList.size();

		// Disable events from resource
		Resource resource = srcFolder.eResource();
		resource.eSetDeliver(false);

		// Do we move all or just one tab ?
		if (srcTabIndex == -1) {
			// move all
			targetTabList.addAll(targetTabIndex, srcTabList);
			srcTabList.clear();
			SashDiagramModelUtil.removeTabFolderNode(srcFolder);
		} else {
			// Do move one tab : attach the node to the target folder
			View srcTab = srcTabList.remove(srcTabIndex);
			targetTabList.add(targetTabIndex, srcTab);
			if (srcTabList.size() == 0)
				SashDiagramModelUtil.removeTabFolderNode(srcFolder);
		}

		// reenable events
		resource.eSetDeliver(true);
	}

}
