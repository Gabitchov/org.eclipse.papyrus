/*******************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.domaincontextcodegen.utils;

import org.eclipse.papyrus.domaincontextcodegen.ElementType;
import org.eclipse.papyrus.domaincontextcodegen.MetaClassType;
import org.eclipse.papyrus.domaincontextcodegen.SpecializationType;

public class ModelUtils {

	public boolean isAbstract(ElementType type) {

		boolean isAbstract = false;

		MetaClassType mt = null;
		if(type instanceof MetaClassType) {
			mt = (MetaClassType)type;
			isAbstract = mt.getMetaClass().isAbstract();

		} else if(type instanceof SpecializationType) {
			SpecializationType st = (SpecializationType)type;
			mt = getMetaClassType(st);
		}

		if(mt != null) {
			isAbstract = mt.getMetaClass().isAbstract();
		}

		return isAbstract;
	}

	private MetaClassType getMetaClassType(SpecializationType st) {

		if(st.getRef() instanceof MetaClassType) {
			return (MetaClassType)st.getRef();

		} else if(st.getRef() instanceof SpecializationType) {
			return getMetaClassType((SpecializationType)st.getRef());

		}

		return null;
	}
}
