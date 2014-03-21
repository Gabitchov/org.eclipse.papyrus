package org.eclipse.papyrus.integrationtests.editor.undoredo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.eclipse.papyrus.infra.core.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.integrationtests.editor.DiagramCreationException;
import org.eclipse.papyrus.integrationtests.editor.DiagramCreator;
import org.eclipse.papyrus.integrationtests.editor.EditorCreationException;
import org.eclipse.papyrus.integrationtests.editor.ExecutionException;
import org.eclipse.papyrus.integrationtests.editor.ProgramaticPapyrusEditor;
import org.eclipse.papyrus.integrationtests.editor.operationhistory.IOperationHistoryHandler;
import org.eclipse.papyrus.integrationtests.editor.operationhistory.OperationHistoryHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Integration tests.
 * Check the undo/redo after nested editor creation.
 * 
 * @author cedric dumoulin
 *
 */
public class UndoRedoAfterEditorCreationTest {

	/**
	 * Handler on a newly created editor
	 */
	protected ProgramaticPapyrusEditor editorHandler;
	
	/**
	 * A diagram creator associated to the editor.
	 * Used to create diagrams.
	 */
	protected DiagramCreator diagramCreator;
	
	/**
	 * Create a new editor
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		editorHandler = new ProgramaticPapyrusEditor();
		diagramCreator = new DiagramCreator(editorHandler);
	}

	/**
	 * Dispose the editor.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		editorHandler.dispose();
	}

	/**
	 * @throws DiagramCreationException 
	 * @throws EditorCreationException 
	 * @throws ServiceException 
	 * 
	 */
	@Test
	public void testUndoRedoUndo() throws DiagramCreationException, EditorCreationException, ServiceException {
		
		TransactionalEditingDomain domain = editorHandler.getServiceRegistry().getService(TransactionalEditingDomain.class);
		CommandStack cstack = domain.getCommandStack();
		
		// Create one diagram
		IPage createdPage = diagramCreator.createEmfTreeDiagram("newDiagram");
		assertNotNull("diagram created", createdPage);
		// Try to undo
		editorHandler.undo();
		assertNull("diagram removed", editorHandler.getEditor().getActiveEditor());
		
		// Try to redo
		editorHandler.redo();
		assertNotNull("diagram exist", editorHandler.getEditor().getActiveEditor());
		
		// Try to undo
		editorHandler.undo();
		assertNull("diagram removed", editorHandler.getEditor().getActiveEditor());
		
		// Try to redo
		editorHandler.redo();
		assertNotNull("diagram exist", editorHandler.getEditor().getActiveEditor());
		// Check di now
		
	}

	/**
	 * @throws ServiceException 
	 * @throws ExecutionException 
	 * 
	 */
	@Test
	public void testUndoRedoUndoIOperationHistory() throws ServiceException, ExecutionException {
		
		// Create one diagram
		IPage createdPage = diagramCreator.createEmfTreeDiagram("newDiagram");
		assertNotNull("diagram created", createdPage);

		IOperationHistoryHandler history = new OperationHistoryHandler(editorHandler);
		
		// Try to undo
		assertTrue("Can undo", history.canUndo());
		history.undo();
		assertNull("diagram removed", editorHandler.getEditor().getActiveEditor());
		
		
		// Try to redo
		assertTrue("Can redo", history.canRedo());
		history.redo();
		assertNotNull("diagram exist", editorHandler.getEditor().getActiveEditor());
		
		// Try to undo
		assertTrue("Can undo", history.canUndo());
		history.undo();
		assertNull("diagram removed", editorHandler.getEditor().getActiveEditor());
		
		// Try to redo
		assertTrue("Can redo", history.canRedo());
		history.redo();
		assertNotNull("diagram exist", editorHandler.getEditor().getActiveEditor());
		// Check di now
		
	}

	/**
	 * @throws ServiceException 
	 * @throws ExecutionException 
	 * 
	 */
	@Test
	public void testDoubleCreateUndoUndoRedoRedoIOperationHistory() throws ServiceException, ExecutionException {
		
		IOperationHistoryHandler history = new OperationHistoryHandler(editorHandler);
		ISashWindowsContainer container = editorHandler.getServiceRegistry().getService(ISashWindowsContainer.class);

		// Create one diagram
		IPage createdPage = diagramCreator.createEmfTreeDiagram("newDiagram");
		Object page1RawModel = createdPage.getRawModel();
		
		assertNotNull("diagram created", createdPage);
		assertNotNull("diagram created", page1RawModel);

		IPage createdPage2 = diagramCreator.createEmfTreeDiagram("newDiagram");
		Object page2RawModel = createdPage2.getRawModel();
		assertNotNull("diagram created", createdPage);
		assertNotNull("diagram created", page2RawModel);
	
		// Try to undo
		assertTrue("Can undo", history.canUndo());
		history.undo();
		assertNull( "diagram removed", container.lookupModelPage(page2RawModel ));
		assertNotNull( "diagram preserved", container.lookupModelPage(page1RawModel ));
		
		
		// Try to undo
		assertTrue("Can undo", history.canUndo());
		history.undo();
		assertNull( "diagram removed", container.lookupModelPage(page2RawModel ));
		assertNull( "diagram removed", container.lookupModelPage(page1RawModel ));
		assertNull("no active editor", editorHandler.getEditor().getActiveEditor());
				
		// Try to redo
		assertTrue("Can redo", history.canRedo());
		history.redo();
		assertNotNull( "diagram restored", container.lookupModelPage(page1RawModel ));
		assertNotNull("active editor set", editorHandler.getEditor().getActiveEditor());
		
		// Try to redo
		assertTrue("Can redo", history.canRedo());
		history.redo();
		assertNotNull( "diagram restored", container.lookupModelPage(page2RawModel ));
		assertNotNull("active editor set", editorHandler.getEditor().getActiveEditor());
		
		// Try to undo
		assertTrue("Can undo", history.canUndo());
		history.undo();
		assertNull( "diagram removed", container.lookupModelPage(page2RawModel ));
		assertNotNull( "diagram preserved", container.lookupModelPage(page1RawModel ));
		
		// Try to redo
		assertTrue("Can redo", history.canRedo());
		history.redo();
		assertNotNull( "diagram restored", container.lookupModelPage(page2RawModel ));
		assertNotNull("active editor set", editorHandler.getEditor().getActiveEditor());
		// Check di now
		
	}


}
