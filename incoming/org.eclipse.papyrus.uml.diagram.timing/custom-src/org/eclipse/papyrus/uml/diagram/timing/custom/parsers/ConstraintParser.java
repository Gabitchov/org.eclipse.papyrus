/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/** A parser for {@link TimeConstraint}s and {@link DurationConstraint}s */
public class ConstraintParser implements ISemanticParser {

	private static final String ERROR = "<error>"; //$NON-NLS-1$

	private static final Pattern pattern = Pattern.compile("\\{(.*?)\\.\\.(.*?)\\}"); //$NON-NLS-1$

	private class MinMax {

		LiteralString min;

		LiteralString max;

		public MinMax(final LiteralString min, final LiteralString max) {
			this.min = min;
			this.max = max;
		}

		public LiteralString getMin() {
			return this.min;
		}

		public LiteralString getMax() {
			return this.max;
		}
	}

	public String getPrintString(final IAdaptable element, final int flags) {
		return getEditString(element, flags);
	}

	public String getEditString(final IAdaptable element, final int flags) {
		final Constraint constraint = doAdapt(element);
		final MinMax minMax = getMinMax(constraint);
		if(minMax == null) {
			return ERROR;
		}
		return getMinMaxLabel(minMax);
	}

	protected static String getMinMaxLabel(final MinMax minMax) {
		return "{" + minMax.getMin().stringValue() + ".." + minMax.getMax().stringValue() + "}";//$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public ICommand getParseCommand(final IAdaptable element, final String newString, final int flags) {
		final Constraint constraint = doAdapt(element);
		final MinMax minMax = getMinMax(constraint);
		if(minMax == null) {
			return UnexecutableCommand.INSTANCE;
		}
		final Matcher matcher = ConstraintParser.pattern.matcher(newString);
		if(matcher.matches()) {
			final String min = matcher.group(1);
			final String max = matcher.group(2);
			final TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(constraint);
			return createSetMinMaxCommand(constraint, minMax, min, max, editingDomain);
		}
		return UnexecutableCommand.INSTANCE;
	}

	private MinMax getMinMax(final Constraint constraint) {
		if(constraint == null) {
			return null;
		}
		final ValueSpecification specification = constraint.getSpecification();
		if(specification instanceof TimeInterval) {
			return getTimeIntervalMinMax((TimeInterval)specification);
		} else if(specification instanceof DurationInterval) {
			return getDurationIntervalMinMax((DurationInterval)specification);
		}

		return null;
	}

	private MinMax getTimeIntervalMinMax(final TimeInterval timeInterval) {
		final ValueSpecification min = timeInterval.getMin();
		final ValueSpecification max = timeInterval.getMax();

		if(!(min instanceof TimeExpression) || !(max instanceof TimeExpression)) {
			return null;
		}

		final TimeExpression minTime = (TimeExpression)min;
		final TimeExpression maxTime = (TimeExpression)max;

		final ValueSpecification minValue = minTime.getExpr();
		final ValueSpecification maxValue = maxTime.getExpr();
		if(!(minValue instanceof LiteralString) || !(maxValue instanceof LiteralString)) {
			return null;
		}

		final LiteralString minStr = (LiteralString)minValue;
		final LiteralString maxStr = (LiteralString)maxValue;

		return new MinMax(minStr, maxStr);
	}

	private MinMax getDurationIntervalMinMax(final DurationInterval durationInterval) {
		final ValueSpecification min = durationInterval.getMin();
		final ValueSpecification max = durationInterval.getMax();

		if(!(min instanceof Duration) || !(max instanceof Duration)) {
			return null;
		}

		final Duration minDuration = (Duration)min;
		final Duration maxDuration = (Duration)max;

		final ValueSpecification minValue = minDuration.getExpr();
		final ValueSpecification maxValue = maxDuration.getExpr();
		if(!(minValue instanceof LiteralString) || !(maxValue instanceof LiteralString)) {
			return null;
		}

		final LiteralString minStr = (LiteralString)minValue;
		final LiteralString maxStr = (LiteralString)maxValue;

		return new MinMax(minStr, maxStr);
	}

	public IParserEditStatus isValidEditString(final IAdaptable element, final String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	private static ICommand createSetMinMaxCommand(final Constraint constraint, final MinMax minMax, final String min, final String max, final TransactionalEditingDomain editingDomain) {
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		return new AbstractTransactionalCommand(editingDomain, Messages.ConstraintParser_SetConstraint, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				minMax.getMin().setValue(min);
				minMax.getMax().setValue(max);
				// setting this label is more user-friendly and it makes the label refresh since
				// we are changing a direct property of the semantic element
				constraint.setName(getMinMaxLabel(minMax));
				return CommandResult.newOKCommandResult();
			}
		};
	}

	/**
	 * Obtain the constraint element from the adaptable.
	 * 
	 * @param element
	 *        the given IAdaptable
	 * @return the constraint or null if it can't be found.
	 */
	protected static Constraint doAdapt(final IAdaptable element) {
		final Object obj = element.getAdapter(EObject.class);
		if(obj instanceof Constraint) {
			return (Constraint)obj;
		}
		return null;
	}

	public boolean isAffectingEvent(final Object event, final int flags) {
		return true;
	}

	public IContentAssistProcessor getCompletionProcessor(final IAdaptable element) {
		return null;
	}

	public List<?> getSemanticElementsBeingParsed(final EObject element) {
		final List<EObject> list = new ArrayList<EObject>();
		if(element instanceof Constraint) {
			final Constraint constraint = (Constraint)element;
			final MinMax minMax = getMinMax(constraint);
			if(minMax != null) {
				list.add(minMax.getMin());
				list.add(minMax.getMax());
			}
		}
		return list;
	}

	public boolean areSemanticElementsAffected(final EObject listener, final Object notification) {
		final EStructuralFeature feature = EcoreUtils.getEStructuralFeature(notification);
		return UMLPackage.eINSTANCE.getLiteralString_Value().equals(feature);
	}
}
