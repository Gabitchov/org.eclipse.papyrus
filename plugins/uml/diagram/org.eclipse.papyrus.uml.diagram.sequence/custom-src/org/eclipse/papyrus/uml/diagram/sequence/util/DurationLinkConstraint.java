/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.gef.EditPart;
import org.eclipse.papyrus.infra.constraints.SimpleConstraint;
import org.eclipse.papyrus.infra.constraints.constraints.Constraint;
import org.eclipse.papyrus.infra.tools.util.ClassLoaderHelper;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.CommentAnnotatedElementEditPart;

public class DurationLinkConstraint extends org.eclipse.papyrus.infra.constraints.constraints.AbstractConstraint {

	private String sourcePart;

	@Override
	protected void setDescriptor(SimpleConstraint descriptor) {
		sourcePart = getValue("sourcePart"); //$NON-NLS-1$
	}

	@Override
	public boolean match(Object selection) {
		if(selection instanceof CommentAnnotatedElementEditPart) {
			CommentAnnotatedElementEditPart sel = (CommentAnnotatedElementEditPart)selection;
			EditPart source = sel.getSource();
			if(source != null && sourcePart != null) {
				Class<?> clazz = ClassLoaderHelper.loadClass(sourcePart);
				return clazz.isInstance(source);
			}
		}
		return false;
	}

	@Override
	protected boolean equivalent(Constraint constraint) {
		if(constraint == null) {
			return false;
		}
		if(!(constraint instanceof DurationLinkConstraint)) {
			return false;
		}
		DurationLinkConstraint other = (DurationLinkConstraint)constraint;
		if(sourcePart == null) {
			if(other.sourcePart != null)
				return false;
		} else if(!sourcePart.equals(other.sourcePart))
			return false;

		return true;
	}

}
