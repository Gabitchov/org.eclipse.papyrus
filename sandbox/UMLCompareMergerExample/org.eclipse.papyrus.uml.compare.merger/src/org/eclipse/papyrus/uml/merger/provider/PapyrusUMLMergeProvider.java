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
package org.eclipse.papyrus.uml.merger.provider;

import java.util.Map;

import org.eclipse.emf.compare.diff.merge.IMerger;
import org.eclipse.emf.compare.diff.merge.IMergerProvider;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeOrderChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.diff.metamodel.UpdateReference;
import org.eclipse.papyrus.uml.compare.merger.utils.PapyrusMap;


public class PapyrusUMLMergeProvider implements IMergerProvider {

	/**
	 * This map keeps a bridge between a given {@link DiffElement}'s class and the most accurate merger's
	 * class for that particular {@link DiffElement}.
	 */
	private Map<Class<? extends DiffElement>, Class<? extends IMerger>> mergerTypes;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.IMergerProvider#getMergers()
	 */
	public Map<Class<? extends DiffElement>, Class<? extends IMerger>> getMergers() {
		if(mergerTypes == null) {
			mergerTypes = new PapyrusMap<Class<? extends DiffElement>, Class<? extends IMerger>>();
			mergerTypes.put(DiffGroup.class, CDiffGroupMerger.class);
			mergerTypes.put(ModelElementChangeRightTarget.class, CModelElementChangeRightTargetMerger.class);
			mergerTypes.put(ModelElementChangeLeftTarget.class, CModelElementChangeLeftTargetMerger.class);
			mergerTypes.put(MoveModelElement.class, CMoveModelElementMerger.class);
			mergerTypes.put(ReferenceChangeRightTarget.class, CReferenceChangeRightTargetMerger.class);
			mergerTypes.put(ReferenceChangeLeftTarget.class, CReferenceChangeLeftTargetMerger.class);
			mergerTypes.put(UpdateReference.class, CUpdateReferenceMerger.class);
			mergerTypes.put(AttributeChangeRightTarget.class, CAttributeChangeRightTargetMerger.class);
			mergerTypes.put(AttributeChangeLeftTarget.class, CAttributeChangeLeftTargetMerger.class);
			mergerTypes.put(UpdateAttribute.class, CUpdateAttributeMerger.class);
			mergerTypes.put(ReferenceOrderChange.class, CReferenceOrderChangeMerger.class);
			mergerTypes.put(AttributeOrderChange.class, CAttributeOrderChangeMerger.class);
			//DiffExtensionMerger : not used for the moment
			//DefaultExtensionMerger : not used for the moment
		}
		return mergerTypes;
	}


}
