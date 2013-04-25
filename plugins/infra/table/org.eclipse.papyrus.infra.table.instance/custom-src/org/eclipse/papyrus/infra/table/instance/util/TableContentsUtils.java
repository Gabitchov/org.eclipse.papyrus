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
package org.eclipse.papyrus.infra.table.instance.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrusTableInstance;
import org.eclipse.papyrus.infra.table.instance.papyrustableinstance.PapyrustableinstancePackage;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;


public class TableContentsUtils {


	private TableContentsUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param papyrusTable
	 *        the table to analyse
	 * @param synchronizedContent
	 *        <li>if <code>true</code> the method returns the list of the elements which should be contained by the table (using the queries or the
	 *        features)</li> <li>if <code>false</code> the method returns the list of the elements currently contained by the table (we use the
	 *        serialized table)</li>
	 * @return
	 */
	public static final List<EObject> getTableContents(final PapyrusTableInstance papyrusTable, final EObject tableContext, final boolean synchronizedContent) {
//		final List<EObject> result = new LinkedList<EObject>();
//		if(synchronizedContent && !papyrusTable.isUsingUser()) {
//			if(papyrusTable.isUsingContextFeature()) {
//				final EReference feature = papyrusTable.getContextFeature();
//				Object value = null;
//				try {
//					value = tableContext.eGet(feature);
//				} catch (final Exception e) {
//					//nothing to do
//				}
//				//				if(value == null) {//teh feature has not been found
//				//					final EStructuralFeature matchingFeature = tableContext.eClass().getEStructuralFeature(feature.getName());
//				//					if(matchingFeature != null) {
//				//						value = tableContext.eGet(matchingFeature);
//				//					}
//				//
//				//				}
//
//
//				if(value instanceof List<?>) {
//					result.addAll((List<EObject>)value);
//				} else if(value instanceof EObject) {
//					result.add((EObject)value);
//				}
//			} else if(papyrusTable.isUsingQueries()) {
//				//TODO
//			}
//		} else {
//			//duplicated code from TableWidgetUtils#public static List<EObject> getElements(final Table tableInstance) {
//			//TODO ask to Mia-Software to change this method in a upper plugin to avoid dependencies on UI
//			if(papyrusTable.getTable() != null) {
//				for(final Row row : papyrusTable.getTable().getRows()) {
//					result.add(row.getElement());
//				}
//			}
//		}
//		return result;
		
		//FIXME
		return new ArrayList<EObject>(papyrusTable.getTable().getElements());
	}
	
	/**
	 * Creates an iterable containing all the Papyrus Tables that are descending from the context.
	 * 
	 * @author olivier melois (Atos)
	 */
	public static Iterable<EObject> createDescendantTablesIterable(EObject context) {

		Set<EObject> result = Sets.newHashSet();

		TreeIterator<EObject> eAllContents = EcoreUtil.getAllProperContents(context, true);
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

	/**
	 * 
	 * @param selection
	 *        the current selection
	 * @return
	 *         the list of the papyrus table instance which have the selection has context
	 */
	public static Collection<PapyrusTableInstance> getPapyrusTableInstances(final EObject selection) {
		final Collection<PapyrusTableInstance> pTables = new ArrayList<PapyrusTableInstance>();
		Iterable<EObject> allDescendingPapyrusTables = createDescendantTablesIterable(selection);
		for(EObject eObject : allDescendingPapyrusTables) {
			if(eObject instanceof PapyrusTableInstance) {
				pTables.add((PapyrusTableInstance)eObject);
			}
		}
		return pTables;
	}
}
