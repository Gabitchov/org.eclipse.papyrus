/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider.di.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * A command to be used with the Eclipse Commands Framework.
 * This command is to be used with {@link SashWindowsContainer} implemented with the Di model.
 * This command allows to close the currently openened diagram.
 * 
 * @author cedric dumoulin
 *
 */
public class CloseDiagramCommand extends AbstractHandler {

	/**
	 * Check if the Command is enabled.
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		//		System.out.println("call to CloseDiagramCommand.setEnable(" + evaluationContext + ")");
	}
	
	/**
	 * Execute the command. This method is called when the action is triggered.
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		try {
			IEditorPart part = HandlerUtil.getActiveEditor(event);
			IPageMngr pageMngr = (IPageMngr)part.getAdapter(IPageMngr.class);
			ISashWindowsContainer container = (ISashWindowsContainer)part.getAdapter(ISashWindowsContainer.class);
			Object pageIdentifier = container.getActiveSashWindowsPage().getRawModel();
			// Bug from sash Di to be corrected
			if(pageIdentifier instanceof PageRef)
			{
				pageIdentifier = ((PageRef)pageIdentifier).getPageIdentifier();
			}
			
			execute(pageMngr, pageIdentifier);

		} catch (NullPointerException e) {
			// PageMngr can't be found
			return null;
		}
		
		
		
		return null;
	}
	
	/**
	 * Close selected page.
	 * @param pageMngr
	 */
	public void execute(IPageMngr pageMngr, Object pageIdentifier) {
		
			if(pageMngr.isOpen(pageIdentifier)) {
				pageMngr.closePage(pageIdentifier);
			}
	}

}
