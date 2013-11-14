/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.gmfdiag.common.editpolicies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * 
 * @author vl222926
 *         An eobject class used to represent a link with no semantic element
 */
public class EdgeWithNoSemanticElementRepresentationImpl extends EObjectImpl {

	/**
	 * the semantic hint for the represented element
	 */
	private String semanticHint;

	/**
	 * the source of the link
	 */
	private final EObject source;

	/**
	 * the target of the link
	 */
	private final EObject target;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        the source of the link
	 * @param target
	 *        the target of the link
	 * @param semanticHint
	 *        the semantic hint for the represented element
	 */
	public EdgeWithNoSemanticElementRepresentationImpl(final EObject source, final EObject target, final String semanticHint) {
		this.source = source;
		this.target = target;
		this.semanticHint = semanticHint;
	}

	/**
	 * 
	 * @return
	 *         the source of the represented link
	 */
	public EObject getSource() {
		return source;
	}

	/**
	 * 
	 * @return
	 *         the target of the represented link
	 */
	public EObject getTarget() {
		return target;
	}

	/**
	 * 
	 * @return
	 *         a view for this link
	 */
	public String getSemanticHint() {
		return semanticHint;
	}

	/**
	 * Calculate the hashcode in order to allows to have the same hashcode for 2 {@link EdgeWithNoSemanticElementRepresentationImpl} with the same
	 * field values.
	 * 
	 * @see java.lang.Object#hashCode()
	 * 
	 * @return
	 *         the hashcode
	 */
	@Override
	public int hashCode() {
		return this.target.hashCode() + 7 * this.source.hashCode() + 11 * this.semanticHint.hashCode();
	}

	/**
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 * @param obj
	 *        an object
	 * @return
	 *         <code>true</code> if this object is the same than the other one
	 */
	@Override
	public boolean equals(final Object obj) {
		if(obj instanceof EdgeWithNoSemanticElementRepresentationImpl) {
			final EdgeWithNoSemanticElementRepresentationImpl otherLink = (EdgeWithNoSemanticElementRepresentationImpl)obj;
			return this.source == otherLink.getSource() && this.target == otherLink.getTarget() && this.semanticHint.equals(otherLink.getSemanticHint());
		}
		return false;
	}
}