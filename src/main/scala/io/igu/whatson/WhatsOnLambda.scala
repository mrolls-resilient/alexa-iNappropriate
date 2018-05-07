package io.igu.whatson

import com.amazon.speech.json.SpeechletRequestEnvelope
import com.amazon.speech.speechlet._
import com.typesafe.scalalogging.LazyLogging
import io.circe.Json
import io.igu.meetup.v2.ConciergeClientComponent
import io.igu.whatson.model.AlexaResponse


class WhatsOnLambda extends SpeechletV2 with WhatsOnLambdaComponent with ConciergeClientComponent {
  val conciergeClient: ConciergeClient = new ConciergeClient {}
}

trait WhatsOnLambdaComponent extends LazyLogging with SpeechletV2[Json, AlexaResponse] {
  self: ConciergeClientComponent =>

  override def onIntent(requestEnvelope: SpeechletRequestEnvelope[IntentRequest]): SpeechletResponse = {
    logger.info(s"onIntent: $requestEnvelope")

    ???
  }

  override def onLaunch(requestEnvelope: SpeechletRequestEnvelope[LaunchRequest]): SpeechletResponse = {
    logger.info(s"onLaunch: $requestEnvelope")

    ???
  }

  override def onSessionEnded(requestEnvelope: SpeechletRequestEnvelope[SessionEndedRequest]): Unit = {
    logger.info(s"onSessionEnded: $requestEnvelope")
  }

  override def onSessionStarted(requestEnvelope: SpeechletRequestEnvelope[SessionStartedRequest]): Unit = {
    logger.info(s"onSessionStarted: $requestEnvelope")
  }

}