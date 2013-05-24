/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Juan Cadavid (CEA LIST) juan.cadavid@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.controlmode.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.exception.SashEditorException;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;


public class TableMoveHelper {

	public static void addAllTableMoveCommands(EditingDomain domain, EObject selection, Resource source, final Resource target, CompoundCommand commandToModify) {
		if(!(domain instanceof TransactionalEditingDomain)) {
			throw new RuntimeException("Unable to retrieve the transactional editing domain");//$NON-NLS-1$
		}

		final Collection<Table> pTables = getPapyrusTableInstances(selection);
		if(!pTables.isEmpty()) {
			RecordingCommand cmd = new RecordingCommand((TransactionalEditingDomain)domain) {

				@Override
				protected void doExecute() {
					target.getContents().addAll(pTables);

				}
			};
			commandToModify.append(cmd);
		}
	}

	public static void addAllPageRefTableMoveCommands(TransactionalEditingDomain domain, EObject selection, Resource source, Resource target, final SashWindowsMngr windowsMngr, CompoundCommand commandToModify) {
		//1. we get the PapyrusTable to move
		final Collection<Table> tables = getPapyrusTableInstances(selection);

		//2. add pages to the page list
		for(final Table pTable : tables) {
			final PageRef pageRef = DiUtils.getPageRef(source, pTable);
			final ICommand addPageCommand = new AbstractTransactionalCommand(domain, "Add Page Command", null) { //$NON-NLS-1$

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					windowsMngr.getPageList().addPage(pageRef.getPageIdentifier());
					try {
						DiUtils.addPageToTabFolder(windowsMngr, pageRef);
					} catch (final SashEditorException e) {
						return CommandResult.newErrorCommandResult(e);
					}
					return CommandResult.newOKCommandResult();
				}
			};

			commandToModify.append(new GMFtoEMFCommandWrapper(addPageCommand));
		}

	}

	private static Collection<Table> getPapyrusTableInstances(final EObject selection) {
		final Collection<Table> pTables = new ArrayList<Table>();
		Iterable<EObject> allDescendingPapyrusTables = createDescendantTablesIterable(selection);
		for(EObject eObject : allDescendingPapyrusTables) {
			if(eObject instanceof Table) {
				pTables.add((Table)eObject);
			}
		}
		return pTables;
	}

	/**
	 * Creates an iterable containing all the Papyrus Tables that are descending from the context.
	 */
	public static Iterable<EObject> createDescendantTablesIterable(EObject context) {

		Set<EObject> result = Sets.newHashSet();

		TreeIterator<EObject> eAllContents = EcoreUtil.getAllProperContents(context, true); // was context.eAllContents().
		Iterator<EObject> contextAndDescendants = Iterators.concat(eAllContents, Iterators.singletonIterator(context));

		/*
		 * Predicate used to keep the usages which are PapyrusTableInstances
		 */
		Predicate<Setting> keepTableInstances = new Predicate<Setting>() {

			public boolean apply(Setting setting) {
				boolean result = true;
				if(setting != null) {
					EObject settingEObject = setting.getEObject();
					result &= settingEObject instanceof Table;
				} else {
					result = false;
				}
				return result;
			}
		};

		/*
		 * Function to get the eObject from a setting
		 */
		Function<Setting, EObject> getEObject = new Function<Setting, EObject>() {

			public EObject apply(Setting input) {
				EObject settingEObject = input.getEObject();
				return settingEObject;
			}

		};

		/*
		 * For the context and his descendants :
		 */
		while(contextAndDescendants.hasNext()) {
			EObject current = contextAndDescendants.next();
			//Usages
			Iterable<Setting> usages = EMFHelper.getUsages(current);
			//Filtering to keep only papyrus table instances.
			Iterable<Setting> tableInstanceSettings = Iterables.filter(usages, keepTableInstances);
			//Getting the eObjects
			Iterable<EObject> papyrusTableInstances = Iterables.transform(tableInstanceSettings, getEObject);
			//Adding all the kept usages.
			Iterables.addAll(result, papyrusTableInstances);
		}

		return result;
	}

}
