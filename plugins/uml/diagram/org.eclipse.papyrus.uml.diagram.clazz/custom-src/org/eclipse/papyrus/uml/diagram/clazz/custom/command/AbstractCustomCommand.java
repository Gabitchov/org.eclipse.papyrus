package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

public abstract class AbstractCustomCommand extends AbstractTransactionalCommand {

	/** The node. */
	protected View node;

	/** The viewer. */
	protected EditPartViewer viewer;

	public AbstractCustomCommand(TransactionalEditingDomain domain, String label, List<?> affectedFiles) {
		super(domain, label, affectedFiles);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public List<IFile> getAffectedFiles() {
		if (viewer != null) {
			EditPart editpart = viewer.getRootEditPart().getContents();
			if (editpart instanceof IGraphicalEditPart) {
				View view = (View) ((IGraphicalEditPart) editpart).getModel();
				if (view != null) {
					IFile f = WorkspaceSynchronizer.getFile(view.eResource());
					if (f != null) {
						return Collections.singletonList(f);
					} else {
						return Collections.emptyList();
					}

				}
			}
		}

		List<IFile> result = new ArrayList<IFile>();
		List<?> affectedFiles = super.getAffectedFiles();
		for (Object affectedFile : affectedFiles) {
			result.add((IFile) affectedFile);
		}

		return result;
	}

	@Override
	protected abstract CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException;

	/**
	 * used to set the node
	 * 
	 * @param newNode
	 *            the newNode to set
	 */
	public void setNode(View newNode) {
		node = newNode;
	}

	/**
	 * used to obtain the created node.
	 * 
	 * @return the created node
	 */
	public View getNode() {
		return node;
	}
}
