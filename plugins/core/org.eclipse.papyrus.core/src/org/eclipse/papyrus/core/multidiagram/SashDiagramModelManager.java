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
package org.eclipse.papyrus.core.multidiagram;

import java.util.logging.Logger;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.core.multidiagram.commands.MoveTabFromFolderToFolderCommand;
import org.eclipse.papyrus.core.multidiagram.commands.MoveTabInsideFolderCommand;
import org.eclipse.papyrus.core.multidiagram.commands.MoveTabToFolderSideCommand;
import org.eclipse.papyrus.di.Diagram;

/**
 * Manage the model representation of the diagrams organized in sash windows. Possible moves are:
 * <ul>
 * <li>moveTab(srcFolder, srcIndex, targetFolder, targetIndex) - between different folders
 * <li>moveTab(srcFolder, srcIndex, targetIndex) - move tab inside the same folder
 * <li>createFolder(srcFolder, srcIndex, targetFolder, position) - move the tab to the N, S E or W of the target, and create a new Folder
 * <li>moveFolder(srcFolder, targetFolder) - move all the tab of the src folder inside the targetFolder. The srcFolder is destroyed
 * <li>moveFolder(srcFolder, targetFolder, position) - move the folder to the the N, S E or W of the target.
 * 
 * </ul>
 * 
 * Additional operations are:
 * <ul>
 * <li>
 * </ul>
 */
public class SashDiagramModelManager extends SashDiagramModelUtil {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** */
	private TransactionalEditingDomain editingDomain;

	/** The resource containing the sash diagram nodes */
	private Resource diagramResource;

	/**
	 * Constructor.
	 */
	public SashDiagramModelManager(TransactionalEditingDomain editingDomain, Resource diagramResource) {
		this.editingDomain = editingDomain;
		this.diagramResource = diagramResource;
	}

	/**
	 * Get the TransactionalEditingDomain required by commands.
	 */
	private TransactionalEditingDomain getTransactionalEditingDomain() {
		return editingDomain;
	}

	/**
	 * Add the specified listener to the model. The listener will be call each time the model is changed, but at the end of the transaction.
	 */
	public void addChangeListener(ResourceSetListener listener) {
		editingDomain.addResourceSetListener(listener);
	}

	/**
	 * Remove the specified listener to the model.
	 */
	public void removeChangeListener(ResourceSetListener listener) {
		editingDomain.removeResourceSetListener(listener);
	}

	/**
	 * Return the root of the Diagram model.
	 * 
	 * @return The model root or null if not found.
	 */
	public Diagram getModelRoot() {

		return getModelRoot(getDiagramResource());
	}

	/**
	 * Get the ResourceSet containing the diagram Model nodes.
	 */
	private Resource getDiagramResource() {
		// TODO Use the Adapter mechanism to retrieve resource ?
		return diagramResource;
	}

	/**
	 * Move the specified tab to the specified destination. Operation are done inside a transaction.
	 * 
	 * @param srcFolder
	 *            The Diagram node containing the tabs@param srcfolder
	 * @param srcTabIndex
	 * @param targetFolder
	 * @param targetTabIndex
	 * 
	 * @see
	 */
	public void doMoveTab(Diagram srcfolder, int srcTabIndex, Diagram targetFolder, int targetTabIndex) {
		System.out.println("Move folder to folder (to be implemented)");
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();
		RecordingCommand command = new MoveTabFromFolderToFolderCommand(editingDomain, srcfolder, srcTabIndex, targetFolder, targetTabIndex);

		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * Execute a command that move the tab inside the same folder.
	 * 
	 * @param srcFolder
	 * @param srcsrcTabIndex
	 * @param targetTabIndex
	 *            Index where the tab will be placed. Other tabs are moved upward.
	 * 
	 * @see org.eclipse.papyrus.core.multidiagram.commands.MoveTabInsideFolderCommand
	 */
	public void doMoveTab(Diagram srcfolder, int srcTabIndex, int targetTabIndex) {
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();
		RecordingCommand command = new MoveTabInsideFolderCommand(editingDomain, srcfolder, srcTabIndex, targetTabIndex);

		editingDomain.getCommandStack().execute(command);
	}

	/**
	 * Execute a command that move a tab to the side of a folder.
	 * 
	 * @param srcFolder
	 * @param srcsrcTabIndex
	 * @param targetTabIndex
	 *            Index where the tab will be placed. Other tabs are moved upward.
	 * 
	 * @see org.eclipse.papyrus.core.multidiagram.SashDiagramModelManager.MoveTabToFolderSideCommand
	 */
	public void doMoveTabToFolderSide(Diagram srcfolder, int srcTabIndex, Diagram targetfolder, int position) {
		TransactionalEditingDomain editingDomain = getTransactionalEditingDomain();
		RecordingCommand command = new MoveTabToFolderSideCommand(editingDomain, srcfolder, srcTabIndex, targetfolder, position);

		editingDomain.getCommandStack().execute(command);
	}

}
