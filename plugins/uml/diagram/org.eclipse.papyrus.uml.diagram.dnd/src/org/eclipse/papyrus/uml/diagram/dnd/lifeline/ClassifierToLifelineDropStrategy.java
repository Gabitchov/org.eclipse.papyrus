/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.dnd.lifeline;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.papyrus.uml.diagram.dnd.Activator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * A DropStrategy to "Type" a Lifeline.
 * Drop a classifier on a Lifeline to type it.
 * This will create a new Property in the interaction, typed by the dropped classifier.
 * The Lifeline will represent this property.
 * 
 * It is also possible to drop directly an already existing Property to the Lifeline.
 * 
 * @author Camille Letavernier
 * 
 */
public class ClassifierToLifelineDropStrategy extends TransactionalDropStrategy {

	public String getLabel() {
		return "Type a Lifeline";
	}

	public String getDescription() {
		return "Drop a classifier on a Lifeline to type it. This will create a new Property in the interaction, typed by the dropped classifier. The Lifeline will represent this property." + "It is also possible to drop directly an already existing Property to the lifeline.";
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		return Activator.PLUGIN_ID + ".lifeline.represents";
	}

	@Deprecated
	public int getPriority() {
		return 0;
	}

	@Override
	protected Command doGetCommand(Request request, EditPart targetEditPart) {
		EObject targetElement = getTargetSemanticElement(targetEditPart);

		if(!(targetElement instanceof Lifeline)) {
			return null;
		}


		final Lifeline targetLifeline = (Lifeline)targetElement;

		final Interaction interaction = targetLifeline.getInteraction();
		if(interaction == null) {
			return null;
		}

		List<EObject> sourceElements = getSourceEObjects(request);

		//The only supported case is "Drop a single Type on a single Lifeline"
		if(sourceElements.size() != 1) {
			return null;
		}

		EObject sourceElement = sourceElements.get(0);
		if(sourceElement instanceof Type) {
			final Type sourceType = (Type)sourceElement;

			Command resultCommand = new Command(getLabel()) {

				@Override
				public void execute() {
					Property property = interaction.createOwnedAttribute("", sourceType);
					targetLifeline.setRepresents(property);
				}
			};

			return resultCommand;
		} else if(sourceElement instanceof Property) {
			final Property property = (Property)sourceElement;
			Command resultCommand = new Command(getLabel()) {

				@Override
				public void execute() {
					targetLifeline.setRepresents(property);
				}
			};

			return resultCommand;
		}

		return null;
	}

}
