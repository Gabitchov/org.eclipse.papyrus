/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.papyrus.diagram.tests.canonical.TestChildNode;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;


public  abstract class TestActivityChildNode extends TestChildNode {


	@Override
	protected void setUp() throws Exception {
		projectCreation();

		while( !(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()instanceof IMultiDiagramEditor)){}
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		papyrusEditor=((PapyrusMultiDiagramEditor)editorPart);
		
		assertTrue(CREATION +INITIALIZATION_TEST,getDiagramEditPart().getChildren().size()==1);
		GraphicalEditPart containerEditPart= (GraphicalEditPart)getDiagramEditPart().getChildren().get(0);
		rootCompartment = null;
		int index=0;
		while (rootCompartment==null && index <containerEditPart.getChildren().size()){
			if((containerEditPart.getChildren().get(index)) instanceof ShapeCompartmentEditPart){
				rootCompartment= (ShapeCompartmentEditPart)(containerEditPart.getChildren().get(index));
			}
			index++;
		}

	}

}
