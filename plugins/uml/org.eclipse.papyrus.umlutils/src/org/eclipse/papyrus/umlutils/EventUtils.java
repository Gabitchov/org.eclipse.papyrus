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
package org.eclipse.papyrus.umlutils;


import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;


/**
 * Utils class to display label for event
 * @author adaussy
 *
 */
public class EventUtils {
	/**
	 * UMLSwitch wich return the string to display an event
	 */
	public static EventLabelSwtich LABEL_SWITCH = new EventLabelSwtich();
	
	public static class EventLabelSwtich extends UMLSwitch<String>{
		
		private static final String WHEN = "when ";////$NON-NLS-1$
		private static final String AT = "at ";////$NON-NLS-1$
		private static final String AFTER = "after ";////$NON-NLS-1$
		private static final String ALL = "all";////$NON-NLS-1$
		private static final String RIGHT_BRACKET = " )";////$NON-NLS-1$
		private static final String LEFT_BRACKET = " (";////$NON-NLS-1$
		private static final String SPACE = " ";////$NON-NLS-1$
		private static final String VIRGULE = ",";////$NON-NLS-1$
		private static final String NO_NAME = "NO NAME";////$NON-NLS-1$

		
		EventLabelSwtich(){
			
		}
		
		/**
		 * <call-event> :: <name> [‘(‘ [<assignment-specification>] ‘)’]
		 * <assignment-specification> ::= <attr-name> [‘,’ <attr-name>]*
		 */
		@Override
		public String caseCallEvent(CallEvent object) {
			StringBuilder result=  new StringBuilder(object.getName());
			Operation ope = object.getOperation();
			if (ope != null){
				result.append(LEFT_BRACKET);
				result.append(getAssignmentSpecification(ope.getOwnedParameters()));
				result.append(RIGHT_BRACKET);
			}
			
			return result.toString();
		}

		private String getAssignmentSpecification(Collection<? extends NamedElement> input ){
			StringBuilder r = new StringBuilder();
			Iterator<? extends NamedElement> ite = input.iterator();
			while( ite.hasNext()){
				r.append(SPACE).append(ite.next().getName()).append(SPACE);
				if(ite.hasNext()){
					r.append(VIRGULE);
				}
			}
			return r.toString();
		}

		@Override
		public String caseSignalEvent(SignalEvent object) {
			StringBuilder result=  new StringBuilder(object.getName());
			Signal sig = object.getSignal();
			if (sig != null){
				result.append(LEFT_BRACKET);
				result.append(getAssignmentSpecification(sig.getOwnedAttributes()));
				result.append(RIGHT_BRACKET);
			}
			return result.toString();
		}

		@Override
		public String caseAnyReceiveEvent(AnyReceiveEvent object) {
			return ALL;
		}

		/**
		 * <time-event> ::= <relative-time-event> | <absolute-time-event>
		 * <relative-time-event> ::= ‘after’ <expression>
		 * <absolute-time-event> ::= ‘at’ <expression>
		 */
		@Override
		public String caseTimeEvent(TimeEvent object) {
			StringBuilder result = new StringBuilder(object.isRelative()?AFTER:AT);
			TimeExpression when = object.getWhen();
			if( when != null){
				result.append(ValueSpecificationUtil.getSpecificationValue(when));
			}
			return result.toString();
		}
		/**
		 * <change-event> ::= ‘when’ <expression>
		 */
		@Override
		public String caseChangeEvent(ChangeEvent object) {
			StringBuilder result = new StringBuilder(WHEN);
			ValueSpecification when = object.getChangeExpression();
			if( when != null){
				result.append(ValueSpecificationUtil.getSpecificationValue(when));
			}
			return result.toString();
		}


		@Override
		public String defaultCase(EObject object) {
			Activator.logError("EventLabelSwtich was unable to get a correct switch for"+object);////$NON-NLS-1$
			if (object instanceof NamedElement){
				return ((NamedElement)object).getName();
			}
			return NO_NAME;////$NON-NLS-1$
		}
		
		
		
		
	}
}
