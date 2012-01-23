package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestLinkBasicDeleteFromDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestLinkBasicDeleteFromModel;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestNodeBasicDeleteFromDiagram;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.delete.TestNodeBasicDeleteFromModel;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestLinkBasicDeleteFromDiagram.class, 
	TestLinkBasicDeleteFromModel.class, 
	TestNodeBasicDeleteFromDiagram.class,
	TestNodeBasicDeleteFromModel.class })
public class AllDeletionTests {

}
