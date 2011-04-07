/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.resourceupdate;

import static org.eclipse.papyrus.core.Activator.log;

import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * A listener for part activation. Will ask the user whether to reload when he enters an editor
 * whose underlying resources have changed, used to trigger an update of
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
public class PartActivationListener implements IPartListener {

	public PartActivationListener(IMultiDiagramEditor editor) {
		this.editor = editor;
		modifiedMainResource = false;
	}

	/**
	 * @return true, if a resource for an underlying editor have been updated?
	 */
	public boolean isModied() {
		return modifiedMainResource;
	}

	/**
	 * indicate that the resource for an editor have been modified
	 * 
	 * @param changedResourcePath
	 *        The path to the resource that has been changed
	 * @param delta
	 *        additional information about the change
	 */
	public void setModificationData(String changedResourcePath, IResourceDelta delta) {
		this.changedResourcePath = changedResourcePath;
		this.delta = delta;
		modifiedMainResource = true;
	}

	public void partActivated(IWorkbenchPart part) {
		// don't use (part == editor.getSite().getPart()), since different views (e.g. model explorer or property)
		// of an active editor may actually be selected
		IMultiDiagramEditor activeEditor = EditorUtils.getMultiDiagramEditor();
		if(editor == activeEditor) {
			System.out.println("activate: " + editor.getTitle());
		}
		if((editor == activeEditor) && modifiedMainResource) {

			switch(delta.getKind()) {
			case IResourceDelta.ADDED:
				break;
			case IResourceDelta.REMOVED:
				// asynchronous notification to avoid that the removal of multiple resource files
				// belonging to the editor (e.g. .uml and .notation) at the same time leads to multiple
				// user feedback.

				MessageDialog.openInformation(new Shell(), "Resource removal", "The resource " + changedResourcePath + " that is in use by a Papyrus editor has been removed. Use save/save as, if you want to keep the model");
				break;

			case IResourceDelta.CHANGED:
				// reopen the editor asynchronously to avoid that changes of multiple resource files
				// belonging to the editor (e.g. .uml and .notation) lead to multiple reloads.
				// de-activate until user responds to message dialog 

				String message = "The resource " + changedResourcePath + " that is in use by a Papyrus editor has changed. Do you want to reopen the editor in order to update its contents?";
				if(editor.isDirty()) {
					message += " CAVEAT: the editor contains unsaved modifications that would be lost.";
				}

				if(MessageDialog.openQuestion(new Shell(), "Resource change", message)) {
					// unloading and reloading all resources of the main causes the following problems
					//  - since resources are removed during the modelSets unload operation, the call eResource().getContents ()
					//    used by the model explorer leads to a null pointer exception
					//  - diagrams in model explorer are not shown
					//  - would need to reset dirty flags
					// => clean & simple option is to close and reopen the editor.

					Display.getCurrent().asyncExec(new Runnable() {

						public void run() {
							IWorkbench wb = PlatformUI.getWorkbench();
							IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
							IEditorInput input = editor.getEditorInput();
							page.closeEditor(editor, false);
							try {
								IEditorDescriptor desc = wb.getEditorRegistry().getDefaultEditor(input.getName());
								page.openEditor(input, desc.getId(), false);
							} catch (PartInitException e) {
								log.error(e);
							}
						}
					});
				}
				break;
			}
			modifiedMainResource = false;
		}
	}

	public void partDeactivated(IWorkbenchPart part) {
	}

	public void partBroughtToTop(IWorkbenchPart part) {
	}

	public void partClosed(IWorkbenchPart part) {
	}

	public void partOpened(IWorkbenchPart part) {
	}

	private IMultiDiagramEditor editor;

	private String changedResourcePath;

	private IResourceDelta delta;

	private boolean modifiedMainResource;
}
