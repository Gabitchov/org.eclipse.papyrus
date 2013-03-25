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
package org.eclipse.papyrus.infra.nattable.dataprovider;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.papyrus.infra.nattable.manager.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AbstractAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisIndexStyle;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.DefaultAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.NattableaxisconfigurationPackage;
import org.eclipse.papyrus.infra.tools.util.IntegerAndSpreadsheetNumberConverter;

/**
 * Abstract class for the header data provider
 * 
 * @author Vincent Lorenzo
 * 
 */
public abstract class AbstractHeaderDataProvider extends AbstractDataProvider {

	/** fields used to know what display in the headers */
	protected boolean displayIndex;

	protected boolean displayLabel;

	protected boolean displayFilter;

	protected AxisIndexStyle style;

	/** listener on {@link Table#isInvertAxis()} feature */
	private Adapter invertedListener;

	/**
	 * listener on the axis configuration
	 */
	private Adapter axisListener;

	/**
	 * the listen axis configuration
	 */
	private AbstractAxisConfiguration listenAxisConfiguration;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param tableModelManager
	 */
	public AbstractHeaderDataProvider(INattableModelManager tableModelManager) {
		super(tableModelManager);
		this.listenAxisConfiguration = getAxisConfiguration();
		initListeners();
		this.manager.getTable().eAdapters().add(this.invertedListener);
		initFields();
	}

	/**
	 * Create the listeners, but doesn't assign them to an object
	 */
	protected void initListeners() {
		this.axisListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				final Object feature = msg.getFeature();
				if(feature != null) {
					if(feature.equals(NattableaxisconfigurationPackage.eINSTANCE.getDefaultAxisConfiguration_DisplayFilter())) {
						AbstractHeaderDataProvider.this.displayFilter = msg.getNewBooleanValue();
						updateAxisCount();
					} else if(feature.equals(NattableaxisconfigurationPackage.eINSTANCE.getDefaultAxisConfiguration_DisplayIndex())) {
						AbstractHeaderDataProvider.this.displayIndex = msg.getNewBooleanValue();
						updateAxisCount();
					} else if(feature.equals(NattableaxisconfigurationPackage.eINSTANCE.getDefaultAxisConfiguration_DisplayLabel())) {
						AbstractHeaderDataProvider.this.displayLabel = msg.getNewBooleanValue();
						updateAxisCount();
					} else if(feature.equals(NattableaxisconfigurationPackage.eINSTANCE.getDefaultAxisConfiguration_IndexStyle())) {
						AbstractHeaderDataProvider.this.style = AxisIndexStyle.get(msg.getNewStringValue());
						updateAxisCount();
					}
				}
			}
		};
		this.invertedListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(msg.getFeature() == NattablePackage.eINSTANCE.getTable_InvertAxis()) {
					final Object oldValue = msg.getOldValue();
					final Object newValue = msg.getNewValue();
					if(oldValue != null && newValue != null) {
						initFields();
					}
				}
			}
		};
	}

	/**
	 * init the field value, and update the listen axis if required
	 */
	private void initFields() {
		if(this.listenAxisConfiguration != getAxisConfiguration()) {
			this.listenAxisConfiguration.eAdapters().remove(this.axisListener);
		}
		this.listenAxisConfiguration = getAxisConfiguration();
		this.listenAxisConfiguration.eAdapters().add(this.axisListener);
		if(this.listenAxisConfiguration instanceof DefaultAxisConfiguration) {
			DefaultAxisConfiguration config = (DefaultAxisConfiguration)this.listenAxisConfiguration;
			this.style = config.getIndexStyle();
			this.displayFilter = config.isDisplayFilter();
			this.displayLabel = config.isDisplayLabel();
			this.displayIndex = config.isDisplayIndex();
		}
		updateAxisCount();
	}

	/**
	 * this method is used to update the values in the inherited classes
	 */
	protected abstract void updateAxisCount();

	/**
	 * 
	 * @return
	 *         the axis configuration to listen
	 */
	protected abstract AbstractAxisConfiguration getAxisConfiguration();

	/**
	 * 
	 * @see org.eclipse.ui.services.IDisposable#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		removeListeners();
		this.listenAxisConfiguration = null;
		super.dispose();
	}

	/**
	 * remove the listener
	 */
	protected void removeListeners() {
		this.listenAxisConfiguration.eAdapters().remove(this.axisListener);
		this.manager.getTable().eAdapters().remove(this.invertedListener);
	}

	/**
	 * 
	 * @param axisIndex
	 *        the index of the axis
	 * @return
	 *         the index to display according to the index style
	 */
	protected Object getAxisIndex(int axisIndex) {
		switch(this.style) {
		case ALPHABETIC:
			return IntegerAndSpreadsheetNumberConverter.toString(axisIndex + 1);
		case NUMERIC:
			return axisIndex;
		}
		return null;
	}


}
