/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.compare.merger.provider;

import java.util.Map;

import org.eclipse.emf.compare.diff.internal.merge.DefaultMergerProvider;
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
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.papyrus.infra.emf.compare.merger.AttributeChangeLeftTargetMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.AttributeChangeRightTargetMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.AttributeOrderChangeMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.DiffGroupMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.ModelElementChangeRightTargetMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.MoveModelElementMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.PapyrusModelElementChangeLeftTargetMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.PapyrusUpdateAttributeMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.ReferenceChangeLeftTargetMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.ReferenceChangeRightTargetMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.ReferenceOrderChangeMerger;
import org.eclipse.papyrus.infra.emf.compare.merger.UpdateReferenceMerger;


public class PapyrusMergerProvider implements IMergerProvider {

	/**
	 * This map keeps a bridge between a given {@link DiffElement}'s class and the most accurate merger's
	 * class for that particular {@link DiffElement}.
	 */
	private Map<Class<? extends DiffElement>, Class<? extends IMerger>> mergerTypes;

	/**
	 * The default merge provide
	 */
	private final IMergerProvider defaultMergeProvider = new DefaultMergerProvider();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.IMergerProvider#getMergers()
	 */
	public Map<Class<? extends DiffElement>, Class<? extends IMerger>> getMergers() {
		if(this.mergerTypes == null) {
			this.mergerTypes = new EMFCompareMap<Class<? extends DiffElement>, Class<? extends IMerger>>();
			this.mergerTypes.put(DiffGroup.class, DiffGroupMerger.class);
			this.mergerTypes.put(ModelElementChangeRightTarget.class, ModelElementChangeRightTargetMerger.class);
			this.mergerTypes.put(ModelElementChangeLeftTarget.class, PapyrusModelElementChangeLeftTargetMerger.class);
			this.mergerTypes.put(MoveModelElement.class, MoveModelElementMerger.class);
			this.mergerTypes.put(ReferenceChangeRightTarget.class, ReferenceChangeRightTargetMerger.class);
			this.mergerTypes.put(ReferenceChangeLeftTarget.class, ReferenceChangeLeftTargetMerger.class);
			this.mergerTypes.put(UpdateReference.class, UpdateReferenceMerger.class);
			this.mergerTypes.put(AttributeChangeRightTarget.class, AttributeChangeRightTargetMerger.class);
			this.mergerTypes.put(AttributeChangeLeftTarget.class, AttributeChangeLeftTargetMerger.class);
			this.mergerTypes.put(UpdateAttribute.class, PapyrusUpdateAttributeMerger.class);
			this.mergerTypes.put(ReferenceOrderChange.class, ReferenceOrderChangeMerger.class);
			this.mergerTypes.put(AttributeOrderChange.class, AttributeOrderChangeMerger.class);
		}
		return this.mergerTypes;
	}

}
