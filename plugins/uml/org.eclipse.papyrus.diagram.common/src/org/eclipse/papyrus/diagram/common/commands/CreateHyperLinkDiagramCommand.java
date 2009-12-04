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
package org.eclipse.papyrus.diagram.common.commands;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.umlutils.ui.VisualInformationPapyrusConstant;
import org.eclipse.papyrus.umlutils.ui.command.CreateEAnnotationCommand;

/**
 * The Class CreateHyperLinkCommand. this has in charge to add a new entry list of hyperlinks
 * 
 */
public class CreateHyperLinkDiagramCommand extends CreateEAnnotationCommand {

	/** The hyperlink kind. */
	public String tooltiptext;

	/** The localization. */
	public String name;

	private EModelElement diagram;

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
	public CreateHyperLinkDiagramCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext,
			String name, EModelElement diagram) {
		super(domain, object, VisualInformationPapyrusConstant.HYPERLINK_DIAGRAM);
		this.tooltiptext = tooltiptext;
		this.name = name;
		this.diagram = diagram;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected void doExecute() {
		EAnnotation eAnnotation = createEAnnotation();
		eAnnotation.getReferences().add(diagram);
		eAnnotation.getDetails().put(VisualInformationPapyrusConstant.HYPERLINK_TOOLTYPE_TEXT, this.tooltiptext);
		eAnnotation.getDetails().put(VisualInformationPapyrusConstant.HYPERLINK_DIAGRAM_NAME, this.name);
		attachEannotation(eAnnotation, getObject());
	}

}
