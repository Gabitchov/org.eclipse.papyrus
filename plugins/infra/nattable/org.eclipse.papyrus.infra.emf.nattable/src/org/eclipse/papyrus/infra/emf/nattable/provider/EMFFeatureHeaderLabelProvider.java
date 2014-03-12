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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.papyrus.infra.emf.nattable.registry.EStructuralFeatureImageRegistry;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EStructuralFeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.swt.graphics.Image;

/**
 * Provides the label for the EstructuralFeature
 * 
 * @author Vincent Lorenzo
 * 
 */
public class EMFFeatureHeaderLabelProvider extends EMFEObjectHeaderLabelProvider {

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> if we are looking for the label of an EStructuralFeature
	 */
	@Override
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElementWrapper) {
			final Object object = ((ILabelProviderContextElementWrapper)element).getObject();
			return object instanceof EStructuralFeature || object instanceof EStructuralFeatureAxis;
		}
		return false;
	}

	/**
	 * 
	 * @param featureConf
	 *        the configuration to use to know what display in the label
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
	protected String getText(FeatureLabelProviderConfiguration featureConf, final IConfigRegistry configRegistry, final String name, final Object type, final boolean isDerived, final int lowerBound, final int upperBounds) {
		//we collect the required values
		boolean displayName = false;
		try {
			displayName = featureConf.isDisplayName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean displayMultiplicity = featureConf.isDisplayMultiplicity();
		boolean displayType = featureConf.isDisplayType();
		boolean displayIsDerived = featureConf.isDisplayIsDerived();

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
		final ILabelProviderContextElementWrapper wrapper = (ILabelProviderContextElementWrapper)element;
		final IConfigRegistry configRegistry = wrapper.getConfigRegistry();

		final Object value = wrapper.getObject();
		EStructuralFeature feature = null;
		String alias = "";//$NON-NLS-1$
		if(value instanceof EStructuralFeatureAxis) {
			feature = ((EStructuralFeatureAxis)value).getElement();
			alias = ((EStructuralFeatureAxis)value).getAlias();
		} else if(value instanceof EStructuralFeature) {
			feature = (EStructuralFeature)value;
		}

		String returnedValue = null;
		if(alias != null && !alias.isEmpty()) {
			returnedValue = alias;
		} else {
			returnedValue = feature.getName();
		}
		ILabelProviderConfiguration conf = null;
		if(wrapper instanceof LabelProviderCellContextElementWrapper) {
			conf = getLabelConfiguration((LabelProviderCellContextElementWrapper)wrapper);
		}
		if(conf instanceof ObjectLabelProviderConfiguration && !((ObjectLabelProviderConfiguration)conf).isDisplayLabel()) {
			returnedValue = ""; //$NON-NLS-1$
		} else {
			if(conf instanceof FeatureLabelProviderConfiguration) {
				returnedValue = getText((FeatureLabelProviderConfiguration)conf, configRegistry, returnedValue, feature.getEType(), feature.isDerived(), feature.getLowerBound(), feature.getUpperBound());
			}
		}
		return returnedValue;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.provider.AbstractNattableCellLabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public Image getImage(Object element) {
		ILabelProviderConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElementWrapper) {
			conf = getLabelConfiguration((LabelProviderCellContextElementWrapper)element);
		}
		if(conf instanceof ObjectLabelProviderConfiguration && !((ObjectLabelProviderConfiguration)conf).isDisplayIcon()) {
			return null;
		}

		final Object object = ((ILabelProviderContextElementWrapper)element).getObject();
		EStructuralFeature feature = null;
		if(object instanceof EStructuralFeatureAxis) {
			feature = ((EStructuralFeatureAxis)object).getElement();
		} else if(object instanceof EStructuralFeature) {
			feature = (EStructuralFeature)object;
		}
		if(feature instanceof EAttribute) {
			return EStructuralFeatureImageRegistry.getAttributeIcon();

		} else if(feature instanceof EReference) {
			return getEReferenceImage((EReference)feature);
		}
		if(feature==null){
			return null;
		}
		return super.getImage(feature);
	}


	/**
	 * 
	 * @param reference
	 *        an EReference
	 * @return
	 *         the image for this reference
	 */
	public static Image getEReferenceImage(final EReference reference) {
		final EReference opposite = reference.getEOpposite();

		if(reference.isContainment()) {
			if(opposite == null) {
				return EStructuralFeatureImageRegistry.getUnidirectionalAggregIcon();
			}
			return EStructuralFeatureImageRegistry.getAggregIcon();
		}

		if(opposite != null && opposite.isContainment()) {
			return EStructuralFeatureImageRegistry.getInvAggregIcon();
		}

		if(opposite == null) {
			return EStructuralFeatureImageRegistry.getUnidirectionalLinkIcon();
		}
		return EStructuralFeatureImageRegistry.getLinkIcon();
	}

}
