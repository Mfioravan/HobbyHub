package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;

import edu.ycp.cs320.hobbyhub.shared.User;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.ListBox;

public class EditView extends Composite{
	private AbsolutePanel mainPanel;
	private User user;
	
	public EditView(){
		mainPanel = new AbsolutePanel();
		
		RootLayoutPanel rootlayoutpanel = RootLayoutPanel.get();
		rootlayoutpanel.add(mainPanel);
		mainPanel.setSize("837px", "668px");
		
		Label lblHeader = new Label("Edit Profile:");
		lblHeader.setStyleName("Header");
		mainPanel.add(lblHeader, 141, 85);
		
		Label lblFirstName = new Label("First Name:");
		mainPanel.add(lblFirstName, 175, 110);
		
		Label lblLastName = new Label("Last Name:");
		mainPanel.add(lblLastName, 176, 150);
		
		Label lblEmail = new Label("Email:");
		mainPanel.add(lblEmail, 178, 190);
		
		Label lblCity = new Label("City:");
		mainPanel.add(lblCity, 178, 230);
		
		Label lblState = new Label("State:");
		mainPanel.add(lblState, 178, 270);
		
		final TextBox firstNameBox = new TextBox();
		mainPanel.add(firstNameBox, 249, 110);
		
		final TextBox lastNameBox = new TextBox();
		mainPanel.add(lastNameBox, 249, 146);
		
		final TextBox emailBox = new TextBox();
		mainPanel.add(emailBox, 249, 186);
		
		final TextBox cityBox = new TextBox();
		mainPanel.add(cityBox, 249, 226);
		
		final Button saveButton = new Button("New button");
		saveButton.setStyleName("dialogVPanel");
		saveButton.setText("Save Changes");
		mainPanel.add(saveButton, 249, 325);
		
		Button backButton = new Button("New button");
		backButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				mainPanel.clear();
				HobbyHubUI.setCurrentView(new ProfileView());
			}
		});
		backButton.setStyleName("dialogVPanel");
		backButton.setText("Back");
		mainPanel.add(backButton, 249, 363);
		
		final ListBox stateList = new ListBox();
		stateList.addItem("Alabama ");
		stateList.addItem("Alaska ");
		stateList.addItem("Arizona ");
		stateList.addItem("Arkansas ");
		stateList.addItem("California ");
		stateList.addItem("Colorado ");
		stateList.addItem("Connecticut ");
		stateList.addItem("Delaware ");
		stateList.addItem("Florida ");
		stateList.addItem("Georgia ");
		stateList.addItem("Hawaii ");
		stateList.addItem("Idaho ");
		stateList.addItem("Illinois ");
		stateList.addItem("Indiana ");
		stateList.addItem("Iowa ");
		stateList.addItem("Kansas ");
		stateList.addItem("Kentucky ");
		stateList.addItem("Louisiana ");
		stateList.addItem("Maine ");
		stateList.addItem("Maryland ");
		stateList.addItem("Massachusetts ");
		stateList.addItem("Michigan ");
		stateList.addItem("Minnesota ");
		stateList.addItem("Mississippi ");
		stateList.addItem("Missouri ");
		stateList.addItem("Montana ");
		stateList.addItem("Nebraska ");
		stateList.addItem("Nevada ");
		stateList.addItem("New Hampshire ");
		stateList.addItem("New Jersey ");
		stateList.addItem("New Mexico ");
		stateList.addItem("New York ");
		stateList.addItem("North Carolina ");
		stateList.addItem("North Dakota ");
		stateList.addItem("Ohio ");
		stateList.addItem("Oklahoma ");
		stateList.addItem("Oregon ");
		stateList.addItem("Pennsylvania ");
		stateList.addItem("Rhode Island ");
		stateList.addItem("South Carolina ");
		stateList.addItem("South Dakota ");
		stateList.addItem("Tennessee ");
		stateList.addItem("Texas ");
		stateList.addItem("Utah ");
		stateList.addItem("Vermont ");
		stateList.addItem("Virginia ");
		stateList.addItem("Washington ");
		stateList.addItem("West Virginia ");
		stateList.addItem("Wisconsin ");
		stateList.addItem("Wyoming");
		mainPanel.add(stateList, 249, 270);
		
		Label removeLabel = new Label("Remove Hobbies:");
		mainPanel.add(removeLabel, 519, 85);
		
		final ListBox hobbyBox = new ListBox();
		mainPanel.add(hobbyBox, 559, 110);
		hobbyBox.setSize("105px", "22px");
		hobbyBox.setVisibleItemCount(1);
		
		final Button removeButton = new Button("Remove Hobby");
		
		removeButton.setStyleName("dialogVPanel");
		mainPanel.add(removeButton, 569, 138);
		
		int userID = HobbyHubUI.instance.userID;
		RPC.accountManagementService.getIDUser(userID, new AsyncCallback<User>(){
			@Override
			public void onSuccess(User result){
				user = result;
				GWT.log("RPC call successful.");
				GWT.log("User name is: " + user.getUserName());
				
				firstNameBox.setText(user.getFirstName());
				lastNameBox.setText(user.getLastName());
				emailBox.setText(user.getUserEmail());
				cityBox.setText(user.getLocationCity());
				
				//Add hobbies to remove List Box
				for (int i = 0; i < user.getHobbies().size(); i++){
					hobbyBox.addItem(user.getHobbies().get(i).getName());
				}
				
				//Save Changes
				saveButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event){
						RPC.accountManagementService.editAccount(HobbyHubUI.instance.userID, firstNameBox.getText()
								, lastNameBox.getText(), emailBox.getText(), cityBox.getText(), stateList.getItemText(stateList.getSelectedIndex()), new AsyncCallback<Boolean>(){
									@Override
									public void onSuccess(Boolean result) {
										GWT.log("Change successful.");
										mainPanel.clear();
										HobbyHubUI.setCurrentView(new ProfileView());
									}
									public void onFailure(Throwable caught){
										GWT.log("An error occured: " + caught);
									}
							});
					}
			
				});
				
				//Remove Hobbies
				removeButton.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						final String hobbyName = hobbyBox.getItemText(hobbyBox.getSelectedIndex());
						GWT.log(hobbyName + "selected for removal.");
						RPC.accountManagementService.removeHobby(hobbyName, HobbyHubUI.instance.userID, new AsyncCallback<Boolean>(){

							@Override
							public void onFailure(Throwable caught) {
								GWT.log("Error: " + caught.getMessage());
								
							}

							@Override
							public void onSuccess(Boolean result) {
								if (result == true){
									GWT.log("Removal of hobby " + hobbyName + " has succeeded.");
									for(int i = 0; i < user.getHobbies().size(); i++){
										GWT.log("Hobby:" + user.getHobbies().get(i).getName());
									}
									
								} else {
									GWT.log("Removal of hobby " + hobbyName + " has failed.");
								}
								
							}
						});
						hobbyBox.removeItem(hobbyBox.getSelectedIndex());
					}
				});
	}
			public void onFailure(Throwable caught){
				GWT.log("RPC call to get Account failed: " + caught.getMessage());
				
			}
});}
	}
