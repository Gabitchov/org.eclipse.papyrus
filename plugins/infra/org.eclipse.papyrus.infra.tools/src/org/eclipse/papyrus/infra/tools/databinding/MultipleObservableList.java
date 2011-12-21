/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.tools.databinding;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.papyrus.infra.widgets.databinding.AggregatedObservable;
import org.eclipse.papyrus.infra.widgets.editors.AbstractEditor;
import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;

//TODO : Implement the getters
//The list may be either the union or the intersection of all sublists
//Union : allows the "remove" and "removeAll" on a group of lists (Even if one of the sublists doesn't contain the given element)
//Intersection : Closer to the behavior of the CompositeValue (The current value is displayed only if it is shared by all elements)
//The Union is probably a better solution
//Simple solution : bind read operations to the first sub-list

/**
 * A Composite ObservableList. Modifications are forwarded to each sublist
 * The read operations are not supported. This list behaves as if it were empty
 * 
 * @author Camille Letavernier
 */
//TODO : Add listeners on sub-observables, and remove them on dispose
public class MultipleObservableList extends ObservableList implements ICommitListener, AggregatedObservable {

	List<IObservableList> observableLists = new LinkedList<IObservableList>();

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public MultipleObservableList() {
		super(new LinkedList<Object>(), Object.class);
		throw new UnsupportedOperationException("This class is not supported yet"); //$NON-NLS-1$
	}

	@Override
	public void add(int index, Object element) {
		for(IObservableList observableList : observableLists) {
			observableList.add(index, element);
		}
	}

	@Override
	public void clear() {
		for(IObservableList observableList : observableLists) {
			observableList.clear();
		}
	}

	@Override
	public boolean contains(Object o) {
		boolean contains = false;

		for(IObservableList observableList : observableLists) {
			if(observableList.contains(o)) {
				contains = true;
			} else {
				return false;
			}
		}

		return contains;
	}

	@Override
	public boolean add(Object o) {
		for(IObservableList observableList : observableLists) {
			observableList.add(o);
		}
		return true;
	}

	@Override
	public boolean remove(Object o) {
		for(IObservableList observableList : observableLists) {
			observableList.remove(o);
		}
		return true;
	}

	@Override
	public boolean containsAll(Collection c) {
		boolean containsAll = false;
		for(IObservableList observableList : observableLists) {
			containsAll = containsAll && observableList.containsAll(c);
		}
		return containsAll;
	}

	@Override
	public boolean addAll(Collection c) {
		for(IObservableList observableList : observableLists) {
			observableList.addAll(c);
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		for(IObservableList observableList : observableLists) {
			observableList.addAll(index, c);
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection c) {
		for(IObservableList observableList : observableLists) {
			observableList.removeAll(c);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection c) {
		for(IObservableList observableList : observableLists) {
			observableList.retainAll(c);
		}
		return true;
	}

	@Override
	public Object set(int index, Object element) {
		for(IObservableList observableList : observableLists) {
			observableList.set(index, element);
		}
		return null;
	}

	@Override
	public Object move(int oldIndex, int newIndex) {
		for(IObservableList observableList : observableLists) {
			observableList.move(oldIndex, newIndex);
		}
		return null;
	}

	@Override
	public Object remove(int index) {
		for(IObservableList observableList : observableLists) {
			observableList.remove(index);
		}
		return null;
	}

	public void commit(AbstractEditor editor) {
		for(IObservableList observableList : observableLists) {
			if(observableList instanceof ICommitListener) {
				((ICommitListener)observableList).commit(editor);
			}
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		for(IObservableList observable : observableLists) {
			observable.dispose();
		}
	}
}
