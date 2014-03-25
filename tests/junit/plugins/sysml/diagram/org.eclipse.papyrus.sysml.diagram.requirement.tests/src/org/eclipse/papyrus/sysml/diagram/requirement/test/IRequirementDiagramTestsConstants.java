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
package org.eclipse.papyrus.sysml.diagram.requirement.test;

import org.eclipse.papyrus.sysml.SysmlPackage;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;

public interface IRequirementDiagramTestsConstants {

	/** name of the test project */
	public final String PROJECT_NAME = "RequirementDiagramTestProject";

	/** name of the test model */
	public final String FILE_NAME = "RequirmentDiagramTest.di";

	public final String PROFILE_SYSML = SysmlPackage.eNS_URI;

	public final String PROFILE_SYSML_PORTS = PortandflowsPackage.eNS_URI;

	public final String PROFILE_SYSML_CONSTRAINTS = ConstraintsPackage.eNS_URI;

	public final String PROFILE_SYSML_REQUIREMENTS = RequirementsPackage.eNS_URI;

	public final String[] PROFILES = new String[]{ PROFILE_SYSML, PROFILE_SYSML_PORTS, PROFILE_SYSML_CONSTRAINTS, PROFILE_SYSML_REQUIREMENTS };
}
