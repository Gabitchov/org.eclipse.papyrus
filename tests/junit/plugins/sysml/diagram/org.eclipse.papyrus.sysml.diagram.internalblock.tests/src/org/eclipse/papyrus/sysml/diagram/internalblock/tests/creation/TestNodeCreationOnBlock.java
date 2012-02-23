package org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createGraphicalNode;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.createNodeFromPalette;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for element creation test (via palette tools) in a Block.
 */
public class TestNodeCreationOnBlock extends AbstractTest {

	public static View containerView;

	@BeforeClass
	public static void prepareContainerForTest() throws Exception {
		try {
			// force inherited provider loading...
			createGraphicalNode(UMLElementTypes.PACKAGE, ElementTypes.COMMENT.getSemanticHint(), getDiagramView());

			// prepare container
			containerView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
			if(containerView == null) {
				throw new Exception("Unable to prepare container for test.");
			}

		} catch (Exception e) {
			throw new Exception("Unable to prepare container for test.", e);
		}
	}

	@Test
	public void createPort() throws Exception {
		createNodeFromPalette("internalblock.tool.port", containerView, true);
	}

	@Test
	public void createFlowPort_IN() throws Exception {
		createNodeFromPalette("internalblock.tool.port_in", containerView, true);
	}
	
	@Test
	public void createFlowPort_OUT() throws Exception {
		createNodeFromPalette("internalblock.tool.port_out", containerView, true);
	}
	
	@Test
	public void createFlowPort_INOUT() throws Exception {
		createNodeFromPalette("internalblock.tool.port_inout", containerView, true);
	}
	
	@Test
	public void createFlowPort_NA() throws Exception {
		createNodeFromPalette("internalblock.tool.port_na", containerView, true);
	}
	
	@Test
	public void createPart() throws Exception {
		createNodeFromPalette("internalblock.tool.part", containerView, false);
	}
	
	@Test
	public void createReference() throws Exception {
		createNodeFromPalette("internalblock.tool.reference", containerView, false);
	}
	
	@Test
	public void createComment() throws Exception {
		createNodeFromPalette("internalblock.tool.comment", containerView, false);
	}

	@Test
	public void createConstraint() throws Exception {
		createNodeFromPalette("internalblock.tool.constraint", containerView, false);
	}
}
