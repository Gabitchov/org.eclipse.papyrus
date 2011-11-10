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
package org.eclipse.papyrus.uml.tools.extendedtypes.providers;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.emf.type.core.EditHelperContext;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.extendedtypes.ActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.providers.GetAllExtendedElementTypeActionProvidersOperation;
import org.eclipse.papyrus.infra.extendedtypes.providers.GetExtendedElementTypeActionProviderOperation;
import org.eclipse.papyrus.infra.extendedtypes.providers.IExtendedElementTypeActionProvider;
import org.eclipse.papyrus.uml.tools.extendedtypes.Activator;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.ApplyStereotypeActionConfiguration;
import org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration.StereotypeToApply;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Provider for Action that applies stereotypes to an element on creation
 */
public class ApplyStereotypeActionProvider extends AbstractProvider implements IExtendedElementTypeActionProvider {

	/**
	 * {@inheritDoc}
	 */
	public boolean provides(IOperation operation) {
		if(operation instanceof GetAllExtendedElementTypeActionProvidersOperation) {
			return true;
		}
		if(operation instanceof GetExtendedElementTypeActionProviderOperation) {
			return (((GetExtendedElementTypeActionProviderOperation)operation).getActionConfiguration() instanceof ApplyStereotypeActionConfiguration);
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getICommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration) {
		// try to create the command that will apply the stereotypes
		if(!(configuration instanceof ApplyStereotypeActionConfiguration)) {
			Activator.INSTANCE.log("Trying to configure a stereotype action configuration with a configuration which is not a stereotype one: " + configuration);
			return UnexecutableCommand.INSTANCE;
		}

		CompositeCommand compositeCommand = new CompositeCommand("Apply Stereotypes");
		ApplyStereotypeActionConfiguration stereotypeActionConfiguration = (ApplyStereotypeActionConfiguration)configuration;

		// for each object in the list of eobjects to edit, create the stereotype apply command
		for(Object objectToEdit : elementsToEdit) {
			if(objectToEdit instanceof Element) {
				//1. retrieve the list of stereotypes
				for(StereotypeToApply stereotypeToApply : stereotypeActionConfiguration.getStereotypesToApply()) {
					String qualifiedName = stereotypeToApply.getStereotypeQualifiedName();

					ICommand command = new ApplyStereotypeCommand((Element)objectToEdit, new ApplyStereotypeRequest(TransactionUtil.getEditingDomain(objectToEdit), (Element)objectToEdit, qualifiedName));
					compositeCommand.add(command);
				}
			} else {
				Activator.INSTANCE.log("Impossible to cast the element to edit into an Element, trying to apply a stereotype on it");
			}
		}
		return compositeCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getBeforeCreateValidationCommand(List<? extends Object> elementsToEdit, ActionConfiguration configuration) {
		// here, element to edit should be the parent of the created element on which the stereotype is applied.
		ApplyStereotypeActionConfiguration stereotypeActionConfiguration = (ApplyStereotypeActionConfiguration)configuration;

		for(Object objectToEdit : elementsToEdit) {
			for(StereotypeToApply stereotypeToApply : stereotypeActionConfiguration.getStereotypesToApply()) {
				// compare this list to accessible profiles from container.
				if(objectToEdit instanceof Element) {
					Element elementToEdit = ((Element)objectToEdit);
					org.eclipse.uml2.uml.Package ownerPackage = elementToEdit.getNearestPackage();
					if(ownerPackage == null) {
						return UnexecutableCommand.INSTANCE;
					}
					for(String requiredProfileName : stereotypeToApply.getRequiredProfiles()) {
						Profile profile = ownerPackage.getAppliedProfile(requiredProfileName, true);
						if(profile == null) {
							return UnexecutableCommand.INSTANCE;
						}
					}
				}
			}
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

	/**
	 * Command to apply stereotypes and set stereotype application properties values
	 */
	public class ApplyStereotypeCommand extends EditElementCommand {

		/**
		 * Create a new {@link ApplyStereotypeCommand}.
		 * 
		 * @param elementToEdit
		 *        element to edit
		 * @param request
		 *        the request used to modify the model
		 */
		protected ApplyStereotypeCommand(Element elementToEdit, IEditCommandRequest request) {
			super("Apply Stereotype Command", elementToEdit, request);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// retrieve the stereotype
			Stereotype stereotypeToApply = getElementToEdit().getApplicableStereotype(getRequest().getStereotypeQualifiedName());
			if(stereotypeToApply == null) {
				return CommandResult.newErrorCommandResult("Impossible to find the stereotype " + getRequest().getStereotypeQualifiedName() + " for the element " + getElementToEdit());
			}
			EObject result = getElementToEdit().applyStereotype(stereotypeToApply);
			if(result != null) {
				return CommandResult.newOKCommandResult();
			}
			return CommandResult.newErrorCommandResult("Impossible to apply the stereotype " + stereotypeToApply + " for the element " + getElementToEdit());
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean canExecute() {
			// check the stereotype is present and can be applied
			Stereotype stereotypeToApply = getElementToEdit().getApplicableStereotype(getRequest().getStereotypeQualifiedName());
			if(stereotypeToApply == null) {
				return false;
			}
			return super.canExecute();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Element getElementToEdit() {
			return (Element)super.getElementToEdit();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected ApplyStereotypeRequest getRequest() {
			return (ApplyStereotypeRequest)super.getRequest();
		}
	}

	/**
	 * Request to apply stereotype on an element
	 */
	public class ApplyStereotypeRequest extends AbstractEditCommandRequest {

		/** element to edit */
		private final Element elementToEdit;

		/** stererotype qualified name */
		private final String stereotypeQualifiedName;

		/**
		 * Constructor.
		 * 
		 * @param editingDomain
		 *        editing domain in which the command will be executed
		 * @param elementToEdit
		 *        element on which the stereotype should be applied
		 * @param stereotypeQualifiedName
		 *        qualified name of the stereotype to apply
		 */
		protected ApplyStereotypeRequest(TransactionalEditingDomain editingDomain, Element elementToEdit, String stereotypeQualifiedName) {
			super(editingDomain);
			this.elementToEdit = elementToEdit;
			this.stereotypeQualifiedName = stereotypeQualifiedName;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getEditHelperContext() {
			IClientContext context = getClientContext();

			if(context == null) {
				return getElementToEdit();
			} else {
				return new EditHelperContext(getElementToEdit(), context);
			}
		}

		/**
		 * Returns the element to edit
		 * 
		 * @return the element to edit
		 */
		public Element getElementToEdit() {
			return elementToEdit;
		}

		/**
		 * Returns the qualified name of the stereotype to apply
		 * 
		 * @return the qualified name of the stereotype to apply
		 */
		public String getStereotypeQualifiedName() {
			return stereotypeQualifiedName;
		}
	}

}
