/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.dialogs.PapyrusAsyncNotificationPopup;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.UMLFactory;

/** Validates a timing model in the context of a Papyrus timing diagram */
public final class ModelValidationUtils {

	private ModelValidationUtils() {
		// utility class
	}

	/**
	 * Validates the given {@link Interaction}. Note that this only validates rules specific to the timing diagram. The
	 * model may be valid according to the UML specification, but we want it to follow some additional constraints in
	 * the context of a Papyrus timing diagram:
	 * <ul>
	 * <li>A Lifeline's coveredBys must follow the same order as the containing Interaction's fragments
	 * <li>There must be no fragment in a {@link Lifeline} after a {@link DestructionOccurrenceSpecification}
	 * <li>There must always be an {@link OccurrenceSpecification} between two {@link StateInvariant}s in a Lifeline.
	 * </ul>
	 * 
	 * @param interaction
	 *            the Interaction to validate
	 * @param autoCorrection
	 *            whether to fix the model if it is not considered valid for us
	 * @param interactive
	 *            whether to display notifications to the user, and ask for confirmation using dialog boxes
	 * @return whether the Interaction is valid for the Papyrus timing diagram, after potential fixes were applied (if
	 *         <code>autoCorrection</code> is <code>true</code>)
	 */
	public static boolean validate(final Interaction interaction, final boolean autoCorrection, final boolean interactive) {
		final StringBuilder messageBuilder = new StringBuilder();

		// In order to ease the process, "coveredBy" features are reordered according to Interaction.fragments order.
		// autoCorrection is overridden as Lifeline.coveredBy is not ordered in UML
		reorderLifelineCoveredBy(interaction, messageBuilder);

		boolean isDestructionOccurrenceOK = false;
		boolean isOSbetweenSIOK = false;
		for (final Lifeline lifeline : interaction.getLifelines()) {
			// There must be no fragment after a DestructionOccurrence
			isDestructionOccurrenceOK = validateDestructionOccurrence(lifeline, autoCorrection, messageBuilder);
			// There must be an OccurrenceSpecification in between 2 StateInvariants
			isOSbetweenSIOK = validateOSbetweenSI(lifeline, autoCorrection, messageBuilder);
		}

		final Display display = Display.getCurrent();
		if (display != null) {
			final String popupMessage = messageBuilder.toString().trim();
			if (popupMessage.length() > 0) {
				// open a popup to notify the user about validation errors, and fixes that were applied
				final PapyrusAsyncNotificationPopup popup = new PapyrusAsyncNotificationPopup(display, new FormToolkit(display));
				popup.setTitle(Messages.ModelValidationUtils_ModelValidation);
				popup.setText(popupMessage);
				popup.open();
			}
		} else if (interactive) {
			throw new IllegalStateException("This method must be called on the UI thread when executed interactively"); //$NON-NLS-1$
		}

		return isDestructionOccurrenceOK && isOSbetweenSIOK;
	}

	private static void appendMessage(final StringBuilder message, final String string) {
		if (message.length() > 0) {
			// start adding dashes if there is more than one message
			if (message.charAt(0) != '-') {
				final String msg = message.toString();
				message.setLength(0);
				message.append("- ").append(msg); //$NON-NLS-1$
			}
			message.append("\n- "); //$NON-NLS-1$
		}
		message.append(string);
	}

	/**
	 * Reorders the InteractionFragments in the coveredBys of all Lifelines in the given Interaction, so that they are
	 * in the same order as the fragments of the Interaction.
	 * 
	 * @param interaction
	 *            the Interaction whose Lifelines to reorder
	 * @param messageBuilder
	 *            to build a validation message
	 */
	private static void reorderLifelineCoveredBy(final Interaction interaction, final StringBuilder messageBuilder) {
		int reorderCount = 0;
		for (final Lifeline lifeline : interaction.getLifelines()) {
			final EList<InteractionFragment> coveredBy = lifeline.getCoveredBys();
			if (!coveredBy.isEmpty()) {
				final List<InteractionFragment> fragments = filterFragments(interaction.getFragments(), lifeline);
				int indexInFragments = 0;
				for (final InteractionFragment interactionFragment : fragments) {
					final int indexInLifeline = coveredBy.indexOf(interactionFragment);
					if (indexInFragments != indexInLifeline) {
						coveredBy.move(indexInFragments, indexInLifeline);
						reorderCount++;
					}
					indexInFragments++;
				}
			}
		}
		if (reorderCount > 0) {
			appendMessage(messageBuilder, NLS.bind(Messages.ModelValidationUtils_CoveredByFragmentsWereReOrdered, Integer.toString(reorderCount)));
		}
	}

	/**
	 * Return the sublist of the given fragments covered by the given Lifeline.
	 * 
	 * @param fragments
	 *            the fragments list to filter
	 * @param lifeline
	 *            the Lifeline which must be covered by the returned fragments
	 * @return the filtered list of fragments that cover the Lifeline
	 */
	private static List<InteractionFragment> filterFragments(final EList<InteractionFragment> fragments, final Lifeline lifeline) {
		final List<InteractionFragment> result = new ArrayList<InteractionFragment>();
		for (final InteractionFragment interactionFragment : fragments) {
			if (interactionFragment.getCovereds().contains(lifeline)) {
				result.add(interactionFragment);
			}
		}
		return result;
	}

	private static boolean validateDestructionOccurrence(final Lifeline lifeline, final boolean autoCorrection, final StringBuilder messageBuilder) {
		int wrongFragmentsFound = 0;
		int wrongFragmentsRemoved = 0;

		final ListIterator<InteractionFragment> listIterator = lifeline.getCoveredBys().listIterator();
		boolean afterDestructionOccurrenceSpecification = false;
		while (listIterator.hasNext()) {
			final InteractionFragment fragment = listIterator.next();
			if (afterDestructionOccurrenceSpecification) {
				if (autoCorrection) {
					listIterator.remove();
					wrongFragmentsRemoved++;
				} else {
					wrongFragmentsFound++;
				}
			}
			if (fragment instanceof DestructionOccurrenceSpecification) {
				afterDestructionOccurrenceSpecification = true;
			}
		}

		if (wrongFragmentsFound > 0) {
			appendMessage(messageBuilder,
					NLS.bind(Messages.ModelValidationUtils_FragmentsFoundAfterDestructionOccurrenceSpecification, Integer.toString(wrongFragmentsFound)));
		}
		if (wrongFragmentsRemoved > 0) {
			appendMessage(messageBuilder,
					NLS.bind(Messages.ModelValidationUtils_FragmentsRemovedAfterDestructionOccurrenceSpecification, Integer.toString(wrongFragmentsRemoved)));
		}

		return wrongFragmentsFound == 0;
	}

	private static boolean validateOSbetweenSI(final Lifeline lifeline, final boolean autoCorrection, final StringBuilder messageBuilder) {

		final List<InteractionFragment> coveredBys = lifeline.getCoveredBys();
		int missingOccurrences = 0;
		final Map<OccurrenceSpecification, Integer> occurencesToBeAdded = new LinkedHashMap<OccurrenceSpecification, Integer>();
		InteractionFragment previousElement = null;
		int offset = 0;
		for (final InteractionFragment interactionFragment : coveredBys) {
			if (interactionFragment instanceof StateInvariant && previousElement instanceof StateInvariant) {
				if (autoCorrection) {
					final OccurrenceSpecification occurrence = UMLFactory.eINSTANCE.createOccurrenceSpecification();
					OccurrenceSpecificationUtils.setAutogeneratedName(occurrence, true);
					occurencesToBeAdded.put(occurrence, Integer.valueOf(coveredBys.indexOf(interactionFragment) + offset++));
				} else {
					missingOccurrences++;
				}
			}
			previousElement = interactionFragment;
		}
		if (!occurencesToBeAdded.isEmpty()) {
			for (final Entry<OccurrenceSpecification, Integer> entry : occurencesToBeAdded.entrySet()) {
				final OccurrenceSpecification occurrence = entry.getKey();
				final int indexInCoveredBys = entry.getValue().intValue();
				// Element must be a StateInvariant
				final StateInvariant stateInvariant = (StateInvariant) lifeline.getCoveredBys().get(indexInCoveredBys);

				// insert the OccurrenceSpecification before the StateInvariant in the Lifeline's coveredBys
				lifeline.getCoveredBys().add(indexInCoveredBys, occurrence);

				final EList<InteractionFragment> fragments = lifeline.getInteraction().getFragments();
				final int indexInFragments = fragments.indexOf(stateInvariant);

				// insert the OccurrenceSpecification before the StateInvariant in the Interaction's fragments
				fragments.add(indexInFragments, occurrence);

				String previousName = null;
				if (indexInCoveredBys > 0) {
					final InteractionFragment previousFragment = lifeline.getCoveredBys().get(indexInCoveredBys - 1);
					if (previousFragment instanceof StateInvariant) {
						final StateInvariant previousStateInvariant = (StateInvariant) previousFragment;
						previousName = previousStateInvariant.getName();
					}
				}

				String followingName = stateInvariant.getName();
				if (previousName == null) {
					previousName = "<unnamed>"; //$NON-NLS-1$
				}
				if (followingName == null) {
					followingName = "<unnamed>"; //$NON-NLS-1$
				}
				occurrence.setName(previousName + "_To_" + followingName); //$NON-NLS-1$ 
			}
			appendMessage(messageBuilder,
					NLS.bind(Messages.ModelValidationUtils_MissingOccurrenceSpecificationAdded, Integer.valueOf(occurencesToBeAdded.size())));
		}

		if (missingOccurrences > 0) {
			appendMessage(messageBuilder, NLS.bind(Messages.ModelValidationUtils_MissingOccurrenceSpecificationFound, Integer.valueOf(missingOccurrences)));
		}
		return missingOccurrences == 0;
	}
}
