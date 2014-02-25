/*
 * Copyright (c) 2010 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Yann Tanguy (CEA LIST) - initial API and implementation
 *
 */
package utils


import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet
import org.eclipse.papyrus.papyrusgmfgenextension.GenNodeConstraint
import org.eclipse.gmf.codegen.gmfgen.GenMultiFacetedNode

@Singleton class NodeConstraintUtils_qvto {

	def boolean hasNodeCreationConstraint(GenNode it) {
		return it.eResource.allContents.filter(typeof(GenNodeConstraint)).filter[v|v.genNode.contains(it) && v.genConstraint != null].size != 0
	}

	def GenNodeConstraint getNodeCreationConstraint(GenNode it) {

		if(hasNodeCreationConstraint(it)) {
			return it.eResource.allContents.filter(typeof(GenNodeConstraint)).filter[v|v.genNode.contains(it) && v.genConstraint != null].head
		} else {
			return null;
		}
	}

	def GenNode getOwningGenNode(TypeModelFacet it) {
		if (! it.eResource.allContents.filter(typeof(GenNode)).filter[v|v.modelFacet == it].empty)
		{
			return it.eResource.allContents.filter(typeof(GenNode)).filter[v|v.modelFacet == it].head
		}else{
			return it.eResource.allContents.filter(typeof(GenMultiFacetedNode)).filter[v|v.additionalModelFacets.contains(it)].head
		}
	}

	def String getNodeCreationConstraintBody(GenNode it) {
		var nodeConstraint = getNodeCreationConstraint(it);

		if(hasNodeCreationConstraint(it)) {
			if((nodeConstraint.genConstraint != null) && (nodeConstraint.genConstraint.body != null)) {
				return nodeConstraint.genConstraint.body;
			}
		}
		return "No GenNodeConstraint found.";
	}

}
