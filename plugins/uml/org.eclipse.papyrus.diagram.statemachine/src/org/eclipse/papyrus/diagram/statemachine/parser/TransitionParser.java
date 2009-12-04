/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 *    Marc Gil (Prodevelop) - Changed the implemented interface from IParser to ISemanticParser
 *    						- If the transition hasn't triggers, guards and efects, show the name
 */

package org.eclipse.papyrus.diagram.statemachine.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

public class TransitionParser implements ISemanticParser {


	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return getPrintString(element, flags);
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		return UnexecutableCommand.INSTANCE;
	}

	public String getPrintString(IAdaptable element, int flags) {
		EObject eObject = (EObject)element.getAdapter(EObject.class);
		if(eObject instanceof Transition) {
			Transition transition = (Transition)eObject;
			String s = "";

			EList<Trigger> triggers = transition.getTriggers();

			for(Iterator<Trigger> triggersIterator = triggers.iterator(); triggersIterator.hasNext();) {
				Trigger trigger = triggersIterator.next();
				Event event = trigger.getEvent();
				if(event != null) {
					s += event.getLabel();
					if(triggersIterator.hasNext()) {
						s += ",";
					}
				}
			}

			Constraint guard = transition.getGuard();
			if(guard != null) {
				ValueSpecification specification = guard.getSpecification();
				if(specification != null) {
					s += "[";
					s += specification.stringValue();
					s += "]";
				}
			}

			Behavior effect = transition.getEffect();
			if(effect != null) {
				s += "/";
				s += effect.getLabel();
			}

			if(s == "")
				return transition.getName();

			return s;
		}
		return ""; //$NON-NLS-1$
	}

	public boolean isAffectingEvent(Object event, int flags) {
		if(event instanceof Notification) {
			Object feature = ((Notification)event).getFeature();
			return UMLPackage.eINSTANCE.getTransition_Trigger().equals(feature) ||
					UMLPackage.eINSTANCE.getTransition_Guard().equals(feature) ||
					UMLPackage.eINSTANCE.getTransition_Effect().equals(feature);
		}
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.UNEDITABLE_STATUS;
	}

	public boolean areSemanticElementsAffected(EObject listener,
			Object notification) {
		return true;
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		if(element instanceof Transition) {
			Transition t = (Transition)element;
			List elements = new ArrayList();

			//insert the own transition
			elements.add(element);
			if(t.getTriggers().size() > 0) {
				//insert every trigger
				for(Iterator<Trigger> it = t.getTriggers().iterator(); it.hasNext();) {
					Trigger tr = it.next();
					elements.add(tr);
					//insert the trigger's event if it exists
					if(tr.getEvent() != null)
						elements.add(tr.getEvent());
				}
			}
			//insert the guard if exists
			if(t.getGuard() != null) {
				elements.add(t.getGuard());
				//insert the guard's specification if exists
				if(t.getGuard().getSpecification() != null)
					elements.add(t.getGuard().getSpecification());
			}
			//insert the effect if exists
			if(t.getEffect() != null) {
				elements.add(t.getEffect());
			}

			return elements;
		}

		return null;
	}
}
