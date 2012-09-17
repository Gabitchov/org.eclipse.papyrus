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
package org.eclipse.papyrus.uml.diagram.common.ui.hyperlinkshell;

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
//TODO this class (and others classes for diagram hyperlink should be moved into oep.infra.gmfdiag.common, no?
public class CreateHyperLinkDiagramCommand extends CreateEAnnotationCommand {

	/** The hyperlink kind. */
	public String tooltiptext;

	/** The localization. */
	public String name;

	private EModelElement diagram;

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
	 */
	public CreateHyperLinkDiagramCommand(TransactionalEditingDomain domain, EModelElement object, String tooltiptext, String name, EModelElement diagram, boolean isDefaultNavigation) {
		super(domain, object, HyperLinkDiagramConstants.HYPERLINK_DIAGRAM);
		this.tooltiptext = tooltiptext;
		this.name = name;
		this.diagram = diagram;
		this.isDefaultNavigation=isDefaultNavigation;
	}

	/**
	 * {@inheritedDoc}
	 */
	protected void doExecute() {
		EAnnotation eAnnotation = createEAnnotation();
		eAnnotation.getReferences().add(diagram);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_TOOLTYPE_TEXT, this.tooltiptext);
		eAnnotation.getDetails().put(HyperLinkDiagramConstants.HYPERLINK_DIAGRAM_NAME, this.name);
		eAnnotation.getDetails().put(HyperLinkConstants.HYPERLINK_IS_DEFAULT_NAVIGATION, ""+this.isDefaultNavigation); //$NON-NLS-1$
		attachEannotation(eAnnotation, getObject());
	}

}
