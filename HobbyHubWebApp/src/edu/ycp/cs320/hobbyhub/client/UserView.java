package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;


public class UserView extends Composite {
	
	private AbsolutePanel absolutePanel;
	private Button UserHobbiesLink;
	public UserView(){
		
		absolutePanel = new AbsolutePanel();
		//initWidget(absolutePanel);
		RootLayoutPanel rootlayoutpanel = RootLayoutPanel.get();
		rootlayoutpanel.setSize("837px", "668px");
		rootlayoutpanel.add(absolutePanel);
		rootlayoutpanel.setWidgetLeftWidth(absolutePanel, 0.0, Unit.PX, 559.0, Unit.PX);
		rootlayoutpanel.setWidgetTopHeight(absolutePanel, 0.0, Unit.PX, 516.0, Unit.PX);
		absolutePanel.setSize("837px", "668px");
		
		Image Logo = new Image();
		Logo.setUrl("http://www.google.com/images/logo.gif");
		absolutePanel.add(Logo, 10, 10);
		Logo.setSize("100px", "100px");
		

		Button HomeLink = new Button("Home");
		HomeLink.setStyleName("dialogVPanel");
		absolutePanel.add(HomeLink, 116, 87);
		HomeLink.setSize("58", "32");
		//HomeLink.
		HomeLink.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// Takes back to main userview
				// if currentview is user view
				// stay the same, else back to userview
				GWT.log("Switch to home view...");
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new UserView());
			}
		});
		
		Button ProfileLink = new Button("New button");
		ProfileLink.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.log("Switching to Profile View");
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new ProfileView());
			}
		});
		ProfileLink.setStyleName("dialogVPanel");
		ProfileLink.setText("My Profile");
		absolutePanel.add(ProfileLink, 181, 87);
		
		Button HobbyLink = new Button("New button");
		HobbyLink.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				absolutePanel.clear();
				HobbyHubUI.setCurrentView(new HobbyView());
			}
		});
		HobbyLink.setStyleName("dialogVPanel");
		HobbyLink.setText("Hobbies");
		absolutePanel.add(HobbyLink, 271, 87);
		
		
		Button AboutLink = new Button("New button");
		AboutLink.setStyleName("dialogVPanel");
		AboutLink.setText("About Us");
		absolutePanel.add(AboutLink, 346, 87);
		
		Label WelcomeLabel = new Label("Welcome");
		absolutePanel.add(WelcomeLabel, 20, 130);
		
		Label UsernameLabel = new Label("Username");
		absolutePanel.add(UsernameLabel, 30, 154);
		
		Button MessagesLink = new Button("New button");
		MessagesLink.setStyleName("dialogVPanel");
		MessagesLink.setText("Messages");
		absolutePanel.add(MessagesLink, 10, 192);
		MessagesLink.setSize("83px", "22px");
		
		Button EventsLink = new Button("New button");
		EventsLink.setStyleName("dialogVPanel");
		EventsLink.setText("Events");
		absolutePanel.add(EventsLink, 10, 226);
		EventsLink.setSize("83px", "22px");
		
		Button FriendsLink = new Button("New button");
		FriendsLink.setStyleName("dialogVPanel");
		FriendsLink.setText("My Friends");
		absolutePanel.add(FriendsLink, 10, 264);
		FriendsLink.setSize("83px", "22px");
		
		UserHobbiesLink = new Button("New button");
		UserHobbiesLink.setStyleName("dialogVPanel");
		UserHobbiesLink.setText("My Hobbies");
		absolutePanel.add(UserHobbiesLink, 10, 302);	
		
		HTML WelcomeHTML = new HTML("<div id='welcome'style='font-size: 150%;'> Welcome!</div>", true);
		absolutePanel.add(WelcomeHTML, 127, 130);
		
		HTML BodyHTML = new HTML("<div id='welcome-body'style='font-size:110%;'>This is a test to see if it works.</div>", true);
		absolutePanel.add(BodyHTML, 127, 154);
		BodyHTML.setSize("422px", "253px");
		
		Button btnLogOut = new Button("Log Out!");
		btnLogOut.setStyleName("dialogVPanel");
		btnLogOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
			HobbyHubUI.instance.userID = 0;
			System.out.println("Setting the user id back to " + HobbyHubUI.instance.userID);
			absolutePanel.clear();
			HobbyHubUI.setCurrentView(new HomeView());
			}
		});
		absolutePanel.add(btnLogOut, 442, 87);
		btnLogOut.setSize("73px", "22px");
		
		Label label = new Label("");
		label.setStyleName("dialogVPanel");
		absolutePanel.add(label, 0, 116);
		label.setSize("547px", "0px");
		
		Label label_1 = new Label("");
		label_1.setStyleName("dialogVPanel");
		absolutePanel.add(label_1, 109, 0);
		label_1.setSize("0px", "656px");
		
	
	}
}
