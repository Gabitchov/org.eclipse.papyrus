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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;

/**
 * The Class CreateHyperLinkCommand. this has in charge to add a new entry list
 * of hyperlinks
 * 
 */
public class CreateHyperLinkPageCommand extends CreateEAnnotationCommand {

	/** The hyperlink kind. */
	public String tooltiptext;

	/** The localization. */
	public String name;

	/**
	 * The pageIdentifier to open
	 */
	private EObject pageIdentifier;

	protected boolean isDefaultNavigation;

	/**
	 * Instantiates a new creates the hyper link command.
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object for example the view
	 * @param tooltiptext
	 *        the hyperlink kind see {@link UMLVisualInformationPapyrusConstant}
	 * @param name
	 *        the localization
	 * @param pageIdentifier
	 * @param isDefaultNavigation
	 */
	public CreateHyperLinkPageCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext, String name, EObject pageIdentifier, boolean isDefaultNavigation) {
		super(domain, object, HyperLinkConstants.PAPYRUS_HYPERLINK_PAGE);
		this.tooltiptext = tooltiptext;
		this.name = name;
		this.pageIdentifier = pageIdentifier;
		this.isDefaultNavigation = isDefaultNavigation;
	}

	/**
	 * {@inheritedDoc}
	 */
	@Override
	protected void doExecute() {
		EAnnotation eAnnotation = createEAnnotation();
		eAnnotation.getReferences().add(pageIdentifier);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT, this.tooltiptext);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_PAGE_NAME, this.name);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION, Boolean.toString(this.isDefaultNavigation));
		attachEannotation(eAnnotation, getObject());
	}

}
