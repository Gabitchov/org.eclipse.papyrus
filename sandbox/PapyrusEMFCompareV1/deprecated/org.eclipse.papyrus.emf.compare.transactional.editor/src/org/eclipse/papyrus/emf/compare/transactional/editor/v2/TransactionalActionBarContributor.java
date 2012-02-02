package org.eclipse.papyrus.emf.compare.transactional.editor.v2;

import java.awt.color.ProfileDataException;
import java.util.EventObject;
import java.util.Set;
import java.util.jar.Manifest;

import org.eclipse.core.commands.operations.IOperationHistoryListener;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.OperationHistoryEvent;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.ui.action.EditingDomainActionBarContributor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.sphinx.emf.compare.ui.editor.ModelCompareEditor;
import org.eclipse.sphinx.emf.compare.ui.internal.Activator;
import org.eclipse.sphinx.emf.util.WorkspaceEditingDomainUtil;
import org.eclipse.sphinx.platform.util.PlatformLogUtil;
import org.eclipse.ui.IEditorPart;


public class TransactionalActionBarContributor extends EditingDomainActionBarContributor {

	//TODO useful?
//not used!
	protected IOperationHistoryListener historyListener;

	public void init(org.eclipse.ui.IActionBars actionBars) {
		super.init(actionBars);
		historyListener = createOperationHistoryListener();

	}

	/**
	 * Creates the {@linkplain IOperationHistoryListener operation history listener} that is responsible for setting
	 * editing domain on <em>undo</em>/<em>redo</em> actions as soon as an operation (on the command stack of that
	 * precise editing domain) has been finished.
	 * 
	 * @return The {@linkplain IOperationHistoryListener operation history listener} to add on the concerned editing
	 *         domain's command stack.
	 */
	protected IOperationHistoryListener createOperationHistoryListener() {
		return new IOperationHistoryListener() {

			public void historyNotification(OperationHistoryEvent event) {
				if(event.getEventType() == OperationHistoryEvent.DONE || event.getEventType() == OperationHistoryEvent.UNDONE || event.getEventType() == OperationHistoryEvent.REDONE) {
					undoAction.update();
					redoAction.update();
					//					IUndoContext[] contexts = event.getOperation().getContexts();
					//					for (IUndoContext context : contexts) {
					//						if (ModelCompareEditor.ID.equals(context.getLabel())) {
					//							Set<Resource> affectedResources = ResourceUndoContext.getAffectedResources(event.getOperation());
					//							TransactionalEditingDomain editingDomain = null;
					//							for (Resource resource : affectedResources) {
					//								TransactionalEditingDomain domain = WorkspaceEditingDomainUtil.getEditingDomain(resource);
					//								if (editingDomain != null && editingDomain != domain) {
					//									//
					//									// !! Important Note !!
					//									// For the moment, the case where two elements from different editing domain are
					//									// compared is not really supported because we do not know very well the expected
					//									// behavior of such a kind of comparison.
					//									//
					//									UnsupportedOperationException ex = new UnsupportedOperationException("Several editing domains"); //$NON-NLS-1$
					//									PlatformLogUtil.logAsWarning(Activator.getPlugin(), ex);
					//									editingDomain = null;
					//									break;
					//								} else {
					//									editingDomain = domain;
					//								}
					//							}
					//							if (editingDomain != null) {
					//								// Set editing domain on Undo/Redo actions
					//								if (undoAction != null) {
					//									undoAction.setEditingDomain(editingDomain);
					//								}
					//								if (redoAction != null) {
					//									redoAction.setEditingDomain(editingDomain);
					//								}
					//							}
					//							break;
					//						}
					//					}
				}
			}
		};
	}

	private TransactionalEditingDomain domain;

	@Override
	public void activate() {
		IEditorPart part = getActiveEditor();
		if(part instanceof IEditingDomainProvider) {
			domain = (TransactionalEditingDomain)((IEditingDomainProvider)part).getEditingDomain();
			domain.getCommandStack().addCommandStackListener(new CommandStackListener() {

				public void commandStackChanged(EventObject event) {
					// TODO Auto-generated method stub
					undoAction.update();
					redoAction.update();
					//TODO : try to refresh the editor!
					//getActiveEditor().getEditorInput().
				}
			});
		}
		// TODO Auto-generated method stub
		super.activate();
	}
}
