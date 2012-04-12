/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 * 
 * @Generated from Part - Model 
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.junit.Assert;


/**
 * Test for Copy / Paste of a Part
 */
public abstract class AbstractCopyPastePartTest extends AbstractCopyPasteTest {

	/**
     * {@inheritDoc}
     * @generated
 	 */
	@Override
	protected void initializeTest(Map<Object, Object> additionalChecks, EObject targetContainer, EObject copiedEObject) {
    super.initializeTest(additionalChecks, targetContainer, copiedEObject);
  
      /* pre-copy initialization */
      
      /* END OF pre-copy initialization */
  }

	/**
	 * {@inheritDoc}
	 * @generated	
	 */
	@Override
	protected void postCopyAdditionalChecks(Map<?, ?> originalModel, List<EObject> newValues, List<EObject> delta) throws Exception {
    super.postCopyAdditionalChecks(originalModel, newValues, delta);
    
      /* post copy checks */
      Association newAssociation = ((Property)newValues.get(0)).getAssociation(); Assert.assertNotNull("New Part should have an association", newAssociation);
      /* END OF post copy checks */
  }

}


