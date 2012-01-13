package org.eclipse.papyrus.infra.hyperlink.object;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistryExtended;
import org.eclipse.papyrus.infra.core.editorsfactory.PageIconsRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.internal.IEditorLabelProvider;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperLinkEditorShell;
import org.eclipse.uml2.uml.Package;


public abstract class HyperLinkEditor extends HyperLinkObject implements IEditorLabelProvider{
	/**
	 * the icon registry
	 */
	private static IPageIconsRegistry editorRegistry;

	/**
	 * Get the EditorRegistry used to create editor instances. This default
	 * implementation return the singleton eINSTANCE. This method can be
	 * subclassed to return another registry.
	 * 
	 * @return the singleton eINSTANCE of editor registry
	 */
	protected IPageIconsRegistryExtended getEditorRegistry() {
		if(editorRegistry == null) {
			editorRegistry = createEditorRegistry();
		}
		if(!(editorRegistry instanceof IPageIconsRegistryExtended)) {
			throw new RuntimeException("The editor registry do not implement IPageIconsRegistryExtended");////$NON-NLS-1$
		}
		return (IPageIconsRegistryExtended)editorRegistry;
	}

	/**
	 * Return the EditorRegistry for nested editor descriptors. Subclass should
	 * implements this method in order to return the registry associated to the
	 * extension point namespace.
	 * 
	 * @return the EditorRegistry for nested editor descriptors
	 *         FIXME : use a deprecated method
	 */
	protected IPageIconsRegistry createEditorRegistry() {
		try {
			return EditorUtils.getServiceRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// Not found, return an empty one which return null for each
			// request.
			return new PageIconsRegistry();
		}
	}

	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.ui.hyperlinkshell.HyperlinkObject#executeSelectPressed()
	 * 
	 */
	@Override
	public void executeSelectPressed() {
		IPageMngr pageMngr = EditorUtils.getIPageMngr();
		try {
			pageMngr.openPage(getObject());
		} catch (Exception e) {
			Activator.log.error(e);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void executeEditMousePressed(List<HyperLinkObject> list, EObject amodel) {
		IPageIconsRegistry editorRegistry=null;
		IMultiDiagramEditor papyrusEditor=EditorUtils.getMultiDiagramEditor();
		try {
			editorRegistry= papyrusEditor.getServicesRegistry().getService(IPageIconsRegistry.class);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EditorHyperLinkEditorShell editor = new EditorHyperLinkEditorShell(editorRegistry, amodel);
		editor.setHyperLinkEditor(this);
		editor.open();
		if(editor.getHyperLinkEditor() != null) {
			int index = list.indexOf(this);
			list.remove(this);
			list.add(index,editor.getHyperLinkEditor());
		}
	}
}
