/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.infra.emf.adapters;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.infra.emf.dialog.NestedEditingDialogContext;
import org.eclipse.papyrus.infra.widgets.creation.IAtomicOperationExecutor;


/**
 * This is the EObjectAdapterFactory type. Enjoy.
 */
public class EObjectAdapterFactory implements IAdapterFactory {

	private final Class<?>[] adapterTypes = { IAtomicOperationExecutor.class };

	public EObjectAdapterFactory() {
		super();
	}

	public Object getAdapter(Object adaptable, @SuppressWarnings("rawtypes") Class adapterType) {
		Object result = null;

		if(adaptable instanceof EObject) {
			if(adapterType == IAtomicOperationExecutor.class) {
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain((EObject)adaptable);
				if(domain == null) {
					ResourceSet rset = NestedEditingDialogContext.getInstance().getResourceSet();
					if(rset != null) {
						domain = TransactionUtil.getEditingDomain(rset);
					}
				}
				if(domain != null) {
					result = new EMFAtomicOperationExecutor(domain);
				}
			}
		}

		return result;
	}

	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return adapterTypes;
	}

	//
	// Nested types
	//

	private static final class EMFAtomicOperationExecutor extends IAtomicOperationExecutor.Default {

		private final TransactionalEditingDomain domain;

		EMFAtomicOperationExecutor(TransactionalEditingDomain domain) {
			this.domain = domain;
		}

		@Override
		public void execute(final Runnable operation, String label) {
			domain.getCommandStack().execute(new RecordingCommand(domain, label) {

				@Override
				protected void doExecute() {
					operation.run();
				}
			});
		}
	}
}
