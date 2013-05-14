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
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.table.widgets;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.nebula.widgets.nattable.NatTable;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.EStructuralFeatureValueFillingConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.IAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.TableHeaderAxisConfiguration;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.NattableaxisproviderFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableconfiguration.TableConfiguration;
import org.eclipse.papyrus.views.properties.contexts.Property;
import org.eclipse.papyrus.views.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
import org.eclipse.papyrus.views.properties.table.Activator;
import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

/**
 * A PropertyEditor to manipulate Papyrus Nattables in the properties view
 * 
 * @author Camille Letavernier
 * 
 */
public class NattablePropertyEditor extends AbstractPropertyEditor {

	private Composite self;

	private URI tableConfigURI = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/resources/property.nattableconfiguration", true);

	public NattablePropertyEditor(Composite parent, int style) {
		self = new Group(parent, SWT.NONE);
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = 10;
		fillLayout.marginWidth = 10;
		self.setLayout(fillLayout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumHeight = 300;
		self.setLayoutData(data);
	}

	public void setURI(String uri) {
		tableConfigURI = URI.createURI(uri);
	}

	public String getURI() {
		return tableConfigURI == null ? null : tableConfigURI.toString();
	}

	@Override
	protected void checkInput() {
		if(tableConfigURI != null) {
			super.checkInput();
		}
	}

	@Override
	protected void doBinding() {
		super.doBinding();

		//Configure the table
		ModelElement modelElement = input.getModelElement(propertyPath);

		Table table;
		if(modelElement instanceof EMFModelElement) {
			EMFModelElement emfModelElement = (EMFModelElement)modelElement;
			EObject sourceElement = emfModelElement.getSource();
			EStructuralFeature feature = emfModelElement.getFeature(getLocalPropertyPath());

			table = createTable(sourceElement, feature);
			if(table == null) {
				displayError("Cannot initialize the table");
				return;
			}
		} else {
			displayError("Invalid table context");
			return;
		}

		//Create the widget
		final NattableModelManager nattableManager = new NattableModelManager(table);
		NatTable widget = nattableManager.createNattable(self, SWT.NONE, null);
		self.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				nattableManager.dispose();
			}
		});

		widget.setBackground(self.getBackground());
	}

	@Override
	protected void updateDescription(String description) {
		self.setToolTipText(description);
	}

	@Override
	public void updateLabel(String label) {
		if(showLabel) {
			((Group)self).setText(getLabel());
		}
	}

	protected void displayError(String message) {
		Label label = new Label(self, SWT.NONE);
		label.setText(message);
		label.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/error.gif")); //$NON-NLS-1$
	}

	protected Table createTable(EObject sourceElement, EStructuralFeature synchronizedFeature) {
		final TableConfiguration tableConfiguration = getTableConfiguration();
		if(tableConfiguration == null) {
			return null;
		}

		final Table table = NattableFactory.eINSTANCE.createTable();

		table.setTableConfiguration(tableConfiguration);
		Property property = getModelProperty();
		if(property != null) {
			String description = property.getDescription();
			if(description != null) {
				table.setDescription(description);
			}
		}

		table.setName(getLabel());
		table.setContext(sourceElement);

		AbstractAxisProvider rowProvider = tableConfiguration.getDefaultRowAxisProvider();
		if(rowProvider == null) {
			rowProvider = NattableaxisproviderFactory.eINSTANCE.createMasterObjectAxisProvider();
		} else {
			rowProvider = EcoreUtil.copy(rowProvider);
		}

		AbstractAxisProvider columnProvider = tableConfiguration.getDefaultColumnAxisProvider();
		if(columnProvider == null) {
			columnProvider = NattableaxisproviderFactory.eINSTANCE.createSlaveObjectAxisProvider();
		} else {
			columnProvider = EcoreUtil.copy(columnProvider);
		}


		TableHeaderAxisConfiguration rowHeaderAxisconfig = tableConfiguration.getRowHeaderAxisConfiguration();
		for(IAxisConfiguration axisConfig : rowHeaderAxisconfig.getOwnedAxisConfigurations()) {
			if(axisConfig instanceof EStructuralFeatureValueFillingConfiguration) {
				((EStructuralFeatureValueFillingConfiguration)axisConfig).setListenFeature(synchronizedFeature);
			}
		}
		//		if(rowProvider instanceof EMFFeatureValueAxisProvider) {
		//			EMFFeatureValueAxisProvider emfAxisProvider = (EMFFeatureValueAxisProvider)rowProvider;
		//
		//			emfAxisProvider.setListenFeature(synchronizedFeature);
		//		}

		table.setCurrentColumnAxisProvider(columnProvider);
		table.setCurrentRowAxisProvider(rowProvider);

		return table;
	}

	protected TableConfiguration getTableConfiguration() {
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			TableConfiguration tableConfiguration = (TableConfiguration)EMFHelper.loadEMFModel(resourceSet, tableConfigURI);
			return tableConfiguration;
		} catch (Exception ex) {
			Activator.log.error("Invalid table configuration", ex);
		}

		return null;
	}

}
