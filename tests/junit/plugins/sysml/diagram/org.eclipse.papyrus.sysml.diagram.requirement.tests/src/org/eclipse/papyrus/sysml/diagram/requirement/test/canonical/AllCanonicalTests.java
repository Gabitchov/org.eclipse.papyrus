package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
	TestRequirementDiagramTopNode.class,
	TestRequirementDiagramChildNode.class,
	TestRequirementDiagramLink.class,
	TestRequirementDiagramContainment.class,
})
public class AllCanonicalTests {

}
