/*****************************************************************************
 * Copyright (c) 2014 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.integrationtests.editor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class EclipseProjectTest {

	private static final String PROJECT_NAME = "org.eclipse.papyrus.integrationtests.editor.project";
	private static final String FROM_BUNDLE_NAME = "org.eclipse.papyrus.integrationtests.editor";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.EclipseProject#EclipseProject(java.lang.String)}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testEclipseProject() throws ExecutionException {
		EclipseProject project = new EclipseProject(PROJECT_NAME);
		
		assertNotNull( "object created", project);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.EclipseProject#getProject()}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testGetProject() throws ExecutionException {
		EclipseProject project = new EclipseProject(PROJECT_NAME);
	
		assertNotNull( "object created", project.getProject());

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.EclipseProject#copyResource(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testCopyResource() throws ExecutionException {
		
		String fromFile = "META-INF/MANIFEST.MF";
		String toFile = "a/b/META-INF/MANIFEST.MF";
		
		EclipseProject project = new EclipseProject(PROJECT_NAME);
		
		project.copyResource(FROM_BUNDLE_NAME, fromFile, toFile);
		
		assertNotNull( "file copied", project.getProject().findMember(toFile));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.integrationtests.editor.EclipseProject#copyResource(java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws ExecutionException 
	 */
	@Test
	public void testCopyResources() throws ExecutionException {
		
		String fromFile1 = "META-INF/MANIFEST.MF";
		String fromFile2 = "about.html";
		
		EclipseProject project = new EclipseProject(PROJECT_NAME);
		
		assertNull( "file copied", project.getProject().findMember(fromFile1));
		assertNull( "file copied", project.getProject().findMember(fromFile2));
		
		project.copyResources(FROM_BUNDLE_NAME, fromFile1, fromFile2);
		
		assertNotNull( "file copied", project.getProject().findMember(fromFile1));
		assertNotNull( "file copied", project.getProject().findMember(fromFile2));
	}


}
