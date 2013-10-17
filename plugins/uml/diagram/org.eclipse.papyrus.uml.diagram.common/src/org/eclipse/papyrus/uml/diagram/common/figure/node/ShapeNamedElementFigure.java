/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.figure.layout.PropertiesCompartmentLayoutManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public class ShapeNamedElementFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure {

	public class ShapeLayoutManager extends AbstractLayout {

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

			int minimumWith = 50;
			int minimumHeight = 50;

			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			Rectangle imageBound = new Rectangle(container.getBounds());
			Rectangle compartmentBound = new Rectangle(container.getBounds());

			if(stereotypePropertiesContent != null && stereotypePropertiesContent.getChildren().size() > 0) {
				Dimension dim = stereotypePropertiesContent.getPreferredSize();
				imageBound.height = imageBound.height - dim.height;
				compartmentBound.y = compartmentBound.y + compartmentBound.height - dim.height;
				compartmentBound.height = dim.height;
				stereotypePropertiesContent.setBounds(compartmentBound);
			}

			if(stereotypePropertiesBrace != null && stereotypePropertiesBrace.getChildren().size() > 0) {
				Dimension dim = stereotypePropertiesBrace.getPreferredSize();
				imageBound.height = imageBound.height - dim.height;
				compartmentBound.y = compartmentBound.y + compartmentBound.height - dim.height;
				compartmentBound.height = dim.height;
				stereotypePropertiesBrace.setBounds(compartmentBound);
			}
			if(scalableImageFigure != null) {
				scalableImageFigure.setBounds(imageBound);
			} else if(originalimage != null) {

				label.setBounds(imageBound);
				String key = "icon" + this.hashCode();
				ImageData imdata = null;
				imdata = (ImageData)originalimage.getImageData().scaledTo(imageBound.width, imageBound.height).clone();
				Image imm = Activator.getDefault().getImageRegistry().get(key);

				// no image in the registry
				if(imm == null) {
					Activator.getDefault().getImageRegistry().put(key, ImageDescriptor.createFromImageData(imdata));
					imm = Activator.getDefault().getImageRegistry().get(key);
				}
				// there is an image but we would like replace it by our new
				// image
				else {
					// imm.dispose();
					Activator.getDefault().getImageRegistry().remove(key);
					Activator.getDefault().getImageRegistry().put(key, ImageDescriptor.createFromImageData(imdata));
					imm = Activator.getDefault().getImageRegistry().get(key);
				}
				// in the case where the image was not disposed
				if(adaptedImage != null) {
					adaptedImage.dispose();
					adaptedImage = null;
				}
				// set new image
				adaptedImage = imm;
				label.setIcon(adaptedImage);
			}

		}
	}

	protected Label label = null;

	/**
	 * 
	 */

	protected String name = "";

	protected ScalableImageFigure scalableImageFigure = null;

	/**
	 * Added for stereptypes properties
	 */
	private RectangleFigure stereotypePropertiesContent;

	/**
	 * Added for stereptypes properties
	 */
	private RectangleFigure stereotypePropertiesBrace;

	/**
	 * 
	 */
	protected Image originalimage;

	/**
	 * 
	 */
	protected Image adaptedImage;

	/**
	 * 
	 */
	protected int numerNode;

	/**
	 * create an icon figure.
	 * 
	 * @param numberNode
	 *        is used to spcify a unique identfier tha t is associated to
	 *        the image thanks to the graphNode.hashCode()
	 * @param image
	 *        the image (GIF) that we want to see
	 */
	public ShapeNamedElementFigure(Image image) {
		super();

		this.originalimage = image;
		label = new Label("");
		label.setIconAlignment(PositionConstants.CENTER);
		label.setTextAlignment(PositionConstants.CENTER);
		label.setIconTextGap(2);
		this.add(label);
		// the image can be null, if we display a SVG file
		if(image != null) {
			label.setIcon(image);
		}
		this.setLayoutManager(new ShapeLayoutManager());

	}

	public ShapeNamedElementFigure() {
		this(null);
		this.setBorder(null);
	}

	/**
	 * display image from a svg file
	 * 
	 * @param path
	 *        of the svg file
	 * @throws MalformedURLException
	 */
	public void setIcon(String path) throws MalformedURLException {
		this.originalimage = null;
		URL url = new URL(path);//$NON-NLS-1$
		scalableImageFigure = new ScalableImageFigure(RenderedImageFactory.getInstance(url), false, true, true);
		scalableImageFigure.setMaintainAspectRatio(false);
		this.add(scalableImageFigure);
	}

	/**
	 * display icon from an image
	 * 
	 * @param image
	 */
	public void setIcon(Image image) {
		if(scalableImageFigure != null) {
			this.remove(scalableImageFigure);
			scalableImageFigure = null;
		}
		this.originalimage = image;
		label.setIcon(originalimage);
	}

	public void setStereotypeDisplay(String stereotypes, Image image) {
		// do nothing

	}

	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		if(stereotypeProperties == null) {
			// remove figure of stereotype properties compartment
			if(this.stereotypePropertiesBrace != null) {
				this.remove(this.stereotypePropertiesBrace);
				this.stereotypePropertiesBrace = null;
			}
			return;
		}

		// set stereotype properties content
		if(stereotypePropertiesBrace == null) {
			this.createStereotypePropertiesBrace();
		}

		fillStereotypePropertiesInBrace(stereotypeProperties);
	}

	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		if(stereotypeProperties == null) {
			// remove figure of stereotype properties compartment
			if(this.stereotypePropertiesContent != null) {
				this.remove(this.stereotypePropertiesContent);
				this.stereotypePropertiesContent = null;
			}
			return;
		}

		// set stereotype properties content
		if(stereotypePropertiesContent == null) {
			this.createStereotypePropertiesContent();
		}

		fillStereotypePropertiesInCompartment(stereotypeProperties);

	}

	public Label getStereotypesLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	private void fillStereotypePropertiesInCompartment(String stereotypeProperties) {

		stereotypePropertiesContent.getChildren().clear();
		StringTokenizer stringTokenizer = new StringTokenizer(stereotypeProperties, ";");
		while(stringTokenizer.hasMoreElements()) {
			String tokenStereotype = stringTokenizer.nextToken();
			tokenStereotype = tokenStereotype.replace("#", "\n  ");
			tokenStereotype = tokenStereotype.replace("|", "\n  ");
			Label label = new Label(tokenStereotype);
			label.setLabelAlignment(PositionConstants.LEFT);
			label.setBorder(null);
			stereotypePropertiesContent.add(label);
		}

	}

	private void fillStereotypePropertiesInBrace(String stereotypeProperties) {
		stereotypePropertiesBrace.getChildren().clear();
		Label label = new Label("{" + stereotypeProperties + "}");
		label.setLabelAlignment(PositionConstants.CENTER);
		label.setBorder(null);
		stereotypePropertiesBrace.add(label);

	}

	protected int getStereotypePropertiesCompartmentPosition() {

		return 1;
	}

	protected void createStereotypePropertiesContent() {
		stereotypePropertiesContent = new StereotypePropertiesCompartment();
		stereotypePropertiesContent.setFill(false);
		stereotypePropertiesContent.setLineWidth(0);
		stereotypePropertiesContent.setBorder(null);
		stereotypePropertiesContent.setLayoutManager(new PropertiesCompartmentLayoutManager());
		this.add(stereotypePropertiesContent, getStereotypePropertiesCompartmentPosition());
	}

	protected void createStereotypePropertiesBrace() {
		stereotypePropertiesBrace = new StereotypePropertiesCompartment();
		stereotypePropertiesBrace.setFill(false);
		stereotypePropertiesBrace.setLineWidth(0);
		stereotypePropertiesBrace.setBorder(null);
		stereotypePropertiesBrace.setLayoutManager(new PropertiesCompartmentLayoutManager());
		this.add(stereotypePropertiesBrace, getStereotypePropertiesCompartmentPosition());
	}

}
