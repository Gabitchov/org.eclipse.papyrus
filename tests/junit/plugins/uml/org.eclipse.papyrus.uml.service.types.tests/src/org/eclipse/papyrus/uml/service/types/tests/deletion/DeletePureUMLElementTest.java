/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.tests.deletion;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.junit.utils.PapyrusProjectUtils;
import org.eclipse.papyrus.junit.utils.ProjectUtils;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class that provides tests only for UML based models, no DI/Notation
 * <P>
 * Goal of this class is to test the uml implementation, ex. SubsetAddComand
 * </P>
 */
public class DeletePureUMLElementTest {

	private static final int deleteActivityChildrenSize = 4;

	private static IProject createProject;

	private static IFile copyPapyrusModel;
	
	private static Model rootModel;

	private static TransactionalEditingDomain transactionalEditingDomain;

	private static Resource resource;

	private static TransactionalEditingDomain domain;

	private static Activity testActivityDelete;

	private static ActivityNode centralBufferNode1;

	private static ActivityNode centralBufferNode2;

	private static ActivityNode addVariableValueAction1;

	private static ActivityNode addVariableValueAction2;

	@BeforeClass
	public static void initTest() {
		// create Project
		try {
			createProject = ProjectUtils.createProject("UMLOnlyTest");
		} catch (CoreException e) {
			fail(e.getMessage());
		}

		// create UML resource
		// import test model
		try {
			copyPapyrusModel = PapyrusProjectUtils.copyIFile("/resource/TestPureUMLModel.uml", Platform.getBundle("org.eclipse.papyrus.uml.service.types"), createProject, "TestPureUMLModel.uml");
		} catch (CoreException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		// open model as UML resource
		ResourceSet set = new ResourceSetImpl();
		domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(set);
		resource = set.createResource(URI.createPlatformResourceURI(createProject.getName()+'/'+copyPapyrusModel.getName(), true));
		try {
			resource.load(Collections.emptyMap());
		} catch (IOException e) {
			fail(e.getMessage());
		}
		
		rootModel = (Model)resource.getContents().get(0);
		assertNotNull("Model should not be null", rootModel);
		try {
			initExistingElements();
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	/**
	 * Init fields corresponding to element in the test model
	 */
	private static void initExistingElements() throws Exception {
		// existing test delete activity
		testActivityDelete = (Activity)rootModel.getOwnedMember("TestActivityDelete");
		assertNotNull("Impossible to find test activity for deletion ", testActivityDelete);
		
		centralBufferNode1 = testActivityDelete.getNode("CentralBufferNode1");
		assertNotNull("Impossible to find element for deletion ", centralBufferNode1);
	
		centralBufferNode2 = testActivityDelete.getNode("CentralBufferNode2");
		assertNotNull("Impossible to find element for deletion ", centralBufferNode2);
		
		addVariableValueAction1 = testActivityDelete.getNode("AddVariableValueAction1");
		assertNotNull("Impossible to find element for deletion ", addVariableValueAction1);
		addVariableValueAction2 = testActivityDelete.getNode("AddVariableValueAction2");
		assertNotNull("Impossible to find element for deletion ", addVariableValueAction2);
	}

	@Test
	public void testDeleteOneAddVariableValueAction() throws Exception {
		int initialNumberOfNodes = testActivityDelete.getOwnedNodes().size();
		assertEquals("Test delete: Initialisation", deleteActivityChildrenSize, initialNumberOfNodes);
		
		Command command = getDeleteChildCommand(addVariableValueAction1, true);
		domain.getCommandStack().execute(command);
		Assert.assertEquals("Wrong number of owned nodes after deletion", initialNumberOfNodes-1, testActivityDelete.getOwnedNodes().size());
		Assert.assertEquals("Wrong number of nodes after deletion", initialNumberOfNodes-1, testActivityDelete.getNodes().size());
		
		domain.getCommandStack().undo();
		Assert.assertEquals("Wrong number of owned nodes after undo", initialNumberOfNodes, testActivityDelete.getOwnedNodes().size());
		Assert.assertEquals("Wrong number of nodes after undo", initialNumberOfNodes, testActivityDelete.getNodes().size());
		
		domain.getCommandStack().redo();
		Assert.assertEquals("Wrong number of owned nodes after redo", initialNumberOfNodes-1, testActivityDelete.getOwnedNodes().size());
		Assert.assertEquals("Wrong number of nodes after redo", initialNumberOfNodes-1, testActivityDelete.getNodes().size());

		domain.getCommandStack().undo();
		Assert.assertEquals("Wrong number of nodes after 2nd undo", initialNumberOfNodes, testActivityDelete.getNodes().size());
	}
	
	@Test
	public void testDeleteOneCentralBufferNode() throws Exception {
		int initialNumberOfNodes = testActivityDelete.getOwnedNodes().size();
		assertEquals("Test delete: Initialisation", deleteActivityChildrenSize, initialNumberOfNodes);
		
		Command command = getDeleteChildCommand(centralBufferNode1, true);
		domain.getCommandStack().execute(command);
		Assert.assertEquals("Wrong number of owned nodes after deletion", initialNumberOfNodes-1, testActivityDelete.getOwnedNodes().size());
		Assert.assertEquals("Wrong number of nodes after deletion", initialNumberOfNodes-1, testActivityDelete.getNodes().size());
		
		domain.getCommandStack().undo();
		Assert.assertEquals("Wrong number of owned nodes after undo", initialNumberOfNodes, testActivityDelete.getOwnedNodes().size());
		Assert.assertEquals("Wrong number of nodes after undo", initialNumberOfNodes, testActivityDelete.getNodes().size());
		
		domain.getCommandStack().redo();
		Assert.assertEquals("Wrong number of owned nodes after redo", initialNumberOfNodes-1, testActivityDelete.getOwnedNodes().size());
		Assert.assertEquals("Wrong number of nodes after redo", initialNumberOfNodes-1, testActivityDelete.getNodes().size());

		domain.getCommandStack().undo();
		Assert.assertEquals("Wrong number of nodes after 2nd undo", initialNumberOfNodes, testActivityDelete.getNodes().size());
	}
	
	/**
	 * Creates the element in the given owner element, undo and redo the action
	 * 
	 * @param owner
	 *        owner of the new element
	 * @param hintedType
	 *        type of the new element
	 * @param canCreate
	 *        <code>true</code> if new element can be created in the specified owner
	 */
	protected Command getDeleteChildCommand(EObject objectToDelete, boolean canDelete) throws Exception {
		IElementEditService elementEditService = ElementEditServiceUtils.getCommandProvider(objectToDelete);
		ICommand command = elementEditService.getEditCommand(new DestroyElementRequest(objectToDelete, false));
		assertNotNull("Delete command should not be null", command);
		// test if the command is enable and compare with the canCreate parameter
		boolean canExecute = command.canExecute();
		if(canExecute) {
			// executable but was expected as not executable
			if(!canDelete) {
				fail("Delete command is executable but it was expected as not executable");
			} else {
				// command is executable, and it was expected to => run the creation 
				Command emfCommand = new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(command);
				return emfCommand;
			}
		} else {
			if(canDelete) {
				fail("Delete command is not executable but it was expected to be executable");
			}
		}
		return null;
	}

}
