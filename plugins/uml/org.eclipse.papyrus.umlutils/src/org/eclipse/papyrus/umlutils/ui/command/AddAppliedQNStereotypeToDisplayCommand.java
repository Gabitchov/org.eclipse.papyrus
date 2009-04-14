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
package org.eclipse.papyrus.umlutils.ui.command;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.helper.AppliedStereotypeHelper;

/**
 * The Class AddQNAppliedStereotypeToDisplayCommand used to set the list of applied stereotype to display withe the qualifiedName.
 */
public class AddAppliedQNStereotypeToDisplayCommand extends CreateEAnnotationCommand {

	/** The qualified namedepht. */
	private String stereotypeListQN;

	/**
	 * the presnetation kind of applied stereotypes
	 */
	private String appliedStereotypePresentationKind;

	/**
	 * Instantiates a new sets the applied stereotype to display command.
	 * 
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param stereotypeList
	 *            the stereotype list
	 */
	public AddAppliedQNStereotypeToDisplayCommand(TransactionalEditingDomain domain, EModelElement object, String stereotypeQNList) {
		super(domain, object, VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		this.stereotypeListQN = stereotypeQNList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		String stereoListQN = AppliedStereotypeHelper.getStereotypesQNToDisplay(this.getObject());
		if (!"".equals(stereoListQN)) {
			stereoListQN = stereoListQN + ",";
		}
		stereoListQN = stereoListQN + stereotypeListQN;
		EAnnotation oldAnnotation = getObject().getEAnnotation(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		if (oldAnnotation == null) {
			oldAnnotation = createEAnnotation();
			attachEannotation(oldAnnotation, getObject());
		}
		replaceEntry(oldAnnotation, VisualInformationPapyrusConstant.STEREOTYPE_WITHQN_LIST, stereoListQN);
		replaceEntry(oldAnnotation, VisualInformationPapyrusConstant.STEREOTYPE_LIST, AppliedStereotypeHelper.getStereotypesToDisplay(getObject()));
		replaceEntry(oldAnnotation, VisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND, AppliedStereotypeHelper.getAppliedStereotypePresentationKind(getObject()));
		replaceEntry(oldAnnotation, VisualInformationPapyrusConstant.PROPERTY_STEREOTYPE_DISPLAY, AppliedStereotypeHelper.getAppliedStereotypesPropertiesToDisplay(getObject()));
		replaceEntry(oldAnnotation, VisualInformationPapyrusConstant.STEREOTYPE_PROPERTY_LOCATION, AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(getObject()));
		replaceEannotation(getObject().getEAnnotation(VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION), getObject());

	}

}
