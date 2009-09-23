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
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.umlutils.StereotypeUtil;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Helper class for labels for elements that can have stereotypes
 */
public abstract class StereotypedElementLabelHelper {

	/**
	 * {@inheritDoc}
	 */
	public Element getUMLElement(GraphicalEditPart editPart) {
		return (Element) ((View) editPart.getModel()).getElement();
	}

	/**
	 * Parses the string containing the complete definition of properties to be displayed, and
	 * generates a map.
	 * 
	 * @param editPart
	 *            the edit part for which the label is edited
	 * @param stereotypesToDisplay
	 *            the list of stereotypes to display
	 * @param stereotypesPropertiesToDisplay
	 *            the properties of stereotypes to display
	 * @return a map. The keys are the name of displayed stereotypes, the corresponding data is a
	 *         collection of its properties to be displayed
	 */
	protected Map<String, List<String>> parseStereotypeProperties(GraphicalEditPart editPart,
			String stereotypesToDisplay, String stereotypesPropertiesToDisplay) {
		Map<String, List<String>> propertiesMap = new HashMap<String, List<String>>();

		StringTokenizer stringTokenizer = new StringTokenizer(stereotypesPropertiesToDisplay,
				VisualInformationPapyrusConstant.STEREOTYPE_PROPERTIES_LIST_SEPARATOR);
		while (stringTokenizer.hasMoreTokens()) {
			String propertyName = stringTokenizer.nextToken();
			// retrieve the name of the stereotype for this property
			String stereotypeName = propertyName.substring(0, propertyName.lastIndexOf(".")); // stereotypequalifiedName.propertyname
			if (!propertiesMap.containsKey(stereotypeName)) {
				List<String> propertiesForStereotype = new ArrayList<String>();
				propertiesMap.put(stereotypeName, propertiesForStereotype);
			}
			propertiesMap.get(stereotypeName).add(
					propertyName.substring(propertyName.lastIndexOf(".") + 1, propertyName.length()));
		}
		return propertiesMap;
	}

	/**
	 * Returns the image to be displayed for the applied stereotypes.
	 * 
	 * @return the image that represents the first applied stereotype or <code>null</code> if no
	 *         image has to be displayed
	 */
	public Collection<Image> stereotypeIconsToDisplay(GraphicalEditPart editPart) {
		String stereotypespresentationKind = AppliedStereotypeHelper
				.getAppliedStereotypePresentationKind((View) editPart.getModel());
		if (stereotypespresentationKind == null) {
			return null;
		}
		if (stereotypespresentationKind.equals(VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION)
				|| stereotypespresentationKind
						.equals(VisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION)) {

			// retrieve the first stereotype in the list of displayed stereotype
			String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View) editPart.getModel());
			Collection<Stereotype> stereotypes = new ArrayList<Stereotype>();
			StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
			while (tokenizer.hasMoreTokens()) {
				String firstStereotypeName = tokenizer.nextToken();
				stereotypes.add(getUMLElement(editPart).getAppliedStereotype(firstStereotypeName));
			}
			return Activator.getIconElements(getUMLElement(editPart), stereotypes, false);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a String that displays stereotypes (using their simple name or their qualified name)
	 * and their properties
	 * 
	 * @param editPart
	 *            the edit part for which the label is edited
	 * @param separator
	 *            the separator used to split the string representing the stereotypes.
	 * @param stereotypesToDisplay
	 *            the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName
	 *            the list of stereotypes displayed using their qualified names
	 * @param stereotypesPropertiesToDisplay
	 *            the list of properties to display
	 * @return a string that displays stereotypes (using their simple name or their qualified name)
	 *         and their properties
	 */
	public String stereotypesAndPropertiesToDisplay(GraphicalEditPart editPart, String separator,
			String stereotypesToDisplay, String stereotypeWithQualifiedName, String stereotypesPropertiesToDisplay) {
		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		assert store != null : "The preference store was not found";
		if (store == null) {
			return "";
		}
		// retrieve if the name of the stereotype has to put to lower case or not
		String sNameAppearance = store.getString(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		// changes the string of properties into a map, where the entries of the map are the
		// stereotype qualified name, and the properties to display are the data
		Map<String, List<String>> propertiesToDisplay = parseStereotypeProperties(editPart, stereotypesToDisplay,
				stereotypesPropertiesToDisplay);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while (strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement(editPart);
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if (stereotype != null) {
				String name = currentStereotype;
				if ((stereotypeWithQualifiedName.indexOf(currentStereotype)) == -1) {
					// property value contains qualifiedName ==> extract name from it
					StringTokenizer strToken = new StringTokenizer(currentStereotype, "::");

					while (strToken.hasMoreTokens()) {
						name = strToken.nextToken();
					}
				}
				// AL Changes Feb. 07 - Beg
				// Handling STEREOTYPE_NAME_APPEARANCE preference (from
				// ProfileApplicationPreferencePage)
				// Previously lowercase forced onto first letter (standard UML)
				// stereotypesToDisplay = stereotypesToDisplay+name.substring(0,
				// 1).toLowerCase()+name.substring(1, name.length())+","+separator;

				// check that the name has not already been added to the displayed string
				if (sNameAppearance.equals(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
					if (out.indexOf(name) == -1) {
						out = out + Activator.ST_LEFT + name + Activator.ST_RIGHT + separator;
					}
				} else { // VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM))
					// {
					name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
					if (out.indexOf(name) == -1) {
						out = out + Activator.ST_LEFT + name + Activator.ST_RIGHT + separator;
					}
				}

				// now should add all properties associated to this stereotype
				List<String> properties = propertiesToDisplay.get(stereotype.getQualifiedName());
				if (properties != null) {
					// retrieve property
					for (String propertyName : properties) {
						out = out
								+ StereotypeUtil.displayPropertyValue(stereotype, StereotypeUtil.getPropertyByName(
										stereotype, propertyName), getUMLElement(editPart), " ");
					}
				}
			}
		}
		if (out.endsWith(",")) {
			return out.substring(0, out.length() - 1);
		}
		if (out.endsWith(separator)) {
			return out.substring(0, out.length() - separator.length());
		}
		return out;
	}

	/**
	 * get the list of stereotype to display from the eannotation
	 * 
	 * @return the list of stereotypes to display
	 */
	public String stereotypesToDisplay(GraphicalEditPart editPart) {
		View view = (View) editPart.getModel();
		// retrieve all stereotypes to be displayed

		// try to display stereotype properties
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(view);
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay(view);
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind(view);

		// now check presentation.
		// if horizontal => equivalent to the inBrace visualization in nodes (i.e. only name =
		// value, separator = comma, delimited with brace
		// if vertical => equivalent to compartment visualization name of stereotype, NL, property =
		// value, NL, etC.

		// check the presentation kind. if only icon => do not display stereotype, only values
		if (VisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getUMLElement(editPart));
		}

		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(view);
		String display = "";
		if (VisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			display += stereotypesAndPropertiesToDisplay(editPart, "\n", stereotypesToDisplay,
					stereotypesToDisplayWithQN, stereotypesPropertiesToDisplay);
		} else {
			final String st = stereotypesToDisplay(editPart, ", ", stereotypesToDisplay, stereotypesToDisplayWithQN);
			if (st != null && !st.equals("")) {
				display += Activator.ST_LEFT + st + Activator.ST_RIGHT + " ";
			}
			final String propSt = StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay,
					getUMLElement(editPart));
			if (propSt != null && !propSt.equals("")) {
				if (st != null && !st.equals("")) {
					// display += "\n";
				}
				display += "{" + propSt + "} ";
			}
		}
		return display;
	}

	/**
	 * Computes the string that displays the stereotypes for the current element
	 * 
	 * @param separator
	 *            the separator used to split the string representing the stereotypes.
	 * @param stereotypesToDisplay
	 *            the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName
	 *            the list of stereotypes displayed using their qualified names
	 * @return the string that represent the stereotypes
	 */
	public String stereotypesToDisplay(GraphicalEditPart editPart, String separator, String stereotypesToDisplay,
			String stereotypeWithQualifiedName) {

		// AL Changes Feb. 07 - Beg
		// Style Handling for STEREOTYPE_NAME_APPEARANCE from ProfileApplicationPreferencePage
		// Stereotype displayed according to UML standard (first letter forced to lower case) -
		// default -
		// or kept as entered by user (user controlled)

		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		assert store != null : "The preference store was not found";
		if (store == null) {
			return "";
		}
		String sNameAppearance = store.getString(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while (strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement(editPart);
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if (stereotype != null) {
				String name = currentStereotype;
				if ((stereotypeWithQualifiedName.indexOf(currentStereotype)) == -1) {
					// property value contains qualifiedName ==> extract name from it
					StringTokenizer strToken = new StringTokenizer(currentStereotype, "::");

					while (strToken.hasMoreTokens()) {
						name = strToken.nextToken();
					}
				}
				// AL Changes Feb. 07 - Beg
				// Handling STEREOTYPE_NAME_APPEARANCE preference (from
				// ProfileApplicationPreferencePage)
				// Previously lowercase forced onto first letter (standard UML)
				// stereotypesToDisplay = stereotypesToDisplay+name.substring(0,
				// 1).toLowerCase()+name.substring(1, name.length())+","+separator;

				// check that the name has not already been added to the displayed string
				if (sNameAppearance.equals(VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
					if (out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				} else { // VisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM))
					// {
					name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
					if (out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				}
			}
		}
		if (out.endsWith(",")) {
			return out.substring(0, out.length() - 1);
		}
		if (out.endsWith(separator)) {
			return out.substring(0, out.length() - separator.length());
		}
		return out;
	}

}
