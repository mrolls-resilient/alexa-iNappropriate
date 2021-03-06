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
        """Welcome to 'is it inappropriate' detector, a not safe for work detector which should be able to tell you if what you say could get you fired.
          |For example Scott may want to check if what he is about to say will get him fired. He would simply say, 'alexa, is it inappropriate to say Jeremy Corbyn is a half wit idiot who knows nothing about politics'.
          |I would then reply, 'you should be fine, it is the truth after all'
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