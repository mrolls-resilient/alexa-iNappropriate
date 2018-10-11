package io.igu.whatson.intents

import com.amazon.speech.speechlet.SpeechletResponse
import io.igu.whatson.{Intent, ResponseSupport}

trait HelloWorldIntentComponent {

  val helloWorldIntent: HelloWorldIntent

  trait HelloWorldIntent {

    def helloWorld = Intent {
      case "HelloWorld"        => getHelloResponse
      case "AMAZON.HelpIntent" => getHelloResponse
    }

    private def getHelloResponse = {
      ResponseSupport.tellResponse("HelloWorld", "Hello World")
    }
  }


}