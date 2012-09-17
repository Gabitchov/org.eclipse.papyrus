/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.Row;


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
	public static final List<EObject> getTableContents(final PapyrusTable papyrusTable, final EObject tableContext, final boolean synchronizedContent) {
		final List<EObject> result = new LinkedList<EObject>();
		if(synchronizedContent && !papyrusTable.isUsingUser()) {
			if(papyrusTable.isUsingContextFeature()) {
				final EReference feature = papyrusTable.getContextFeature();
				Object value = null;
				try {
					value = tableContext.eGet(feature);
				} catch (final Exception e) {
					//nothing to do
				}
				//				if(value == null) {//teh feature has not been found
				//					final EStructuralFeature matchingFeature = tableContext.eClass().getEStructuralFeature(feature.getName());
				//					if(matchingFeature != null) {
				//						value = tableContext.eGet(matchingFeature);
				//					}
				//
				//				}


				if(value instanceof List<?>) {
					result.addAll((List<EObject>)value);
				} else if(value instanceof EObject) {
					result.add((EObject)value);
				}
			} else if(papyrusTable.isUsingQueries()) {
				//TODO
			}
		} else {
			//duplicated code from TableWidgetUtils#public static List<EObject> getElements(final Table tableInstance) {
			//TODO ask to Mia-Software to change this method in a upper plugin to avoid dependencies on UI
			if(papyrusTable.getTable() != null) {
				for(final Row row : papyrusTable.getTable().getRows()) {
					result.add(row.getElement());
				}
			}
		}
		return result;
	}
}
