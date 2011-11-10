/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.services.edit.commands.IConfigureCommandFactory;
import org.eclipse.papyrus.uml.service.types.command.UnapplyAllStereotypesCommand;
import org.eclipse.uml2.uml.Element;

/**
 * <pre>
 * 
 * Edit helper class for {@link Element}
 * 
 * Expected behavior:
 * - Removes any stereotype application before deletion
 * 
 * The configure command allows contributions provided by the request parameters.
 * </pre>
 */
public class ElementEditHelper extends DefaultEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		if (req.getParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID) != null) {
			IConfigureCommandFactory factory = (IConfigureCommandFactory) req.getParameter(IConfigureCommandFactory.CONFIGURE_COMMAND_FACTORY_ID);
			return factory.create(req);
		}
		return super.getConfigureCommand(req);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<EClass, EReference> getDefaultContainmentFeatures() {
		return (Map<EClass, EReference>)super.getDefaultContainmentFeatures();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getDestroyElementCommand(DestroyElementRequest req) {

		// Default destroy command
		ICommand destroyCommand = super.getDestroyElementCommand(req);
		// Stereotype application remove command
		ICommand removeStereotypeCommand = null;

		// Prepare stereotype application remove command
		EObject elementToDestroy = req.getElementToDestroy();
		if(elementToDestroy instanceof Element) {
			removeStereotypeCommand = new UnapplyAllStereotypesCommand(req.getEditingDomain(), req.getLabel(), (Element)elementToDestroy);
		}

		// Compose both commands
		destroyCommand = CompositeCommand.compose(removeStereotypeCommand, destroyCommand);
		if(destroyCommand != null) {
			destroyCommand = destroyCommand.reduce();
		}

		return destroyCommand;
	}

}
