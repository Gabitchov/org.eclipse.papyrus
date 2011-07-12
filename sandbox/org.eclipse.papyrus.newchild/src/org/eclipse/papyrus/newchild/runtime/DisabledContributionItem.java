package org.eclipse.papyrus.newchild.runtime;

import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;


public class DisabledContributionItem extends ContributionItem {

	protected String text;

	protected ImageDescriptor image;

	public DisabledContributionItem(String text, ImageDescriptor image, String id) {
		this.text = text;
		this.image = image;
		setId(id);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void fill(Menu parent, int index) {
		MenuItem item = new MenuItem(parent, SWT.CASCADE, index);
		item.setText(text);
		item.setImage(image.createImage());
		item.setEnabled(false);

		item.setMenu(new Menu(item));
	}
}
