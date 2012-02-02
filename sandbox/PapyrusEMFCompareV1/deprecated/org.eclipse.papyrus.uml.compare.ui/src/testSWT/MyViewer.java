package testSWT;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.Text;


public class MyViewer extends Composite {
	private Text text;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MyViewer(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		
		CoolBar coolBar = new CoolBar(this, SWT.FLAT);
		FormData fd_coolBar = new FormData();
		fd_coolBar.bottom = new FormAttachment(0, 173);
		fd_coolBar.right = new FormAttachment(0, 120);
		fd_coolBar.top = new FormAttachment(0, 143);
		fd_coolBar.left = new FormAttachment(0, 10);
		coolBar.setLayoutData(fd_coolBar);
		
		CoolItem coolItem = new CoolItem(coolBar, SWT.NONE);
		
		Button button = new Button(this, SWT.CHECK);
		FormData fd_button = new FormData();
		fd_button.top = new FormAttachment(0, 154);
		fd_button.left = new FormAttachment(0, 22);
		button.setLayoutData(fd_button);
		button.setText("Check Button");
		
		Button btnCheckButton_1 = new Button(this, SWT.CHECK);
		FormData fd_btnCheckButton_1 = new FormData();
		fd_btnCheckButton_1.top = new FormAttachment(0, 10);
		fd_btnCheckButton_1.left = new FormAttachment(button, 0, SWT.LEFT);
		btnCheckButton_1.setLayoutData(fd_btnCheckButton_1);
		btnCheckButton_1.setText("Check Button");
		
		Button btnNewButton = new Button(this, SWT.CHECK);
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(btnCheckButton_1, 27);
		fd_btnNewButton.left = new FormAttachment(button, 0, SWT.LEFT);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("New Button");
		
		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		FormData fd_toolBar = new FormData();
		fd_toolBar.bottom = new FormAttachment(coolBar, -6);
		fd_toolBar.right = new FormAttachment(button, 0, SWT.RIGHT);
		toolBar.setLayoutData(fd_toolBar);
		
		ToolItem tltmNewItem = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem.setText("New Item");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		btnNewButton_1.setLayoutData(new FormData());
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(this, SWT.NONE);
		btnNewButton_2.setLayoutData(new FormData());
		btnNewButton_2.setText("New Button");
		
		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new FormData());

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
