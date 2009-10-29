/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.internal;

import java.util.logging.Level;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorActionBarContributor;
import org.eclipse.papyrus.sasheditor.editor.actionbarcontributor.IMultiPageEditorActionBarContributor;
import org.eclipse.papyrus.sasheditor.internal.eclipsecopy.MultiPageSelectionProvider;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.INestableKeyBindingService;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.services.INestable;
import org.eclipse.ui.services.IServiceLocator;

/**
 * Instance of this class track the active leaf or editor. When the active editor change, the
 * tracker receive an event, and perform following tasks: - send unselect msg to old active editor -
 * send select msg to new active editor - record the new active editor - fire events to all
 * registered listeners.
 * 
 * This class allows to set externally the active editor. This class add IEditor switching: when the
 * editor change, it is connected, thanks to the Site, to the SelectionService, KeyboardService, ...
 * 
 * @author dumoulin
 * 
 * @deprecated Not used anymore. Use {@link ActiveEditorServicesSwitcher}
 */
// @unused
@Deprecated
public class ActiveEditorAndPageTracker extends ActivePageTracker {

	/**
	 * The manager used to access main editor properties like site, actionbars, ...
	 */
	private final IMultiEditorManager multiEditorManager;

	/**
	 * The active service locator. This value may be <code>null</code> if there is no selected page,
	 * or if the selected page is a control with no site.
	 */
	private INestable activeServiceLocator;

	/**
	 * @param editorManager
	 *            TODO Provide main editor Site only.
	 */
	// @unused
	public ActiveEditorAndPageTracker(IMultiEditorManager editorManager) {
		this.multiEditorManager = editorManager;
	}

	/**
	 * Get the currently active IEditorPart, if any. Return null if there is no active IeditorPart.
	 * Method check if the active leaf encapsulate an IEditorPart. Return it if true.
	 * 
	 * @return The currentlyactive IEditorPart or null.
	 */
	private IEditorPart getActiveIEditorPart() {
		return getIEditorPart(activeEditor);
	}

	/**
	 * Get IEditorPart of the specified PagePart, if any. Return null if there is no IeditorPart.
	 * Method check if the leaf encapsulate an IEditorPart. Return it if true.
	 * 
	 * @return The IEditorPart or null.
	 */
	private IEditorPart getIEditorPart(PagePart pagePart) {
		if (pagePart == null) {
			return null;
		}

		if (pagePart instanceof EditorPart) {
			return ((EditorPart) pagePart).getIEditorPart();
		}
		// not found
		return null;
	}

	/**
	 * Notifies that the editor has been activated. This method is called when the user selects a
	 * different editor.
	 * 
	 * @param editor
	 */
	protected void editorChange(PagePart editor) {
		System.out.println(getClass().getSimpleName() + ".editorChange('" + editor.getPageTitle() + "')");
		// Set focus
		IPartService partService = (IPartService) getEditorSite().getService(IPartService.class);
		if (partService.getActivePart() == getEditorSite().getPart()) {
			editor.setFocus();
		}

		// Switch services
		deactivateServices(false);
		fireChangeEventToActionBarContributor();
		propagateSelectionChange(editor);
		activateServices();
	}

	/**
	 * Propagate the selection change to the outer SelectionProvider.
	 * 
	 * @param editor
	 */
	private void propagateSelectionChange(PagePart editor) {

		// Get the IEditor
		IEditorPart editorPart = getIEditorPart(editor);

		// Propagate the selection change event.
		if (editorPart != null) {
			ISelectionProvider selectionProvider = editorPart.getSite().getSelectionProvider();
			if (selectionProvider != null) {
				ISelectionProvider outerProvider = getEditorSite().getSelectionProvider();
				if (outerProvider instanceof MultiPageSelectionProvider) {
					SelectionChangedEvent event = new SelectionChangedEvent(selectionProvider, selectionProvider
							.getSelection());

					MultiPageSelectionProvider provider = (MultiPageSelectionProvider) outerProvider;
					provider.fireSelectionChanged(event);
					provider.firePostSelectionChanged(event);
				} else {
					if (log.isLoggable(Level.WARNING)) {
						log.warning(this.getClass().getSimpleName() + " did not propogate selection for " //$NON-NLS-1$
								+ editorPart.getTitle());
					}
				}
			}
		}
	}

	/**
	 * Activates services of the active editor: site, keybinding deactivate old active site.
	 */
	@SuppressWarnings( { "restriction", "deprecation" })
	private void activateServices() {
		// Deactivate old active site
		if (activeServiceLocator != null) {
			activeServiceLocator.deactivate();
			activeServiceLocator = null;
		}

		// Get the service
		final IKeyBindingService service = getEditorSite().getKeyBindingService();

		final IEditorPart editor = getActiveIEditorPart();

		if (editor != null) {
			// active the service for this inner editor
			if (service instanceof INestableKeyBindingService) {
				final INestableKeyBindingService nestableService = (INestableKeyBindingService) service;
				nestableService.activateKeyBindingService(editor.getEditorSite());

			} else {
				WorkbenchPlugin
						.log("MultiPageEditorPart.activateSite()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
			}
			// Activate the services for the new service locator.
			final IServiceLocator serviceLocator = editor.getEditorSite();
			if (serviceLocator instanceof INestable) {
				activeServiceLocator = (INestable) serviceLocator;
				activeServiceLocator.activate();
			}

		}
	}

	/**
	 * Deactivate services: old nested site if any and keybinding service if there is no active
	 * editor. Deactivate the key binding service. Deactivate it only if there is no editor
	 * selected.
	 */
	@SuppressWarnings( { "restriction", "deprecation" })
	private void deactivateServices(boolean immediate) {
		// Deactivate the nested services from the last active service locator.
		if (activeServiceLocator != null) {
			activeServiceLocator.deactivate();
			activeServiceLocator = null;
		}

		final IEditorPart editor = getActiveIEditorPart();
		final IKeyBindingService service = getEditorSite().getKeyBindingService();
		if (editor != null || immediate) {
			// There is no selected page, so deactivate the active service.
			if (service instanceof INestableKeyBindingService) {
				final INestableKeyBindingService nestableService = (INestableKeyBindingService) service;
				nestableService.activateKeyBindingService(null);
			} else {
				WorkbenchPlugin
						.log("MultiPageEditorPart.deactivateSite()   Parent key binding service was not an instance of INestableKeyBindingService.  It was an instance of " + service.getClass().getName() + " instead."); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * Send message to the ActionBarContributor, like this it can switch the active editor.
	 */
	private void fireChangeEventToActionBarContributor() {
		IEditorActionBarContributor contributor = getEditorSite().getActionBarContributor();
		if (contributor != null && contributor instanceof IMultiPageEditorActionBarContributor) {
			((MultiPageEditorActionBarContributor) contributor).setActivePage(getActiveIEditorPart());
		}

	}

	/**
	 * Return the MultipageEditorSite
	 * 
	 * @return
	 */
	private IEditorSite getEditorSite() {
		return multiEditorManager.getEditorSite();
	}

}
