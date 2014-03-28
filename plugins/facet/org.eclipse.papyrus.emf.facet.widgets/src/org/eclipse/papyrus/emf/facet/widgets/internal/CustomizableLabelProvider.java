/*******************************************************************************
 * Copyright (c) 2010, 2014 Mia-Software, CEA, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 339653 - org.eclipse.papyrus.emf.facet.widgets API Cleaning
 *    Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *    Christian W. Damus (CEA) - bug 410346
 *  
 *******************************************************************************/

package org.eclipse.papyrus.emf.facet.widgets.internal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedLabelProvider;
import org.eclipse.papyrus.emf.facet.custom.ui.ICustomizedLabelProviderFactory;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.swt.graphics.Image;

@Deprecated
public class CustomizableLabelProvider extends LabelProvider {

	private final ComposedAdapterFactory adapterFactoryWithRegistry;
	private ICustomizationManager customizationEngine;
	private ICustomizedLabelProvider labelProvider;

	public CustomizableLabelProvider(final ICustomizationManager customizationEngine) {
		this();
		this.customizationEngine = customizationEngine;
		this.labelProvider = ICustomizedLabelProviderFactory.DEFAULT.createCustomizedLabelProvider(customizationEngine);
	}

	public CustomizableLabelProvider() {
		this.adapterFactoryWithRegistry = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		this.adapterFactoryWithRegistry.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactoryWithRegistry
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	}

	@Override
	public void dispose() {
		try {
			// Because we created this adapter factory, ourselves, we must dispose it, as it may have created
			// adapters that are redundant with other adapters still attached to the model and nobody else will
			// be using our adapters (they are only recognized by the factory that created them)
			adapterFactoryWithRegistry.dispose();
		} finally {
			super.dispose();
		}
	}
	
	@Override
	public String getText(final Object element) {
		if (element instanceof EReference) {
			EReference eReference = (EReference) element;
			return getText(eReference);
		}
		if (element instanceof EAttribute) {
			EAttribute eAttribute = (EAttribute) element;
			return getText(eAttribute);
		}
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			return getText(eObject);
		}
		return element.toString();
	}

	public String getText(final EObject eObject) {
		if (this.customizationEngine != null) {
			String label = this.labelProvider.getText(eObject);
			if (label != null) {
				return label;
			}
		}

		final IItemLabelProvider itemLabelProvider = (IItemLabelProvider) this.adapterFactoryWithRegistry
				.adapt(eObject, IItemLabelProvider.class);

		if (itemLabelProvider != null) {
			return itemLabelProvider.getText(eObject);
		}
		return null;
	}

	public static String getText(final EReference reference) {
		boolean showMultiplicity = true;
		boolean showOpposite = false;
		// String customizedName = null;

		String multiplicity = ""; //$NON-NLS-1$

		if (showMultiplicity) {
			multiplicity = getMultiplicity(reference);
		}

		String opposite = ""; //$NON-NLS-1$

		if (showOpposite) {
			final EReference oppositeRef = reference.getEOpposite();
			if (oppositeRef != null) {
				String oppositeMultiplicity = ""; //$NON-NLS-1$
				if (showMultiplicity) {
					oppositeMultiplicity = getMultiplicity(oppositeRef);
				}

				opposite = " <-> " + oppositeRef.getName() + oppositeMultiplicity; //$NON-NLS-1$
			}
		}

		final String prefix;
		if (reference.isDerived()) {
			prefix = "/"; //$NON-NLS-1$
		} else {
			prefix = ""; //$NON-NLS-1$
		}
		final String referenceName;
		// if (customizedName != null) {
		// referenceName = customizedName;
		// } else {
		referenceName = reference.getName();
		// }
		return prefix + referenceName + multiplicity + opposite;
	}

	public static String getMultiplicity(final EReference reference) {
		final String multLow;
		if (reference.isRequired()) {
			multLow = "1"; //$NON-NLS-1$
		} else {
			multLow = "0"; //$NON-NLS-1$
		}
		final String multHigh;
		if (reference.isMany()) {
			multHigh = "*"; //$NON-NLS-1$
		} else {
			multHigh = "1"; //$NON-NLS-1$
		}
		return " [" + multLow + ".." + multHigh + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public static String getText(final EAttribute attribute) {
		String multiplicity = ""; //$NON-NLS-1$

		if (true /* showMultiplicity */) {
			final String multLow;
			if (attribute.isRequired()) {
				multLow = "1"; //$NON-NLS-1$
			} else {
				multLow = "0"; //$NON-NLS-1$
			}
			final String multHigh;
			if (attribute.isMany()) {
				multHigh = "*"; //$NON-NLS-1$
			} else {
				multHigh = "1"; //$NON-NLS-1$
			}
			multiplicity = " [" + multLow + ".." + multHigh + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		final String prefix;
		if (attribute.isDerived()) {
			prefix = "/"; //$NON-NLS-1$
		} else {
			prefix = ""; //$NON-NLS-1$
		}

		final String attributeName = attribute.getName();
		return prefix + attributeName + multiplicity;
	}

	@Override
	public Image getImage(final Object element) {
		if (element instanceof EReference) {
			EReference eReference = (EReference) element;
			return getImage(eReference);
		}
		if (element instanceof EAttribute) {
			EAttribute eAttribute = (EAttribute) element;
			return getImage(eAttribute);
		}
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			return getImage(eObject);
		}
		return null;
	}

	public Image getImage(final EObject eObject) {
		if (this.customizationEngine != null) {
			Image image = this.labelProvider.getImage(eObject);
			if (image != null) {
				return image;
			}
		}

		final IItemLabelProvider itemLabelProvider = (IItemLabelProvider) this.adapterFactoryWithRegistry
				.adapt(eObject, IItemLabelProvider.class);

		if (itemLabelProvider != null) {
			final Object image = itemLabelProvider.getImage(eObject);
			return ExtendedImageRegistry.getInstance().getImage(image);
		}
		return null;
	}

	public static Image getImage(final EReference reference) {
		// if (reference instanceof FacetReference || reference instanceof
		// Shortcut) {
		// return ImageProvider.getInstance().getFacetLinkIcon();
		// }

		final EReference opposite = reference.getEOpposite();

		if (reference.isContainment()) {
			if (opposite == null) {
				return ImageProvider.getInstance().getUnidirectionalAggregIcon();
			}
			return ImageProvider.getInstance().getAggregIcon();
		}

		if (opposite != null && opposite.isContainment()) {
			return ImageProvider.getInstance().getInvAggregIcon();
		}

		if (opposite == null) {
			return ImageProvider.getInstance().getUnidirectionalLinkIcon();
		}
		return ImageProvider.getInstance().getLinkIcon();
	}

	public static Image getImage(@SuppressWarnings("unused") final EAttribute eAttribute) {
		return ImageProvider.getInstance().getAttributeIcon();
	}

}
