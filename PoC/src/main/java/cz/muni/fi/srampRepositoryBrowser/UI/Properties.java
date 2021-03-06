package cz.muni.fi.srampRepositoryBrowser.UI;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/*
 * property class 
 * @author Jan Bouska
 *
 */
class Properties extends Composite {
	
	private Prop prop;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Properties(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		prop = new Prop(this,SWT.NONE);
		prop.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		
		Button addProperty = new Button(this,SWT.NONE);
		addProperty.setText("Add property");
		addProperty.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				prop.addPropertyToParent();
			}
			});
		
	}
	
	public List<PropData> getPropertyList()
	{
		return prop.getData();
	}

	
}


class Property extends Composite{
	private Text nameT;
	private Text valueT;
	

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Property(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		
		Label nameLabel = new Label(this, SWT.NONE);
				
		nameLabel.setText("Name:");
		
		
		Label valueLabel = new Label(this, SWT.NONE);
		valueLabel.setText("Value:");
		
		nameT = new Text(this, SWT.BORDER);
		nameT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		valueT = new Text(this, SWT.BORDER);
		valueT.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}
	
	public String getNameT()
	{
		return nameT.getText();
	}

	public String getValueT()
	{
		return valueT.getText();
	}
}



class Prop extends Composite{

	private List <Property> list;

	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Prop(Composite parent, int style) {
		super(parent, style);
		list = new ArrayList<>();
		setLayout(new GridLayout(1, false));
		
		
		Property pr = new Property(this, SWT.NONE);
		list.add(pr);
		pr.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		
	}

	void addPropertyToParent()
	{	Property pr = new Property(this, SWT.NONE);
		list.add(pr);
		pr.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		
		getShell().layout();
		getShell().pack();
	}
	
	public List<PropData> getData()
	{
		List<PropData> data = new ArrayList<>();
		for(Property p : list)
		{	if(p.getNameT().isEmpty())
		{
			continue;
		}
			PropData d = new PropData(p.getNameT(),p.getValueT());
			data.add(d);
		}
		
		return data;
		
	}
	
}
