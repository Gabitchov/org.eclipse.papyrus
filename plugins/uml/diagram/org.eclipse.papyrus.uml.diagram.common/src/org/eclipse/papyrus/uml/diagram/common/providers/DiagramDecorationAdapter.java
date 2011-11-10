/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/LIFL) - Amine.Elkouhen@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.swt.graphics.Image;


// TODO: Auto-generated Javadoc
/**
 * The Class DiagramDecorationAdapter.
 */
public class DiagramDecorationAdapter {

	/** The decorator target. */
	protected IDecoratorTarget decoratorTarget;


	/** The decoration. */
	protected IDecoration decoration;


	/** The decoration image. */
	protected Image decorationImage;



	/**
	 * Instantiates a new diagram decoration adapter.
	 *
	 * @param decoratorTarget the decorator target
	 */
	public DiagramDecorationAdapter(IDecoratorTarget decoratorTarget) {
		this.decoratorTarget = decoratorTarget;
	}

	/**
	 * Gets the decoration.
	 *
	 * @return the decoration
	 */
	public IDecoration getDecoration() {
		return this.decoration;
	}

	/**
	 * Gets the decorator target.
	 *
	 * @return the decorator target
	 */
	public IDecoratorTarget getDecoratorTarget() {
		return this.decoratorTarget;
	}

	/**
	 * Removes the decoration.
	 */
	public void removeDecoration() {
		if(getDecoration() == null || getDecoratorTarget() == null) {
			return;
		}
		removeDecoration(getDecoratorTarget(), getDecoration());

	}

	/**
	 * Removes the decoration.
	 *
	 * @param decoration the decoration
	 */
	public void removeDecoration(IDecoration decoration) {
		if(decoration == null || getDecoratorTarget() == null) {
			return;
		}
		removeDecoration(getDecoratorTarget(), decoration);

	}

	/**
	 * Sets the decoration.
	 *
	 * @param image the image
	 * @param position the position
	 * @param percentageFromSource the percentage from source
	 * @param margin the margin
	 * @param isVolatile the is volatile
	 * @return the i decoration
	 */
	public IDecoration setDecoration(Image image, PreferedPosition position, int percentageFromSource, int margin, boolean isVolatile) {
		this.decoration = getDecoration(getDecoratorTarget(), image, position, percentageFromSource, margin, isVolatile);
		this.decorationImage = image;
		return getDecoration();
	}

	/**
	 * Sets the decoration.
	 *
	 * @param figure the figure
	 * @param position the position
	 * @param percentageFromSource the percentage from source
	 * @param margin the margin
	 * @param isVolatile the is volatile
	 * @return the i decoration
	 */
	public IDecoration setDecoration(IFigure figure, PreferedPosition position, int percentageFromSource, int margin, boolean isVolatile) {
		this.decoration = getDecoration(getDecoratorTarget(), figure, position, percentageFromSource, margin, isVolatile);
		return getDecoration();
	}

	/**
	 * Sets the decorator target.
	 *
	 * @param decoratorTarget the new decorator target
	 */
	public void setDecoratorTarget(IDecoratorTarget decoratorTarget) {
		this.decoratorTarget = decoratorTarget;
	}

	/**
	 * Gets the decoration image.
	 *
	 * @return the decoration image
	 */
	public Image getDecorationImage() {
		return decorationImage;
	}

	/**
	 * Gets the tool tip.
	 *
	 * @param message the message
	 * @return the tool tip
	 */
	public Label getToolTip(String message) {
		return new Label(message, getDecorationImage());
	}

	/**
	 * Sets the decoration.
	 *
	 * @param idecoration the idecoration
	 * @param percentageFromSource the percentage from source
	 * @param margin the margin
	 * @param isVolatile the is volatile
	 * @return the i decoration
	 */
	public IDecoration setDecoration(org.eclipse.papyrus.infra.services.decoration.util.IDecoration idecoration, int percentageFromSource, int margin, boolean isVolatile) {

		this.decorationImage = (idecoration.getDecorationImage() != null) ? idecoration.getDecorationImage().createImage() : null;
		this.decoration = getDecoration(getDecoratorTarget(), getDecorationImage(), idecoration.getPosition(), percentageFromSource, margin, isVolatile);

		return getDecoration();
	}

	/**
	 * Removes the decoration.
	 *
	 * @param decoratorTarget the decorator target
	 * @param Decoration the decoration
	 */
	public void removeDecoration(IDecoratorTarget decoratorTarget, org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration Decoration) {
		if(Decoration instanceof IFigure) {
			((IFigure)Decoration).getParent().remove((IFigure)Decoration);
		}
		GraphicalEditPart ownerEditPart = (GraphicalEditPart)decoratorTarget.getAdapter(GraphicalEditPart.class);
		ownerEditPart.getViewer().getVisualPartMap().remove(Decoration);

	}

	/**
	 * Gets the decoration.
	 *
	 * @param decoratorTarget the decorator target
	 * @param image the image
	 * @param position the position
	 * @param percentageFromSource the percentage from source
	 * @param margin the margin
	 * @param isVolatile the is volatile
	 * @return the decoration
	 */
	public org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration getDecoration(IDecoratorTarget decoratorTarget, Image image, PreferedPosition position, int percentageFromSource, int margin, boolean isVolatile) {
		View view = (View)decoratorTarget.getAdapter(View.class);
		org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration decoration = null;
		if(view == null || view.eResource() == null || image == null) {
			return decoration;
		}
		EditPart editPart = (EditPart)decoratorTarget.getAdapter(EditPart.class);
		if(editPart == null || editPart.getViewer() == null) {
			return decoration;
		}
		if(editPart instanceof org.eclipse.gef.GraphicalEditPart) {
			if(view instanceof Edge) {
				decoration = decoratorTarget.addConnectionDecoration(image, percentageFromSource, isVolatile);
			} else {
				if(editPart instanceof org.eclipse.gef.GraphicalEditPart) {
					margin = MapModeUtil.getMapMode(((org.eclipse.gef.GraphicalEditPart)editPart).getFigure()).DPtoLP(margin);
				}
				decoration = decoratorTarget.addShapeDecoration(image, getDirection(position), margin, isVolatile);
			}

		}
		return decoration;
	}

	/**
	 * Gets the direction.
	 *
	 * @param position the position
	 * @return the direction
	 */
	private Direction getDirection(PreferedPosition position) {

		switch(position) {

		case NORTH_WEST:
			return IDecoratorTarget.Direction.NORTH_WEST;
		case NORTH:
			return IDecoratorTarget.Direction.NORTH;
		case NORTH_EAST:
			return IDecoratorTarget.Direction.NORTH_EAST;
		case EAST:
			return IDecoratorTarget.Direction.EAST;
		case SOUTH_EAST:
			return IDecoratorTarget.Direction.SOUTH_EAST;
		case SOUTH:
			return IDecoratorTarget.Direction.SOUTH;
		case SOUTH_WEST:
			return IDecoratorTarget.Direction.SOUTH_WEST;
		case WEST:
			return IDecoratorTarget.Direction.WEST;
		case CENTER:
			return IDecoratorTarget.Direction.CENTER;
		default:
			return IDecoratorTarget.Direction.NORTH_EAST;

		}
	}

	/**
	 * Gets the decoration.
	 *
	 * @param decoratorTarget the decorator target
	 * @param figure the figure
	 * @param position the position
	 * @param percentageFromSource the percentage from source
	 * @param margin the margin
	 * @param isVolatile the is volatile
	 * @return the decoration
	 */
	public org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration getDecoration(IDecoratorTarget decoratorTarget, IFigure figure, PreferedPosition position, int percentageFromSource, int margin, boolean isVolatile) {

		View view = (View)decoratorTarget.getAdapter(View.class);
		org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration decoration = null;
		if(view == null || view.eResource() == null || figure == null) {
			return decoration;
		}
		EditPart editPart = (EditPart)decoratorTarget.getAdapter(EditPart.class);
		if(editPart == null || editPart.getViewer() == null) {
			return decoration;
		}
		if(editPart instanceof org.eclipse.gef.GraphicalEditPart) {
			if(view instanceof Edge) {
				decoration = decoratorTarget.addConnectionDecoration(figure, percentageFromSource, isVolatile);
			} else {
				if(editPart instanceof org.eclipse.gef.GraphicalEditPart) {
					margin = MapModeUtil.getMapMode(((org.eclipse.gef.GraphicalEditPart)editPart).getFigure()).DPtoLP(margin);
				}
				decoration = decoratorTarget.addShapeDecoration(figure, getDirection(position), margin, isVolatile);
			}

		}
		return decoration;
	}

}
