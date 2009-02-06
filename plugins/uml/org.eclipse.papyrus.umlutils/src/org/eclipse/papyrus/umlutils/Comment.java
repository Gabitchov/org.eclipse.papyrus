/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.umlutils;

/**
 * 
 * 
 * 
 * 
 * This class represents a comment and encapsulates an org.eclipse.uml2.uml.Comment object
 */
public class Comment extends Element {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Comment uml2Comment;

	/**
	 * 
	 * 
	 * @param uml2Comment
	 */
	public Comment(org.eclipse.uml2.uml.Comment uml2Comment) {
		super(uml2Comment);
		this.uml2Comment = uml2Comment;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Comment.
	 */
	public org.eclipse.uml2.uml.Comment getUml2Comment() {
		return uml2Comment;
	}

}