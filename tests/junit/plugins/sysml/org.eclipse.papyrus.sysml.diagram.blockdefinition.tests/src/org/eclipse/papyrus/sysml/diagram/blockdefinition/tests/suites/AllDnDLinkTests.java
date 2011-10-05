package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.link.TestLinkDropOnModel;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.dnd.link.TestLinkDropOnPackage;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestLinkDropOnModel.class, TestLinkDropOnPackage.class })
public class AllDnDLinkTests {

}
