/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.parser;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

public class BasicApplyStrategy implements ApplyStrategy {

	public List/* 1.5 <ICommand> */apply(EObject modelObject, EObject parsedObject) {
		List result = new LinkedList();
		for (Iterator it = parsedObject.eClass().getEAllStructuralFeatures().iterator(); it.hasNext();) {
			EStructuralFeature next = (EStructuralFeature) it.next();
			if (parsedObject.eIsSet(next) && !next.isDerived()) {
				transferValue(result, modelObject, parsedObject, next);
			}
		}
		return result.isEmpty() ? NOT_EXECUTABLE : result;
	}

	protected final void transferValue(List output, EObject model, EObject parsed, EStructuralFeature feature) {
		if (feature.isDerived() || !parsed.eIsSet(feature)) {
			return;
		}
		Object parsedValue = parsed.eGet(feature);
		Object actualValue = model.eGet(feature);
		if (safeEquals(parsedValue, actualValue)) {
			return;
		}
		// XXX: workaround for : #152080
		// XXX: can not set multi-valued properties using SetValueCommand,
		// XXX: see https://bugs.eclipse.org/bugs/show_bug.cgi?id=152080
		if (feature instanceof EReference && feature.isMany()) {
			transferValuesList(output, model, parsed, (EReference) feature);
			return;
		}
		SetRequest request = new SetRequest(model, feature, parsedValue);
		output.add(new SetValueCommand(request));
	}

	private void transferValuesList(List output, EObject model, EObject parsed, EReference isManyReference) {
		assert isManyReference.isMany();
		List<EObject> actualValues = (List<EObject>) model.eGet(isManyReference);
		List<EObject> parsedValues = (List<EObject>) parsed.eGet(isManyReference);

		for (EObject nextActual : actualValues) {
			DestroyReferenceRequest nextRequest = new DestroyReferenceRequest(model, isManyReference, nextActual, false);
			output.add(new DestroyReferenceCommand(nextRequest));
		}

		for (EObject nextParsed : parsedValues) {
			SetRequest nextRequest = new SetRequest(model, isManyReference, nextParsed);
			output.add(new SetValueCommand(nextRequest));
		}
	}

	protected static <T> boolean safeEquals(T o1, T o2) {
		return o1 == null ? o2 == null : o1.equals(o2);
	}

}
