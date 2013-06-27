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
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;
import org.eclipse.papyrus.infra.nattable.properties.observable.AbstractConfigurationElementObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnDisplayFilterHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnDisplayIndexHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnDisplayLabelHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnFeatureLabelDisplayIconObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnFeatureLabelDisplayIsDerivedObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnFeatureLabelDisplayLabelObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnFeatureLabelDisplayMultiplicityObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnFeatureLabelDisplayNameObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnFeatureLabelDisplayTypeObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnIndexHeaderStyleObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnObjectLabelDisplayIconObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnObjectLabelDisplayLabelObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowDisplayIndexHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowDisplayLabelHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowIndexHeaderStyleObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public class NatTableModelElement extends EMFModelElement {

	/**
	 * this listener used to update the value of the property view
	 */
	private Adapter tableListener;

	/**
	 * the map linking the propertypath and the observable values
	 */
	private Map<String, AbstractConfigurationElementObservableValue> observableValues;

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
	 * the list of the column label provider configuration
	 */
	private Collection<ILabelProviderConfiguration> columnLabelProviderConfigurations;

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
		this.observableValues = new HashMap<String, AbstractConfigurationElementObservableValue>();
		this.interestingFeatures = new ArrayList<EStructuralFeature>();
		interestingFeatures.add(NattablePackage.eINSTANCE.getTable_InvertAxis());
		interestingFeatures.add(NattablePackage.eINSTANCE.getTable_LocalColumnHeaderAxisConfiguration());
		interestingFeatures.add(NattablePackage.eINSTANCE.getTable_LocalRowHeaderAxisConfiguration());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayFilter());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayIndex());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_DisplayLabel());
		interestingFeatures.add(NattableaxisconfigurationPackage.eINSTANCE.getAbstractHeaderAxisConfiguration_IndexStyle());
		interestingFeatures.add(NattablelabelproviderPackage.eINSTANCE.getFeatureLabelProviderConfiguration_DisplayIsDerived());
		interestingFeatures.add(NattablelabelproviderPackage.eINSTANCE.getFeatureLabelProviderConfiguration_DisplayMultiplicity());
		interestingFeatures.add(NattablelabelproviderPackage.eINSTANCE.getFeatureLabelProviderConfiguration_DisplayName());
		interestingFeatures.add(NattablelabelproviderPackage.eINSTANCE.getFeatureLabelProviderConfiguration_DisplayType());
		interestingFeatures.add(NattablelabelproviderPackage.eINSTANCE.getObjectLabelProviderConfiguration_DisplayIcon());
		interestingFeatures.add(NattablelabelproviderPackage.eINSTANCE.getObjectLabelProviderConfiguration_DisplayLabel());

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
		//we add a listener on the main object managed by the property view
		source.eAdapters().add(tableListener);
		initOtherFieldsAndAddOthersListeners();

	}

	/**
	 * init the fields of the elements to listen (excepted the table itself)+ add listeners on them
	 */
	private void initOtherFieldsAndAddOthersListeners() {

		columnHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getColumnAbstractHeaderAxisInTable(getEditedTable());
		rowHeaderAxisConfiguration = HeaderAxisConfigurationManagementUtils.getRowAbstractHeaderAxisInTable(getEditedTable());

		//COLUMNS MANAGEMENT
		//we add a listener on the columnHeaderAxisConfiguration
		if(columnHeaderAxisConfiguration != null) {
			columnHeaderAxisConfiguration.eAdapters().add(tableListener);
		}

		if(columnHeaderAxisConfiguration != null) {
			columnLabelProviderConfigurations = columnHeaderAxisConfiguration.getOwnedLabelConfigurations();
		}

		if(this.columnLabelProviderConfigurations != null) {
			//we add listener on all column label configurations
			for(final ILabelProviderConfiguration conf : columnLabelProviderConfigurations) {
				conf.eAdapters().add(tableListener);
			}
		}

		//ROW MANAGEMENT
		//we add a listener on the rowHeaderAxisConfiguration
		if(rowHeaderAxisConfiguration != null) {
			rowHeaderAxisConfiguration.eAdapters().add(tableListener);
		}

	}

	/**
	 * remove the listener
	 */
	private void removeListeners() {
		//COLUMNS MANAGEMENT
		//we add a listener on the columnHeaderAxisConfiguration
		if(columnHeaderAxisConfiguration != null) {
			columnHeaderAxisConfiguration.eAdapters().remove(tableListener);
		}



		if(this.columnLabelProviderConfigurations != null) {
			//we add listener on all column label configurations
			for(final ILabelProviderConfiguration conf : columnLabelProviderConfigurations) {
				conf.eAdapters().remove(tableListener);
			}
		}

		//ROW MANAGEMENT
		//we add a listener on the rowHeaderAxisConfiguration
		if(rowHeaderAxisConfiguration != null) {
			rowHeaderAxisConfiguration.eAdapters().remove(tableListener);
		}
	}

	/**
	 * update all values in the property view
	 */
	private void updateValues() {
		//we do the update with asyncExec to be sure that the new values have been set before to update it
		Display.getDefault().asyncExec(new Runnable() {

			/**
			 * 
			 * @see java.lang.Runnable#run()
			 * 
			 */
			@Override
			public void run() {
				removeListeners();
				initOtherFieldsAndAddOthersListeners();

				final Event event = new Event();
				for(final AbstractConfigurationElementObservableValue current : observableValues.values()) {
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
		removeListeners();
		observableValues.clear();
		columnLabelProviderConfigurations = null;
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
	protected IObservable doGetObservable(final String propertyPath) {
		AbstractConfigurationElementObservableValue value = this.observableValues.get(propertyPath);
		if(value == null) {
			Table table = getEditedTable();
			//column header properties
			if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_FILTER.equals(propertyPath)) {
				value = new ColumnDisplayFilterHeaderObservableValue(table);
			} else if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_INDEX.equals(propertyPath)) {
				value = new ColumnDisplayIndexHeaderObservableValue(table);
			} else if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new ColumnDisplayLabelHeaderObservableValue(table);
			} else if(Constants.LOCAL_COLUMN_HEADER_AXIS_CONFIGURATION_INDEX_STYLE.equals(propertyPath)) {
				value = new ColumnIndexHeaderStyleObservableValue(table);


				//row header property
			} else if(Constants.LOCAL_ROW_HEADER_AXIS_CONFIGURATION_DISPLAY_INDEX.equals(propertyPath)) {
				value = new RowDisplayIndexHeaderObservableValue(table);
			} else if(Constants.LOCAL_ROW_HEADER_AXIS_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new RowDisplayLabelHeaderObservableValue(table);
			} else if(Constants.LOCAL_ROW_HEADER_AXIS_CONFIGURATION_INDEX_STYLE.equals(propertyPath)) {
				value = new RowIndexHeaderStyleObservableValue(table);


				//feature column label property
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				value = new ColumnFeatureLabelDisplayIconObservableValue(table);
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new ColumnFeatureLabelDisplayLabelObservableValue(table);
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_IS_DERIVED.equals(propertyPath)) {
				value = new ColumnFeatureLabelDisplayIsDerivedObservableValue(table);
			} else if(Constants.COLUMN__FEATURE_LABEL_CONFIGURATION_DISPLAY_NAME.equals(propertyPath)) {
				value = new ColumnFeatureLabelDisplayNameObservableValue(table);
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_TYPE.equals(propertyPath)) {
				value = new ColumnFeatureLabelDisplayTypeObservableValue(table);
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_MULTIPLICITY.equals(propertyPath)) {
				value = new ColumnFeatureLabelDisplayMultiplicityObservableValue(table);


				//object column label property
			} else if(Constants.COLUMN_OBJECT_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				value = new ColumnObjectLabelDisplayIconObservableValue(table);
			} else if(Constants.COLUMN_OBJECT_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new ColumnObjectLabelDisplayLabelObservableValue(table);
			}

			if(value != null) {
				this.observableValues.put(propertyPath, (AbstractConfigurationElementObservableValue)value);
			}
		}
		if(value != null) {
			return value;
		}
		return super.doGetObservable(propertyPath);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.views.properties.modelelement.EMFModelElement#isEditable(java.lang.String)
	 * 
	 * @param propertyPath
	 * @return
	 */
	@Override
	public boolean isEditable(String propertyPath) {
		boolean res = super.isEditable(propertyPath);
		if(!res) {
			if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				res = true;
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				res = true;
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_IS_DERIVED.equals(propertyPath)) {
				res = true;
			} else if(Constants.COLUMN__FEATURE_LABEL_CONFIGURATION_DISPLAY_NAME.equals(propertyPath)) {
				res = true;
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_TYPE.equals(propertyPath)) {
				res = true;
			} else if(Constants.COLUMN_FEATURE_LABEL_CONFIGURATION_DISPLAY_MULTIPLICITY.equals(propertyPath)) {
				res = true;

				//object column label property
			} else if(Constants.COLUMN_OBJECT_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				res = true;
			} else if(Constants.COLUMN_OBJECT_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				res = true;
			}
		}
		return res;
	}
}
