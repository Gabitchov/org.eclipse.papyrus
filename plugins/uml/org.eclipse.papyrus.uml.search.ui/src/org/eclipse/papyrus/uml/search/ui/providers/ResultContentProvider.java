/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Fix leaking of all UML models in search results
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui.providers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.uml.search.ui.pages.PapyrusSearchResultPage;
import org.eclipse.papyrus.uml.search.ui.query.AbstractPapyrusQuery;
import org.eclipse.papyrus.uml.search.ui.results.PapyrusSearchResult;
import org.eclipse.papyrus.views.search.results.AbstractResultEntry;
import org.eclipse.papyrus.views.search.results.ResultEntry;
import org.eclipse.papyrus.views.search.utils.MatchUtils;
import org.eclipse.search.ui.text.AbstractTextSearchResult;

/**
 * 
 * A content provider that generate the content through the results computed by resultContentProviders
 * 
 */
public class ResultContentProvider implements ITreeContentProvider {

	private final Object[] EMPTY_ARR = new Object[0];

	private AbstractTextSearchResult fResult = null;

	private PapyrusSearchResultPage fPage = null;

	private AbstractTreeViewer fViewer;


	public AbstractTreeViewer getfViewer() {
		return fViewer;
	}


	public void setfViewer(AbstractTreeViewer fViewer) {
		this.fViewer = fViewer;
	}

	private Map<Object, Set<Object>> fChildrenMap;

	public ResultContentProvider(PapyrusSearchResultPage page, AbstractTreeViewer viewer) {
		fPage = page;

		this.fViewer = viewer;
	}

	public void dispose() {

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if(newInput != null) {
			if(newInput instanceof PapyrusSearchResult) {
				fResult = (AbstractTextSearchResult)newInput;
				initialize();
			}
		} else {
			// forget the previous result, so that the ScopeEntry instances it contains, with all
			// of the ModelSet and ServicesRegistry instances they hang on to (and lots of UML models!)
			// may be garbage-collected
			fResult = AbstractPapyrusQuery.Empty.INSTANCE.getSearchResult();
		}
	}

	public Object[] getElements(Object inputElement) {
		Object[] children = getChildren(inputElement);
		int elementLimit = getElementLimit();
		if(elementLimit != -1 && elementLimit < children.length) {
			Object[] limitedChildren = new Object[elementLimit];
			System.arraycopy(children, 0, limitedChildren, 0, elementLimit);
			return limitedChildren;
		}
		return children;
	}

	private int getElementLimit() {
		return fPage.getElementLimit().intValue();
	}

	/**
	 * Used to clear the content
	 */
	public void clear() {
		initialize();
		fViewer.refresh();
	}

	public void initialize() {

		fChildrenMap = new HashMap<Object, Set<Object>>();

		Set<AbstractResultEntry> realMatches = MatchUtils.getMatches(fResult, true);

		for(AbstractResultEntry resultEntry : realMatches) {
			insert(resultEntry, false);
		}

	}

	protected boolean insertChild(Object parent, Object child) {

		Set<Object> children = fChildrenMap.get(parent);

		if(children == null) {
			children = new HashSet<Object>();
			fChildrenMap.put(parent, children);
		}

		boolean found = false;

		for(Object childInMap : children) {
			if(child instanceof AbstractResultEntry) {
				if(childInMap instanceof AbstractResultEntry) {
					if(((AbstractResultEntry)childInMap).equals((AbstractResultEntry)child)) {

						if((!(child instanceof ResultEntry)) && (childInMap instanceof ResultEntry)) {

							replaceResultEntryByRealResult((AbstractResultEntry)childInMap, (AbstractResultEntry)child);

						}

						found = true;
						break;

					}
				}
			}
		}

		if(!found) {
			children.add(child);
			return true;
		} else {
			return false;
		}

	}

	protected void replaceResultEntryByRealResult(AbstractResultEntry toReplace, AbstractResultEntry replacement) {

		//Must replace ResultEntry in the tree by RealMatch
		for(Object childInMap : fChildrenMap.get(toReplace)) {
			if(childInMap instanceof AbstractResultEntry) {
				((AbstractResultEntry)childInMap).setParent(replacement);
			}
		}

		fChildrenMap.put(replacement, fChildrenMap.get(toReplace));
		((AbstractResultEntry)replacement).setParent(toReplace.getParent());
		fChildrenMap.remove(toReplace);

		for(Object key : fChildrenMap.keySet()) {

			if(fChildrenMap.get(key).contains(toReplace)) {
				fChildrenMap.get(key).remove(toReplace);
				fChildrenMap.get(key).add(replacement);
			}
		}

	}

	protected Object getUpdateParent(Object child) {
		Object parent = getParent(child);

		Object existingParent = null;

		//Try to find if it is already in the childrenMap
		for(Object key : fChildrenMap.keySet()) {
			//It may be the parent
			if(key instanceof AbstractResultEntry) {
				if(((AbstractResultEntry)key).equals(parent)) {
					existingParent = key;
					break;
				}
			}

			//or one of the children
			for(Object childInMap : fChildrenMap.get(key)) {
				if(childInMap instanceof AbstractResultEntry) {
					if(((AbstractResultEntry)childInMap).equals(parent)) {
						existingParent = childInMap;
						break;
					}
				}
			}
		}

		if(existingParent != null) {
			((AbstractResultEntry)child).setParent(existingParent);
			return existingParent;
		} else {
			return parent;
		}
	}


	protected void insert(Object child, boolean refreshViewer) {

		Object parent = getUpdateParent(child);

		while(parent != null) {
			if(insertChild(parent, child)) {
				if(refreshViewer) {
					fViewer.add(parent, child);
				}
			} else {
				if(refreshViewer) {
					fViewer.refresh(parent);
				}
				return;
			}
			child = parent;
			parent = getUpdateParent(child);
		}

		if(insertChild(fResult, child)) {
			if(refreshViewer) {
				fViewer.add(fResult, child);
			}
		}
	}

	protected boolean hasChild(Object parent, Object child) {
		Set<Object> children = fChildrenMap.get(parent);

		if(children != null) {
			for(Object childInMap : children) {
				if(childInMap instanceof AbstractResultEntry) {
					if(child instanceof AbstractResultEntry) {
						if(((AbstractResultEntry)childInMap).equals((AbstractResultEntry)child)) {

							if((!(child instanceof ResultEntry)) && (childInMap instanceof ResultEntry)) {
								replaceResultEntryByRealResult((AbstractResultEntry)childInMap, (AbstractResultEntry)child);
							}

							return true;
						}
					}
				}
			}
		}

		return false;
		//		return children != null && children.contains(child);
	}

	protected void removeFromSiblings(Object element, Object parent) {
		Set<Object> siblings = fChildrenMap.get(parent);
		if(siblings != null) {
			siblings.remove(element);
		}
	}

	public void remove(Object element, boolean refreshViewer) {
		if(hasChildren(element)) {
			if(refreshViewer) {
				fViewer.refresh(element);
			}
		} else {
			fChildrenMap.remove(element);
			Object parent = getUpdateParent(element);
			if(parent != null) {
				removeFromSiblings(element, parent);
				remove(parent, refreshViewer);
			} else {
				removeFromSiblings(element, fResult);
				if(refreshViewer) {
					fViewer.refresh();
				}
			}

		}
	}

	/**
	 * Signal the objects that changed in the content
	 * 
	 * @param objects
	 *        objects that changed
	 */
	public synchronized void elementsChanged(Object[] updatedElements) {

		for(int i = 0; i < updatedElements.length; i++) {

			if(updatedElements[i] instanceof AbstractResultEntry) {
				AbstractResultEntry resultEntry = (AbstractResultEntry)updatedElements[i];
				Set<AbstractResultEntry> matches = MatchUtils.getMatches(fResult, true);

				if(matches.contains(updatedElements[i])) {

					Object parent = getUpdateParent(resultEntry);

					if(hasChild(parent, resultEntry)) {
						fViewer.update(new Object[]{ resultEntry, parent }, null);
					} else {
						insert(resultEntry, true); //or update
					}

				} else {
					remove(resultEntry, true);
				}
			} else {
				if(fResult.getMatchCount(updatedElements[i]) > 0) {
					insert(updatedElements[i], true);
				} else {
					remove(updatedElements[i], true);
				}
			}
		}
	}

	public Object[] getChildren(Object parentElement) {
		Set<Object> children = fChildrenMap.get(parentElement);
		if(children == null)
			return EMPTY_ARR;
		return children.toArray();
	}

	public Object getParent(Object element) {
		if(element instanceof AbstractResultEntry) {
			AbstractResultEntry match = (AbstractResultEntry)element;
			return match.getParent();
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
}
