/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.tests.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({

// child nodes
TestActivityDiagramChildNode.class,
TestActivityDiagramChildWithOtherCreationNode.class,
TestActivityChildNodeInStructuredActivity.class
//Nodes in structured Activity
//TestActivityChildNodeInStructuredActivity.class,
//test links
//TestActivityDiagramLink.class,
//test links owned by source
//TestClassDiagramLinkOwnedBySource.class,
//containmentLink
//TestClassDiagramContainment.class,

})
public class AllCanonicalTests {

}
