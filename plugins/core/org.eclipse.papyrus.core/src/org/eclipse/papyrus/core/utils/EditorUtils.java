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

import static org.eclipse.papyrus.core.Activator.log;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Set of utility methods for the CoreEditor.
 * 
 * WARNING : Some of these methods rely on PlatformUI.getWorkbench().getActiveWorkbenchWindow()getActivePage() to
 * lookup for shared objects owned by the main editor. This doesn't work during the initialization of the main editor
 * because the main editor is not yet registered in the Eclipse workbench. This can lead to a null or an exception,
 * and sometime this can lead to getting the shared object of another main editor !
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
	 * Gets the opened multi-diagram editors.
	 * 
	 * @return The opened {@link IMultiDiagramEditor} or null if an error occured.
	 */
	public static IMultiDiagramEditor[] getMultiDiagramEditors() {
		// Lookup ServiceRegistry
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if(workbenchWindow == null) {
			return null;
		}
		IWorkbenchPage page = workbenchWindow.getActivePage();
		if(page == null) {
			return null;
		}
		List<IMultiDiagramEditor> list = new ArrayList<IMultiDiagramEditor>();
		for(IEditorReference editorRef : page.getEditorReferences()) {
			IEditorPart editorPart = editorRef.getEditor(false);
			if(editorPart instanceof IMultiDiagramEditor) {
				list.add((IMultiDiagramEditor)editorPart);
			}
		}
		return list.toArray(new IMultiDiagramEditor[list.size()]);
	}

	/**
	 * Returns the editors that are related to to given file.<BR>
	 * 
	 * @param file
	 *        The file (model, di or notation).
	 * @return The associated editors.
	 */
	public static IMultiDiagramEditor[] getRelatedEditors(IFile file) {
		// Get the DI file
		IFile diFile = DiResourceSet.getRelatedDiFile(file);
		if(diFile == null || !diFile.exists()) {
			return new IMultiDiagramEditor[0];
		}

		IMultiDiagramEditor[] openedEditors = EditorUtils.getMultiDiagramEditors();
		if(openedEditors == null) {
			return new IMultiDiagramEditor[0];
		}
		List<IMultiDiagramEditor> list = new ArrayList<IMultiDiagramEditor>(openedEditors.length);

		for(IMultiDiagramEditor editorPart : openedEditors) {
			if(editorPart.getEditorInput() instanceof IFileEditorInput && diFile.equals(((IFileEditorInput)editorPart.getEditorInput()).getFile())) {
				list.add(editorPart);
			}
		}
		return list.toArray(new IMultiDiagramEditor[list.size()]);
	}

	/**
	 * Get the service registry of the currently active main editor. <br>
	 * WARNING - This method doesn't work during the initialization of the main editor. See note in class doc.
	 * 
	 * @return The {@link ServicesRegistry} or null if not found.
	 */
	static public ServicesRegistry getServiceRegistry() {
		// Lookup ServiceRegistry
		IMultiDiagramEditor editor = getMultiDiagramEditor();
		return editor == null ? null : (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
	}

	/**
	 * Get the service registry of the currently active main editor. <br>
	 * WARNING - This method doesn't work during the initialization of the main editor. See note in class doc.
	 * 
	 * @return The {@link ServicesRegistry} or null if not found.
	 * @throws ServiceException If an error occurs.
	 */
	static public ServicesRegistry getServiceRegistryChecked() throws ServiceException {
		// Lookup ServiceRegistry
		IMultiDiagramEditor editor = getMultiDiagramEditor();
		if( editor == null ) {
			throw new ServiceException("Can't get ServiceRegistry");
		}
		
		return (ServicesRegistry)editor.getAdapter(ServicesRegistry.class);
	}

	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * 
	 * @return the ISashWindowsContentProvider from the main editor or null if not found.
	 */
	static public ISashWindowsContentProvider getISashWindowsContentProvider() {
		IEditorPart editorPart = getMultiDiagramEditor();
		return editorPart == null ? null : (ISashWindowsContentProvider)editorPart.getAdapter(ISashWindowsContentProvider.class);

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
			log.error(e);
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
			log.error(e);
		}
		return null;
	}

}
