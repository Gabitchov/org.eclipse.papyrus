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
package org.eclipse.papyrus.uml.compare.diff.internal.provider;

import java.util.Map;

import org.eclipe.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationSourceChangedExtension;
import org.eclipe.papyrus.uml.compare.diff.uml_diff_extension.GeneralizationTargetChangedExtension;
import org.eclipe.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationSourceChangedExtensionImpl;
import org.eclipe.papyrus.uml.compare.diff.uml_diff_extension.impl.GeneralizationTargetChangedExtensionImpl;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusCompareMap;
import org.eclipse.papyrus.infra.emf.compare.diff.merge.ITransactionalMerger;
import org.eclipse.papyrus.infra.emf.compare.diff.provider.ITransactionalMergerProvider;
import org.eclipse.papyrus.uml.compare.diff.internal.merger.GeneralizationSourceMerger;
import org.eclipse.papyrus.uml.compare.diff.internal.merger.GeneralizationTargetMerger;




/**
 * 
 * This class provides the mergers for the UML DiffElement
 * 
 */
public class UMLTransactionalMergerProvider implements ITransactionalMergerProvider {

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
			//its it better to set MyClassImpl.class than MyInterface.class, in the 2nd case, we don't  have guarantee that the method getBestMerger find the real best merger
			//another workaround is to implmements the method providesMerger in the Extension
			mergerTypes.put(GeneralizationSourceChangedExtensionImpl.class, GeneralizationSourceMerger.class);
			mergerTypes.put(GeneralizationTargetChangedExtensionImpl.class, GeneralizationTargetMerger.class);
		}
		return mergerTypes;
	}


}
