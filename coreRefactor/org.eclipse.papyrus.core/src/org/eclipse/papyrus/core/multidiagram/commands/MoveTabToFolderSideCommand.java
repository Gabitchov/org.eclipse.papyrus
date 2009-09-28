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

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.multidiagram.SashDiagramModelUtil;

/**
 * Create a folder containing the srcTab, at the specified position of the targetFolder.
 */
public class MoveTabToFolderSideCommand extends RecordingCommand {

	Diagram srcfolder;

	int srcTabIndex;

	Diagram targetfolder;

	int position;

	/**
	 * Constructor.
	 */
	public MoveTabToFolderSideCommand(TransactionalEditingDomain domain, Diagram srcfolder, int srcTabIndex, Diagram targetfolder, int position) {
		super(domain);
		this.srcfolder = srcfolder;
		this.srcTabIndex = srcTabIndex;
		this.targetfolder = targetfolder;
		this.position = position;
	}

	/**
	 * Execute the command.
	 * 
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	protected void doExecute() {

		// Disable events from resource
		Resource resource = srcfolder.eResource();
		resource.eSetDeliver(false);
		
		// Get node to move
//		Diagram movedTab = (Diagram) srcfolder.getContained().remove(srcTabIndex);
	//	Diagram movedTab = SashDiagramModelUtil.removeNodeFromTabFolder(srcfolder, srcTabIndex);
		// Create a folder and insert the movedTab
		Diagram createdFolder = SashDiagramModelUtil.createTabFolderNode();
	//	createdFolder.getChildren().add(movedTab);

		// insert it in the specified position relative to targetNode
		SashDiagramModelUtil.insertNode(createdFolder, targetfolder, position);
		
		// Reenable events
		resource.eSetDeliver(true);
	}

}
