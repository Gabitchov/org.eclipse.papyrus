/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline.overview;

import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.parts.ScrollableThumbnail;
import org.eclipse.draw2d.parts.Thumbnail;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.part.MultiPageEditorPart;
import org.eclipse.ui.part.Page;

/**
 * An implementation of the IOverviewPage interface applied to a GEF editor.
 * 
 * @author Jacques Lescot
 */
public class GEFOverviewPage extends Page implements IOverviewPage {

	/** the control of the overview */
	private Canvas overview;

	/** the root edit part */
	private ScalableFreeformRootEditPart rootEditPart;

	/** the thumbnail */
	private Thumbnail thumbnail;

	/**
	 * The Constructor
	 * 
	 * @param root
	 */
	public GEFOverviewPage(ScalableFreeformRootEditPart root) {
		rootEditPart = root;
	}

	/**
	 * Creates the control of the overview
	 */
	@Override
	public void createControl(Composite parent) {
		overview = new Canvas(parent, SWT.NONE);
		overview.setLayoutData(new GridData(GridData.FILL_BOTH));
		LightweightSystem lws = new LightweightSystem(overview);

		thumbnail = new ScrollableThumbnail((Viewport) rootEditPart.getFigure());
		thumbnail.setBorder(new MarginBorder(3));
		thumbnail.setSource(rootEditPart
				.getLayer(LayerConstants.SCALABLE_LAYERS));

		lws.setContents(thumbnail);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.Page#dispose()
	 */
	public void dispose() {
		// dispose the Thumbnail
		if (null != thumbnail) {
			thumbnail.deactivate();
			thumbnail = null;
		}
		super.dispose();
	}

	@Override
	public Control getControl() {
		return overview;
	}

	@Override
	public void setFocus() {
		// Do nothing
	}

	/**
	 * Update the contents of the {@link IOverviewPage} page. This may be used
	 * in the case of a {@link MultiPageEditorPart}, while changing of tab. Thus
	 * the root EditPart is changed, and calling this method ensure graphic
	 * contents is updated.
	 * 
	 * @param newRoot
	 *            the new active {@link ScalableFreeformRootEditPart}
	 */
	public void updateContents(ScalableFreeformRootEditPart newRoot) {
		rootEditPart = newRoot;

		LightweightSystem lws = new LightweightSystem(overview);

		if (null != thumbnail) {
			thumbnail.deactivate();
			thumbnail = null;
		}

		thumbnail = new ScrollableThumbnail((Viewport) rootEditPart.getFigure());
		thumbnail.setBorder(new MarginBorder(3));
		thumbnail.setSource(rootEditPart
				.getLayer(LayerConstants.SCALABLE_LAYERS));

		lws.setContents(thumbnail);
	}
}
