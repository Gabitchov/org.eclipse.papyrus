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
package org.eclipse.papyrus.umlutils.ui;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

// TODO: Auto-generated Javadoc
/**
 * The Class SetQualifiedNameDepthCommand.
 */
public class SetGradienColorCommand extends CreateEAnnotationCommand {

	/** The qualified namedepht. */
	private String gradientColor;

	/**
	 * Instantiates a new sets the qualified name depth command.
	 * 
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param depht
	 *            the depht
	 */
	public SetGradienColorCommand(TransactionalEditingDomain domain, EModelElement object, boolean gradient) {
		super(domain, object, VisualInformationPapyrusConstant.GRADIENT);
		this.gradientColor = "" + gradient;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		EAnnotation qualifiedNameEAnnotation = createEAnnotation();
		replaceEannotation(qualifiedNameEAnnotation, getObject());
		replaceEntry(qualifiedNameEAnnotation, VisualInformationPapyrusConstant.GRADIENT_VALUE, gradientColor);
	}

}
