package org.eclipse.papyrus.compare.ui;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;


public class PapyrusStyledLabelProvider extends StyledCellLabelProvider implements ILabelProvider {
	
	PapyrusLabelProvider delegate;
	
	public PapyrusStyledLabelProvider() {
		delegate = new PapyrusLabelProvider();
	}

	public Image getImage(Object element) {
		return delegate.getImage(element);
	}

	public String getText(Object element) {
		return getStyledText(element).getString();
	}

	public void update(ViewerCell cell) {
		StyledString string = getStyledText(cell.getElement());
		cell.setText(string.getString());
		cell.setStyleRanges(string.getStyleRanges());
		cell.setImage(getImage(cell.getElement()));
		super.update(cell);
	}

	private StyledString getStyledText(Object element) {
		StyledString styledString = new StyledString();
		styledString.append(delegate.getText(element));
		styledString.append(' ');
		styledString.append('(', StyledString.QUALIFIER_STYLER);
		styledString.append("bla-bla", StyledString.QUALIFIER_STYLER);
		styledString.append(')', StyledString.QUALIFIER_STYLER);
		return styledString;
	}

}
