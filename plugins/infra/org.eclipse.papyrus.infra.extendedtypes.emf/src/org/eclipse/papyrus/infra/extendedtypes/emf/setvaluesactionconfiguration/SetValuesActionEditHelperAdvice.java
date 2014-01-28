/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.emf.setvaluesactionconfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.extendedtypes.IActionEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.emf.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;


/**
 * advice for the {@link SetValuesActionConfiguration}
 */
public class SetValuesActionEditHelperAdvice extends AbstractEditHelperAdvice implements IActionEditHelperAdvice<SetValuesActionConfiguration> {
	
	/** list of the features to set */
	protected Map<String, FeatureValue> featuresToValues = null; 

	/**
	 * {@inheritDoc}
	 */
	public void init(SetValuesActionConfiguration configuration) {
		featuresToValues= new HashMap<String, FeatureValue>(); // reset of the map
		if(configuration==null) {
			return;
		}
		for(FeatureToSet featureToSet : configuration.getFeaturesToSet()) {
			featuresToValues.put(featureToSet.getFeatureName(), featureToSet.getValue());
		}
	}
	
	/**
	 * Default Constructor
	 */
	public SetValuesActionEditHelperAdvice() {
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean approveRequest(IEditCommandRequest request) {
		return super.approveRequest(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		return super.getBeforeCreateCommand(request);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		return super.getAfterCreateCommand(request);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		return super.getBeforeConfigureCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		ICommand resultCommand = null;
		
		// retrieve eobject 
		EObject elementToConfigure = request.getElementToConfigure();
		if(elementToConfigure==null) {
			return null;
		}
		// retrieve edit service to get features from configure command
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(elementToConfigure);
		if(service == null) {
			Activator.log.error("Impossible to get edit service from element: "+elementToConfigure, null);
			return null;
		}
		
		for(Entry<String, FeatureValue> featureEntry: featuresToValues.entrySet()) {
			// retrieve feature value
			ICommand command = getSetFeatureValueCommand(elementToConfigure, featureEntry.getKey(), featureEntry.getValue(), service, request);
			if(command !=null) {
				if(resultCommand == null) {
					resultCommand = command; 
				} else {
					resultCommand = resultCommand.compose(command);
				}
			}
		}
		if(resultCommand!=null) {
			return resultCommand.reduce();
		}
		
		
		return super.getAfterConfigureCommand(request);
	}

	/**
	 * @param elementToConfigure the eobject to configure
	 * @param name the name of the feature to set 
	 * @param value the new value of the feature
	 */
	protected ICommand getSetFeatureValueCommand(EObject elementToConfigure, String name, FeatureValue featureValue, IElementEditService service, ConfigureRequest configureRequest) {
		if(name==null) {
			Activator.log.debug("No feature name has been set.");
			return null;
		}
		if(elementToConfigure.eClass() ==null) {
			Activator.log.error("Impossible to find EClass from EObject: "+elementToConfigure, null);
			return null;
		}
		// retrieve structural feature for the element to configure
		EStructuralFeature feature = elementToConfigure.eClass().getEStructuralFeature(name);
		if(feature ==null) {
			Activator.log.error("Impossible to find feature "+name+" for eobject "+elementToConfigure, null);
			return null; 
		}
		
		Object value = FeatureValueUtils.getValue(elementToConfigure, feature, featureValue);
		
		
		SetRequest request = new SetRequest(elementToConfigure, feature, value);
		// duplicate parameters from configure request?
		request.addParameters(configureRequest.getParameters());
		
		return service.getEditCommand(request);
	}
}
