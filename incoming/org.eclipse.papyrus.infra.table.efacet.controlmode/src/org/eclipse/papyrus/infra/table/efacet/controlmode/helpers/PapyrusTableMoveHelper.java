/*****************************************************************************
 * Copyright (c) 2012 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Olivier Melois (ATOS) olivier.melois@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.controlmode.helpers;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TableInstance;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.TablePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrustablePackage;
import org.eclipse.papyrus.views.modelexplorer.commands.MoveOpenableCommand;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

/**
 * Helper used to move the tables into the right resources when controlling a package.
 */
//FIXME : remove the dependency on the ModelExplorer
public class PapyrusTableMoveHelper {


	private PapyrusTableMoveHelper() {
		//to prevent instanciation
	}

	/**
	 * Adds commands to move every table that descend from the selection to the target resource.
	 */
	public static void addAllTableMoveCommands(final EditingDomain domain, final EObject selection, final Resource target, final CompoundCommand commandToModify) {
		/*
		 * All the tables in the tables that descend from the selection.
		 */
		final Iterable<EObject> allDescendingPapyrusTables = createDescendantTablesIterable(selection);

		/*
		 * Making sure the editing domain is transactional.
		 */
		if(!(domain instanceof TransactionalEditingDomain)) {
			throw new RuntimeException("Unable to retrieve the transactional editing domain");////$NON-NLS-1$
		}
		final TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)domain;

		/*
		 * Moving every table from the new resource.
		 */
		for(final EObject descendant : allDescendingPapyrusTables) {
			if(descendant instanceof PapyrusTable) {
				final PapyrusTable papyrusTable = (PapyrusTable)descendant;
				addMoveTableCommand(editingDomain, papyrusTable, target, commandToModify);
			}
		}
	}


	/**
	 * Adds a command to move a papyrus table and the matching table2 instance, to the compound command.
	 */
	protected static void addMoveTableCommand(final TransactionalEditingDomain editingDomain, final PapyrusTable papyrusTable, final Resource target, final CompoundCommand commandToModify) {
		/*
		 * Has the target resource been loaded, and is it in read only mode ?
		 */
		if(editingDomain.isReadOnly(target)) {
			return;
		}

		/*
		 * Moving both the table instance and the table2 instance.
		 */
		if(target != null) {
			final MoveOpenableCommand mvTabCmd = new MoveOpenableCommand(editingDomain, "moving table", papyrusTable, target);//$NON-NLS-1$
			if((mvTabCmd != null) && mvTabCmd.canExecute()) {
				commandToModify.append(new GMFtoEMFCommandWrapper(mvTabCmd));
			}
		}
	}

	/**
	 * Creates an iterable containing all the Papyrus Tables that are descending from the context.
	 * 
	 * @author olivier melois (Atos)
	 */
	public static Iterable<EObject> createDescendantTablesIterable(final EObject context) {

		final Set<EObject> result = Sets.newHashSet();

		final TreeIterator<EObject> eAllContents = EcoreUtil.getAllProperContents(context, true); // was context.eAllContents().
		final Iterator<EObject> contextAndDescendants = Iterators.concat(eAllContents, Iterators.singletonIterator(context));

		final Predicate<Setting> keepPapyrusTableInstances = new Predicate<Setting>() {

			public boolean apply(final Setting setting) {
				boolean result = true;
				if(setting != null) {
					final EObject settingEObject = setting.getEObject();
					result &= settingEObject instanceof PapyrusTable;
					result &= PapyrustablePackage.Literals.PAPYRUS_TABLE__TABLE == setting.getEStructuralFeature();
				} else {
					result = false;
				}
				return result;
			}
		};

		/*
		 * Predicate used to keep the usages which are PapyrusTableInstances
		 */
		final Predicate<Setting> keepTableInstances = new Predicate<Setting>() {

			public boolean apply(final Setting setting) {
				boolean result = true;
				if(setting != null) {
					final EObject settingEObject = setting.getEObject();
					result &= settingEObject instanceof TableInstance;
					result &= setting.getEStructuralFeature() == TablePackage.Literals.TABLE__CONTEXT;

					final Collection<Setting> references = PapyrusEcoreUtils.getUsages(settingEObject);
					final Iterable<Setting> papyrusTableInstances = Iterables.filter(references, keepPapyrusTableInstances);
					//Veryfing that there is at least one papyrusTableInstance
					result = result && !Iterables.isEmpty(papyrusTableInstances);
					System.out.println("result2 = " + result);

				} else {
					result = false;
				}
				return result;
			}
		};

		/*
		 * Function to get the eObject from a setting
		 */
		final Function<Setting, EObject> getEObject = new Function<Setting, EObject>() {

			public EObject apply(final Setting input) {
				final EObject settingEObject = input.getEObject();
				final Collection<Setting> references = PapyrusEcoreUtils.getUsages(settingEObject);
				final Iterable<Setting> papyrusTableInstances = Iterables.filter(references, keepPapyrusTableInstances);
				//Getting the eobject of thie first element of this iterable.
				return Iterables.get(papyrusTableInstances, 0).getEObject();
			}

		};

		/*
		 * For the context and his descendants :
		 */
		while(contextAndDescendants.hasNext()) {
			final EObject current = contextAndDescendants.next();
			//Usages
			final Iterable<Setting> usages = PapyrusEcoreUtils.getUsages(current);
			//Filtering to keep only papyrus table instances.
			final Iterable<Setting> tableInstanceSettings = Iterables.filter(usages, keepTableInstances);
			//Getting the eObjects 
			final Iterable<EObject> papyrusTableInstances = Iterables.transform(tableInstanceSettings, getEObject);
			//Adding all the kept usages.
			Iterables.addAll(result, papyrusTableInstances);
		}

		return result;
	}
}
