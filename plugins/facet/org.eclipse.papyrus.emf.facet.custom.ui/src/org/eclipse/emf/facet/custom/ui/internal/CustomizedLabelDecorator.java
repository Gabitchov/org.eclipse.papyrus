/*******************************************************************************
 * Copyright (c) 2013 Soft-Maint.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Couvrand (Soft-Maint) - Bug 418418 - [Customization] Overlay icons not implemented
 *    David Couvrand (Soft-Maint) - [Customization] NPE for CustomizableLabelProvider when no image found for image customization
 *    Thomas Cicognani (Soft-Maint) - Bug 424414 - ImageManager doesn't cache images
 *    Thomas Cicognani (Soft-Maint) - Bug 424416 - Plug-in for JFace Utilities
 *******************************************************************************/
package org.eclipse.emf.facet.custom.ui.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.custom.core.internal.exported.CustomizationUtils;
import org.eclipse.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.util.jface.ui.imageprovider.IImageProvider;
import org.eclipse.emf.facet.util.jface.ui.imageprovider.IImageProviderFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecorationContext;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelDecorator;
import org.eclipse.swt.graphics.Image;

public class CustomizedLabelDecorator extends LabelDecorator {

	private final ICustomizationManager customizationMgr;
	private final PropertiesHandler propertiesHandler;
	private final ImageManager imageManager;

	public CustomizedLabelDecorator(final ICustomizationManager customizationMgr) {
		super();
		this.customizationMgr = customizationMgr;
		this.propertiesHandler = new PropertiesHandler(customizationMgr);
		this.imageManager = new ImageManager();
	}

	public Image decorateImage(final Image image, final Object element) {
		return null;
	}

	public String decorateText(final String text, final Object element) {
		return null;
	}

	public void addListener(final ILabelProviderListener listener) {
		// Nothing to do
	}

	public void dispose() {
		// Nothing to do
	}

	public boolean isLabelProperty(final Object element, final String property) {
		return false;
	}

	public void removeListener(final ILabelProviderListener listener) {
		// Nothing to do
	}

	@Override
	public Image decorateImage(final Image image, final Object element,
			final IDecorationContext context) {
		Image result = null;
		if ((image != null) && (element instanceof EObject)) {
			final IImage bLeftIImage = getPropertyValue(element,
					this.propertiesHandler.getBottomLeftOverlayProperty(),
					null, IImage.class);
			final ImageDescriptor bottomLeftImDesc = this.imageManager
					.getImageDescriptor(bLeftIImage);
			final IImage tLeftIImage = getPropertyValue(element,
					this.propertiesHandler.getTopLeftOverlayProperty(), null,
					IImage.class);
			final ImageDescriptor topLeftImDesc = this.imageManager
					.getImageDescriptor(tLeftIImage);
			final IImage bRightIImage = getPropertyValue(element,
					this.propertiesHandler.getBottomRightOverlayProperty(),
					null, IImage.class);
			final ImageDescriptor bottomRightImDesc = this.imageManager
					.getImageDescriptor(bRightIImage);
			final IImage tRightIImage = getPropertyValue(element,
					this.propertiesHandler.getTopRightOverlayProperty(), null,
					IImage.class);
			final ImageDescriptor topRightImDesc = this.imageManager
					.getImageDescriptor(tRightIImage);
			final ImageDescriptor[] overlaysArray = new ImageDescriptor[] {
					topLeftImDesc, topRightImDesc, bottomLeftImDesc,
					bottomRightImDesc, null };
			final DecorationOverlayIcon overlayIcon = new DecorationOverlayIcon(
					image, overlaysArray);
			final IImageProvider imageProvider = IImageProviderFactory.DEFAULT
					.createIImageProvider(Activator.getDefault());
			result = imageProvider.getImage(overlayIcon);
		}
		return result;
	}

	@Override
	public String decorateText(final String text, final Object element,
			final IDecorationContext context) {
		return null;
	}

	@Override
	public boolean prepareDecoration(final Object element,
			final String originalText, final IDecorationContext context) {
		return false;
	}

	private <T> T getPropertyValue(final Object element,
			final FacetOperation property, final ETypedElement eTypedElement,
			final Class<T> classs) {
		return CustomizationUtils.getPropertyValue(this.customizationMgr,
				element, property, eTypedElement, classs);
	}

}
