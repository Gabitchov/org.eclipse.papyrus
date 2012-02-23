package org.eclipse.papyrus.sysml.diagram.internalblock.tests.suites;

import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.TestDiagramCreation;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.creation.TestNodeCreationOnDiagram;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.TestLinkDropOnDiagram;
import org.eclipse.papyrus.sysml.diagram.internalblock.tests.dnd.TestNodeDropOnDiagram;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	TestDiagramCreation.class,
	TestNodeCreationOnDiagram.class,
	TestNodeDropOnDiagram.class,
	TestLinkDropOnDiagram.class
})
public class AllDiagramTests {

}
