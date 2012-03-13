/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur daussy (Atos) arthur.daussy@atos.net
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.parsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.umlutils.EventUtils;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * Semantic parser for {@link Trigger}
 * @author adaussy
 *
 */
public class TriggerParser implements ISemanticParser {

	private static final String FROM = "from ";
	private static String EMPTY_STRING = ""; //$NON-NLS-1$
	private static final String SPACE = " ";
	private static final String VIRGULE = ",";

	
	public String getEditString(IAdaptable element, int flags) {
		if (element instanceof NamedElement){
			return ((NamedElement)element).getName();
		}
		return EMPTY_STRING;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		if (element != null && newString != null){
			EditingDomain editinDomain = AdapterFactoryEditingDomain.getEditingDomainFor(element);
			if (editinDomain != null){
				Object object = element.getAdapter(EObject.class);
				if (object instanceof EObject){
					SetCommand cmd = new SetCommand(editinDomain, (EObject)object, UMLPackage.Literals.NAMED_ELEMENT__NAME, newString);
					return new EMFtoGMFCommandWrapper(cmd);
				}
				
			}
		}
		return null;
	}
	/**
	 * <trigger> ::= <call-event> | <signal-event> | <any-receive-event> | <time-event> | <change-event>
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Object object = element.getAdapter(EObject.class);
		if(object instanceof Trigger) {
			Trigger trig = (Trigger)object;
			Event event = trig.getEvent();
			StringBuilder result =null;
			if (event != null){				
				result = new StringBuilder(EventUtils.LABEL_SWITCH.doSwitch(event));
				EList<Port> ports = trig.getPorts();
				if ( ports != null && !ports.isEmpty()){
					result.append(FROM);
					Iterator<Port> ite = ports.iterator();
					while(ite.hasNext()){
						result.append(ite.next().getName());
						if (ite.hasNext()){
							result.append(VIRGULE);
							result.append(SPACE);
						} 
					}
				}
			} else {
				result = new StringBuilder(trig.getName());
			}
			return result.toString();
		}
		return EMPTY_STRING;
	}
	

	public boolean isAffectingEvent(Object event, int flags) {
		return true;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		if(element instanceof Trigger) {
			Trigger trig = (Trigger)element;
			List<EObject> result = new ArrayList<EObject>();
			result.add(trig);
			Event event = trig.getEvent();
			if (event != null){
				result.addAll(semanticFromCommunicationSwitch.doSwitch(event));
				result.add(element);
				EList<Port> ports = trig.getPorts();
				if ( ports != null && !ports.isEmpty()){
					result.addAll(ports);
				}
				return result;				
			}
		}
		return Collections.emptyList();
			
	}
	protected static TriggerSemanticElementToListenSwtich semanticFromCommunicationSwitch = new TriggerSemanticElementToListenSwtich();
	
	public static class TriggerSemanticElementToListenSwtich extends UMLSwitch<List<EObject>>{

		@Override
		public List<EObject> caseCallEvent(CallEvent object) {
			List<EObject> result = new ArrayList<EObject>();
			result.add(object);
			Operation ope = object.getOperation();
			if (ope != null){
				result.add(ope);
			}
			
			return result;
		}


		@Override
		public List<EObject> caseSignalEvent(SignalEvent object) {
			List<EObject> result = new ArrayList<EObject>();
			result.add(object);
			Signal sig = object.getSignal();
			if (sig != null){
				result.add(sig);
			}
			return result;
		}

		@Override
		public List<EObject> caseAnyReceiveEvent(AnyReceiveEvent object) {
			return Collections.emptyList();
		}

		/**
		 * <time-event> ::= <relative-time-event> | <absolute-time-event>
		 * <relative-time-event> ::= ‘after’ <expression>
		 * <absolute-time-event> ::= ‘at’ <expression>
		 */
		@Override
		public List<EObject> caseTimeEvent(TimeEvent object) {
			List<EObject> result = new ArrayList<EObject>();
			result.add(object);
			TimeExpression when = object.getWhen();
			if( when != null){
				result.add(when);
			}
			return result;
		}
		/**
		 * <change-event> ::= ‘when’ <expression>
		 */
		@Override
		public List<EObject> caseChangeEvent(ChangeEvent object) {
			List<EObject> result = new ArrayList<EObject>();
			result.add(object);
			ValueSpecification when = object.getChangeExpression();
			if( when != null){
				result.add(when);
			}
			return result;
		}


		@Override
		public List<EObject> defaultCase(EObject object) {
			return Collections.emptyList();
		}
		
		
		
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}
}
