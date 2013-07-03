/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.sysml.nattable.requirement.tests.tests;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.commands.OpenDiagramCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.editor.integration.tests.tests.AbstractEditorIntegrationTest;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageManager;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationUtils;
import org.eclipse.papyrus.infra.nattable.common.editor.NatTableEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.Bundle;


public class OpenTableTest extends AbstractEditorIntegrationTest {

	/**
	 * This test allows to be sure that we doesn't break existing table model
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOpenExistingTable() throws Exception {
		initModel("requirementtableTest", "openTest", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(1, pageManager.allPages().size());
		IEditorPart tableEditor = editor.getActiveEditor();
		Assert.assertNull(tableEditor);
		Resource notationResource = NotationUtils.getNotationModel(editor.getServicesRegistry().getService(ModelSet.class)).getResource();
		Table requirementTable = (Table)notationResource.getContents().get(0);
		TransactionalEditingDomain editingDomain = editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, requirementTable)));
		//to refresh the table content
		while(Display.getDefault().readAndDispatch());
		tableEditor = editor.getActiveEditor();
		Assert.assertTrue(tableEditor instanceof NatTableEditor);
		INattableModelManager manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager);
		Assert.assertEquals(AllTests.REQUIREMENT_TABLE_ID, manager.getTable().getTableConfiguration().getType());

	}

	@Override
	protected String getSourcePath() {
		return "/resources/"; //$NON-NLS-1$
	}

	@Override
	protected Bundle getBundle() {
		return org.eclipse.papyrus.sysml.nattable.requirement.tests.Activator.getDefault().getBundle();
	}

	@AfterClass
	public static void endOfTest() {
		GenericUtils.closeAllEditors();
	}
}
