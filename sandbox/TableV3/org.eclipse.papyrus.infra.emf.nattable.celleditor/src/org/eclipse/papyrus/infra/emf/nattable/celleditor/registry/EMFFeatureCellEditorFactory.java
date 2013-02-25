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
package org.eclipse.papyrus.infra.emf.nattable.celleditor.registry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.Activator;
import org.eclipse.papyrus.infra.emf.nattable.celleditor.messages.Messages;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.common.celleditor.configs.IAxisCellEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.common.celleditor.factory.AbstractCellEditorConfigurationFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

/**
 * 
 * This factory provides the celleditor for EMF features
 * 
 */
public class EMFFeatureCellEditorFactory extends AbstractCellEditorConfigurationFactory {

	/**
	 * the map with the editor configuration stored by order
	 */
	private Map<Integer, IAxisCellEditorConfiguration> configurations;

	/**
	 * The list of the message already displayed, to avoid spam in the console
	 */
	private List<String> messagesAlreadyDisplayed = new ArrayList<String>();

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.factory.AbstractCellEditorConfigurationFactory#initFactory(java.lang.String)
	 * 
	 * @param id
	 */
	@Override
	public void initFactory(String id) {
		super.initFactory(id);
		this.configurations = new TreeMap<Integer, IAxisCellEditorConfiguration>();
		Collection<String> editorId = new ArrayList<String>();

		final Collection<IConfigurationElement> config = getAllRegisteredCellEditorConfiguration();
		for(IConfigurationElement iConfigurationElement : config) {
			final Integer order = new Integer(iConfigurationElement.getAttribute(ORDER_ATTRIBUTE));
			IAxisCellEditorConfiguration cellEditorConfig = null;
			try {
				cellEditorConfig = (IAxisCellEditorConfiguration)iConfigurationElement.createExecutableExtension(CLASS_ATTRIBUTE);
			} catch (CoreException e) {
				Activator.log.error(e);
			}

			final String currentId = cellEditorConfig.getConfigCellId();
			if(currentId != null) {
				if(editorId.contains(currentId)) {
					final String message = NLS.bind(Messages.EMFFeatureCellEditorFactory_SeveralCellEditorAreDeclaredWithTheSameId, currentId);
					if(!messagesAlreadyDisplayed.contains(message)) {
						messagesAlreadyDisplayed.add(message);
						Activator.log.warn(message);
					}
				}
				editorId.add(currentId);
				this.configurations.put(order, cellEditorConfig);
			} else {
				final String message = NLS.bind(Messages.EMFFeatureCellEditorFactory_TheCellEditorProvidesANullCellId, cellEditorConfig.getClass());
				if(!messagesAlreadyDisplayed.contains(message)) {
					messagesAlreadyDisplayed.add(message);
					Activator.log.warn(message);
				}
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.factory.AbstractCellEditorConfigurationFactory#getCellEditorConfiguration(java.lang.String)
	 * 
	 * @param id
	 *        the id of the cell editor
	 * @return
	 *         the cell editor corresponding to this id or <code>null</code> if not found
	 */
	public IAxisCellEditorConfiguration getCellEditorConfiguration(final String id) {
		for(final IAxisCellEditorConfiguration config : this.configurations.values()) {
			if(config.getEditorId().equals(id)) {
				return config;
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.factory.AbstractCellEditorConfigurationFactory#handles(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 *        a table
	 * @param obj
	 *        an object
	 * @return
	 *         <code>true</code> if this factory provides a cell editor for this type
	 */
	public boolean handles(final Table table, final Object obj) {
		return obj instanceof EStructuralFeature && getCellEditorConfiguration(table, obj) != null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.common.celleditor.factory.AbstractCellEditorConfigurationFactory#getCellEditorConfiguration(org.eclipse.papyrus.infra.nattable.model.nattable.Table,
	 *      java.lang.Object)
	 * 
	 * @param table
	 *        a table
	 * @param object
	 *        an object
	 * @return
	 *         the cell configuration for the object and the table or <code>null</code> if not found
	 */
	public IAxisCellEditorConfiguration getCellEditorConfiguration(final Table table, final Object object) {
		assert object instanceof EStructuralFeature;
		final EStructuralFeature feature = (EStructuralFeature)object;
		final EClassifier featureType = feature.getEType();
		final boolean isMany = feature.isMany();
		for(final IAxisCellEditorConfiguration config : this.configurations.values()) {
			if(config.isMany() == isMany) {
				final EClassifier managedType = (EClassifier)config.getEditedType();
				if(featureType == managedType) {
					return config;
				} else if(EMFHelper.isSuperType(managedType, featureType)) {
					return config;
				}
			}
		}
		if(featureType instanceof EEnum) {
			return getCellEditorConfiguration(EcorePackage.eINSTANCE.getEEnum(), isMany, table);
		}
		return null;
	}

	/**
	 * 
	 * @param eClass
	 *        an eclass
	 * @param isMany
	 *        <code>true</code> if the multiplicity if >1
	 * @param table
	 *        the table
	 * @return
	 *         the configuration or <code>null</code> if not found
	 */
	public IAxisCellEditorConfiguration getCellEditorConfiguration(final EClass eClass, final boolean isMany, final Table table) {
		for(final IAxisCellEditorConfiguration config : this.configurations.values()) {
			if(config.isMany() == isMany) {
				final EClassifier managedType = (EClassifier)config.getEditedType();
				if(EMFHelper.isSuperType(managedType, eClass)) {
					return config;
				}
			}
		}
		return null;
	}

	
}
