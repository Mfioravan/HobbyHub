package edu.ycp.cs320.hobbyhub.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Button;

public class AboutView extends Composite{
	
	public AboutView(){
		RootLayoutPanel rootLayoutPanel = RootLayoutPanel.get();
		
		AbsolutePanel absolutePanel_1 = new AbsolutePanel();
		rootLayoutPanel.add(absolutePanel_1);
		rootLayoutPanel.setWidgetTopHeight(absolutePanel_1, 0.0, Unit.PX, 769.0, Unit.PX);
		absolutePanel_1.setSize("900", "1200");
		
		Label label = new Label("");
		label.setStyleName("dialogVPanel");
		absolutePanel_1.add(label, 112, 0);
		label.setSize("0px", "755px");
		
		Label label_2 = new Label("");
		label_2.setStyleName("dialogVPanel");
		absolutePanel_1.add(label_2, 0, 110);
		label_2.setSize("1051px", "0px");
		
		Button button = new Button("New button");
		button.setText("Home");
		button.setStyleName("dialogVPanel");
		absolutePanel_1.add(button, 130, 70);
		button.setSize("58", "32");
		
		Button button_1 = new Button("New button");
		button_1.setText("My Profile");
		button_1.setStyleName("dialogVPanel");
		absolutePanel_1.add(button_1, 196, 70);
		button_1.setSize("83", "32");
		
		Button button_2 = new Button("New button");
		button_2.setText("Hobbies");
		button_2.setStyleName("dialogVPanel");
		absolutePanel_1.add(button_2, 287, 70);
		button_2.setSize("71", "32");
		
		Button button_3 = new Button("New button");
		button_3.setText("About Us");
		button_3.setStyleName("dialogVPanel");
		absolutePanel_1.add(button_3, 366, 70);
		button_3.setSize("78", "32");
		
		Button button_4 = new Button("New button");
		button_4.setText("Log Out");
		button_4.setStyleName("dialogVPanel");
		absolutePanel_1.add(button_4, 679, 75);
		button_4.setSize("70", "32");
		
		Label label_1 = new Label((String) null);
		absolutePanel_1.add(label_1, 170, 298);
		label_1.setSize("65px", "18px");
		
		Label label_3 = new Label((String) null);
		absolutePanel_1.add(label_3, 263, 298);
		label_3.setSize("65px", "18px");
		
		Label label_4 = new Label((String) null);
		absolutePanel_1.add(label_4, 352, 298);
		label_4.setSize("65px", "18px");
		
		Label label_5 = new Label((String) null);
		absolutePanel_1.add(label_5, 428, 298);
		label_5.setSize("65px", "18px");
		
		Button button_5 = new Button("New button");
		button_5.setText("Add Hobby");
		button_5.setStyleName("dialogVPanel");
		absolutePanel_1.add(button_5, 490, 276);
		button_5.setSize("88px", "32px");
		
		Label label_6 = new Label("");
		label_6.setStyleName("Border");
		absolutePanel_1.add(label_6, 162, 149);
		label_6.setSize("422px", "169px");
		
		Label label_7 = new Label("");
		label_7.setStyleName("Border");
		absolutePanel_1.add(label_7, 162, 347);
		label_7.setSize("422px", "169px");
		
		Button button_6 = new Button("New button");
		button_6.setText("Add Hobby");
		button_6.setStyleName("dialogVPanel");
		absolutePanel_1.add(button_6, 490, 474);
		button_6.setSize("88px", "32px");
		
		Label label_8 = new Label((String) null);
		absolutePanel_1.add(label_8, 352, 498);
		label_8.setSize("56px", "18px");
		
		Label label_9 = new Label((String) null);
		absolutePanel_1.add(label_9, 263, 498);
		label_9.setSize("56px", "18px");
		
		Label label_10 = new Label((String) null);
		absolutePanel_1.add(label_10, 170, 498);
		label_10.setSize("56px", "18px");
		
		Label label_11 = new Label((String) null);
		absolutePanel_1.add(label_11, 170, 688);
		label_11.setSize("56px", "18px");
		
		Label label_12 = new Label((String) null);
		absolutePanel_1.add(label_12, 263, 688);
		label_12.setSize("56px", "18px");
		
		Label label_13 = new Label((String) null);
		absolutePanel_1.add(label_13, 352, 688);
		label_13.setSize("56px", "18px");
		
		Button button_7 = new Button("New button");
		button_7.setText("Add Hobby");
		button_7.setStyleName("dialogVPanel");
		absolutePanel_1.add(button_7, 490, 664);
		button_7.setSize("88px", "32px");
		
		Label label_14 = new Label("");
		label_14.setStyleName("Border");
		absolutePanel_1.add(label_14, 162, 537);
		label_14.setSize("422px", "169px");
	}
}
