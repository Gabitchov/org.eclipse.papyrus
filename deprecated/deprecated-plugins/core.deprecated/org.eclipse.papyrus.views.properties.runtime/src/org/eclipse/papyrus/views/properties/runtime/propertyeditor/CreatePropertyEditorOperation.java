/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.runtime.propertyeditor;

import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.controller.PropertyEditorController;
import org.eclipse.swt.widgets.Composite;


/**
 * Operation that creates an {@link AbstractPropertyEditor} from a provider
 */
public class CreatePropertyEditorOperation implements IOperation {

	/** parent composite for the created widgets */
	protected Composite parent;

	/** identifier of the specific editor to find */
	protected final String editorIdentifier;

	/** indicates if the property to edit is multi-valued */
	protected final boolean multiValue;

	/** controller which requires the property editor creation */
	protected PropertyEditorController controller;

	/**
	 * Constructor.
	 * 
	 * @param controller
	 *        the controller that manages the created editor
	 * @param id
	 *        the identifier of the editor to find
	 */
	public CreatePropertyEditorOperation(PropertyEditorController controller, String id) {
		this.controller = controller;
		this.editorIdentifier = id;
		this.multiValue = false;
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractPropertyEditor execute(IProvider provider) {
		if(provider instanceof PropertyEditorProvider) {
			AbstractPropertyEditor editor = ((PropertyEditorProvider)provider).createPropertyEditor(editorIdentifier, controller);
			return editor;
		} else {
			Activator.log.error("CreatePropertyEditorOperation should execute on a PropertyEditorProvider", null);
		}
		return null;
	}

	/**
	 * Returns the identifier of the specific editor to find
	 * 
	 * @return the identifier of the specific editor to find. It can be <code>null</code>. In this case, feature should not be <code>null</code>
	 */
	public String getEditorIdentifier() {
		return editorIdentifier;
	}

	/**
	 * Returns <code>true</code> if the property to edit is multi-valued
	 * 
	 * @return <code>true</code> if the property to edit is multi-valued
	 */
	public boolean isMultiValue() {
		return multiValue;
	}

}
