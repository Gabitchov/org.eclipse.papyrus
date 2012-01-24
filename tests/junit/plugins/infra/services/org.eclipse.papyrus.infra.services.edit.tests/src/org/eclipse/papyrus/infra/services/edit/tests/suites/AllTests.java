package org.eclipse.papyrus.infra.services.edit.tests.suites;

import org.eclipse.papyrus.infra.services.edit.tests.commands.TestConfigureFeatureCommandFactory;
import org.eclipse.papyrus.infra.services.edit.tests.commands.TestConfigureFeatureListCommandFactory;
import org.eclipse.papyrus.infra.services.edit.tests.context.TestClientContext;
import org.eclipse.papyrus.infra.services.edit.tests.service.TestElementEditService;
import org.eclipse.papyrus.infra.services.edit.tests.service.TestElementEditServiceProvider;
import org.eclipse.papyrus.infra.services.edit.tests.service.TestElementEditServiceProviderFactory;
import org.eclipse.papyrus.infra.services.edit.tests.service.TestElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.tests.utils.TestElementTypeValidator;
import org.eclipse.papyrus.infra.services.edit.tests.utils.TestGMFCommandUtils;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Main Test suite.
 */
@RunWith(Suite.class)
@SuiteClasses({ 
	TestClientContext.class,
	TestElementEditService.class,
	TestElementEditServiceProvider.class,
	TestElementEditServiceProviderFactory.class,
	TestElementEditServiceUtils.class,
	TestElementTypeValidator.class,
	TestGMFCommandUtils.class,
	TestConfigureFeatureCommandFactory.class,
	TestConfigureFeatureListCommandFactory.class
})
public class AllTests {

}
