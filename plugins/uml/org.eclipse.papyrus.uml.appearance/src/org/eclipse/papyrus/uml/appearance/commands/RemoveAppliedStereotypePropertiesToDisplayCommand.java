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
package org.eclipse.papyrus.uml.appearance.commands;

import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;

/**
 * The Class RemoveAppliedStereotypeToDisplayCommand used to set the list of applied stereotype to
 * display
 */
public class RemoveAppliedStereotypePropertiesToDisplayCommand extends CreateEAnnotationCommand {

	/** The qualified namedepht. */
	private String stereotypePropertiesListToRemove;

	/**
	 * Instantiates a new sets the applied stereotype to display command.
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object
	 * @param stereotypePropertyList
	 *        the stereotype list
	 */
	public RemoveAppliedStereotypePropertiesToDisplayCommand(TransactionalEditingDomain domain, EModelElement object,
			String stereotypePropertyList) {
		super(domain, object, UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		this.stereotypePropertiesListToRemove = stereotypePropertyList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		String stereotypePropertiesList = AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(this
				.getObject());

		StringTokenizer appliedStereotypeToken = new StringTokenizer(stereotypePropertiesListToRemove, ",");
		while(appliedStereotypeToken.hasMoreElements()) {
			String tokenToRemove = appliedStereotypeToken.nextToken();
			stereotypePropertiesList = stereotypePropertiesList.replaceAll("," + tokenToRemove.trim(), "");
			stereotypePropertiesList = stereotypePropertiesList.replaceAll(tokenToRemove.trim(), "");
		}

		EAnnotation oldAnnotation = getObject().getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if(oldAnnotation == null) {
			oldAnnotation = createEAnnotation();
			attachEannotation(oldAnnotation, getObject());
		}
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_WITHQN_LIST, AppliedStereotypeHelper
				.getStereotypesQNToDisplay(getObject()));
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_LIST, AppliedStereotypeHelper
				.getStereotypesToDisplay(getObject()));
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND,
				AppliedStereotypeHelper.getAppliedStereotypePresentationKind(getObject()));
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.PROPERTY_STEREOTYPE_DISPLAY,
				stereotypePropertiesList);
		replaceEntry(oldAnnotation, UMLVisualInformationPapyrusConstant.STEREOTYPE_PROPERTY_LOCATION,
				AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(getObject()));

		replaceEannotation(getObject().getEAnnotation(UMLVisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION),
				getObject());
	}
}
