/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for Parameter
 *
 *****************************************************************************/

package org.eclipse.papyrus.parsers.texteditor.parameterlabel;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.parsers.modelgenerator.ParameterGenerator;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.papyrus.umlutils.ParameterUtil;
import org.eclipse.uml2.uml.Parameter;

/**
 * Configuration Class for the direct edition of a UML property
 */
public class ParameterConfigurationForUML extends DefaultDirectEditorConfiguration {

	/** Configuration of the source viewer */
	final private ParameterLabelSourceViewerConfiguration configuration;

	/**
	 * Creates a new ParameterConfigurationForUML.
	 */
	public ParameterConfigurationForUML() {
		configuration = new ParameterLabelSourceViewerConfiguration();
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
		if(editedObject instanceof Parameter) {
			return ParameterUtil.getLabel((Parameter)editedObject);
		}
		return "not a Parameter";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object preEditAction(Object objectToEdit) {
		if(objectToEdit instanceof Parameter) {
			configuration.setParameter((Parameter)objectToEdit);
		}
		return super.preEditAction(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object postEditAction(Object editedObject, String text) {
		// Should undo the various creations done in the property edition
		// (template binding, etc...)
		if(editedObject instanceof Parameter) {
			ParameterGenerator generator = new ParameterGenerator(((Parameter)editedObject));
			generator.parseAndModifyParameter(text);
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
				if(getObjectToEdit() instanceof Parameter) {
					ParameterGenerator generator = new ParameterGenerator(((Parameter)getObjectToEdit()));
					return generator.parseAndValidateParameter(newText);
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
		if(editedObject instanceof Parameter) {
			Parameter parameter = (Parameter)editedObject;
			String name = NamedElementUtil.getName(parameter);
			int start = value.indexOf(name);
			int length = name.length();
			return new Selection(start, length);
		}
		return super.getTextSelection(value, editedObject);
	}
}
