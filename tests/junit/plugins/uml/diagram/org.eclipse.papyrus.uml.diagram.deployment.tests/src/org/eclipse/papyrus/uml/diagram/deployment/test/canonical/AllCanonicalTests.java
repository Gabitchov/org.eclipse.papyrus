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
package org.eclipse.papyrus.uml.diagram.deployment.test.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
// Top Node
TestDeploymentDiagramTopNode.class,
// Child Node
TestDeploymentDiagramChildNode.class,
// Deployment Link
TestDeploymentDiagramDeploymentLink.class,
// Link by owned source 
TestDeploymentDiagramLinkOwnedBySource.class,
// Comment link
TestDeploymentDiagramCommentLink.class,
// Cosntraint link
TestDeploymentDiagramConstraintLink.class,
// Manifestation Link
TestDeploymentDiagramManifestationLink.class,
// Others Link
TestDeploymentDiagramLink.class,

// End
})
public class AllCanonicalTests {

}
