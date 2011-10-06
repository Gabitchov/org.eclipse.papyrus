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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.test.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.Element;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.CommandManager;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.facet.infra.browser.uicore.CustomizationManager;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.emf.facet.util.core.internal.FileUtils;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.modelexplorer.handler.DeleteCommandHandler;
import org.eclipse.papyrus.modelexplorer.handler.DeleteDiagramHandler;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.table.modelexplorer.handlers.DeleteTableHandler;
import org.eclipse.papyrus.table.modelexplorer.handlers.RenameTableHandler;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.handlers.HandlerProxy;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.services.IServiceLocator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.internal.impl.AssociationImpl;
import org.eclipse.emf.facet.infra.facet.FacetFactory;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.impl.*;
import org.eclipse.emf.facet.infra.browser.custom.MetamodelView ;
/**
 * 
 * @author VL222926
 * 
 *         This plugin tests the activation of the correct handler for differents selection in the ModelExplorer
 */
//FIXME : remove the dependency with EMF-Facet
public class DeleteHandlerTest extends AbstractHandlerTest {

	/**
	 * the id of the delete command
	 */
	private static final String DELETE_COMMAND_ID = "org.eclipse.ui.edit.delete"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DeleteHandlerTest() {
		super(DELETE_COMMAND_ID);
	}

	/**
	 * We test if we can delete the root of the Model or not
	 */
	@Test
	public void deleteRootOfTheModel() {
		selectElementInTheModelexplorer(rootOfTheModel);
		IHandler handler = getActiveHandler();
		if(handler == null) {
			//not a problem in this case
		} else {
			Assert.isTrue(handler.isEnabled() == false, NLS.bind("The handler {0} is enabled on the root of the model", handler) + " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR);  //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
	/**
	 * We test if we can delete other uml elements
	 */
	@Test
	public void deleteUMLElementsTest() {
		List<PackageableElement> packagedElements = rootOfTheModel.getPackagedElements();
		for(int i = 0; i < packagedElements.size(); i++) {
			selectElementInTheModelexplorer(packagedElements.get(i));
			IHandler handler = getActiveHandler();
			Assert.isTrue(handler instanceof DeleteCommandHandler, NLS.bind("The handler {0} is actived on {1} instead of org.eclipse.papyrus.modelexplorer.handler.DeleteCommandHandler", new Object[]{handler, packagedElements.get(i)})); //$NON-NLS-1$
			Assert.isTrue(handler.isEnabled(), NLS.bind("The handler {0} is disabled on {1}.",new Object[]{handler,packagedElements.get(i)})+ " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	

	/**
	 * We test the delete on the diagrams
	 */
	@Test
	public void deleteDiagramTest() {
		for(int i = 0; i < diagrams.size(); i++) {
			selectElementInTheModelexplorer(diagrams.get(i));
			IHandler handler =  getActiveHandler();
			Assert.isTrue(handler instanceof DeleteDiagramHandler, NLS.bind("The handler {0} is actived on {1} instead of instead of org.eclipse.papyrus.modelexplorer.handler.DeleteCommandHandler",handler)); //$NON-NLS-1$
			Assert.isTrue(handler.isEnabled(), NLS.bind("The handler {0} is disabled on {1}.",new Object[]{handler,diagrams.get(i)})+ " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
	/**
	 * We test the delete on the table instance
	 */
	@Test
	public void deletePapyrusTableInstanceTest() {
		for(int i = 0; i < papyrusTable.size(); i++) {
			selectElementInTheModelexplorer(papyrusTable.get(i));
			IHandler handler = getActiveHandler();
			Assert.isTrue(handler instanceof DeleteTableHandler,NLS.bind("The handler {0} is actived on {1} instead of org.eclipse.papyrus.table.modelexplorer.handlers.DeleteTableHandler", new Object[]{handler, papyrusTable.get(i)})); //$NON-NLS-1$
			Assert.isTrue(handler.isEnabled(), "We can't delete the following element" + papyrusTable.get(i)); //$NON-NLS-1$
		}
	}

	/**
	 * We test the delete on the ReadOnly element 
	 */
	@Test
	public void deleteReadOnlyElementsTest() {

		List<PackageImport> packageImports = rootOfTheModel.getPackageImports();		
		commonViewer.expandToLevel(4);
		
		//the method revealSemanticelement doesn't work for imported element (bug 360092), so we use a workaround to write this JUnit test
		Object[] elements = commonViewer.getVisibleExpandedElements();
		List<Object> readOnlyElement = new ArrayList<Object>();
		for(int i=0;i<elements.length;i++){
			Object current = elements[i];
			if(current instanceof LinkItem){
				if(((LinkItem)current).getReference().getName().equals("importedPackage")){ //$NON-NLS-1$
					readOnlyElement.addAll(((LinkItem)current).getChildren());
					break;
				}
			
			}
		}
		
		for(int j=0;j<readOnlyElement.size();j++){
			selectElementInTheModelexplorer((ITreeElement)readOnlyElement.get(j));
			IHandler handler = getActiveHandler();
			if(handler==null){
				//not a problem here
			}else{
				Assert.isTrue(!handler.isEnabled(),NLS.bind("The handler {0} is enabled on read-only element",handler) + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$
			}
			return;
		}
	}
	
	/**
	 * we test the delete on the link item
	 */
	@Test
	public void deleteLinkItemTest() {
		commonViewer.expandToLevel(3);
		Object[] expandedElement = commonViewer.getExpandedElements();
		for(Object object : expandedElement) {
			if(object instanceof org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem) {
				selectElementInTheModelexplorer((ITreeElement)object);
				IHandler handler = getActiveHandler();
				if(handler != null) {
					Assert.isTrue(!handler.isEnabled(), NLS.bind("The handler {0} is enabled on LinkItem",handler) + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$
				}
			}
		}
	}
}
