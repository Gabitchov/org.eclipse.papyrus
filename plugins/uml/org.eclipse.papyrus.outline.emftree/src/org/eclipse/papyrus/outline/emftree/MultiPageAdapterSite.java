/**
 * 
 */
package org.eclipse.papyrus.outline.emftree;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorActionBarContributor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.internal.services.INestable;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.part.MultiPageEditorSite;


/**
 * A site made of a main site and another ActionarContributor.
 * 
 * @author dumoulin
 *
 */
public class MultiPageAdapterSite implements IEditorSite, INestable {

	/**
	 * The actionBarContributor to use instead of the one in the site.
	 */
	private EditorActionBarContributor actionBarContributor;
	
	/**
	 * The site to which methods delegate.
	 */
	private IEditorSite site;
	
	/**
	 * Constructor.
	 * @param workbenchPartSite
	 * @param actionBarContributor
	 */
	public MultiPageAdapterSite(IEditorSite site, EditorActionBarContributor actionBarContributor) {
		super();
		this.site = site;
		this.actionBarContributor = actionBarContributor;
	}
	/**
	 * @see org.eclipse.ui.IEditorSite#getActionBarContributor()
	 * @return
	 * 
	 */
	public IEditorActionBarContributor getActionBarContributor() {
		
		return actionBarContributor;
	}

	/**
	 * @see org.eclipse.ui.IEditorSite#getActionBars()
	 * @return
	 * 
	 */
	public IActionBars getActionBars() {
		return site.getActionBars();
	}

	/**
	 * @see org.eclipse.ui.IEditorSite#registerContextMenu(org.eclipse.jface.action.MenuManager, org.eclipse.jface.viewers.ISelectionProvider, boolean)
	 * @param menuManager
	 * @param selectionProvider
	 * @param includeEditorInput
	 * 
	 */
	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider, boolean includeEditorInput) {
		site.registerContextMenu(menuManager, selectionProvider, includeEditorInput);
	}

	/**
	 * @see org.eclipse.ui.IEditorSite#registerContextMenu(java.lang.String, org.eclipse.jface.action.MenuManager, org.eclipse.jface.viewers.ISelectionProvider, boolean)
	 * @param menuId
	 * @param menuManager
	 * @param selectionProvider
	 * @param includeEditorInput
	 * 
	 */
	public void registerContextMenu(String menuId, MenuManager menuManager, ISelectionProvider selectionProvider, boolean includeEditorInput) {
		site.registerContextMenu(menuId, menuManager, selectionProvider, includeEditorInput);

	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getId()
	 * @return
	 * 
	 */
	public String getId() {
		return site.getId();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getKeyBindingService()
	 * @return
	 * @deprecated
	 * 
	 */
	public IKeyBindingService getKeyBindingService() {
		return site.getKeyBindingService();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getPart()
	 * @return
	 * 
	 */
	public IWorkbenchPart getPart() {
		return site.getPart();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getPluginId()
	 * @return
	 * 
	 */
	public String getPluginId() {
		return site.getPluginId();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#getRegisteredName()
	 * @return
	 * 
	 */
	public String getRegisteredName() {
		return site.getRegisteredName();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#registerContextMenu(org.eclipse.jface.action.MenuManager, org.eclipse.jface.viewers.ISelectionProvider)
	 * @param menuManager
	 * @param selectionProvider
	 * 
	 */
	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider) {
		site.registerContextMenu(menuManager, selectionProvider);

	}

	/**
	 * @see org.eclipse.ui.IWorkbenchPartSite#registerContextMenu(java.lang.String, org.eclipse.jface.action.MenuManager, org.eclipse.jface.viewers.ISelectionProvider)
	 * @param menuId
	 * @param menuManager
	 * @param selectionProvider
	 * 
	 */
	public void registerContextMenu(String menuId, MenuManager menuManager, ISelectionProvider selectionProvider) {
		site.registerContextMenu(menuId, menuManager, selectionProvider);

	}

	/**
	 * @see org.eclipse.ui.IWorkbenchSite#getPage()
	 * @return
	 * 
	 */
	public IWorkbenchPage getPage() {
		return site.getPage();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchSite#getSelectionProvider()
	 * @return
	 * 
	 */
	public ISelectionProvider getSelectionProvider() {
		return site.getSelectionProvider();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchSite#getShell()
	 * @return
	 * 
	 */
	public Shell getShell() {
		return site.getShell();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchSite#getWorkbenchWindow()
	 * @return
	 * 
	 */
	public IWorkbenchWindow getWorkbenchWindow() {
		return site.getWorkbenchWindow();
	}

	/**
	 * @see org.eclipse.ui.IWorkbenchSite#setSelectionProvider(org.eclipse.jface.viewers.ISelectionProvider)
	 * @param provider
	 * 
	 */
	public void setSelectionProvider(ISelectionProvider provider) {
		site.setSelectionProvider(provider);

	}

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * @param adapter
	 * @return
	 * 
	 */
	public Object getAdapter(Class adapter) {
		return site.getAdapter(adapter);
	}

	/**
	 * @see org.eclipse.ui.services.IServiceLocator#getService(java.lang.Class)
	 * @param api
	 * @return
	 * 
	 */
	public Object getService(Class api) {
		return site.getService(api);
	}

	/**
	 * @see org.eclipse.ui.services.IServiceLocator#hasService(java.lang.Class)
	 * @param api
	 * @return
	 * 
	 */
	public boolean hasService(Class api) {
		return site.hasService(api);
	}
	
	/**
	 * 
	 * @see org.eclipse.ui.internal.services.INestable#activate()
	 *
	 */
	public void activate() {
		if(site instanceof INestable )
		  ((INestable)site).activate();
	}
	/**
	 * 
	 * @see org.eclipse.ui.internal.services.INestable#deactivate()
	 *
	 */
	public void deactivate() {
		if(site instanceof INestable )
			  ((INestable)site).deactivate();
	}

}
