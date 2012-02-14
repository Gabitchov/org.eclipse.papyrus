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
package org.eclipse.papyrus.infra.emf.databinding;

import java.util.Map.Entry;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
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
		EAnnotation annotation = getEAnnotation();
		if(annotation == null) {
			return null;
		}

		return annotation.getDetails().get(key);
	}


	protected EAnnotation getEAnnotation() {
		return source.getEAnnotation(annotationName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doSetValue(Object value) {
		Command emfCommand = getCommand(value);
		if(emfCommand != null) {
			domain.getCommandStack().execute(emfCommand);
		}
	}

	protected Command getCommand(Object value) {
		EAnnotation annotation = getEAnnotation();

		if(value == null) {
			if(annotation == null) {
				return null;
			}
		} else {
			if(!(value instanceof String)) {
				return null;
			}
		}

		CompoundCommand emfCommand = new CompoundCommand("Set " + key) {

			@Override
			public boolean prepare() {
				if(this.isEmpty()) {
					return false;
				}

				return commandList.get(0).canExecute();
			}

		};

		if(annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			SetCommand nameCommand = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_Source(), annotationName);
			nameCommand.setLabel("Set name");
			emfCommand.append(nameCommand);

			SetCommand attachToSourceCommand = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_EModelElement(), source);
			nameCommand.setLabel("Attach to source");
			emfCommand.append(attachToSourceCommand);
		}

		EMap<String, String> details = new BasicEMap<String, String>();
		for(Entry<String, String> entry : annotation.getDetails().entrySet()) {
			details.put(entry.getKey(), entry.getValue());
		}

		if(value == null) {
			details.remove(key);
			if(details.isEmpty()) { //We removed the last key : delete the annotation
				SetCommand command = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_EModelElement(), null);
				command.setLabel("Delete EAnnotation");
				emfCommand.append(command);
				annotation = null;
				return emfCommand;
			}
		} else {
			details.put(key, (String)value);
		}

		SetCommand command = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_Details(), details);
		command.setLabel("Set details");
		emfCommand.append(command);

		return emfCommand;
	}
}
