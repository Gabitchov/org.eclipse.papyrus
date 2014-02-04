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
package org.eclipse.papyrus.uml.tools.extendedtypes.applystereotypeactionconfiguration;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.extendedtypes.IActionEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.emf.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * advice for the {@link ApplyStereotypeActionConfiguration}
 */
public class ApplyStereotypeActionEditHelperAdvice extends AbstractEditHelperAdvice implements IActionEditHelperAdvice<ApplyStereotypeActionConfiguration> {

	/** configuration for this edit helper advice */
	protected ApplyStereotypeActionConfiguration configuration;

	/**
	 * {@inheritDoc}
	 */
	public void init(ApplyStereotypeActionConfiguration configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		return super.approveRequest(request);
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
		if(configuration==null) {
			return null;
		}
		ICommand resultCommand = null;
		// retrieve eobject 
		EObject elementToConfigure = request.getElementToConfigure();
		if(!(elementToConfigure instanceof Element)) {
			return null;
		}
		
		TransactionalEditingDomain editingDomain = request.getEditingDomain();
		if(editingDomain ==null) {
			return null;
		}
		// retrieve edit service to get features from configure command
		IElementEditService service = ElementEditServiceUtils.getCommandProvider(elementToConfigure);
		if(service == null) {
			Activator.log.error("Impossible to get edit service from element: " + elementToConfigure, null);
			return null;
		}
		
		// for each stereotype, apply stereotype and apply values
		for(StereotypeToApply stereotypeToApply : configuration.getStereotypesToApply()) {
			Stereotype stereotype = ((Element)elementToConfigure).getApplicableStereotype(stereotypeToApply.getStereotypeQualifiedName());
			
			if(stereotype !=null) {
				ApplyStereotypeCommand applyStereotypeCommand = new ApplyStereotypeCommand(editingDomain, (Element)elementToConfigure, stereotype, stereotypeToApply.isUpdateName());
				if(resultCommand == null) {
					resultCommand = applyStereotypeCommand;
				} else {
					resultCommand = resultCommand.compose(applyStereotypeCommand);
				}
				
				// apply values
				for(FeatureToSet featureToSet : stereotypeToApply.getFeaturesToSet()) {
					// retrieve feature value
					ICommand command = getSetStereotypeFeatureValueCommand((Element)elementToConfigure, stereotype, featureToSet.getFeatureName(), featureToSet.getValue(), service, request);
					if(command != null) {
						if(resultCommand == null) {
							resultCommand = command;
						} else {
							resultCommand = resultCommand.compose(command);
						}
					}
				}
			}
			
		}
	
		if(resultCommand != null) {
			return resultCommand.reduce();
		}
		return super.getAfterConfigureCommand(request);
	}

	/**
	 * @param elementToConfigure
	 *        the eobject to configure
	 * @param name
	 *        the name of the feature to set
	 * @param value
	 *        the new value of the feature
	 */
	protected ICommand getSetStereotypeFeatureValueCommand(Element elementToConfigure, Stereotype stereotype, String name, FeatureValue featureValue, IElementEditService service, ConfigureRequest configureRequest) {
		if(name == null) {
			Activator.log.debug("No feature name has been set.");
			return null;
		}
		if(elementToConfigure.eClass() == null) {
			Activator.log.error("Impossible to find EClass from EObject: " + elementToConfigure, null);
			return null;
		}
		
		if(configureRequest.getEditingDomain()==null) {
			return null;
		}
		
		// retrieve structural feature for the element to configure
		TypedElement typedElement = (TypedElement)stereotype.getMember(name, true, UMLPackage.eINSTANCE.getTypedElement());
		if(typedElement == null) {
			Activator.log.error("Impossible to find feature " + name + " for eobject " + elementToConfigure, null);
			return null;
		}
		Object value = getStereotypeValue(elementToConfigure, stereotype, typedElement.getType(), featureValue);
		
		return new SetStereotypeValueCommand(configureRequest.getEditingDomain(), elementToConfigure, stereotype, name, value);
		
	}
	
	
	/**
	 * @param elementToConfigure
	 * @param stereotype
	 * @param feature
	 * @param featureValue
	 * @return
	 */
	protected Object getStereotypeValue(Element elementToConfigure, Stereotype stereotype, Type type, FeatureValue featureValue) {
		return StereotypeFeatureValueUtils.getValue(elementToConfigure, stereotype, type, featureValue);
	}


	public static class ApplyStereotypeCommand extends AbstractTransactionalCommand {

		private Stereotype stereotype;
		
		private Element element;

		private boolean rename;
		
		/**
		 * @param domain editing domain to modify the element
		 * @param element the element on which stereotype is applied. Must not be <code>null</code>
		 * @param stereotype the stereotype to modify 
		 * @param rename 
		 */
		public ApplyStereotypeCommand(TransactionalEditingDomain domain, Element element, Stereotype stereotype, boolean rename) {
			super(domain, "Apply Stereotype "+stereotype.getLabel(), getWorkspaceFiles(element));
			this.element = element;
			this.stereotype = stereotype;
			this.rename = rename;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			try {
				Object stereotypeApplication = element.applyStereotype(stereotype);
				if(rename && element instanceof NamedElement) {
					if(((NamedElement)element).getNamespace()!=null) {
						String newName = NamedElementUtil.getDefaultNameWithIncrement(stereotype.getName(), element, ((NamedElement)element).getNamespace().getMembers());
						((NamedElement)element).setName(newName);
					}
				}
				return CommandResult.newOKCommandResult(stereotypeApplication);
			} catch (Throwable t) {
				Activator.log.error(t);
				return CommandResult.newErrorCommandResult(t.getMessage());
			}
		}
	}
	
	
	public static class SetStereotypeValueCommand extends AbstractTransactionalCommand {

		private Element element;
		private Stereotype stereotype;
		private String featureName;
		private Object featureValue;

		/**
		 * Default Constructor
		 * @param domain editing domain to modify the element
		 * @param element the element on which stereotype is applied. Must not be <code>null</code>
		 * @param stereotype the stereotype to modify 
		 * @param featureName name of the stereotype feature to modify 
		 * @param featureValue the new value for the stereotype feature value
		 */
		public SetStereotypeValueCommand(TransactionalEditingDomain domain, Element element, Stereotype stereotype, String featureName, Object featureValue) {
			super(domain, "Set stereotype  value "+featureName, getWorkspaceFiles(element.getStereotypeApplication(stereotype)));
			this.element = element;
			this.stereotype = stereotype;
			this.featureName = featureName;
			this.featureValue = featureValue;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			try {
				element.setValue(stereotype, featureName, featureValue);
			} catch (Throwable t) {
				Activator.log.error(t);
				return CommandResult.newErrorCommandResult(t.getMessage());
			}
			
			return CommandResult.newOKCommandResult(element.getValue(stereotype, featureName));
		}
		
	}
}
