/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.matcher.BlockMatcher;
import org.eclipse.papyrus.sysml.service.types.matcher.PartPropertyMatcher;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;

/** SysML Property Part edit helper advice */
public class PartPropertyEditHelperAdvice extends AbstractPropertyEditHelperAdvice {

	/**
	 * Check if the creation context is a {@link Block}.
	 * 
	 * @see org.eclipse.papyrus.sysml.service.types.helper.AbstractStereotypedElementEditHelperAdvice#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request
	 * @return true if the request is approved
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		boolean isApproved = super.approveRequest(request);

		if((request != null) && (request instanceof GetEditContextRequest)) {

			// Retrieve the edit context from request
			GetEditContextRequest editContextRequest = (GetEditContextRequest)request;

			// Test if the edit context is a Block
			if(editContextRequest.getEditContext() instanceof Element) {
				Element contextElement = (Element)editContextRequest.getEditContext();

				IElementMatcher matcher = new BlockMatcher();
				if(!matcher.matches(contextElement)) {
					isApproved = false;
				}
			}
		}

		return isApproved;
	}

	/** Complete creation process by setting name and default aggregation */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				Property element = (Property)request.getElementToConfigure();
				if(element != null) {

					// Set default name
					String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase("part", element.eContainer().eContents()); //$NON-NLS-1$
					element.setName(initializedName);
					// Initialize the aggregation to composite.
					element.setAggregation(AggregationKind.COMPOSITE_LITERAL);
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
	}

	/**
	 * Complete creation process by adding the related association.
	 * This assumes the part type has been set at this point.
	 */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				Property sourcePart = (Property)request.getElementToConfigure();
				if((sourcePart != null) && (sourcePart.getType() != null)) {

					// Create association between element owner and element type
					Type sourceType = sourcePart.getClass_();
					//Type targetType = sourcePart.getType();
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
		};
	}
	
	/**
	 * Returns the Part to be duplicated
	 * 
	 * @return the Part to be duplicated or <code>null</code> if this is not a part
	 */
	protected Property getDuplicatedProperty(DuplicateElementsRequest request) {
		List<Object> elementsToBeDuplicated = request.getElementsToBeDuplicated();
		if(elementsToBeDuplicated == null || elementsToBeDuplicated.isEmpty()) {
			return null;
		}
		Object firstElement = elementsToBeDuplicated.get(0); // there should be only one element here
		if(!(firstElement instanceof Property)) {
			return null;
		}
		PartPropertyMatcher matcher = new PartPropertyMatcher();
		return matcher.matches((Property)firstElement) ? (Property)firstElement : null;
	}

	
}
