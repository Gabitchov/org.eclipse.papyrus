package org.eclipse.papyrus.infra.widgets.providers;

import java.util.Map;

import org.eclipse.jface.viewers.LabelProvider;

/**
 * A LabelProvider based on a Map
 * 
 * @author Camille Letavernier
 */
public class MapLabelProvider extends LabelProvider {

	protected final Map<? extends Object, String> objectsToLabels;

	public MapLabelProvider(Map<? extends Object, String> objectsToLabels) {
		this.objectsToLabels = objectsToLabels;
	}

	@Override
	public String getText(Object element) {
		return objectsToLabels.get(element);
	}

}
