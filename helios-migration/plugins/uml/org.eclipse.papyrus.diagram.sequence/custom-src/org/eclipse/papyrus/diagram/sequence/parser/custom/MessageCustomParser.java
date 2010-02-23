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
package org.eclipse.papyrus.diagram.sequence.parser.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.papyrus.diagram.sequence.parsers.MessageFormatParser;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
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
		StringBuffer sb = new StringBuffer();

		if(obj instanceof Message) {
			Message message = (Message)obj;
			if(message.getSignature() != null) {
				NamedElement signature = message.getSignature();
				if(signature.getName().length() > 0) {
					sb.append(signature.getName());
					sb.append("(");
					sb.append(")");

					// Return-value and attribute assignment are used only for reply messages
					if(MessageSort.REPLY_LITERAL.equals(message.getMessageSort())) {
						if(signature instanceof Operation) {
							Operation operation = (Operation)signature;

							Parameter returnResult = operation.getReturnResult();
							if(returnResult != null) {
								sb.append(":");
								sb.append(returnResult.getName());
							}
						}

					}
				}
			}

			// If the String is empty, we add the name of the message
			if(sb.length() == 0) {
				sb.append(message.getName());
			}
		}

		return sb.toString();
	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return false;
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		List<Element> semanticElementsBeingParsed = new ArrayList<Element>();
		if(element instanceof Message) {
			Message message = (Message)element;
			semanticElementsBeingParsed.add(message);

		}
		return semanticElementsBeingParsed;
	}

}
