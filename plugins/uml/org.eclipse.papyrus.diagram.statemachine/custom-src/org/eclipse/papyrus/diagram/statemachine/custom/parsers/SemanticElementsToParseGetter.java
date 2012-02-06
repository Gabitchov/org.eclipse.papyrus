/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Olivier MÃƒÂ©lois (Atos) olivier.melois@atos.net
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.statemachine.custom.parsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.CreationEvent;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExecutionEvent;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.ReceiveOperationEvent;
import org.eclipse.uml2.uml.ReceiveSignalEvent;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;


/**
 * Class used to get the elements that should be parsed by TransitionPropertiesParser.
 * 
 */
public class SemanticElementsToParseGetter extends UMLSwitch<List<EObject>> {

	/**
	 * This is the main method which retrieves every element that the 
	 * transitionPropertiesParser needs to react to. 
	 */
	public List<EObject> caseTransition(Transition object) {
		List<EObject> result = new ArrayList<EObject>();
		if (object != null){
			result.add(object);			
		}

		for(Trigger t : object.getTriggers()) {
			result.addAll(this.doSwitch(t));
		}
		Constraint guard = object.getGuard();
		if(guard != null){
			result.addAll(this.doSwitch(guard));
		}
		Behavior effect = object.getEffect();
		if (effect != null){
			result.addAll(this.doSwitch(effect));			
		}
		return result;
	}


	public List<EObject> caseTrigger(Trigger object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		Event event = object.getEvent();
		if(event != null) {
			result.addAll(this.doSwitch(event));
		}
		return result;
	}

	public List<EObject> caseConstraint(Constraint object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		ValueSpecification spec = object.getSpecification();
		if(spec != null) {
			result.add(spec);
		}
		return result;
	}

	public List<EObject> caseBehavior(Behavior object) {
		return Collections.singletonList((EObject)object);
	}


	public List<EObject> caseAnyReceiveEvent(AnyReceiveEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		return result;
	}

	public List<EObject> caseChangeEvent(ChangeEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		ValueSpecification spec = object.getChangeExpression();
		if(spec != null) {
			result.add(spec);
		}
		return result;
	}

	public List<EObject> caseTimeEvent(TimeEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		ValueSpecification spec = object.getWhen();
		if(spec != null) {
			result.add(spec);
		}
		return result;
	}

	public List<EObject> caseCreationEvent(CreationEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		return result;
	}

	public List<EObject> caseDestructionEvent(DestructionEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		return result;
	}

	public List<EObject> caseExecutionEvent(ExecutionEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		return result;
	}

	public List<EObject> caseCallEvent(CallEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		Operation operation = object.getOperation();
		if(operation != null) {
			result.add(operation);
		}
		return result;
	}

	public List<EObject> caseReceiveOperationEvent(ReceiveOperationEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		Operation operation = object.getOperation();
		if(operation != null) {
			result.add(operation);
		}
		return result;
	}

	public List<EObject> caseSendOperationEvent(SendOperationEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		Operation operation = object.getOperation();
		if(operation != null) {
			result.add(operation);
		}
		return result;
	}

	public List<EObject> caseReceiveSignalEvent(ReceiveSignalEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		Signal signal = object.getSignal();
		if(signal != null) {
			result.add(signal);
		}
		return result;
	}

	public List<EObject> caseSendSignalEvent(SendSignalEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		Signal signal = object.getSignal();
		if(signal != null) {
			result.add(signal);
		}
		return result;
	}

	public List<EObject> caseSignalEvent(SignalEvent object) {
		List<EObject> result = new ArrayList<EObject>();
		result.add(object);
		Signal signal = object.getSignal();
		if(signal != null) {
			result.add(signal);
		}
		return result;
	}
}
