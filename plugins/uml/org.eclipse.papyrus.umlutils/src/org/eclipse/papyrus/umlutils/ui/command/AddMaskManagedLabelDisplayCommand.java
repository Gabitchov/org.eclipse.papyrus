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

/**
 * The Class AddAppliedStereotypeToDisplayCommand used to set the list of applied stereotype to
 * display
 */
public class AddMaskManagedLabelDisplayCommand extends CreateEAnnotationCommand {

	/** new Mask Value */
	private int maskValue;

	/**
	 * Instantiates a new sets the applied stereotype to display command.
	 * 
	 * @param domain
	 *            the editing domain that manages the command
	 * @param object
	 *            the object to be modified
	 * @param maskValue
	 *            the mask value to be stored
	 */
	public AddMaskManagedLabelDisplayCommand(TransactionalEditingDomain domain, EModelElement object, int maskValue) {
		super(domain, object, VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION);
		this.maskValue = maskValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {

		EAnnotation oldAnnotation = getObject().getEAnnotation(
				VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION);
		if (oldAnnotation == null) {
			oldAnnotation = createEAnnotation();
			attachEannotation(oldAnnotation, getObject());
		}
		System.err.println(maskValue + " -> " + Integer.toString(maskValue));
		replaceEntry(oldAnnotation, VisualInformationPapyrusConstant.CUSTOM_APPEARANCE_MASK_VALUE, Integer
				.toString(maskValue));

		replaceEannotation(getObject().getEAnnotation(VisualInformationPapyrusConstant.CUSTOM_APPEARENCE_ANNOTATION),
				getObject());

	}

}
