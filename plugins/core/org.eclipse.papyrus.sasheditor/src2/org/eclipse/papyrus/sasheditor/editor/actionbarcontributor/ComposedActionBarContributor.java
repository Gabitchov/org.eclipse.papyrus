/**
 * 
 */
package org.eclipse.papyrus.sasheditor.editor.actionbarcontributor;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorActionBarContributor;

/**
 * 
 * An ActionBarContributor composed of ActionBarContributor from multi editor. This
 * ActionBarContributor switch to the contributor dedicated to the active editor in a
 * MultiPageEditor environement.
 * 
 * @author dumoulin
 * 
 */
public class ComposedActionBarContributor extends MultiPageEditorActionBarContributor {

	/** Log object */
	private Logger log = Logger.getLogger(getClass().getName());

	/** The currently active nested editor */
	protected IEditorPart activeNestedEditor;

	/**
	 * Sets the active page of the the multi-page editor to be the given editor. Switch the
	 * currently active editor.
	 * <p>
	 * This method is called whenever the page changes. Subclasses must implement this method to
	 * redirect actions to the given editor (if not already directed to it).
	 * </p>
	 * 
	 * @param activeEditor
	 *            the new active editor, or <code>null</code> if there is no active page, or if the
	 *            active page does not have a corresponding editor
	 */
	public void setActivePage(IEditorPart activeEditor) {
		// Check if we are already initialized
		// Return if we are not
		if (getPage() == null) {
			return;
		}

		// skip if the activeEditor doesn't change.
		if (activeEditor == activeNestedEditor) {
			return;
		}

		if (log.isLoggable(Level.FINE)) {
			log.fine("setActivePage(" + activeEditor + " " + ")");
		}

		activeNestedEditor = activeEditor;

		// Propagate call if possible
		// Call setActiveEditor() on nested contributor.
		IEditorActionBarContributor contributor = getActiveContributor();
		if (contributor != this && contributor instanceof EditorActionBarContributor) {
			((EditorActionBarContributor) contributor).setActiveEditor(activeEditor);
		}

	}

	/**
	 * Get the active nested contributor, if any.
	 * 
	 * @return the active nested contributor, or null if any.
	 */
	protected IEditorActionBarContributor getActiveContributor() {

		// If there is no nestedEditor, this contributor is used.
		if (activeNestedEditor == null) {
			return this;
		}

		// 
		return activeNestedEditor.getEditorSite().getActionBarContributor();
	}
}
