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

public interface IRequirementDiagramTestsConstants {

	/** name of the test project */
	public final String PROJECT_NAME = "RequirementDiagramTestProject";

	/** name of the test model */
	public final String FILE_NAME = "RequirmentDiagramTest.di";

	public final String PROFILE_SYSML = "http://www.eclipse.org/papyrus/0.7.0/SysML";

	public final String PROFILE_SYSML_BLOCKS = "http://www.eclipse.org/papyrus/0.7.0/SysML/Blocks";

	public final String PROFILE_SYSML_PORTS = "http://www.eclipse.org/papyrus/0.7.0/SysML/PortAndFlows";

	public final String PROFILE_SYSML_CONSTRAINTS = "http://www.eclipse.org/papyrus/0.7.0/SysML/Constraints";

	public final String[] PROFILES = new String[] {
			PROFILE_SYSML,
			PROFILE_SYSML_BLOCKS,
			PROFILE_SYSML_PORTS,
			PROFILE_SYSML_CONSTRAINTS
	};
}