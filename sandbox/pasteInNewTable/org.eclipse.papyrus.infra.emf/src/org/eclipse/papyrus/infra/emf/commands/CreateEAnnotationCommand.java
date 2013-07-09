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
package org.eclipse.papyrus.infra.emf.commands;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

public class CreateEAnnotationCommand extends org.eclipse.emf.transaction.RecordingCommand {

	public EModelElement getObject() {
		return object;
	}

	// @unused
	public void setObject(EModelElement object) {
		this.object = object;
	}

	// @unused
	public String getEAnnotationName() {
		return eAnnotationName;
	}

	// @unused
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
	 *        the domain
	 * @param object
	 *        the object
	 * @param eannotationName
	 *        the eannotation name
	 */
	public CreateEAnnotationCommand(TransactionalEditingDomain domain, EModelElement object, String eannotationName) {
		super(domain);
		this.object = object;
		this.eAnnotationName = eannotationName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		attachEannotation(createEAnnotation(), object);

	}

	/**
	 * Creates the e annotation.
	 * 
	 * @return the e annotation
	 */
	protected EAnnotation createEAnnotation() {
		EAnnotation eannotation = EcoreFactory.eINSTANCE.createEAnnotation();
		eannotation.setSource(eAnnotationName);
		return eannotation;
	}

	/**
	 * Attach eannotation to an EmodelElement.
	 * 
	 * @param annotation
	 *        the annotation
	 * @param object
	 *        the object
	 */
	protected void attachEannotation(EAnnotation annotation, EModelElement object) {
		object.getEAnnotations().add(annotation);
	}

	/**
	 * Replace existing eannotation with a new eannotation. This repplaced eannotation has the same
	 * source.
	 * 
	 * @param annotation
	 *        the annotation
	 * @param object
	 *        the object
	 */
	protected void replaceEannotation(EAnnotation annotation, EModelElement object) {
		while(object.getEAnnotation(annotation.getSource()) != null) {
			object.getEAnnotations().remove(object.getEAnnotation(annotation.getSource()));
		}

		object.getEAnnotations().add(annotation);
	}

	/**
	 * Adds the entry.
	 * 
	 * @param annotation
	 *        the annotation
	 * @param key
	 *        the key
	 * @param value
	 *        the value
	 */
	// @unused
	protected void addEntry(EAnnotation annotation, String key, String value) {
		annotation.getDetails().put(key, value);
	}

	/**
	 * Replace entry.
	 * 
	 * @param annotation
	 *        the annotation not null
	 * @param key
	 *        the key
	 * @param value
	 *        the value
	 */
	protected void replaceEntry(EAnnotation annotation, String key, String value) {
		while(annotation.getDetails().get(key) != null) {
			annotation.getDetails().removeKey(key);

		}
		annotation.getDetails().put(key, value);
	}
}
