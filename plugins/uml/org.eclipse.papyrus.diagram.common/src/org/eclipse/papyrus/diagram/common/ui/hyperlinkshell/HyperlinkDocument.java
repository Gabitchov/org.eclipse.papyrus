/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Package;

/**
 * The Class HyperlinkDocument. A container of document
 */
public class HyperlinkDocument extends HyperlinkObject {

	/**
	 * Gets the hyperlink document.
	 * 
	 * @return the hyperlink document
	 */
	public String getHyperlinkDocument() {
		return (String)super.getObject();
	}

	/**
	 * Sets the hyperlink document.
	 * 
	 * @param object
	 *        the new hyperlink document
	 */
	public void setHyperlinkDocument(String object) {
		super.setObject(object);
	}

	@Override
	public void executeSelectPressed() {
		try {
			// this is a file try to open it
			IEditorDescriptor eDesc = PlatformUI.getWorkbench().getEditorRegistry().findEditor(IEditorRegistry.SYSTEM_EXTERNAL_EDITOR_ID);

			// creation of a phantom workspace
			IWorkspace ws = ResourcesPlugin.getWorkspace();
			IProject project = ws.getRoot().getProject("External Files");
			if(!project.exists()) {
				project.create(null);
			}
			if(!project.isOpen()) {
				project.open(null);
			}
			IPath location = new Path(this.getHyperlinkDocument());
			IFile file = project.getFile(location.lastSegment());
			if(!file.exists()) {
				file.createLink(location, IResource.NONE, null);
			}
			IEditorInput editorInput = new FileEditorInput(file);
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			page.openEditor(editorInput, eDesc.getId());
		} catch (Exception e) {
			Activator.log.error(e);
		}
		
	}

	@Override
	public void executeEditMousePressed(List<HyperlinkObject> list, Package amodel) {
		EditorHyperlinkDocumentShell editor = new EditorHyperlinkDocumentShell();
		editor.setHyperlinkDocument(this);
		editor.open();
		int index = list.indexOf(this);
		list.remove(this);
		list.add(index, editor.getHyperlinkDocument());
		
	}
}
