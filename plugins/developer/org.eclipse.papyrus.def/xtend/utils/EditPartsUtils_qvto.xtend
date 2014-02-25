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
import java.util.List
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.papyrus.papyrusgmfgenextension.SpecificLocatorExternalLabel

@Singleton class EditPartsUtils_qvto {

	def boolean hasSpecificLocator(GenExternalNodeLabel it) {

		return it.eResource.allContents.filter(typeof(SpecificLocatorExternalLabel)).filter[v|v.genExternalNodeLabel.contains(it)].size != 0
	}

	def String getSpecificLocator(GenExternalNodeLabel it) {

		if(hasSpecificLocator(it)) {
			return it.eResource.allContents.filter(typeof(SpecificLocatorExternalLabel)).filter[v|v.genExternalNodeLabel.contains(it)].head.classpath
		}

		return null;
	}

	def List<GenExternalNodeLabel> getExternalLabelsWithoutSpecificLocator(GenNode it) {
		return it.labels.filter(typeof(GenExternalNodeLabel)).filter[l|!hasSpecificLocator(l)].toList;
	}

	def List<GenExternalNodeLabel> getExternalLabelsWithSpecificLocator(GenNode it) {
		return it.labels.filter(typeof(GenExternalNodeLabel)).filter[l|hasSpecificLocator(l)].toList;
	}

}
