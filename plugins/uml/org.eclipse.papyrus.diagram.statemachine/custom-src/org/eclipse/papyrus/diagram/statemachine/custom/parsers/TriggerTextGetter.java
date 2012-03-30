/*****************************************************************************
 * Copyright (c) 2011-2012 CEA LIST.
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

import org.eclipse.papyrus.umlutils.ValueSpecificationUtil;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.CreationEvent;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.ExecutionEvent;
import org.eclipse.uml2.uml.ReceiveOperationEvent;
import org.eclipse.uml2.uml.ReceiveSignalEvent;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;

/**
 * Class used to get the text from a trigger that should be displayed on a transition
 * label.
 * 
 */
public class TriggerTextGetter extends UMLSwitch<String> {

	public String caseAnyReceiveEvent(AnyReceiveEvent object) {
		return "all" ;//$NON-NLS-1$
	}

	public String caseChangeEvent(ChangeEvent object) {
		StringBuilder result = new StringBuilder();
		ValueSpecification spec = object.getChangeExpression();
		if(spec != null) {
			result.append("When \""); //$NON-NLS-1$
			result.append(spec.getName());
			result.append(" = "); //$NON-NLS-1$
			String specText = ValueSpecificationUtil.getSpecificationValue(spec);
			result.append(specText);
			if(spec.getType() != null) {
				result.append(" "); //$NON-NLS-1$
				result.append(spec.getType().getName());
			}
			result.append("\"");
		} else {
			result.append(object.getName());
		}
		return result.toString();
	}

	public String caseTimeEvent(TimeEvent object) {
		StringBuilder result = new StringBuilder();
		ValueSpecification spec = object.getWhen();
		if(spec != null) {
			if(object.isRelative()) {
				result.append("After \""); //$NON-NLS-1$				
			} else {
				result.append("At \""); //$NON-NLS-1$
			}
			result.append(spec.getName());
			result.append(" = "); //$NON-NLS-1$
			String specText = ValueSpecificationUtil.getSpecificationValue(spec);
			result.append(specText);
			if(spec.getType() != null) {
				result.append(" "); //$NON-NLS-1$
				result.append(spec.getType().getName());
			}
			result.append("\"");
		} else {
			result.append(object.getName());
		}
		return result.toString();
	}

	public String caseCreationEvent(CreationEvent object) {
		return object.getName();
	}

	public String caseDestructionEvent(DestructionEvent object) {
		return object.getName();
	}

	public String caseExecutionEvent(ExecutionEvent object) {
		return object.getName();
	}

	public String caseCallEvent(CallEvent object) {
		return object.getName();
	}

	public String caseReceiveOperationEvent(ReceiveOperationEvent object) {
		StringBuilder result = new StringBuilder();
		if(object.getOperation() != null) {
			String operation = object.getOperation().getName();
			//String operation = OperationUtil.getCustomLabel(object.getOperation(), ICustomAppearence.DEFAULT_UML_OPERATION);
			result.append(operation);
		} else {
			result.append(object.getName());
		}
		return result.toString();
	}

	public String caseSendOperationEvent(SendOperationEvent object) {
		StringBuilder result = new StringBuilder();
		if(object.getOperation() != null) {
			String operation = object.getOperation().getName();
			//String operation = OperationUtil.getCustomLabel(object.getOperation(), ICustomAppearence.DEFAULT_UML_OPERATION);
			result.append(operation);
		} else {
			result.append(object.getName());
		}
		return result.toString();
	}

	public String caseReceiveSignalEvent(ReceiveSignalEvent object) {
		StringBuilder result = new StringBuilder();
		if(object.getSignal() != null) {
			String signal = object.getSignal().getName();
			//String signal = SignalUtil.getCustomLabel(object.getSignal(), ICustomAppearence.DEFAULT_UML_OPERATION);
			result.append(signal);
		} else {
			result.append(object.getName());
		}
		return result.toString();
	}

	public String caseSendSignalEvent(SendSignalEvent object) {
		StringBuilder result = new StringBuilder();
		if(object.getSignal() != null) {
			String signal = object.getSignal().getName();
			//String signal = SignalUtil.getCustomLabel(object.getSignal(), ICustomAppearence.DEFAULT_UML_OPERATION);
			result.append(signal);
		} else {
			result.append(object.getName());
		}
		return result.toString();
	}

	public String caseSignalEvent(SignalEvent object) {
		StringBuilder result = new StringBuilder();
		if(object.getSignal() != null) {
			String signal = object.getSignal().getName();
			//String signal = SignalUtil.getCustomLabel(object.getSignal(), ICustomAppearence.DEFAULT_UML_OPERATION);
			result.append(signal);
		} else {
			result.append(object.getName());
		}
		return result.toString();
	}
}
