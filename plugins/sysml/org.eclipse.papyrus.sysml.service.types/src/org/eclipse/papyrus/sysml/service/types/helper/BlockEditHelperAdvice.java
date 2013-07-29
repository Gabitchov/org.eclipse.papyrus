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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.sysml.service.types.matcher.FlowSpecificationMatcher;
import org.eclipse.papyrus.sysml.service.types.matcher.RequirementMatcher;
import org.eclipse.papyrus.uml.service.types.helper.advice.AbstractStereotypedElementEditHelperAdvice;
import org.eclipse.papyrus.uml.service.types.utils.EMFUtil;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/** SysML Block edit helper advice */
public class BlockEditHelperAdvice extends AbstractStereotypedElementEditHelperAdvice {

	/** Default constructor */
	public BlockEditHelperAdvice() {
		requiredProfiles.add(BlocksPackage.eINSTANCE);
	}

	/**
	 * Check if the creation context is allowed.
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

			// Test context type
			if(editContextRequest.getEditContext() instanceof Element) {
				Element contextElement = (Element)editContextRequest.getEditContext();

				IElementMatcher matcher;

				// Cannot create a nested Block in FlowSpecification
				matcher = new FlowSpecificationMatcher();
				if(matcher.matches(contextElement)) {
					isApproved = false;
				}

				// Cannot create a nested Block in Requirement
				matcher = new RequirementMatcher();
				if(matcher.matches(contextElement)) {
					isApproved = false;
				}
			}
		}

		return isApproved;
	}

	/** Complete creation process by applying the expected stereotype */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				NamedElement element = (NamedElement)request.getElementToConfigure();
				if(element != null) {
					StereotypeApplicationHelper.INSTANCE.applyStereotype(element, BlocksPackage.eINSTANCE.getBlock());

					// Set default name
					// Initialize the element name based on the created IElementType
					String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase(BlocksPackage.eINSTANCE.getBlock().getName(), element.eContainer().eContents());
					element.setName(initializedName);
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
	}
	
	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		// test if the creation is for a SysML association

		IElementType type = request.getElementType();
		if(hasSuperType(type, SysMLElementTypes.ASSOCIATION)) {
			// test source and target...
			EObject source = request.getSource();
			// The source of an association cannot be read-only.
			if (EMFUtil.isReadOnly(source)) {
				return UnexecutableCommand.INSTANCE;
			}
		}

		return super.getBeforeCreateRelationshipCommand(request);
	}
	
	protected boolean hasSuperType(IElementType elementType, IElementType typeToTest) {
		if(elementType == null || typeToTest == null) {
			return false;
		}

		if(elementType.equals(typeToTest)) {
			return true;
		}

		List<IElementType> superTypes = Arrays.asList(elementType.getAllSuperTypes());
			if(superTypes.contains(typeToTest)) {
				return true;
			}

		return false;
	}
}
