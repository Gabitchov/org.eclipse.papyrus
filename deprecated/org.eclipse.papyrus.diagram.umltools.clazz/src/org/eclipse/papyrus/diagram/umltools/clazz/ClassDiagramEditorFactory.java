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
 *  Cedric Dumoulin Cedric.Dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.umltools.clazz;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.extension.diagrameditor.EditorDescriptor;
import org.eclipse.papyrus.core.extension.diagrameditor.IPluggableEditorFactory;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageModel;

/**
 * @author dumoulin
 * 
 */
public class ClassDiagramEditorFactory implements IPluggableEditorFactory {

	/** 
	 * Expected diagram type
     */
	private String expectedType;

	/**
	 * Main service Registry. 
	 * Initialized when the factory is registered to the main editor.
	 */
	private ServicesRegistry servicesRegistry;

	/**
	 * Editor Descriptor containing data from the Eclipse extension declaration.
	 */
	private EditorDescriptor editorDescriptor;

	/**
	 * @param diagramClass
	 * @param expectedType
	 */
	public ClassDiagramEditorFactory() {
		expectedType = getDiagramNotationID();
	}

	/**
	 * Initialize the factory.
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IPluggableEditorFactory#init(org.eclipse.papyrus.core.services.ServicesRegistry, org.eclipse.papyrus.core.extension.diagrameditor.EditorDescriptor)
	 *
	 * @param serviceRegistry
	 * @param editorDescriptor
	 */
	public void init(ServicesRegistry serviceRegistry, EditorDescriptor editorDescriptor) {
		this.servicesRegistry = serviceRegistry;
		this.editorDescriptor = editorDescriptor;
		
	}

	/**
	 * Return true if this PageModelFactory can create a PageModel for the specified pageIdentifier.
	 * The pageIdentifier is an instance of Diagram.
	 * 
	 * @see org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactory#isPageModelFactoryFor(java.lang.Object)
	 * @param pageIdentifier
	 * @return
	 * 
	 */
	public boolean isPageModelFactoryFor(Object pageIdentifier) {

		if(pageIdentifier instanceof Diagram) {
			Diagram diagram = (Diagram)pageIdentifier;
			final String type = diagram.getType();
			return getExpectedType().equals(type);
		}
		// no
		return false;

	}

	/**
	 * Create a new instance of the EditorModel for the specified pageIdentifier.
	 * @see org.eclipse.papyrus.core.editorsfactory.IEditorFactory#createIPageModel(java.lang.Object)
	 *
	 * @param pageIdentifier
	 * @return
	 */
	public IPageModel createIPageModel(Object pageIdentifier) {
		return new ClassDiagramEditorModel((Diagram)pageIdentifier, servicesRegistry, editorDescriptor);
	}

	/**
	 * @return the diagramClass
	 */
//	private Class<?> getDiagramClass() {
//		return diagramClass;
//	}

	
	/**
	 * @return the expectedType
	 */
	private String getExpectedType() {
		return expectedType;
	}

	/**
	 * Get the ID identifying the type of the Diagram.
	 * {@inheritDoc}
	 */
	protected String getDiagramNotationID() {
		return org.eclipse.uml2.diagram.clazz.edit.parts.PackageEditPart.MODEL_ID;
	}




}
