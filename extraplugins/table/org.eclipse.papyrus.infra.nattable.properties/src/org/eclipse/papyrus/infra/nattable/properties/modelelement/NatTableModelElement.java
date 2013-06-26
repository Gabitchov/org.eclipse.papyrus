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
package org.eclipse.papyrus.infra.nattable.properties.modelelement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.properties.observable.AbstractAxisHeaderConfigurationElementObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnDisplayFilterHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnDisplayIndexHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnDisplayLabelHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnIndexHeaderStyleObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowDisplayIndexHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowDisplayLabelHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowIndexHeaderStyleObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;


public class NatTableModelElement extends EMFModelElement {

	/**
	 * this listener used to update the value of the property view
	 */
	private Adapter tableListener;

	/**
	 * the map linking the propertypath and the observable values
	 */
	private Map<String, AbstractAxisHeaderConfigurationElementObservableValue> observableValues;

	/**
	 * the collection of the interesting features to update the property view
	 */
	private Collection<EStructuralFeature> interestingFeatures;

	/**
	 * the row header axis configuration
	 */
	private AbstractHeaderAxisConfiguration rowHeaderAxisConfiguration;

	/**
	 * the column header axis configuration
	 */
	private AbstractHeaderAxisConfiguration columnHeaderAxisConfiguration;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        the table
	 * @param domain
	 *        the editing domain
	 */
	public NatTableModelElement(final Table source, final EditingDomain domain) {
		super(source, domain);
		init();
	}

	/**
	 * Add the listener
	 */
	private void init() {
		this.observableValues = new HashMap<String, AbstractAxisHeaderConfigurationElementObservableValue>();
		this.interestingFeatures = new ArrayList<EStructuralFeature>();
		interestingFeatures.add(NattablePackage.eINSTANCE.getTable_InvertAxis());
		interestingFeatures.add(NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration());
		interestingFeatures.add(NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayFilter());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayIndex());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayLabel());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_IndexStyle());

		this.tableListener = new AdapterImpl() {

			/**
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 * @param msg
			 */
			@Override
			public void notifyChanged(Notification msg) {
				if(interestingFeatures.contains(msg.getFeature())) {
					updateValues();
				}
			}
		};
		columnHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTable(getEditedTable());
		rowHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTable(getEditedTable());
		if(columnHeaderAxisConfiguration != null) {
			columnHeaderAxisConfiguration.eAdapters().add(tableListener);
		}
		if(rowHeaderAxisConfiguration != null) {
			rowHeaderAxisConfiguration.eAdapters().add(tableListener);
		}

		source.eAdapters().add(tableListener);
	}

	/**
	 * update all values in the property view
	 */
	private void updateValues() {
		//we do the update with asyncExec to be sure that the new value will be set before to update it
		Display.getDefault().asyncExec(new Runnable() {

			/**
			 * 
			 * @see java.lang.Runnable#run()
			 * 
			 */
			@Override
			public void run() {
				if(columnHeaderAxisConfiguration != null) {
					columnHeaderAxisConfiguration.eAdapters().remove(tableListener);
				}
				if(rowHeaderAxisConfiguration != null) {
					rowHeaderAxisConfiguration.eAdapters().remove(tableListener);
				}
				columnHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTable(getEditedTable());
				rowHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTable(getEditedTable());
				if(columnHeaderAxisConfiguration != null) {
					columnHeaderAxisConfiguration.eAdapters().add(tableListener);
				}
				if(rowHeaderAxisConfiguration != null) {
					rowHeaderAxisConfiguration.eAdapters().add(tableListener);
				}

				Event event = new Event();
				for(final AbstractAxisHeaderConfigurationElementObservableValue current : observableValues.values()) {
					current.handleEvent(event);
				}
			}
		});
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.AbstractModelElement#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();
		source.eAdapters().remove(tableListener);
		if(columnHeaderAxisConfiguration != null) {
			columnHeaderAxisConfiguration.eAdapters().remove(tableListener);
		}
		if(rowHeaderAxisConfiguration != null) {
			rowHeaderAxisConfiguration.eAdapters().remove(tableListener);
		}
		observableValues.clear();
	}


	/**
	 * 
	 * @return
	 */
	private Table getEditedTable() {
		return (Table)source;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.EMFModelElement#doGetObservable(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	protected IObservable doGetObservable(String propertyPath) {
		AbstractAxisHeaderConfigurationElementObservableValue value = this.observableValues.get(propertyPath);
		if(value == null) {
			Table table = getEditedTable();
			//column properties
			if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_FILTER.equals(propertyPath)) {
				value = new ColumnDisplayFilterHeaderObservableValue(table);
			} else if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_INDEX.equals(propertyPath)) {
				value = new ColumnDisplayIndexHeaderObservableValue(table);
			} else if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new ColumnDisplayLabelHeaderObservableValue(table);
			} else if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_INDEX_STYLE.equals(propertyPath)) {
				value = new ColumnIndexHeaderStyleObservableValue(table);
				//row property
			} else if(Constants.LOCAL_ROW_HEADER_AXIS_CONFIGURATION_DISPLAY_INDEX.equals(propertyPath)) {
				value = new RowDisplayIndexHeaderObservableValue(table);
			} else if(Constants.LOCAL_ROW_HEADER_AXIS_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new RowDisplayLabelHeaderObservableValue(table);
			} else if(Constants.LOCAL_ROW_HEADER_AXIS_CONFIGURATION_INDEX_STYLE.equals(propertyPath)) {
				value = new RowIndexHeaderStyleObservableValue(table);
			}

			if(value != null) {
				this.observableValues.put(propertyPath, (AbstractAxisHeaderConfigurationElementObservableValue)value);
			}
		}
		if(value != null) {
			return value;
		}
		return super.doGetObservable(propertyPath);
	}
}
