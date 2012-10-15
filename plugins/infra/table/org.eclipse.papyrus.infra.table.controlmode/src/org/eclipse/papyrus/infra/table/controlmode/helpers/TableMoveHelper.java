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
package org.eclipse.papyrus.infra.table.controlmode.helpers;

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
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;
import org.eclipse.papyrus.views.modelexplorer.commands.MoveOpenableCommand;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;

/**
 * Helper used to move the tables into the right resources when controlling a package.
 */
public class TableMoveHelper {

	/**
	 * Adds commands to move every table that descend from the selection to the target resource.
	 */
	public static void addAllTableMoveCommands(EditingDomain domain, EObject selection, Resource target, CompoundCommand commandToModify) {
		/*
		 * All the tables in the tables that descend from the selection.
		 */
		Iterable<EObject> allDescendingPapyrusTables = createDescendantTablesIterable(selection);

		/*
		 * Making sure the editing domain is transactional.
		 */
		if(!(domain instanceof TransactionalEditingDomain)) {
			throw new RuntimeException("Unable to retrieve the transactional editing domain");////$NON-NLS-1$
		}
		TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)domain;

		/*
		 * Moving every table from the new resource.
		 */
		for(EObject descendant : allDescendingPapyrusTables) {
			if(descendant instanceof PapyrusTableInstance) {
				PapyrusTableInstance papyrusTable = (PapyrusTableInstance)descendant;
				addMoveTableCommand(editingDomain, papyrusTable, target, commandToModify);
			}
		}
	}


	/**
	 * Adds a command to move a papyrus table and the matching table2 instance, to the compound command.
	 */
	protected static void addMoveTableCommand(TransactionalEditingDomain editingDomain, PapyrusTableInstance papyrusTable, Resource target, CompoundCommand commandToModify) {
		//The command has to move both the table and its table2.
		TableInstance2 papyrusTable2 = papyrusTable.getTable();

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
			MoveOpenableCommand mvTabCmd = new MoveOpenableCommand(editingDomain, "moving table", papyrusTable, target);//$NON-NLS-1$
			if(mvTabCmd != null && mvTabCmd.canExecute()) {
				commandToModify.append(new GMFtoEMFCommandWrapper(mvTabCmd));
			}

			MoveOpenableCommand mvTab2Cmd = new MoveOpenableCommand(editingDomain, "moving table2", papyrusTable2, target);//$NON-NLS-1$
			if(mvTab2Cmd != null && mvTab2Cmd.canExecute()) {
				commandToModify.append(new GMFtoEMFCommandWrapper(mvTab2Cmd));
			}
		}
	}

	/**
	 * Creates an iterable containing all the Papyrus Tables that are descending from the context.
	 * 
	 * @author olivier melois (Atos)
	 */
	public static Iterable<EObject> createDescendantTablesIterable(EObject context) {

		Set<EObject> result = Sets.newHashSet();

		TreeIterator<EObject> eAllContents = EcoreUtil.getAllProperContents(context, true); // was context.eAllContents().
		Iterator<EObject> contextAndDescendants = Iterators.concat(eAllContents, Iterators.singletonIterator(context));

		final Predicate<Setting> keepPapyrusTableInstances = new Predicate<Setting>() {

			public boolean apply(Setting setting) {
				boolean result = true;
				if(setting != null) {
					EObject settingEObject = setting.getEObject();
					result &= settingEObject instanceof PapyrusTableInstance;
					result &= PapyrustableinstancePackage.Literals.PAPYRUS_TABLE_INSTANCE__TABLE == setting.getEStructuralFeature();
				} else {
					result = false;
				}
				return result;
			}
		};

		/*
		 * Predicate used to keep the usages which are PapyrusTableInstances
		 */
		Predicate<Setting> keepTableInstances = new Predicate<Setting>() {

			public boolean apply(Setting setting) {
				boolean result = true;
				if(setting != null) {
					EObject settingEObject = setting.getEObject();
					result &= settingEObject instanceof TableInstance;
					result &= setting.getEStructuralFeature() == TableinstancePackage.Literals.TABLE_INSTANCE__CONTEXT;

					Collection<Setting> references = EMFHelper.getUsages(settingEObject);
					Iterable<Setting> papyrusTableInstances = Iterables.filter(references, keepPapyrusTableInstances);
					//Veryfing that there is at least one papyrusTableInstance
					result = result && !Iterables.isEmpty(papyrusTableInstances);

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
				Collection<Setting> references = EMFHelper.getUsages(settingEObject);
				Iterable<Setting> papyrusTableInstances = Iterables.filter(references, keepPapyrusTableInstances);
				//Getting the eobject of thie first element of this iterable.
				return Iterables.get(papyrusTableInstances, 0).getEObject();
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
