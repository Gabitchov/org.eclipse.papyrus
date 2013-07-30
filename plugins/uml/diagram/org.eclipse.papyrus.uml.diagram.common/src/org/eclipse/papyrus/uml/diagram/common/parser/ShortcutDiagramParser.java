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
 *  Patrick Tessier(CEA LIST) Patrick.Tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.parser;

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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.uml.diagram.common.Messages;

/**
 * parser to display the name of diagram in the case of a short cut
 * 
 */
public class ShortcutDiagramParser implements IParser {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		Diagram diagram = doAdapt(element);
		if(diagram == null || diagram.eResource() == null) {
			return Messages.DiagramNotFound;
		}

		return diagram.getName();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		Diagram diagram = doAdapt(element);
		if(diagram == null || diagram.eResource() == null) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(diagram);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, Messages.SetNameDiagram); //$NON-NLS-1$
		SetRequest request = new SetRequest(diagram, NotationPackage.eINSTANCE.getDiagram_Name(), newString);
		command.compose(new SetValueCommand(request));
		return command;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {
		Diagram diagram = doAdapt(element);
		if(diagram == null || diagram.eResource() == null) {
			return Messages.DiagramNotFound;
		}

		return diagram.getName();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * used to obtain the diagram element.
	 * 
	 * @param element
	 *        the given IAdaptable
	 * @return the diagram or null if it can't be found.
	 */
	protected Diagram doAdapt(IAdaptable element) {
		Object obj = element.getAdapter(EObject.class);
		if(obj instanceof Diagram) {
			return (Diagram)obj;
		}
		return null;
	}
}
