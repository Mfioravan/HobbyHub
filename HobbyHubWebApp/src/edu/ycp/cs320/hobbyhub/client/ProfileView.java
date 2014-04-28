package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

import edu.ycp.cs320.hobbyhub.server.persist.DatabaseProvider;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class ProfileView extends Composite{
	private AbsolutePanel mainPanel;
	
	public ProfileView(){
		
		mainPanel = new AbsolutePanel();
		

		initWidget(mainPanel);
		mainPanel.setSize("837px", "668px");
		
		//Image image = new Image((String) null);
		//mainPanel.add(image);
		//mainPanel.setSize("800px", "800px");
		
		//Image logo = new Image((String) null);
		//mainPanel.add(logo, 10, 10);
		//logo.setSize("100px", "100px");
		
		Button homeButton = new Button("New button");
		homeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new UserView());
			}
		});
		homeButton.setStyleName("dialogVPanel");
		homeButton.setText("Home");
		mainPanel.add(homeButton, 116, 80);
		
		Button profileButton = new Button("New button");
		profileButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new ProfileView());
			}
		});
		profileButton.setStyleName("dialogVPanel");
		profileButton.setText("My Profile");
		mainPanel.add(profileButton, 182, 80);
		
		Button hobbyButton = new Button("New button");
		hobbyButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.setCurrentView(new HobbyView());
			}
		});
		hobbyButton.setStyleName("dialogVPanel");
		hobbyButton.setText("Hobbies");
		mainPanel.add(hobbyButton, 273, 80);
		
		Button aboutButton = new Button("New button");
		aboutButton.setStyleName("dialogVPanel");
		aboutButton.setText("About Us");
		mainPanel.add(aboutButton, 352, 80);
		
		Label TopBorder = new Label("");
		TopBorder.setStyleName("dialogVPanel");
		mainPanel.add(TopBorder, 0, 110);
		TopBorder.setSize("737px", "0px");
		
		Label sideBorder = new Label("");
		sideBorder.setStyleName("dialogVPanel");
		mainPanel.add(sideBorder, 112, 0);
		sideBorder.setSize("0px", "554px");
		
		Button logOutButton = new Button("New button");
		logOutButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				HobbyHubUI.instance.userID = 0;
				System.out.println("Setting the user id back to " + HobbyHubUI.instance.userID);
				HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		logOutButton.setStyleName("dialogVPanel");
		logOutButton.setText("Log Out");
		mainPanel.add(logOutButton, 662, 80);
		
		Image profilePic = new Image();
		profilePic.setUrl("http://i0.wp.com/pyd.io/wp-content/plugins/buddypress/bp-core/images/mystery-man.jpg");
		mainPanel.add(profilePic, 130, 128);
		profilePic.setSize("100px", "100px");
		
		Label userName = new Label("Username");
		mainPanel.add(userName, 236, 128);
		
		Label userBorder = new Label("");
		userBorder.setStyleName("dialogVPanel");
		mainPanel.add(userBorder, 126, 234);
		userBorder.setSize("611px", "0px");
		
		Label lblAboutMe = new Label("About Me:");
		lblAboutMe.setStyleName("gwt-DialogBox");
		mainPanel.add(lblAboutMe, 130, 248);
		lblAboutMe.setSize("71px", "18px");
		
		Label lblCity = new Label("City:");
		mainPanel.add(lblCity, 140, 272);
		
		Label lblState = new Label("State:");
		mainPanel.add(lblState, 140, 296);
		
		Label lblFullName = new Label("Full Name:");
		mainPanel.add(lblFullName, 140, 320);
		
		Label userCity = new Label("User City");
		mainPanel.add(userCity, 211, 272);
		
		Label userState = new Label("User State");
		mainPanel.add(userState, 211, 296);
		
		Label fullUserName = new Label("User Name");
		mainPanel.add(fullUserName, 209, 320);
		
		Label imageBorder = new Label("");
		imageBorder.setStyleName("dialogVPanel");
		mainPanel.add(imageBorder, 126, 357);
		imageBorder.setSize("611px", "0px");
		
		Label aboutBorder = new Label("");
		aboutBorder.setStyleName("dialogVPanel");
		mainPanel.add(aboutBorder, 362, 242);
		aboutBorder.setSize("0px", "106px");
		
		Label lblMyHobbies = new Label("My Hobbies:");
		lblMyHobbies.setStyleName("gwt-DialogBox");
		mainPanel.add(lblMyHobbies, 380, 248);
		lblMyHobbies.setSize("83px", "18px");
		
		Label lblHobby = new Label("Hobby1");
		mainPanel.add(lblHobby, 390, 272);
		
		Label userImages = new Label("My Images:");
		userImages.setStyleName("gwt-DialogBox");
		mainPanel.add(userImages, 130, 375);
		userImages.setSize("83px", "18px");
		
		Image userImage = new Image();
		userImage.setUrl("http://cdn.maxbuttons.com/wordpress/wp-content/themes/maxbuttonsdotcom/images/placeholder-200x150.png");
		mainPanel.add(userImage, 140, 399);
		userImage.setSize("100px", "100px");
		
		Label welcome = new Label("Welcome:");
		mainPanel.add(welcome, 10, 128);
		
		Label userWelcome = new Label("Username");
		mainPanel.add(userWelcome, 20, 152);
		
		Button messagesButton = new Button("New button");
		messagesButton.setStyleName("dialogVPanel");
		messagesButton.setText("Messages");
		mainPanel.add(messagesButton, 10, 176);
		messagesButton.setSize("83px", "22px");
		
		Button eventButton = new Button("New button");
		eventButton.setText("Events");
		eventButton.setStyleName("dialogVPanel");
		mainPanel.add(eventButton, 10, 214);
		eventButton.setSize("83px", "22px");
		
		Button friendButton = new Button("New button");
		friendButton.setStyleName("dialogVPanel");
		friendButton.setText("Friends");
		mainPanel.add(friendButton, 10, 248);
		friendButton.setSize("83px", "22px");
		
		Button myHobbiesButton = new Button("New button");
		myHobbiesButton.setStyleName("dialogVPanel");
		myHobbiesButton.setText("My Hobbies");
		mainPanel.add(myHobbiesButton, 10, 286);
		
		
	}
}