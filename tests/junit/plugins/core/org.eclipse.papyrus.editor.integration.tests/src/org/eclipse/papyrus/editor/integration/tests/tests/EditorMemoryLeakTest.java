/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.editor.integration.tests.tests;

import static org.junit.Assert.fail;

import java.util.Collections;

import org.eclipse.core.runtime.Platform;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.junit.utils.rules.Condition;
import org.eclipse.papyrus.junit.utils.rules.Conditional;
import org.eclipse.papyrus.junit.utils.rules.MemoryLeakRule;
import org.eclipse.papyrus.junit.utils.rules.MemoryLeakRule.SoftReferenceSensitive;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


/**
 * This is the EditorMemoryLeakTest type. Enjoy.
 */
public class EditorMemoryLeakTest extends AbstractEditorIntegrationTest {

	private static final String PROPERTY_SHEET = "org.eclipse.ui.views.PropertySheet";

	private static final String OUTLINE = "org.eclipse.ui.views.ContentOutline";

	private static final String PROJECT_EXPLORER = "org.eclipse.ui.navigator.ProjectExplorer";

	private static final String PACKAGE_EXPLORER = "org.eclipse.jdt.ui.PackageExplorer";

	@Rule
	public final MemoryLeakRule memory = new MemoryLeakRule();

	public EditorMemoryLeakTest() {
		super();
	}

	/**
	 * Verify that the Model Set does not leak when closing the editor.
	 */
	@Test
	public void testModelSetDoesNotLeak() {
		try {
			memory.add(getModelSet());
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Could not get model set");
		}
	}

	/**
	 * Verify that the UML Model content in the Model Explorer does not leak when closing the editor.
	 */
	@Test
	@SoftReferenceSensitive
	@Conditional(key = "isSupportedPlatform")
	public void testModelExplorerContentDoesNotLeak() {
		memory.add(getRootUMLModel());
	}

	/**
	 * Verify that diagram view parts do not leak when closing the editor.
	 */
	@Test
	@SoftReferenceSensitive
	public void testDiagramContentDoesNotLeak() {
		DiagramEditor diagramEditor = (DiagramEditor)editor.getActiveEditor();
		memory.add(diagramEditor.getDiagramEditPart());
	}

	/**
	 * Verify that the property sheet does not leak models when closing the editor.
	 */
	@Test
	@SoftReferenceSensitive
	@Conditional(key = "isSupportedPlatform")
	public void testPropertySheetContentDoesNotLeak() {
		// Activate the Properties view
		getView(PROPERTY_SHEET, true);

		// Select the Model element to show it in the Properties
		selectModelInModelExplorer();

		// Back to the Properties view
		getView(PROPERTY_SHEET, false);

		memory.add(getRootUMLModel());
	}

	//
	// Test framework
	//

	/**
	 * The memory leak tests all pass consistently on Mac OS X, but the {@link #testPropertySheetContentDoesNotLeak()} test
	 * fails (at least intermittently) on the Linux build server.
	 * 
	 * @return whether the current platform is supported by the conditional test
	 */
	@Condition
	public boolean isSupportedPlatform() {
		return !Platform.OS_LINUX.equals(Platform.getOS());
	}

	@Before
	public void openEditor() throws Exception {
		openEditor("simple_class_model");
	}

	void openEditor(String modelName) throws Exception {
		initModel(memory.getTestName(), modelName, getBundle());

		// Select the Model element
		selectModelInModelExplorer();

		flushDisplayEvents();
	}

	@After
	public void closeEditor() throws Exception {
		closeEditor(editor);

		// now, open a new editor and close it to ensure that views such as Model Explorer, Outline, etc. get
		// a new model into context and forget the previous
		openEditor("empty_model");

		try {
			getView(PROPERTY_SHEET, true);
			getView(OUTLINE, true);

			// Select something in the Project Explorer to flush the last model selection from the Properties view's default page
			selectProjectInProjectExplorer();
			flushDisplayEvents();

			getView(PROPERTY_SHEET, true);
			getView(OUTLINE, true);
		} finally {
			closeEditor(editor);
		}
	}

	void closeEditor(IEditorPart editor) {
		editor.getSite().getPage().closeEditor(editor, false);
		flushDisplayEvents();
	}

	IViewPart getView(String id, boolean open) {
		IViewPart result = null;

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		try {
			result = activeWorkbenchWindow.getActivePage().findView(id);
			if((result == null) && open) {
				result = activeWorkbenchWindow.getActivePage().showView(id);
			}

			if(result != null) {
				result.getSite().getPage().activate(result);
				flushDisplayEvents();
			}
		} catch (PartInitException e) {
			e.printStackTrace();
			fail("Failed to show a view: " + id);
		} finally {
			flushDisplayEvents();
		}

		return result;
	}

	void selectModelInModelExplorer() {
		getModelExplorerView().revealSemanticElement(Collections.singletonList(getRootUMLModel()));
		flushDisplayEvents();
	}

	void selectProjectInProjectExplorer() {
		ISetSelectionTarget projectExplorer = getProjectOrPackageExplorer();
		projectExplorer.selectReveal(new StructuredSelection(project));
		flushDisplayEvents();
	}

	ISetSelectionTarget getProjectOrPackageExplorer() {
		ISetSelectionTarget result = null;

		IViewPart explorer = getView(PROJECT_EXPLORER, false);
		if(explorer == null) {
			// Maybe we're in the Java perspective
			explorer = getView(PACKAGE_EXPLORER, false);
			if(explorer == null) {
				// Force the Project Explorer, then
				explorer = getView(PROJECT_EXPLORER, true);
			}
		}

		result = (ISetSelectionTarget)explorer;

		return result;
	}

	@Override
	protected String getSourcePath() {
		return "/model/basic/";
	}

}
