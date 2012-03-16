/*****************************************************************************
 * Copyright (c) 2012 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.oneinstance;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.readonly.IReadOnlyHandler;
import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.ui.toolbox.notification.Type;
import org.eclipse.papyrus.ui.toolbox.notification.builders.IContext;
import org.eclipse.papyrus.ui.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


public class OneInstanceReadOnlyHandler implements IReadOnlyHandler, IPartListener, IPageListener, IWindowListener {

	protected static final String PAPYRUS_EDITOR_ID = "org.eclipse.papyrus.core.papyrusEditor";

	protected EditingDomain authorizedEditingDomain;
	
	protected Set<EditingDomain> unauthorizedEditingDomains = new HashSet<EditingDomain>();

	public OneInstanceReadOnlyHandler() {
		PlatformUI.getWorkbench().addWindowListener(this);
		for (IWorkbenchWindow workbenchWindow : PlatformUI.getWorkbench().getWorkbenchWindows()) {
			workbenchWindow.addPageListener(this);
			for (IWorkbenchPage page : workbenchWindow.getPages()) {
				page.addPartListener(this);
			}
		}
	}

	public boolean isReadOnly(final IFile[] files, final EditingDomain editingDomain) {
		// don't give the write token to a previously unauthorized editor
		if (unauthorizedEditingDomains.contains(editingDomain)) {
			return true;
		}

		// give the write token
		if (authorizedEditingDomain == null) {
			authorizedEditingDomain = editingDomain;
		}

		if (authorizedEditingDomain != null) {
			if (!authorizedEditingDomain.equals(editingDomain)) {
				// newly unauthorized (read-only) editor : warn the user
				// and propose write access
				unauthorizedEditingDomains.add(editingDomain);
				String msg = "The current editor is read-only.";
				new NotificationBuilder().setAsynchronous(true).setTemporary(true).setDelay(4000).setType(Type.WARNING).setMessage(msg).addAction(new NotificationRunnable() {
					
					public void run(IContext context) {
						enableWrite(files, editingDomain);
					}
					
					public String getLabel() {
						return "Enable write access";
					}
				}).run();
				return true;
			}
		}
		return false;
	}

	public boolean enableWrite(IFile[] files, EditingDomain editingDomain) {
		if (authorizedEditingDomain != null && editingDomain != null) {
			final IEditorPart authorizedEditor = getAssociatedPapyrusEditor(authorizedEditingDomain);
			final IEditorPart currentEditor = getAssociatedPapyrusEditor(editingDomain);

			if (authorizedEditor != null) {
				String msg = "<form><p>Only one editor can have write access at a time.</p>" +
						"<p>Do you want to enable write access for this  editor ?</p>" +
						"<p>This will close the currently writable editor <b>" + authorizedEditor.getTitle() + "</b></p>" +
						"<p>and re-open this one.</p></form>";
				
				new NotificationBuilder().setType(Type.QUESTION).setHTML(true).setMessage(msg).addAction(new NotificationRunnable() {
					
					public void run(IContext context) {
						// close the current authorized editor and re-open the current one
						authorizedEditor.getEditorSite().getPage().closeEditor(authorizedEditor, true);
						IWorkbenchPage currentPage = currentEditor.getEditorSite().getPage();
						IEditorInput currentInput = currentEditor.getEditorInput();
						currentPage.closeEditor(currentEditor, false);
						try {
							currentPage.openEditor(currentInput, PAPYRUS_EDITOR_ID);
						} catch (PartInitException e) {}
					}
					
					public String getLabel() {
						return "Close editor";
					}
				}).addAction(new NotificationRunnable() {
					
					public void run(IContext context) {
						context.put(IContext.ACTION_ID, Boolean.FALSE);
					}
					
					public String getLabel() {
						return "Cancel";
					}
				}).run();
			}
		}

		// never ack : the editor is reopened anyway if we get the token
		return false;
	}
	
	protected IEditorPart getAssociatedPapyrusEditor(EditingDomain editingDomain) {
		for (IWorkbenchWindow workbenchWindow : PlatformUI.getWorkbench().getWorkbenchWindows()) {
			for (IWorkbenchPage page : workbenchWindow.getPages()) {
				for (IEditorReference editorRef : page.getEditorReferences()) {
					if (PAPYRUS_EDITOR_ID.equals(editorRef.getId())) {
						IEditorPart editor = editorRef.getEditor(false);
						if (editingDomain.equals(editor.getAdapter(EditingDomain.class))) {
							return editor;
						}
					}
				}
			}
		}
		return null;
	}

	public void partClosed(IWorkbenchPart part) {
		EditingDomain editingDomain = (EditingDomain)part.getAdapter(EditingDomain.class);
		
		if (editingDomain != null) {
			unauthorizedEditingDomains.remove(editingDomain);
			if (editingDomain.equals(authorizedEditingDomain)) {
				authorizedEditingDomain = null;
			}
		}
	}

	public void partOpened(IWorkbenchPart part) {
	}

	public void windowClosed(IWorkbenchWindow window) {
		window.removePageListener(this);
	}

	public void windowOpened(IWorkbenchWindow window) {
		window.addPageListener(this);
	}

	public void pageClosed(IWorkbenchPage page) {
		page.removePartListener(this);
	}

	public void pageOpened(IWorkbenchPage page) {
		page.addPartListener(this);
	}

	public void partActivated(IWorkbenchPart part) {}
	public void partBroughtToTop(IWorkbenchPart part) {}
	public void partDeactivated(IWorkbenchPart part) {}
	public void pageActivated(IWorkbenchPage page) {}
	public void windowActivated(IWorkbenchWindow window) {}
	public void windowDeactivated(IWorkbenchWindow window) {}
}
