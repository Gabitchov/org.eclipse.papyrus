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
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.emf.nattable.registry.EStructuralFeatureImageRegistry;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.EObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElement;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElement;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
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
		if(element instanceof ILabelProviderContextElement) {
			final Object object = ((ILabelProviderContextElement)element).getObject();
			return object instanceof EStructuralFeature;
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
		boolean displayName = featureConf.isDisplayName();
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
		final EStructuralFeature feature = (EStructuralFeature)((ILabelProviderContextElement)element).getObject();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
		ILabelConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElement) {
			INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			LabelStack labels = ((LabelProviderCellContextElement)element).getCell().getConfigLabels();
			if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
				conf = manager.getColumnAxisConfiguration().getLabelConfiguration();
			} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
				conf = manager.getRowAxisConfiguration().getLabelConfiguration();
			}

		}
		if(conf instanceof EObjectLabelProviderConfiguration && !((EObjectLabelProviderConfiguration)conf).isDisplayLabel()) {
			return "";
		}
		if(conf instanceof FeatureLabelProviderConfiguration) {
			return getText((FeatureLabelProviderConfiguration)conf, configRegistry, feature.getName(), feature.getEType(), feature.isDerived(), feature.getLowerBound(), feature.getUpperBound());
		} else {
			return super.getText(element);
		}
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
		ILabelConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElement) {
			final IConfigRegistry configRegistry = ((ILabelProviderContextElement)element).getConfigRegistry();
			INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			LabelStack labels = ((LabelProviderCellContextElement)element).getCell().getConfigLabels();
			if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
				conf = manager.getColumnAxisConfiguration().getLabelConfiguration();
			} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
				conf = manager.getRowAxisConfiguration().getLabelConfiguration();
			}

		}
		if(conf instanceof EObjectLabelProviderConfiguration && !((EObjectLabelProviderConfiguration)conf).isDisplayIcon()) {
			return null;
		}
		final EStructuralFeature feature = (EStructuralFeature)((ILabelProviderContextElement)element).getObject();
		if(feature instanceof EAttribute) {
			return EStructuralFeatureImageRegistry.getAttributeIcon();

		} else if(feature instanceof EReference) {
			return getEReferenceImage((EReference)feature);
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
