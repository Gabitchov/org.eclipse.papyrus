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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.diagram.clazz.CreateClassDiagramCommand;
import org.eclipse.papyrus.diagram.clazz.UmlClassDiagramForMultiEditor;
import org.eclipse.papyrus.diagram.clazz.part.UMLDiagramEditor;
import org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.uml2.uml.Element;


/**
 * The Class AbstractPapyrusTestCase.
 */
public abstract class AbstractPapyrusTestCase extends TestCase {


	/** The papyrus editor. */
	protected PapyrusMultiDiagramEditor papyrusEditor;
	
	/** The di resource set. */
	protected ModelSet diResourceSet;
	
	/** The project. */
	protected IProject project;
	
	/** The file. */
	protected IFile file;
	
	/** The root. */
	protected IWorkspaceRoot root;
	
	/** The page. */
	protected IWorkbenchPage page;
	
	/** The diagram editor. */
	protected UMLDiagramEditor diagramEditor=null;
	
	/** The clazzdiagramedit part. */
	protected DiagramEditPart clazzdiagrameditPart;

	
	/**
	 * @see junit.framework.TestCase#setUp()
	 *
	 * @throws Exception
	 */
	
	protected void setUp() throws Exception {
		
		super.setUp();
		projectCreation();

		while( !(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()instanceof IMultiDiagramEditor)){}
		IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		papyrusEditor=((PapyrusMultiDiagramEditor)editorPart);
	}

	/**
	 * Gets the root view.
	 * 
	 * @return the root view
	 */
	protected View getRootView(){
		return getDiagramEditPart().getDiagramView();
	}
	
	/**
	 * Gets the root semantic model.
	 * 
	 * @return the root semantic model
	 */
	protected Element getRootSemanticModel(){
		return (Element) getRootView().getElement();
	}
	
	/**
	 * @see junit.framework.TestCase#tearDown()
	 *
	 * @throws Exception
	 */
	
	protected void tearDown() throws Exception {
		diagramEditor.doSave(new NullProgressMonitor());
		//diResourceSet.save( new NullProgressMonitor());
		//diagramEditor.close(true);
		diagramEditor=null;
		page.closeAllEditors(true);
		project.delete(true, new NullProgressMonitor());
		
		super.tearDown();
	}

	/**
	 * Gets the diagram edit part.
	 * 
	 * @return the diagram edit part
	 */
	protected DiagramEditPart getDiagramEditPart(){
		if(clazzdiagrameditPart== null){
			diagramEditor= (UmlClassDiagramForMultiEditor)papyrusEditor.getActiveEditor();
			System.err.println(diagramEditor.getGraphicalViewer().getContents().getRoot());
			clazzdiagrameditPart = (DiagramEditPart)diagramEditor.getGraphicalViewer().getContents().getRoot().getChildren().get(0);
		}
		return clazzdiagrameditPart;
	}
	
	/**
	 * Project creation.
	 */
	protected void projectCreation(){
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		root = workspace.getRoot();
		project = root.getProject("ClazzDiagramTestProject");
		file = project.getFile("ClazzDiagramTest.di");
		this.diResourceSet = new DiResourceSet();
		try{
			//at this point, no resources have been created
			if (!project.exists()) project.create(null);
			if (!project.isOpen()) project.open(null);

			if (!file.exists()) {
				diResourceSet.createsModels(file);
				ICreationCommand command= new CreateClassDiagramCommand();
				command.createDiagram((DiResourceSet)diResourceSet, null, "ClazzDiagram");
				diResourceSet.save( new NullProgressMonitor());
				
			}
			 page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
				page.openEditor(new FileEditorInput(file), desc.getId());
		}
		catch (Exception e) {
			System.err.println("error "+e);
		}
		
		
	}

}
