/*******************************************************************************
 * Copyright (c) 2009 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This class modifies the anchors of the edges connected to the passed element so that they can
 * preserve their position after the resize of the figure. If any of the anchors does not fit in the
 * new size, then no change will be made to the anchors and the command error result will be
 * returned. If everything went OK, then a command OK result will be returned.
 * 
 * This class allows to preserve the position in the Y axis, in the X axis or in both axis.
 * 
 * @author gmerin
 * 
 */
public class PreserveAnchorsPositionCommand extends AbstractTransactionalCommand {

	// The Shape being resized
	private ShapeNodeEditPart shapeEP;

	// The size delta aplied to the shape
	private Dimension sizeDelta;

	private int preserveAxis;

	// Command's label
	protected final static String COMMAND_LABEL = "Modify Anchors to Preserve Position";

	// Command's error message
	protected final static String COMMAND_ERROR_MESSAGE = "One of the anchors is left outside of the new figure's size";

	// Constants to describe which axis position should be preserved
	public final static int PRESERVE_Y = 0;

	public final static int PRESERVE_X = 1;

	public final static int PRESERVE_XY = 2;

	/**
	 * Constructor. It needs the shape being resized, it's re-size delta and the axis where the
	 * position should be preserved. The different preserveAxis values are the following:
	 * <ul>
	 * <li>ModifyAnchorsToPreservePosition.PRESERVE_Y</li>
	 * <li>ModifyAnchorsToPreservePosition.PRESERVE_X</li>
	 * <li>ModifyAnchorsToPreservePosition.PRESERVE_XY</li>
	 * </ul>
	 * 
	 * @param shapeEP
	 *        the ShapeNodeEditPart that is being resized
	 * @param sizeDelta
	 *        the re-size delta
	 * @param preserveAxis
	 *        the axis where the position should be preserved. If the given value is not valid,
	 *        then PRESERVE_Y will be taken as default
	 */
	public PreserveAnchorsPositionCommand(ShapeNodeEditPart shapeEP, Dimension sizeDelta, int preserveAxis) {
		super(shapeEP.getEditingDomain(), COMMAND_LABEL, null);
		setShapeEP(shapeEP);
		setSizeDelta(sizeDelta);
		setPreserveAxis(preserveAxis);
	}

	/**
	 * Set the new value of the preserveAxis property
	 * 
	 * @param preserveAxis
	 *        the new preserveAxis value
	 */
	public void setPreserveAxis(int preserveAxis) {
		if(preserveAxis != PRESERVE_Y && preserveAxis != PRESERVE_X && preserveAxis != PRESERVE_XY) {
			this.preserveAxis = PRESERVE_Y;
		} else {
			this.preserveAxis = preserveAxis;
		}
	}

	/**
	 * Return the current value of the preserveAxis property
	 * 
	 * @return preserveAxis current value
	 */
	public int getPreserveAxis() {
		return preserveAxis;
	}

	/**
	 * Set the new value of the ShapeNodeEditPart property
	 * 
	 * @param shapeEP
	 */
	public void setShapeEP(ShapeNodeEditPart shapeEP) {
		this.shapeEP = shapeEP;
	}

	/**
	 * Return the current value of the ShapeNodeEditPart property
	 * 
	 * @return shapeEP
	 */
	public ShapeNodeEditPart getShapeEP() {
		return shapeEP;
	}

	/**
	 * Return the bounds of the ShapeNodeEditPart's figure
	 * 
	 * @return The bounds
	 */
	public Rectangle getFigureBounds() {
		return getShapeEP().getFigure().getBounds();
	}

	/**
	 * Return's the view associated with the ShapeNodeEditPart
	 * 
	 * @return The View
	 */
	public View getView() {
		return (View)getShapeEP().getModel();
	}

	/**
	 * Sets the new size delta property
	 * 
	 * @param sizeDelta
	 *        the new sizeDelta value
	 */
	protected void setSizeDelta(Dimension sizeDelta) {
		this.sizeDelta = sizeDelta;
	}

	/**
	 * Returns the current size delta property
	 * 
	 * @return The size delta
	 */
	public Dimension getSizeDelta() {
		return sizeDelta;
	}

	/**
	 * Execution of the command
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		View view = getView();

		List<Edge> sourceList = ViewUtil.getSourceConnections(view);
		List<Edge> targetList = ViewUtil.getTargetConnections(view);

		// Variable to know if all the anchors fit inside the new bounds
		boolean isOk = true;
		// Variable to store the anchor and it's new position
		HashMap<IdentityAnchor, String> hashMap = new HashMap<IdentityAnchor, String>();

		for(Edge edge : sourceList) {
			IdentityAnchor anchor = (IdentityAnchor)edge.getSourceAnchor();
			if(anchor != null) {
				String newIdStr = getNewIdStr(anchor);
				// If the newIdStr is null is because the anchor cannot preserve
				// it's position as it does not fit in the new bounds of the
				// figure
				if(newIdStr != null) {
					hashMap.put(anchor, newIdStr);
				} else {
					isOk = false;
					break;
				}
			}
		}
		if(isOk) {
			for(Edge edge : targetList) {
				IdentityAnchor anchor = (IdentityAnchor)edge.getTargetAnchor();
				if(anchor != null) {
					String newIdStr = getNewIdStr(anchor);
					// If the newIdStr is null is because the anchor cannot
					// preserve
					// it's position as it does not fit in the new bounds of the
					// figure
					if(newIdStr != null) {
						hashMap.put(anchor, newIdStr);
					} else {
						isOk = false;
						break;
					}
				}
			}
		}

		// If everything went OK, then commit the changes. Otherwise, return an
		// error result
		if(isOk) {
			for(Entry<IdentityAnchor, String> entry : hashMap.entrySet()) {
				entry.getKey().eSet(NotationPackage.eINSTANCE.getIdentityAnchor_Id(), entry.getValue());
			}
			return CommandResult.newOKCommandResult();
		} else {
			return CommandResult.newErrorCommandResult(COMMAND_ERROR_MESSAGE);
		}

	}

	/**
	 * Returns the new anchor's position to preserve it's position after
	 * 
	 * @param anchor
	 * @return the new IdStr
	 */
	protected String getNewIdStr(IdentityAnchor anchor) {
		Dimension sizeDelta = getSizeDelta();
		Rectangle figureBounds = getFigureBounds();

		PrecisionPoint pp = BaseSlidableAnchor.parseTerminalString(anchor.getId());

		if(getPreserveAxis() == PRESERVE_Y || getPreserveAxis() == PRESERVE_XY) {
			int anchorYPos = (int)Math.round(figureBounds.height * pp.preciseY);

			if(anchorYPos > (figureBounds.height + sizeDelta.height)) {
				return null;
			}

			pp.preciseY = (double)anchorYPos / (figureBounds.height + sizeDelta.height);
		}

		if(getPreserveAxis() == PRESERVE_X || getPreserveAxis() == PRESERVE_XY) {
			int anchorXPos = (int)Math.round(figureBounds.width * pp.preciseX);

			if(anchorXPos > (figureBounds.width + sizeDelta.width)) {
				return null;
			}

			pp.preciseX = (double)anchorXPos / (figureBounds.width + sizeDelta.width);
		}

		String idStr = (new BaseSlidableAnchor(null, pp)).getTerminal();
		return idStr;
	}

	/**
	 * This operation checks if, after resizing the ShapeNodeEditPart, all links anchors will fit
	 * inside the figure in case their positions are preserved
	 * 
	 * @param shapeEP
	 *        That shape being resized
	 * @param sizeDelta
	 *        The SizeDelta for the resize
	 * @param preserveAxis
	 *        The axisxxx
	 * @return The new SizeDelta to preserve anchors' positions
	 */
	public static Dimension getSizeDeltaToFitAnchors(ShapeNodeEditPart shapeEP, Dimension sizeDelta, int preserveAxis) {

		Dimension newSizeDelta = new Dimension(sizeDelta);
		View view = (View)shapeEP.getModel();
		Rectangle figureBounds = shapeEP.getFigure().getBounds();

		List<Edge> sourceList = ViewUtil.getSourceConnections(view);
		List<Edge> targetList = ViewUtil.getTargetConnections(view);

		for(Edge edge : sourceList) {
			IdentityAnchor anchor = (IdentityAnchor)edge.getSourceAnchor();
			modifySizeDeltaToFitAnchor(anchor, newSizeDelta, preserveAxis, figureBounds);
		}
		for(Edge edge : targetList) {
			IdentityAnchor anchor = (IdentityAnchor)edge.getTargetAnchor();
			modifySizeDeltaToFitAnchor(anchor, newSizeDelta, preserveAxis, figureBounds);
		}

		return newSizeDelta;
	}

	/**
	 * Used inside the getSizeDeltaToFitAnchors operation. It's goal is to modify a SizeDelta in
	 * order to keep fitting an anchor within the figureBounds
	 * 
	 * @param anchor
	 *        The anchor whose position will be kept
	 * @param sizeDelta
	 * @param preserveAxis
	 * @param figureBounds
	 */
	protected static void modifySizeDeltaToFitAnchor(IdentityAnchor anchor, Dimension sizeDelta, int preserveAxis,
			Rectangle figureBounds) {
		PrecisionPoint pp = BaseSlidableAnchor.parseTerminalString(anchor.getId());

		int margin = 6;

		if(preserveAxis == PRESERVE_Y || preserveAxis == PRESERVE_XY) {
			int anchorYPos = (int)Math.round(figureBounds.height * pp.preciseY);

			int newHeight = figureBounds.height + sizeDelta.height;

			if(anchorYPos + margin > newHeight) {
				sizeDelta.height = (anchorYPos - figureBounds.height) + margin;
			}
		}

		if(preserveAxis == PRESERVE_X || preserveAxis == PRESERVE_XY) {
			int anchorXPos = (int)Math.round(figureBounds.width * pp.preciseX);

			int newWidth = figureBounds.width + sizeDelta.width;

			if(anchorXPos + margin > newWidth) {
				sizeDelta.width = (anchorXPos - figureBounds.width) + margin;
			}
		}
	}

	/**
	 * Creations of a new request in order to have a correct visualization of the feedback in order
	 * to preserve links's anchors.
	 * 
	 * @param request
	 * @param editPart
	 * @return a replication of the request but with a SizeDelta modification
	 */
	// @unused
	public static Request getNewSourceFeedbackRequest(Request request, ShapeNodeEditPart editPart) {
		if(request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest currRequest = (ChangeBoundsRequest)request;
			Dimension oldDelta = currRequest.getSizeDelta();
			Dimension newDelta = getSizeDeltaToFitAnchors(editPart, oldDelta, PreserveAnchorsPositionCommand.PRESERVE_Y);
			// Information for creating a new ChangeBoundsRequest has been taken
			// from org.eclipse.gef.editpolicies.ResizableEditPolicy
			ChangeBoundsRequest newRequest = new ChangeBoundsRequest();
			newRequest.setMoveDelta(currRequest.getMoveDelta());
			newRequest.setSizeDelta(newDelta);
			newRequest.setLocation(currRequest.getLocation());
			newRequest.setExtendedData(currRequest.getExtendedData());
			newRequest.setResizeDirection(currRequest.getResizeDirection());
			newRequest.setType(currRequest.getType());
			return newRequest;
		} else {
			return request;
		}
	}

}
