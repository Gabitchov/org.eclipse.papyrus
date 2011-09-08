/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.databinding;

import java.util.Map.Entry;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * An IObservableValue for editing EMF EAnnotations
 * 
 * @author Camille Letavernier
 */
public class AnnotationObservableValue extends AbstractObservableValue {

	/**
	 * The EModelElement to edit.
	 */
	protected EModelElement source;

	/**
	 * The editing domain on which the commands will be executed
	 */
	protected EditingDomain domain;

	/**
	 * The name of the annotation to use
	 */
	protected String annotationName;

	/**
	 * The annotation key to edit
	 */
	protected String key;

	/**
	 * The EAnnotation being edited
	 * May be null
	 */
	protected EAnnotation annotation;

	/**
	 * Constructor.
	 * 
	 * Creates an IObservableValue for the annotation. The annotation doesn't
	 * need to be created beforehand
	 * 
	 * @param source
	 *        The EObject owning the annotation
	 * @param domain
	 *        The editing domain on which the commands will be executed
	 * @param annotationName
	 *        The name of the annotation
	 * @param key
	 *        The name of annotation's property to edit
	 */
	public AnnotationObservableValue(EModelElement source, EditingDomain domain, String annotationName, String key) {
		this.source = source;
		this.domain = domain;
		this.annotationName = annotationName;
		this.key = key;
		annotation = source.getEAnnotation(annotationName);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getValueType() {
		return String.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object doGetValue() {
		if(annotation == null) {
			return null;
		}

		return annotation.getDetails().get(key);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doSetValue(Object value) {
		if(!(value instanceof String)) {
			return;
		}

		CompoundCommand emfCommand = new CompoundCommand("Set " + key);

		if(annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			SetCommand command = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_Source(), source);
			emfCommand.append(command);
		}

		EMap<String, String> details = new BasicEMap<String, String>();
		for(Entry<String, String> entry : annotation.getDetails().entrySet()) {
			details.put(entry.getKey(), entry.getValue());
		}

		details.put(key, (String)value);

		SetCommand command = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_Details(), details);
		emfCommand.append(command);

		domain.getCommandStack().execute(emfCommand);
	}

}
