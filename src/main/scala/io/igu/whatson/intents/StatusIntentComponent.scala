package io.igu.whatson.intents

import io.igu.whatson.{Intent, ResponseSupport}

trait StatusIntentComponent {

  val statusIntent: StatusIntent

  trait StatusIntent {

    def status = Intent {
      case "Status" => getStatusResponse
    }

    private def getStatusResponse = {
      val speechText = "Everything looks healthy"
      ResponseSupport.tellResponse("Status", speechText)
    }

  }


}

