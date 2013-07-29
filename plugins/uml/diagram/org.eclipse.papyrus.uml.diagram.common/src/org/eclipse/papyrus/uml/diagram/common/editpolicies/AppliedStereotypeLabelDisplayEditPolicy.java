/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Specific edit policy for label displaying stereotypes and their properties
 * for edges representing UML elements.
 * <p>
 * It also displays the tag for the links, for example "use" for {@link Usage}.
 * 
 */
public abstract class AppliedStereotypeLabelDisplayEditPolicy extends AbstractAppliedStereotypeDisplayEditPolicy {

	/** constant for this edit policy role */
	public final static String STEREOTYPE_LABEL_POLICY = "AppliedStereotypeLabelDisplayEditPolicy";

	/** tag displayed for the UML element */
	public String tag;

	/**
	 * Creates a new AppliedStereotypeLabelDisplayEditPolicy, with the specified
	 * tag for the element.
	 * 
	 * @param tag
	 *        the tag for element, for example "use" for {@link Usage}.
	 */
	public AppliedStereotypeLabelDisplayEditPolicy(String tag) {
		super();
		this.tag = Activator.ST_LEFT + tag + Activator.ST_RIGHT;
	}

	/**
	 * Creates a new AppliedStereotypeLabelDisplayEditPolicy, with no tag for
	 * the element.
	 */
	public AppliedStereotypeLabelDisplayEditPolicy() {
		super();
		this.tag = "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		refreshStereotypeDisplay();
	}

	/**
	 * Refreshes the stereotype display
	 */
	protected abstract void refreshStereotypeDisplay();

	/**
	 * Returns the image to be displayed for the applied stereotypes.
	 * 
	 * @return the image that represents the first applied stereotype or <code>null</code> if no image has to be displayed
	 */
	public Image stereotypeIconToDisplay() {
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)getHost().getModel());
		if(stereotypespresentationKind == null) {
			return null;
		}
		if(stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION) || stereotypespresentationKind.equals(UMLVisualInformationPapyrusConstant.TEXT_ICON_STEREOTYPE_PRESENTATION)) {

			// retrieve the first stereotype in the list of displayed stereotype
			String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getHost().getModel());
			StringTokenizer tokenizer = new StringTokenizer(stereotypesToDisplay, ",");
			if(tokenizer.hasMoreTokens()) {
				String firstStereotypeName = tokenizer.nextToken();
				Stereotype stereotype = getUMLElement().getAppliedStereotype(firstStereotypeName);
				return Activator.getIconElement(getUMLElement(), stereotype, false);
			}
		}
		return null;
	}

	/**
	 * Returns a String that displays stereotypes (using their simple name or
	 * their qualified name) and their properties
	 * 
	 * @param separator
	 *        the separator used to split the string representing the
	 *        stereotypes.
	 * @param stereotypesToDisplay
	 *        the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName
	 *        the list of stereotypes displayed using their qualified names
	 * @param stereotypesPropertiesToDisplay
	 *        the list of properties to display
	 * @return a string that displays stereotypes (using their simple name or
	 *         their qualified name) and their properties
	 */
	public String stereotypesAndPropertiesToDisplay(String separator, String stereotypesToDisplay, String stereotypeWithQualifiedName, String stereotypesPropertiesToDisplay) {
		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		assert store != null : "The preference store was not found";
		if(store == null) {
			return "";
		}
		// retrieve if the name of the stereotype has to put to lower case or
		// not
		String sNameAppearance = store.getString(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		// changes the string of properties into a map, where the entries of the
		// map are the
		// stereotype qualified name, and the properties to display are the data
		Map<String, List<String>> propertiesToDisplay = parseStereotypeProperties(stereotypesToDisplay, stereotypesPropertiesToDisplay);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while(strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement();
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if(stereotype != null) {
				String name = currentStereotype;
				if((stereotypeWithQualifiedName.indexOf(currentStereotype)) == -1) {
					// property value contains qualifiedName ==> extract name
					// from it
					StringTokenizer strToken = new StringTokenizer(currentStereotype, "::");

					while(strToken.hasMoreTokens()) {
						name = strToken.nextToken();
					}
				}
				// AL Changes Feb. 07 - Beg
				// Handling STEREOTYPE_NAME_APPEARANCE preference (from
				// ProfileApplicationPreferencePage)
				// Previously lowercase forced onto first letter (standard UML)
				// stereotypesToDisplay = stereotypesToDisplay+name.substring(0,
				// 1).toLowerCase()+name.substring(1,
				// name.length())+","+separator;

				// check that the name has not already been added to the
				// displayed string
				if(sNameAppearance.equals(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
					if(out.indexOf(name) == -1) {
						out = out + Activator.ST_LEFT + name + Activator.ST_RIGHT + separator;
					}
				} else { // VisualInformationPapyrusConstants.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM))
					// {
					name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
					if(out.indexOf(name) == -1) {
						out = out + Activator.ST_LEFT + name + Activator.ST_RIGHT + separator;
					}
				}

				// now should add all properties associated to this stereotype
				List<String> properties = propertiesToDisplay.get(stereotype.getQualifiedName());
				if(properties != null) {
					// retrieve property
					for(String propertyName : properties) {
						out = out + StereotypeUtil.displayPropertyValue(stereotype, StereotypeUtil.getPropertyByName(stereotype, propertyName), getUMLElement(), "\n");
					}
				}
			}
		}
		if(out.endsWith(",")) {
			return out.substring(0, out.length() - 1);
		}
		if(out.endsWith(separator)) {
			return out.substring(0, out.length() - separator.length());
		}
		return out;
	}

	/**
	 * get the list of stereotype to display from the eannotation
	 * 
	 * @return the list of stereotypes to display
	 */
	public String stereotypesToDisplay() {

		// retrieve all stereotypes to be displayed

		// try to display stereotype properties
		String stereotypesPropertiesToDisplay = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay((View)getHost().getModel());
		String stereotypesToDisplay = AppliedStereotypeHelper.getStereotypesToDisplay((View)getHost().getModel());
		String stereotypespresentationKind = AppliedStereotypeHelper.getAppliedStereotypePresentationKind((View)getHost().getModel());

		// now check presentation.
		// if horizontal => equivalent to the inBrace visualization in nodes
		// (i.e. only name =
		// value, separator = comma, delimited with brace
		// if vertical => equivalent to compartment visualization name of
		// stereotype, NL, property =
		// value, NL, etC.

		// check the presentation kind. if only icon => do not display
		// stereotype, only values
		if(UMLVisualInformationPapyrusConstant.ICON_STEREOTYPE_PRESENTATION.equals(stereotypespresentationKind)) {
			return StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getUMLElement());
		}

		String stereotypesToDisplayWithQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(((View)getHost().getModel()));
		String display = "";
		if(UMLVisualInformationPapyrusConstant.STEREOTYPE_TEXT_VERTICAL_PRESENTATION.equals(stereotypespresentationKind)) {
			display += stereotypesAndPropertiesToDisplay("\n", stereotypesToDisplay, stereotypesToDisplayWithQN, stereotypesPropertiesToDisplay);
		} else {
			final String st = stereotypesToDisplay(", ", stereotypesToDisplay, stereotypesToDisplayWithQN);
			if(st != null && !st.equals("")) {
				display += Activator.ST_LEFT + st + Activator.ST_RIGHT;
			}
			final String propSt = StereotypeUtil.getPropertiesValuesInBrace(stereotypesPropertiesToDisplay, getUMLElement());
			if(propSt != null && !propSt.equals("")) {
				if(st != null && !st.equals("")) {
					display += "\n";
				}
				display += "{" + propSt + "}";
			}
		}
		return display;
	}

	/**
	 * Computes the string that displays the stereotypes for the current element
	 * 
	 * @param separator
	 *        the separator used to split the string representing the
	 *        stereotypes.
	 * @param stereotypesToDisplay
	 *        the list of stereotypes displayed
	 * @param stereotypeWithQualifiedName
	 *        the list of stereotypes displayed using their qualified names
	 * @return the string that represent the stereotypes
	 */
	public String stereotypesToDisplay(String separator, String stereotypesToDisplay, String stereotypeWithQualifiedName) {

		// AL Changes Feb. 07 - Beg
		// Style Handling for STEREOTYPE_NAME_APPEARANCE from
		// ProfileApplicationPreferencePage
		// Stereotype displayed according to UML standard (first letter forced
		// to lower case) -
		// default -
		// or kept as entered by user (user controlled)

		// Get the preference from PreferenceStore. there should be an assert
		final IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		assert store != null : "The preference store was not found";
		if(store == null) {
			return "";
		}
		String sNameAppearance = store.getString(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_APPEARANCE);

		StringTokenizer strQualifiedName = new StringTokenizer(stereotypesToDisplay, ",");
		String out = "";
		while(strQualifiedName.hasMoreElements()) {
			String currentStereotype = strQualifiedName.nextToken();

			// check if current stereotype is applied
			final Element umlElement = getUMLElement();
			Stereotype stereotype = umlElement.getAppliedStereotype(currentStereotype);
			if(stereotype != null) {
				String name = currentStereotype;
				if((stereotypeWithQualifiedName.indexOf(currentStereotype)) == -1) {
					// property value contains qualifiedName ==> extract name
					// from it
					StringTokenizer strToken = new StringTokenizer(currentStereotype, "::");

					while(strToken.hasMoreTokens()) {
						name = strToken.nextToken();
					}
				}
				// AL Changes Feb. 07 - Beg
				// Handling STEREOTYPE_NAME_APPEARANCE preference (from
				// ProfileApplicationPreferencePage)
				// Previously lowercase forced onto first letter (standard UML)
				// stereotypesToDisplay = stereotypesToDisplay+name.substring(0,
				// 1).toLowerCase()+name.substring(1,
				// name.length())+","+separator;

				// check that the name has not already been added to the
				// displayed string
				if(sNameAppearance.equals(UMLVisualInformationPapyrusConstant.P_STEREOTYPE_NAME_DISPLAY_USER_CONTROLLED)) {
					if(out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				} else { // VisualInformationPapyrusConstants.P_STEREOTYPE_NAME_DISPLAY_UML_CONFORM))
					// {
					name = name.substring(0, 1).toLowerCase() + name.substring(1, name.length());
					if(out.indexOf(name) == -1) {
						out = out + name + separator;
					}
				}
			}
		}
		if(out.endsWith(",")) {
			return out.substring(0, out.length() - 1);
		}
		if(out.endsWith(separator)) {
			return out.substring(0, out.length() - separator.length());
		}
		return out;
	}
}
