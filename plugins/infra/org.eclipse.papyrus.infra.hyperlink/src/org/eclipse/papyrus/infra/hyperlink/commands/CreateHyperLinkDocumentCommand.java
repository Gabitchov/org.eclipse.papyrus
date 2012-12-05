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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.commands;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


/**
 * The Class CreateHyperLinkCommand. this has in charge to add a new entry list
 * of hyperlinks
 * 
 */
public class CreateHyperLinkDocumentCommand extends CreateEAnnotationCommand {

	/** The hyperlink kind. */
	public String tooltiptext;

	/** The localization. */
	public String localization;

	/** to set if is a default hyperlink */
	public boolean isDefault;

	/**
	 * Instantiates a new creates the hyper link command.
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object for example the view
	 * @param tooltiptext
	 *        the hyperlink kind see {@link VisualInformationPapyrusConstant}
	 * @param localization
	 *        the localization
	 * @param isDefault
	 *        to set this hyperlink as default
	 */
	public CreateHyperLinkDocumentCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext, String localization, boolean isDefault) {
		super(domain, object, HyperLinkConstants.HYPERLINK_DOCUMENT);
		this.tooltiptext = tooltiptext;
		this.localization = localization;
		this.isDefault = isDefault;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected void doExecute() {
		EAnnotation eAnnotation = createEAnnotation();
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT, this.tooltiptext);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_DOCUMENT_LOCALIZATION, this.localization);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION, "" + this.isDefault); //$NON-NLS-1$
		attachEannotation(eAnnotation, getObject());
	}

}
