package org.eclipse.papyrus.uml.diagram.deployment.custom.figure.nodes;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * this is the layout manager in charge to place element in the enumeration
 * 
 */
class NodeLayoutManager extends AbstractLayout {

	/**
	 * gap in x to display name stereotypes and qualified name
	 */
	protected final int GAP_X = 10;

	protected final int GAP_Y = 5;

	/**
	 * 
	 */
	private final NodeFigure nodeFigure;

	/**
	 * Constructor.
	 *
	 * @param nodeFigure
	 */
	NodeLayoutManager(NodeFigure nodeFigure) {
		this.nodeFigure = nodeFigure;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

		int minimumWith = 0;
		int minimumHeight = 0;
		// display name
		if(nodeFigure.getNameLabel() != null) {
			if(nodeFigure.getNameLabel().getPreferredSize().width > minimumWith) {
				minimumWith = nodeFigure.getNameLabel().getPreferredSize().width;
			}
			minimumHeight += nodeFigure.getNameLabel().getPreferredSize().height;
		}

		return new Dimension(minimumWith, minimumHeight);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void layout(IFigure container) {

		List<?> childrenList = container.getChildren();
		for(int i = 0; i < container.getChildren().size(); i++) {
			Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
			IFigure fig = ((IFigure)childrenList.get(i));
			fig.invalidate();
			Dimension pref = ((IFigure)childrenList.get(i)).getPreferredSize();
			fig.invalidate();
			Dimension prefConstraint = ((IFigure)childrenList.get(i)).getPreferredSize(container.getBounds().width - 40, -1);
			if(pref.width < prefConstraint.width) {
				bound.setSize(pref);
			} else {
				bound.setSize(prefConstraint);
			}
			if(((IFigure)childrenList.get(i)).equals(nodeFigure.iconNode)) {
				Rectangle boundName = nodeFigure.getNameLabel().getBounds().getCopy();
				boundName.x += GAP_X / 2;
				nodeFigure.iconNode.setBounds(new Rectangle(boundName.getTopRight(), new Dimension(16, 16)));
			} else {
				if(i > 0) {
					bound.x = nodeFigure.getBounds().x + GAP_X;
					bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
				} else {
					bound.x = nodeFigure.getBounds().x + GAP_X;
					bound.y = nodeFigure.getBounds().y + GAP_Y + nodeFigure.SPACE_FOR_PERSPECTIVE;
				}
				((IFigure)childrenList.get(i)).setBounds(bound);
			}
		}
		// container
		Rectangle lastRectangle = nodeFigure.getCompositeCompartmentFigure().getBounds();
		lastRectangle.x = container.getBounds().x;
		lastRectangle.height = nodeFigure.getBounds().y + nodeFigure.getBounds().height - lastRectangle.y;
		lastRectangle.width = nodeFigure.getBounds().width - nodeFigure.SPACE_FOR_PERSPECTIVE;

		if(nodeFigure.getGMFCompositeContainer() != null) {

		}

	}

}
