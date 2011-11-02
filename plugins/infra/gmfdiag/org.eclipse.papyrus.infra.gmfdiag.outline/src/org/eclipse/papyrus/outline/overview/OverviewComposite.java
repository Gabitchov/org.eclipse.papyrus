/***********************************************************************
 * Copyright (c) 2007, 2008, 2009 Anyware Technologies, Obeo
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *    Obeo
 *    
 **********************************************************************/
package org.eclipse.papyrus.outline.overview;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * This class is an outline control showing an overview of a graphical editor. <br>
 * 
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma </a>
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class OverviewComposite extends Composite {

	/** the control of the overview */
	private Canvas overview;

	/** the root edit part */
	private ScalableFreeformRootEditPart rootEditPart;

	/** the thumbnail */
	private ScrollableThumbnail thumbnail;

	/**
	 * Creates a new OverviewOutlinePage instance.
	 * 
	 * @param parent
	 *        the parent composite
	 * @param rootEditPart
	 *        the root edit part
	 */
	public OverviewComposite(Composite parent, ScalableFreeformRootEditPart rootEditPart) {
		super(parent, SWT.BORDER);
		this.rootEditPart = rootEditPart;

		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		setLayout(layout);
		setLayoutData(new GridData(GridData.FILL_BOTH));
		createControl(this);
	}

	/**
	 * Creates the inner controls
	 * 
	 * @param parent
	 *        the parent composite
	 */
	public void createControl(Composite parent) {
		// An swt canvas and lws drawing the figure.
		overview = new Canvas(parent, SWT.NONE);
		overview.setLayoutData(new GridData(GridData.FILL_BOTH));
		// A draw2d object linking swt and draw2d
		LightweightSystem lightweightSystem = new LightweightSystem(overview);

		// create the thumbnail
		thumbnail = new ScrollableThumbnail((Viewport)rootEditPart.getFigure());
		thumbnail.setBorder(new MarginBorder(3));
		thumbnail.setSource(rootEditPart.getLayer(LayerConstants.PRINTABLE_LAYERS/* SCALABLE_LAYERS */));
		lightweightSystem.setContents(thumbnail);

	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		if(null != thumbnail) {
			thumbnail.deactivate();
			thumbnail = null;
		}

		super.dispose();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setVisible(boolean state) {
		thumbnail.setVisible(state);
		super.setVisible(state);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return the main control
	 */
	public Control getControl() {
		return overview;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return <code>true</code> if the focus succeed
	 */
	public boolean setFocus() {
		if(getControl() != null) {
			return getControl().setFocus();
		}
		return false;
	}

}
