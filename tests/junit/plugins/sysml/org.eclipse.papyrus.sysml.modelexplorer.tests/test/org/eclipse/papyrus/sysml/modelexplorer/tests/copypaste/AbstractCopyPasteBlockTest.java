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
 * 
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.modelexplorer.tests.copypaste;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.utils.FilteredCollectionView;
import org.eclipse.papyrus.infra.core.utils.IFilter;
import org.eclipse.uml2.uml.Property;
import org.junit.Assert;


/**
 * Test for Copy / Paste of a Part
 */
public abstract class AbstractCopyPasteBlockTest extends AbstractCopyPasteTest {

	/**
	 * {@inheritDoc}
	 * 
	 * 
	 */
	@Override
	protected void initializeTest(Map<Object, Object> additionalChecks, EObject targetContainer, EObject copiedEObject) {
    super.initializeTest(additionalChecks, targetContainer, copiedEObject);
  
      /* pre-copy initialization */
      List<Property> originalParts = new ArrayList<Property>();
      for(Property p : ((org.eclipse.uml2.uml.Class)copiedEObject).getAllAttributes()) {  	if(new org.eclipse.papyrus.sysml.service.types.matcher.PartPropertyMatcher().matches(p)) {originalParts.add(p);}} additionalChecks.put("originalParts", originalParts);
      /* END OF pre-copy initialization */
  }

	/**
	 * {@inheritDoc}
	 * 
	 * 
	 */
	@Override
	protected void postCopyAdditionalChecks(Map<?, ?> originalModel, List<EObject> newValues, List<EObject> delta) throws Exception {
    super.postCopyAdditionalChecks(originalModel, newValues, delta);
    
      /* post copy checks */
           FilteredCollectionView<EObject> newClasses = new FilteredCollectionView<EObject>(delta, new IFilter() {    /**     * {@inheritDoc}     */    public boolean isAllowed(Object object) {     return object instanceof org.eclipse.uml2.uml.Class && !(object instanceof org.eclipse.uml2.uml.Association);    }   });   
           Assert.assertEquals("New values should contain a Class", 1, newClasses.size()); //$NON-NLS-1$
           org.eclipse.uml2.uml.Class newBlock = newClasses.toArray(new org.eclipse.uml2.uml.Class[]{})[0];
           Assert.assertNotNull("Block stereotype should be applied",     ((org.eclipse.uml2.uml.Class) newBlock).getAppliedStereotype("SysML::Blocks::Block")); //$NON-NLS-1$
           List<Property> originalParts = (List<Property>) originalModel     .get("originalParts");   List<Property> newParts = new ArrayList<Property>();   for (Property p : ((org.eclipse.uml2.uml.Class) newBlock)     .getAllAttributes()) {    if (new org.eclipse.papyrus.sysml.service.types.matcher.PartPropertyMatcher().matches(p)) {     newParts.add(p);     Assert.assertNotNull(       "Part should have an associated association.",       p.getAssociation());    }   }   
           Assert.assertEquals(     "Both original and new list of attributes should be quivalent for the blocks",     originalParts.size(), newParts.size()); //$NON-NLS-1$
      /* END OF post copy checks */
  }

}
