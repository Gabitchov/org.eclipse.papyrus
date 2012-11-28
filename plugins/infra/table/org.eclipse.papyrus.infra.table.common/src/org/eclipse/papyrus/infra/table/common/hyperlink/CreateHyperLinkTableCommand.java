/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.common.hyperlink;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkConstants;


public class CreateHyperLinkTableCommand extends CreateEAnnotationCommand {

	/** The hyperlink kind. */
	public String tooltiptext;

	/** The localization. */
	public String name;

	private EModelElement table;

	protected boolean isDefaultNavigation;

	/**
	 * Instantiates a new creates the hyper link command.
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object for example the view
	 * @param tooltiptext
	 *        the hyperlink kind see {@link VisualInformationPapyrusConstant}
	 * @param name
	 *        the localization
	 */
	public CreateHyperLinkTableCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext, String name, EModelElement diagram, boolean isDefaultNavigation) {
		super(domain, object, HyperLinkTableConstants.HYPERLINK_TABLE);
		this.tooltiptext = tooltiptext;
		this.name = name;
		this.table = diagram;
		this.isDefaultNavigation = isDefaultNavigation;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected void doExecute() {
		EAnnotation eAnnotation = createEAnnotation();
		eAnnotation.getReferences().add(table);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT, this.tooltiptext);
		eAnnotation.getDetails().put(HyperLinkTableConstants.HYPERLINK_TABLE_NAME, this.name); //TODO change that!
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION, "" + this.isDefaultNavigation);
		attachEannotation(eAnnotation, getObject());
	}
}
