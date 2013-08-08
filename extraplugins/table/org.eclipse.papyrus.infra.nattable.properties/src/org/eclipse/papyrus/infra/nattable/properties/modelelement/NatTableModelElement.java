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
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.ILabelProviderConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablelabelprovider.NattablelabelproviderPackage;
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
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnPasteEObjectContainmentFeatureObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnPasteEObjectElementTypeIdObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnPasteObjectDetachedModeObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.ColumnPasteObjectPostActionsObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowDisplayIndexHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowDisplayLabelHeaderObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowFeatureLabelDisplayIconObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowFeatureLabelDisplayIsDerivedObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowFeatureLabelDisplayLabelObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowFeatureLabelDisplayMultiplicityObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowFeatureLabelDisplayNameObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowFeatureLabelDisplayTypeObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowIndexHeaderStyleObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowObjectLabelDisplayIconObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowObjectLabelDisplayLabelObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowPasteEObjectContainmentFeatureObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowPasteEObjectElementTypeIdObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowPasteObjectDetachedModeObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.observable.RowPasteObjectPostActionsObservableValue;
import org.eclipse.papyrus.infra.nattable.properties.provider.ColumnContainmentFeatureContentProvider;
import org.eclipse.papyrus.infra.nattable.properties.provider.ColumnElementTypeIdContentProvider;
import org.eclipse.papyrus.infra.nattable.properties.provider.RowContainmentFeatureContentProvider;
import org.eclipse.papyrus.infra.nattable.properties.provider.RowElementTypeIdContentProvider;
import org.eclipse.papyrus.infra.nattable.properties.utils.Constants;
import org.eclipse.papyrus.infra.nattable.utils.HeaderAxisConfigurationManagementUtils;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
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
	private Map<String, IObservable> observableValues;

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
	 * the list of the row label provider configuration
	 */
	private Collection<ILabelProviderConfiguration> rowLabelProviderConfigurations;

	/**
	 * a table manager created to get possible axis contents
	 */
	private INattableModelManager tableModelManager;

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
		tableModelManager = new NattableModelManager(getEditedTable());
		this.observableValues = new HashMap<String, IObservable>();
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

		if(rowHeaderAxisConfiguration != null) {
			rowLabelProviderConfigurations = rowHeaderAxisConfiguration.getOwnedLabelConfigurations();
		}

		if(this.rowLabelProviderConfigurations != null) {
			//we add listener on all column label configurations
			for(final ILabelProviderConfiguration conf : rowLabelProviderConfigurations) {
				conf.eAdapters().add(tableListener);
			}
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

		if(this.rowLabelProviderConfigurations != null) {
			//we add listener on all column label configurations
			for(final ILabelProviderConfiguration conf : rowLabelProviderConfigurations) {
				conf.eAdapters().remove(tableListener);
			}
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
				for(final IObservable current : observableValues.values()) {
					if(current instanceof Listener) {
						((Listener)current).handleEvent(event);
					}
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
		rowLabelProviderConfigurations = null;
		tableModelManager.dispose();
		tableModelManager = null;
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
		IObservable value = this.observableValues.get(propertyPath);
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
			} else

			//feature row label property
			if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				value = new RowFeatureLabelDisplayIconObservableValue(table);
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new RowFeatureLabelDisplayLabelObservableValue(table);
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_IS_DERIVED.equals(propertyPath)) {
				value = new RowFeatureLabelDisplayIsDerivedObservableValue(table);
			} else if(Constants.ROW__FEATURE_LABEL_CONFIGURATION_DISPLAY_NAME.equals(propertyPath)) {
				value = new RowFeatureLabelDisplayNameObservableValue(table);
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_TYPE.equals(propertyPath)) {
				value = new RowFeatureLabelDisplayTypeObservableValue(table);
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_MULTIPLICITY.equals(propertyPath)) {
				value = new RowFeatureLabelDisplayMultiplicityObservableValue(table);


				//object row label property
			} else if(Constants.ROW_OBJECT_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				value = new RowObjectLabelDisplayIconObservableValue(table);
			} else if(Constants.ROW_OBJECT_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				value = new RowObjectLabelDisplayLabelObservableValue(table);
			}

			//paste row EObject
			else if(Constants.ROW_PASTED_EOBJECT_CONTAINMENT_FEATURE.equals(propertyPath)) {
				value = new RowPasteEObjectContainmentFeatureObservableValue(table);
			} else if(Constants.ROW_PASTED_EOBJECT_ID.equals(propertyPath)) {
				value = new RowPasteEObjectElementTypeIdObservableValue(table);
			} else if(Constants.ROW_PASTED_OBJECT_DETACHED_MODE_FEATURE.equals(propertyPath)) {
				value = new RowPasteObjectDetachedModeObservableValue(getEditedTable());
			} else if(Constants.ROW_PASTED_OBJECT_POST_ACTIONS_FEATURE.equals(propertyPath)) {
				value = new RowPasteObjectPostActionsObservableValue(getDomain(), getEditedTable());
			}

			//paste column EObject
			else if(Constants.COLUMN_PASTED_EOBJECT_CONTAINMENT_FEATURE.equals(propertyPath)) {
				value = new ColumnPasteEObjectContainmentFeatureObservableValue(table);
			} else if(Constants.COLUMN_PASTED_EOBJECT_ID.equals(propertyPath)) {
				value = new ColumnPasteEObjectElementTypeIdObservableValue(table);
			} else if(Constants.COLUMN_PASTED_OBJECT_DETACHED_MODE_FEATURE.equals(propertyPath)) {
				value = new ColumnPasteObjectDetachedModeObservableValue(getEditedTable());
			} else if(Constants.COLUMN_PASTED_OBJECT_POST_ACTIONS_FEATURE.equals(propertyPath)) {
				value = new ColumnPasteObjectPostActionsObservableValue(getDomain(), getEditedTable());
			}

			if(value != null) {
				this.observableValues.put(propertyPath, (IObservable)value);
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
			//feature column label property
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



			//feature row label property
			else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				res = true;
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				res = true;
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_IS_DERIVED.equals(propertyPath)) {
				res = true;
			} else if(Constants.ROW__FEATURE_LABEL_CONFIGURATION_DISPLAY_NAME.equals(propertyPath)) {
				res = true;
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_TYPE.equals(propertyPath)) {
				res = true;
			} else if(Constants.ROW_FEATURE_LABEL_CONFIGURATION_DISPLAY_MULTIPLICITY.equals(propertyPath)) {
				res = true;

				//object row label property
			} else if(Constants.ROW_OBJECT_LABEL_CONFIGURATION_DISPLAY_ICON.equals(propertyPath)) {
				res = true;
			} else if(Constants.ROW_OBJECT_LABEL_CONFIGURATION_DISPLAY_LABEL.equals(propertyPath)) {
				res = true;
			}

			//paste row EObject
			else if(Constants.ROW_PASTED_EOBJECT_CONTAINMENT_FEATURE.equals(propertyPath)) {
				res = new RowContainmentFeatureContentProvider(getEditedTable()).getElements().length != 0;
			} else if(Constants.ROW_PASTED_EOBJECT_ID.equals(propertyPath)) {
				res = new RowElementTypeIdContentProvider(this.tableModelManager).getElements().length != 0;
			} else if(Constants.ROW_PASTED_OBJECT_DETACHED_MODE_FEATURE.equals(propertyPath)) {
				res = true;
			} else if(Constants.ROW_PASTED_OBJECT_POST_ACTIONS_FEATURE.equals(propertyPath)) {
				res = true;

				//paste column EObject
			} else if(Constants.COLUMN_PASTED_EOBJECT_CONTAINMENT_FEATURE.equals(propertyPath)) {
				res = new ColumnContainmentFeatureContentProvider(getEditedTable()).getElements().length != 0;
			} else if(Constants.COLUMN_PASTED_EOBJECT_ID.equals(propertyPath)) {
				res = new ColumnElementTypeIdContentProvider(this.tableModelManager).getElements().length != 0;
			} else if(Constants.COLUMN_PASTED_OBJECT_DETACHED_MODE_FEATURE.equals(propertyPath)) {
				res = true;
			} else if(Constants.COLUMN_PASTED_OBJECT_POST_ACTIONS_FEATURE.equals(propertyPath)) {
				res = true;
			}
		}

		return res;
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		IStaticContentProvider provider = null;
		if(Constants.ROW_PASTED_EOBJECT_CONTAINMENT_FEATURE.equals(propertyPath)) {
			provider = new RowContainmentFeatureContentProvider(getEditedTable());
		} else if(Constants.COLUMN_PASTED_EOBJECT_CONTAINMENT_FEATURE.equals(propertyPath)) {
			provider = new ColumnContainmentFeatureContentProvider(getEditedTable());
		} else if(Constants.ROW_PASTED_EOBJECT_ID.equals(propertyPath)) {
			provider = new RowElementTypeIdContentProvider(this.tableModelManager);
		} else if(Constants.COLUMN_PASTED_EOBJECT_ID.equals(propertyPath)) {
			provider = new ColumnElementTypeIdContentProvider(this.tableModelManager);
		}
		if(provider != null) {
			return provider;
		}
		return super.getContentProvider(propertyPath);
	}
}
