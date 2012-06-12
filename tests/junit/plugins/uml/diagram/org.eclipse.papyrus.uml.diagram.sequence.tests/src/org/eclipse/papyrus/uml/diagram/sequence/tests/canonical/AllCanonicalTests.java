package org.eclipse.papyrus.uml.diagram.sequence.tests.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
// top nodes
TestSequenceDiagramTopNode.class,
// child nodes
TestSequenceDiagramChildNode.class,
//test links
TestSequenceDiagramLink.class, })
public class AllCanonicalTests {

}
