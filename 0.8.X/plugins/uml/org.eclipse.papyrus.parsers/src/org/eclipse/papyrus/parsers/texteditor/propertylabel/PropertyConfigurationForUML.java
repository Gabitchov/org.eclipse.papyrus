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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.parsers.texteditor.propertylabel;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.parsers.modelgenerator.PropertyGenerator;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.uml2.uml.Property;

/**
 * Configuration Class for the direct edition of a UML property
 */
public class PropertyConfigurationForUML extends DefaultDirectEditorConfiguration {

	/** configuration of the source viewer */
	final private PropertyLabelSourceViewerConfiguration configuration;

	/**
	 * Creates a new PropertyConfigurationForUML.
	 */
	public PropertyConfigurationForUML() {
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
		if (editedObject instanceof Property) {
			return PropertyUtil.getLabel((Property) editedObject);
		}
		return "not a Property";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object preEditAction(Object objectToEdit) {
		if (objectToEdit instanceof Property) {
			configuration.setProperty((Property) objectToEdit);
		}
		return super.preEditAction(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object postEditAction(Object editedObject, String text) {
		// should undo the various creations done in the property edition
		// (template binding, etc...)
		if (editedObject instanceof Property) {
			PropertyGenerator generator = new PropertyGenerator(((Property) editedObject));
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
				if (getObjectToEdit() instanceof Property) {
					PropertyGenerator generator = new PropertyGenerator(((Property) getObjectToEdit()));
					return generator.parseAndValidateProperty(newText);
				}
				return null;
			}
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Selection getTextSelection(String value, Object editedObject) {
		if (editedObject instanceof Property) {
			Property property = (Property) editedObject;
			String name = PropertyUtil.getName(property);
			int start = value.indexOf(name);
			int length = name.length();
			return new Selection(start, length);
		}
		return super.getTextSelection(value, editedObject);
	}

}
