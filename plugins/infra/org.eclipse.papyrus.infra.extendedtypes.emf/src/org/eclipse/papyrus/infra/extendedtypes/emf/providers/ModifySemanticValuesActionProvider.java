/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.emf.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.emf.Activator;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ConstantValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureToSet;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.FeatureValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ListValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.ModifySemanticValuesActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.QueryExecutionValue;
import org.eclipse.papyrus.infra.extendedtypes.emf.modifysemanticvaluesactionconfiguration.util.ModifySemanticValuesActionConfigurationSwitch;
import org.eclipse.papyrus.infra.extendedtypes.providers.GetAllExtendedElementTypeActionProvidersOperation;
import org.eclipse.papyrus.infra.extendedtypes.providers.GetExtendedElementTypeActionProviderOperation;
import org.eclipse.papyrus.infra.extendedtypes.providers.IExtendedElementTypeActionProvider;
import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;
import org.eclipse.papyrus.infra.queries.core.converter.ConverterNotfoundException;
import org.eclipse.papyrus.infra.queries.core.converter.ConverterRegistry;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * Provider for Action that set semantic values to an element on creation
 */
public class ModifySemanticValuesActionProvider extends AbstractProvider implements IExtendedElementTypeActionProvider {

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetAllExtendedElementTypeActionProvidersOperation) {
			return true;
		}
		if(operation instanceof GetExtendedElementTypeActionProviderOperation) {
			return (((GetExtendedElementTypeActionProviderOperation)operation).getActionConfiguration() instanceof ModifySemanticValuesActionConfiguration);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getICommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration) {
		// try to create the command that will apply the stereotypes
		if(!(configuration instanceof ModifySemanticValuesActionConfiguration)) {
			Activator.log.error("Trying to configure a modify semantic values action configuration with a configuration which is not a semantic value one: " + configuration, null);
			return UnexecutableCommand.INSTANCE;
		}

		CompositeCommand compositeCommand = new CompositeCommand("Set Values");
		ModifySemanticValuesActionConfiguration modifySemanticValuesActionConfiguration = (ModifySemanticValuesActionConfiguration)configuration;

		// for each object in the list of eobjects to edit, create the stereotype apply command
		for(Object objectToEdit : elementsToEdit) {
			// for each feature in the configuration, sets the value
			if(objectToEdit instanceof EObject) {
				for(FeatureToSet featureToSet : modifySemanticValuesActionConfiguration.getFeaturesToSet()) {
					// create a command from a set request and use the Papyrus edit service
					EObject eObject = (EObject)objectToEdit;
					EStructuralFeature feature = eObject.eClass().getEStructuralFeature(featureToSet.getFeatureName());
					if(feature != null && feature.isChangeable()) {
						// retrieve the value to set
						FeatureValue featureValue = featureToSet.getValue();
						Object value = computeValue(eObject, feature, featureValue);
						SetRequest request = new SetRequest(eObject, feature, value);
						IElementEditService service = ElementEditServiceUtils.getCommandProvider(eObject);
						ICommand command = service.getEditCommand(request);
						if(command != null) {
							compositeCommand.add(command);
						}
					}
				}
				
				// for dynamic features, opens the pop up and ask for the values to set
			}
		}
		return compositeCommand;
	}

	/**
	 * Retrieves the value from the feature value parameter
	 * 
	 * @param eObject
	 *        the context of the value
	 * @param feature
	 *        the feature for which the value is computed
	 * @param featureValue
	 *        the representation of the value of the feature from which to compute the real value
	 * @return the value of the feature
	 */
	protected Object computeValue(final EObject eObject, final EStructuralFeature feature, FeatureValue featureValue) {
		Object value = new ModifySemanticValuesActionConfigurationSwitch<Object>() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object caseListValue(ListValue listValue) {
				List<Object> values = new ArrayList<Object>();
				for(FeatureValue fValue : listValue.getValues()) {
					Object value = computeValue(eObject, feature, fValue);
					values.add(value);
				}
				return values;
			};

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object caseQueryExecutionValue(QueryExecutionValue queryExecutionValue) {
				Object value = null;
				QueryConfiguration configuration = queryExecutionValue.getConfiguration();
				try {
					//value = QueryUtil.evaluateQuery(eObject, configuration);
				} catch (Exception e) {
					Activator.log.error(e);
				}
				return value;
			};

			/**
			 * {@inheritDoc}
			 */
			@Override
			public Object caseConstantValue(ConstantValue constantValue) {
				Class<?> parameterType = feature.getEType().getInstanceClass();
				try {
					Object convertedValue = ConverterRegistry.getSingleton().convert(parameterType, constantValue.getValueInstance());
					return convertedValue;
				} catch (ConverterNotfoundException e) {
					Activator.log.error(e);
				}
				return null;
			}

		}.doSwitch(featureValue);

		return value;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getBeforeCreateValidationCommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration) {
		// here, element to edit should be the parent of the created element on which the stereotype is applied.
		ModifySemanticValuesActionConfiguration modifySemanticValuesActionConfiguration = (ModifySemanticValuesActionConfiguration)configuration;

		for(Object objectToEdit : elementsToEdit) {
			// FIXME ...
		}
		// returns a null command, which means it is possible to apply the stereotype
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setConfiguration(IConfigurationElement element) {
		// something to do here ?
	}

}
