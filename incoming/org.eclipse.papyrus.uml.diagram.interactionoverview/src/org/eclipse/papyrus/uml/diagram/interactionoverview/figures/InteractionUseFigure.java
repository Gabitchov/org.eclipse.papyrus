package org.eclipse.papyrus.uml.diagram.interactionoverview.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.activity.figures.CallBehaviorActionFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.common.draw2d.InteractionFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.LeftToolbarLayout;


public class InteractionUseFigure extends CallBehaviorActionFigure {


	private WrappingLabel interactionHeader;

	private RectangleFigure interactionLabelContainer;

	private RectangleFigure interactionContentPane;

	private WrappingLabel interactionNameLabel;

	public InteractionUseFigure() {
		createContents();
		this.corner = 0;
	}

	protected void createContents() {
		add(createInteractionFigureHeader());
		add(createContentPane());
		setLayoutManager(new InteractionUseLayoutManager());
	}

	private class InteractionUseLayoutManager extends AbstractLayout {

		public void layout(final IFigure container) {
			final List childrenList = container.getChildren();
			for(int i = 0; i < container.getChildren().size(); i++) {
				final IFigure currentFigure = (IFigure)childrenList.get(i);
				if(currentFigure.equals(interactionLabelContainer) || currentFigure.equals(interactionContentPane)) {
					final Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
					bound.setSize(((IFigure)childrenList.get(i)).getPreferredSize());
					if(i > 0) {
						bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
						// bound.x = getBounds().x + GAP_X;
					} else {
						// bound.x = getBounds().x + GAP_X;
						bound.y = getBounds().y;
					}
					((IFigure)childrenList.get(i)).setBounds(bound);
				}
			}

		}

		@Override
		protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	protected RectangleFigure createContentPane() {

		interactionNameLabel = new WrappingLabel();
		interactionContentPane = new RectangleFigure();
		// Margin allow to add message easily
		interactionContentPane.setBorder(new MarginBorder(5, 5, 5, 5));
		interactionContentPane.setFill(true);
		interactionContentPane.setOutline(false);
		interactionContentPane.setLayoutManager(new CenterLayout());
		interactionContentPane.add(interactionNameLabel);
		return interactionContentPane;
	}

	protected RectangleFigure createInteractionFigureHeader() {
		this.interactionHeader = new WrappingLabel() {

			@Override
			public Dimension getPreferredSize(final int wHint, final int hHint) {
				final Dimension preferredSize = super.getPreferredSize(wHint, hHint);
				if(preferredSize.width == 0) {
					return preferredSize;
				}
				return new Dimension(preferredSize.width + 2, preferredSize.height + 2);
			}
		};
		interactionHeader.setText("Ref");
		final InteractionFigure interactionFigure = new InteractionFigure();
		interactionFigure.setBorder(new MarginBorder(3, 3, 3, 3));
		interactionFigure.setLayoutManager(new LeftToolbarLayout());
		interactionFigure.add(interactionHeader);
		interactionLabelContainer = new RectangleFigure();
		interactionLabelContainer.setOutline(false);
		interactionLabelContainer.setFill(false);
		interactionLabelContainer.setLayoutManager(new ToolbarLayout(false));
		interactionLabelContainer.add(interactionFigure, OrderedLayout.ALIGN_CENTER);
		return interactionLabelContainer;
	}

	@Override
	public WrappingLabel getNameLabel() {
		return interactionNameLabel;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ShapeCompartmentFigure getGMFContentContainer() {
		if(interactionContentPane.getChildren().size() > 0) {
			return (ShapeCompartmentFigure)interactionContentPane.getChildren().get(0);
		}
		return null;
	}

}
