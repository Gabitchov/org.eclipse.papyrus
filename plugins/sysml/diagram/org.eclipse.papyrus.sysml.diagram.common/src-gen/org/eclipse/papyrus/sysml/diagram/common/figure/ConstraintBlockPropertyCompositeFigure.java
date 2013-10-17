package org.eclipse.papyrus.sysml.diagram.common.figure; 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusRoundedNodeFigure;

public class ConstraintBlockPropertyCompositeFigure extends PapyrusRoundedNodeFigure {

	protected WrappingLabel constraintLabel;
	protected WrappingLabel tagLabel;
	
	private static final String tagConstraintText = String.valueOf("\u00AB") + "constraint" + String.valueOf("\u00BB"); 

	/** main flow page */
	protected FlowPage page;

	public ConstraintBlockPropertyCompositeFigure() {
		this(ConstraintBlockPropertyCompositeEditPart.ROUNDED_REPRESENTATION);
	}
	
	public ConstraintBlockPropertyCompositeFigure(String representationMode) {
		super();

		ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout() {
			
			@Override
			/**
			 * Always strech figure for StructureCompartment
			 * @see org.eclipse.draw2d.LayoutManager#layout(IFigure)
			 */
			public void layout(IFigure parent) {
				if (!parent.isVisible())
					return;
				List<?> children = getChildren(parent);
				int numChildren = children.size();
				Rectangle clientArea = transposer.t(parent.getClientArea());
				int x = clientArea.x;
				int y = clientArea.y;
				int availableHeight = clientArea.height;

				Dimension prefSizes[] = new Dimension[numChildren];
				Dimension minSizes[] = new Dimension[numChildren];
				Dimension maxSizes[] = new Dimension[numChildren];

				// Calculate the width and height hints.  If it's a vertical ToolBarLayout,
				// then ignore the height hint (set it to -1); otherwise, ignore the 
				// width hint.  These hints will be passed to the children of the parent
				// figure when getting their preferred size. 
				int wHint = -1;
				int hHint = -1;
				if (isHorizontal()) {
					hHint = parent.getClientArea(Rectangle.SINGLETON).height;
				} else {
					wHint = parent.getClientArea(Rectangle.SINGLETON).width;
				}

				/*		
				 * Calculate sum of preferred heights of all children(totalHeight). 
				 * Calculate sum of minimum heights of all children(minHeight).
				 * Cache Preferred Sizes and Minimum Sizes of all children.
				 *
				 * totalHeight is the sum of the preferred heights of all children
				 * totalMinHeight is the sum of the minimum heights of all children
				 * prefMinSumHeight is the sum of the difference between all children's
				 * preferred heights and minimum heights. (This is used as a ratio to 
				 * calculate how much each child will shrink). 
				 */
				IFigure child;
				int totalHeight = 0;
				int totalMinHeight = 0;
				double totalMaxHeight = 0;
				int prefMinSumHeight = 0;
				double prefMaxSumHeight = 0;

				for (int i = 0; i < numChildren; i++) {
					child = (IFigure) children.get(i);

					prefSizes[i] = transposer.t(child.getPreferredSize(wHint, hHint));
					minSizes[i] = transposer.t(child.getMinimumSize(wHint, hHint));
					maxSizes[i] = transposer.t(child.getMaximumSize());

					if (getConstraint(child) != null) {
						double ratio = ((Double) getConstraint(child)).doubleValue();
						int prefHeight = (int) (ratio * availableHeight);
						prefHeight = Math.max(prefHeight, minSizes[i].height);
						prefHeight = Math.min(prefHeight, maxSizes[i].height);
						prefSizes[i].height = prefHeight;
					}

					totalHeight += prefSizes[i].height;
					totalMinHeight += minSizes[i].height;
					totalMaxHeight += maxSizes[i].height;
				}
				totalHeight += (numChildren - 1) * getSpacing();
				totalMinHeight += (numChildren - 1) * getSpacing();
				totalMaxHeight += (numChildren - 1) * getSpacing();
				prefMinSumHeight = totalHeight - totalMinHeight;
				prefMaxSumHeight = totalMaxHeight - totalHeight;

				/* 
				 * The total amount that the children must be shrunk is the 
				 * sum of the preferred Heights of the children minus  
				 * Max(the available area and the sum of the minimum heights of the children).
				 *
				 * amntShrinkHeight is the combined amount that the children must shrink
				 * amntShrinkCurrentHeight is the amount each child will shrink respectively  
				 */
				int amntShrinkHeight =
					totalHeight - Math.max(availableHeight, totalMinHeight);

				for (int i = 0; i < numChildren; i++) {
					int amntShrinkCurrentHeight = 0;
					int prefHeight = prefSizes[i].height;
					int minHeight = minSizes[i].height;
					int maxHeight = maxSizes[i].height;
					int prefWidth = prefSizes[i].width;
					int minWidth = minSizes[i].width;
					int maxWidth = maxSizes[i].width;
					Rectangle newBounds = new Rectangle(x, y, prefWidth, prefHeight);

					child = (IFigure) children.get(i);
					if (getStretchMajorAxis() || child instanceof ShapeCompartmentFigure) {
						if (amntShrinkHeight > 0 && prefMinSumHeight != 0)
		                    amntShrinkCurrentHeight = (int) ((long) (prefHeight - minHeight)
		                        * amntShrinkHeight / (prefMinSumHeight));
						else if (amntShrinkHeight < 0 && totalHeight != 0)
							amntShrinkCurrentHeight =
								(int) (((maxHeight - prefHeight) / prefMaxSumHeight)
									* amntShrinkHeight);
					}

					int width = Math.min(prefWidth, maxWidth);
					if (isStretchMinorAxis())
						width = maxWidth;
					width = Math.max(minWidth, Math.min(clientArea.width, width));
					newBounds.width = width;

					int adjust = clientArea.width - width;
					switch (getMinorAlignment()) {
						case ALIGN_TOPLEFT :
							adjust = 0;
							break;
						case ALIGN_CENTER :
							adjust /= 2;
							break;
						case ALIGN_BOTTOMRIGHT :
							break;
					}
					newBounds.x += adjust;
					if (newBounds.height - amntShrinkCurrentHeight > maxHeight)
						amntShrinkCurrentHeight = newBounds.height - maxHeight;
					newBounds.height -= amntShrinkCurrentHeight;
					child.setBounds(transposer.t(newBounds));

					amntShrinkHeight -= amntShrinkCurrentHeight;
					prefMinSumHeight -= (prefHeight - minHeight);
					prefMaxSumHeight -= (maxHeight - prefHeight);
					totalHeight -= prefHeight;
					y += newBounds.height + getSpacing();
				}
			}

			/**
			 * Gets the list of children after applying the layout options of
			 * ignore invisible children & reverse children
			 */
			private List<?> getChildren(IFigure container) {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				List<?> children = new ArrayList(container.getChildren());
				if (getIgnoreInvisibleChildren()) {
					Iterator<?> iter = children.iterator();
					while (iter.hasNext()) {
						IFigure f = (IFigure) iter.next();
						if (!f.isVisible())
							iter.remove();
					}
				}
				if (isReversed())
					Collections.reverse(children);
				return children;
			}

		};
		
		layout.setStretchMajorAxis(false);
		setLayoutManager(layout);
		
		tagLabel = new WrappingLabel();
		tagLabel.setAlignment(PositionConstants.MIDDLE);
		add(tagLabel);

		if (ConstraintBlockPropertyCompositeEditPart.ROUNDED_REPRESENTATION.equals(representationMode)) {
			corner = 50;
		}
		else {
			corner = 0;
			tagLabel.setText(tagConstraintText);
		}
		
		add(nameLabel);

		constraintLabel = new WrappingLabel();
		constraintLabel.setAlignment(PositionConstants.RIGHT);
		add(constraintLabel);
	}
	
	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure#getNameLabel()
	 * 
	 * @return
	 */
	public WrappingLabel getNameLabel() {
		return nameLabel;
	}
	
	/**
	 * 
	 * @return the textflow of the constraint that contain the string of the
	 *         specification
	 */
	public WrappingLabel getConstraintLabel() {
		return constraintLabel;
	}
	
	public int getCorner() {
		return corner;
	}

	public void setCorner(int newCorner) {
		this.corner = newCorner;
	}

	public WrappingLabel getTagLabel() {
		return tagLabel;
	}

	public void setTagLabel(String newTag) {
		this.tagLabel.setText(newTag);
	}
	
	public static boolean isCompleteRepresentation() {
		return false;
	}

}
