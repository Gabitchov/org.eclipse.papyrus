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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.parsers.modelgenerator.PropertyGenerator;
import org.eclipse.papyrus.parsers.texteditor.CompletionFilterSourceViewerConfiguration.ICompletionFilter;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.IContext;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.PropertyConfigurationForUML;
import org.eclipse.papyrus.parsers.texteditor.propertylabel.PropertyLabelSourceViewerConfiguration;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * Configuration Class for the direct edition of a SysML constraint property
 */
public class ConstraintPropertyConfiguration extends DefaultDirectEditorConfiguration {

	/** configuration of the source viewer */
	final private PropertyLabelSourceViewerConfiguration configuration;

	/**
	 * Creates a new PropertyConfiguration to filter values.
	 */
	public ConstraintPropertyConfiguration() {
		configuration = new PropertyLabelSourceViewerConfiguration(new ICompletionFilter() {

			public boolean filter(int context, EObject e) {
				switch(context) {
				case IContext.AFTER_COLON:
					if(e instanceof Element) {
						if(((Element)e).getAppliedStereotype("SysML::Constraints::ConstraintBlock") != null) {
							return false;
						}
					}

					return true;
				default:
					return false;
				}
			}
		});
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
		if(editedObject instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty)editedObject).getBase_Property();
			return PropertyUtil.getLabel(property);
		}
		return "not a Constraint Property";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object preEditAction(Object objectToEdit) {
		if(objectToEdit instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty)objectToEdit).getBase_Property();
			configuration.setProperty(property);
		}
		return super.preEditAction(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object postEditAction(Object editedObject, String text) {
		if(editedObject instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty)editedObject).getBase_Property();
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
				if(getObjectToEdit() instanceof ConstraintProperty) {
					Property property = ((ConstraintProperty)getObjectToEdit()).getBase_Property();
					PropertyGenerator generator = new PropertyGenerator(property);
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
		if(editedObject instanceof ConstraintProperty) {
			Property property = ((ConstraintProperty)editedObject).getBase_Property();
			return new PropertyConfigurationForUML().getTextSelection(value, property);
		}
		return super.getTextSelection(value, editedObject);
	}

}
