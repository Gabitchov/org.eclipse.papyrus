/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.test.canonical;

import org.eclipse.papyrus.commands.ICreationCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.RequirementDiagramCreateCommand;
import org.eclipse.papyrus.sysml.diagram.requirement.test.IRequirementDiagramTestsConstants;

/**
 * The Class AbstractPapyrusTestCase.
 */
public abstract class AbstractPapyrusTestCase extends org.eclipse.papyrus.diagram.tests.canonical.AbstractPapyrusTestCase {

	@Override
	protected ICreationCommand getDiagramCommandCreation() {
		return new RequirementDiagramCreateCommand();
	}

	@Override
	protected String[] getRequiredProfiles() {
		return IRequirementDiagramTestsConstants.PROFILES;
	}
}
