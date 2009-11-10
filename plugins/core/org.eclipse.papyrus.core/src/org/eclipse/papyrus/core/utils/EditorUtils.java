/**
 * 
 */
package org.eclipse.papyrus.core.utils;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Set of utility methods for the CoreEditor.
 * 
 * @author cedric dumoulin
 */
public class EditorUtils {

	/**
	 * Gets the active <IEditorPart>.
	 * 
	 * @return the active editor or null if none.
	 */
	public static IEditorPart getActiveEditor() {
		IWorkbench wb = PlatformUI.getWorkbench();
		if (wb != null) {
			IWorkbenchWindow ww = wb.getActiveWorkbenchWindow();
			if (ww != null) {
				IWorkbenchPage wp = ww.getActivePage();
				if (wp != null) {
					return wp.getActiveEditor();
				}
			}
		}
		return null;
	}

	/**
	 * Gets the multi diagram editor.
	 * 
	 * @return Get the current {@link IMultiDiagramEditor} or null if not found.
	 */
	public static IMultiDiagramEditor getMultiDiagramEditor() {
		IEditorPart editor = getActiveEditor();
		if (editor instanceof IMultiDiagramEditor) {
			IMultiDiagramEditor multiDiagramEditor = (IMultiDiagramEditor) editor;
			return multiDiagramEditor;
		}
		return null;
	}

	/**
	 * Get the service registry of the currently active main editor.
	 * 
	 * @return The {@link ServicesRegistry} or null if not found.
	 */
	public static ServicesRegistry getServiceRegistry() {
		// Lookup ServiceRegistry
		IMultiDiagramEditor multiEditor = getMultiDiagramEditor();
		if (multiEditor != null) {
			return multiEditor.getServicesRegistry();
		} else {
			return null;
		}
	}

	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * 
	 * @return
	 */
	public static ISashWindowsContentProvider getISashWindowsContentProvider() {
		// Lookup ServiceRegistry
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		return (ISashWindowsContentProvider) editorPart.getAdapter(ISashWindowsContentProvider.class);
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
		} catch (ServiceException e) {
			// FIXME wait to use log
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * 
	 * @return The {@link IPageMngr} or null if the active editor is not a multi-editor one.
	 * 
	 * @throws IllegalStateException
	 *             If there is no ActiveEditor (generally during editor initializing).
	 */
	public static IPageMngr getIPageMngr() throws IllegalStateException {
		// Lookup ServiceRegistry
		IEditorPart editorPart = getActiveEditor();
		if (editorPart == null) {
			// FIXME it would be more useful to return null...
			throw new IllegalStateException("Error getting the Multi-Diagram Editor");
		}
		return (IPageMngr) editorPart.getAdapter(IPageMngr.class);

	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource. This instance is suitable to
	 * add, remove, close or open diagrams.
	 * 
	 * @param diResource
	 * @return The non transactional implementation of IPageMngr
	 */
	public static IPageMngr getIPageMngr(Resource diResource) {
		return DiSashModelMngr.createIPageMngr(diResource);
	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource. This instance is suitable to
	 * add, remove, close or open diagrams.
	 * 
	 * @param diResource
	 * @return The transactional implementation of IPageMngr
	 */
	public static IPageMngr getTransactionalIPageMngr(Resource diResource, TransactionalEditingDomain editingDomain) {
		return TransactionalDiSashModelMngr.createIPageMngr(diResource, editingDomain);

	}

	/**
	 * Lookup the currently active Diagram from the Papyrus editor. Return the current Diagram or
	 * null if none is active. TODO This method introduce dependency on GMF. It can be moved to a
	 * GMF plugin.
	 * 
	 * @return
	 */
	// @unused
	public static Diagram lookupEditorActiveDiagram() {
		// First, lookup the main editor.
		IEditorPart editorPart = getActiveEditor();
		if (editorPart == null) {
			return null;
		}
		// Get the sashwindow container
		ISashWindowsContainer container = (ISashWindowsContainer) editorPart.getAdapter(ISashWindowsContainer.class);

		// Get the active page within the sashcontainer
		IEditorPart activeEditor = container.getActiveEditor();
		// Check if it is a GMF DiagramEditor
		if (activeEditor instanceof DiagramEditor) {
			DiagramEditor editor = (DiagramEditor) activeEditor;
			return editor.getDiagram();
		}

		// Not found
		return null;

	}

	/**
	 * Lookup the currently active IEditor in the SashSystem. If the currently eclipse active editor
	 * doesn't contains a {@link ISashWindowsContainer}, return null. If the current SashSystem page
	 * is not a IEditor, return null.
	 * 
	 * @return
	 */
	// @unused
	public static IEditorPart lookupSashSystemActiveIEditor() {
		// First, lookup the main editor.
		IEditorPart editorPart = getActiveEditor();
		if (editorPart == null) {
			return null;
		}
		// Get the sashwindow container
		ISashWindowsContainer container = (ISashWindowsContainer) editorPart.getAdapter(ISashWindowsContainer.class);
		if (container == null) {
			return null;
		}

		// Get the active page within the sashcontainer
		return container.getActiveEditor();
	}

	/**
	 * Lookup the currently active {@link IPage} in the SashSystem. If the currently eclipse active
	 * editor doesn't contains a {@link ISashWindowsContainer}, return null. If the current
	 * SashSystem page is not a IEditor, return null.
	 * 
	 * @return
	 */
	// @unused
	public static IPage lookupSashSystemActivePage() {
		// First, lookup the main editor.
		IEditorPart editorPart = getActiveEditor();
		if (editorPart == null) {
			return null;
		}
		// Get the sashwindow container
		ISashWindowsContainer container = (ISashWindowsContainer) editorPart.getAdapter(ISashWindowsContainer.class);
		if (container == null) {
			return null;
		}

		// Get the active page within the sashcontainer
		return container.getActiveSashWindowsPage();
	}
}
