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
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.appearance.helper;

import java.util.StringTokenizer;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.appearance.commands.AddAppliedQNStereotypeToDisplayCommand;
import org.eclipse.papyrus.uml.appearance.commands.AddAppliedStereotypePropertiesToDisplayCommand;
import org.eclipse.papyrus.uml.appearance.commands.AddAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.uml.appearance.commands.RemoveAppliedStereotypePropertiesToDisplayCommand;
import org.eclipse.papyrus.uml.appearance.commands.RemoveAppliedStereotypeToDisplayCommand;
import org.eclipse.papyrus.uml.appearance.commands.SetAppliedStereotypePropertiesLocalizationCommand;
import org.eclipse.papyrus.uml.appearance.commands.SetAppliedStereotypeToDisplayCommand;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class AppliedStereotypeHelper.
 */
public class AppliedStereotypeHelper {

	/**
	 * get the list of stereotype to display from the eannotation.
	 * 
	 * @param view
	 *        the view
	 * 
	 * @return the list of stereotypes to display separated by a comma. the applied stereotype to
	 *         display is represented by the qualified name of the stereotype
	 */
	public static String getStereotypesToDisplay(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String stereotypesToDisplay = entries.get(UMLVisualInformationPapyrusConstant.STEREOTYPE_LIST);
			if(stereotypesToDisplay != null) {
				return stereotypesToDisplay;
			}
		}
		return "";
	}

	/**
	 * Gets the applied stereotypes properties to display.
	 * 
	 * @param view
	 *        the view the view that displays the stereotyped element
	 * 
	 * @return the applied stereotypes properties to display
	 */
	public static String getAppliedStereotypesPropertiesToDisplay(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String stereotypesToDisplay = entries.get(UMLVisualInformationPapyrusConstant.PROPERTY_STEREOTYPE_DISPLAY);
			if(stereotypesToDisplay != null) {
				return stereotypesToDisplay;
			}
		}
		return "";
	}

	/**
	 * checks if the applied stereotypes properties have to be displayed.
	 * 
	 * @param view
	 *        the view the view that displays the stereotyped element
	 * @param location
	 *        the location where the properties have to be displayed.
	 * 
	 * @return <code>true</code> if the applied stereotypes properties have to display, <code>false</code> in other case
	 */
	public static boolean hasAppliedStereotypesPropertiesToDisplay(EModelElement view, String location) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String placeToDisplay = entries.get(UMLVisualInformationPapyrusConstant.STEREOTYPE_PROPERTY_LOCATION);
			if(placeToDisplay != null && placeToDisplay.equals(location)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the applied stereotypes properties localization.
	 * 
	 * @param view
	 *        the view
	 * 
	 * @return the applied stereotypes properties localization
	 */
	public static String getAppliedStereotypesPropertiesLocalization(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String displayLocalization = entries.get(UMLVisualInformationPapyrusConstant.STEREOTYPE_PROPERTY_LOCATION);
			if(displayLocalization != null && !displayLocalization.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION)) {
				return displayLocalization;
			}
		}

		//CSS Value (TODO : Remove this dependency ; add an extension point)

		//		if(view instanceof UMLCustomStyle) {
		//			UMLCustomStyle cssElement = (UMLCustomStyle)view;
		//			return cssElement.getCSSDisplayPlace();
		//		}

		return UMLVisualInformationPapyrusConstant.STEREOTYPE_COMPARTMENT_LOCATION;
	}

	/**
	 * get lhe list of stereotype to display with the qulifiedName.
	 * 
	 * @param view
	 *        the view of the uml element
	 * 
	 * @return the list of applied stereotype to display withe their qualified name
	 */
	public static String getStereotypesQNToDisplay(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();

			String stereotypesToDisplay = entries.get(UMLVisualInformationPapyrusConstant.STEREOTYPE_WITHQN_LIST);
			if(stereotypesToDisplay != null) {
				return stereotypesToDisplay;
			}
		}
		return "";
	}

	/**
	 * return the kind of display of applied stereotype.
	 * 
	 * @param view
	 *        that contains the eannotation about the display
	 * 
	 * @return VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION,
	 *         VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION,
	 *         VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION,
	 *         VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION,
	 *         VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION
	 */
	public static String getAppliedStereotypePresentationKind(EModelElement view) {
		EAnnotation stereotypeDisplayKind = view.getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(stereotypeDisplayKind != null) {
			EMap<String, String> entries = stereotypeDisplayKind.getDetails();
			String stereotypespresentationKind = entries.get(UMLVisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND);
			if(stereotypespresentationKind != null) {
				if(!(stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION) || stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION))) {
					return stereotypespresentationKind;
				}
			}
		}

		//CSS Value (TODO : Remove this dependency ; add an extension point)

		//		if(view instanceof UMLCustomStyle) {
		//			UMLCustomStyle cssElement = (UMLCustomStyle)view;
		//			String display = cssElement.getCSSStereotypeDisplay();
		//
		//			if(display != null) {
		//				if(display.equals("Text")) {
		//					String alignment = cssElement.getCSSTextAlignment();
		//					if(alignment.equals("Vertical")) {
		//						return VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION;
		//					}
		//					return VisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
		//				} else if("Text and Icon".equals(display)) {
		//					return VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION;
		//				} else if("Icon".equals(display)) {
		//					return VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION;
		//				} else if("Shape".equals(display)) {
		//					return VisualInformationPapyrusConstant.IMAGE_STEREOTYPE_PRESENTATION;
		//				}
		//			}
		//		}

		return UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_HORIZONTAL_PRESENTATION;
	}

	/**
	 * Gets the applied.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * @param appliedStereotypeList
	 *        the applied stereotype list
	 * @param presentationKind
	 *        see {@link UMLVisualInformationPapyrusConstant} for the kind of presentation
	 * 
	 * @return the applied
	 */
	public static RecordingCommand getAppliedStereotypeToDisplayCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeList, String presentationKind) {
		return new SetAppliedStereotypeToDisplayCommand(domain, view, appliedStereotypeList, presentationKind);
	}

	/**
	 * add new applied stereotypes to display withe the qualified name.
	 * 
	 * @param domain
	 *        the transactionnal edit domain
	 * @param view
	 *        the emodel element that is the display of the uml element
	 * @param appliedStereotypeList
	 *        the list of stereotype with qualified name to display
	 * 
	 * @return the command to display it
	 */
	public static RecordingCommand getAddAppliedStereotypeToDisplayWithQNCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeList) {
		return new AddAppliedQNStereotypeToDisplayCommand(domain, view, appliedStereotypeList);
	}

	/**
	 * Gets the adds the applied stereotype command.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * @param appliedStereotypeListToAdd
	 *        the applied stereotype list to add
	 * @param presentationKind
	 *        the presentation kind
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
	 *        the domain
	 * @param view
	 *        the view
	 * @param appliedStereotypeListToAdd
	 *        the applied stereotype properties list to add
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
	 *        the domain
	 * @param view
	 *        the view
	 * @param appliedStereotypeListToRemove
	 *        the applied stereotype list to remove
	 * @param presentationKind
	 *        the presentation kind
	 * 
	 * @return the removes the applied stereotype command
	 */
	public static RecordingCommand getRemoveAppliedStereotypeCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeListToRemove, String presentationKind) {
		return new RemoveAppliedStereotypeToDisplayCommand(domain, view, appliedStereotypeListToRemove, presentationKind);
	}

	/**
	 * Gets the remove applied stereotype properties command.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * @param appliedStereotypeListToRemove
	 *        the applied stereotype list to remove
	 * 
	 * @return the removes the applied stereotype properties command
	 */
	public static RecordingCommand getRemoveAppliedStereotypePropertiesCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypeListToRemove) {
		return new RemoveAppliedStereotypePropertiesToDisplayCommand(domain, view, appliedStereotypeListToRemove);
	}

	/**
	 * Gets the sets the applied stereotype properties localization command.
	 * 
	 * @param domain
	 *        the domain
	 * @param view
	 *        the view
	 * @param appliedStereotypePropertiesLocation
	 *        the applied stereotype properties location
	 * 
	 * @return the sets the applied stereotype properties localization command
	 */
	public static RecordingCommand getSetAppliedStereotypePropertiesLocalizationCommand(TransactionalEditingDomain domain, EModelElement view, String appliedStereotypePropertiesLocation) {
		return new SetAppliedStereotypePropertiesLocalizationCommand(domain, view, appliedStereotypePropertiesLocation);
	}

	/**
	 * 
	 * @param model
	 * @param element
	 * @return
	 */
	public static Stereotype getFirstDisplayedStereotype(EModelElement model, Element element) {
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(model);
		StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
		if(tokenizer.hasMoreTokens()) {
			String firstStereotypeName = tokenizer.nextToken();
			Stereotype stereotype = element.getAppliedStereotype(firstStereotypeName);
			return stereotype;
		}
		return null;
	}
}
