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

import org.eclipse.papyrus.junit.utils.classification.ClassificationRule;
import org.junit.Rule;

/**
 * An abstract class which should be extended by all Papyrus tests
 *
 * @author Camille Letavernier
 *
 */
public abstract class AbstractPapyrusTest {

	@Rule
	public final ClassificationRule classification = new ClassificationRule();
}
