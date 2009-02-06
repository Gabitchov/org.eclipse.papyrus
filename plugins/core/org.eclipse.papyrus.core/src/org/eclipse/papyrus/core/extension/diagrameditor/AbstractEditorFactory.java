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
package org.eclipse.papyrus.core.extension.diagrameditor;

import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.ui.IEditorPart;

/**
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public abstract class AbstractEditorFactory implements IEditorFactory {

	/**
	 * Expected Class of the diagram to create.
	 */
	private Class<?> diagramClass;

	/** Expected diagram type (@see {@link Diagram#getType()}) */
	private String expectedType;

	/**
	 * Creates a new AbstractEditorFactory.
	 * 
	 * @param diagramClass
	 *            expected Class of the diagram to create.
	 * @param expectedType
	 *            expected diagram type (@see {@link Diagram#getType()})
	 */
	public AbstractEditorFactory(Class<?> diagramClass, String expectedType) {
		assert (expectedType != null);
		this.diagramClass = diagramClass;
		this.expectedType = expectedType;
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
	 * {@inheritDoc}
	 */
	public abstract IEditorPart createEditorFor(IEditorContext context, Object root) throws BackboneException;

	/**
	 * {@inheritDoc}
	 */
	public boolean isEditorFor(Object root) {
		if (root instanceof Diagram) {
			Diagram diagram = (Diagram) root;
			final String type = diagram.getType();
			return expectedType.equals(type);
		}
		// no
		return false;
	}

}
