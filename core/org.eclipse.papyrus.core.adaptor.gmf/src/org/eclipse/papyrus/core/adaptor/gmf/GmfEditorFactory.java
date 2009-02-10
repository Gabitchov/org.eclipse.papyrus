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
package org.eclipse.papyrus.core.adaptor.gmf;

import java.lang.reflect.Constructor;

import org.eclipse.gef.ui.parts.GraphicalEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.diagrameditor.AbstractEditorFactory;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContext;
import org.eclipse.papyrus.di.CoreSemanticModelBridge;
import org.eclipse.ui.IEditorPart;

/**
 * Base class of GmfEditor factories. Editor should subclass this class and provide a 0 args constructor initializing the super class.
 * 
 * @author Cedric Dumoulin
 * @author Remi Schnekenburger
 * @author Patrick Tessier
 */
public class GmfEditorFactory extends AbstractEditorFactory {

	public static final String GMF_DIAGRAM = "diagram.gmf";

	/**
	 * Creates a new GmfEditorFactory.
	 * 
	 * @param diagramClass
	 *            expected Class of the diagram to create.
	 * @param expectedType
	 *            expected diagram type (@see {@link Diagram#getType()})
	 */
	public GmfEditorFactory(Class<?> diagramClass, String expectedType) {
		super(diagramClass, expectedType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEditorFor(Object root) {

		// TODO Change next to remove dependency on di2.
		// Retrieve GMF diagram, if any.
		if (root instanceof org.eclipse.papyrus.di.Diagram) {
			org.eclipse.papyrus.di.Diagram di2Diagram = (org.eclipse.papyrus.di.Diagram) root;
			if (!GMF_DIAGRAM.equals(di2Diagram.getType()))
				return false;
			// Ok, this is a gmf diagram
			root = ((CoreSemanticModelBridge) di2Diagram.getSemanticModel()).getElement();
		}

		if (root instanceof Diagram) {
			Diagram diagram = (Diagram) root;
			final String type = diagram.getType();
			return getExpectedType().equals(type);
		}
		// no
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public IEditorPart createEditorFor(IEditorContext context, Object root) throws BackboneException {
		assert (context instanceof GmfEditorContext);
		return createEditorFor((GmfEditorContext) context, root);
	}

	/**
	 * It is used to create the editor by taking account the root element, for example a diagram
	 * 
	 * @param context
	 *            the gmf context
	 * @param root
	 *            the element on which the editor can be launch , for example the editor
	 * @return the created editor
	 * @throws BackboneException
	 *             editor could not be created
	 */
	public IEditorPart createEditorFor(GmfEditorContext context, Object root) throws BackboneException {
		GraphicalEditor editor;

		// TODO Change next to remove dependency on di2.
		// Retrieve GMF diagram, if any.
		if (root instanceof org.eclipse.papyrus.di.Diagram) {
			org.eclipse.papyrus.di.Diagram di2Diagram = (org.eclipse.papyrus.di.Diagram) root;
			if (!GMF_DIAGRAM.equals(di2Diagram.getType()))
				throw new BackboneException("Problem retrieving GMF Diagram.");
			// Ok, this is a gmf diagram
			root = ((CoreSemanticModelBridge) di2Diagram.getSemanticModel()).getElement();
		}

		try {
			Constructor<?> c = getDiagramClass().getConstructor(Diagram.class, GmfEditorContext.class);
			editor = (GraphicalEditor) c.newInstance((Diagram) root, context);
			// editor = new ClassDiagramEditor((Diagram)root, context.getModelMngr(), context.getCommandStack(), context.getActionRegistry() );
			return editor;

		} catch (Exception e) {
			// Lets propagate. This is an implementation problem that should be solved by programmer.
			throw new BackboneException(e);
		}
	}
}
