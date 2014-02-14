/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Gregoire Dupe (Mia-Software) - initial API and implementation
 *   Nicolas Bros (Mia-Software) - Bug 339664 - org.eclipse.emf.facet.widgets.celleditors API cleaning
 *   Gregoire Dupe (Mia-Software) - Bug 344563 - NPE with Enum Editor
 *****************************************************************************/
package org.eclipse.emf.facet.widgets.celleditors.internal.core.composite;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.swt.widgets.Composite;

public class EnumeratorComposite<T extends Enumerator> extends EnumComposite<T> {

	public EnumeratorComposite(final Composite parent) {
		super(parent);

	}

	private EEnum eenum = null;

	public void setEEnum(final EEnum eenum2) {
		this.eenum = eenum2;
		getCombo().setItems(getEnumStrings());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected T getEnumValue(final String text) {
		if (this.eenum.getEEnumLiteralByLiteral(text) == null) {
			throw new RuntimeException("Invalid enumeration literal"); //$NON-NLS-1$
		}
		Object result = this.eenum.getEPackage().getEFactoryInstance()
				.createFromString(this.eenum, this.eenum.getEEnumLiteralByLiteral(text).getName());
		if (result instanceof Enumerator) {
			return (T) result;
		}
		return null;
	}

	@Override
	public String getEnumString(final T value) {
		return value.getLiteral();
	}

	@Override
	protected String[] getEnumStrings() {
		List<String> result = new ArrayList<String>();
		if (this.eenum != null) {
			for (EEnumLiteral eeNumLiteral : this.eenum.getELiterals()) {
				result.add(eeNumLiteral.getLiteral());
			}
		}
		return result.toArray(new String[] {});
	}
}
