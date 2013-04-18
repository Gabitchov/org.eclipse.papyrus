/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted Code from Eclipse GMF 
 *  (AutoSizeAction, SizeBothAction, SizeHeightAction and SizeWidthAction)
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.layout.LayoutUtils;
import org.eclipse.papyrus.uml.diagram.common.util.Util;
import org.eclipse.papyrus.uml.diagram.menu.actions.DistributeAffixedChildNodeLinkAction.AffixedChildNodeRepresentation;

/**
 * 
 * This class provides commands to change the size of the selected {@link IGraphicalEditPart}
 * 
 */
public class SizeAction {

	/** parameter for the autosize action */
	public static final String PARAMETER_AUTOSIZE = "parameter_autosize"; //$NON-NLS-1$

	/** parameter for the Same Height and Width action */
	public static final String PARAMETER_BOTH = "parameter_both"; //$NON-NLS-1$

	/** parameter for the same Height action */
	public static final String PARAMETER_HEIGHT = "parameter_height"; //$NON-NLS-1$

	/** parameter for the Same Width action */
	public static final String PARAMETER_WIDTH = "parameter_width"; //$NON-NLS-1$

	/** the size action type */
	protected int sizeActionType = 0;

	/** value for the AutoSize action */
	public static final int AUTOSIZE = 0;

	/** value for the Both (Same Height and Width) action */
	public static final int BOTH = AUTOSIZE + 1;

	/** value for the Same Height action */
	public static final int HEIGHT = BOTH + 1;

	/** value for the Same Width action */
	public static final int WIDTH = HEIGHT + 1;

	/** the selected elements */
	public List<IGraphicalEditPart> selectedElements;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        the parameter for this action
	 * @param selectedElements
	 *        the selected elements for this action
	 */
	public SizeAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
		if(PARAMETER_AUTOSIZE.equals(parameter)) {
			this.sizeActionType = AUTOSIZE;
		} else if(PARAMETER_BOTH.equals(parameter)) {
			this.sizeActionType = BOTH;
		} else if(PARAMETER_HEIGHT.equals(parameter)) {
			this.sizeActionType = HEIGHT;
		} else if(PARAMETER_WIDTH.equals(parameter)) {
			this.sizeActionType = WIDTH;
		}
	}

	/**
	 * Return the command for this Action
	 * 
	 * @return
	 *         The command for this Action
	 */
	public Command getCommand() {
		switch(this.sizeActionType) {
		case AUTOSIZE:
			return getAutoSizeCommand();
		case BOTH:
			return getBothCommand();
		case HEIGHT:
			return getHeightCommand();
		case WIDTH:
			return getWidthCommand();

		default:
			return UnexecutableCommand.INSTANCE;
		}

	}

	/**
	 * Return the command for the AutoSize Action
	 * 
	 * @return
	 *         the command for the AutoSize Action
	 */
	protected Command getAutoSizeCommand() {
		// check if the element is selected
		if(this.selectedElements.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		} else {
			boolean foundNonAutosizedPart = false;
			List<IGraphicalEditPart> operationSet = selectedElements;

			CompoundCommand command = new CompoundCommand("AutoSize Command"); //$NON-NLS-1$
				
			for(IGraphicalEditPart editPart : selectedElements) {
				//Local variables
				int posRightParent = 0;
				int posDownParent = 0;
				Dimension delta;
				double[] zoomMargin = { 0,0,0,0,0,0, 1.5, 2.5, 3.5, 4.5, 13.5 };
								
				//check if the editpart is autosized
				if(editPart instanceof GraphicalEditPart) {
					GraphicalEditPart graphicalEditPart = (GraphicalEditPart)editPart;

					Integer containerWidth = (Integer)graphicalEditPart.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Width());
					Integer containerHeight = (Integer)graphicalEditPart.getStructuralFeatureValue(NotationPackage.eINSTANCE.getSize_Height());

					List<?> listept = editPart.getChildren();
					if(containerWidth.intValue() != -1 || containerHeight.intValue() != -1 || !(listept.isEmpty())) {
						foundNonAutosizedPart = true;
						PrecisionRectangle boundsEditPart = LayoutUtils.getAbsolutePosition(graphicalEditPart);

						posRightParent = boundsEditPart.right();
						posDownParent = boundsEditPart.bottom();

					} else {
						return UnexecutableCommand.INSTANCE;
					}
				}
								
				// Function find editpart
				Dimension d = findSizeChildren(editPart);
				
				if(d.height > 0 && d.width > 0) {
					//Detected zoom
					ZoomAction zoomAction = new ZoomAction("Zoom", operationSet);
					ZoomManager zoomMngr = zoomAction.getZoomManager();
					double[]  zoomLevel = zoomMngr.getZoomLevels();
					
					double currentZoomLevel = zoomMngr.getZoom();
					
					int index = findIndex(currentZoomLevel,zoomLevel);
					double cstZoom = 0;
					if (index != -1){
						cstZoom = zoomMargin[index];
					}
								
					
					int newW = (int)((posRightParent - d.width) - LayoutUtils.scrollBarSize - cstZoom);
					int newH = (int)((posDownParent - d.height) - LayoutUtils.scrollBarSize - cstZoom);

					delta = new Dimension(-(newW), -(newH));

					// Prepare setBoundRequest
					ChangeBoundsRequest bRequest = new ChangeBoundsRequest();

					bRequest.setSizeDelta(delta);
					bRequest.setType(RequestConstants.REQ_RESIZE);
					Command resizeCommand = editPart.getCommand(bRequest);
					command.add(resizeCommand);

				} else {
					// Prepare setBoundRequest
					ChangeBoundsRequest bRequest = new ChangeBoundsRequest();
					bRequest.setResizeDirection(PositionConstants.BOTTOM);

					bRequest.setType(RequestConstants.REQ_AUTOSIZE);
					Command resizeCommand = editPart.getCommand(bRequest);
					command.add(resizeCommand);
				}
				
			}
			
			return command.isEmpty() || command.size() != (operationSet.size())  || !foundNonAutosizedPart ? UnexecutableCommand.INSTANCE : (Command)command;
			
		}
	}

	private Dimension findSizeChildren(IGraphicalEditPart editPart) {
		Dimension sizeChild = new Dimension(0,0);
		int maxRight = 0;
		int maxDown = 0;
		
		//Contents of Edit Part selected
		List<EditPart> contents = editPart.getChildren() ;
				
			for(int index = 0; index < contents.size(); index++) {
				EditPart editPartCompar = contents.get(index);
				List<?> editPartChild = editPartCompar.getChildren();
				
				if(!editPartChild.isEmpty()) {
					
					for(int index2 = 0; index2 < editPartChild.size(); index2++) {
						if(editPartChild.get(index2) != null) {
							
							GraphicalEditPart graphicalEditPart = (GraphicalEditPart)editPartChild.get(index2);
							
							if ( graphicalEditPart.getChildren().size() > 1 && ! (editPartChild instanceof AffixedChildNodeRepresentation)){
								PrecisionRectangle rectEditPartChild = LayoutUtils.getAbsolutePosition(graphicalEditPart);

								maxRight = (rectEditPartChild.right() > maxRight) ? rectEditPartChild.right() : maxRight;
								maxDown = (rectEditPartChild.bottom() > maxDown) ? rectEditPartChild.bottom() : maxDown;
								sizeChild = new Dimension(maxRight,maxDown);
							}else{
								return findSizeChildren(graphicalEditPart);
								
							}
					}
				}
			}else{
				sizeChild = new Dimension(0,0);
			}
				
		}
		
		return sizeChild;
	}

	/**
	 * Find index.
	 *
	 * @param currentZoomLevel the current zoom level
	 * @param zoomLevel the zoom level
	 * @return the int
	 */
	private int findIndex(double currentZoomLevel, double[] zoomLevel) {
		for(int i=0 ; i <= zoomLevel.length; i++){
			if (zoomLevel[i] == currentZoomLevel)
				return i;
		}
			
		return -1; //element not found
	}

	/**
	 * Return the command for the Same Height and Width Action
	 * 
	 * @return
	 *         Return the command for the Same Height and Width Action
	 */
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
			if(width.intValue() == -1 || height.intValue() == -1)
				primarySize = primary.getFigure().getSize().getCopy();
			else
				primarySize = new Dimension(width.intValue(), height.intValue());

			while(iter.hasNext()) {

				// For each figure in the selection (to be resize) a request is created for resize to new bounds in the south-east direction.
				// The command for this resize is contributed by the edit part for the resize request.

				IGraphicalEditPart toResize = iter.next();
				View resizeView = (View)toResize.getModel();
				Integer previousWidth = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width());
				Integer previousHeight = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height());

				Dimension previousSize;
				if(previousWidth.intValue() == -1 || previousHeight.intValue() == -1)
					previousSize = toResize.getFigure().getSize().getCopy();
				else
					previousSize = new Dimension(previousWidth.intValue(), previousHeight.intValue());

				// Calculate delta resize
				Dimension delta = new Dimension(primarySize.width - previousSize.width, primarySize.height - previousSize.height);

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

				doResizeCmd.add(resizeCommand); //$NON-NLS-1$
			}

			return doResizeCmd.unwrap();
		}
	}

	/**
	 * Return the command for the Same Height Action
	 * 
	 * @return
	 *         Return the command for the Same Height Action
	 */
	protected Command getHeightCommand() {
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
			if(width.intValue() == -1 || height.intValue() == -1)
				primarySize = primary.getFigure().getSize().getCopy();
			else
				primarySize = new Dimension(width.intValue(), height.intValue());

			while(iter.hasNext()) {

				// For each figure in the selection (to be resize) a request is created for resize to new bounds in the south-east direction.
				// The command for this resize is contributed by the edit part for the resize request.

				IGraphicalEditPart toResize = iter.next();
				View resizeView = (View)toResize.getModel();
				Integer previousWidth = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width());
				Integer previousHeight = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height());

				Dimension previousSize;
				if(previousWidth.intValue() == -1 || previousHeight.intValue() == -1)
					previousSize = toResize.getFigure().getSize().getCopy();
				else
					previousSize = new Dimension(previousWidth.intValue(), previousHeight.intValue());

				// Calculate delta resize
				Dimension delta = new Dimension(0, primarySize.height - previousSize.height);

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

				doResizeCmd.add(resizeCommand); //$NON-NLS-1$
			}

			return doResizeCmd.unwrap();
		}
	}

	/**
	 * Return the command for the Same Width Action
	 * 
	 * @return
	 *         the command for the Same Width Action
	 */
	protected Command getWidthCommand() {
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
			if(width.intValue() == -1 || height.intValue() == -1)
				primarySize = primary.getFigure().getSize().getCopy();
			else
				primarySize = new Dimension(width.intValue(), height.intValue());

			while(iter.hasNext()) {

				// For each figure in the selection (to be resize) a request is created for resize to new bounds in the south-east direction.
				// The command for this resize is contributed by the edit part for the resize request.

				IGraphicalEditPart toResize = iter.next();
				View resizeView = (View)toResize.getModel();
				Integer previousWidth = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Width());
				Integer previousHeight = (Integer)ViewUtil.getStructuralFeatureValue(resizeView, NotationPackage.eINSTANCE.getSize_Height());

				Dimension previousSize;
				if(previousWidth.intValue() == -1 || previousHeight.intValue() == -1)
					previousSize = toResize.getFigure().getSize().getCopy();
				else
					previousSize = new Dimension(previousWidth.intValue(), previousHeight.intValue());

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

				doResizeCmd.add(resizeCommand); //$NON-NLS-1$
			}

			return doResizeCmd.unwrap();
		}
	}
}
