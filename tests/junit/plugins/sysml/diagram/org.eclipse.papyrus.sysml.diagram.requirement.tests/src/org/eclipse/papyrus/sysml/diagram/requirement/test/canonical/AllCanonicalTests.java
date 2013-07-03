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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
// Top Node
TestRequirementDiagramTopNode.class,
// Child Node
TestRequirementDiagramChildNode.class,
// Links
TestRequirementDiagramLink.class,
// Comment Link
TestRequirementDiagramCommentLink.class,
// Constraint Link
TestRequirementDiagramConstraintLink.class,
// Containment Link
TestRequirementDiagramContainment.class,
// Link Owned By source
TestRequirementDiagramLinkOwnedBySource.class })
public class AllCanonicalTests {
}
