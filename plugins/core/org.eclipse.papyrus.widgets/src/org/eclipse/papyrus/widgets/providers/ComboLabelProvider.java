package org.eclipse.papyrus.widgets.providers;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;


public class ComboLabelProvider extends LabelProvider {

	private ILabelProvider labelProvider;

	public ComboLabelProvider(IBaseLabelProvider encapsulated) {
		this.labelProvider = (ILabelProvider)encapsulated;
	}

	@Override
	public String getText(Object value) {
		if(value == UnsetObject.instance || value == UnchangedObject.instance) {
			return value.toString();
		}
		return labelProvider.getText(value);
	}

	@Override
	public Image getImage(Object value) {
		if(value == UnsetObject.instance || value == UnchangedObject.instance) {
			return null;
		}
		return labelProvider.getImage(value);
	}
}
