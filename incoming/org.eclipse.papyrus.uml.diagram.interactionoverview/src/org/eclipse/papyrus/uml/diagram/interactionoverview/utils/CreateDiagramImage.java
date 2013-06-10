/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.utils;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ImageFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramGenerator;
import org.eclipse.gmf.runtime.diagram.ui.render.clipboard.DiagramImageGenerator;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.widgets.editors.MultipleValueSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.FilteredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.ReferenceSelector;
import org.eclipse.papyrus.uml.diagram.communication.edit.parts.LifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.interactionoverview.Activator;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.NamedElement;

public class CreateDiagramImage {

	public static Image getDiagramImage(final Diagram diagram, final PreferencesHint preferencesHint, final ImageFigure imageFigure, final View callBehaviorActionView) {
		Image image = null;

		final DiagramEditPart diagramEditPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, new Shell(), preferencesHint);
		if(diagramEditPart != null) {
			image = getDiagramImage(diagramEditPart, imageFigure, callBehaviorActionView);
			diagramEditPart.deactivate();
		}
		return image;
	}

	public static Image getDiagramImage(final DiagramEditPart diagramEP, final ImageFigure imageFigure, final View callBehaviorActionView) {

		final List<GraphicalEditPart> editParts = diagramEP.getPrimaryEditParts();
		getAllChildren(diagramEP, editParts);
		final List<GraphicalEditPart> lifelines = getAllLifeline(editParts);

		final DiagramGenerator gen = new DiagramImageGenerator(diagramEP);

		if(CallBehaviorUtil.isBehaviorNew(callBehaviorActionView)) {
			CallBehaviorUtil.setBehaviorAsNonNew(callBehaviorActionView);
			final List selectedLifelines = Arrays.asList(selectLifelines(lifelines));
			final List removedLifeline = new ArrayList(lifelines);
			removedLifeline.removeAll(selectedLifelines);
			final List removedLifelineCopyForIterate = new ArrayList(removedLifeline);
			for(final Iterator iterator = removedLifelineCopyForIterate.iterator(); iterator.hasNext();) {
				final Object object = iterator.next();
				getAllChildren((GraphicalEditPart)object, removedLifeline);
			}
			final List<GraphicalEditPart> filteredEditParts = new ArrayList<GraphicalEditPart>(editParts);

			for(final Iterator iterator = editParts.iterator(); iterator.hasNext();) {
				final GraphicalEditPart graphicalEditPart = (GraphicalEditPart)iterator.next();
				if(removedLifeline.contains(graphicalEditPart)) {
					graphicalEditPart.getFigure().setVisible(false);
					final View view = (View)graphicalEditPart.getModel();
					if(view.getElement() != null && view.getElement() instanceof NamedElement) {
						CallBehaviorUtil.addLifelineQualifiedNames(callBehaviorActionView, ((NamedElement)(view.getElement())).getQualifiedName());
					}

				}
			}
		} else {
			final List<String> qualifiedNames = CallBehaviorUtil.getRemovedLifelinesQualifiedNames(callBehaviorActionView);
			for(final Iterator iterator = editParts.iterator(); iterator.hasNext();) {
				final GraphicalEditPart graphicalEditPart = (GraphicalEditPart)iterator.next();
				final View view = (View)graphicalEditPart.getModel();
				if(view.getElement() != null && view.getElement() instanceof Lifeline) {
					final String qualifiedName = ((Lifeline)(view.getElement())).getQualifiedName();
					if(qualifiedNames.contains(qualifiedName)) {
						graphicalEditPart.getFigure().setVisible(false);
					}
				}
			}
		}

		final Rectangle rectangle = gen.calculateImageRectangle(diagramEP.getPrimaryEditParts());
		final ImageDescriptor descriptor = gen.createSWTImageDescriptorForDiagram();

		return resize(descriptor.createImage(), rectangle.width, rectangle.height);

	}

	private static Object[] selectLifelines(final List<GraphicalEditPart> lifelines) {

		final ServicesRegistry servicesRegistry = ((IMultiDiagramEditor)(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor())).getServicesRegistry();

		final ReferenceSelector referenceSelector = new ReferenceSelector(true);

		final IStaticContentProvider semanticProvider = new StaticContentProvider(lifelines.toArray());
		final FilteredContentProvider filteredProvider = new FilteredContentProvider(semanticProvider);
		referenceSelector.setContentProvider(filteredProvider);

		MultipleValueSelectorDialog dialog = null;

		ILabelProvider serv = null;
		try {
			serv = servicesRegistry.getService(LabelProviderService.class).getLabelProvider();
		} catch (final ServiceException e) {
			Activator.log.error("LabelProviderServiceNotFound", e);
		}

		referenceSelector.setLabelProvider(serv);
		dialog = new MultipleValueSelectorDialog(Display.getDefault().getActiveShell(), referenceSelector, Messages.CreateDiagramImage_MultipleValueSelectorDialog, true, false, -1);

		dialog.setLabelProvider(serv);
		dialog.setMessage(Messages.CreateDiagramImage_LifelineDialogMessage);
		dialog.setTitle(Messages.CreateDiagramImage_LifelineDialogTitle);
		dialog.setInitialElementSelections(lifelines);

		if(dialog.open() == org.eclipse.jface.window.Window.OK) {
			final Object[] result = dialog.getResult();
			if(result != null && result.length > 0)
				return result;
		}
		return new Object[0];
	}

	private static List<GraphicalEditPart> getAllLifeline(final List<GraphicalEditPart> editParts) {
		final List<GraphicalEditPart> allChild = new ArrayList<GraphicalEditPart>();
		for(final Iterator iterator = editParts.iterator(); iterator.hasNext();) {
			final GraphicalEditPart editPart = (GraphicalEditPart)iterator.next();
			getAllChildren(editPart, allChild);
		}
		final List<GraphicalEditPart> lifelines = new ArrayList<GraphicalEditPart>();
		for(final Iterator iterator = allChild.iterator(); iterator.hasNext();) {
			final GraphicalEditPart graphicalEditPart = (GraphicalEditPart)iterator.next();
			if(isValidLifelineEditPart(graphicalEditPart)) {
				lifelines.add(graphicalEditPart);
			}
		}
		return lifelines;
	}

	private static boolean isValidLifelineEditPart(final GraphicalEditPart graphicalEditPart) {
		if(graphicalEditPart instanceof LifelineEditPart || graphicalEditPart instanceof LifelineEditPartCN || graphicalEditPart instanceof org.eclipse.papyrus.uml.diagram.timing.edit.parts.LifelineEditPart) {
			return true;
		}
		return false;
	}

	private static List<GraphicalEditPart> getAllChildren(final GraphicalEditPart ep, final List<GraphicalEditPart> result) {

		for(final Object object : ep.getChildren()) {
			final GraphicalEditPart gep = (GraphicalEditPart)object;
			if(!result.contains(gep)) {
				result.add(gep);
			}
			if(!gep.getChildren().isEmpty()) {
				getAllChildren(gep, result);
			}
		}
		return result;
	}

	public static org.eclipse.swt.graphics.Image resize(final org.eclipse.swt.graphics.Image image, final int newWidth, final int newHeight) {

		// convert to buffered image
		BufferedImage img = convertToAWT(image.getImageData());

		final java.awt.Image scaledImage = img.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_AREA_AVERAGING);

		// convert the scaled image back to a buffered image
		img = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
		img.getGraphics().drawImage(scaledImage, 0, 0, null);

		// reconstruct swt image
		final ImageData imageData = convertToSWT(img);
		return new org.eclipse.swt.graphics.Image(Display.getDefault(), imageData);
	}

	public static BufferedImage convertToAWT(final ImageData data) {
		ColorModel colorModel = null;
		final PaletteData palette = data.palette;
		if(palette.isDirect) {
			colorModel = new DirectColorModel(data.depth, palette.redMask, palette.greenMask, palette.blueMask);
			final BufferedImage bufferedImage = new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(data.width, data.height), false, null);
			final WritableRaster raster = bufferedImage.getRaster();
			final int[] pixelArray = new int[3];
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					final int pixel = data.getPixel(x, y);
					final RGB rgb = palette.getRGB(pixel);
					pixelArray[0] = rgb.red;
					pixelArray[1] = rgb.green;
					pixelArray[2] = rgb.blue;
					raster.setPixels(x, y, 1, 1, pixelArray);
				}
			}
			return bufferedImage;
		} else {
			final RGB[] rgbs = palette.getRGBs();
			final byte[] red = new byte[rgbs.length];
			final byte[] green = new byte[rgbs.length];
			final byte[] blue = new byte[rgbs.length];
			for(int i = 0; i < rgbs.length; i++) {
				final RGB rgb = rgbs[i];
				red[i] = (byte)rgb.red;
				green[i] = (byte)rgb.green;
				blue[i] = (byte)rgb.blue;
			}
			if(data.transparentPixel != -1) {
				colorModel = new IndexColorModel(data.depth, rgbs.length, red, green, blue, data.transparentPixel);
			} else {
				colorModel = new IndexColorModel(data.depth, rgbs.length, red, green, blue);
			}
			final BufferedImage bufferedImage = new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(data.width, data.height), false, null);
			final WritableRaster raster = bufferedImage.getRaster();
			final int[] pixelArray = new int[1];
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					final int pixel = data.getPixel(x, y);
					pixelArray[0] = pixel;
					raster.setPixel(x, y, pixelArray);
				}
			}
			return bufferedImage;
		}
	}

	public static ImageData convertToSWT(final BufferedImage bufferedImage) {
		if(bufferedImage.getColorModel() instanceof DirectColorModel) {
			final DirectColorModel colorModel = (DirectColorModel)bufferedImage.getColorModel();
			final PaletteData palette = new PaletteData(colorModel.getRedMask(), colorModel.getGreenMask(), colorModel.getBlueMask());
			final ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
			final WritableRaster raster = bufferedImage.getRaster();
			final int[] pixelArray = new int[3];
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					final int pixel = palette.getPixel(new RGB(pixelArray[0], pixelArray[1], pixelArray[2]));
					data.setPixel(x, y, pixel);
				}
			}
			return data;
		} else if(bufferedImage.getColorModel() instanceof IndexColorModel) {
			final IndexColorModel colorModel = (IndexColorModel)bufferedImage.getColorModel();
			final int size = colorModel.getMapSize();
			final byte[] reds = new byte[size];
			final byte[] greens = new byte[size];
			final byte[] blues = new byte[size];
			colorModel.getReds(reds);
			colorModel.getGreens(greens);
			colorModel.getBlues(blues);
			final RGB[] rgbs = new RGB[size];
			for(int i = 0; i < rgbs.length; i++) {
				rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF, blues[i] & 0xFF);
			}
			final PaletteData palette = new PaletteData(rgbs);
			final ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
			data.transparentPixel = colorModel.getTransparentPixel();
			final WritableRaster raster = bufferedImage.getRaster();
			final int[] pixelArray = new int[1];
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					data.setPixel(x, y, pixelArray[0]);
				}
			}
			return data;
		}
		return null;
	}
}
