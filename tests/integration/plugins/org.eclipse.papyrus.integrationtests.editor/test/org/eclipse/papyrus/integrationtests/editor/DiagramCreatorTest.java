package org.eclipse.papyrus.integrationtests.editor;

import static org.junit.Assert.*;

import org.eclipse.papyrus.infra.core.sasheditor.editor.IPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test for {@link DiagramCreator}.
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class DiagramCreatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	@Ignore
	public void testCreateClassDiagram() throws Exception {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
//		DiagramCreator diagramCreator = new DiagramCreator(editorHandler);
//		
//		IPage createdPage = diagramCreator.createClassDiagram("newDiagram");
//		
//		assertNotNull("diagram created", createdPage);
		
		// exit
		editorHandler.dispose();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateActivityDiagram() throws Exception {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		DiagramCreator diagramCreator = new DiagramCreator(editorHandler);
		
		IPage createdPage = diagramCreator.createActivityDiagram("newDiagram");
		
		assertNotNull("diagram created", createdPage);
		
		// exit
		editorHandler.dispose();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateEMFTreeDiagram() throws Exception {
		ProgramaticPapyrusEditor editorHandler = new ProgramaticPapyrusEditor();
		DiagramCreator diagramCreator = new DiagramCreator(editorHandler);
		
		IPage createdPage = diagramCreator.createEmfTreeDiagram("newDiagram");
		
		assertNotNull("diagram created", createdPage);
		
		// exit
		editorHandler.dispose();
	}

	
}
