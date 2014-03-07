package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
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
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IPageManager pageManager;
		try {
			pageManager = getPageManager(event);
		} catch (NullPointerException e) {
			// PageMngr or Editing Domain can't be found
			return null;
		}
		execute(pageManager);

		return null;
	}

	/**
	 * Get the PageMngr used to interact with the content provider.
	 *
	 * @param event
	 * @return
	 * @throws NullPointerException
	 *         if the PageMngr can't be found.
	 */
	private IPageManager getPageManager(ExecutionEvent event) {
		IEditorPart part = HandlerUtil.getActiveEditor(event);
		IPageManager pageManager = (IPageManager)part.getAdapter(IPageManager.class);

		return pageManager;
	}

	/**
	 * Close all the diagrams.
	 *
	 * @param pageManager
	 */
	public void execute(final IPageManager pageManager) throws ExecutionException {
		boolean atLeastOneOpenPage = false;
		for(Object pageIdentifier : pageManager.allPages()) {
			if(pageManager.isOpen(pageIdentifier)) {
				atLeastOneOpenPage = true;
				break;
			}
		}

		if(!atLeastOneOpenPage) {
			return;
		}

		pageManager.closeAllOpenedPages();
	}

}
