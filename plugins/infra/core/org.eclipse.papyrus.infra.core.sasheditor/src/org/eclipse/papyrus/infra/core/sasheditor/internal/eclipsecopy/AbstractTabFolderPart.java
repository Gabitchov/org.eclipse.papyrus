/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.internal.eclipsecopy;

import org.eclipse.papyrus.infra.core.sasheditor.internal.AbstractPanelPart;
import org.eclipse.papyrus.infra.core.sasheditor.internal.IPanelParent;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Copy of org.eclipse.ui.part.MultiPageEditorPart. Change if to be suitable has a sash leaf. A multi-page editor is an editor with multiple pages,
 * each of which may contain an editor or an arbitrary
 * SWT control.
 * <p>
 * This class is intented to separate folder stuff into 2 classes. Subclasses must implement the following methods:
 * <ul>
 * <li><code>createPages</code> - to create the required pages by calling one of the <code>addPage</code> methods</li>
 * <li><code>IEditorPart.doSave</code> - to save contents of editor</li>
 * <li><code>IEditorPart.doSaveAs</code> - to save contents of editor</li>
 * <li><code>IEditorPart.isSaveAsAllowed</code> - to enable Save As</li>
 * <li><code>IEditorPart.gotoMarker</code> - to scroll to a marker</li>
 * </ul>
 * </p>
 * <p>
 * Multi-page editors have a single action bar contributor, which manages contributions for all the pages. The contributor must be a subclass of
 * <code>AbstractMultiPageEditorActionBarContributor</code>. Note that since any nested editors are created directly in code by callers of
 * <code>addPage(IEditorPart,IEditorInput)</code>, nested editors do not have their own contributors.
 * </p>
 * 
 * @see org.eclipse.ui.part.MultiPageEditorActionBarContributor
 */
public abstract class AbstractTabFolderPart extends AbstractPanelPart {

	/**
	 * Subclasses that override {@link #createPageContainer(Composite)} can use this constant to get a site for the container that can be active while
	 * the current page is deactivated.
	 * 
	 * @since 3.4
	 * @see #activateSite()
	 * @see #deactivateSite(boolean, boolean)
	 * @see #getPageSite(int)
	 */
	protected static final int PAGE_CONTAINER_SITE = 65535;

	//	/**
	//	 * Private tracing output.
	//	 */
	//	private static final String TRACING_COMPONENT = "MPE"; //$NON-NLS-1$

	//	/**
	//	 * The active service locator. This value may be <code>null</code> if there is no selected page, or if the selected page is a control with no site.
	//	 */
	//	private INestable activeServiceLocator;
	//
	//
	//	private IServiceLocator pageContainerSite;

	/**
	 * Creates an empty multi-page editor with no pages.
	 */
	protected AbstractTabFolderPart(IPanelParent parent) {
		super(parent);
	}

	/**
	 * The <code>MultiPageEditor</code> implementation of this <code>IWorkbenchPart</code> method creates the control for the multi-page editor by
	 * calling <code>createContainer</code>, then <code>createPages</code>. Subclasses should implement <code>createPages</code> rather than
	 * overriding this method.
	 * 
	 * @param parent
	 *        The parent in which the editor should be created; must not be <code>null</code>.
	 */
	@Override
	abstract public void createPartControl(Composite parent);

	/**
	 * Returns the active nested editor if there is one.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 * 
	 * @return the active nested editor, or <code>null</code> if none
	 */
	//	public IEditorPart getActiveEditor() {
	//		int index = getActivePage();
	//		if (index != -1) {
	//			return getEditor(index);
	//		}
	//		return null;
	//	}

	/**
	 * Returns the index of the currently active page of this folder, or -1 if there is no active page.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 * 
	 * @return the index of the active page, or -1 if there is no active page
	 */
	protected int getActivePage() {
		CTabFolder tabFolder = getTabFolder();
		if(tabFolder != null && !tabFolder.isDisposed()) {
			return tabFolder.getSelectionIndex();
		}
		return -1;
	}

	/**
	 * Returns the control for the given page index, or <code>null</code> if no control has been set for the page. The page index must be valid.
	 * <p>
	 * Subclasses should not override this method
	 * </p>
	 * 
	 * @param pageIndex
	 *        the index of the page
	 * @return the control for the specified page, or <code>null</code> if none has been set
	 */
	protected Control getControl(int pageIndex) {
		return getItem(pageIndex).getControl();
	}

	/**
	 * Returns the editor for the given page index. The page index must be valid.
	 * 
	 * @param pageIndex
	 *        the index of the page
	 * @return the editor for the specified page, or <code>null</code> if the specified page was not created with
	 *         <code>addPage(IEditorPart,IEditorInput)</code>
	 */
	//	abstract protected IEditorPart getEditor(int pageIndex);

	/**
	 * Returns the service locator for the given page index. This method can be used to create service locators for pages that are just controls. The
	 * page index must be valid.
	 * <p>
	 * This will return the editor site service locator for an editor, and create one for a page that is just a control.
	 * </p>
	 * 
	 * @param pageIndex
	 *        the index of the page
	 * @return the editor for the specified page, or <code>null</code> if the specified page was not created with
	 *         <code>addPage(IEditorPart,IEditorInput)</code>
	 * @since 3.4
	 */
	//	protected final IServiceLocator getPageSite(int pageIndex) {
	//		if (pageIndex == PAGE_CONTAINER_SITE) {
	//			return getPageContainerSite();
	//		}
	//
	//		/**
	//		 * Return the site associated to the editor.
	//		 */
	//		return getEditor(pageIndex).getSite();
	//	}

	/**
	 * @return A site that can be used with a header.
	 * @since 3.4
	 * @see #createPageContainer(Composite)
	 * @see #PAGE_CONTAINER_SITE
	 * @see #getPageSite(int)
	 */
	//	private IServiceLocator getPageContainerSite() {
	//		if (pageContainerSite == null) {
	//			IServiceLocatorCreator slc = (IServiceLocatorCreator) getSite().getService(IServiceLocatorCreator.class);
	//			pageContainerSite = slc.createServiceLocator(getSite(), null, new IDisposable() {
	//
	//				public void dispose() {
	//					final Control control = ((PartSite) getSite()).getPane().getControl();
	//					if (control != null && !control.isDisposed()) {
	//						((PartSite) getSite()).getPane().doHide();
	//					}
	//				}
	//			});
	//		}
	//		return pageContainerSite;
	//	}

	/**
	 * Returns the tab item for the given page index (page index is 0-based). The page index must be valid.
	 * 
	 * @param pageIndex
	 *        the index of the page
	 * @return the tab item for the given page index
	 */
	private CTabItem getItem(int pageIndex) {
		return getTabFolder().getItem(pageIndex);
	}

	/**
	 * Returns the number of pages in this multi-page editor.
	 * 
	 * @return the number of pages
	 */
	protected int getPageCount() {
		CTabFolder folder = getTabFolder();
		// May not have been created yet, or may have been disposed.
		if(folder != null && !folder.isDisposed()) {
			return folder.getItemCount();
		}
		return 0;
	}

	/**
	 * Returns the tab folder containing this multi-page editor's pages.
	 * 
	 * @return the tab folder, or <code>null</code> if <code>createPartControl</code> has not been called yet
	 */
	protected abstract CTabFolder getTabFolder();

	/**
	 * Notifies this multi-page editor that the page with the given id has been activated. This method is called when the user selects a different
	 * tab.
	 * <p>
	 * The <code>MultiPageEditorPart</code> implementation of this method sets focus to the new page, and notifies the action bar contributor (if
	 * there is one). This checks whether the action bar contributor is an instance of <code>MultiPageEditorActionBarContributor</code>, and, if so,
	 * calls <code>setActivePage</code> with the active nested editor. This also fires a selection change event if required.
	 * </p>
	 * <p>
	 * Subclasses may extend this method.
	 * </p>
	 * 
	 * @param newPageIndex
	 *        the index of the activated page
	 */
	protected void pageChange(int newPageIndex) {
		//		System.out.println(this.getClass().getSimpleName() + "pageChange()");
		//		deactivateSite(false, false);
		//
		//		IPartService partService = (IPartService) getSite().getService(IPartService.class);
		//		if (partService.getActivePart() == this) {
		//			setFocus(newPageIndex);
		//		}
		//
		//		IEditorPart activeEditor = getEditor(newPageIndex);
		//
		//		IEditorActionBarContributor contributor = getEditorSite().getActionBarContributor();
		//		if (contributor != null && contributor instanceof MultiPageEditorActionBarContributor) {
		//			((MultiPageEditorActionBarContributor) contributor).setActivePage(activeEditor);
		//		}
		//
		//		if (activeEditor != null) {
		//			ISelectionProvider selectionProvider = activeEditor.getSite().getSelectionProvider();
		//			if (selectionProvider != null) {
		//				ISelectionProvider outerProvider = getSite().getSelectionProvider();
		//				if (outerProvider instanceof MultiPageSelectionProvider) {
		//					SelectionChangedEvent event = new SelectionChangedEvent(selectionProvider, selectionProvider.getSelection());
		//
		//					MultiPageSelectionProvider provider = (MultiPageSelectionProvider) outerProvider;
		//					provider.fireSelectionChanged(event);
		//					provider.firePostSelectionChanged(event);
		//				} else {
		//					if (Policy.DEBUG_MPE) {
		//						Tracing.printTrace(TRACING_COMPONENT, "MultiPageEditorPart " + getTitle() //$NON-NLS-1$
		//								+ " did not propogate selection for " //$NON-NLS-1$
		//								+ activeEditor.getTitle());
		//					}
		//				}
		//			}
		//		}
		//
		//		activateSite();
	}

	/**
	 * This method can be used by implementors of {@link AbstractTabFolderPart#createPageContainer(Composite)} to deactivate the active inner editor
	 * services while their header has focus. A
	 * deactivateSite() must have a matching call to activateSite() when appropriate.
	 * <p>
	 * An new inner editor will have its site activated on a {@link AbstractTabFolderPart#pageChange(int)}.
	 * </p>
	 * <p>
	 * <b>Note:</b> This API is evolving in 3.4 and this might not be its final form.
	 * </p>
	 * 
	 * @param immediate
	 *        immediately deactivate the legacy keybinding service
	 * @param containerSiteActive
	 *        Leave the page container site active.
	 * @since 3.4
	 * @see #activateSite()
	 * @see #createPageContainer(Composite)
	 * @see #getPageSite(int)
	 * @see #PAGE_CONTAINER_SITE
	 */
	//	protected final void deactivateSite(boolean immediate, boolean containerSiteActive) {
	//		// Deactivate the nested services from the last active service locator.
	//		if (activeServiceLocator != null) {
	//			activeServiceLocator.deactivate();
	//			activeServiceLocator = null;
	//		}
	//
	//		final int pageIndex = getActivePage();
	//		final IKeyBindingService service = getSite().getKeyBindingService();
	//		if (pageIndex < 0 || pageIndex >= getPageCount() || immediate) {
	//			// There is no selected page, so deactivate the active service.
	//			if (service instanceof INestableKeyBindingService) {
	//				final INestableKeyBindingService nestableService = (INestableKeyBindingService) service;
	//				nestableService.activateKeyBindingService(null);
	//			} else {
	//				WorkbenchPlugin
	//						.log("MultiPageEditorPart.deactivateSite()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
	//			}
	//		}
	//
	//		if (containerSiteActive) {
	//			IServiceLocator containerSite = getPageContainerSite();
	//			if (containerSite instanceof INestable) {
	//				activeServiceLocator = (INestable) containerSite;
	//				activeServiceLocator.activate();
	//			}
	//		}
	//	}

	/**
	 * This method can be used by implementors of {@link #createPageContainer(Composite)} to activate the active inner editor services when their
	 * header loses focus.
	 * <p>
	 * An new inner editor will have its site activated on a {@link #pageChange(int)}.
	 * </p>
	 * <p>
	 * <b>Note:</b> This API is evolving in 3.4 and this might not be its final form.
	 * </p>
	 * 
	 * @since 3.4
	 * @see #deactivateSite(boolean,boolean)
	 * @see #createPageContainer(Composite)
	 * @see #getPageSite(int)
	 */
	//	protected final void activateSite() {
	//		if (activeServiceLocator != null) {
	//			activeServiceLocator.deactivate();
	//			activeServiceLocator = null;
	//		}
	//
	//		final IKeyBindingService service = getSite().getKeyBindingService();
	//		final int pageIndex = getActivePage();
	//		final IEditorPart editor = getEditor(pageIndex);
	//
	//		if (editor != null) {
	//			// active the service for this inner editor
	//			if (service instanceof INestableKeyBindingService) {
	//				final INestableKeyBindingService nestableService = (INestableKeyBindingService) service;
	//				nestableService.activateKeyBindingService(editor.getEditorSite());
	//
	//			} else {
	//				WorkbenchPlugin
	//						.log("MultiPageEditorPart.activateSite()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
	//			}
	//			// Activate the services for the new service locator.
	//			final IServiceLocator serviceLocator = editor.getEditorSite();
	//			if (serviceLocator instanceof INestable) {
	//				activeServiceLocator = (INestable) serviceLocator;
	//				activeServiceLocator.activate();
	//			}
	//
	//		} else {
	//			Item item = getItem(pageIndex);
	//
	//			// There is no selected editor, so deactivate the active service.
	//			if (service instanceof INestableKeyBindingService) {
	//				final INestableKeyBindingService nestableService = (INestableKeyBindingService) service;
	//				nestableService.activateKeyBindingService(null);
	//			} else {
	//				WorkbenchPlugin
	//						.log("MultiPageEditorPart.activateSite()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
	//			}
	//
	//			if (item.getData() instanceof INestable) {
	//				activeServiceLocator = (INestable) item.getData();
	//				activeServiceLocator.activate();
	//			}
	//		}
	//	}

	//	/**
	//	 * Disposes the given part and its site.
	//	 * 
	//	 * @param part
	//	 *            The part to dispose; must not be <code>null</code>.
	//	 */
	//	private void disposePart(final IWorkbenchPart part) {
	//		SafeRunner.run(new ISafeRunnable() {
	//
	//			public void run() {
	//				IWorkbenchPartSite partSite = part.getSite();
	//				part.dispose();
	//				if (partSite instanceof MultiPageEditorSite) {
	//					((MultiPageEditorSite) partSite).dispose();
	//				}
	//			}
	//
	//			public void handleException(Throwable e) {
	//				// Exception has already being logged by Core. Do nothing.
	//			}
	//		});
	//	}

	/**
	 * Sets the currently active page for this folder.
	 * Removed since 0.10.0
	 * 
	 * @param pageIndex
	 *        the index of the page to be activated; the index must be valid
	 */
//	public void setActivePage(int pageIndex) {
//		//		Assert.isTrue(pageIndex >= 0 && pageIndex < getPageCount());
//		if(!isValidPageIndex(pageIndex))
//			return;
//
//		getTabFolder().setSelection(pageIndex);
//		pageChange(pageIndex);
//	}

	/**
	 * Return true if the specified index is valid.
	 * The index should be between 0 and pageCount.
	 * If there is no page, return false.
	 * 
	 * @param pageIndex
	 * @return
	 */
	protected boolean isValidPageIndex(int pageIndex) {

		return pageIndex >= 0 && pageIndex < getPageCount();
	}

	/**
	 * Sets the control for the given page index. The page index must be valid.
	 * 
	 * @param pageIndex
	 *        the index of the page
	 * @param control
	 *        the control for the specified page, or <code>null</code> to clear the control
	 */
	protected void setControl(int pageIndex, Control control) {
		getItem(pageIndex).setControl(control);
	}


	/* *************************************** */
	/* Added method. */
	/* *************************************** */

	//	/**
	//	 * Title of this TilePart ? Needed by a trace message.
	//	 */
	//	protected String getTitle() {
	//		return getClass().toString();
	//	}
	//
	//	/**
	//	 * 
	//	 */
	//	protected IWorkbenchPartSite getSite() {
	//		return getEditorSite();
	//	}
	//
	//	/**
	//	 * 
	//	 */
	//	abstract protected void firePropertyChange(int propertyId);
	//
	//	/**
	//	 * 
	//	 */
	//	abstract protected IEditorSite getEditorSite();


}
