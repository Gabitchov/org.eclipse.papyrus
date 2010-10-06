/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.activity.parser.custom;

import java.util.ArrayList;
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
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * Specific Parser for the comment, in case they have a html format.
 */
public class PreConditionConstraintLabelParser implements IParser {
	private static final String CHEVRON = String.valueOf("\u00AB") +"PreCondition"+ String.valueOf("\u00BB");
	/**
	 * {@inheritDoc}
	 */
	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public List getSemanticElementsBeingParsed(EObject element) {
		List list = new ArrayList();
		list.add(element);
		return list;
	}

	/**
	 * {@inheritDoc}
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null) {
			return "<NULL CONSTRAINT>"; //$NON-NLS-1$
		}
		return constraint.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(constraint);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Name"); //$NON-NLS-1$
		SetRequest request = new SetRequest(constraint, UMLPackage.eINSTANCE.getNamedElement_Name(), newString);
		command.compose(new SetValueCommand(request));
		return command;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Constraint constraint = doAdapt(element);
		if(constraint == null) {
			return "<NULL CONSTRAINT>"; //$NON-NLS-1$
		}


		return CHEVRON+constraint.getName();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if(event instanceof org.eclipse.emf.common.notify.Notification) {
			Object source = ((org.eclipse.emf.common.notify.Notification)event).getFeature();
			if(UMLPackage.eINSTANCE.getNamedElement_Name().equals(source)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}


	/**
	 * Get the property associated with the given IAdaptable and the memberEndIndex .
	 * 
	 * @param element
	 *        the given IAdaptable
	 * @return the property associated or null if it can't be found.
	 */
	protected Constraint doAdapt(IAdaptable element) {
		Object obj = element.getAdapter(EObject.class);
		if(obj instanceof Constraint) {
			return (Constraint)obj;
		}
		return null;
	}

}
