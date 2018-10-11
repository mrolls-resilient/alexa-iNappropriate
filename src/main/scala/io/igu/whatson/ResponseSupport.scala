package io.igu.whatson

import com.amazon.speech.speechlet.SpeechletResponse
import com.amazon.speech.ui.{OutputSpeech, PlainTextOutputSpeech, Reprompt, SimpleCard}

trait ResponseSupport {

  private def getSimpleCard(title: String, content: String): SimpleCard = {
    val card = new SimpleCard
    card.setTitle(title)
    card.setContent(content)
    card
  }

  private def getPlainTextOutputSpeech(speechText: String): PlainTextOutputSpeech = {
    val speech = new PlainTextOutputSpeech
    speech.setText(speechText)
    speech
  }

  private def getReprompt(outputSpeech: OutputSpeech): Reprompt = {
    val reprompt = new Reprompt
    reprompt.setOutputSpeech(outputSpeech)
    reprompt
  }

  def askResponse(cardTitle: String, speechText: String): SpeechletResponse = {
    val card = getSimpleCard(cardTitle, speechText)
    val speech = getPlainTextOutputSpeech(speechText)
    val reprompt = getReprompt(speech)
    SpeechletResponse.newAskResponse(speech, reprompt, card)
  }

  def tellResponse(cardTitle: String, speechText: String): SpeechletResponse = {
    val card = getSimpleCard(cardTitle, speechText)
    val speech = getPlainTextOutputSpeech(speechText)

    SpeechletResponse.newTellResponse(speech, card)
  }

}

object ResponseSupport extends ResponseSupport {}