/**
 * 
 */
package org.eclipse.papyrus.extensionpoints.editors.ui;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.extensionpoints.editors.definition.DirectEditorExtensionPoint;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IServiceLocator;

/**
 * 
 */
public class DirectEditorsContributionItem extends ContributionItem implements IWorkbenchContribution {

	/**
	 * Service locator given to this contribution item using the {@link IWorkbenchContribution} interface.
	 */
	private IServiceLocator serviceLocator;

	private MenuItem subMenuItem;

	/**
	 * 
	 */
	public DirectEditorsContributionItem() {
		setId("org.eclipse.papyrus.editors.menuitem");
	}

	/**
	 * @param id
	 */
	public DirectEditorsContributionItem(String id) {
		super(id);
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void dispose() {
		if(subMenuItem != null && !subMenuItem.isDisposed()) {
			subMenuItem.dispose();
		}
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void fill(Composite parent) {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void fill(Menu menu, int index) {
		// retrieves current selection
		final Object selectedElement = getSelectedElement();

		// first case: this class was not able to retrieve the selection service
		// or does not understand the current selection.
		// does not build any sub-menu and returns.
		if(selectedElement == null) {
			return;
		}

		// get the uml object type of this element, using the business resolver
		final Object businessObject = EMFHelper.getEObject(selectedElement);

		// no object found: exit
		if(businessObject == null) {
			return;
		}

		// retrieves all editor configurations for this kind of element
		final Collection<DirectEditorExtensionPoint> configurations = DirectEditorExtensionPoint.getDirectEditorConfigurations(businessObject.getClass());

		// if configurations is not empty, a submenu should open to select which
		// editor to use...

		if(configurations.size() < 1) {
			return;
		}

		createSubMenu(menu, index, businessObject, configurations);
	}

	// creates the submenu "open editors" > "edit with UML", "edit with AL", etc
	protected void createSubMenu(Menu menu, int index, Object businessObject, Collection<DirectEditorExtensionPoint> configurations) {
		// create direct item, and then create sub-items
		subMenuItem = new MenuItem(menu, SWT.CASCADE);
		String type = ((businessObject instanceof EObject) ? ((EObject)businessObject).eClass().getName() : "");

		subMenuItem.setText("Edit " + type);

		// submenu
		Menu subMenu = new Menu(menu);
		subMenuItem.setMenu(subMenu);

		// items on the submenu
		// there are as many items as configurations
		Class fullType = ((businessObject instanceof EObject) ? ((EObject)businessObject).eClass().getInstanceClass() : null);
		final DirectEditorExtensionPoint defaultConfig = DirectEditorExtensionPoint.getDefautDirectEditorConfiguration(fullType);

		for(final DirectEditorExtensionPoint configuration : configurations) {
			MenuItem item = new MenuItem(subMenu, SWT.NONE);
			StringBuffer buffer = new StringBuffer();
			buffer.append("Using ");
			buffer.append(configuration.getLanguage());
			buffer.append(" Editor");
			if(configuration.equals(defaultConfig)) {
				buffer.append(" (Default)");
			}
			item.setText(buffer.toString());
			item.addSelectionListener(new SelectionListener() {

				/**
				 * {@inheritDoc}
				 */
				public void widgetDefaultSelected(SelectionEvent e) {

				}

				/**
				 * {@inheritDoc}
				 */
				public void widgetSelected(SelectionEvent e) {
					// launch editor
					GMFEmbeddedEditorActionDelegate actionDelegate = new GMFEmbeddedEditorActionDelegate();
					actionDelegate.setActivePart(null, ((CoreMultiDiagramEditor)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()).getActiveEditor());
					actionDelegate.selectionChanged(null, getSelection());
					actionDelegate.setExtensionPointConfiguration(configuration);
					actionDelegate.run(null);
				}
			});
		}
	}

	/**
	 * Retrieves and return the current selected element
	 * 
	 * @return the current selected element
	 */
	protected Object getSelectedElement() {
		ISelection selection = getSelection();
		// this checks if it is the good instance AND if it is not null
		if(selection instanceof IStructuredSelection) {
			return ((IStructuredSelection)selection).getFirstElement();
		}
		return null;
	}

	/**
	 * Retrieves and return the current selection
	 * 
	 * @return the current selection
	 */
	protected ISelection getSelection() {
		ISelectionService selectionService = getSelectionService();
		if(selectionService != null) {
			return selectionService.getSelection();
		}
		return null;
	}

	/**
	 * Returns the selection service for the current workbench
	 * 
	 * @return the selection service for the current workbench or <code>null</code> if no selection
	 *         service was found.
	 */
	protected ISelectionService getSelectionService() {
		ISelectionService selectionService = (ISelectionService)serviceLocator.getService(ISelectionService.class);
		return selectionService;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void fill(ToolBar parent, int index) {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 * 
	 * @since 3.0
	 */
	@Override
	public void fill(CoolBar parent, int index) {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 * 
	 * @since 3.0
	 */
	@Override
	public void saveWidgetState() {
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isDirty() {
		// @issue should this be false instead of calling isDynamic()?
		return true;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>true</code>. Subclasses may override.
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isDynamic() {
		return true;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isGroupMarker() {
		return false;
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method returns <code>false</code>. Subclasses may override.
	 */
	@Override
	public boolean isSeparator() {
		return false;
	}

	/**
	 * Returns a string representation of this contribution item suitable only for debugging.
	 */
	@Override
	public String toString() {
		return getClass().getName() + "(id=" + getId() + ")";//$NON-NLS-2$//$NON-NLS-1$
	}

	/**
	 * The default implementation of this <code>IContributionItem</code> method does nothing.
	 * Subclasses may override.
	 */
	@Override
	public void update() {
	}

	/**
	 * The <code>ContributionItem</code> implementation of this method declared on <code>IContributionItem</code> does nothing. Subclasses should
	 * override to update their
	 * state.
	 */
	@Override
	public void update(String id) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void initialize(IServiceLocator serviceLocator) {
		assert (serviceLocator != null);
		this.serviceLocator = serviceLocator;
	}

}
