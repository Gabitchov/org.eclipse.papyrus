/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.edit.commands;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * Configure command factory that set a list of {@link EStructuralFeature} of the new element.
 */
public class ConfigureFeatureListCommandFactory extends AbstractConfigureCommandFactory {

	/** A Map containing the {@link EStructuralFeature} to be set and their values. */
	private Map<EStructuralFeature, Object> featureValueMap;

	/** Constructor */
	public ConfigureFeatureListCommandFactory(Map<EStructuralFeature, Object> featureValueMap) {
		super();
		this.featureValueMap = featureValueMap;
	}

	/**
	 * {@inheritDoc}
	 */
	public ConfigureElementCommand create(ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				EObject eObject = getElementToEdit();
				for(EStructuralFeature feature : featureValueMap.keySet()) {
					eObject.eSet(feature, featureValueMap.get(feature));
				}

				return CommandResult.newOKCommandResult(eObject);
			}

		};
	}
}
