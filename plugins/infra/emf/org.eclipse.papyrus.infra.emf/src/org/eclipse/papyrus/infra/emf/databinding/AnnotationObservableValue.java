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

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
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
	 * Whether the EAnnotation should be removed from the source when its last
	 * entry is removed (ie. value = null)
	 */
	protected boolean deleteWithLastEntry;

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
		this(source, domain, annotationName, key, false);
	}

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
	 * @param deleteWithLastEntry
	 *        Whether the EAnnotation should be removed from the source when its
	 *        last entry is removed (ie. value = null)
	 */
	public AnnotationObservableValue(EModelElement source, EditingDomain domain, String annotationName, String key, boolean deleteWithLastEntry) {
		this.source = source;
		this.domain = domain;
		this.annotationName = annotationName;
		this.key = key;
		this.deleteWithLastEntry = deleteWithLastEntry;
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

	/**
	 * @return the observed EAnnotation
	 */
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

	/**
	 * Returns the command used to edit the observed annotation, which the
	 * given value
	 * 
	 * @param value
	 * @return
	 */
	protected Command getCommand(Object value) {
		EAnnotation annotation = getEAnnotation();

		if(value == null) {
			//No change : the key is not defined ; we cannot remove it
			if(annotation == null || !annotation.getDetails().containsKey(key)) {
				return null;
			}
		} else {
			if(!(value instanceof String)) {
				return null;
			}
		}

		CompoundCommand emfCommand = new CompoundCommand("Set " + key) { //$NON-NLS-1$

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

			SetCommand attachToSourceCommand = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_EModelElement(), source);
			attachToSourceCommand.setLabel("Attach to source");
			emfCommand.append(attachToSourceCommand);

			SetCommand nameCommand = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_Source(), annotationName);
			nameCommand.setLabel("Set name");
			emfCommand.append(nameCommand);
		}

		if(value == null) {
			if(annotation.getDetails().size() == 1 && annotation.getDetails().containsKey(key) && deleteWithLastEntry) {
				//We removed the last key : delete the annotation
				SetCommand deleteAnnotationCommand = new SetCommand(domain, annotation, EcorePackage.eINSTANCE.getEAnnotation_EModelElement(), null);
				deleteAnnotationCommand.setLabel("Delete EAnnotation");
				emfCommand.append(deleteAnnotationCommand);
			} else {
				Command removeEntryCommand = new RemoveEntryCommand(annotation, key);
				emfCommand.append(removeEntryCommand);
			}
		} else {
			Command addEntryCommand = new AddEntryCommand(annotation, key, (String)value);
			emfCommand.append(addEntryCommand);
		}

		return emfCommand;
	}

	/**
	 * A Command to remove an entry from an EAnnotation
	 * 
	 * @author Camille Letavernier
	 * 
	 */
	protected class RemoveEntryCommand extends AbstractCommand {

		private EAnnotation annotation;

		private String key;

		private String previousValue;

		private boolean undo = false;

		/**
		 * Constructor
		 * 
		 * @param annotation
		 *        The EAnnotation to edit
		 * @param key
		 *        The EAnnotation's key to edit
		 */
		public RemoveEntryCommand(EAnnotation annotation, String key) {
			this.annotation = annotation;
			this.key = key;
		}

		public void execute() {
			undo = annotation.getDetails().containsKey(key);
			if(undo) {
				previousValue = annotation.getDetails().get(key);
				annotation.getDetails().remove(key);
			}
		}

		public void redo() {
			execute();
		}

		@Override
		public boolean prepare() {
			return true;
		}

		@Override
		public void undo() {
			if(undo) {
				annotation.getDetails().put(key, previousValue);
			}
		}
	}

	/**
	 * A Command to set an EAnnotation's entry
	 * 
	 * @author Camille Letavernier
	 */
	protected class AddEntryCommand extends AbstractCommand {

		private EAnnotation annotation;

		private String key;

		private String value;

		/**
		 * 
		 * 
		 * @param annotation
		 *        The EAnnotation to edit
		 * @param key
		 *        The EAnnotation's key to edit
		 * @param value
		 *        The value to set
		 */
		public AddEntryCommand(EAnnotation annotation, String key, String value) {
			this.annotation = annotation;
			this.key = key;
			this.value = value;
		}

		public void execute() {
			annotation.getDetails().put(key, value);
		}

		public void redo() {
			execute();
		}

		@Override
		public void undo() {
			annotation.getDetails().remove(key);
		}

		@Override
		public boolean prepare() {
			return true;
		}
	}
}
