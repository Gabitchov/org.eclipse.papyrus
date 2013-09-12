/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.sysml.nattable.menu.handlers;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.commands.ConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.tools.utils.NamedElementUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * Command handler for Problem creation
 * 
 * </pre>
 * 
 * @generated
 */
public class ConstraintBlockParameterHandler extends AbstractSysmlNattableCreateCommandHandler {

	/**
	 * <pre>
	 * @see org.eclipse.papyrus.uml.service.types.handlers.AbstractCreateCommandHandler#getElementTypeToCreate()
	 * 
	 * @return the IElementType this handler is supposed to create
	 * 
	 * </pre>
	 * 
	 * @generated
	 */
	protected IElementType getElementTypeToCreate() {
		return UMLElementTypes.PROPERTY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command buildCommand() {

		if(getCommandContext() == null) {
			return UnexecutableCommand.INSTANCE;
		}

		EObject container = getCommandContext().getContainer();
		EReference reference = getCommandContext().getReference();

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		CreateElementRequest createRequest = null;
		if(reference == null) {
			createRequest = new CreateElementRequest(container, getElementTypeToCreate());
		} else {
			createRequest = new CreateElementRequest(container, getElementTypeToCreate(), reference);
		}

		String name = NamedElementUtil.getDefaultNameWithIncrementFromBase("parameter", ((Element)container).eContents()); //$NON-NLS-1$
		createRequest.setParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID, new ConfigureFeatureCommandFactory(UMLPackage.eINSTANCE.getNamedElement_Name(), name));

		// Retrieve create command from the Element Edit service
		ICommand createGMFCommand = provider.getEditCommand(createRequest);
		if(createGMFCommand != null) {
			Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);
			return emfCommand;
		}
		return UnexecutableCommand.INSTANCE;
	}
}
