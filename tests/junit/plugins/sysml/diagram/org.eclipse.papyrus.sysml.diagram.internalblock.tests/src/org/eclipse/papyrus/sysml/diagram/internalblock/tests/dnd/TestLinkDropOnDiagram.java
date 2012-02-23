package org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd;

import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.EditorUtils.getDiagramView;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createConnectorLink;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createElement;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestPrepareUtils.createLink;
import static org.eclipse.papyrus.sysml.diagram.internalblock.tests.utils.TestUtils.dropFromModelExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.AbstractTest;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Property;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit tests for Link DnD tests (via palette tools).
 */
public class TestLinkDropOnDiagram extends AbstractTest {

	public static EObject portSource;
	public static EObject constraintTarget;
	public static EObject partTarget;
	
	public static EObject dependency;
	public static EObject connector;
	
	@BeforeClass
	public static void prepare() throws Exception {
		// Prepare elements for link creation tests
		View blockView = ViewUtil.getChildBySemanticHint(getDiagramView(), SysMLGraphicalTypes.SHAPE_SYSML_BLOCK_AS_COMPOSITE_ID);
		portSource = createElement(UMLElementTypes.PORT, blockView);
		constraintTarget = createElement(UMLElementTypes.CONSTRAINT, getDiagramView());
		partTarget = createElement(SysMLElementTypes.PART_PROPERTY, getDiagramView());
		
		dependency = createLink(UMLElementTypes.DEPENDENCY, blockView.getElement(), constraintTarget);
		connector = createConnectorLink((EncapsulatedClassifier) blockView.getElement(), (ConnectableElement)portSource, (Property)null, (ConnectableElement)partTarget, (Property)null);
	}

	@Test
	public void dropDependencyInDiagram() throws Exception {
		dropFromModelExplorer(dependency, getDiagramView(), true);
	}
	
	@Test
	public void dropConnectorInDiagram() throws Exception {
		// The following test currently fails if the Connector source and target are not shown on the diagram.
		dropFromModelExplorer(connector, getDiagramView(), true); 
	}
}
