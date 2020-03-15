package Gtm.actions;

import java.io.BufferedReader;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import Gtm.Country;
import Gtm.GTMTool;
import Gtm.GtmFactory;
import Gtm.GtmPackage;
import Gtm.ServiceBrand;
import Gtm.ServiceBrands;
import Gtm.presentation.GtmEditor;
import Gtm.presentation.GtmEditorPlugin;

public class ImportServiceBrandsAction extends ImportCsvDataAction {


	public ImportServiceBrandsAction(IEditingDomainProvider editingDomainProvider) {
		super("import service brands", editingDomainProvider);
		this.setToolTipText(this.getText());
		setImageDescriptor(GtmUtils.getImageDescriptor("/icons/importBrands.png")); //$NON-NLS-1$
	}

	protected void run (IStructuredSelection structuredSelection) {
		
		GTMTool tool = GtmUtils.getGtmTool();
		
		GtmEditor editor = GtmUtils.getActiveEditor(); 
		
		EditingDomain domain = GtmUtils.getActiveDomain();
		if (domain == null) return;
		
		if (tool == null) {
			MessageBox dialog =  new MessageBox(Display.getDefault().getActiveShell(), SWT.ICON_ERROR | SWT.OK);
			dialog.setText("no data found");
			dialog.open(); 
			return;
		}
		
		Country country = tool.getConversionFromLegacy().getParams().getCountry();
		if (country == null) {
			String message = "the country is missing in the conversion parameter";
			GtmUtils.writeConsoleError(message);
			MessageBox dialog =  new MessageBox(Display.getDefault().getActiveShell(), SWT.ICON_ERROR | SWT.OK);
			dialog.setText("the country is missing in the conversion parameter");
			dialog.open(); 
			return;
		}
		
		BufferedReader br = super.getReader("import carrier codes (.csv)");

		IRunnableWithProgress operation =	new IRunnableWithProgress() {
			// This is the method that gets invoked when the operation runs.

			public void run(IProgressMonitor monitor) {
				
				try {
					
					monitor.beginTask("Import carriers", 250); 
		
					monitor.subTask("Initialize main structure");
					prepareStructure(tool, domain);
					monitor.worked(10);

					monitor.subTask("read service brands");
			    	
			    	ServiceBrands newBrands = GtmFactory.eINSTANCE.createServiceBrands();

			        String st; 
			        boolean isFirstLine = true;
					CompoundCommand command =  new CompoundCommand();
					
					while ((st = br.readLine()) != null) {
						
						ServiceBrand brand = decodeLine(st);
						
						if (!isFirstLine) {
							if (brand != null) {
								newBrands.getServiceBrands().add(brand);	
							}
						} else {
							isFirstLine = false;
						}
					}

			        
			        int added = 0;
			        int updated = 0;

			        
					monitor.subTask("Add service brands");
					for (ServiceBrand newBrand : newBrands.getServiceBrands()) {
				       	
			        	ServiceBrand brand = tool.getCodeLists().getServiceBrands().findServiceBRand(newBrand.getCode());
			        	
			        	if (brand == null) {
			        		Command cmd2 = new AddCommand(domain, tool.getCodeLists().getServiceBrands().getServiceBrands(), newBrand);
			        		command.append(cmd2);
			        		added++;
			        	} else {
			        		Command cmd2 = new SetCommand(domain, brand, GtmPackage.Literals.SERVICE_BRAND__NAME, newBrand.getName());
			                command.append(cmd2);
			        		Command cmd3 = new SetCommand(domain, brand, GtmPackage.Literals.SERVICE_BRAND__ABBREVIATION, newBrand.getAbbreviation());
			                command.append(cmd3);        	
			        		Command cmd4 = new SetCommand(domain, brand, GtmPackage.Literals.SERVICE_BRAND__DESCRIPTION, newBrand.getDescription());
			                command.append(cmd4);   
			                updated++;
			           	}
			        			
			        }
			        
			        if (command != null && !command.isEmpty()) {
			        	domain.getCommandStack().execute(command);
						GtmUtils.writeConsoleInfo("service brands added: (" + Integer.toString(added)+")" );
						GtmUtils.writeConsoleInfo("service brands updated: (" + Integer.toString(updated) + ")" );
			        }	
					monitor.worked(10);
					monitor.done();
					
				} catch (IOException e) {

					return;			
				} finally {
					monitor.done();
				}
			}
		};
		try {
			// This runs the operation, and shows progress.
			editor.disconnectViews();
			new ProgressMonitorDialog(editor.getSite().getShell()).run(true, false, operation);
		} catch (Exception exception) {
			MessageBox dialog =  new MessageBox(Display.getDefault().getActiveShell(), SWT.ICON_ERROR | SWT.OK);
			dialog.setText("carrier file read error");
			dialog.setMessage(exception.getMessage());
			dialog.open(); 
			GtmEditorPlugin.INSTANCE.log(exception);
		} finally {
		editor.reconnectViews();
		}

		
	}


	private ServiceBrand decodeLine(String st) {
		String[] strings = st.split(";");
		
		if (strings.length < 3) return null;
		
		try {
			if (strings[0].length() < 4) {
				ServiceBrand brand = GtmFactory.eINSTANCE.createServiceBrand();
				brand.setCode(Integer.parseInt(strings[0]));
				brand.setAbbreviation(strings[1]);
				brand.setName(strings[2]);
				brand.setDescription(strings[3]);
				return brand;
			}
		} catch (Exception e){
			return null;
		}
		return null;

	}

}
