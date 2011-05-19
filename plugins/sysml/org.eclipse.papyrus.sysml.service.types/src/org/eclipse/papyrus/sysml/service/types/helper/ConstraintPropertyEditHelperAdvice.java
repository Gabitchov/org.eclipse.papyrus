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
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.papyrus.uml.service.types.helper.advice.AbstractStereotypedElementEditHelperAdvice;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/** SysML {@link ConstraintProperty} edit helper advice */
public class ConstraintPropertyEditHelperAdvice extends AbstractStereotypedElementEditHelperAdvice {

	/** Default constructor */
	public ConstraintPropertyEditHelperAdvice() {
		requiredProfileIDs.add(SysmlResource.CONSTRAINTS_ID);
	}

	/** Complete creation process by applying the expected stereotype */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				NamedElement element = (NamedElement)request.getElementToConfigure();
				if(element != null) {
					Stereotype stereotypeToApply = element.getApplicableStereotype(SysmlResource.CONSTRAINT_PROPERTY_ID);
					if(stereotypeToApply != null) {
						element.applyStereotype(stereotypeToApply);
					}

					// Set default name
					// Initialize the element name based on the created IElementType
					String initializedName = NamedElementHelper.EINSTANCE.getNewUMLElementName(element.getOwner(), ConstraintsPackage.eINSTANCE.getConstraintProperty().getName().toLowerCase());
					element.setName(initializedName);
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
	}
	
	/** 
	 * Restrict allowed types to 
	 * 		{@link ConstraintBlock} 
	 */
	@Override
	protected ICommand getBeforeSetCommand(SetRequest request) {
		
		// Only allow ConstraintBlock or null as new type
		if(UMLPackage.eINSTANCE.getTypedElement_Type().equals(request.getFeature())) {
			if (request.getValue() != null) {
				
				if (! (request.getValue() instanceof Element)) {
					return UnexecutableCommand.INSTANCE;
				}
				
				ConstraintBlock constraint = ElementUtil.getStereotypeApplication((Element) request.getValue(), ConstraintBlock.class);
				if (constraint == null) {
					return UnexecutableCommand.INSTANCE;
				}
			}
		}

		return null;
	}
}
