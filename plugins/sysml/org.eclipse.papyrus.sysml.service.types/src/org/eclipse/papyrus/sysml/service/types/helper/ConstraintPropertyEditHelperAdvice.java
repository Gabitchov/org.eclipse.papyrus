/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.helper.advice.AbstractStereotypedElementEditHelperAdvice;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/** SysML {@link ConstraintProperty} edit helper advice */
public class ConstraintPropertyEditHelperAdvice extends AbstractStereotypedElementEditHelperAdvice {

	/** Default constructor */
	public ConstraintPropertyEditHelperAdvice() {
		requiredProfiles.add(ConstraintsPackage.eINSTANCE);
	}

	/** Complete creation process by applying the expected stereotype */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				NamedElement element = (NamedElement)request.getElementToConfigure();
				if(element != null) {
					StereotypeApplicationHelper.INSTANCE.applyStereotype(element, ConstraintsPackage.eINSTANCE.getConstraintProperty());

					// Set default name
					// Initialize the element name based on the created IElementType
					String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase(ConstraintsPackage.eINSTANCE.getConstraintProperty().getName().toLowerCase(), element.eContainer().eContents());
					element.setName(initializedName);
					// SysML constraint : self.ownedAttribute->forAll(p | p.type.oclIsKindOf(ConstraintBlock) implies p.aggregation = #composite)
					if (element instanceof Property) {
						((Property)element).setAggregation(AggregationKind.COMPOSITE_LITERAL);
					}
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
	}

	/**
	 * Restrict allowed types to {@link ConstraintBlock}
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {

		// Only allow ConstraintBlock or null as new type
		if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(request.getFeature())) {
			if(request.getValue() != null) {

				if(!(request.getValue() instanceof Element)) {
					return UnexecutableCommand.INSTANCE;
				}

				ConstraintBlock constraint = UMLUtil.getStereotypeApplication((Element)request.getValue(), ConstraintBlock.class);
				if(constraint == null) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}

		return null;
	}

	/**
	 * Complete creation process by adding the related association.
	 * This assumes the constraintProperty type has been set at this point.
	 */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				Property sourcePart = (Property)request.getElementToConfigure();
				if((sourcePart != null) && (sourcePart.eContainer() != null)) {

					sourcePart.setAggregation(AggregationKind.COMPOSITE_LITERAL);
					
					// Create association between element owner and element type
					Type sourceType = resolveTypeContainer(sourcePart);
					Package associationContainer = sourceType.getNearestPackage();

					// Create targetProperty
					Property targetProperty = UMLFactory.eINSTANCE.createProperty();
					targetProperty.setType(sourceType);
					targetProperty.setName(sourceType.getName() != null ? sourceType.getName().toLowerCase() : "null");

					Association association = UMLFactory.eINSTANCE.createAssociation();
					association.getMemberEnds().add(sourcePart);
					association.getOwnedEnds().add(targetProperty);
					association.getMemberEnds().add(targetProperty);

					String associationName = NamedElementHelper.getDefaultNameWithIncrementFromBase("Association", associationContainer.eContents()); //$NON-NLS-1$
					association.setName(associationName);

					// Add SysML Nature on the new Association
					ElementUtil.addNature(association, SysMLElementTypes.SYSML_NATURE);

					association.setPackage(associationContainer);
				}
				return CommandResult.newOKCommandResult(sourcePart);
			}

			private Type resolveTypeContainer(Property property) {
				EObject eContainer = property.eContainer();
				if (eContainer instanceof Property) {
					eContainer = ((Property) eContainer).getType();
				}
				if (eContainer instanceof Type) {
					return (Type)eContainer;
				}
				return null;
			}
		};
	}
}
