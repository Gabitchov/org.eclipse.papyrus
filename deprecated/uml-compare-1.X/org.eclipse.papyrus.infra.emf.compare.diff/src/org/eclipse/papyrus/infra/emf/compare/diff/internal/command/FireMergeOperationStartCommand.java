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
package org.eclipse.papyrus.infra.emf.compare.diff.internal.command;

import java.util.List;

import org.eclipse.emf.compare.diff.merge.IMergeListener;
import org.eclipse.emf.compare.diff.merge.MergeEvent;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;


public class FireMergeOperationStartCommand extends AbstractFireMergeCommand {

	public FireMergeOperationStartCommand(final DiffElement diffElement, final List<IMergeListener> listeners) {
		super(diffElement, listeners);
	}

	public FireMergeOperationStartCommand(final List<DiffElement> diffs, final List<IMergeListener> listeners) {
		super(diffs, listeners);
	}

	public void execute() {
		List<IMergeListener> listeners = getMergeListeners();
		if(!getDiffElementsList().isEmpty()) {
			for(IMergeListener current : listeners) {
				current.mergeOperationStart(new MergeEvent(getDiffElementsList()));
			}
		}
		if(getDiffElement() != null) {
			for(IMergeListener current : listeners) {
				current.mergeOperationStart(new MergeEvent(getDiffElement()));
			}

		}
	}

	@Override
	public void undo() {
		//TODO?
	}
}
