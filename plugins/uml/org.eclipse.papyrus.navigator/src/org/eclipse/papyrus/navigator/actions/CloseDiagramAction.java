/**
 * 
 */

package org.eclipse.papyrus.navigator.actions;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Action used to open the given diagram
 * 
 * @author cedric dumoulin
 */
public class CloseDiagramAction extends Action {

	Diagram diagram;
	IPageMngr pageMngr;

	public CloseDiagramAction(IPageMngr pageMngr, Diagram diagram) {
		this.diagram = diagram;
		this.pageMngr = pageMngr;
		
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
		setText("Close");
		setEnabled( pageMngr.isOpen(diagram) );
	}

	/**
	 * Delete the given diagram
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		
		pageMngr.closePage(diagram);
	}
}
