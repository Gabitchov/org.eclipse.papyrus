package org.eclipse.papyrus.widgets.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.jface.viewers.Viewer;


public class HierarchicToFlatContentProvider extends TreeToFlatContentProvider {

	private IHierarchicContentProvider contentProvider;

	public HierarchicToFlatContentProvider(IHierarchicContentProvider provider) {
		super(provider);
		if(!(provider instanceof IStaticContentProvider)) {
			throw new IllegalArgumentException();
		}
		contentProvider = provider;
	}

	@Override
	public void dispose() {
		contentProvider.dispose();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		contentProvider.inputChanged(viewer, oldInput, newInput);
	}

	@Override
	public Object[] getElements() {
		return getElementsList().toArray();
	}

	@Override
	protected Collection<Object> getElementsList() {
		Collection<Object> result = new LinkedHashSet<Object>();
		Set<Object> browsedElements = new HashSet<Object>();

		for(Object root : ((IStaticContentProvider)contentProvider).getElements()) {
			if(exploreBranch(null, root)) {
				if(contentProvider.isValidValue(root)) {
					result.add(getValue(root));
				}
				getElementsList(root, result, browsedElements);
			}
		}

		return result;
	}

	@Override
	protected void getElementsList(Object parent, Collection<Object> result, Set<Object> browsedElements) {
		if(!browsedElements.add(parent)) {
			return;
		}

		for(Object child : contentProvider.getChildren(parent)) {
			Object childValue = getValue(child);
			if(result.contains(childValue)) {
				continue; //Avoid infinite recursion
			}
			if(exploreBranch(parent, child)) {
				if(contentProvider.isValidValue(child)) {
					result.add(childValue);
				}
				getElementsList(child, result, browsedElements);
			}
		}
	}

}
