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
 * The Class AddAppliedStereotypeToDisplayCommand used to set the list of applied stereotype to display
 */
public class AddAppliedStereotypeToDisplayCommand extends CreateEAnnotationCommand {

	/** The qualified namedepht. */
	private String stereotypeList;

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
	public AddAppliedStereotypeToDisplayCommand(TransactionalEditingDomain domain, EModelElement object, String stereotypeList, String appliedStereotypepresentationKind) {
		super(domain, object, VisualInformationPapyrusConstant.STEREOTYPE_ANNOTATION);
		this.stereotypeList = stereotypeList;
		this.appliedStereotypePresentationKind = appliedStereotypepresentationKind;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		String stereoList = AppliedStereotypeHelper.getStereotypesToDisplay(this.getObject());
		if (!"".equals(stereoList)) {
			stereoList = stereoList + ",";
		}
		stereoList = stereoList + stereotypeList;
		EAnnotation appliedStereotypeEAnnotation = createEAnnotation();
		replaceEannotation(appliedStereotypeEAnnotation, getObject());
		replaceEntry(appliedStereotypeEAnnotation, VisualInformationPapyrusConstant.STEREOTYPE_LIST, stereoList);
		replaceEntry(appliedStereotypeEAnnotation, VisualInformationPapyrusConstant.STEREOTYPE_PRESENTATION_KIND, appliedStereotypePresentationKind);
	}

}
