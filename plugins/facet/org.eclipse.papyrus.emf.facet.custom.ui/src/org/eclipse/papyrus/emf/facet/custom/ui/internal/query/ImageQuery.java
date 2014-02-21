/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Nicolas Bros (Mia-Software) - Bug 379683 - customizable Tree content provider
 *      Gregoire Dupe (Mia-Software) - Bug 424122 - [Table] Images, fonts and colors are not shared between the instances of table
 */
package org.eclipse.papyrus.emf.facet.custom.ui.internal.query;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.Activator;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.ImageProvider;
import org.eclipse.papyrus.emf.facet.custom.ui.internal.custompt.ImageWrapper;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.efacet.core.exception.DerivedTypedElementException;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.query.java.core.IJavaQuery2;
import org.eclipse.papyrus.emf.facet.query.java.core.IParameterValueList2;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProvider;
import org.eclipse.papyrus.emf.facet.util.swt.imageprovider.IImageProviderFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.swt.graphics.Image;

public class ImageQuery implements IJavaQuery2<EObject, IImage> {

	public IImage evaluate(final EObject source,
			final IParameterValueList2 parameterValues,
			final IFacetManager facetManager)
			throws DerivedTypedElementException {
		IImage result = null;
		ETypedElement sfParam = null;
		if (parameterValues != null) {
			sfParam = (ETypedElement) parameterValues
					.getParameterValueByName("eStructuralFeature").getValue(); //$NON-NLS-1$
		}
		if (sfParam == null) {
			result = getEObjectImage(source);
		} else {
			result = getLinkImage(sfParam);
		}
		return result;
	}

	protected static IImage getEObjectImage(final EObject source) {
		IImage result = null;
		final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		final IItemLabelProvider itemLabelProvider = (IItemLabelProvider) adapterFactory
				.adapt(source, IItemLabelProvider.class);
		if (itemLabelProvider != null) {
			final ImageDescriptor imgDescriptor = ExtendedImageRegistry
					.getInstance().getImageDescriptor(source);
			final IImageProvider imgProvider = IImageProviderFactory.DEFAULT
					.createIImageProvider(Activator.getDefault());
			if (imgDescriptor != null) {
				final Image image = imgProvider.getImage(imgDescriptor);
				result = new ImageWrapper(image);
			}
		}
		return result;
	}

	/**
	 * Returns the image for an attribute or reference link.
	 *
	 * @param sfParam
	 *            the attribute or reference
	 * @param source
	 *            the EObject under which the attribute or reference appears
	 * @return the image
	 */
	private static IImage getLinkImage(final ETypedElement sfParam) {
		Image image = null;
		if (sfParam instanceof FacetReference) {
			image = ImageProvider.getInstance().getFacetLinkIcon();
		} else if (sfParam instanceof EReference) {
			image = getReferenceImage((EReference) sfParam);
		} else if (sfParam instanceof FacetAttribute) {
			image = ImageProvider.getInstance().getFacetAttributeIcon();
		} else if (sfParam instanceof EAttribute) {
			image = getAttributeImage();
		} else {
			image = ImageProvider.getInstance().getFeatureIcon();
		}
		return new ImageWrapper(image);
	}

	private static Image getReferenceImage(final EReference reference) {
		Image result;
		final EReference opposite = reference.getEOpposite();
		if (reference.isContainment()) {
			if (opposite == null) {
				result = ImageProvider.getInstance().getUnidirectionalAggregIcon();
			} else {
				result = ImageProvider.getInstance().getAggregIcon();
			}
		} else {
			if (opposite != null && opposite.isContainment()) {
				result = ImageProvider.getInstance().getInvAggregIcon();
			} else if (opposite == null) {
				result = ImageProvider.getInstance().getUnidirectionalLinkIcon();
			} else {
				result = ImageProvider.getInstance().getLinkIcon();
			}
		}
		return result;
	}

	private static Image getAttributeImage() {
		return ImageProvider.getInstance().getAttributeIcon();
	}
}
