/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.parser;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * The Class ConstraintParser.
 */
public class ConstraintParser implements IParser, ISemanticParser {

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getEditString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 */

	public String getEditString(IAdaptable element, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null || constraint.getSpecification() == null) {
			return "<NULL Constraint>"; //$NON-NLS-1$
		}
		if(constraint.getSpecification() instanceof LiteralString) {
			return ((LiteralString)constraint.getSpecification()).getValue();
		}
		return "";
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isValidEditString(org.eclipse.core.runtime.IAdaptable, java.lang.String)
	 * 
	 */

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getParseCommand(org.eclipse.core.runtime.IAdaptable, java.lang.String, int)
	 * 
	 */

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null || constraint.getSpecification() == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(constraint);
		if(editingDomain == null || constraint.getSpecification() == null) {
			return UnexecutableCommand.INSTANCE;
		}
		LiteralString specif = (LiteralString)constraint.getSpecification();
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Value Constraint"); //$NON-NLS-1$
		SetRequest request = new SetRequest(specif, UMLPackage.eINSTANCE.getLiteralString_Value(), newString);
		command.compose(new SetValueCommand(request));
		return command;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getPrintString(org.eclipse.core.runtime.IAdaptable, int)
	 * 
	 */

	public String getPrintString(IAdaptable element, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null || constraint.getSpecification() == null) {
			return "";
		}
		if(constraint.getSpecification() instanceof LiteralString) {
			return ((LiteralString)constraint.getSpecification()).getValue();
		}
		return "";
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#isAffectingEvent(java.lang.Object, int)
	 * 
	 */

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.ui.services.parser.IParser#getCompletionProcessor(org.eclipse.core.runtime.IAdaptable)
	 * 
	 */

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * used to obtain the constraint element.
	 * 
	 * @param element
	 *        the given IAdaptable
	 * @return the constraint or null if it can't be found.
	 */
	protected Constraint doAdapt(IAdaptable element) {
		Object obj = element.getAdapter(EObject.class);
		if(obj instanceof Constraint) {
			return (Constraint)obj;
		}
		return null;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#getSemanticElementsBeingParsed(org.eclipse.emf.ecore.EObject)
	 * 
	 */

	public List getSemanticElementsBeingParsed(EObject element) {
		Element umlElement = (Element)element;
		List<EObject> result = new LinkedList<EObject>();
		if(umlElement instanceof Constraint) {
			Constraint constraint = (Constraint)umlElement;
			if(constraint.getSpecification() != null) {
				ValueSpecification value = constraint.getSpecification();
				result.add(value);
			}
		}
		return result;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser#areSemanticElementsAffected(org.eclipse.emf.ecore.EObject,
	 *      java.lang.Object)
	 * 
	 */

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return true;
	}

}
