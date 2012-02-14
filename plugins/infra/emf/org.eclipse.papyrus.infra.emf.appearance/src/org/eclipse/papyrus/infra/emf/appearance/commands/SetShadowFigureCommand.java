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
package org.eclipse.papyrus.infra.emf.appearance.commands;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.appearance.helper.VisualInformationPapyrusConstants;
import org.eclipse.papyrus.infra.emf.commands.CreateEAnnotationCommand;

/**
 * The Class SetQualifiedNameDepthCommand.
 */
public class SetShadowFigureCommand extends CreateEAnnotationCommand {

	/** The shadowFigure. */
	private String shadowFigure;

	/**
	 * Instantiates a new sets the qualified name depth command.
	 * 
	 * @param domain
	 *        the domain
	 * @param object
	 *        the object
	 * @param shadow
	 *        the shadow
	 */
	public SetShadowFigureCommand(TransactionalEditingDomain domain, EModelElement object, boolean shadow) {
		super(domain, object, VisualInformationPapyrusConstants.SHADOWFIGURE);
		this.shadowFigure = "" + shadow;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		EAnnotation shadowFigureEAnnotation = createEAnnotation();
		replaceEannotation(shadowFigureEAnnotation, getObject());
		replaceEntry(shadowFigureEAnnotation, VisualInformationPapyrusConstants.SHADOWFIGURE_VALUE, shadowFigure);
	}

}
