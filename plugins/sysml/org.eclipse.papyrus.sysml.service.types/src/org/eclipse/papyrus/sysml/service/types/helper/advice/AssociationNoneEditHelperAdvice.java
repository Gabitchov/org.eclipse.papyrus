/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.service.types.Activator;
import org.eclipse.papyrus.uml.service.types.utils.ClassifierUtils;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Edit helper advice for {@link Association} with "aggregation = none" (used for creation purpose only).
 */
public class AssociationNoneEditHelperAdvice extends AssociationEditHelperAdvice {

	/**
	 * This method provides the source type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	protected Classifier getSourceOwnerType(ConfigureRequest req) {
		Classifier result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.SOURCE);
		if(paramObject instanceof Classifier) {
			result = (Classifier)paramObject;
		}

		return result;
	}

	/**
	 * This method provides the target type provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	protected Classifier getTargetOwnerType(ConfigureRequest req) {
		Classifier result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.TARGET);
		if(paramObject instanceof Classifier) {
			result = (Classifier)paramObject;
		}

		return result;
	}

	/**
	 * Creates a new {@link Property} from the propertyType in the propertyContainer
	 * 
	 * @param propertyContainer
	 *        the container of the {@link Property}
	 * @param propertyType
	 *        the type of the {@link Property}
	 * @return the new {@link Property}
	 * @throws ExecutionException 
	 */	
	protected Property createTargetProperty(Property targetProperty, Classifier propertyContainer, Type propertyType, Association association, TransactionalEditingDomain editingDomain, IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		setPropertyType(targetProperty, propertyType, editingDomain, progressMonitor, info);
		setPropertyName(targetProperty);
		return targetProperty;
	}
	
	protected Property createSourceProperty(Property sourceProperty, Classifier propertyContainer, Type propertyType, Association association, TransactionalEditingDomain editingDomain, IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		setPropertyType(sourceProperty, propertyType, editingDomain, progressMonitor, info);
		setPropertyName(sourceProperty);
		return sourceProperty;
	}
	
	protected void setPropertyType(Property property, Type propertyType, TransactionalEditingDomain editingDomain, IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// Set type using all AdviceHelper (use ServiceEdit instead of manually set)
		SetRequest request = new SetRequest(property, UMLPackage.eINSTANCE.getTypedElement_Type(), propertyType);
		request.setEditingDomain(editingDomain);	
		IElementEditService commandProvider = ElementEditServiceUtils.getCommandProvider(property);
		ICommand editCommand = commandProvider.getEditCommand(request);
		editCommand.execute(progressMonitor, info);
	}

	private void setPropertyName(Property property) {
		String baseName = property.getType().getName().toLowerCase();
		Element owner = property.getOwner();
		if (owner instanceof Classifier) {
			List<Property> ownedAttributes = ClassifierUtils.getOwnedAttributes((Classifier)owner);
			String defaultNameWithIncrementFromBase = NamedElementHelper.getDefaultNameWithIncrementFromBase(
					property.getType().getName().toLowerCase(), ownedAttributes, "_");
			property.setName(defaultNameWithIncrementFromBase);
		}
		else {
			// default
			property.setName(baseName);
		}
	}

	/**
	 * This method has to be specialized by subclasses (AggregationKind)
	 * @param sourceProperty
	 * 			The property to configure
	 */
	protected void configureSourceProperty(Property sourceProperty)  {
		// do nothing
	}

	/**
	 * This method has to be specialized by subclasses (AggregationKind)
	 * @param sourceProperty
	 * 			The property to configure
	 */
	protected void configureTargetProperty(Property targetProperty) {
		// do nothing
	}

	/**
	 * This method has to be specialized by subclasses (owner)
	 * 
	 * @param sourceEnd
	 *        the semantic end
	 * @param owner
	 *        the end container
	 * @param targetType
	 *        the target type
	 * @param association
	 *        the association
	 * @throws UnsupportedOperationException
	 */
	protected void addSourceInModel(final Property sourceEnd, Classifier owner, Type targetType, Association association) throws UnsupportedOperationException {
		// set the container in order to allow Stereotype appliance
		boolean added = ClassifierUtils.addOwnedAttribute(owner, sourceEnd); 
		if(!added) {
			throw new UnsupportedOperationException("Cannot add a Property on Classifier " + owner.getQualifiedName());
		}
	}

	/**
	 * This method has to be specialized by subclasses (owner)
	 * 
	 * @param targetEnd
	 *        the semantic end
	 * @param owner
	 *        the end container
	 * @param sourceType
	 *        the source type
	 * @param association
	 *        the association
	 * @throws UnsupportedOperationException
	 */
	protected void addTargetInModel(Property targetEnd, Classifier owner, Type sourceType, Association association) {
		// set the container in order to allow Stereotype appliance
		boolean added = ClassifierUtils.addOwnedAttribute(owner, targetEnd); 
		if(!added) {
			throw new UnsupportedOperationException("Cannot add a Property on Classifier " + owner.getQualifiedName());
		}
	}

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Complete the {@link Association} creation by setting its ends.
	 * 
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		final Association association = (Association)request.getElementToConfigure();
		final Classifier sourceType = getSourceOwnerType(request);
		final Classifier targetType = getTargetOwnerType(request);

		if((sourceType == null) || (targetType == null)) {
			return UnexecutableCommand.INSTANCE;
		}

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				try {
					Property targetProperty = UMLFactory.eINSTANCE.createProperty();
					Property sourceProperty = UMLFactory.eINSTANCE.createProperty();

					// TODO: problem with SysML. Link are inversed. A -> B => memberEnd={a, b} instead of {b, a}.
					// Problem seems to come from cached derivedFeature /endTypes
					// So we force to set memberEnd in this order before doing anything with the created properties
					association.getMemberEnds().add(targetProperty);
					association.getMemberEnds().add(sourceProperty);

					// Create source and target ends
					addSourceInModel(targetProperty, sourceType, targetType, association);
					addTargetInModel(sourceProperty, targetType, sourceType, association);
					createTargetProperty(targetProperty, sourceType, targetType, association, request.getEditingDomain(), progressMonitor, info);
					configureSourceProperty(targetProperty);
					createSourceProperty(sourceProperty, targetType, sourceType, association, request.getEditingDomain(), progressMonitor, info);
					configureTargetProperty(sourceProperty);
	
				} catch (Exception e) {
					Activator.log.error(e);
					return CommandResult.newCancelledCommandResult();
				}

				return CommandResult.newOKCommandResult(association);
			}
		};
	}
}