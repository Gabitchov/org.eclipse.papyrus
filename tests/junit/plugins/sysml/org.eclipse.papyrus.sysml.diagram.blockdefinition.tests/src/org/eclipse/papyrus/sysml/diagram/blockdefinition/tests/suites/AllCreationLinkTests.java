package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.suites;

import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationCommentConstraintForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationCommentConstraintFromComment;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationCommentConstraintFromConstraint;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationDependencyForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationDependencyFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationGeneralizationForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationGeneralizationFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationInterfaceRealizationForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationInterfaceRealizationFromBlock;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationUsageForSources;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.tests.creation.link.TestLinkCreationUsageFromBlock;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ 
	TestLinkCreationDependencyForSources.class, 
	TestLinkCreationGeneralizationForSources.class,
	TestLinkCreationDependencyFromBlock.class,
	TestLinkCreationGeneralizationFromBlock.class,
	TestLinkCreationInterfaceRealizationForSources.class,
	TestLinkCreationUsageForSources.class,
	TestLinkCreationInterfaceRealizationFromBlock.class,
	TestLinkCreationUsageFromBlock.class,
	TestLinkCreationCommentConstraintForSources.class,
	TestLinkCreationCommentConstraintFromComment.class,
	TestLinkCreationCommentConstraintFromConstraint.class })
public class AllCreationLinkTests {

}