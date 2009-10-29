/**
 * 
 */
package org.eclipse.papyrus.sasheditor.sash;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageEditorActionBarContributor;
import org.eclipse.papyrus.sasheditor.eclipsecopy.MultiPageSelectionProvider;
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
 * Instance of this class track the active editor. When the active editor change, the tracker
 * receive an event, and perform following tasks: - send unselect msg to old active editor - send
 * select msg to new active editor - record the new active editor - fire events to all registered
 * listeners.
 * 
 * This class allows to set externally the active editor.
 * 
 * @author dumoulin
 * 
 */
@SuppressWarnings("unchecked")
public class ActiveEditorTracker {

	/**
	 * The active service locator. This value may be <code>null</code> if there is no selected page,
	 * or if the selected page is a control with no site.
	 */
	private INestable activeServiceLocator;

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	/** List of listeners */
	private final List<IActiveEditorChangeListener> activeEditorChangeListeners = new ArrayList<IActiveEditorChangeListener>();

	/** The currently active editor */
	private EditorTile activeEditor;

	/**
	 * The main multiPartEditor.
	 */
	private final IMultiEditorNestedPartManager multiPartEditor;

	/**
	 * Interface that must be implemented by listeners on activeEditorChange event.
	 * 
	 * @author dumoulin
	 * 
	 */
	public interface IActiveEditorChangeListener {

		/**
		 * This method is called whenever the active editor change.
		 * 
		 * @param oldEditor
		 * @param newEditor
		 */
		public void activeEditorChange(EditorTile oldEditor, EditorTile newEditor);
	}

	/**
	 * Constructor. The activeEditor will be set by the first TabFolder that will call
	 * TabFolderPart.setPage().
	 * 
	 * @param multiPartEditor
	 */
	public ActiveEditorTracker(IMultiEditorNestedPartManager multiPartEditor) {
		this.multiPartEditor = multiPartEditor;
	}

	/**
	 * Get the activeEditor.
	 * 
	 * @return The active editor or null if there is none.
	 */
	public EditorTile getActiveEditor() {
		return activeEditor;
	}

	/**
	 * Set the active editor with the specified editor.
	 * 
	 * @param editor
	 */
	public void setActiveEditor(EditorTile editor) {
		EditorTile oldEditor = activeEditor;

		activeEditor = editor;
		editorChange(editor);
		fireEditorChangeEvent(oldEditor, editor);
	}

	/**
	 * Notifies that the editor has been activated. This method is called when the user selects a
	 * different editor.
	 * 
	 * @param editor
	 */
	private void editorChange(EditorTile editor) {
		System.out.println(getClass().getSimpleName() + ".editorChange('" + editor.getIEditorPart().getTitle() + "')");
		// Set focus
		IPartService partService = (IPartService) getEditorSite().getService(IPartService.class);
		if (partService.getActivePart() == getEditorSite().getPart()) {
			editor.getIEditorPart().setFocus();
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
	private void propagateSelectionChange(EditorTile editor) {

		IEditorPart editorPart = editor.getIEditorPart();

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
						log.warning("MultiPageEditorPart " + multiPartEditor.getClass().getName()
								+ " did not propogate selection for " //$NON-NLS-1$
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

		final IEditorPart editor = (activeEditor != null ? activeEditor.getIEditorPart() : null);

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

		final IEditorPart editor = (activeEditor != null ? activeEditor.getIEditorPart() : null);
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
		if (contributor != null && contributor instanceof MultiPageEditorActionBarContributor) {
			((MultiPageEditorActionBarContributor) contributor).setActivePage(activeEditor.getIEditorPart());
		}

	}

	/**
	 * Return the MultipageEditorSite
	 * 
	 * @return
	 */
	private IEditorSite getEditorSite() {
		return multiPartEditor.getEditorSite();
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	// @unused
	public void addActiveEditorChangeListener(IActiveEditorChangeListener listener) {
		// no duplicate
		if (activeEditorChangeListeners.contains(listener)) {
			return;
		}
		activeEditorChangeListeners.add(listener);
	}

	/**
	 * Add a listener on the activeEditorChange event.
	 * 
	 * @param listener
	 */
	// @unused
	public void removeActiveEditorChangeListener(IActiveEditorChangeListener listener) {
		activeEditorChangeListeners.remove(listener);
	}

	private void fireEditorChangeEvent(EditorTile oldEditor, EditorTile newEditor) {
		// Fire only if really change
		if (oldEditor == newEditor) {
			return;
		}

		for (IActiveEditorChangeListener listener : activeEditorChangeListeners) {
			listener.activeEditorChange(oldEditor, newEditor);
		}
	}

}
