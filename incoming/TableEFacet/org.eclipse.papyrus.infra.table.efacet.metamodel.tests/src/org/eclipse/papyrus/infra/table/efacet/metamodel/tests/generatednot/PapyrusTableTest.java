/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.metamodel.tests.generatednot;

import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.FillingMode;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustableFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * This class test the call of the methods which should be 'tagged generated NOT'
 * 
 */
public class PapyrusTableTest {

	@Test
	public void testIsUsingUser() {
		final PapyrusTable table = PapyrustableFactory.eINSTANCE.createPapyrusTable();
		table.setFillingMode(FillingMode.USER);
		Assert.assertEquals("The method PapyrusTable.isUsingUser doesn't return the wanted value", true, table.isUsingUser());
		Assert.assertEquals("The method PapyrusTable.isUsingContextFeature() doesn't return the wanted value", false, table.isUsingContextFeature());
		Assert.assertEquals("The method PapyrusTable.isUsingQueries() doesn't return the wanted value", false, table.isUsingQueries());
	}

	@Test
	public void testisUsingContextFeature() {
		final PapyrusTable table = PapyrustableFactory.eINSTANCE.createPapyrusTable();
		table.setFillingMode(FillingMode.CONTEXT_FEATURE);
		Assert.assertEquals("The method PapyrusTable.isUsingUser doesn't return the wanted value", false, table.isUsingUser());
		Assert.assertEquals("The method PapyrusTable.isUsingContextFeature() doesn't return the wanted value", true, table.isUsingContextFeature());
		Assert.assertEquals("The method PapyrusTable.isUsingQueries() doesn't return the wanted value", false, table.isUsingQueries());
	}

	@Test
	public void testIsUsingQueries() {
		final PapyrusTable table = PapyrustableFactory.eINSTANCE.createPapyrusTable();
		table.setFillingMode(FillingMode.QUERIES);
		Assert.assertEquals("The method PapyrusTable.isUsingUser doesn't return the wanted value", false, table.isUsingUser());
		Assert.assertEquals("The method PapyrusTable.isUsingContextFeature() doesn't return the wanted value", false, table.isUsingContextFeature());
		Assert.assertEquals("The method PapyrusTable.isUsingQueries() doesn't return the wanted value", true, table.isUsingQueries());
	}

}
