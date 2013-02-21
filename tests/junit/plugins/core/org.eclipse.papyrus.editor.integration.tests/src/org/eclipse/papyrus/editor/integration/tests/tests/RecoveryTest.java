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

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.uml.diagram.clazz.UmlClassDiagramForMultiEditor;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests the cases where the di model is not totally valid
 * The Editor should be able to load the valid parts and should not
 * fail on the invalid ones
 * 
 * @author Camille Letavernier
 * 
 */
public class RecoveryTest extends AbstractEditorIntegrationTest {

	private static final String SOURCE_PATH = "/model/recovery/";

	//Should work
	@Test
	public void testInvalidAvailablePage() throws Exception {
		initModel("invalidAvailablePage", "invalidAvailablePage");
		Assert.assertTrue(editor.getActiveEditor() instanceof UmlClassDiagramForMultiEditor);
		//IPageManager manager = editor.getServicesRegistry().getService(IPageManager.class);
		//Is the page manager supposed to filter the invalid pages..?
		//Assert.assertEquals(2, manager.allPages().size());
	}

	//Not fixed yet. Bug 401109: [PageManager] Deleting an Activity leads to critical model corruption
	//FIXME Critical
	@Test
	public void testInvalidTab() throws Exception {
		initModel("invalidTab", "invalid_child_tab");
		IPageManager manager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(1, manager.allPages().size());
	}

	@Ignore("Recovery not supported")
	//Not fixed yet
	//Starts with an empty Di Model (All the contents have been erased, except the root xmi tag)
	//We should be able to open a Papyrus editor and manipulate the PageManager
	@Test
	public void testEmptyDiModel() throws Exception {
		initModel("emptyDiModel", "empty_di_model");
		IPageManager manager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(0, manager.allPages().size());
		NotationModel notationModel = (NotationModel)editor.getServicesRegistry().getService(ModelSet.class).getModel(NotationModel.MODEL_ID);
		Assert.assertEquals(1, notationModel.getResource().getContents().size());
		Diagram diagram = (Diagram)notationModel.getResource().getContents().get(0);
		manager.openPage(diagram);
		Assert.assertEquals(1, manager.allPages().size());
	}

	//We should be able to open a page even if is not (yet) in the availablePages list
	//This works programmatically, but is not supported by the current implementation of handler#isEnabled
	@Test
	public void testUnavailablePageRecovery() throws Exception {
		initModel("unavailablePageRecovery", "missing_page_recovery");
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
		initModel("proxyDiagram", "proxy_diagram_recovery");
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(2, pageManager.allPages().size());
	}

	@Ignore("Recovery not supported")
	//Not fixed yet. Fails when the <children> tag contains an unresolved local URI (i.e. an invalid uri within the same resource)
	//Works when only the availablePage is invalid
	/** @see {link #testInvalidTab()} */
	@Test
	public void testProxyTable() throws Exception {
		initModel("proxyTable", "proxy_table_recovery");
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(2, pageManager.allPages());
	}

	@Ignore("Recovery not supported")
	//Not fixed yet
	//This model contains a few different errors (Unresolved proxy, invalid tabs, invalid available pages, ...)
	@Test
	public void testCompleteCase() throws Exception {
		initModel("completeCase", "complex_invalid_model");
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(3, pageManager.allPages().size());
	}

	@Override
	protected String getSourcePath() {
		return SOURCE_PATH;
	}
}
