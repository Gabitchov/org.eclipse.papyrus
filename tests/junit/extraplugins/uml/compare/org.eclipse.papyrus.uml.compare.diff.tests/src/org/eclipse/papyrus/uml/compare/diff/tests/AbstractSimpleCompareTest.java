/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServiceMultiException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.junit.utils.GenericUtils;
import org.eclipse.papyrus.uml.compare.file.editor.utils.ServicesRegistryUtils;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;


public class AbstractSimpleCompareTest {

	protected static IProject project;

	protected static TransactionalEditingDomain domain;

	protected static ModelSet set;

	/** indicates the direction of the merge */
	protected static boolean leftToRight;

	//	protected static List<DiffElement> initialDifferences;
	/** the left element used for the comparison */
	protected static Element leftElement;

	/** the rigth element used for the comparison */
	protected static Element rightElement;

	/** This field is used to store the initial Differences before to do the merge */
	protected static List<DiffElement> initialDifferences;

	protected static ServicesRegistry servicesRegistry;

	protected static List<EObject> roots;

	public static void loadModels(final List<IFile> comparedFiles) throws ServiceException, ModelMultiException {
		roots = new ArrayList<EObject>();
		servicesRegistry = ServicesRegistryUtils.createAndInitServiceRegistryForUMLCompareFile();
		set = servicesRegistry.getService(ModelSet.class);
		domain = set.getTransactionalEditingDomain();
		for(final IFile current : comparedFiles) {
			set.loadModels(current);
			final String filePath = current.getFullPath().toString();
			URI uri = URI.createPlatformResourceURI(filePath, false);
			EObject root = UML2Util.load(set, uri, UMLPackage.Literals.PACKAGE);
			set.getResource(uri, false).setTrackingModification(true);
			Assert.assertNotNull("The root of the model is null", root); //$NON-NLS-1$
			roots.add(root);
		}
	}


	/** allow to verify that the class ahas the correct parameter using its name */
	@Test
	public void testTestConformance() {
		final String name = getClass().getName();
		if(name.endsWith("LeftToRight")) { //$NON-NLS-1$
			Assert.assertEquals(true, leftToRight);
		} else if(name.endsWith("RightToLeft")) { //$NON-NLS-1$
			Assert.assertEquals(false, leftToRight);
		} else {
			Assert.fail();
		}
	}

	@AfterClass
	public static final void closeAll() {
		//useful ?
		if(set != null) {
			final List<Resource> resources = new ArrayList<Resource>(set.getResources());
			for(Resource current : resources) {
				current.setTrackingModification(false);
				set.getResources().remove(current);
				TransactionUtil.disconnectFromEditingDomain(current);
				current.unload();
			}
			resources.clear();
			if(servicesRegistry != null) {
				try {
					servicesRegistry.disposeRegistry();
				} catch (ServiceMultiException e) {
					//log.error(e);
					//TODO 
				}
			}
			//we close all the editors
			GenericUtils.closeAllEditors();
		}
	}
}
