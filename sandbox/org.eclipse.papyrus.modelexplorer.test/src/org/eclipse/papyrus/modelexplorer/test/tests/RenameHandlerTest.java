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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.modelexplorer.handler.RenameDiagramHandler;
import org.eclipse.papyrus.table.modelexplorer.handlers.RenameTableHandler;
import org.eclipse.ui.internal.handlers.HandlerProxy;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.PackageImport;
import org.junit.Test;

/**
 * 
 * This command test the activation of the command org.eclipse.ui.edit.rename
 * 
 */
public class RenameHandlerTest extends AbstractHandlerTest {

	/**
	 * the id of the command to rename the element
	 */
	private static final String commandId = "org.eclipse.ui.edit.rename"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public RenameHandlerTest() {
		super(commandId);
	}

	/**
	 * We try to rename an UnnamedElement
	 */
	@Test
	public void renameUMLUnnamedElementTest() {
		List<Comment> comments = rootOfTheModel.getOwnedComments();
		Assert.isTrue(comments.size() != 0);
		for(int i = 0; i < rootOfTheModel.getOwnedComments().size(); i++) {
			selectElementInTheModelexplorer(rootOfTheModel.getOwnedComments().get(i));
			IHandler handler = getActiveHandler();
			if(handler != null) {
				Assert.isTrue(handler.isEnabled() == false, NLS.bind("The handler {0} is active on UMLUnnamedElement.", handler) + " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}

	/**
	 * We try to rename a NamedElement
	 */
	@Test
	public void renameUMLNamedElementTest() {
		selectElementInTheModelexplorer(rootOfTheModel);
		IHandler handler = getActiveHandler();
		//TODO import the handler
		Assert.isTrue(handler.getClass().getName().equals("org.eclipse.papyrus.uml.menu.handler.RenameNamedElementHandler"), NLS.bind("The handler {0} is actived on UML NamedElement, instead of org.eclipse.papyrus.uml.menu.handler.RenameNamedElementHandler",handler )); //$NON-NLS-1$ //$NON-NLS-2$
		Assert.isTrue(handler.isEnabled(), NLS.bind("The handler {0} is disabled on {1}.",new Object[]{handler,rootOfTheModel})+ " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
	}


	/**
	 * We try to rename a Diagram
	 */
	@Test
	public void renameDiagramTest() {
		for(int i = 0; i < diagrams.size(); i++) {
			selectElementInTheModelexplorer(diagrams.get(i));
			IHandler handler = getActiveHandler();
			Assert.isTrue(handler instanceof RenameDiagramHandler,  NLS.bind("The handler {0} is actived on Diagram, instead of RenameDiagramHandler",handler )); //$NON-NLS-1$
			Assert.isTrue(handler.isEnabled(),NLS.bind("The handler {0} is disabled on {1}.",new Object[]{handler,diagrams.get(i)})+ " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * We try to rename a Table
	 */
	@Test
	public void renameTableTest() {
		for(int i = 0; i < papyrusTable.size(); i++) {
			selectElementInTheModelexplorer(papyrusTable.get(i));
			IHandler handler = getActiveHandler();
			Assert.isTrue(handler instanceof RenameTableHandler, NLS.bind("The handler {0} is actived on Table, instead of RenameTableHandler ",handler )); //$NON-NLS-1$
			Assert.isTrue(handler.isEnabled(),NLS.bind("The handler {0} is disabled on {1}.",new Object[]{handler,papyrusTable.get(i)})+ " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * We try to rename a readonly element
	 */
	@Test
	public void renameReadOnlyElementsTest() {
		List<PackageImport> packageImports = rootOfTheModel.getPackageImports();
		commonViewer.expandToLevel(4);

		//the method revealSemanticelement doesn't work for imported element (bug 360092), so we use a workaround to write this JUnit test
		Object[] elements = commonViewer.getVisibleExpandedElements();
		List<Object> readOnlyElement = new ArrayList<Object>();
		for(int i = 0; i < elements.length; i++) {
			Object current = elements[i];
			if(current instanceof LinkItem) {
				if(((LinkItem)current).getReference().getName().equals("importedPackage")) { //$NON-NLS-1$
					readOnlyElement.addAll(((LinkItem)current).getChildren());
					break;
				}

			}
		}

		for(int j = 0; j < readOnlyElement.size(); j++) {
			selectElementInTheModelexplorer((ITreeElement)readOnlyElement.get(j));
			IHandler handler = getActiveHandler();
			if(handler == null) {
				//not a problem here
			} else {
				Assert.isTrue(handler.isEnabled()==false, NLS.bind("The handler {0} is enabled on {1}.",new Object[]{handler,readOnlyElement.get(j)})+ " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
			}
			return;
		}
	}

	/**
	 * We try to rename a LinkItem
	 */
	@Test
	public void renameLinkItemTest() {
		commonViewer.expandToLevel(3);
		Object[] expandedElement = commonViewer.getExpandedElements();
		for(Object object : expandedElement) {
			if(object instanceof org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem) {
				selectElementInTheModelexplorer((ITreeElement)object);
				IHandler handler = getActiveHandler();
				if(handler != null) {
					Assert.isTrue(handler.isEnabled() == false, NLS.bind("The handler {0} is enabled on {1}.",new Object[]{handler,object})+ " " + IT_IS_NOT_THE_REQUIRED_BEHAVIOR); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
	}
}
