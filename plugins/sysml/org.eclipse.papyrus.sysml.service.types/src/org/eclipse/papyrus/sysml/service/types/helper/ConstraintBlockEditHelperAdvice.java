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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.helper.advice.AbstractStereotypedElementEditHelperAdvice;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;

/** SysML {@link ConstraintBlock} edit helper advice */
public class ConstraintBlockEditHelperAdvice extends AbstractStereotypedElementEditHelperAdvice {

	/** Default constructor */
	public ConstraintBlockEditHelperAdvice() {
		requiredProfiles.add(ConstraintsPackage.eINSTANCE);
	}

	/**
	 * Restriction on ConstraintBlock owned Structural and Behavioral features.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {

		IElementType elementToCreate = request.getElementType();

		if(UMLElementTypes.STRUCTURAL_FEATURE.getEClass().isSuperTypeOf(elementToCreate.getEClass())) {
			if(elementToCreate != SysMLElementTypes.CONSTRAINT_PROPERTY && elementToCreate != UMLElementTypes.PROPERTY) {
				return null;
			}
		}

		return super.getBeforeCreateCommand(request);
	}

	/**
	 * Complete creation process by applying the expected stereotype
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				NamedElement element = (NamedElement)request.getElementToConfigure();
				if(element != null) {
					StereotypeApplicationHelper.INSTANCE.applyStereotype(element, ConstraintsPackage.eINSTANCE.getConstraintBlock());

					// Set default name
					// Initialize the element name based on the created IElementType
					String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase(ConstraintsPackage.eINSTANCE.getConstraintBlock().getName(), element.eContainer().eContents());
					element.setName(initializedName);
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
	}
}
