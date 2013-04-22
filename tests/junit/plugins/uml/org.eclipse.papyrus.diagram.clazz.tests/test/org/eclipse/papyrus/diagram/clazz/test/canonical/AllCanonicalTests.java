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
package org.eclipse.papyrus.diagram.clazz.test.canonical;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * All test in canonical package
 */
@RunWith(Suite.class)
@SuiteClasses({
// top nodes
TestClassDiagramTopNode.class,
// child nodes
TestClassDiagramChildNode.class,
//labelNodes
TestClassDiagramChildLabel.class,
//test links
TestClassDiagramLink.class,
//test links owned by source
TestClassDiagramLinkOwnedBySource.class,
// multilinks
TestMutliLink.class,
//containmentLink
TestClassDiagramContainment.class,
//test the order for the drop
TestDropfunction.class,
//test is a static operation is underlined
TestStaticFeatureRepresentation.class,
//test nested classifier
TestClassDiagramNestedClassifier.class,

})
public class AllCanonicalTests {

}
