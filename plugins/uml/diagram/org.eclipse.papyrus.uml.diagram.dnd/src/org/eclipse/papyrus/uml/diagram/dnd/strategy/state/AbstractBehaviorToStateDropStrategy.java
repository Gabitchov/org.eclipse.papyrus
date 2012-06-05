/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.dnd.strategy.state;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.infra.gmfdiag.dnd.strategy.TransactionalDropStrategy;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.State;

/**
 * Abstract implementation for a Behavior being dropped on a State. One of the State's
 * features will be set to the dropped behavior (doActivity, Entry, Exit)
 * 
 * @author Camille Letavernier
 * 
 */
//FIXME: This is a sample implementation. The edited features are composite, which means
//the dropped behavior is actually moved to the target state.
//We should either add a warning to avoid confusing the user, or offer a refactoring option
//(e.g. Move the behavior to an operation, create a new FunctionBehavior in the state, 
//and link the FunctionBehavior#specification to the operation)
public abstract class AbstractBehaviorToStateDropStrategy extends TransactionalDropStrategy {

	public String getLabel() {
		String featureName = getFeatureToEdit().getName();
		return "Behavior -> State : sets the \"" + featureName + "\" property";
	}

	public String getDescription() {
		String featureName = getFeatureToEdit().getName();
		return "When a Behavior is dropped on a State, sets the behavior as the state's \"" + featureName + "\" property";
	}

	public Image getImage() {
		return null;
	}

	public String getID() {
		String featureName = getFeatureToEdit().getName();
		return "org.eclipse.papyrus.behaviorToState." + featureName;
	}

	public int getPriority() {
		return 50;
	}

	public String getCategory() {
		return "org.eclipse.papyrus.behaviorToState";
	}

	@Override
	public Command doGetCommand(Request request, EditPart targetEditPart) {
		if(!(getTargetSemanticElement(targetEditPart) instanceof State)) {
			return null;
		}

		List<EObject> sourceEObjects = getSourceEObjects(request);

		if(sourceEObjects.size() != 1) {
			return null;
		}

		if(!(sourceEObjects.get(0) instanceof Behavior)) {
			return null;
		}

		final Behavior behavior = (Behavior)sourceEObjects.get(0);
		final State targetState = (State)getTargetSemanticElement(targetEditPart);

		EObject ancestor = targetState.eContainer();
		while(ancestor != null) {
			if(ancestor == behavior) {
				return null; //Avoid containment cycle
			}

			ancestor = ancestor.eContainer();
		}

		return new Command() {

			@Override
			public void execute() {
				targetState.eSet(getFeatureToEdit(), behavior);
			}
		};
	}

	protected abstract EStructuralFeature getFeatureToEdit();

}
