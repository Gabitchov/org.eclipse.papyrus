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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.provider;

import java.util.Map;

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
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.AttributeChangeLeftTargetTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.AttributeChangeRightTargetTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.AttributeOrderChangeTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DiffGroupTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.ModelElementChangeLeftTargetTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.ModelElementChangeRightTargetTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.MoveModelElementTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.ReferenceChangeLeftTargetTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.ReferenceChangeRightTargetTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.ReferenceOrderChangeTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.UpdateAttributeTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.UpdateReferenceTransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusCompareMap;
import org.eclipse.papyrus.infra.emf.compare.diff.merge.ITransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.provider.ITransactionalMergerProvider;


public class DefaultTransactionalMergerProvider implements ITransactionalMergerProvider {

	/**
	 * This map keeps a bridge between a given {@link DiffElement}'s class and the most accurate merger's
	 * class for that particular {@link DiffElement}.
	 */
	private Map<Class<? extends DiffElement>, Class<? extends ITransactionalMerger>> mergerTypes;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.IMergerProvider#getMergers()
	 */
	public Map<Class<? extends DiffElement>, Class<? extends ITransactionalMerger>> getMergers() {
		if(mergerTypes == null) {
			mergerTypes = new PapyrusCompareMap<Class<? extends DiffElement>, Class<? extends ITransactionalMerger>>();
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
			//TODO DiffExtensionMerger : not used for the moment
			//TODO DefaultExtensionMerger : not used for the moment
		}
		return mergerTypes;
	}


}
