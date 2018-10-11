package io.igu.whatson.intents

import io.igu.whatson.{Intent, ResponseSupport}

trait InappropriateIntentComponent {

  val inappropriateIntent: InappropriateIntent

  trait InappropriateIntent {

    def inappropriate = Intent {
      case "Inappropriate" => getStatusResponse
    }

    private def getStatusResponse = {
      val speechText = "Yes... Yes it is"
      ResponseSupport.askResponse("Status", speechText)
    }

  }


}

