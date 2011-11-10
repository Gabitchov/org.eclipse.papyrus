/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;


/**
 * 
 * A part of this code comes from {@link ZoomContributionItem}
 * 
 * 
 */
@SuppressWarnings("restriction")
public class ZoomAction extends AbstractParametricAction {//extends Action

	/**
	 * Custom zoom operations
	 */
	public static final String ZOOM_IN = DiagramUIMessages.ZoomAction_ZoomCombo_ZoomIn;

	public static final String ZOOM_OUT = DiagramUIMessages.ZoomAction_ZoomCombo_ZoomOut;

	public static final String ZOOM_100 = DiagramUIMessages.ZoomAction_ZoomCombo_Zoom100;

	public static final String ZOOM_FIT = DiagramUIMessages.ZoomAction_ZoomCombo_ZoomToFit;

	public static final String ZOOM_WIDTH = DiagramUIMessages.ZoomAction_ZoomCombo_ZoomToWidth;

	public static final String ZOOM_HEIGHT = DiagramUIMessages.ZoomAction_ZoomCombo_ZoomToHeight;

	public static final String ZOOM_SELECTION = DiagramUIMessages.ZoomAction_ZoomCombo_ZoomToSelection;

	/**
	 * Zoom parameters
	 */
	public static final String ZOOM_IN_PARAMETER = "parameter_zoom_in"; //$NON-NLS-1$

	public static final String ZOOM_OUT_PARAMETER = "parameter_zoom_out";//$NON-NLS-1$

	public static final String ZOOM_100_PARAMETER = "parameter_zoom_100";//$NON-NLS-1$

	public static final String ZOOM_FIT_PARAMETER = "parameter_zoom_fit";//$NON-NLS-1$

	public static final String ZOOM_WIDTH_PARAMETER = "parameter_zoom_width";//$NON-NLS-1$

	public static final String ZOOM_HEIGHT_PARAMETER = "parameter_zoom_height";//$NON-NLS-1$

	public static final String ZOOM_SELECTION_PARAMETER = "parameter_zoom_selection";//$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 * @param parameter
	 *        parameter for the zoom action
	 *        Parameters can value :
	 *        <ul>
	 *        <li>#ZOOM_IN_PARAMETER</li>
	 *        <li>#ZOOM_OUT_PARAMETER</li>
	 *        <li>#ZOOM_100_PARAMETER</li>
	 *        <li>#ZOOM_FIT_PARAMETER</li>
	 *        <li>#ZOOM_WIDTH_PARAMETER</li>
	 *        <li>#ZOOM_HEIGHT_PARAMETER</li>
	 *        <li>#ZOOM_SELECTION_PARAMETER</li>
	 *        <li>a number as String (with % at end or not)</li>
	 *        </ul>
	 * 
	 * @param selectedElements
	 *        the selected element for the zoom action
	 */
	public ZoomAction(String parameter, List<IGraphicalEditPart> selectedElements) {
		super(parameter, selectedElements);
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return isValid(getParameter());
	}

	/**
	 * <code>false</code> if not
	 * 
	 * @param zoomText
	 *        the new zoom value
	 * @return
	 *         <code>true</code> if the zoomText is a correct value
	 */
	protected boolean isValid(String zoomText) {
		//we test if we are in a diagram
		DiagramEditPart diagramEP = getDiagramEditPart();
		if(diagramEP == null) {
			return false;
		}

		if(zoomText.equals(ZoomAction.ZOOM_IN_PARAMETER)) {
			return true;
		} else if(zoomText.equals(ZOOM_OUT_PARAMETER)) {
			return true;
		} else if(zoomText.equals(ZOOM_100_PARAMETER)) {
			return true;
		} else if(zoomText.equals(ZOOM_FIT_PARAMETER)) {
			return true;
		} else if(zoomText.equals(ZOOM_WIDTH_PARAMETER)) {
			return true;
		} else if(zoomText.equals(ZOOM_HEIGHT_PARAMETER)) {
			return true;
		} else if(zoomText.equals(ZOOM_SELECTION_PARAMETER)) {
			return true;
		} else {
			StringBuffer buffer = new StringBuffer(zoomText);
			while(buffer.indexOf("%") != -1) {//$NON-NLS-1$
				int index = buffer.indexOf("%");//$NON-NLS-1$
				buffer.deleteCharAt(index);
			}
			try {
				Double.parseDouble(buffer.toString());
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	}

	/**
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 * 
	 */
	@Override
	public void doRun(IProgressMonitor progressMonitor) {
		if(isEnabled()) {
			String parameter = getParameter();
			getZoomManager();
			if(parameter.equals(ZOOM_IN_PARAMETER)) {
				getZoomManager().zoomIn();
			} else if(parameter.equals(ZOOM_OUT_PARAMETER)) {
				getZoomManager().zoomOut();
			} else if(parameter.equals(ZOOM_100_PARAMETER)) {
				getZoomManager().setZoom(1);
			} else if(parameter.equals(ZOOM_FIT_PARAMETER)) {
				zoomToFit(true, true, false);
			} else if(parameter.equals(ZOOM_WIDTH_PARAMETER)) {
				zoomToFit(true, false, false);
			} else if(parameter.equals(ZOOM_HEIGHT_PARAMETER)) {
				zoomToFit(false, true, false);
			} else if(parameter.equals(ZOOM_SELECTION_PARAMETER)) {
				zoomToFit(true, true, true);
			} else {
				getZoomManager().setZoomAsText(parameter);//to set a specific value to zoom
			}
		}
	}

	/**
	 * Performs the zoom operation. Always zooms when possible.
	 * 
	 * @param onWidth
	 *        true to perform zoom on the width
	 * @param onHeight
	 *        true to perform zoom on the height
	 * @param selectionOnly
	 *        true to only zoom the selected items, false to zoom the entire
	 *        diagram
	 */
	protected void zoomToFit(boolean onWidth, boolean onHeight, boolean selectionOnly) {
		zoomToFit(onWidth, onHeight, selectionOnly, false);
	}

	/**
	 * Performs the zoom operation.
	 * 
	 * @param onWidth
	 *        true to perform zoom on the width
	 * @param onHeight
	 *        true to perform zoom on the height
	 * @param selectionOnly
	 *        true to only zoom the selected items, false to zoom the entire
	 *        diagram
	 * @param zoomOutOnly
	 *        true to only zoom out and avoid zooming to greater than 100%,
	 *        false to always zoom even if it could make the shapes on the
	 *        diagram very large
	 */
	@SuppressWarnings("unchecked")
	protected void zoomToFit(boolean onWidth, boolean onHeight, boolean selectionOnly, boolean zoomOutOnly) {

		Iterator<?> editParts;
		if(selectionOnly) {
			editParts = getSelection().iterator();
		} else {
			List<?> allEditParts = getDiagramEditPart().getConnections();
			allEditParts.addAll(getDiagramEditPart().getChildrenAffectingZoom());
			editParts = allEditParts.iterator();
		}

		Rectangle targetRegion = null;
		while(editParts.hasNext()) {
			IFigure f = ((GraphicalEditPart)editParts.next()).getFigure();
			targetRegion = targetRegion == null ? f.getBounds().getCopy() : targetRegion.getUnion(f.getBounds());
		}

		// IF nothing to Zoom...
		if(targetRegion == null) {
			// do nothing
			return;
		}

		// Translate the region into pixels
		MapModeUtil.getMapMode(getDiagramEditPart().getFigure()).LPtoDP(targetRegion);

		Viewport viewport = getZoomManager().getViewport();

		float xratio = viewport.getHorizontalRangeModel().getExtent() / (float)targetRegion.width;
		float yratio = viewport.getVerticalRangeModel().getExtent() / (float)targetRegion.height;

		double zoom = 1.0;
		if(onHeight && onWidth) {
			zoom = (yratio < xratio) ? Math.floor(yratio * 100) : Math.floor(xratio * 100);
		} else if(onWidth) {
			zoom = Math.floor(xratio * 100);
		} else if(onHeight) {
			zoom = Math.floor(yratio * 100);
		}

		if(zoomOutOnly && zoom >= 100) {
			// we should always continue in order to set the viewport
			// location
			zoom = 100;
		}

		// apply thresholds
		Point topLeft = targetRegion.getTopLeft();
		zoom = Math.min((int)(getZoomManager().getMaxZoom() * 100), Math.max((int)(getZoomManager().getMinZoom() * 100), zoom));

		int viewX = Math.round(topLeft.x * (float)zoom / 100.0f);
		int viewY = Math.round(topLeft.y * (float)zoom / 100.0f);

		getZoomManager().setZoom(zoom / 100);
		viewport.setHorizontalLocation(viewX);
		viewport.setVerticalLocation(viewY);

	}

	/**
	 * Returns the current zoom manager
	 * 
	 * @return
	 *         the current zoom manager
	 */
	protected ZoomManager getZoomManager() {
		return (ZoomManager)getDiagramWorkbenchPart().getAdapter(ZoomManager.class);
	}

}
