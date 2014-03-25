/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEALIST - Initial API and implementation (Adapted code from DeferredLayoutCommand)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.SnapToHelper;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.snap.BorderNodeSnapHelper;
import org.eclipse.papyrus.infra.gmfdiag.common.snap.NodeSnapHelper;

/**
 * This command is used to snap editparts on the grid, when only the view
 * adapters are available at the time of creating the command. It is necessary
 * to have the editparts when creating a snap command so this command defers
 * the creation of the layout command until execution time at which point it can
 * get the editparts from the editpart registry using the view adapters.
 * 
 * @author vlorenzo
 */
//TODO : creation from the palette should use me
//TODO : move action could use me???
public class DeferredSnapToGridCommand extends AbstractTransactionalCommand {

	/** the IAdaptables from which an View can be retrieved */
	protected List<?> viewAdapters;

	/** the diagram editpart used to get the editpart registry */
	protected IGraphicalEditPart containerEP;

	/**
	 * Constructor for <code>DefferedSnapToGridCommand</code>.
	 * 
	 * @param editingDomain
	 *        the editing domain through which model changes are made
	 * @param viewAdapters
	 *        the IAdaptables from which an IView can be retrieved
	 * @param containerEP
	 *        the container editpart used to get the editpart registry
	 */
	public DeferredSnapToGridCommand(TransactionalEditingDomain editingDomain, List<?> viewAdapters, IGraphicalEditPart containerEP) {
		super(editingDomain, "Deferred Snap to grid command", null); //$NON-NLS-1$
		this.viewAdapters = viewAdapters;
		this.containerEP = containerEP;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#getAffectedFiles()
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getAffectedFiles() {
		if(containerEP != null) {
			View view = (View)containerEP.getModel();
			if(view != null) {
				IFile f = WorkspaceSynchronizer.getFile(view.eResource());
				return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
			}
		}
		return super.getAffectedFiles();
	}

	/**
	 * Executes a layout command with all the editparts for the view adapters.
	 * 
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		final RunnableWithResult<List<IGraphicalEditPart>> refreshRunnable = new RunnableWithResult<List<IGraphicalEditPart>>() {

			private IStatus status;

			private List<IGraphicalEditPart> result;

			public List<IGraphicalEditPart> getResult() {
				return result;
			}

			public void setStatus(IStatus status) {
				this.status = status;
			}

			public IStatus getStatus() {
				return status;
			}

			public void run() {
				containerEP.refresh();

				// The layout command requires that the figure world is updated.
				getContainerFigure().invalidate();
				getContainerFigure().validate();

				List<IGraphicalEditPart> editParts = new ArrayList<IGraphicalEditPart>(viewAdapters.size());
				Map<?, ?> epRegistry = containerEP.getRoot().getViewer().getEditPartRegistry();
				for(Iterator<?> iter = viewAdapters.iterator(); iter.hasNext();) {
					IAdaptable ad = (IAdaptable)iter.next();
					View view = (View)ad.getAdapter(View.class);
					Object ep = epRegistry.get(view);
					if(ep instanceof IGraphicalEditPart) {
						editParts.add((IGraphicalEditPart)ep);
					}
				}

				if(editParts.isEmpty()) {
					result = editParts;
					return;
				}

				//probably useless
				//				Set<IGraphicalEditPart> layoutSet = new HashSet<IGraphicalEditPart>(editParts.size());
				//				layoutSet.addAll(editParts);
				//
				//				// refresh source and target connections of any shapes in the container not being considered for layout
				//				Iterator<?> iter = containerEP.getChildren().iterator();
				//				while(iter.hasNext()) {
				//					Object obj = iter.next();
				//					if(!layoutSet.contains(obj) && obj instanceof IGraphicalEditPart) {
				//						IGraphicalEditPart ep = (IGraphicalEditPart)obj;
				//						ep.refresh();
				//					}
				//				}

				result = editParts;
			}
		};

		EditPartUtil.synchronizeRunnableToMainThread(containerEP, refreshRunnable);
		List<IGraphicalEditPart> editParts = refreshRunnable.getResult();
		if(editParts == null || editParts.isEmpty()) {
			return CommandResult.newOKCommandResult();
		}

		//	add an arrange command, to layout the related shapes
		CompoundCommand cc = new CompoundCommand("Snap Command"); //$NON-NLS-1$
		for(final IGraphicalEditPart current : editParts) {
			final SnapToHelper snapHelper = (SnapToHelper)((IAdaptable)current).getAdapter(SnapToHelper.class);
			final NodeSnapHelper nodeSnapHelper;
			final PrecisionRectangle boundsFigure = new PrecisionRectangle(((GraphicalEditPart)current).getFigure().getBounds());
			current.getFigure().translateToAbsolute(boundsFigure);
			final PrecisionRectangle result = new PrecisionRectangle(boundsFigure);
			if(current instanceof BorderedBorderItemEditPart) {
				nodeSnapHelper = new BorderNodeSnapHelper(snapHelper, boundsFigure);
			} else {
				nodeSnapHelper = new NodeSnapHelper(snapHelper, boundsFigure);
			}
			ChangeBoundsRequest request = new ChangeBoundsRequest("move"); //$NON-NLS-1$
			request.setEditParts(Collections.singletonList(current));
			request.setSnapToEnabled(true);
			request.setLocation(boundsFigure.getLocation());
			nodeSnapHelper.snapPoint(request);
			request.setLocation(result.getLocation());
			cc.add(((EditPart)current).getCommand(request));
		}


		if(!cc.isEmpty() && cc.canExecute()) {
			cc.execute();
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#cleanup()
	 * 
	 */
	protected void cleanup() {
		containerEP = null;//for garbage collection
		viewAdapters = null;
		super.cleanup();
	}

	/**
	 * gets the container edit part's figure
	 * 
	 * @return the container figure
	 */
	protected IFigure getContainerFigure() {
		return containerEP.getFigure();
	}

	/**
	 * gets the container edit part
	 * 
	 * @return the container edit part
	 */
	protected IGraphicalEditPart getContainerEP() {
		return containerEP;
	}

	/**
	 * gets a list of <code>IAdaptable</code> that can adapt to <code>
	 * View</code>
	 * 
	 * @return view adapters
	 */
	protected List<?> getViewAdapters() {
		return viewAdapters;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && containerEP != null;
	}
}
