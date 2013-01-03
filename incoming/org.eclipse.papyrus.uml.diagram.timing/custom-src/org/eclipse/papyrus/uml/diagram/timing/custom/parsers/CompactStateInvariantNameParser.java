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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EcoreUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.LifelineUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateInvariantUtils;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Used to get and set the name of a StateInvariant when editing a StateInvariant's label (this gets and sets the body
 * in the OpaqueExpression of the Constraint of the StateInvariant)
 */
public class CompactStateInvariantNameParser implements ISemanticParser {

	public String getEditString(final IAdaptable adaptable, final int flags) {
		final StateInvariant stateInvariant = getStateInvariant(adaptable);
		final String name = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
		if (name == null) {
			return ""; //$NON-NLS-1$
		}
		return name;
	}

	public IParserEditStatus isValidEditString(final IAdaptable element, final String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	public ICommand getParseCommand(final IAdaptable adaptable, final String newString, final int flags) {
		final StateInvariant stateInvariant = getStateInvariant(adaptable);
		final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(stateInvariant);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new AbstractTransactionalCommand(editingDomain, Messages.CompactStateInvariantNameParser_SetStateInvariantName, null) {
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				// set the name on the Constraint and OpaqueExpression
				StateInvariantUtils.setInnerStateInvariantName(stateInvariant, newString);
				// set the name directly on the StateInvariant (note that this triggers a refresh of the label)
				stateInvariant.setName(newString);
				for (final Lifeline coveredLifeline : stateInvariant.getCovereds()) {
					LifelineUtils.updateFragmentNames(coveredLifeline, null);
					// XXX what if the StateInvariant appears both on a compact and on a full lifeline?
					StateDefinitionUtils.updateStateDefinitionNamesForCompactLifeline(coveredLifeline);
				}
				return CommandResult.newOKCommandResult();
			}
		};
	}

	private static StateInvariant getStateInvariant(final IAdaptable adaptable) {
		return (StateInvariant) adaptable.getAdapter(EObject.class);
	}

	public String getPrintString(final IAdaptable adaptable, final int flags) {
		final StateInvariant stateInvariant = getStateInvariant(adaptable);
		final String name = StateInvariantUtils.getInnerStateInvariantName(stateInvariant);
		if (name == null || name.length() == 0) {
			return Messages.CompactStateInvariantNameParser_Unnamed;
		}
		return name;
	}

	public boolean isAffectingEvent(final Object event, final int flags) {
		return true;
	}

	public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
		return null;
	}

	public List<?> getSemanticElementsBeingParsed(final EObject element) {
		final List<EObject> list = new ArrayList<EObject>();
		if (element instanceof StateInvariant) {
			final StateInvariant stateInvariant = (StateInvariant) element;
			final Constraint invariant = stateInvariant.getInvariant();
			if (invariant != null) {
				final ValueSpecification specification = invariant.getSpecification();
				if (specification != null) {
					list.add(specification);
				}
			}
		}
		return list;
	}

	public boolean areSemanticElementsAffected(final EObject listener, final Object notification) {
		final EStructuralFeature feature = EcoreUtils.getEStructuralFeature(notification);
		return UMLPackage.eINSTANCE.getStateInvariant_Invariant().equals(feature) || UMLPackage.eINSTANCE.getConstraint_Specification().equals(feature)
				|| UMLPackage.eINSTANCE.getOpaqueExpression_Body().equals(feature);
	}
}
