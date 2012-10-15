/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.dragdrop;

import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.papyrus.sysml.modelexplorer.tests.common.AbstractModelExplorerTest;
import org.eclipse.papyrus.sysml.modelexplorer.tests.utils.EditorUtils;
import org.eclipse.papyrus.views.modelexplorer.CustomCommonViewer;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.views.modelexplorer.NavigatorUtils;
import org.eclipse.swt.dnd.DND;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.navigator.dnd.NavigatorDnDService;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;
import org.junit.Assert;
import org.junit.Before;

/**
 * Abstract Class to implement diagram drag and drop tests.
 */
public class AbstractDragDropTest extends AbstractModelExplorerTest {

	/**
	 * prepare the copy
	 * 
	 * @throws Exception
	 *         exception thrown in case of problems
	 */
	@Before
	public void testPrepare() throws Exception {
		// check editor state (should be non dirty)
		//FIXME: In Papyrus, the editor may be dirty at initialization. This should not be tested here. We simply save the editor as soon as it is opened.
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().doSave(new NullProgressMonitor());
		Assert.assertFalse("Editor should not be dirty at initialization", isEditorDirty());
	}

	public List<CompoundCommand> getListOfDropCommands(EObject sourceElement, EObject targetElement) throws Exception {
		// init source object
		ModelElementItem sourceMEI = null;
		if(sourceElement instanceof Diagram) {
			sourceMEI = findSemanticModelElementItem((Diagram)sourceElement);
		} else {
			sourceMEI = findSemanticModelElementItem(sourceElement);
		}
		ModelElementItem targetMEI = null;
		if(targetElement instanceof Diagram) {
			targetMEI = findSemanticModelElementItem((Diagram)targetElement);
		} else {
			targetMEI = findSemanticModelElementItem(targetElement);
		}
		if(sourceElement instanceof Diagram) {
			selectAndRevealDiagram((Diagram)sourceElement);
		} else {
			selectAndReveal(sourceElement);
		}
		ModelExplorerView modelExplorerView = null;
		ModelExplorerPageBookView bookViewPart = (ModelExplorerPageBookView)NavigatorUtils.findViewPart(ModelExplorerPageBookView.VIEW_ID);
		if(bookViewPart != null) {
			modelExplorerView = (ModelExplorerView)bookViewPart.getActiveView();
			Assert.assertNotNull("Impossible to find model explorer view", modelExplorerView);
		}
		NavigatorDnDService dndService = (NavigatorDnDService)modelExplorerView.getNavigatorContentService().getDnDService();
		Assert.assertNotNull("Impossible to find dnd service", dndService);
		CommonDropAdapter commonDropAdapter = ((CustomCommonViewer)modelExplorerView.getCommonViewer()).getDropAdapter();
		CommonDropAdapterAssistant[] commonDropAdapterAssistants = dndService.findCommonDropAdapterAssistants(targetMEI, (IStructuredSelection)modelExplorerView.getCommonViewer().getSelection());
		List<CompoundCommand> results = new ArrayList<CompoundCommand>();
		for(CommonDropAdapterAssistant assistant : commonDropAdapterAssistants) {
			// try to adapt to a Papyrus drop assistant. If not, send a warning
			if(!(assistant instanceof org.eclipse.papyrus.views.modelexplorer.dnd.CommonDropAdapterAssistant)) {
				fail("this test expects that only papyrus drop assistants are provided for papyrus model explorer");
			}
			org.eclipse.papyrus.views.modelexplorer.dnd.CommonDropAdapterAssistant papyrusAssistant = ((org.eclipse.papyrus.views.modelexplorer.dnd.CommonDropAdapterAssistant)assistant);
			Field currentOperationField = ViewerDropAdapter.class.getDeclaredField("currentOperation");
			Assert.assertNotNull(currentOperationField);
			currentOperationField.setAccessible(true);
			currentOperationField.set(commonDropAdapter, DND.DROP_MOVE);
			System.err.println(commonDropAdapter.getCurrentOperation()); // should be 2
			Field currentLocationField = ViewerDropAdapter.class.getDeclaredField("currentLocation");
			Assert.assertNotNull(currentLocationField);
			currentLocationField.setAccessible(true);
			currentLocationField.set(commonDropAdapter, ViewerDropAdapter.LOCATION_ON);
			System.err.println(commonDropAdapter.getCurrentLocation()); // should be 3
			LocalSelectionTransfer.getTransfer().setSelection(modelExplorerView.getCommonViewer().getSelection());
			CompoundCommand command = papyrusAssistant.getDrop(targetMEI);
			results.add(command);
		}
		return results;
	}

	public void testExecutableDropOfDiagram(Diagram sourceElement, EObject targetElement) throws Exception {
		Assert.assertFalse("Editor should not be dirty at the beginning of the test", EditorUtils.getEditor().isDirty());
		EObject initialDiagramContainer = sourceElement.getElement();
		// find command for the drag / drop (source, target)
		List<CompoundCommand> dropCommands = getListOfDropCommands(sourceElement, targetElement);
		// create only one compound command
		CompoundCommand executableCommand = new CompoundCommand();
		for(CompoundCommand cc : dropCommands) {
			executableCommand.append(cc);
		}
		getEditingDomain().getCommandStack().execute(executableCommand);
		// check results
		Assert.assertEquals("Context of the diagram should be the target: " + printElement(targetElement), targetElement, sourceElement.getElement());
		Assert.assertNotNull("diagram should still be contained in a resource", sourceElement.eResource());
		// try to undo
		getEditingDomain().getCommandStack().undo();
		Assert.assertEquals("Context of the diagram should be the initial value: " + printElement(initialDiagramContainer), initialDiagramContainer, sourceElement.getElement());
		// try to redo
		getEditingDomain().getCommandStack().redo();
		// check results
		Assert.assertEquals("Context of the diagram should be the target: " + printElement(targetElement), targetElement, sourceElement.getElement());
		Assert.assertNotNull("diagram should still be contained in a resource", sourceElement.eResource());
		// undo to go to previous state
		getEditingDomain().getCommandStack().undo();
		Assert.assertEquals("Context of the diagram should be the initial value: " + printElement(initialDiagramContainer), initialDiagramContainer, sourceElement.getElement());

		Assert.assertFalse("Editor should not be dirty at the end of the test", EditorUtils.getEditor().isDirty());
	}

	public void testUnexecutableDropOfDiagram(Diagram sourceElement, EObject targetElement) throws Exception {
		// find command for the drag / drop (source, target)
		List<CompoundCommand> dropCommands = getListOfDropCommands(sourceElement, targetElement);
		// create only one compound command
		// boolean that indicates that the command can really be not executable
		boolean notexecutable = true;
		for(CompoundCommand cc : dropCommands) {
			if(cc != null && !cc.isEmpty()) {
				if(cc.canExecute()) {
					notexecutable = false;
				}
			}
		}
		Assert.assertTrue("It should be impossible to move " + printElement(sourceElement) + " on " + printElement(targetElement), notexecutable);
	}
}
