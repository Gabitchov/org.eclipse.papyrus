/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.nattable.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.nattable.config.IConfigRegistry;
import org.eclipse.nebula.widgets.nattable.grid.GridRegion;
import org.eclipse.nebula.widgets.nattable.layer.LabelStack;
import org.eclipse.nebula.widgets.nattable.style.DisplayMode;
import org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider;
import org.eclipse.papyrus.infra.emf.nattable.registry.EStructuralFeatureImageRegistry;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.FeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.FeatureLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ObjectLabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.nattable.utils.ILabelProviderContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.LabelConfigurationManagementUtils;
import org.eclipse.papyrus.infra.nattable.utils.LabelProviderCellContextElementWrapper;
import org.eclipse.papyrus.infra.nattable.utils.NattableConfigAttributes;
import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.papyrus.uml.nattable.messages.Messages;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * 
 * @author Vincent Lorenzo
 *         This label provider is called to display the properties of stereotype application in the headers of the table
 */
public class StereotypePropertyHeaderLabelProvider extends EMFFeatureHeaderLabelProvider {

	/** The string displayed in the header when the required profile is not avalaible */
	public static final String REQUIRED_PROFILE_NOT_AVALAIBLE = Messages.StereotypePropertyHeaderLabelProvider_RequiredProfileNotFound;

	/** the icon for the shared aggregation */
	public static final String AGGREG_SHARED = "icons/aggreg_shared.gif"; //$NON-NLS-1$

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#accept(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 *         <code>true</code> when element represents a property of a stereotype
	 */
	@Override
	public boolean accept(Object element) {
		if(element instanceof ILabelProviderContextElementWrapper) {
			final Object value = ((ILabelProviderContextElementWrapper)element).getObject();
			String id = AxisUtils.getPropertyId(value);
			return (id != null && id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX));
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#getText(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public String getText(Object element) {
		final ILabelProviderContextElementWrapper wrapper = (ILabelProviderContextElementWrapper)element;
		final IConfigRegistry configRegistry = wrapper.getConfigRegistry();
		final INattableModelManager modelManager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
		final Table table = modelManager.getTable();
		final EObject tableContext = table.getContext();
		final Object value = wrapper.getObject();
		String alias = ""; //$NON-NLS-1$
		if(value instanceof FeatureAxis) {
			alias = ((FeatureAxis)value).getAlias();
		}

		ILabelProviderConfiguration conf = null;
		if(wrapper instanceof LabelProviderCellContextElementWrapper) {
			LabelStack labels = ((LabelProviderCellContextElementWrapper)wrapper).getConfigLabels();
			if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
				conf = LabelConfigurationManagementUtils.getUsedColumnFeatureLabelConfiguration(table);
			} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
				conf = LabelConfigurationManagementUtils.getUsedRowFeatureLabelConfiguration(table);
			}

		}
		String returnedValue = null;
		if(conf instanceof ObjectLabelProviderConfiguration && !((ObjectLabelProviderConfiguration)conf).isDisplayLabel()) {
			returnedValue = ""; //$NON-NLS-1$
		} else {
			String id = AxisUtils.getPropertyId(value);
			final Property prop = UMLTableUtils.getRealStereotypeProperty(tableContext, id);
			if(alias != null && !alias.isEmpty()) {
				returnedValue = alias;
			} else {
				returnedValue = getLabelProviderService(configRegistry).getLabelProvider(prop).getText(prop);
			}
			if(conf != null && prop != null) {
				if(alias != null && !alias.equals("")) { //$NON-NLS-1$
					returnedValue = alias;
				}
				returnedValue = getText((FeatureLabelProviderConfiguration)conf, configRegistry, returnedValue, prop.getType(), prop.isDerived(), prop.getLower(), prop.getUpper());
			} else if(prop == null) {
				id = id.replace(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX, ""); //$NON-NLS-1$
				returnedValue = id + " " + REQUIRED_PROFILE_NOT_AVALAIBLE; //$NON-NLS-1$
			}
		}
		return returnedValue;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.provider.EMFFeatureHeaderLabelProvider#getImage(java.lang.Object)
	 * 
	 * @param element
	 * @return
	 */
	@Override
	public Image getImage(Object element) {
		final Object value = ((ILabelProviderContextElementWrapper)element).getObject();
		final IConfigRegistry configRegistry = ((ILabelProviderContextElementWrapper)element).getConfigRegistry();
		final INattableModelManager modelManager = (INattableModelManager)getAxisContentProvider(configRegistry);
		ILabelProviderConfiguration conf = null;
		if(element instanceof LabelProviderCellContextElementWrapper) {
			INattableModelManager manager = configRegistry.getConfigAttribute(NattableConfigAttributes.NATTABLE_MODEL_MANAGER_CONFIG_ATTRIBUTE, DisplayMode.NORMAL, NattableConfigAttributes.NATTABLE_MODEL_MANAGER_ID);
			LabelStack labels = ((LabelProviderCellContextElementWrapper)element).getConfigLabels();
			if(labels.hasLabel(GridRegion.COLUMN_HEADER)) {
				conf = LabelConfigurationManagementUtils.getUsedColumnFeatureLabelConfiguration(manager.getTable());
			} else if(labels.hasLabel(GridRegion.ROW_HEADER)) {
				conf = LabelConfigurationManagementUtils.getUsedRowFeatureLabelConfiguration(manager.getTable());
			}
		}
		if(conf instanceof ObjectLabelProviderConfiguration && !((ObjectLabelProviderConfiguration)conf).isDisplayIcon()) {
			return null;
		}

		final EObject tableContext = modelManager.getTable().getContext();
		String id = AxisUtils.getPropertyId(value);
		final Property prop = UMLTableUtils.getRealStereotypeProperty(tableContext, id);
		if(prop != null) {
			final Type type = prop.getType();
			if(type instanceof DataType) {
				return EStructuralFeatureImageRegistry.getAttributeIcon();
			}
			switch(prop.getAggregation().getValue()) {
			case AggregationKind.NONE:
				return EStructuralFeatureImageRegistry.getLinkIcon();
			case AggregationKind.COMPOSITE:
				return EStructuralFeatureImageRegistry.getAggregIcon();
			case AggregationKind.SHARED:
				return Activator.getDefault().getImage(org.eclipse.papyrus.uml.nattable.Activator.PLUGIN_ID, AGGREG_SHARED);
			}
		}
		return null;
	}
}
