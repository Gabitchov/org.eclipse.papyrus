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
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlutils.ui.command;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

/**
 * This {@link RecordingCommand} removes an eannotation to a given element.
 */
public class RemoveEAnnotationCommand extends org.eclipse.emf.transaction.RecordingCommand {

	public EModelElement getObject() {
		return object;
	}

	public void setObject(EModelElement object) {
		this.object = object;
	}

	public String getEAnnotationName() {
		return eAnnotationName;
	}

	public void setEAnnotationName(String annotationName) {
		eAnnotationName = annotationName;
	}

	/** The object. */
	private EModelElement object;

	/** The e annotation name. */
	private String eAnnotationName;

	/**
	 * Instantiates a new creates the e annotation command.
	 * 
	 * @param domain
	 *            the domain
	 * @param object
	 *            the object
	 * @param eannotationName
	 *            the eannotation name
	 */
	public RemoveEAnnotationCommand(TransactionalEditingDomain domain, EModelElement object, String eannotationName) {
		super(domain);
		this.object = object;
		this.eAnnotationName = eannotationName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		EAnnotation annotation = object.getEAnnotation(eAnnotationName);
		object.getEAnnotations().remove(annotation);
	}

}
