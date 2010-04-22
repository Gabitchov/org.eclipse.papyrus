/**
 * 
 */

package org.eclipse.papyrus.navigator.actions;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Action used to open the given diagram. The diagram is open in a new tab, even if it is already
 * open.
 * 
 * @author cedric dumoulin
 */
public class OpenDiagramAction extends Action {

	private final Diagram diagram;

	private final IPageMngr pageMngr;

	public OpenDiagramAction(IPageMngr pageMngr, Diagram diagram) {
		this.diagram = diagram;
		this.pageMngr = pageMngr;

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		if(pageMngr.isOpen(diagram)) {
			setText("Open in New Tab");
			setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));
		} else {
			setText("Open");
			setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_BACK));
		}

		setEnabled(true);
	}

	/**
	 * Delete the given diagram
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		pageMngr.openPage(diagram);
		// TransactionalEditingDomain editingDomain =
		// NavigatorUtils.getTransactionalEditingDomain();
		// if (editingDomain != null) {
		//			
		//			
		// EList<EObject> diagrams = diagram.eResource().getContents();
		// //TODO : synchronize with Cedric
		// Command command = new RemoveCommand(editingDomain, diagrams,
		// diagram);
		// editingDomain.getCommandStack().execute(command);
		// }
	}
}
