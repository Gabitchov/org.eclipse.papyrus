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
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>: Code simplification and NPE
 *         management.
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.utils;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


/**
 * Set of utility methods for the CoreEditor.
 * 
 * @author cedric dumoulin
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>
 */
// FIXME throws Exception (eg: NotFoundException) instead of null
public class EditorUtils {

	/**
	 * Gets the multi diagram editor.
	 * 
	 * @return Get the current {@link IMultiDiagramEditor} or null if not found.
	 */
	public static IMultiDiagramEditor getMultiDiagramEditor() {
		// Lookup ServiceRegistry
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(workbenchWindow == null) {
			return null;
		}
		IWorkbenchPage page = workbenchWindow.getActivePage();
		if(page == null) {
			return null;
		}
		IEditorPart editor = page.getActiveEditor();
		if(editor instanceof IMultiDiagramEditor) {
			return (IMultiDiagramEditor)editor;
		} else {
			return null;
		}
	}

	/**
	 * Get the service registry of the currently active main editor.
	 * 
	 * @return The {@link ServicesRegistry} or null if not found.
	 */
	static public ServicesRegistry getServiceRegistry() {
		// Lookup ServiceRegistry
		IMultiDiagramEditor editor = getMultiDiagramEditor();
		return editor == null ? null : (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
	}

	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * 
	 * @return the ISashWindowsContentProvider from the main editor or null if not found.
	 */
	static public ISashWindowsContentProvider getISashWindowsContentProvider() {
		IEditorPart editorPart = getMultiDiagramEditor();
		return editorPart == null ? null : (ISashWindowsContentProvider)editorPart
				.getAdapter(ISashWindowsContentProvider.class);

	}

	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * 
	 * @return the ISashWindowsContentProvider from the main editor or null if not found.
	 */
	public static IPageMngr getIPageMngr() {
		IMultiDiagramEditor editorPart = getMultiDiagramEditor();
		return editorPart == null ? null : (IPageMngr)editorPart.getAdapter(IPageMngr.class);
	}

	/**
	 * Get the Eclipse ActiveEditor.
	 * 
	 * @return The active {@link CoreMultiDiagramEditor} or null if not found.
	 * @deprecated Use {@link EditorUtils#getMultiDiagramEditor()}
	 */
	@Deprecated
	public static IEditorPart getWorkbenchActiveEditor() {
		IMultiDiagramEditor editorPart = getMultiDiagramEditor();
		if(editorPart instanceof CoreMultiDiagramEditor) {
			return editorPart;
		} else {
			return null;
		}
	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource.
	 * This instance is suitable to add, remove, close or open diagrams.
	 * 
	 * @param diResource
	 * @return The non transactional implementation of IPageMngr
	 */
	public static IPageMngr getIPageMngr(Resource diResource) {
		return DiSashModelMngr.createIPageMngr(diResource);
	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource.
	 * This instance is suitable to add, remove, close or open diagrams.
	 * 
	 * @param diResource
	 * @param editingDomain
	 * 
	 * @return The transactional implementation of IPageMngr
	 */
	public static IPageMngr getTransactionalIPageMngr(Resource diResource, TransactionalEditingDomain editingDomain) {
		return TransactionalDiSashModelMngr.createIPageMngr(diResource, editingDomain);
	}

	/**
	 * Lookup the currently active Diagram from the Papyrus editor. Return the current Diagram
	 * or null if none is active.
	 * TODO This method introduce dependency on GMF. It can be moved to a GMF plugin.
	 * 
	 * @return The active diagram or null if not found.
	 */
	public static Diagram lookupEditorActiveDiagram() {
		DiagramEditor diagEditor = lookupActiveDiagramEditor();
		return diagEditor == null ? null : diagEditor.getDiagram();
	}

	/**
	 * Lookup the currently active Diagram from the Papyrus editor. Return the current Diagram or
	 * null if none is active. 
	 * TODO This method introduce dependency on GMF. It can be moved to a GMF plugin.
	 * 
	 * @return the active diagram editor or null if not found.
	 */
	public static DiagramEditor lookupActiveDiagramEditor() {
		// Get the active page within the sashcontainer
		IEditorPart activeEditor = lookupSashSystemActiveIEditor();
		// Check if it is a GMF DiagramEditor
		if(activeEditor instanceof DiagramEditor) {
			return ((DiagramEditor)activeEditor);
		} else {
			// Not found
			return null;
		}

	}

	/**
	 * Lookup the currently active Diagram from the Papyrus editor. Return the current Diagram
	 * or null if none is active.
	 * TODO This method introduce dependency on GMF. It can be moved to a GMF plugin.
	 * 
	 * @return
	 */
	private static IEditorPart lookupSashSystemActiveIEditor() {
		// Get the sashwindow container
		ISashWindowsContainer container = getSashWindowContainer();
		// Get the active page within the sashcontainer
		return container == null ? null : container.getActiveEditor();
	}

	/**
	 * Lookup the currently active IEditor in the SashSystem.
	 * If the currently eclipse active editor doesn't contains a {@link ISashWindowsContainer}, return null.
	 * If the current SashSystem page is not a IEditor, return null.
	 * 
	 * @return
	 */
	public static IPage lookupSashSystemActivePage() {
		// Get the sashwindow container
		ISashWindowsContainer container = getSashWindowContainer();
		// Get the active page within the sashcontainer
		return container == null ? null : container.getActiveSashWindowsPage();
	}

	private static ISashWindowsContainer getSashWindowContainer() {
		// First, lookup the main editor.
		IMultiDiagramEditor editorPart = getMultiDiagramEditor();
		// Get the sashwindow container
		return editorPart == null ? null : (ISashWindowsContainer)editorPart.getAdapter(ISashWindowsContainer.class);
	}

	/**
	 * Gets the di resource set.
	 * 
	 * @return Get the current {@link DiResourceSet} or null if not found.
	 */
	public static DiResourceSet getDiResourceSet() {
		try {
			ServicesRegistry registry = getServiceRegistry();
			return registry == null ? null : registry.getService(DiResourceSet.class);
		} catch (ServiceException e) {
			// FIXME wait to use log
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the transactional editing domain.
	 * 
	 * @return Get the current {@link TransactionalEditingDomain} or null if not found
	 */
	public static TransactionalEditingDomain getTransactionalEditingDomain() {
		try {
			ServicesRegistry registry = getServiceRegistry();
			return registry == null ? null : registry.getService(TransactionalEditingDomain.class);
		} catch (IllegalStateException e) {
			// Registry can't be found, do nothing.
		} catch (ServiceException e) {
			// FIXME wait to use log
			e.printStackTrace();
		}
		return null;
	}

}
