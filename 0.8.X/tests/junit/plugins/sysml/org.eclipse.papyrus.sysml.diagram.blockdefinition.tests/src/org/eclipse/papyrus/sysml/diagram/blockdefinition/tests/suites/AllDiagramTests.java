package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.TestDiagramCreation;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.TestNodeCreationOnDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestNodeBasicDeleteFromDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestNodeBasicDeleteFromModel;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.TestNodeDropOnDiagram;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	TestDiagramCreation.class,
	TestNodeCreationOnDiagram.class,
	TestNodeDropOnDiagram.class,
	TestNodeBasicDeleteFromDiagram.class,
	TestNodeBasicDeleteFromModel.class
})
public class AllDiagramTests {

}
