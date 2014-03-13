/*****************************************************************************
 * Copyright (c) 2011 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos) mathieu.velten@atos.net - Initial API and implementation
 *  Philippe Roland (Atos) philippe.roland@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.matching;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EReferenceTreeElement;

/***
 * An IMatchingItem implementation that matches for LinkItems
 * 
 * @author proland
 */
public class LinkItemMatchingItem implements IMatchingItem {

	private EObject parent;

	private EReference ref;

	public LinkItemMatchingItem(EObject parent, EReference ref) {
		this.parent = parent;
		this.ref = ref;
	}

	public boolean matchingItemEquals(Object obj) {
		if(obj instanceof EReferenceTreeElement) {
			if(ref != null && parent != null) {
				return parent.equals(((EReferenceTreeElement)obj).getParent()) && ref.equals(((EReferenceTreeElement)obj).getEReference());
			}
		}
		return super.equals(obj);
	}

	public int matchingItemHashcode() {
		if(ref != null && parent != null) {
			return HashCodeCalculus.getHashCode(parent, ref);
		}
		return 0;
	}

}
