/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils.tests;

import org.eclipse.papyrus.junit.utils.classification.ClassificationRunner;
import org.junit.runner.RunWith;

/**
 * An abstract class which should be extended by all Papyrus tests
 *
 * It provides generic support for papyrus-specific annotations (e.g. ClassificationRunner)
 *
 * @author Camille Letavernier
 *
 */
@RunWith(ClassificationRunner.class)
public abstract class AbstractPapyrusTest {

}
