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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagramqueryresult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmt.modisco.infra.query.runtime.ModelQueryResult;
import org.eclipse.gmt.modisco.infra.query.ui.views.queryExecution.QueryResultDisplayer;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.diagram.clazz.UmlClassDiagramForMultiEditor;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditor;
import org.eclipse.papyrus.diagram.common.command.wrappers.GEFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;


public class DiagramQueryResultDisplayer implements QueryResultDisplayer {
	
	/** The diagram editor. */
	protected UMLDiagramEditor diagramEditor=null;
	
	/** The clazzdiagramedit part. */
	protected DiagramEditPart clazzdiagrameditPart;



	/** The papyrus editor. */
	protected PapyrusMultiDiagramEditor papyrusEditor;

	public DiagramQueryResultDisplayer() {
		// TODO Auto-generated constructor stub
	}

	public void displayQueryResult(List<ModelQueryResult> result) {
		while( !(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()instanceof IMultiDiagramEditor)){}
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		DiResourceSet diResourceSet=EditorUtils.getDiResourceSet();
		papyrusEditor=((PapyrusMultiDiagramEditor)editorPart);
		CreateClassDiagramCommand command= new CreateClassDiagramCommand();
		command.createDiagram(diResourceSet, null, "result");

		Iterator<ModelQueryResult> resultIterator= result.iterator();
		while(resultIterator.hasNext()) {
			ModelQueryResult modelQueryResult = (ModelQueryResult)resultIterator.next();

			if(modelQueryResult.getValue() instanceof Collection){
				Iterator iter= ((Collection)modelQueryResult.getValue()).iterator();
				int i=0;
				while(iter.hasNext()) {
					Object object = (Object)iter.next();
					
					if( object instanceof Element){
						DropObjectsRequest dropObjectsRequest= new DropObjectsRequest();
						ArrayList list = new ArrayList();
						list.add((Element)object);
						dropObjectsRequest.setObjects(list);
						dropObjectsRequest.setLocation(new Point(20,100*i));
						Command commandDrop= getDiagramEditPart().getCommand(dropObjectsRequest);
						diagramEditor.getDiagramEditDomain().getDiagramCommandStack().execute(commandDrop);
						i++;
					}
				}
			}
		}
		List operationSet = getDiagramEditPart().getChildren();
		ArrangeRequest aRequest =  new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL, LayoutType.DEFAULT);
		//aRequest.setType(ActionIds.ACTION_ARRANGE_ALL);
		ArrayList toarrange= new ArrayList();
		toarrange.add(getDiagramEditPart());
		aRequest.setPartsToArrange(toarrange);
		Command commandArrangeAll = getDiagramEditPart().getCommand(aRequest);
		//getDiagramEditPart().getEditingDomain().getCommandStack().execute(new GEFtoEMFCommandWrapper(commandArrangeAll));
		
	


	}

	/**
	 * Gets the diagram edit part.
	 * 
	 * @return the diagram edit part
	 */
	protected DiagramEditPart getDiagramEditPart(){
			diagramEditor= (UmlClassDiagramForMultiEditor)papyrusEditor.getActiveEditor();
			clazzdiagrameditPart = (DiagramEditPart)diagramEditor.getGraphicalViewer().getEditPartRegistry().get(diagramEditor.getDiagram());
		return clazzdiagrameditPart;
	}

}
