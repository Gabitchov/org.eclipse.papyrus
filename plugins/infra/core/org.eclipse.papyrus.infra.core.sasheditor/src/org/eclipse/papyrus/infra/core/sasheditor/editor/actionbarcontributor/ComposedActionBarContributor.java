/**
 * 
 */
package org.eclipse.papyrus.infra.core.sasheditor.editor.actionbarcontributor;

import java.util.logging.Level;

import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.part.EditorActionBarContributor;


/**
 * 
 * An ActionBarContributor composed of ActionBarContributor from multi editor.
 * This ActionBarContributor switch to the contributor dedicated to the active editor in
 * a MultiPageEditor environement.
 * 
 * @author dumoulin
 * 
 */
public class ComposedActionBarContributor extends MultiPageEditorActionBarContributor {

	//	/**
	//	 * List of contributors.
	//	 */
	//	protected ContributorMap<Class<? extends IEditorPart>, EditorActionBarContributor> contributors = new ContributorMap<Class<? extends IEditorPart>, EditorActionBarContributor>();
	//	
	//	
	//	/**
	//	 * Contributor used as default.
	//	 */
	//	protected EditorActionBarContributor defaultContributor;
	//	
	//	/**
	//	 * The currently active contributor.
	//	 */
	//	protected EditorActionBarContributor activeContributor;


	/** The currently active nested editor */
	protected IEditorPart activeNestedEditor;

	/**
	 * Constructor.
	 */
	public ComposedActionBarContributor() {
	}

	/**
	 * Sets the active page of the the multi-page editor to be the given editor.
	 * Switch the currently active editor.
	 * <p>
	 * This method is called whenever the page changes. Subclasses must implement this method to redirect actions to the given editor (if not already
	 * directed to it).
	 * </p>
	 * 
	 * @param activeEditor
	 *        the new active editor, or <code>null</code> if there is no active page, or if the
	 *        active page does not have a corresponding editor
	 */
	@Override
	public void setActivePage(IEditorPart activeEditor) {
		// Check if we are already initialized
		// Return if we are not
		if(getPage() == null)
			return;

		// skip if the activeEditor doesn't change.
		if(activeEditor == activeNestedEditor)
			return;

		if(log.isLoggable(Level.FINE)) {
			log.fine("setActivePage(" + activeEditor + " " + ")");
		}

		activeNestedEditor = activeEditor;

//		System.out.println(this.getClass().getSimpleName()
//				+ ".setActivePage(" + activeEditor
//				+ ") :" + getActiveContributor());

		// Propagate call if possible
		// Call setActiveEditor() on nested contributor.
		IEditorActionBarContributor contributor = getActiveContributor();
		if(contributor != this && contributor instanceof EditorActionBarContributor)
			((EditorActionBarContributor)contributor).setActiveEditor(activeEditor);

		//		if(contributor != this && contributor instanceof IMultiPageEditorActionBarContributor)
		//			((IMultiPageEditorActionBarContributor)contributor).setActivePage(activeEditor);

	}

	/**
	 * Sets the active editor for the contributor.
	 * <p>
	 * The <code>EditorActionBarContributor</code> implementation of this method does nothing. Subclasses may reimplement. This generally entails
	 * disconnecting from the old editor, connecting to the new editor, and updating the actions to reflect the new editor.
	 * </p>
	 * 
	 * @param part
	 *        the new target editor
	 */
	public void setActiveEditor(IEditorPart part) {
		if(log.isLoggable(Level.FINE)) {
			log.fine("setActiveEditor(" + part + " " + ")");
		}

		// Switch the editor and activeContributor.
		super.setActiveEditor(part);
		// Now, propagate to the new activeContributor
		//		IEditorActionBarContributor activeContributor = getActiveContributor();
		//
		//		if(activeContributor!=this)
		//		  activeContributor.setActiveEditor(part);
	}
	
	@Override
	public void dispose(){
		super.dispose();
		activeNestedEditor = null;
	}

	/**
	 * Get the active nested contributor, if any.
	 * 
	 * @return the active nested contributor, or null if any.
	 */
	protected IEditorActionBarContributor getActiveContributor() {

		// If there is no nestedEditor, this contributor is used.
		if(activeNestedEditor == null)
			return this;

		// 
		return activeNestedEditor.getEditorSite().getActionBarContributor();
	}


	// ************************************************ //
	//      Propagate method calls  //
	// ************************************************ //

	/**
	 * Returns this contributor's action bars.
	 * 
	 * @return the action bars
	 */
	//    public IActionBars getActionBars() {
	//    	IEditorActionBarContributor activeContributor = getActiveContributor();
	//    	if( activeContributor!=this && activeContributor instanceof EditorActionBarContributor)
	//          return ((EditorActionBarContributor)getActiveContributor()).getActionBars();
	//    	else
	//    		return super.getActionBars();
	//    }


}
