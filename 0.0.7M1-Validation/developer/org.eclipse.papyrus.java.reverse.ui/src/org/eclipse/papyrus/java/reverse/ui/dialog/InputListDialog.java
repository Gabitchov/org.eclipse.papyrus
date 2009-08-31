/**
 * 
 */
package org.eclipse.papyrus.java.reverse.ui.dialog;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.w3c.dom.ls.LSInput;

/**
 * @author dumoulin
 *
 */
public class InputListDialog {

	/** Message to be show */
	private String message;
	
	/** List of fields to show */
	private List<String> fieldList;
	
    /**
     * Input text widget.
     */
    private Text addToListText;
    
    private org.eclipse.swt.widgets.List listWidget;

	/**
	 * Constructor.
	 * @param msg
	 * @param list
	 */
	public InputListDialog(String msg, List<String> list) {
		this.message = msg;
		this.fieldList = list;
	}
	
	/**
	 * Return the selected list.
	 * @return
	 */
	public String[] getList() 
	{
		return listWidget.getItems();
	}
	
	/**
	 * 
	 * @param parent
	 * @return
	 */
	   public Control createDialogArea(Composite parent) {
	        // create composite
	        Composite composite = parent;
	        // create message
	        if (message != null) {
	            Label label = new Label(composite, SWT.WRAP);
	            label.setText(message);
	            GridData data = new GridData(GridData.GRAB_HORIZONTAL
	                   /* | GridData.GRAB_VERTICAL */ | GridData.HORIZONTAL_ALIGN_FILL
	                    | GridData.VERTICAL_ALIGN_CENTER);
//	            data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
	            label.setLayoutData(data);
	            label.setFont(parent.getFont());
	        }

	        // button
	        createButtonBar(composite);
	        
	        // list
	        listWidget = new org.eclipse.swt.widgets.List(composite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.RESIZE);

	        GridData listData = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_VERTICAL | GridData.VERTICAL_ALIGN_FILL);

	        listData.heightHint = 100;
	        listWidget.setLayoutData(listData);
	        if(fieldList != null)
	        for(String item : fieldList)
	        {
	        	listWidget.add(item);
	        }
	        
//	        applyDialogFont(composite);
	        return composite;
	    }


	/**
	 * Returns the style bits that should be used for the input text field.
	 * Defaults to a single line entry. Subclasses may override.
	 * 
	 * @return the integer style bits that should be used when creating the
	 *         input text
	 * 
	 * @since 3.4
	 */
	protected int getInputTextStyle() {
		return SWT.SINGLE | SWT.BORDER;
	}

	/**
	 * Creates and returns the contents of this dialog's button bar.
	 * <p>
	 * The <code>Dialog</code> implementation of this framework method lays
	 * out a button bar and calls the <code>createButtonsForButtonBar</code>
	 * framework method to populate it. Subclasses may override.
	 * </p>
	 * <p>
	 * The returned control's layout data must be an instance of
	 * <code>GridData</code>.
	 * </p>
	 * 
	 * @param parent
	 *            the parent composite to contain the button bar
	 * @return the button bar control
	 */
	protected Control createButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		// create a layout with spacing and margins appropriate for the font
		// size.
		GridLayout layout = new GridLayout();
		layout.numColumns = 0; // this is incremented by createButton
		layout.makeColumnsEqualWidth = false;
//		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
//		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
//		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
//		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		composite.setLayout(layout);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL
				| GridData.VERTICAL_ALIGN_CENTER);
		composite.setLayoutData(data);
		composite.setFont(parent.getFont());
		
		// Add the buttons to the button bar.
		createButtonsForButtonBar(composite);
		return composite;
	}

	/**
	 * Adds buttons to this dialog's button bar.
	 * <p>
	 * The <code>Dialog</code> implementation of this framework method adds
	 * standard ok and cancel buttons using the <code>createButton</code>
	 * framework method. These standard buttons will be accessible from
	 * <code>getCancelButton</code>, and <code>getOKButton</code>.
	 * Subclasses may override.
	 * </p>
	 * 
	 * @param parent
	 *            the button bar composite
	 */
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		// Create input text
        // input text
		((GridLayout) parent.getLayout()).numColumns++;
        addToListText = new Text(parent, getInputTextStyle());
        setButtonLayoutData(addToListText);
        addToListText.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING 
                | GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL ));

        // Create a Button
		((GridLayout) parent.getLayout()).numColumns++;
		Button button = new Button(parent, SWT.PUSH);
		button.setText("add");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				addPressed();
			}
		});
        setButtonLayoutData(button);
		
        // remove
		((GridLayout) parent.getLayout()).numColumns++;
		button = new Button(parent, SWT.PUSH);
		button.setText("-");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				removedPressed();
			}
		});
        setButtonLayoutData(button);
        
        // up
		((GridLayout) parent.getLayout()).numColumns++;
		button = new Button(parent, SWT.PUSH);
		button.setText("^");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				upPressed();
			}
		});
        setButtonLayoutData(button);
        
        // down
		((GridLayout) parent.getLayout()).numColumns++;
		button = new Button(parent, SWT.PUSH);
		button.setText("v");
		button.setFont(JFaceResources.getDialogFont());
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				downPressed();
			}
		});
        setButtonLayoutData(button);

		
	}

	/**
	 * Called when add button is pressed.
	 */
	protected void addPressed() {
		System.out.println("add pressed " + addToListText.getText());
		String msg = addToListText.getText();
		if(msg.length() == 0)
			return;
		
		msg.trim();
		listWidget.add(msg);
//		listWidget.pack(true);
	}

	protected void upPressed() {
		System.out.println("up pressed");
		int selectionIndex = listWidget.getSelectionIndex();
		
		if(selectionIndex > 0 )
		{
			swapItems(selectionIndex-1, selectionIndex);
			listWidget.setSelection(selectionIndex-1);
		}
	}

	/**
	 * Swap items in the list
	 * @param down
	 * @param up
	 */
	private void swapItems(int down, int up)
	{
		String tmp = listWidget.getItem(down);
		listWidget.setItem(down, listWidget.getItem(up) );
		listWidget.setItem(up, tmp );		
	}

	protected void downPressed() {
		System.out.println("down pressed");
		int selectionIndex = listWidget.getSelectionIndex();
		
		if(selectionIndex < listWidget.getItemCount()-1 )
		{
			swapItems(selectionIndex, selectionIndex+1);
			listWidget.setSelection(selectionIndex+1);
		}
	}


	protected void removedPressed() {
		System.out.println("removed pressed");
		int selectionIndex = listWidget.getSelectionIndex();
		
		String old = listWidget.getItem(selectionIndex);
		listWidget.remove(selectionIndex);
		addToListText.setText(old);
	}


	/**
	 * Set the layout data of the button to a GridData with appropriate heights
	 * and widths.
	 * 
	 * @param button
	 */
	protected void setButtonLayoutData(Control button) {
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
//		int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		Point minSize = button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
//		data.widthHint = Math.max(widthHint, minSize.x);
		data.widthHint = minSize.x;
		button.setLayoutData(data);
	}



}
