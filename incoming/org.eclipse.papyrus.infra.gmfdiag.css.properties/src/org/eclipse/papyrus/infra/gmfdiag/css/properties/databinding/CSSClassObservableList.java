/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.databinding;

import java.text.Collator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.Diffs;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.databinding.AnnotationObservableValue;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSAnnotations;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;

/**
 * An ObservableList containing a list of classes. When commit is called,
 * the list is concatenated in a space-separated String.
 * 
 * @author Camille Letavernier
 */
public class CSSClassObservableList extends WritableList implements ICommitListener, IChangeListener {

	private AnnotationObservableValue observable;

	protected EditingDomain domain;

	protected EModelElement source;

	private String currentValue = null;

	public CSSClassObservableList(EditingDomain domain, EModelElement source) {
		super(new LinkedList<String>(), String.class);
		this.domain = domain;
		this.source = source;
		observable = new AnnotationObservableValue(source, domain, CSSAnnotations.CSS_ANNOTATION, CSSAnnotations.CSS_GMF_CLASS_KEY);
		observable.addChangeListener(this);
		parseValue(false);
	}

	public void commit(AbstractEditor editor) {
		String value = getStringValue();

		observable.setValue(value);
	}

	public void handleChange(ChangeEvent event) {
		String oldValue = currentValue;
		String newValue = (String)observable.getValue();
		if(Collator.getInstance().equals(oldValue, newValue)) {
			return;
		}

		parseValue(true);
	}

	protected String getStringValue() {
		String value = "";
		for(Object cssClassObject : this) {
			String cssClass = (String)cssClassObject;
			value += cssClass + " ";
		}

		if(value.equals("")) {
			value = null; //Unset the annotation key
		} else {
			value = value.trim(); //remove the trailing space
		}

		return value;
	}

	protected void parseValue(boolean isChange) {
		currentValue = (String)observable.getValue();
		if(currentValue == null) {
			if(isChange) {
				clear();
			} else {
				this.wrappedList.clear();
			}
			return;
		}

		String[] values = currentValue.split("\\s");
		List<String> valuesList = new ArrayList<String>(values.length);
		for(String currentValue : values) {
			if(!currentValue.isEmpty()) {
				valuesList.add(currentValue);
			}
		}

		final List previousList = new LinkedList(wrappedList);

		this.wrappedList.clear();
		this.wrappedList.addAll(valuesList);

		if(isChange) {

			final List newList = new LinkedList(wrappedList);
			final ListDiffEntry[] differences = Diffs.computeListDiff(previousList, newList).getDifferences();

			fireListChange(new ListDiff() {

				@Override
				public ListDiffEntry[] getDifferences() {
					return differences;
				}

			});
		}
	}
}
