/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.widget.celleditors.editors;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.facet.widgets.celleditors.IListener;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditHandler;
import org.eclipse.emf.facet.widgets.celleditors.IModelCellEditor;
import org.eclipse.emf.facet.widgets.celleditors.internal.core.composite.EnumeratorComposite;
import org.eclipse.papyrus.uml.table.widget.celleditors.composite.PapyrusEnumeratorComposite;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * This class provides an Editor for EMF Enumerator.
 * 
 * FIXME : this class doesn't depend on UML.
 */

public class EnumeratorEditor implements IModelCellEditor {

	/** the composite for this editor */
	private EnumeratorComposite<Enumerator> composite = null;

	/**
	 * {@inheritDoc}
	 * 
	 * @return <code>null</code> when the Enumeration constains only one EnumLiteral
	 */
	public Control activateCell(Composite parent, Object originalValue, final IModelCellEditHandler editHandler, EStructuralFeature feature, EObject source) {
		if(originalValue instanceof Enumerator) {
			Class<?> class_ = originalValue.getClass();
			Object[] constants = class_.getEnumConstants();
			EEnum myEEnum = EcoreFactoryImpl.eINSTANCE.createEEnum();
			myEEnum.setName(class_.getSimpleName());
			myEEnum.setInstanceClassName(class_.getName());
			for(int i = 0; i < constants.length; i++) {
				EEnumLiteral literal = EcoreFactoryImpl.eINSTANCE.createEEnumLiteral();
				literal.setInstance((Enumerator)constants[i]);
				myEEnum.getELiterals().add(literal);

			}

			if(myEEnum.getELiterals().size() > 2) {//we don't return the editor when there is only one value in the enumeration
				this.composite = new PapyrusEnumeratorComposite<Enumerator>(parent);
				this.composite.setEEnum(myEEnum);
				this.composite.setValue((Enumerator)originalValue);
				this.composite.addCommitListener(new IListener() {

					public void handleEvent() {
						editHandler.commit();
					}
				});
				return this.composite;
			}
		}
		return null;
	}


	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	public Object getValue() {
		return this.composite.getValue();
	}

}
