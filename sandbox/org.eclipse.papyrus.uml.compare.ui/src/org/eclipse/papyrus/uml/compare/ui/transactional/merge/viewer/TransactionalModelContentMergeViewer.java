package org.eclipse.papyrus.uml.compare.ui.transactional.merge.viewer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.ui.viewer.content.ModelContentMergeViewer;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.EMFOperationCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.papyrus.uml.compare.ui.Activator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class TransactionalModelContentMergeViewer extends ModelContentMergeViewer {

	private TransactionalEditingDomain domain;
	
	
	private boolean isSynchronizedWithDiagram;

	//duplicate code from tatiana
	public TransactionalModelContentMergeViewer(Composite parent, CompareConfiguration config) {
		super(parent, config);
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(editor instanceof IEditingDomainProvider) {
			domain = (TransactionalEditingDomain)((IEditingDomainProvider)editor).getEditingDomain();
		}
	}

	@Override
	protected ModelContentMergeTabFolder createModelContentMergeTabFolder(Composite composite, int side) {
		// TODO Auto-generated method stub
		//		return super.createModelContentMergeTabFolder(composite, side);
		return new TransactionalModelContentMergeTabFolder(this, composite, side);
	}

	/**
	 * Undoes the changes implied by the currently selected {@link DiffElement diff}.
	 */
	protected void copyDiffLeftToRight() {
		if(currentSelection != null) {
			doCopy(currentSelection, true);
		}
		currentSelection.clear();
		switchCopyState(false);
	}

	/**
	 * Applies the changes implied by the currently selected {@link DiffElement diff}.
	 */
	protected void copyDiffRightToLeft() {
		if(currentSelection != null) {
			doCopy(currentSelection, false);
		}
		currentSelection.clear();
		switchCopyState(false);
	}


	protected void doCopy(final List<DiffElement> diffs, final boolean leftToRight) {
		Map<?, ?> transactionOptions = Collections.EMPTY_MAP;
		final Runnable runnable = new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				TransactionalModelContentMergeViewer.this.copy(diffs, leftToRight);
			}
		};

		//		AbstractCommand cmd = new ChangeC(){
		//
		//			public void execute() {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//
		//			public void redo() {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//			
		//		}
		IUndoableOperation operation = new AbstractEMFOperation(domain, "copy action", transactionOptions) {

			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				//				try {
				runnable.run();
				return Status.OK_STATUS;
				//				} catch (RuntimeException ex) {
				//					if (ex instanceof OperationCanceledException) {
				//						throw (OperationCanceledException) ex;
				//					} else {
				////						throw new ExecutionException(NLS.bind(Messages.problem_transactionFailed, operationLabel), ex);
				//					}
				//				}
				//				
			}

			//			@Override
			//			public boolean canUndo() {
			////				return transactionOptions.get(Transaction.OPTION_NO_UNDO) != Boolean.TRUE;
			//			}


		};

		Command command = new EMFOperationCommand(domain, operation);
		//		domain.getCommandStack().
		domain.getCommandStack().execute(command);

	}


	@Override
	protected void createToolItems(ToolBarManager tbm) {
		
		final IAction diagramSynchronization = new Action("Diagram Synchronisation", IAction.AS_CHECK_BOX) {

			@Override
			public ImageDescriptor getImageDescriptor() {
				//TODO improve?
				return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/PapyrusLogo16x16.gif");
			}
		};


		ActionContributionItem actionContributionItem = new ActionContributionItem(diagramSynchronization) {
			@Override
			public void fill(ToolBar parent, int index) {
				// TODO Auto-generated method stub
				super.fill(parent, index);
			}
		};
		//actionContributionItem.setMode(ActionContributionItem.MODE_FORCE_TEXT);
		diagramSynchronization.addPropertyChangeListener(new IPropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent event) {
				//we are here each time the user click on the action!
				diagramSynchronization.setChecked(diagramSynchronization.isChecked());
				isSynchronizedWithDiagram = diagramSynchronization.isChecked();
			}
		});
		tbm.insert(0, actionContributionItem);
		super.createToolItems(tbm);
	}

}
