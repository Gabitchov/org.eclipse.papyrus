/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.parser.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.uml.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;
import org.eclipse.papyrus.uml.tools.utils.OperationUtil;
import org.eclipse.papyrus.uml.tools.utils.SignalUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLPackage;

public class MessageCustomParser extends MessageFormatParser implements ISemanticParser {

	public MessageCustomParser(EAttribute[] features) {
		super(features);
	}

	public MessageCustomParser(EAttribute[] features, EAttribute[] editableFeatures) {
		super(features, editableFeatures);
	}

	public MessageCustomParser() {
		super(new EAttribute[]{ UMLPackage.eINSTANCE.getNamedElement_Name() });
	}

	@Override
	public String getPrintString(IAdaptable adapter, int flags) {
		Object obj = adapter.getAdapter(EObject.class);
		String result = null;
		if(obj instanceof Message) {
			Message message = (Message)obj;
			NamedElement signature = message.getSignature();
			if(signature instanceof Operation) {
				Operation operation = (Operation)signature;
				if(MessageSort.REPLY_LITERAL.equals(message.getMessageSort())) {
					result = OperationUtil.getCustomLabel(operation, Arrays.asList(ICustomAppearance.DISP_NAME, ICustomAppearance.DISP_RT_TYPE));
				} else if(MessageSort.SYNCH_CALL_LITERAL.equals(message.getMessageSort())) {
					result = OperationUtil.getCustomLabel(operation, Arrays.asList(ICustomAppearance.DISP_NAME, ICustomAppearance.DISP_PARAMETER_NAME, ICustomAppearance.DISP_PARAMETER_TYPE));
				} else {
					result = OperationUtil.getCustomLabel(operation, Arrays.asList(ICustomAppearance.DISP_NAME, ICustomAppearance.DISP_PARAMETER_NAME, ICustomAppearance.DISP_PARAMETER_TYPE, ICustomAppearance.DISP_RT_TYPE));
				}
			} else if(signature instanceof Signal) {
				result = SignalUtil.getCustomLabel((Signal)signature, Arrays.asList(ICustomAppearance.DISP_NAME, ICustomAppearance.DISP_TYPE));
			} else if(signature != null) {
				result = signature.getName();
			}
			// If the String is empty, we add the name of the message
			if(result == null || result.equals("")) {
				result = message.getName();
			}
		}
		return result;
	}

	@Override
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

	@Override
	public List<Element> getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(element instanceof Message) {
			Message message = (Message)element;
			semanticElementsBeingParsed.add(message);
			NamedElement signature = message.getSignature();
			semanticElementsBeingParsed.add(signature);
			if(signature instanceof Operation) {
				for(Parameter parameter : ((Operation)signature).getOwnedParameters()) {
					semanticElementsBeingParsed.add(parameter);
				}
			}
			if(signature instanceof Signal) {
				for(Property property : ((Signal)signature).getOwnedAttributes()) {
					semanticElementsBeingParsed.add(property);
				}
			}
		}
		return semanticElementsBeingParsed;
	}
}
