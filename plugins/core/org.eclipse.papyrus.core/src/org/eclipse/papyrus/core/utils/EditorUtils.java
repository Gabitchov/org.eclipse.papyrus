/**
 * 
 */
package org.eclipse.papyrus.core.utils;

import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.services.IService;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.ISashWindowsContentProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;


/**
 * St of utility methods for the CoreEditor.
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

}
