/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.core.importer;

import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferOperation;

/**
 * This is the ReentrantOperationContext type. Enjoy.
 */
public class ReentrantOperationContext
		implements IModelTransferOperation.Context {

	private final IModelTransferOperation.Context delegate;

	private AtomicInteger depth = new AtomicInteger();

	public ReentrantOperationContext(IModelTransferOperation.Context delegate) {
		super();

		this.delegate = delegate;
	}

	public Diagnostic run(IModelTransferOperation operation) {
		Diagnostic result;

		try {
			if (depth.getAndIncrement() == 0) {
				// let the delegate run it
				result = delegate.run(operation);
			} else {
				// run it directly, assuming we are still in the context of the
				// delegate
				result = operation.run(new NullProgressMonitor());
			}
		} finally {
			depth.decrementAndGet();
		}
		
		return result;
	}

}
