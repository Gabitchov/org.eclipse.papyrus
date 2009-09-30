/**
 * 
 */
package org.eclipse.papyrus.core.utils;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.services.IService;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.papyrus.sasheditor.contentprovider.di.DiSashModelMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.papyrus.sasheditor.contentprovider.di.TransactionalDiSashModelMngr;
import org.eclipse.papyrus.sasheditor.editor.IPage;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;


/**
 * Set of utility methods for the CoreEditor.
 * @author dumoulin
 */
public class EditorUtils {

	/**
	 * Get the service registry of the currently active main editor.
	 * @return The ServiceRegistry or null if not found.
	 */
	static public ServicesRegistry getServiceRegistry()
	{
			// Lookup ServiceRegistry
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if(page==null)
				throw new IllegalStateException("No Active Page can be found. So no Service Registry can be returned.");
			IEditorPart editorPart = page.getActiveEditor();
			if(editorPart==null)
				throw new IllegalStateException("No Active Editor can be found. So no Service Registry can be returned.");
			if( ! (editorPart instanceof CoreMultiDiagramEditor) )
				throw new IllegalStateException("No CoreMultiDiagramEditor  can be found. So no Service Registry can be returned.");
				
			return (ServicesRegistry)editorPart.getAdapter(ServicesRegistry.class);
	}
	
	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * @return
	 */
	static public ISashWindowsContentProvider getISashWindowsContentProvider() {
			// Lookup ServiceRegistry
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorPart editorPart = page.getActiveEditor();
			return (ISashWindowsContentProvider)editorPart.getAdapter(ISashWindowsContentProvider.class);

	}

	/**
	 * Get the ISashWindowsContentProvider from the main editor.
	 * @return
	 * @throws IllegalStateException If there is no ActiveEditor (generally during editor initializing).
	 */
	static public IPageMngr getIPageMngr() throws IllegalStateException {
			// Lookup ServiceRegistry
			IEditorPart editorPart = getWorkbenchActiveEditor();
			return (IPageMngr)editorPart.getAdapter(IPageMngr.class);

	}

	/**
	 * Get the Eclipse ActiveEditor.
	 * @return
	 * @throws IllegalStateException If there is no ActiveEditor (generally during editor initializing).
	 */
	static public IEditorPart getWorkbenchActiveEditor() throws IllegalStateException {
		// Lookup ServiceRegistry
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if(page==null)
			throw new IllegalStateException("No Active Page can be found.");
		IEditorPart editorPart = page.getActiveEditor();
		if(editorPart==null)
			throw new IllegalStateException("No Active Editor can be found.");
		if( ! (editorPart instanceof CoreMultiDiagramEditor) )
			throw new IllegalStateException("No CoreMultiDiagramEditor can be found.");
			
		return editorPart;
		
	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource.
	 * This instance is suitable to add, remove, close or open diagrams.	 
	 * @param diResource
	 * @return The non transactional implementation of IPageMngr
	 */
	public static IPageMngr getIPageMngr(Resource diResource) {
		return DiSashModelMngr.createIPageMngr(diResource);
	}

	/**
	 * Create an instance of IPageMngr acting on the provided resource.
	 * This instance is suitable to add, remove, close or open diagrams.	 
	 * @param diResource
	 * @return The transactional implementation of IPageMngr
	 */
	public static IPageMngr getTransactionalIPageMngr(Resource diResource, TransactionalEditingDomain editingDomain) {
		return TransactionalDiSashModelMngr.createIPageMngr(diResource, editingDomain);
		
	}

	/**
	 * Lookup the currently active Diagram from the Papyrus editor. Return the current Diagram
	 * or null if none is active.
	 * TODO This method introduce dependency on GMF. It can be moved to a GMF plugin.
	 * @return
	 */
	public static Diagram lookupEditorActiveDiagram()
	{
		// First, lookup the main editor. 
        IEditorPart editorPart = getWorkbenchActiveEditor();
        // Get the sashwindow container
        ISashWindowsContainer container = (ISashWindowsContainer)editorPart.getAdapter(ISashWindowsContainer.class);
 
        // Get the active page within the sashcontainer
        IEditorPart activeEditor = container.getActiveEditor();
        // Check if it is a GMF DiagramEditor
        if( activeEditor instanceof DiagramEditor)
        {
        	DiagramEditor editor = (DiagramEditor)activeEditor;
        	return editor.getDiagram();
        }
        
        // Not found
        return null;
		
	}
	
	/**
	 * Lookup the currently active IEditor in the SashSystem. 
	 * If the currently eclipse active editor doesn't contains a {@link ISashWindowsContainer}, return null.
	 * If the current SashSystem page is not a IEditor, return null.
	 * @return
	 * TODO : move in a SashUtils class inside Sash ?
	 */
	public static IEditorPart lookupSashSystemActiveIEditor()
	{
		// First, lookup the main editor. 
        IEditorPart editorPart = getWorkbenchActiveEditor();
        if(editorPart == null)
        	return null;
        // Get the sashwindow container
        ISashWindowsContainer container = (ISashWindowsContainer)editorPart.getAdapter(ISashWindowsContainer.class);
        if( container == null)
        	return null;
        
        // Get the active page within the sashcontainer
        return container.getActiveEditor();
	}
	
	/**
	 * Lookup the currently active {@link IPage} in the SashSystem. 
	 * If the currently eclipse active editor doesn't contains a {@link ISashWindowsContainer}, return null.
	 * If the current SashSystem page is not a IEditor, return null.
	 * @return
	 * TODO : move in a SashUtils class inside Sash ?
	 */
	public static IPage lookupSashSystemActivePage()
	{
		// First, lookup the main editor. 
        IEditorPart editorPart = getWorkbenchActiveEditor();
        if(editorPart == null)
        	return null;
        // Get the sashwindow container
        ISashWindowsContainer container = (ISashWindowsContainer)editorPart.getAdapter(ISashWindowsContainer.class);
        if( container == null)
        	return null;
        
        // Get the active page within the sashcontainer
        return container.getActiveSashWindowsPage();
	}
}
