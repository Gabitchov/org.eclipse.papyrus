/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.util;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.common.part.UmlGmfDiagramEditor;
import org.eclipse.ui.IEditorPart;

/**
 * This class provides a Tester to know if the current diagram is the wanted
 * diagram. Test is done using {@link Diagram#getType()}
 * 
 * 
 * 
 */
public class DiagramTester extends PropertyTester {

	/**
	 * The property to test
	 */
	private static final String DIAGRAM_ID = "diagramType";

	/**
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 * 
	 * @param receiver
	 * @param property
	 * @param args
	 * @param expectedValue
	 * @return
	 */
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(DIAGRAM_ID.equals(property) && receiver instanceof IEditorPart) {
			return testDiagramType((IEditorPart)receiver, expectedValue);
		}
		return false;
	}

	/**
	 * Test the type of the diagram
	 * 
	 * @param iEditor
	 *        the current editor
	 * @param expectedValue
	 *        the expected value : the wanted diagram type
	 * @return <code>true</code> if the current diagram has the wanted type
	 */
	protected boolean testDiagramType(IEditorPart iEditor, Object expectedValue) {
		UmlGmfDiagramEditor editor = (UmlGmfDiagramEditor)iEditor.getAdapter(UmlGmfDiagramEditor.class);
		if(editor != null) {
			Diagram diagram = MDTUtil.getDiagramFomEditor(editor);
			if(diagram != null) {
				return expectedValue.equals(diagram.getType());
			}
		}
		return false;
	}
}
