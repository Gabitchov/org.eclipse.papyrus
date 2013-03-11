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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.nattable.provider;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.layer.cell.ILayerCell;
import org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;

/**
 * Provides the label for the EstructuralFeature
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EMFFeatureHeaderLabelProvider extends AbstractNattableCellLabelProvider {

	private boolean displayName = true;//FIXME : we need to get the axis of this element to know what we should display!

	private boolean displayMultiplicity = true;//FIXME : we need to get the axis of this element to know what we should display!

	private boolean displayType = true;//FIXME : we need to get the axis of this element to know what we should display!

	private boolean displayIsDerived = true;//FIXME : we need to get the axis of this element to know what we should display!

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> if we are looking for the label of an EStructuralFeature
	 */
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElement) {
			final Object object = ((ILabelProviderContextElement)element).getObject();
			return object instanceof EStructuralFeature;
		}
		return false;
	}

	/**
	 * 
	 * @param configRegistry
	 *        the configRegistry
	 * @param name
	 *        the name of the feature
	 * @param type
	 *        the type of the feature
	 * @param isDerived
	 *        <code>true</code> if the feature is derived
	 * @param lowerBound
	 *        the lower bound of the feature
	 * @param upperBounds
	 *        the upper bound of the feature
	 * @return
	 *         the text to display for the feature according to these informations and the preferences of the user
	 */
	protected String getText(final IConfigRegistry configRegistry, final String name, final Object type, final boolean isDerived, final int lowerBound, final int upperBounds) {
		//FIXME : we need to get the axis of this element to know what we should display!
		String displayedText = ""; //$NON-NLS-1$
		if(isDerived && displayIsDerived) {
			displayedText += "/"; //$NON-NLS-1$
		}
		if(displayName) {
			displayedText += name;
		}
		if(displayType) {
			if(displayName) {
				displayedText += " : "; //$NON-NLS-1$
			}
			displayedText += getTypeName(configRegistry, type);
		}
		if(displayMultiplicity) {
			displayedText += " ["; //$NON-NLS-1$
			if(upperBounds == -1 && lowerBound <= 1) {
				displayedText += "*"; //$NON-NLS-1$
			} else if(lowerBound == upperBounds) {
				displayedText += Integer.toString(lowerBound);
			} else {
				displayedText += Integer.toString(lowerBound);
				displayedText += ".."; //$NON-NLS-1$
				if(upperBounds == -1) {
					displayedText += "*"; //$NON-NLS-1$
				} else {
					displayedText += Integer.toString(upperBounds);
				}
			}
			displayedText += "]"; //$NON-NLS-1$
		}

		return displayedText;
	}

	/**
	 * 
	 * @param configRegistry
	 *        the configRegistry
	 * @param type
	 *        the type of the feature
	 * @return
	 *         the name to display for the type
	 */
	protected String getTypeName(final IConfigRegistry configRegistry, final Object type) {
		final LabelProviderService serv = getLabelProviderService(configRegistry);
		if(type instanceof EClassifier) {
			return ((EClassifier)type).getName();
		} else {
			return serv.getLabelProvider(type).getText(type);
		}
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		final EStructuralFeature feature = (EStructuralFeature)((ILabelProviderContextElement)element).getObject();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		String txt = getText(configRegistry, feature.getName(), feature.getEType(), feature.isDerived(), feature.getLowerBound(), feature.getUpperBound());
		if(feature instanceof EReference && ((EReference)feature).isContainment()) {
			txt = "CF " + txt; //$NON-NLS-1$
		}
		return txt;
	}
}
