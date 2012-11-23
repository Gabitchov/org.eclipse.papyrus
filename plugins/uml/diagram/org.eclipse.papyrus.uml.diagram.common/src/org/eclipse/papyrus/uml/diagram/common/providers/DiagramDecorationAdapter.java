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
 *  Ansgar Radermacher (CEA LIST) - ansgar.radermacher@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.providers;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.Decoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.swt.graphics.Image;


// TODO: Auto-generated Javadoc
/**
 * The Class DiagramDecorationAdapter.
 */
public class DiagramDecorationAdapter {

	/** The decorator target. */
	protected IDecoratorTarget decoratorTarget;


	/** The decoration. */
	protected List<IDecoration> decorations;

	protected List<IPapyrusDecoration> pDecorations;

	/** The decoration image. */
	protected Image decorationImage;



	/**
	 * Instantiates a new diagram decoration adapter.
	 * 
	 * @param decoratorTarget
	 *        the decorator target
	 */
	public DiagramDecorationAdapter(IDecoratorTarget decoratorTarget) {
		this.decoratorTarget = decoratorTarget;
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
	public void removeDecorations() {
		if((decoratorTarget == null) || (decorations == null)) {
			return;
		}
		for(IDecoration decoration : decorations) {
			removeDecoration(decoration);
		}

	}

	/**
	 * Sets the decorator target.
	 * 
	 * @param decoratorTarget
	 *        the new decorator target
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
	 * @param message
	 *        the message
	 * @return the tool tip
	 */
	public Label getToolTip(String message) {
		return new Label(message, getDecorationImage());
	}

	/**
	 * Sets the decoration.
	 * 
	 * @param pDecoration
	 *        A set of papyrus decorations
	 * @param percentageFromSource
	 *        the distance in percent from source node (only used for decorations on an edge). 50 indicates in the middle
	 *        between source and target
	 * @param margin
	 *        the margin from right corner (only used for decorations on a node)
	 * @param isVolatile
	 *        the is volatile
	 * @return the set of JFace decorations
	 */
	public List<IDecoration> setDecorations(List<IPapyrusDecoration> pDecorations, int percentageFromSource, int margin, boolean isVolatile) {

		final int distBetweenIconsPercent = 20;
		final int percentageMin = 10;
		final int percentageMax = 90;

		decorations = new BasicEList<IDecoration>();
		if(pDecorations.size() > 1) {
			percentageFromSource -= distBetweenIconsPercent / 2 * (pDecorations.size() - 1);
		}
		if(percentageFromSource < percentageMin) {
			percentageFromSource = percentageMin;
		}
		for(IPapyrusDecoration pDecoration : pDecorations) {
			// TODO: createImage each time leaks!
			Image image = pDecoration.getDecorationImageForGE().createImage();
			IDecoration decoration = setDecoration(decoratorTarget, image, percentageFromSource, margin, isVolatile);
			decorations.add(decoration);
			String message = pDecoration.getMessage();
			Label toolTip = getToolTip(message);
			if(decoration instanceof Decoration) {
				((Decoration)decoration).setToolTip(toolTip);
			}
			percentageFromSource += distBetweenIconsPercent;
			if(percentageFromSource > percentageMax) {
				percentageFromSource = percentageMax;
			}
			margin += image.getBounds().width;
		}
		this.pDecorations = pDecorations;

		return decorations;
	}

	/**
	 * Removes the decoration.
	 * 
	 * @param decoratorTarget
	 *        the decorator target
	 * @param Decoration
	 *        the decoration
	 */
	public void removeDecoration(IDecoration decoration) {
		if((decoration == null) || (decoratorTarget == null)) {
			return;
		}

		if(decoration instanceof IFigure) {
			IFigure parent = ((IFigure)decoration).getParent();
			if(parent != null) {
				parent.remove((IFigure)decoration);
			}
		}
		// decorations.remove(decoration);
		GraphicalEditPart ownerEditPart = (GraphicalEditPart)decoratorTarget.getAdapter(GraphicalEditPart.class);
		if(ownerEditPart.getViewer() != null) {
			ownerEditPart.getViewer().getVisualPartMap().remove(decoration);
		}
	}

	/**
	 * Gets the decoration.
	 * TODO: has side effect, rename?
	 * 
	 * @param decoratorTarget
	 *        the decorator target
	 * @param image
	 *        the image
	 * @param position
	 *        the position
	 * @param percentageFromSource
	 *        the percentage from source, only evaluated for edge decorations
	 * @param margin
	 *        the margin in pixels from the target position.
	 * @See org.eclipse.gmf.runtime.diagram.ui.services.decorator.addShapeDecoration:
	 *      The margin is the space, in himetric units, between the
	 *      shape's edge and the decoration. A positive margin will place
	 *      the figure outside the shape, a negative margin will place the
	 *      decoration inside the shape.
	 * @param isVolatile
	 *        the is volatile
	 * @return the decoration
	 */
	public IDecoration setDecoration(IDecoratorTarget decoratorTarget, Image image, int percentageFromSource, int margin, boolean isVolatile) {
		final View view = (View)decoratorTarget.getAdapter(View.class);
		org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration decoration = null;
		if(view == null || view.eResource() == null || image == null) {
			return decoration;
		}
		EditPart editPart = (EditPart)decoratorTarget.getAdapter(EditPart.class);
		if(editPart == null || editPart.getViewer() == null) {
			return decoration;
		}
		if(editPart instanceof GraphicalEditPart) {
			GraphicalEditPart gEditPart = (GraphicalEditPart)editPart;
			if(view instanceof Edge) {
				decoration = decoratorTarget.addConnectionDecoration(image, percentageFromSource, isVolatile);
			} else {
				IFigure parentFig = gEditPart.getFigure();
				margin = MapModeUtil.getMapMode(parentFig).DPtoLP(margin);
				Locator locator = new MultiIconTopRightLocator(parentFig, margin);

				// test to create fig from image in order to use addDecorator directly with a locator

				// ImageFigure fig = new ImageFigure(image);
				// fig.setParent(parentFig);
				// fig.setVisible(true);
				// BorderLayout layout = new BorderLayout();
				// layout.setConstraint(fig, BorderLayout.CENTER);
				// Rectangle r = fig.getBounds();

				// Direction NORTH_EAST will be ignored, since we impose "our" locator below
				decoration = decoratorTarget.addShapeDecoration(image, IDecoratorTarget.Direction.NORTH_EAST, margin, isVolatile);
				if(decoration instanceof Decoration) {
					((Decoration)decoration).setLocator(locator);
				}
				// decoration = decoratorTarget.addDecoration(fig, locator, isVolatile);
			}

		}
		return decoration;
	}

	/**
	 * Gets the decoration.
	 * 
	 * @param decoratorTarget
	 *        the decorator target
	 * @param figure
	 *        the figure
	 * @param position
	 *        the position
	 * @param percentageFromSource
	 *        the percentage from source
	 * @param margin
	 *        the margin
	 * @param isVolatile
	 *        the is volatile
	 * @return the decoration
	 */
	public IDecoration setDecoration(IDecoratorTarget decoratorTarget, IFigure figure, int percentageFromSource, int margin, boolean isVolatile) {

		final View view = (View)decoratorTarget.getAdapter(View.class);
		org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration decoration = null;
		if(view == null || view.eResource() == null || figure == null) {
			return decoration;
		}
		EditPart editPart = (EditPart)decoratorTarget.getAdapter(EditPart.class);
		if(editPart == null || editPart.getViewer() == null) {
			return decoration;
		}
		if(editPart instanceof GraphicalEditPart) {
			if(view instanceof Edge) {
				decoration = decoratorTarget.addConnectionDecoration(figure, percentageFromSource, isVolatile);
			} else {
				IFigure parentFig = ((GraphicalEditPart)editPart).getFigure();
				margin = MapModeUtil.getMapMode(parentFig).DPtoLP(margin);

				// Locator locator = new MultiIconTopRightLocator(parentFig, margin);

				// decoration = decoratorTarget.addDecoration(figure, locator, isVolatile);
				decoration = decoratorTarget.addShapeDecoration(figure, IDecoratorTarget.Direction.NORTH_EAST, margin, isVolatile);
			}

		}
		return decoration;
	}

	/**
	 * A locator that places elements to the upper right corner with a "margin" distance to the left.
	 * 
	 * @See org.eclipse.gmf.runtime.gef.ui.internal.figures.RelativetoBorderLocator
	 * @author ansgar
	 * 
	 */
	public class MultiIconTopRightLocator implements Locator {

		public MultiIconTopRightLocator(IFigure parentFig, int rightMargin) {
			this.reference = parentFig;
			if(rightMargin < 0) {
				// avoid negative right margin. This could imply that the decorator enlarges the reference figure
				// which in turn might re-position the decorator to the right and thus causing an enlargement in
				// an endless loop
				rightMargin = 0;
			}
			this.rightMargin = rightMargin;
		}

		public void relocate(IFigure target) {
			Rectangle bounds = reference instanceof HandleBounds ? new PrecisionRectangle(((HandleBounds)reference).getHandleBounds()) : new PrecisionRectangle(reference.getBounds());

			reference.translateToAbsolute(bounds);
			target.translateToRelative(bounds);

			Point pTR = bounds.getTopRight();
			Point pTL = bounds.getTopLeft();
			Point pDecoration = new Point(pTR);

			int decorationX = pTR.x - target.getSize().width - rightMargin;
			if(decorationX > pTL.x) {
				// only set position, if it is inside the figure, i.e. bigger than left margin
				pDecoration.setX(decorationX);
			} else {
				pDecoration.setX(pTL.x);
			}
			target.setLocation(pDecoration);
		}

		protected IFigure reference;

		protected int rightMargin;
	};


	/**
	 * Gets the direction.
	 * 
	 * @param position
	 *        the position
	 * @return the direction
	 */
	@Deprecated
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


}
