package org.eclipse.papyrus.infra.core.sasheditor.di.contentprovider.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IPageManager pageMngr;
		TransactionalEditingDomain editingDomain;
		try {
			pageMngr = getPageManager(event);
			editingDomain = getTransactionalEditingDomain(event);
		} catch (NullPointerException e) {
			// PageMngr or Editing Domain can't be found
			return null;
		}
		execute(pageMngr, editingDomain);

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
		IPageManager pageMngr = (IPageManager)part.getAdapter(IPageManager.class);

		return pageMngr;

	}

	/**
	 * Get the TransactionalEditingDomain used to execute commands.
	 * 
	 * @param event
	 * @return
	 * @throws NullPointerException
	 *         if the TransactionalEditingDomain can't be found.
	 */
	private TransactionalEditingDomain getTransactionalEditingDomain(ExecutionEvent event) {
		IEditorPart activePart = HandlerUtil.getActiveEditor(event);
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)activePart.getAdapter(TransactionalEditingDomain.class);
		return editingDomain;
	}

	/**
	 * Close all the diagrams.
	 * 
	 * @param pageMngr
	 */
	public void execute(final IPageManager pageMngr, TransactionalEditingDomain editingDomain) throws ExecutionException {
		if(editingDomain == null) {
			throw new ExecutionException("Editing domain not found");
		}

		boolean atLeastOneOpenPage = false;
		for(Object pageIdentifier : pageMngr.allPages()) {
			if(pageMngr.isOpen(pageIdentifier)) {
				atLeastOneOpenPage = true;
				break;
			}
		}

		if(!atLeastOneOpenPage) {
			return;
		}

		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Close all pages") {

			@Override
			protected void doExecute() {

				pageMngr.closeAllOpenedPages();
			}
		});
	}

}
