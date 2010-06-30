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
 * Test strategy 1 = Load the additional resources (profile and pathmap). Controlled resources are not loaded
 * 
 * @author eperico
 * 
 */
public class Strategy1TestModel1 extends AbstractResourceLoadingTestModel1 {

	@Override
	public int getStrategy() {
		// Load the additional resources (profile and pathmap). Controlled resources are not loaded
		return 1;
	}

}
