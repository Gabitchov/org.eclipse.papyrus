package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * A command to be used with the Eclipse Commands Framework.
 * This command is to be used with {@link SashWindowsContainer} implemented with the Di model.
 * This command allows to close all diagrams in the folder, except the currently openened one.
 * 
 * @author cedric dumoulin
 * 
 */
public class CloseOtherDiagramsCommand extends AbstractHandler {

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
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		try {
			IEditorPart part = HandlerUtil.getActiveEditor(event);
			IPageManager pageManager = (IPageManager)part.getAdapter(IPageManager.class);
			ISashWindowsContainer container = (ISashWindowsContainer)part.getAdapter(ISashWindowsContainer.class);
			Object pageIdentifier = container.getActiveSashWindowsPage().getRawModel();
			//FIXME Bug from sash Di to be corrected
			if(pageIdentifier instanceof PageRef) {
				pageIdentifier = ((PageRef)pageIdentifier).getPageIdentifier();
			}
			execute(pageManager, pageIdentifier);

		} catch (NullPointerException e) {
			// PageMngr can't be found
			return null;
		}



		return null;
	}

	/**
	 * Close selected page.
	 * 
	 * @param pageManager
	 */
	public void execute(final IPageManager pageManager, final Object pageIdentifier) {
		boolean atLeastOneDifferentPageOpen = false;
		for(Object page : pageManager.allPages()) {
			if(page != pageIdentifier && pageManager.isOpen(page)) {
				atLeastOneDifferentPageOpen = true;
				break;
			}
		}

		if(!atLeastOneDifferentPageOpen) {
			return; //Nothing to do
		}

		pageManager.closeOtherPages(pageIdentifier);
	}

}
