package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;


/**
 * The Class AbstractPapyrusTestCase.
 */
public abstract class AbstractPapyrusTestCase extends org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return  new RequirementDiagramCreateCommand();
	}


}
