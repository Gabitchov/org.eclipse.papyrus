package org.eclipse.papyrus.infra.gmfdiag.common.figure.node;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;

/**
 * Scalable Image figure that will be aligned in the middle/center and keep its own ratio. 
 * 
 *  It is also used to serve as specific implementation in Papyrus, as debug items can be easily added.
 */
public class BorderedScalableImageFigure extends ScalableImageFigure {

		public BorderedScalableImageFigure(RenderedImage renderedImage, boolean useDefaultImageSize, boolean useOriginalColors, boolean antiAlias) {
			super(renderedImage, useDefaultImageSize, useOriginalColors, antiAlias);
			//setBorder(new LineBorder(ColorConstants.red, 2));
			setAlignment(PositionConstants.CENTER|PositionConstants.MIDDLE);
			setMaintainAspectRatio(true);
			//setBackgroundColor(ColorConstants.green);
			//setForegroundColor(ColorConstants.red);
		}

	}
