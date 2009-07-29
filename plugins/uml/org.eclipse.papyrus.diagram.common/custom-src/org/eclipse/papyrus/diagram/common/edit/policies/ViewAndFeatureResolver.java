/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.edit.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

// TODO: Auto-generated Javadoc
/**
 * Lets a D&D policy know if an <EObject> is a <Node> or a <Edge> in the host <EditPart>. Can
 * resolve the <EStructuralFeature> where an <EObject> is stored by its <ECLass>.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public interface ViewAndFeatureResolver extends ViewResolver {

	/**
	 * Gets the e structural feature for e class.
	 * 
	 * @param eClass
	 *            the e class
	 * 
	 * @return the e structural feature for e class
	 */
	EStructuralFeature getEStructuralFeatureForEClass(EClass eClass);

}
