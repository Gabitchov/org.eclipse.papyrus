/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider.di.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * A command to be used with the Eclipse Commands Framework.
 * This command allows to close all diagrams openened in the current SashContainer implemented
 * on di.
 * 
 * @author cedric dumoulin
 *
 */
public class CloseAllDiagramsCommand extends AbstractHandler {

	/**
	 * Check if the Command is enabled.
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
//		System.out.println("call to CloseAllDiagramsCommand.setEnable(" + evaluationContext + ")");
	}
	
	/**
	 * Execute the command. This method is called when the action is triggered.
	 * 
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		IPageMngr pageMngr;
		try {
			pageMngr = getPageMngr(event);
		} catch (NullPointerException e) {
			// PageMngr can't be found
			return null;
		}
		execute(pageMngr);
		
		return null;
	}
	
	/**
	 * Get the PageMngr used to interact with the content provider.
	 * @param event
	 * @return
	 * @throws NullPointerException if the PageMngr can't be found.
	 */
	private IPageMngr getPageMngr(ExecutionEvent event) {
		
		IEditorPart part = HandlerUtil.getActiveEditor(event);
		IPageMngr pageMngr = (IPageMngr)part.getAdapter(IPageMngr.class);
		
		return pageMngr;
		
	}

	/**
	 * Close all the diagrams.
	 * @param pageMngr
	 */
	public void execute(IPageMngr pageMngr) {
		
		pageMngr.closeAllOpenedPages();
	}

}
