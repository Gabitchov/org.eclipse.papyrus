/*****************************************************************************
 * Copyright (c) 2009 CEA LIST & LIFL 
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.sasheditor.internal;

import java.util.logging.Logger;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IPageImageUtils;
import org.eclipse.papyrus.infra.core.sasheditor.internal.preferences.ITabTooltipPreferences;
import org.eclipse.papyrus.infra.core.sasheditor.internal.preferences.TabTooltipPreferences;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


/**
 * A class managing tooltips as Part.
 * 
 * @author dumoulin
 */
public class ImageToolTipManager {

	/** Log object */
	Logger log = Logger.getLogger(getClass().getName());

	protected ITabTooltipPreferences settings = new TabTooltipPreferences();
	
	/** */
	private Control toolTipedControl;

	/**
	 * Size of the image to show.
	 */
	private Rectangle toolTipExpectedSize = new Rectangle(0, 0, 100, 80);

	private int offsetX = 20;

	private int offsetY = 20;

	/**
	 * Position of the tooltip relative to the tooltiped swt.Control.
	 */
	private int toolTipAlignement = SWT.TOP;

	/**
	 * 
	 */
	private Shell tip = null;
	
	/**
	 * Cached value of the image. Use to do dispose when closing.
	 */
	private Image image = null;

	/**
	 * Constructor.
	 */
	public ImageToolTipManager() {
		// TODO Auto-generated constructor stub
	}

	private void resetTimer() {
		if( settings.getTooltipAutoCloseDelay() == -1)
			return;
		
		// do reset timer
	}
	/**
	 * Close the tooltip and dispose it.
	 */
	public void closeToolTip() {
		if(tip != null) {
			tip.dispose();
			tip = null;
		}
		if(image != null) {
			image.dispose();
			image = null;
		}
		toolTipedControl = null;

	}

	/**
	 * Disable the tooltip.
	 * If the tooltip is shown, hide it.
	 * In the disable state, calls to showTooltip() with the same Control will not
	 * show the tooltip again untill another control is proposed.
	 * A call to closeToolTip() is required to show the same Control again.
	 */
	public void disableToolTip() {
		// Close the tooltip.
		if(tip != null) {
			tip.dispose();
			tip = null;
		}
		if(image != null) {
			image.dispose();
			image = null;
		}
		// Keep the control for future checking.
	}

	/**
	 * dispose the tooltip and its resources.
	 * 
	 */
	public void dispose() {
		if(tip != null) {
			tip.dispose();
			tip = null;
		}
		if(image != null) {
			image.dispose();
			image = null;
		}
		toolTipedControl = null;
	}

	/**
	 * Ask to show the tooltip.
	 * First check if preferences allows to show tooltip.
	 * 
	 * @param pagePart The PagePart for which a ToolTip should be opened.
	 * @param flyedControl The control that trigger the tooltip opening
	 * @param mousePos
	 */
	public void showToolTip(PagePart pagePart, Rectangle flyedControlBounds, Point mousePos) {
		
		// If tooltip is already showing for this control, skip.
		if(toolTipedControl ==  pagePart.getControl()) {
			resetTimer();
			return;
		}

		if( ! settings.isTooltipEnable() )
			return;
		
		// Check if we are showing the tooltip for current tab.
		if( ! settings.isTooltipForCurrentTabShown() && pagePart.getParent().getVisiblePagePart() == pagePart ) {
			// close current tooltip if any
			closeToolTip();
			return;
		}
		
		doShowToolTip(pagePart, flyedControlBounds, mousePos);
	}

	/**
	 * Do show th tooltip, unless we can't get an image for the part.
	 * @param pagePart
	 * @param flyedControlBounds
	 * @param mousePos
	 */
	private void doShowToolTip(PagePart pagePart, Rectangle flyedControlBounds, Point mousePos) {
		Image image = getPageImage(pagePart);
		if(image == null)
			return;

		toolTipedControl = pagePart.getControl();
		// Change image scale
		float scaleFactor = settings.getScaledFactor(); //.5f;
		Image scaledImage = scaledImage(pagePart.getControl().getDisplay(), image, scaleFactor);
		image.dispose();

		// Remember the image to be able to dispose it.
		this.image = scaledImage;
		
		Point pos = computeToolTipPosition(flyedControlBounds, mousePos, scaledImage.getBounds());
		openToolTip(pagePart.getControl(), scaledImage, pos);
	}
	
	/**
	 * Compute the tooltip position.
	 * 
	 * @param relatedControlBounds
	 *        Bounds of the item to which the tooltip apply
	 * @param mousePos
	 *        Position of the mouse inside the relatedControlBounds.
	 * @param toolTipSize
	 *        Size of the ToolTip.
	 * 
	 * @return Position of the tooltip
	 */
	private Point computeToolTipPosition(Rectangle relatedControlBounds, Point mousePos, Rectangle toolTipSize) {

		int x, y;
		if(toolTipAlignement == SWT.TOP) {
			// Position.x = mousePoint.x
			// Position.y = itemBounds - (toolTipSize.y + offsetY)
			x = mousePos.x;
			y = relatedControlBounds.y - (toolTipSize.height + offsetY);
		} else if(toolTipAlignement == SWT.BOTTOM) {
			x = mousePos.x;
			y = relatedControlBounds.y + (relatedControlBounds.height + offsetY);
		} else {
			throw new UnsupportedOperationException("Not yet implemented for this alignement.");
		}
		return new Point(x, y);
	}

	/**
	 * Open a tooltip like window containing the image.
	 * 
	 * @param device
	 *        The control from which atPoint is specified.
	 * @param scaledImage
	 * @param atPoint
	 */
	private void openToolTip(Control device, Image scaledImage, Point atPoint) {
		if(tip != null && !tip.isDisposed())
			tip.dispose();
		tip = new Shell(device.getShell(), SWT.ON_TOP | SWT.NO_FOCUS | SWT.TOOL);
		FillLayout layout = new FillLayout();
		layout.marginWidth = 2;
		tip.setLayout(layout);
		Label label = new Label(tip, SWT.NONE);
		label.setImage(scaledImage);
		Point size = tip.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		Point pt = device.toDisplay(atPoint.x + 20, atPoint.y);
		tip.setBounds(pt.x, pt.y, size.x, size.y);
		tip.setVisible(true);
	}

	/**
	 * Create an image corresponding to the control.
	 * 
	 * @param control
	 *        The control for which an image is to be built.
	 * @return
	 */
	private Image createControlImage(Control control) {
		// Create an image of the part.

		Rectangle size;

		size = control.getBounds();
		if(size.width == 0 && size.height == 0) {
			Point pt = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			size = new Rectangle(0, 0, pt.x, pt.y);
		}

		Image image = new Image(control.getDisplay(), size);
		GC gc = new GC(image);

		boolean success = control.print(gc);
		gc.dispose();
		if(!success) {
			image.dispose();
			//			log.warning("Can't create Snapshot for the control of '" + part + "'.");
			return null;
		}

		return image;
	}

	/**
	 * Create an image corresponding to the control.
	 * 
	 * @param control
	 *        The control for which an image is to be built.
	 * @return
	 */
	private Image scaledImage2(Device device, Image image, float factor) {
		Rectangle imageBounds = image.getBounds();
		Rectangle size = computeToolTipSize(image, factor);
		Image scaledImage = new Image(device, size);
		GC gc = new GC(scaledImage);

		gc.drawImage(image, 0, 0, imageBounds.width, imageBounds.height, 0, 0, size.width, size.height);

		return scaledImage;
	}

	/**
	 * Compute the expected size of the tooltip.
	 * For now, simply return the expected size.
	 * 
	 * @param image
	 * @param factor
	 * @return
	 */
	private Rectangle computeToolTipSize(Image image, float factor) {

		//		Rectangle imageBounds = image.getBounds();
		//		Rectangle size;

		return toolTipExpectedSize;
	}

	/**
	 * Create a new image which is the input image scaled.
	 * 
	 * @param image
	 * @param factor
	 * @return
	 */
	private Image scaledImage(Device device, Image image, float factor) {

		Rectangle bounds = image.getBounds();
		//		Float factor = 0.5f;

		Rectangle newBounds = new Rectangle(0, 0, Math.round(bounds.width * factor), Math.round(bounds.height * factor));
		Image scaledImage = new Image(device, newBounds);
		GC gc = new GC(scaledImage);

		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		Transform tr = new Transform(device);
		tr.scale(factor, factor);
		gc.setTransform(tr);
		gc.drawImage(image, 0, 0);
		gc.dispose();
		tr.dispose();
		return scaledImage;
	}

	/**
	 * get the Image for the page.
	 * @param pagePart
	 * @return
	 */
	private Image getPageImage( PagePart pagePart ) {
		
		return IPageImageUtils.getPageImage(pagePart);
	}
	
}
