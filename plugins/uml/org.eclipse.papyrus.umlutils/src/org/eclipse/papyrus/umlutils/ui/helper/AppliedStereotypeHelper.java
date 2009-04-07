/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.umlutils.ui.helper;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.command.AddAppliedQNStereotypeToDisplayCommand;
import org.eclipse.papyrus.umlutils.ui.command.AddAppliedStereotypePropertiesToDisplayCommand;
import org.eclipse.papyrus.umlutils.ui.command.AddAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.umlutils.ui.command.RemoveAppliedStereotypePropertiesToDisplayCommand;
import org.eclipse.papyrus.umlutils.ui.command.RemoveAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.umlutils.ui.command.SetAppliedStereotypeToDisplayCommand;

public class AppliedStereotypeHelper {

	/**
	 * get the list of stereotype to display from the eannotation
	 * 
	 * @return the list of stereotypes to display separated by a comma. the applied stereotype to display is represented by the qualified name of the stereotype
	 */
	public static String getStereotypesToDisplay(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if (stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String stereotypesToDisplay = entries.get(VisualInformationPapyrusConstant.STEREOTYPE_LIST);
			if (stereotypesToDisplay != null) {
				return stereotypesToDisplay;
			}
		}
		return "";
	}

	public static String getAppliedStereotypesPropertiesToDisplay(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if (stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String stereotypesToDisplay = entries.get(VisualInformationPapyrusConstant.PROPERTY_STEREOTYPE_DISPLAY);
			if (stereotypesToDisplay != null) {
				return stereotypesToDisplay;
			}
		}
		return "";
	}

	/**
	 * get lhe list of stereotype to display with the qulifiedName
	 * 
	 * @param view
	 *            the view of the uml element
	 * @return the list of applied stereotype to display withe their qualified name
	 */
	public static String getStereotypesQNToDisplay(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if (stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String stereotypesToDisplay = entries.get(VisualInformationPapyrusConstant.STEREOTYPE_WITHQN_LIST);
			if (stereotypesToDisplay != null) {
				return stereotypesToDisplay;
			}
		}
		return "";
	}

	/**
	 * return the kind of display of applied stereotype
	 * 
	 * @param view
	 *            that contains the eannotation about the display
	 * @return VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION, VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION,
	 *         VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION, VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION,
	 *         VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION
	 */
	public static String getAppliedStereotypePresentationKind(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if (stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();
			String stereotypespresentationKind = entries.get(VisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND);
			if (stereotypespresentationKind != null) {
				return stereotypespresentationKind;
			}
		}
		return VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
	}

	/**
	 * Gets the applied.
	 * 
	 * @param domain
	 *            the domain
	 * @param view
	 *            the view
	 * @param appliedStereotypeList
	 *            the applied stereotype list
	 * @param presentationKind
	 *            see {@link VisualInformationPapyrusConstant} for the kind of presentation
	 * 
	 * @return the applied
	 */
	public static RecordingCommand getAppliedStereotypeToDisplayCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeList, String presentationKind) {
		return new SetAppliedStereotypeToDisplayCommand(domain, view, appliedStereotypeList, presentationKind);
	}

	/**
	 * add new applied stereotypes to display withe the qualified name
	 * 
	 * @param domain
	 *            the transactionnal edit domain
	 * @param view
	 *            the emodel element that is the display of the uml element
	 * @param appliedStereotypeList
	 *            the list of stereotype with qualified name to display
	 * @return the command to display it
	 */
	public static RecordingCommand getAddAppliedStereotypeToDisplayWithQNCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeList) {
		return new AddAppliedQNStereotypeToDisplayCommand(domain, view, appliedStereotypeList);
	}

	/**
	 * Gets the adds the applied stereotype command.
	 * 
	 * @param domain
	 *            the domain
	 * @param view
	 *            the view
	 * @param appliedStereotypeListToAdd
	 *            the applied stereotype list to add
	 * @param presentationKind
	 *            the presentation kind
	 * 
	 * @return the adds the applied stereotype command
	 */
	public static RecordingCommand getAddAppliedStereotypeCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeListToAdd, String presentationKind) {
		return new AddAppliedStereotypeToDisplayCommand(domain, view, appliedStereotypeListToAdd, presentationKind);
	}

	/**
	 * Gets the adds the applied stereotype propertiescommand.
	 * 
	 * @param domain
	 *            the domain
	 * @param view
	 *            the view
	 * @param appliedStereotypeListToAdd
	 *            the applied stereotype properties list to add
	 * 
	 * @return the adds the applied stereotype command
	 */
	public static RecordingCommand getAddAppliedStereotypePropertiesCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeListToAdd) {
		return new AddAppliedStereotypePropertiesToDisplayCommand(domain, view, appliedStereotypeListToAdd);
	}

	/**
	 * Gets the removes the applied stereotype command.
	 * 
	 * @param domain
	 *            the domain
	 * @param view
	 *            the view
	 * @param appliedStereotypeListToRemove
	 *            the applied stereotype list to remove
	 * @param presentationKind
	 *            the presentation kind
	 * 
	 * @return the removes the applied stereotype command
	 */
	public static RecordingCommand getRemoveAppliedStereotypeCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeListToRemove, String presentationKind) {
		return new RemoveAppliedStereotypeToDisplayCommand(domain, view, appliedStereotypeListToRemove, presentationKind);
	}

	/**
	 * 
	 * @param domain
	 * @param view
	 * @param appliedStereotypeListToRemove
	 * @return
	 */
	public static RecordingCommand getRemoveAppliedStereotypePropertiesCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeListToRemove) {
		return new RemoveAppliedStereotypePropertiesToDisplayCommand(domain, view, appliedStereotypeListToRemove);
	}
}
