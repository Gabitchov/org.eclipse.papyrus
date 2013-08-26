/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.menu.actions.SizeAction;
import org.eclipse.papyrus.uml.diagram.menu.actions.handlers.SizeHandler;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomSizeHandler extends SizeHandler {

	/**
	 * Constructor.
	 * 
	 */
	public CustomSizeHandler() {
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.menu.actions.handlers.SizeHandler#getCommand()
	 * 
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected Command getCommand() {
		super.getCommand();
		CustomSizeAction action = new CustomSizeAction(this.parameter, getSelectedElements());
		Command cmd = action.getCommand();
		return (cmd == null) ? UnexecutableCommand.INSTANCE : cmd;
	}

	public class CustomSizeAction extends SizeAction {

		/**
		 * Constructor.
		 * 
		 * @param parameter
		 * @param selectedElements
		 */
		public CustomSizeAction(String parameter, List<IGraphicalEditPart> selectedElements) {
			super(parameter, selectedElements);
		}

		/**
		 * Return the command for the Same Height Action
		 * 
		 * @return
		 *         Return the command for the Same Height Action
		 */
		@Override
		protected Command getHeightCommand() {
			if(!(this.selectedElements.size() > 1)) {
				return UnexecutableCommand.INSTANCE;
			} else {
				// Create a compound command to hold the resize commands
				CompoundCommand doResizeCmd = new CompoundCommand();
				// Create an iterator for the selection
				Iterator<IGraphicalEditPart> iter = selectedElements.iterator();
				// Get the Primary Selection
				Dimension primarySize = getPrimarySize();
				while(iter.hasNext()) {
					// For each figure in the selection (to be resize) a request is created for resize to new bounds in the south-east direction.
					// The command for this resize is contributed by the edit part for the resize request.
					IGraphicalEditPart toResize = iter.next();
					View resizeView = (View)toResize.getModel();
					Integer previousWidth = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width());
					Integer previousHeight = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height());
					Dimension previousSize;
					if(previousWidth.intValue() == -1 || previousHeight.intValue() == -1) {
						previousSize = toResize.getFigure().getSize().getCopy();
					} else {
						previousSize = new Dimension(previousWidth.intValue(), previousHeight.intValue());
					}
					// Calculate delta resize
					Dimension delta = new Dimension(0, primarySize.height - previousSize.height);
					if(isLifelines()) {
						//Align all Lifelines at bottom.
						Rectangle constraint = getLifelineConstraint();
						Rectangle previousRect = SequenceUtil.getAbsoluteBounds(toResize);
						delta.height = constraint.bottom() - previousRect.bottom();
					}
					// Prepare setBoundRequest
					ChangeBoundsRequest bRequest = new ChangeBoundsRequest();
					bRequest.setResizeDirection(PositionConstants.SOUTH);
					bRequest.setSizeDelta(delta);
					bRequest.setType(RequestConstants.REQ_RESIZE);
					Command resizeCommand = toResize.getCommand(bRequest);
					// Previous implementation (following line) forced bounds on view instead of using resize command provided by the edit part.
					//
					// size.width = ((Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width())).intValue();
					// doResizeCmd.add(new ICommandProxy(new SetBoundsCommand(toResize.getEditingDomain(), "", new EObjectAdapter(resizeView), size))); //$NON-NLS-1$
					//
					doResizeCmd.add(resizeCommand);
				}
				return doResizeCmd.unwrap();
			}
		}

		protected Dimension getPrimarySize() {
			if(selectedElements.isEmpty()) {
				return null;
			}
			// Get the Primary Selection
			int last = selectedElements.size() - 1;
			IGraphicalEditPart primary = selectedElements.get(last);
			return getPrimarySize(primary);
		}

		private boolean isLifelines() {
			if(selectedElements.isEmpty()) {
				return true;
			}
			boolean isLifelines = true;
			for(int i = 0; i < selectedElements.size(); i++) {
				isLifelines &= selectedElements.get(i) instanceof LifelineEditPart;
			}
			return isLifelines;
		}

		protected Rectangle getLifelineConstraint() {
			Rectangle constraint = new Rectangle();
			for(int i = 0; i < selectedElements.size(); i++) {
				LifelineEditPart lifelineEditPart = (LifelineEditPart)selectedElements.get(i);
				Rectangle rect = SequenceUtil.getAbsoluteBounds(lifelineEditPart);
				constraint.union(rect);
			}
			return constraint;
		}

		protected Dimension getPrimarySize(IGraphicalEditPart primaryChild) {
			View primaryView = (View)primaryChild.getModel();
			Integer width = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Width());
			Integer height = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Height());
			Dimension primarySize;
			if(width.intValue() == -1 || height.intValue() == -1) {
				primarySize = primaryChild.getFigure().getSize().getCopy();
			} else {
				primarySize = new Dimension(width.intValue(), height.intValue());
			}
			return primarySize;
		}

		/**
		 * Return the command for the Same Width Action
		 * 
		 * @return
		 *         the command for the Same Width Action
		 */
		@Override
		protected Command getWidthCommand() {
			if(!(this.selectedElements.size() > 1)) {
				return UnexecutableCommand.INSTANCE;
			} else {
				// Create a compound command to hold the resize commands
				CompoundCommand doResizeCmd = new CompoundCommand();
				// Create an iterator for the selection
				Iterator<IGraphicalEditPart> iter = selectedElements.iterator();
				// Get the Primary Selection
				Dimension primarySize = getPrimarySize();
				while(iter.hasNext()) {
					// For each figure in the selection (to be resize) a request is created for resize to new bounds in the south-east direction.
					// The command for this resize is contributed by the edit part for the resize request.
					IGraphicalEditPart toResize = iter.next();
					View resizeView = (View)toResize.getModel();
					Integer previousWidth = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width());
					Integer previousHeight = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height());
					Dimension previousSize;
					if(previousWidth.intValue() == -1 || previousHeight.intValue() == -1) {
						previousSize = toResize.getFigure().getSize().getCopy();
					} else {
						previousSize = new Dimension(previousWidth.intValue(), previousHeight.intValue());
					}
					// Calculate delta resize
					Dimension delta = new Dimension(primarySize.width - previousSize.width, 0);
					// Prepare setBoundRequest
					ChangeBoundsRequest bRequest = new ChangeBoundsRequest();
					bRequest.setResizeDirection(PositionConstants.EAST);
					bRequest.setSizeDelta(delta);
					bRequest.setType(RequestConstants.REQ_RESIZE);
					Command resizeCommand = toResize.getCommand(bRequest);
					// Previous implementation (following line) forced bounds on view instead of using resize command provided by the edit part.
					//
					// size.height = ((Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height())).intValue();
					// doResizeCmd.add(new ICommandProxy(new SetBoundsCommand(toResize.getEditingDomain(), "", new EObjectAdapter(resizeView), size))); //$NON-NLS-1$
					//
					doResizeCmd.add(resizeCommand);
				}
				return doResizeCmd.unwrap();
			}
		}

		/**
		 * @see org.eclipse.papyrus.uml.diagram.menu.actions.SizeAction#getBothCommand()
		 * 
		 * @return
		 */
		@Override
		protected Command getBothCommand() {
			if(!(this.selectedElements.size() > 1)) {
				return UnexecutableCommand.INSTANCE;
			} else {
				// Create a compound command to hold the resize commands
				CompoundCommand doResizeCmd = new CompoundCommand();

				// Create an iterator for the selection
				Iterator<IGraphicalEditPart> iter = selectedElements.iterator();

				// Get the Primary Selection
				int last = selectedElements.size() - 1;
				IGraphicalEditPart primary = selectedElements.get(last);
				View primaryView = (View)primary.getModel();
				Integer width = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Width());
				Integer height = (Integer)ViewUtil.getStructuralFeatureValue(primaryView, NotationPackage.eINSTANCE.getSize_Height());

				Dimension primarySize;
				if(width.intValue() == -1 || height.intValue() == -1) {
					primarySize = primary.getFigure().getSize().getCopy();
				} else {
					primarySize = new Dimension(width.intValue(), height.intValue());
				}

				while(iter.hasNext()) {

					// For each figure in the selection (to be resize) a request is created for resize to new bounds in the south-east direction.
					// The command for this resize is contributed by the edit part for the resize request.

					IGraphicalEditPart toResize = iter.next();
					View resizeView = (View)toResize.getModel();
					Integer previousWidth = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width());
					Integer previousHeight = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height());

					Dimension previousSize;
					if(previousWidth.intValue() == -1 || previousHeight.intValue() == -1) {
						previousSize = toResize.getFigure().getSize().getCopy();
					} else {
						previousSize = new Dimension(previousWidth.intValue(), previousHeight.intValue());
					}

					// Calculate delta resize
					Dimension delta = new Dimension(primarySize.width - previousSize.width, primarySize.height - previousSize.height);
					if(isLifelines()) {
						//Align all Lifelines at bottom.
						Rectangle constraint = getLifelineConstraint();
						Rectangle previousRect = SequenceUtil.getAbsoluteBounds(toResize);
						delta.height = constraint.bottom() - previousRect.bottom();
					}
					// Prepare setBoundRequest
					ChangeBoundsRequest bRequest = new ChangeBoundsRequest();
					bRequest.setResizeDirection(PositionConstants.SOUTH_EAST);
					bRequest.setSizeDelta(delta);
					bRequest.setType(RequestConstants.REQ_RESIZE);

					Command resizeCommand = toResize.getCommand(bRequest);

					// Previous implementation (following line) forced bounds on view instead of using resize command provided by the edit part.
					//
					// doResizeCmd.add(new ICommandProxy(new SetBoundsCommand(toResize.getEditingDomain(), "", new EObjectAdapter(resizeView), primarySize))); //$NON-NLS-1$
					//

					doResizeCmd.add(resizeCommand);
				}

				return doResizeCmd.unwrap();
			}
		}
	}
}
