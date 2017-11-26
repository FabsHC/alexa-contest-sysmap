package com.hypercube.adri.entities;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.util.JodaTime;

@DynamoDBTable(tableName = "ScoreKeeperUserData")
public class Meeting {
	
    private String id;
    private JodaTime date;
    private JodaTime startTime;
    private double durationInHours;
    
    @DynamoDBHashKey(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @DynamoDBHashKey(attributeName = "date")
    public JodaTime getDate() {
		return date;
	}

	public void setDate(JodaTime date) {
		this.date = date;
	}

    @DynamoDBHashKey(attributeName = "startTime")
	public JodaTime getStartTime() {
		return startTime;
	}

	public void setStartTime(JodaTime startTime) {
		this.startTime = startTime;
	}
	
	@DynamoDBHashKey(attributeName = "durationInHours")
	public double getDuration() {
		return durationInHours;
	}

	public void setDuration(double durationInHours) {
		this.durationInHours = durationInHours;
	}

}
