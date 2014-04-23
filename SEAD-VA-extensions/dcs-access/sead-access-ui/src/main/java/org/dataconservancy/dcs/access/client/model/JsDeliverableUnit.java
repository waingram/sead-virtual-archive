/*
 * Copyright 2012 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dataconservancy.dcs.access.client.model;

import org.dataconservancy.dcs.access.client.Util;
import org.dataconservancy.dcs.access.client.ui.EmailPopupPanel;
import org.dataconservancy.dcs.access.ui.client.model.JsRelation;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

// TODO JSON seems to use metadataRefs and metadataRef...

/**
 * Models a Data Conservancy Deliverable Unit
 */
public final class JsDeliverableUnit
        extends JsEntity{
	
    protected JsDeliverableUnit() {
    }

    public JsArrayString getCollections() {
        return getRefs("collections");
    }
    
    public JsArray<JsCreator> getCreators() {
        return (JsArray<JsCreator>) getArray("dataContributors");
    }
  
    
    @SuppressWarnings("unchecked")
    public JsArray<JsMetadata> getMetadata() {
        return (JsArray<JsMetadata>) getArray("metadata");
    }

    public JsArrayString getMetadataRefs() {
        return getRefs("metadataRefs");
    }

    @SuppressWarnings("unchecked")
    public JsArray<JsRelation> getRelations() {
        return (JsArray<JsRelation>) getArray("relations");
    }

    public JsArrayString getFormerExternalRefs() {
        return getStrings("formerExternalRefs");
    }

    public JsArrayString getParents() {
        return getRefs("parents");
    }
    
    

    public String getSite() {
        return getString("site");
    }
    
    public JsPrimaryDataLocation getPrimaryDataLocation(){
    	return (JsPrimaryDataLocation) getObject("primaryLocation");
    }
    
    public Boolean isDigitalSurrogate() {
        return getBooleanObject("digitalSurrogate");
    }

    public JsCoreMetadata getCoreMd() {
        return (JsCoreMetadata) getObject("coreMd");
    }
    

    public Widget display(CellTree tree) {
        FlowPanel panel = new FlowPanel();

        try{
        	
        
        panel.setStylePrimaryName("Entity");
        Button b = new Button("Download (Email download link)");
        if(!getCoreMd().getRights().equalsIgnoreCase("restricted"))
        	panel.add(b);

        b.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	//pop window
            	//send email
               // Window.open(Application.datastreamURLnoEncoding(getId()), "_blank", "");
                EmailPopupPanel emailPopup = new EmailPopupPanel(getId());
                emailPopup.show();	 
            }
        });
        
      // panel.add(Util.label("Core metadata", "SubSectionHeader"));
     
        try{
       panel.add(getCoreMd().display(getId(),tree));
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        


        /*FlexTable table =
                Util.createTable(
                		"Publication Date:",
                		"Abstract:",
                		"Site:",
                		//"Identifier:",
                        "Entity type:",
                        "Creators:",
                        "Parents:",
                        "Collections:",
                        "Former refs",
                        "Metadata refs:",
                        "Provenance:",
                        "Surrogate:",
                        "Alternate Ids:",
                        "Location:",
                        "Active Version:");*/
        FlexTable table = Util.createTable("");
        panel.add(table);
        
        
        
        if(getPubdate()!=null){
        	if(!getPubdate().isEmpty()){
        		//table.setText(0, 0, "Publication Date:");
        		Util.addRow(table, "Publication Date:");
        		table.setWidget(table.getRowCount()-1, 1, new Label(getPubdate()));
        	}
        }
        
        if(getAbstract()!=null){
        	if(!getAbstract().isEmpty()){
	        	FlowPanel abstractPanel = new FlowPanel();
	        	abstractPanel.add(new Label(getAbstract()));
	        	//table.setText(1, 0, "Abstract:");
	        	Util.addRow(table, "Abstract:");
	        	table.setWidget(table.getRowCount()-1, 1, abstractPanel);
	        }
        }

      /*  if(getSite()!=null){
        	System.out.println("getSite()2"+ getSite());
        	table.setWidget(2, 1, new Label(getSite()));
        }*/
        if(!getSite().isEmpty()){
        	System.out.println("getSite Length:"+getSite().length());
        	//table.setText(2, 0, "Site:");
        	Util.addRow(table, "Site:");
        	table.setWidget(table.getRowCount()-1, 1, new Label(getSite()));
        }
        

        Util.addRow(table, "Entity Type");
        System.out.println("RowCount:" +table.getRowCount());
        table.setText(table.getRowCount()-1, 1, "Collection");
        
        if(getCreators().length()>0){
        	Util.addRow(table, "Creators:");
        	table.setWidget(table.getRowCount()-1, 1, JsCreator.display(getCreators()));
        }
        
        if (getParents().length()>0) {
        	Util.addRow(table, "Parents:");
        	System.out.println("Parents Count:"+getParents().length());
            table.setWidget(table.getRowCount()-1, 1, Util.entityLinks(getParents()));
        }

        if (getCollections().length()>0) {
        	Util.addRow(table, "Collections:");
            table.setWidget(table.getRowCount()-1, 1, Util.entityLinks(getCollections()));
        }
        if(getFormerExternalRefs().length()>0){
        	Util.addRow(table, "Former refs");
        	table.setText(table.getRowCount()-1, 1, toString(getFormerExternalRefs()));
        }
        
        if(getMetadataRefs().length()>0){
        	Util.addRow(table, "Metadata refs");
        	table.setWidget(table.getRowCount()-1, 1, Util.metadataLinks(getMetadataRefs()));
        }
        
        Util.addRow(table, "Surrogate");
        table.setText(table.getRowCount()-1, 1, isDigitalSurrogate() == null ? "Unknown" : ""
                + isDigitalSurrogate());
        
        Panel locationPanel = new FlowPanel();
        if(getPrimaryDataLocation()!=null)
        	locationPanel.add(getPrimaryDataLocation().display());
       
        if(getAlternateIds()!=null){
        	JsArray<JsAlternateId> altIds = getAlternateIds();
        	FlowPanel altIdPanel = new FlowPanel();
        	FlowPanel altLocPanel = new FlowPanel();
        	
        	int doiFlag1 =0;
        	for(int i=0;i<altIds.length();i++){
        		String altIdStr ;
        		altIdStr =altIds.get(i).getIdValue();

        		final String finalLink;
    			if(altIds.get(i).getTypeId().equals("medici")){
    				finalLink = "http://nced.ncsa.illinois.edu/acr/#collection?uri="+altIds.get(i).getIdValue();
    				altIdStr = getCoreMd().getTitle();
    			}
    			else
    				finalLink= altIdStr;
    			
    			Label altIdLabel = Util.label(altIdStr,"Hyperlink");
    			altIdLabel.addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						Window.open(finalLink, "_blank", "");
//						MetadataPopupPanel statusPopupPanel = new MetadataPopupPanel(); 
//						statusPopupPanel.show();
					}
				});
    			
    			if(altIds.get(i).getTypeId().equals("medici")){
    				
    				altLocPanel.add(altIdLabel);
    			}
    			else
    				altIdPanel.add(altIdLabel);
        		
        	}
        	
        	if(getAlternateIds().length()>0){
        		Util.addRow(table, "PIDs");
            	table.setWidget(table.getRowCount()-1, 1, altIdPanel);
        	}
        	
        	Util.addRow(table, "Location");
            table.setWidget(table.getRowCount()-1, 1, altLocPanel);
        	
        }

        if(getDataLocations()!=null){
        	JsArray<JsDataLocation> locs = getDataLocations();
        	for(int i=0;i<locs.length();i++){

        		String location=locs.get(i).getLocation();
        		
        		if(locs.get(i).getName().contains("SDA"))
        			location = "https://www.sdarchive.iu.edu";
        		Image image;
	        	
        		if(locs.get(i).getType().contains("IU"))
	        		image= new Image
	        			("images/IU_Scholarworks.jpg");
	        	else if(locs.get(i).getType().contains("Ideals")){
	        		image= new Image
        			("images/Ideals.png");
	        		location = location.replace("xmlui/", "");
	        	}
	        	else 
	        		image= new Image
        			("images/local.jpg");


                Label locationLabel;
        		
    			final String finalLink = location;
                if(!locs.get(i).getName().contains("SDA")){
                    locationLabel = Util.label(
                            location
                            ,"Hyperlink");
                    locationLabel.addClickHandler(new ClickHandler() {

                        @Override
                        public void onClick(ClickEvent event) {
                            Window.open(finalLink, "_blank", "");

                        }
                    });
                }
                else{
                    locationLabel = new Label();
                    locationLabel.setText(location);
                }
    			
    			FlexTable smallTable = Util.createTable();
    			smallTable.setWidget(0, 0, locationLabel);
	        	
	        	smallTable.setWidget(0, 1,image);
    			locationPanel.add(smallTable);
        	}
        }
        
        Util.addRow(table, "Active Version");
        table.setWidget(table.getRowCount()-1, 1, locationPanel);
        
 
//        if (getMetadata() != null && getMetadata().length() > 0) {
//            panel.add(Util.label("Additional metadata", "SubSectionHeader"));
//            JsMetadata.display(panel, getMetadata());
//        }

        if (getRelations() != null && getRelations().length() > 0) {
            panel.add(Util.label("Relations", "SubSectionHeader"));
            JsRelation.display(panel, getRelations());
        }

        }
        catch(Exception e){
        	e.printStackTrace();
        }
        
        return panel;
    }

    public static void display(Panel panel, JsArray<JsDeliverableUnit> array, CellTree tree) {
        for (int i = 0; i < array.length(); i++) {
        	if (array.get(i) != null) {
                panel.add(array.get(i).display(tree));
            }
        }
    }

    public String summary() {
        return getCoreMd().getTitle();
    }
    
    public interface Resources extends ClientBundle {
		 @Source("org/dataconservancy/dcs/access/client/resources/IU_Scholarworks.jpg")
		  ImageResource IuRepo();
		 @Source("org/dataconservancy/dcs/access/client/resources/Ideals.jpg")
		  ImageResource IdealsRepo();
		 @Source("org/dataconservancy/dcs/access/client/resources/local_dspace.jpg")
		  ImageResource locarlRepo();
	}
}
