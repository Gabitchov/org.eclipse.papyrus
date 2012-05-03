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
package org.eclipse.papyrus.uml.merger.internal.provider;

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
import org.eclipse.papyrus.uml.compare.merger.internal.merger.AttributeChangeLeftTargetTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.AttributeChangeRightTargetTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.AttributeOrderChangeTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.DiffGroupTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.ModelElementChangeLeftTargetTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.ModelElementChangeRightTargetTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.MoveModelElementTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.ReferenceChangeLeftTargetTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.ReferenceChangeRightTargetTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.ReferenceOrderChangeTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.UpdateAttributeTransactionalMerger;
import org.eclipse.papyrus.uml.compare.merger.internal.merger.UpdateReferenceTransactionalMerger;
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
			mergerTypes.put(DiffGroup.class, DiffGroupTransactionalMerger.class);
			mergerTypes.put(ModelElementChangeRightTarget.class, ModelElementChangeRightTargetTransactionalMerger.class);
			mergerTypes.put(ModelElementChangeLeftTarget.class, ModelElementChangeLeftTargetTransactionalMerger.class);
			mergerTypes.put(MoveModelElement.class, MoveModelElementTransactionalMerger.class);
			mergerTypes.put(ReferenceChangeRightTarget.class, ReferenceChangeRightTargetTransactionalMerger.class);
			mergerTypes.put(ReferenceChangeLeftTarget.class, ReferenceChangeLeftTargetTransactionalMerger.class);
			mergerTypes.put(UpdateReference.class, UpdateReferenceTransactionalMerger.class);
			mergerTypes.put(AttributeChangeRightTarget.class, AttributeChangeRightTargetTransactionalMerger.class);
			mergerTypes.put(AttributeChangeLeftTarget.class, AttributeChangeLeftTargetTransactionalMerger.class);
			mergerTypes.put(UpdateAttribute.class, UpdateAttributeTransactionalMerger.class);
			mergerTypes.put(ReferenceOrderChange.class, ReferenceOrderChangeTransactionalMerger.class);
			mergerTypes.put(AttributeOrderChange.class, AttributeOrderChangeTransactionalMerger.class);
			//DiffExtensionMerger : not used for the moment
			//DefaultExtensionMerger : not used for the moment
		}
		return mergerTypes;
	}


}
