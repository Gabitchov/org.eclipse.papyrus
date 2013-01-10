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
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.tooling.runtime.draw2d.CenterLayout;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.Constants;

public class FullLifelineFigure extends LifelineFigure {

	private RectangleFigure stateDefinitionContainerFigure;

	// Chronogram contains statedefinition and timeline
	private RectangleFigure chronogramContainerFigure;

	@Override
	protected void createContents() {
		this.nameLabelContainerFigure = new InvisibleRectangleFigure() {

			@SuppressWarnings("unused")
			String DEBUG_ID = "FullLifelineFigure_nameLabelContainerFigure"; //$NON-NLS-1$
		};
		add(this.nameLabelContainerFigure);

		this.nameLabel = new LifelineVerticalLabel();
		this.nameLabelContainerFigure.add(this.nameLabel);
		this.nameLabelContainerFigure.setLayoutManager(new CenterLayout());

		this.lifelineDataContainerFigure = new InvisibleRectangleFigure() {

			@SuppressWarnings("unused")
			String DEBUG_ID = "FullLifelineFigure_lifelineDataContainerFigure"; //$NON-NLS-1$
		};
		this.lifelineDataContainerFigure.setLayoutManager(new AbstractLayout() {

			public void layout(final IFigure container) {
				final Rectangle clientArea = container.getClientArea();
				final List<?> children = container.getChildren();
				for(int i = 0; i < children.size(); i++) {
					final IFigure child = (IFigure)children.get(i);
					if(child == getChronogramContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y, clientArea.width, clientArea.height - Constants.TIME_RULER_HEIGHT));
					} else if(child == getTimeRulerContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y + clientArea.height - Constants.TIME_RULER_HEIGHT, clientArea.width, Constants.TIME_RULER_HEIGHT));
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
		this.chronogramContainerFigure = new InvisibleRectangleFigure() {

			@SuppressWarnings("unused")
			String DEBUG_ID = "FullLifelineFigure_chronogramContainerFigure"; //$NON-NLS-1$
		};
		this.lifelineDataContainerFigure.add(this.chronogramContainerFigure);
		this.chronogramContainerFigure.setLayoutManager(new AbstractLayout() {

			public void layout(final IFigure container) {
				final Rectangle clientArea = container.getClientArea();
				final List<?> children = container.getChildren();
				for(int i = 0; i < children.size(); i++) {
					final IFigure child = (IFigure)children.get(i);
					if(child == getStateDefinitionContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y, Constants.STATE_DEFINITIONS_WIDTH, clientArea.height));
					} else if(child == getTimelineContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x + Constants.STATE_DEFINITIONS_WIDTH, clientArea.y, clientArea.width - Constants.STATE_DEFINITIONS_WIDTH, clientArea.height));
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});
		createChronogramContainerContents();

		this.timeRulerContainerFigure = new TimeRulerFigure() {

			@SuppressWarnings("unused")
			String DEBUG_ID = "FullLifelineFigure_timeRulerContainerFigure"; //$NON-NLS-1$
		};
		this.lifelineDataContainerFigure.add(this.timeRulerContainerFigure);
	}

	private void createChronogramContainerContents() {

		this.stateDefinitionContainerFigure = new InvisibleRectangleFigure() {

			@SuppressWarnings("unused")
			String DEBUG_ID = "FullLifelineFigure_stateDefinitionContainerFigure"; //$NON-NLS-1$
		};
		this.chronogramContainerFigure.add(this.stateDefinitionContainerFigure);

		this.timelineContainerFigure = new InvisibleRectangleFigure() {

			@SuppressWarnings("unused")
			String DEBUG_ID = "FullLifelineFigure_timelineContainerFigure"; //$NON-NLS-1$
		};
		this.chronogramContainerFigure.add(this.timelineContainerFigure);
	}

	public RectangleFigure getStateDefinitionContainerFigure() {
		return this.stateDefinitionContainerFigure;
	}

	public RectangleFigure getChronogramContainerFigure() {
		return this.chronogramContainerFigure;
	}
}
