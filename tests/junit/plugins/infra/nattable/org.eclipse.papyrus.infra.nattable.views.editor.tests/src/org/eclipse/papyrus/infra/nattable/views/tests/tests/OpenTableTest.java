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
package org.eclipse.papyrus.infra.nattable.views.tests.tests;

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
import org.eclipse.ui.IEditorPart;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.osgi.framework.Bundle;

/**
 * Test the opening of an existing table
 * 
 * @author vl222926
 * 
 */
public class OpenTableTest extends AbstractEditorIntegrationTest {

	@BeforeClass
	public static void startOfTest() {
//		GenericUtils.closeAllEditors();
	}

	/**
	 * This test allows to be sure that we doesn't break existing table model
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOpenExistingTable() throws Exception {
		initModel("tableOfViewsTest", "openTest", getBundle()); //$NON-NLS-1$ //$NON-NLS-2$
		IPageManager pageManager = editor.getServicesRegistry().getService(IPageManager.class);
		Assert.assertEquals(1, pageManager.allPages().size());
		IEditorPart tableEditor = editor.getActiveEditor();
		Assert.assertNull(tableEditor);
		Resource notationResource = NotationUtils.getNotationModel(editor.getServicesRegistry().getService(ModelSet.class)).getResource();
		Table requirementTable = (Table)notationResource.getContents().get(0);
		TransactionalEditingDomain editingDomain = editor.getServicesRegistry().getService(TransactionalEditingDomain.class);
		editingDomain.getCommandStack().execute(new GMFtoEMFCommandWrapper(new OpenDiagramCommand(editingDomain, requirementTable)));
		DisplayUtils.safeReadAndDispatch();
		tableEditor = editor.getActiveEditor();
		Assert.assertTrue(tableEditor instanceof NatTableEditor);
		INattableModelManager manager = (INattableModelManager)tableEditor.getAdapter(INattableModelManager.class);
		Assert.assertNotNull(manager);
	}

	@Override
	protected String getSourcePath() {
		return "/resources/"; //$NON-NLS-1$
	}

	@Override
	protected Bundle getBundle() {
		return org.eclipse.papyrus.infra.nattable.views.tests.Activator.getDefault().getBundle();
	}

	@AfterClass
	public static void endOfTest() {
		GenericUtils.closeAllEditors();
	}

}
