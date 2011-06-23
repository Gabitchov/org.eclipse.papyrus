/**
 * 
 *  Copyright (c) 2011 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Vincent Lorenzo(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.merge;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueReferenceChange;

/**
 * 
 * Merger for the references in the TaggedValue 
 * 
 * Warning : this class assumes allows to merge the tag value itself, but if the element referenced by the tag
 * value should be merged too, it is not managed here. This second action should be managed by the viewer with a listener
 * on the selection event.
 *
 */
public class TaggedValueReferenceChangeMerger extends DefaultMerger {

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#undoInTarget()
	 *
	 */
	@Override
	public void undoInTarget() {
		final TaggedValueReferenceChange theDiff = (TaggedValueReferenceChange)this.diff;
		updateReferenceValue(theDiff, theDiff.getLeftElement(), theDiff.getRightElement());
		super.undoInTarget();
	}
	
	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#applyInOrigin()
	 *
	 */
	@Override
	public void applyInOrigin() {
		final TaggedValueReferenceChange theDiff = (TaggedValueReferenceChange)this.diff;
		updateReferenceValue(theDiff, theDiff.getRightElement(), theDiff.getLeftElement());
		super.applyInOrigin();
	}
	
	/**
	 * 
	 * @param theDiff
	 * the diffElement
	 * @param source
	 * the source for the merge
	 * @param target
	 * the target for the merge
	 */
	private void updateReferenceValue(TaggedValueReferenceChange theDiff, EObject source, EObject target){
		final EReference changedProperty = theDiff.getReference();
		int featureID = changedProperty.getFeatureID();

		EStructuralFeature featureSource = source.eClass().getEStructuralFeature(featureID);
		Object value = source.eGet(featureSource);
		if(value instanceof EObject) {
			EStructuralFeature featureTarget = target.eClass().getEStructuralFeature(featureID);

			Resource sourceResource = source.eResource();
			Resource targetResource = target.eResource();
			String uriFragment = sourceResource.getURIFragment((EObject)source.eGet(featureSource));
			value = targetResource.getEObject(uriFragment);
			//the value object should have been merged before!
			Assert.isNotNull(value, "The object with the ID " + uriFragment + "cannot be found in the target model.");
			target.eSet(featureTarget, value);
		}
	}
}
