/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.editor.integration.tests.tests;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.commands.DestroyElementPapyrusCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.uml.diagram.clazz.UmlClassDiagramForMultiEditor;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests the cases where the di model is not totally valid
 * The Editor should be able to load the valid parts and should not
 * fail on the invalid ones
 *
 * In most cases, we're simply interested in opening the Papyrus Editor
 * (i.e. the model is invalid, so we don't expect to be able to manipulate
 * the diagrams; but we should still be able to manipulate the editor
 * and the semantic model, create new digrams, etc).
 *
 * @author Camille Letavernier
 *
 */
public class RecoveryTest extends AbstractEditorIntegrationTest {

	private static final String SOURCE_PATH = "/model/recovery/";

	//Should work
	@Test
	public void testInvalidAvailablePage() throws Exception {
		initModel("invalidAvailablePage", "invalidAvailablePage", getBundle());
		Assert.assertTrue(editor.getActiveEditor() instanceof UmlClassDiagramForMultiEditor);
		//IPageManager manager = editor.getServicesRegistry().getService(IPageManager.class);
		//Is the page manager supposed to filter the invalid pages..?
		//Assert.assertEquals(2, manager.allPages().size());
	}

	//Should work
	//Bug 401109: [PageManager] Deleting an element which contains an opened page leads to critical model corruption
	@Test
	public void testInvalidTab() throws Exception {
		initModel("invalidTab", "invalid_child_tab", getBundle());
		IPageManager manager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(1, manager.allPages().size());
	}

	@Ignore("Recovery not supported")
	//Not fixed yet
	//Starts with an empty Di Model (All the contents have been erased, except the root xmi tag)
	//We should be able to open a Papyrus editor and manipulate the PageManager
	@Test
	public void testEmptyDiModel() throws Exception {
		initModel("emptyDiModel", "empty_di_model", getBundle());
		IPageManager manager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(0, manager.allPages().size());
		NotationModel notationModel = (NotationModel)editor.getServicesRegistry().getService(ModelSet.class).getModel(NotationModel.MODEL_ID);
		Assert.assertEquals(1, notationModel.getResource().getContents().size());
		Diagram diagram = (Diagram)notationModel.getResource().getContents().get(0);
		manager.openPage(diagram);
		Assert.assertEquals(1, manager.allPages().size());
	}

	//We should be able to open a page even if is not (yet) in the availablePages list
	@Test
	@Ignore("This test is not required anymore, as the allPages() is computed dynamically (Bug 429239)")
	public void testUnavailablePageRecovery() throws Exception {
		initModel("unavailablePageRecovery", "missing_page_recovery", getBundle());
		final IPageManager manager = editor.getServicesRegistry().getService(IPageManager.class);
		int availablePages = manager.allPages().size();
		NotationModel notationModel = (NotationModel)editor.getServicesRegistry().getService(ModelSet.class).getModel(NotationModel.MODEL_ID);
		Assert.assertEquals("Cannot find the diagram to open", 1, notationModel.getResource().getContents().size());

		final Diagram diagram = (Diagram)notationModel.getResource().getContents().get(0);

		TransactionalEditingDomain domain = editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		domain.getCommandStack().execute(new RecordingCommand(domain, "Open diagram") {

			@Override
			protected void doExecute() {
				manager.openPage(diagram);
			}
		});

		Assert.assertEquals("A new page should be available", availablePages + 1, manager.allPages().size());
	}

	//Should work. The invalid tab is loaded as an "unresolved tab" and displays a warning.
	@Test
	public void testProxyDiagram() throws Exception {
		initModel("proxyDiagram", "proxy_diagram_recovery", getBundle());
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(2, pageManager.allPages().size());
	}

	@Ignore("Disabled because the Papyrus Editor opens a user dialog. Won't run on Hudson.")
	//Should work
	/** @see {link #testInvalidTab()} */
	@Test
	public void testProxyTable() throws Exception {
		initModel("proxyTable", "proxy_table_recovery", getBundle());
		//IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		//Assert.assertEquals(2, pageManager.allPages());
	}

	//This model contains a few different errors (Unresolved proxy, invalid tabs, invalid available pages, ...)
	@Test
	public void testCompleteCase() throws Exception {
		initModel("completeCase", "complex_invalid_model", getBundle());
		//		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		//		Assert.assertEquals(3, pageManager.allPages().size());
	}

	//We should be able to delete a diagram, even when there is an invalid page in the model
	@Test
	public void testDeleteDiagramWithInvalidAvailablePage() throws Exception {
		initModel("deleteDiagramWithInvalidPage", "invalidAvailablePage", getBundle());

		//Di layout: Diagram 0 - Invalid page - Diagram 1
		//We take the diagram at index 1 (i.e. after the invalid page) and try to delete it
		final Diagram diagram = (Diagram)NotationUtils.getNotationModel(editor.getServicesRegistry().getService(ModelSet.class)).getResource().getContents().get(1);

		final IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);

		//Check initial state
		int availablePages = pageManager.allPages().size();

		TransactionalEditingDomain editingDomain = editor.getServicesRegistry().getService(TransactionalEditingDomain.class);

		CompoundCommand command = new CompoundCommand("Delete diagram");

		Command sashRemoveComd = new RecordingCommand(editingDomain, "Remove page") {

			@Override
			protected void doExecute() {
				pageManager.removePage(diagram);
			}

		};

		command.append(sashRemoveComd);
		command.append(new GMFtoEMFCommandWrapper(new DestroyElementPapyrusCommand(new DestroyElementRequest(diagram, false))));

		editingDomain.getCommandStack().execute(command);

		Assert.assertEquals("The page has not been correctly removed", availablePages - 1, pageManager.allPages().size());
		Assert.assertNull("The diagram should not be contained in the resource anymore", diagram.eResource());
	}

	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}
}
