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
package org.eclipse.papyrus.infra.table.efacet.common.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.table.efacet.common.input.PapyrusTableEditorInput;
import org.eclipse.papyrus.infra.table.efacet.common.listener.FillingListener;
import org.eclipse.papyrus.infra.table.efacet.common.listener.MoveTableLineListener;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.contexts.IContextService;

public abstract class AbstractSynchronizedTableEditor extends AbstractTableEditor {



	/** listener on the model for synchronized table */
	private TriggerListener fillingListener;

	/** to listen moving lines in the table */
	private TriggerListener moveLineListener;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param servicesRegistry
	 *        the service serviceRegistry
	 * @param rawModel
	 *        the raw model
	 */
	public AbstractSynchronizedTableEditor(final ServicesRegistry servicesRegistry, final PapyrusTable rawModel) {
		super(servicesRegistry, rawModel);
	}



	/**
	 * 
	 * @see org.eclipse.emf.facet.widgets.nattable.workbench.editor.NatTableEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 * 
	 * @param site
	 * @param input
	 * @throws PartInitException
	 */
	@Override
	public void init(final IEditorSite site, final IEditorInput input) throws PartInitException {
		final PapyrusTableEditorInput tableEditorInput = new PapyrusTableEditorInput(this.rawModel, getEditingDomain());
		super.init(site, tableEditorInput);
	}


	/**
	 * add listeners on the context of the table and on the table itself
	 */
	@Override
	protected void configureEditorEditingDomain() {
		super.configureEditorEditingDomain();
		final EditingDomain editingDomain = getEditingDomain();
		Assert.isTrue(editingDomain instanceof TransactionalEditingDomain);

		this.fillingListener = new FillingListener(this.rawModel);
		((TransactionalEditingDomain)editingDomain).addResourceSetListener(this.fillingListener);

		this.moveLineListener = new MoveTableLineListener(this.rawModel);
		((TransactionalEditingDomain)editingDomain).addResourceSetListener(this.moveLineListener);
	}

	@Override
	public void createPartControl(final Composite parent) {
		final IContextService contextService = (IContextService)getSite().getService(IContextService.class);
		//FIXME : before Eclipse Juno, this line was not necessary
		//see bug 367816 and bug 382218
		contextService.activateContext("org.eclipse.papyrus.infra.table.efacet.common.context"); //$NON-NLS-1$
		super.createPartControl(parent);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.table.common.internal.NatTableEditor#dispose()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public void dispose() {
		((TransactionalEditingDomain)getEditingDomain()).removeResourceSetListener(this.fillingListener);
		((TransactionalEditingDomain)getEditingDomain()).removeResourceSetListener(this.moveLineListener);
		super.dispose();
	}



}
