/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.core.test.testModel1;

/**
 * Test strategy 0 = Load all the needed resources
 * 
 * @author eperico
 * 
 */
public class Strategy0TestModel1 extends AbstractResourceLoadingTestModel1 {

	@Override
	public int getStrategy() {
		// Load all the needed resources
		return 0;
	}

}
