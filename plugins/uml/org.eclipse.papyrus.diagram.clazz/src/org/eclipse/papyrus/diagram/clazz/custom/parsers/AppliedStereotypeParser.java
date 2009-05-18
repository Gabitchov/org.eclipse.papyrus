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
package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.Usage;

/**
 * this the parser used to manage applied stereotype
 * 
 * @author Patrick Tessier
 */
public class AppliedStereotypeParser implements IParser {

	protected final String stereoBegin = "\u00AB";

	protected final String stereoEnd = "\u00BB";

	/**
	 * 
	 * {@inheritDoc}
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getEditString(IAdaptable element, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public ICommand getParseCommand(IAdaptable element, String newString,
			int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public String getPrintString(IAdaptable element, int flags) {

		if (element instanceof EObjectAdapter) {
			return stereotypesToDisplay(" ",
					(Element) ((EObjectAdapter) element).getRealObject());
		}
		return null;

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
	public IParserEditStatus isValidEditString(IAdaptable element,
			String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * get the list of stereotype to display.To modify by taking account
	 * preferences of stereotype display
	 * 
	 * @param separator
	 *            " " or "/n" for example
	 * @param umlElement
	 *            the uml element on which stereotype are displayed
	 * @return the lis of sterotype to display
	 */
	public String stereotypesToDisplay(String separator, Element umlElement) {
		String stereotypesToDisplay = "";

		// AL Changes Feb. 07 - Beg
		// Style Handling for STEREOTYPE_NAME_APPEARANCE from
		// ProfileApplicationPreferencePage
		// Stereotype displayed according to UML standard (first letter forced
		// to lower case) - default -
		// or kept as entered by user (user controlled)

		// Get the preference from PreferenceStore
		// IPreferenceStore store =
		// PapyrusPlugin.getDefault().getPreferenceStore();
		// String sNameAppearance =
		// store.getString(ProfileApplicationPreferenceConstants.P_STEREOTYPE_NAME_APPEARANCE);

		// AL Changes Feb. 07 - End
		// TODO: remove this and replace by figurelabel
		// Particular cases
		if (umlElement instanceof Signal) {
			stereotypesToDisplay = "signal," + separator;
		} else if (umlElement instanceof Enumeration) {
			stereotypesToDisplay = "enumeration," + separator;
		} else if (umlElement instanceof DataType
				&& !(umlElement instanceof PrimitiveType)) {
			stereotypesToDisplay = "dataType," + separator;
		} else if (umlElement instanceof PrimitiveType
				&& !(umlElement instanceof DataType)) {
			stereotypesToDisplay = "primitiveType," + separator;
		} else if (umlElement instanceof Interface) {
			stereotypesToDisplay = "interface," + separator;
		} else if (umlElement instanceof Reception) {
			stereotypesToDisplay = "signal," + separator;
		} else if (umlElement instanceof Model) {
			stereotypesToDisplay = "model," + separator;
		} else if (umlElement instanceof Profile) {
			stereotypesToDisplay = "profile," + separator;
		} else if (umlElement instanceof Stereotype) {
			stereotypesToDisplay = "stereotype," + separator;
		} else if (umlElement instanceof Component) {
			stereotypesToDisplay = "component," + separator;
		} else if (umlElement instanceof Substitution) {
			stereotypesToDisplay = "substitute," + separator;
		} else if (umlElement instanceof Abstraction
				&& !(umlElement instanceof Realization)) {
			stereotypesToDisplay = "abstraction," + separator;
		} else if (umlElement instanceof PackageImport) {
			stereotypesToDisplay = "import," + separator;
		} else if (umlElement instanceof PackageMerge) {
			stereotypesToDisplay = "merge," + separator;
		} else if (umlElement instanceof Usage) {
			stereotypesToDisplay = "use," + separator;
		}

		Iterator<Stereotype> iterStereotype = (umlElement)
				.getAppliedStereotypes().iterator();
		while (iterStereotype.hasNext()) {
			stereotypesToDisplay = iterStereotype.next().getLabel();
			stereotypesToDisplay += "," + separator;
		}

		if (!(stereotypesToDisplay.equals(""))) {
			return stereoBegin
					+ stereotypesToDisplay.substring(0, stereotypesToDisplay
							.length() - 2) + stereoEnd;
		}

		return " ";
	}
}
