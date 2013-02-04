/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parsers;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.uml2.uml.Lifeline;

/** Used to get and set the name of a StateDefinition when editing a StateDefinition's label */
public class StateDefinitionParser implements IParser {

	public String getEditString(final IAdaptable adaptable, final int flags) {
		final View stateDefinitionLabelView = (View)adaptable.getAdapter(View.class);
		final View stateDefinitionView = (View)stateDefinitionLabelView.eContainer();
		final String name = StateDefinitionUtils.getStateDefinitionName(stateDefinitionView);
		if(name == null) {
			return ""; //$NON-NLS-1$
		}
		return name;
	}

	public IParserEditStatus isValidEditString(final IAdaptable element, final String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	public ICommand getParseCommand(final IAdaptable adaptable, final String newString, final int flags) {
		final View stateDefinitionLabelView = (View)adaptable.getAdapter(View.class);
		final View stateDefinitionView = (View)stateDefinitionLabelView.eContainer();
		final View lifelineView = ViewUtils.findSuperViewWithId(stateDefinitionView, FullLifelineEditPartCN.VISUAL_ID);
		final Lifeline lifeline = (Lifeline)lifelineView.getElement();
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(lifeline);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}

		return new AbstractTransactionalCommand(editingDomain, Messages.StateDefinitionParser_SetStateDefinitionName, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				StateDefinitionUtils.setStateDefinitionName(stateDefinitionView, newString);
				LifelineUtils.updateFragmentNames(lifeline, lifelineView);
				return CommandResult.newOKCommandResult();
			}
		};
	}

	public String getPrintString(final IAdaptable adaptable, final int flags) {
		final View stateDefinitionLabelView = (View)adaptable.getAdapter(View.class);
		final View stateDefinitionView = (View)stateDefinitionLabelView.eContainer();
		final String name = StateDefinitionUtils.getStateDefinitionName(stateDefinitionView);
		if(name == null || name.length() == 0) {
			return Messages.StateDefinitionParser_Unnamed;
		}
		return name;
	}

	public boolean isAffectingEvent(final Object event, final int flags) {
		return true;
	}

	public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
		return null;
	}
}
