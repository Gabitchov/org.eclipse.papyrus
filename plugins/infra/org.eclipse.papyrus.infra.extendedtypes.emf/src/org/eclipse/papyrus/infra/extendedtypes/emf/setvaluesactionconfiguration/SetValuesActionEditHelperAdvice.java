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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.resources.GMFHelper;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.extendedtypes.IActionEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.emf.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.views.properties.contexts.View;
import org.eclipse.papyrus.views.properties.creation.EditionDialog;
import org.eclipse.papyrus.views.properties.creation.PropertyEditorFactory;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.runtime.ViewConstraintEngine;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * advice for the {@link SetValuesActionConfiguration}
 */
public class SetValuesActionEditHelperAdvice extends AbstractEditHelperAdvice implements IActionEditHelperAdvice<SetValuesActionConfiguration> {

	/** list of the features to set */
	//protected Map<String, FeatureValue> featuresToValues = null; 
	/** list of runtime defined features */
	protected Map<String, FeatureValue> featuresToRuntimeDefinitions = null;

	/** list of static defined features */
	protected Map<String, FeatureValue> featuresToStaticDefinitions = null;

	/**
	 * {@inheritDoc}
	 */
	public void init(SetValuesActionConfiguration configuration) {
		featuresToRuntimeDefinitions = new HashMap<String, FeatureValue>();
		featuresToStaticDefinitions = new HashMap<String, FeatureValue>();
		if(configuration == null) {
			return;
		}
		for(FeatureToSet featureToSet : configuration.getFeaturesToSet()) {
			if(featureToSet.isAtRuntime()) {
				featuresToRuntimeDefinitions.put(featureToSet.getFeatureName(), featureToSet.getValue());
			} else {
				featuresToStaticDefinitions.put(featureToSet.getFeatureName(), featureToSet.getValue());	
			}
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
		
		for(Entry<String, FeatureValue> featureEntry: featuresToStaticDefinitions.entrySet()) {
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
		
		if(!featuresToRuntimeDefinitions.isEmpty()) {
			ICommand command = getDynamicSetFeatureValueCommand(elementToConfigure, featuresToRuntimeDefinitions, service, request);
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
	 * @param elementToConfigure
	 * @param featuresToRuntimeDefinitions2
	 * @param service
	 * @param request
	 * @return
	 */
	protected ICommand getDynamicSetFeatureValueCommand(final EObject elementToConfigure, Map<String, FeatureValue> featuresToRuntimeDefinitions, IElementEditService service, ConfigureRequest request) {
		return new AbstractTransactionalCommand(request.getEditingDomain(), "Editing "+EMFCoreUtil.getName(elementToConfigure), Collections.singletonList(WorkspaceSynchronizer.getFile((elementToConfigure.eResource())))) {
			
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				new PropertyEditorFactory().edit(Display.getCurrent().getFocusControl(), elementToConfigure);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * @param elementToConfigure
	 *        the eobject to configure
	 * @param name
	 *        the name of the feature to set
	 * @param value
	 *        the new value of the feature
	 */
	protected ICommand getSetFeatureValueCommand(EObject elementToConfigure, String name, FeatureValue featureValue, IElementEditService service, ConfigureRequest configureRequest) {
		if(name == null) {
			Activator.log.debug("No feature name has been set.");
			return null;
		}
		if(elementToConfigure.eClass() == null) {
			Activator.log.error("Impossible to find EClass from EObject: " + elementToConfigure, null);
			return null;
		}
		// retrieve structural feature for the element to configure
		EStructuralFeature feature = elementToConfigure.eClass().getEStructuralFeature(name);
		if(feature == null) {
			Activator.log.error("Impossible to find feature " + name + " for eobject " + elementToConfigure, null);
			return null;
		}
		Object value = FeatureValueUtils.getValue(elementToConfigure, feature, featureValue);
		SetRequest request = new SetRequest(elementToConfigure, feature, value);
		// duplicate parameters from configure request?
		request.addParameters(configureRequest.getParameters());
		return service.getEditCommand(request);
	}
}
