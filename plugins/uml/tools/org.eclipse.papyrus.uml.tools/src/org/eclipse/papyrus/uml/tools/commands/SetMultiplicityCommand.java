/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (camille.letavernier@cea.fr) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.commands;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.tools.util.MultiplicityParser;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A Command to edit the Multiplicity of a MultiplicityElement. The expected value is a String
 * representing the Multiplicity.
 * 
 * This command is a CompoundCommand, and relies on the Service Edit to retrieve the individual "set bounds" commands
 * 
 * @author Camille Letavernier
 * 
 * @see {@link MultiplicityParser}
 */
public class SetMultiplicityCommand extends CompoundCommand {

	private int[] lowerUpper;

	private MultiplicityElement element;

	static EStructuralFeature lowerFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Lower();

	static EStructuralFeature upperFeature = UMLPackage.eINSTANCE.getMultiplicityElement_Upper();

	public SetMultiplicityCommand(MultiplicityElement element, String value) {
		if(element == null) {
			return;
		}

		int[] lowerUpper = MultiplicityParser.getBounds(value);
		if(lowerUpper == null || lowerUpper.length < 2) {
			return;
		}

		int lower = lowerUpper[0];
		int upper = lowerUpper[1];

		if(!MultiplicityParser.isValidMultiplicity(lower, upper)) {
			return;
		}

		this.lowerUpper = lowerUpper;
		this.element = element;

		append(getSetCommand(lowerFeature, lower));
		append(getSetCommand(upperFeature, upper));
	}

	private Command getSetCommand(EStructuralFeature feature, int value) {
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
		if(provider != null) {
			SetRequest request = new SetRequest(element, feature, value);
			ICommand createGMFCommand = provider.getEditCommand(request);

			Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

			return emfCommand;
		}
		return null;
	}

	@Override
	public boolean canExecute() {
		return element != null && lowerUpper != null && lowerUpper.length == 2 && super.canExecute();
	}

}
