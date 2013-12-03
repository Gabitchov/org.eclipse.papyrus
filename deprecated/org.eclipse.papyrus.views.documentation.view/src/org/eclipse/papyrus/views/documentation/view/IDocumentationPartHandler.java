package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.views.documentation.IDocumentationManager;
import org.eclipse.ui.IWorkbenchPart;

/**
 * This interface specifies editor-specific behavior of the doc view
 * @author mvelten
 *
 */
public interface IDocumentationPartHandler {
	/**
	 * Test if the part can be handled by the implementation
	 * @param part
	 * @return
	 */
	public boolean canHandlePart(IWorkbenchPart part);

	/**
	 * @return the documentation manager
	 */
	public IDocumentationManager getDocumentationManager();

	/**
	 * if an associated diagram exists its model element is returned
	 * @param part
	 * @param eObject
	 * @return the diagram element or null
	 */
	public EObject getAssociatedDiagram(IWorkbenchPart part, EObject eObject);

	/**
	 * Execute an EMF command
	 * @param part
	 * @param cmd
	 */
	public void executeCommand(IWorkbenchPart part, Command cmd);
	
	/**
	 * Open an element (understand one of its associated diagram if any) in the current editor
	 * @param part
	 * @param elementUri
	 */
	public void openElement(IWorkbenchPart part, URI elementUri);
	
	/**
	 * Open a dialog to select an element in the model of the editor
	 * @param part
	 * @return the selected element
	 */
	public EObject openElementSelectionDialog(IWorkbenchPart part);

	/**
	 * Check if the element can be edited in the editor.
	 * @param part
	 * @param eObject
	 * @return
	 */
	public boolean isReadOnly(IWorkbenchPart part, EObject eObject);
}
