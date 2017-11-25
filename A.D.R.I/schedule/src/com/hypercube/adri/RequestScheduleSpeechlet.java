package com.hypercube.adri;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;

/**
 * 
 * @author Fabio Henrique Chaves - HyperCube
 *
 */
public final class RequestScheduleSpeechlet implements SpeechletV2{
	
	private StringBuilder textOutput;
	private StringBuilder repromptTextOutput;
	private OutputSpeech outputSpeech, repromptOutputSpeech;
	private Reprompt reprompt;

	@Override
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {

		if(textOutput==null)
			textOutput = new StringBuilder();
		
		if(repromptTextOutput==null)
			repromptTextOutput = new StringBuilder();
		
	}

	@Override
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		return newAskResponse();
	}

	@Override
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		
	}
	
	
	
    private SpeechletResponse newAskResponse() {
    	
    	outputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) outputSpeech).setText(textOutput.toString());
    	
        repromptOutputSpeech = new PlainTextOutputSpeech();
        ((PlainTextOutputSpeech) repromptOutputSpeech).setText(repromptTextOutput.toString());
        
    	reprompt = new Reprompt();
        reprompt.setOutputSpeech(repromptOutputSpeech);
    	
        return SpeechletResponse.newAskResponse(outputSpeech, reprompt);
    }
    
    private void clearText(){
    	textOutput = new StringBuilder();
		repromptTextOutput = new StringBuilder();
    }

}
