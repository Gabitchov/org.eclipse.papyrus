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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.core.extension.diagrameditor;

import org.eclipse.papyrus.infra.core.services.ServicesRegistry;

/**
 * Abstract base class for Factory of editors. See {@link IEditorFactory}.
 * 
 * 
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 * @author cedric dumoulin
 */
public abstract class AbstractEditorFactory implements IPluggableEditorFactory {

	/**
	 * Expected Class of the diagram to create.
	 */
	private Class<?> diagramClass;

	/** Expected diagram type (@see {@link Diagram#getType()}) */
	private String expectedType;

	/**
	 * EditorDescriptor associated to the factory. TODO : Maybe use individual
	 * setters to set the requested data (ContributorId and Icon).
	 */
	protected EditorDescriptor editorDescriptor;

	/**
	 * ServiceRegistry that can be provided to created editors.
	 */
	private ServicesRegistry serviceRegistry;

	/**
	 * Creates a new AbstractEditorFactory.
	 * 
	 * @param diagramClass
	 *        expected Class of the diagram to create.
	 * @param expectedType
	 *        expected diagram type (@see {@link Diagram#getType()})
	 */
	public AbstractEditorFactory(Class<?> diagramClass, String expectedType) {
		assert (expectedType != null);
		this.diagramClass = diagramClass;
		this.expectedType = expectedType;
	}

	/**
	 * Initialize the factory with useful Classes.
	 * 
	 * @param serviceRegistry
	 *        Service registry that will be provided to created editor.
	 * @param editorDescriptor
	 *        Descriptor containing data from the Eclipse Extension.
	 */
	public void init(ServicesRegistry serviceRegistry, EditorDescriptor editorDescriptor) {
		this.editorDescriptor = editorDescriptor;
		this.serviceRegistry = serviceRegistry;

	}

	/**
	 * @return the serviceRegistry
	 */
	public ServicesRegistry getServiceRegistry() {
		return serviceRegistry;
	}

	/**
	 * Returns the expected class for the diagram implementation
	 * 
	 * @return the expected class for the diagram implementation
	 */
	public Class<?> getDiagramClass() {
		return diagramClass;
	}

	/**
	 * Returns the expected type of the diagram
	 * 
	 * @return the expected diagram type (@see {@link Diagram#getType()})
	 */
	public String getExpectedType() {
		return expectedType;
	}

	/**
	 * @return the editorDescriptor
	 */
	public EditorDescriptor getEditorDescriptor() {
		return editorDescriptor;
	}

}
