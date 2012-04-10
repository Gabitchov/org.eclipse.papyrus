/*******************************************************************************
 * Copyright (c) 2006, 2010 Soyatec (http://www.soyatec.com) and others.       *
 * All rights reserved. This program and the accompanying materials            *
 * are made available under the terms of the Eclipse Public License v1.0       *
 * which accompanies this distribution, and is available at                    *
 * http://www.eclipse.org/legal/epl-v10.html                                   *
 *                                                                             *  
 * Contributors:                                                               *        
 *     Soyatec - initial API and implementation                                *
 *******************************************************************************/
package org.eclipse.papyrus.xwt.internal.utils;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.papyrus.xwt.internal.xml.Attribute;
import org.eclipse.papyrus.xwt.internal.xml.DocumentObject;
import org.eclipse.papyrus.xwt.internal.xml.Element;

public class DocumentObjectSorter {

	public static List<DocumentObject> sortWithAttr(DocumentObject[] sourceArray, String attrName) {
		return sortWithAttr(sourceArray, new AttrComparator(attrName), attrName);
	}

	public static List<DocumentObject> sortWithAttr(DocumentObject[] sourceArray, Comparator<Element> comparator, String attrName) {
		List<DocumentObject> columnsList = new LinkedList<DocumentObject>();
		for(DocumentObject column : sourceArray) {
			Element columnElement = (Element)column;
			Attribute indexAttr = columnElement.getAttribute(attrName);
			if(indexAttr == null) {
				columnsList.add(column);
			}
		}

		List<Element> tempList = new LinkedList<Element>();
		for(DocumentObject column : sourceArray) {
			Element columnElement = (Element)column;
			Attribute indexAttr = columnElement.getAttribute(attrName);
			if(indexAttr != null) {
				tempList.add(columnElement);
			}
		}

		if(comparator == null) {
			comparator = new AttrComparator(attrName);
		}
		Collections.sort(tempList, comparator);

		for(Element columnElement : tempList) {
			Attribute indexAttr = columnElement.getAttribute(attrName);
			try {
				int index = Integer.parseInt(indexAttr.getContent());
				columnsList.add(index, columnElement);
			} catch (Exception e) {
				columnsList.add(columnsList.size(), columnElement);
			}
		}

		return columnsList;
	}

	private static class AttrComparator implements Comparator<Element>, Serializable {

		private static final long serialVersionUID = 1L;

		private String attrName;

		public AttrComparator(String attrName) {
			this.attrName = attrName;
		}

		public int compare(Element e1, Element e2) {
			Attribute attr1 = e1.getAttribute(attrName);
			Attribute attr2 = e2.getAttribute(attrName);
			String compare1 = attr1.getContent();
			String compare2 = attr2.getContent();
			if(compare1 == null || compare2 == null) {
				return 0;
			}
			try {
				int index1 = Integer.parseInt(compare1);
				int index2 = Integer.parseInt(compare2);
				return index1 > index2 ? 1 : -1;
			} catch (Exception e) {
				return compare1.compareTo(compare2);
			}
		}
	}
}
