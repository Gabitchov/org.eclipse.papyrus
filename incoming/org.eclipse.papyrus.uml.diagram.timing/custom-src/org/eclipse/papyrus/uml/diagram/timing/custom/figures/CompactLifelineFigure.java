/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.tooling.runtime.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;

/**
 * @author vgillet
 * 
 */
public class CompactLifelineFigure extends LifelineFigure {

	/**
	 * Get the rectangle which contains all labels
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure#getDefaultLabelsContainer()
	 * @return lifeline labels rectangle
	 */
	protected IFigure getDefaultLabelsContainer() {
		return getNameLabelContainerFigure();
	}

	@Override
	protected void createContents() {
		this.nameLabelContainerFigure = new InvisibleRectangleFigure() {
			@SuppressWarnings("unused")
			String DEBUG_ID = "CompactLifelineFigure_nameLabelContainerFigure"; //$NON-NLS-1$
		};
		this.add(this.nameLabelContainerFigure);

		this.nameLabel = new LifelineVerticalLabel();
		this.nameLabelContainerFigure.add(this.nameLabel);
		this.nameLabelContainerFigure.setLayoutManager(new CenterLayout());

		this.lifelineDataContainerFigure = new InvisibleRectangleFigure() {
			@SuppressWarnings("unused")
			String DEBUG_ID = "CompactLifelineFigure_lifelineDataContainerFigure"; //$NON-NLS-1$
		};
		this.lifelineDataContainerFigure.setLayoutManager(new AbstractLayout() {
			public void layout(final IFigure container) {
				final Rectangle clientArea = container.getClientArea();
				final List<?> children = container.getChildren();
				for (int i = 0; i < children.size(); i++) {
					final IFigure child = (IFigure) children.get(i);
					if (child == getTimelineContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y, clientArea.width, clientArea.height - Constants.TIME_RULER_HEIGHT));
					} else if (child == getTimeRulerContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y + clientArea.height - Constants.TIME_RULER_HEIGHT, clientArea.width,
								Constants.TIME_RULER_HEIGHT));
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});
		add(this.lifelineDataContainerFigure);

		createDataContainerContents();
	}

	private void createDataContainerContents() {
		this.timelineContainerFigure = new InvisibleRectangleFigure() {
			@SuppressWarnings("unused")
			String DEBUG_ID = "CompactLifelineFigure_compactTimelineContainerFigure"; //$NON-NLS-1$
		};
		this.lifelineDataContainerFigure.add(this.timelineContainerFigure);

		this.timeRulerContainerFigure = new TimeRulerFigure() {
			@SuppressWarnings("unused")
			String DEBUG_ID = "CompactLifelineFigure_timeRulerContainerFigure"; //$NON-NLS-1$
		};
		this.lifelineDataContainerFigure.add(this.timeRulerContainerFigure);
	}
}
