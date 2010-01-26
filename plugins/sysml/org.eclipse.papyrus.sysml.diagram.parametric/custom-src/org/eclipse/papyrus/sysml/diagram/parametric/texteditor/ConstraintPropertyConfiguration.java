/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.texteditor;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.parsers.modelgenerator.PropertyGenerator;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.PropertyLabelSourceViewerConfiguration;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.uml2.uml.Property;

/**
 * Configuration Class for the direct edition of a SysML constraint property
 */
public class ConstraintPropertyConfiguration extends DefaultDirectEditorConfiguration {

	/** configuration of the source viewer */
	final private PropertyLabelSourceViewerConfiguration configuration;

	/**
	 * Creates a new PropertyConfigurationForUML.
	 */
	public ConstraintPropertyConfiguration() {
		configuration = new PropertyLabelSourceViewerConfiguration();
	}

	/**
	 * {@inheritDoc}
	 */
	public SourceViewerConfiguration getSourceViewerConfiguration() {
		return configuration;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getTextToEdit(Object editedObject) {
		if (editedObject instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty) editedObject).getBase_Property();
			return PropertyUtil.getLabel(property);
		}
		return "not a Constraint Property";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object preEditAction(Object objectToEdit) {
		if (objectToEdit instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty) objectToEdit).getBase_Property();
			configuration.setProperty(property);
		}
		return super.preEditAction(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object postEditAction(Object editedObject, String text) {
		if (editedObject instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty) editedObject).getBase_Property();
			PropertyGenerator generator = new PropertyGenerator(property);
			generator.parseAndModifyProperty(text);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IInputValidator getInputValidator() {
		return new IInputValidator() {

			public String isValid(String newText) {
				if (getObjectToEdit() instanceof ConstraintProperty) {
					Property property = ((ConstraintProperty) getObjectToEdit()).getBase_Property();
					PropertyGenerator generator = new PropertyGenerator(property);
					return generator.parseAndValidateProperty(newText);
				}
				return null;
			}
		};
	}

}
