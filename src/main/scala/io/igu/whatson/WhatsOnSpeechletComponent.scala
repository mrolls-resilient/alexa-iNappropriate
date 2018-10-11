package io.igu.whatson


import com.amazon.speech.json.SpeechletRequestEnvelope
import com.amazon.speech.speechlet.{IntentRequest, LaunchRequest, SessionEndedRequest, SessionStartedRequest, SpeechletResponse, _}
import com.typesafe.scalalogging.LazyLogging
import io.igu.whatson.intents.{InappropriateIntentComponent, StatusIntentComponent}

trait WhatsOnSpeechletComponent {

  val whatsOnSpeechlet: WhatsOnSpeechlet

  trait WhatsOnSpeechlet extends LazyLogging with SpeechletV2 {
    val intent: Intent

    def onSessionStarted(requestEnvelope: SpeechletRequestEnvelope[SessionStartedRequest]): Unit = {
      logger.info("onSessionStarted requestId={}, sessionId={}", requestEnvelope.getRequest.getRequestId, requestEnvelope.getSession.getSessionId)
      // any initialization logic goes here
    }

    def onLaunch(requestEnvelope: SpeechletRequestEnvelope[LaunchRequest]): SpeechletResponse = {
      logger.info("onLaunch requestId={}, sessionId={}", requestEnvelope.getRequest.getRequestId, requestEnvelope.getSession.getSessionId)
      welcomeResponse
    }

    def onIntent(requestEnvelope: SpeechletRequestEnvelope[IntentRequest]): SpeechletResponse = {
      val request = requestEnvelope.getRequest
      logger.info("onIntent requestId={}, sessionId={}", request.getRequestId, requestEnvelope.getSession.getSessionId)

      intent(requestEnvelope).getOrElse {
        val speechText = "Oh shit something has gone wrong"
        ResponseSupport.tellResponse("Error", speechText)
      }
    }

    def onSessionEnded(requestEnvelope: SpeechletRequestEnvelope[SessionEndedRequest]): Unit = {
      logger.info("onSessionEnded requestId={}, sessionId={}", requestEnvelope.getRequest.getRequestId, requestEnvelope.getSession.getSessionId)
      // any cleanup logic goes here
    }

    private def welcomeResponse = {
      val speechText =
        """Welcome to the resilient plc office conversation appropriateness detector. Please note, use of this app may lead to you being fired.
          |In order to check the appropriateness of a conversation, you could say for example, Alexa, ask if it is inappropriate to say that Scott is an australian wanker. 
          | I then use machine learning to confirm that yes, it is probably inappropriate to say that Scott is an australian wanker, even if it's true.
          |""".stripMargin
      ResponseSupport.tellResponse("HelloWorld", speechText)
    }

  }

}

object WhatsOnSpeechletComponent extends WhatsOnSpeechletComponent with InappropriateIntentComponent with StatusIntentComponent {
  self =>

  override val statusIntent: StatusIntent = new StatusIntent {

  }

  override val inappropriateIntent: InappropriateIntent = new InappropriateIntent {

  }

  override val whatsOnSpeechlet: WhatsOnSpeechlet = new WhatsOnSpeechlet {
    override val intent: Intent = inappropriateIntent.inappropriate
  }


}
