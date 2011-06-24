/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/

package org.eclipse.papyrus.parsers.texteditor.collaborationuselabel;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.configuration.DefaultDirectEditorConfiguration;
import org.eclipse.papyrus.parsers.modelgenerator.CollaborationUseGenerator;
import org.eclipse.papyrus.umlutils.CollaborationUseUtil;
import org.eclipse.uml2.uml.CollaborationUse;

/**
 * Configuration Class for the direct edition of a UML property
 */
public class CollaborationUseConfigurationForUML extends DefaultDirectEditorConfiguration {

	/** Configuration of the source viewer */
	final private CollaborationUseLabelSourceViewerConfiguration configuration;

	/**
	 * Creates a new CollaborationUseConfigurationForUML.
	 */
	public CollaborationUseConfigurationForUML() {
		configuration = new CollaborationUseLabelSourceViewerConfiguration();
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
		if(editedObject instanceof CollaborationUse) {
			return CollaborationUseUtil.getLabel((CollaborationUse)editedObject);
		}
		return "not a CollaborationUse";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object preEditAction(Object objectToEdit) {
		if(objectToEdit instanceof CollaborationUse) {
			configuration.setCollaborationUse((CollaborationUse)objectToEdit);
		}
		return super.preEditAction(objectToEdit);
	}

	/**
	 * {@inheritDoc}
	 */
	public Object postEditAction(Object editedObject, String text) {
		// Should undo the various creations done in the property edition
		// (template binding, etc...)
		if(editedObject instanceof CollaborationUse) {
			CollaborationUseGenerator generator = new CollaborationUseGenerator(((CollaborationUse)editedObject));
			generator.parseAndModifyCollaborationUse(text);
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
				if(getObjectToEdit() instanceof CollaborationUse) {
					CollaborationUseGenerator generator = new CollaborationUseGenerator(
							((CollaborationUse)getObjectToEdit()));
					return generator.parseAndValidateCollaborationUse(newText);
				}
				return null;
			}
		};
	}

}
